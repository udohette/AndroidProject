package com.example.android.xmlparse;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

interface ResultsCallBack {
    public void onPreExecute();

    public void onPostExecute(ArrayList<HashMap<String, String>> results);
}

public class MainActivity extends AppCompatActivity implements ResultsCallBack {
    placeHolderFragment taskFragment;
    ListView articleListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        articleListView = (ListView) findViewById(R.id.articlesListView);
        if (savedInstanceState == null) {
            taskFragment = new placeHolderFragment();
            getFragmentManager().beginTransaction().add(taskFragment, "MyFragment").commit();

        } else {
            taskFragment = (placeHolderFragment) getFragmentManager().findFragmentByTag("MyFragment");

        }
        taskFragment.startTask();


    }

    @Override
    public void onPreExecute() {

    }

    @Override
    public void onPostExecute(ArrayList<HashMap<String, String>> results) {
        articleListView.setAdapter(new MyAdapter(this, results));

    }

    public static class placeHolderFragment extends Fragment {
        ResultsCallBack callBack;
        TechCrunchTask downloadTask;

        public placeHolderFragment() {

        }

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            callBack = (ResultsCallBack) context;
            if (downloadTask != null) {
                downloadTask.onAttach(callBack);
            }
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            setRetainInstance(true);
        }

        public void startTask() {
            if (downloadTask != null) {
                downloadTask.cancel(true);
            } else {
                downloadTask = new TechCrunchTask(callBack);
                downloadTask.execute();
            }
        }

        @Override
        public void onDetach() {
            super.onDetach();
            callBack = null;
            if (downloadTask != null) {
                downloadTask.onDetach();
            }
        }
    }

    public static class TechCrunchTask extends AsyncTask<Void, Void, ArrayList<HashMap<String, String>>> {
        ResultsCallBack callBack = null;

        public TechCrunchTask(ResultsCallBack callBack) {
            this.callBack = callBack;

        }

        public void onAttach(ResultsCallBack callBack) {
            this.callBack = callBack;

        }

        public void onDetach() {
            callBack = null;

        }

        @Override
        protected void onPreExecute() {
            if (callBack != null) {
                callBack.onPreExecute();
            }

        }

        @Override
        protected ArrayList<HashMap<String, String>> doInBackground(Void... params) {
            String downloadUrl = "https://feeds.skynews.com/feeds/rss/technology.xml";
            ArrayList<HashMap<String, String>> results = new ArrayList<>();
            try {
                URL url = new URL(downloadUrl);
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                InputStream inputStream = connection.getInputStream();
                processXML(inputStream);
            } catch (Exception e) {
                //L.m(e+"");
            }
            return results;
        }

        @Override
        protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
            if (callBack != null) {
                callBack.onPostExecute(result);
            }

        }

        public ArrayList<HashMap<String, String>> processXML(InputStream inputStream) throws Exception {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document xmlDocument = documentBuilder.parse(inputStream);
            Element rootElement = xmlDocument.getDocumentElement();
            // L.m(""+ rootElement.getTagName());
            NodeList itemList = rootElement.getElementsByTagName("item");
            NodeList itemChildren = null;
            Node currentItem = null;
            Node currentChild = null;
            int count = 0;
            ArrayList<HashMap<String, String>> results = new ArrayList<>();
            HashMap<String, String> currentMap = null;
            for (int i = 0; i < itemList.getLength(); i++) {
                currentItem = itemList.item(i);
                itemChildren = currentItem.getChildNodes();
                currentMap = new HashMap<>();

                for (int j = 0; j < itemChildren.getLength(); j++) {
                    currentChild = itemChildren.item(j);
                    if (currentChild.getNodeName().equalsIgnoreCase("title")) {
                        L.m("" + currentChild.getTextContent());
                        currentMap.put("title", currentChild.getTextContent());
                    }
                    if (currentChild.getNodeName().equalsIgnoreCase("pubDate")) {
                        // L.m(""+currentChild.getTextContent());
                        currentMap.put("pubDate", currentChild.getTextContent());
                    }
                    if (currentChild.getNodeName().equalsIgnoreCase("description")) {
                        // L.m(""+currentChild.getTextContent());
                        currentMap.put("description", currentChild.getTextContent());
                    }
                    if (currentChild.getNodeName().equalsIgnoreCase("media:thumbnail url")) {
                        count++;
                        if (count == 2) {
                            //L.m(currentChild.getAttributes().item(0).getTextContent());
                            currentMap.put("imageURL", currentChild.getAttributes().item(0).getTextContent());

                        }


                    }
                    if (currentMap != null && !currentMap.isEmpty()) {
                        results.add(currentMap);
                    }
                }
                count = 0;
            }
            return results;
        }
    }
}

class MyAdapter extends BaseAdapter {
    ArrayList<HashMap<String, String>> dataSource = new ArrayList<>();
    Context context;
    LayoutInflater layoutInflater;

    public MyAdapter(Context context, ArrayList<HashMap<String, String>> dataSource) {
        this.dataSource = dataSource;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {

        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MyHolder holder = null;
        if (row == null) {
            layoutInflater.inflate(R.layout.custom_row, parent, false);
            holder = new MyHolder(row);
            row.setTag(holder);
        } else {
            holder = (MyHolder) row.getTag();
        }
        HashMap<String, String> currentItem = dataSource.get(position);
        holder.articleTitleText.setText(currentItem.get("title"));
        holder.articlePublishDateText.setText(currentItem.get("pubDate"));
        holder.articleImage.setImageURI(Uri.parse(currentItem.get("imageURL")));
        holder.articleDescriptionText.setText(currentItem.get("description"));
        return row;
    }
}

class MyHolder {
    TextView articleTitleText;
    TextView articlePublishDateText;
    ImageView articleImage;
    TextView articleDescriptionText;

    public MyHolder(View view) {
        articleTitleText = (TextView) view.findViewById(R.id.articleTitleText);
        articlePublishDateText = (TextView) view.findViewById(R.id.articlePublishDate);
        articleImage = (ImageView) view.findViewById(R.id.articleImage);
        articleDescriptionText = (TextView) view.findViewById(R.id.articleDescriptionText);

    }
}

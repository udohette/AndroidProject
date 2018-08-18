package com.example.dennis.whatistheweather;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;

import static android.R.attr.description;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    TextView showResult;



    public void findWeather(View view){

        MyTask task = new MyTask();
        try {
            String encodedCityName = URLEncoder.encode(editText.getText().toString(),"UTF-8");
            task.execute("http://api.openweathermap.org/data /2.5/weather?q=" + encodedCityName);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Could not get Weather",Toast.LENGTH_LONG).show();
        }

        Log.i("city name",editText.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.weather_button);
        editText = (EditText)findViewById(R.id.edit_text);
        showResult = (TextView)findViewById(R.id.display_result);

    }
    public  class  MyTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url= new URL(params[0]);
                urlConnection = (HttpURLConnection)url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader  inputStreamReader = new InputStreamReader(inputStream);
                int data = inputStreamReader.read();
                while (data != -1){
                    char current = (char) data;
                    result += current;
                    data = inputStreamReader.read();
                }
                return result;

            } catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {

                Toast.makeText(getApplicationContext(),"Could not get Weather",Toast.LENGTH_LONG).show();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            JSONObject jsonObject = new JSONObject();
            try {
                String message = "";
                String weatherInfo = jsonObject.getString("weather");
                Log.i("Weather Content", weatherInfo);

                JSONArray jsonArray = new JSONArray(weatherInfo);
                for (int i = 0; i<jsonArray.length(); i++){
                    JSONObject jsonPart = jsonArray.getJSONObject(i);
                    String main = "";
                    String description = "";
                    main = jsonPart.getString("main");
                    description =  jsonPart.getString("description");
                    if (main != "" && description != ""){
                        message += main + ": "+ description + "\r\n";
                    }
                }
                if (message != ""){
                    showResult.setText(message);
                }else {
                    Toast.makeText(getApplicationContext(),"Could not get Weather",Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {

                Toast.makeText(getApplicationContext(),"Could not get Weather",Toast.LENGTH_LONG).show();
            }
        }
    }

}

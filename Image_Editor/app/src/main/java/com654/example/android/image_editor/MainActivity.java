package com654.example.android.image_editor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1;
    private int PICK_IMAGE_REQUEST = 1;

    Bitmap originalBitMap, image;
    ImageView img_view;
    EditText ed_sample;
    ImageButton imageButton;

    Paint paint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent1 = new Intent();
        // Show only images, no videos or anything else
        intent1.setType("image/*");
        intent1.setAction(Intent.ACTION_GET_CONTENT);
        // Always show the chooser (if there are multiple options available)
        startActivityForResult(Intent.createChooser(intent1, "Choose File"), PICK_IMAGE_REQUEST);


        ImageButton imageButton = (ImageButton) findViewById(R.id.img_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQUEST);
            }
        });
        //Image View Object;
        img_view = (ImageView) findViewById(R.id.img_view);
        //to get Screen width and Height;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        //dimensions x,y of device to create a scaled bitmap having similar dimensions to screen size
        int height1 = displayMetrics.heightPixels;
        int width1 = displayMetrics.widthPixels;
        //paint object to define paint properties
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        paint.setTextSize(25);
        //Loading BitMap from Drawable;
        originalBitMap = BitmapFactory.decodeResource(getResources(), R.drawable.direction_jpg);
        //Scaling of BitMap;
        originalBitMap = Bitmap.createScaledBitmap(originalBitMap, width1, height1, false);
        //creating anoter copy of bitmap to be used for editing
        image = originalBitMap.copy(Bitmap.Config.RGB_565, true);
        ed_sample = (EditText) findViewById(R.id.ed_txt);
        Button btn_save_image = (Button) findViewById(R.id.btn_save_image);
        Button btn_clr_all = (Button) findViewById(R.id.btn_clr_all);


        btn_clr_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Auto-generated method stub
                //loading original bitmap again (undoing all editing)
                image = originalBitMap.copy(Bitmap.Config.RGB_565, true);
                img_view.setImageBitmap(image);

            }
        });
        btn_save_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                //function save image is called with bitmap image as parameter
                saveImage(image);
            }
        });
        img_view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                // TODO Auto-generated method stub
                String User_txt = ed_sample.getText().toString();
                //getting x,y co ordinates on screen touch
                float src_x = event.getRawX();
                float scr_y = event.getRawY();
                //function called to perform drawing
                CreateImage(src_x, scr_y, User_txt);
                return true;
            }
        });
    }

    void saveImage(Bitmap img) {
        String RootDir = Environment.getExternalStorageDirectory() + File.separator + "txt_imgs";
        File myDir = new File(RootDir);
        myDir.mkdir();
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-" + n + ".jpg";
        File file = new File(myDir, fname);
        if (file.exists()) file.delete();
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            img.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception exeception) {
            exeception.printStackTrace();
        }
        Toast.makeText(MainActivity.this, "Image Saved To 'txt_imgs' folder", Toast.LENGTH_LONG).show();

    }

    public Bitmap CreateImage(float scr_x, float scr_y, String user_text) {
        //canvas object with bitmap image as constructor
        Canvas canvas = new Canvas(image);
        int viewTop = getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
        //removing title bar hight
        scr_y = scr_y - viewTop;
        //function to draw text on image. you can try more drawing functions like oval,point,rect,etc...
        canvas.drawText("" + user_text, scr_x, scr_y, paint);
        img_view.setImageBitmap(image);
        return image;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && requestCode == Activity.RESULT_OK && requestCode == PICK_IMAGE_REQUEST
                && data != null && data.getData() != null) {
            Uri uri = data.getData();
            try {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imageButton.setImageBitmap(bitmap);
                Bitmap bitmap1 = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                // Log.d(TAG, String.valueOf(bitmap));
                ImageButton imageButton1 = (ImageButton)findViewById(R.id.library_F);
                imageButton1.setImageBitmap(bitmap1);
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

}
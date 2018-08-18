package com.example.dennis.currecnyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{


    class Number {
        int number;

        public boolean isSquare() {
            double sauareRoot = Math.sqrt(number);
            if (sauareRoot == Math.floor(sauareRoot)) {
                return true;
            } else {
                return false;
            }
        }


        public boolean isTriangular() {
            int x = 1;
            int triangularNumber = 1;
            while (triangularNumber < number) {
                x++;
                triangularNumber = triangularNumber + x;
            }
            if (triangularNumber == number) {
                return true;
            } else {
                return false;
            }

        }
    }


    public void testButton(View v) {
        String message = "";
        EditText editText = (EditText) findViewById(R.id.editText3);
        if (editText.getText().toString().isEmpty()){
           Toast.makeText(MainActivity.this,"Please Enter a number",Toast.LENGTH_SHORT).show();
        }else {
            Log.i("Testing App", editText.getText().toString());
            Number n = new Number();
            n.number = Integer.parseInt(editText.getText().toString());
            if (n.isSquare()) {
                if (n.isTriangular()) {
                    message = n.number + "  is both triangular and Square";
                } else {
                    message = n.number + " is Square, but  not Triangular";
                }

            } else {
                if (n.isTriangular()) {
                    message = n.number + "  is Triangular, but not Square";
                } else {
                    message = n.number + " is Neither Square or Triangular";
                }
            }
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}

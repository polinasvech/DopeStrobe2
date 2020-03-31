package com.example.dopestrobe2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener
{
    private static final String TAG = "MainActivity";

    Button btnColor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnColor = (Button) findViewById(R.id.btnColor);
        btnColor.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, ColorActivity.class);
        startActivityForResult(intent, 1);
    }

    @SuppressLint("ResourceAsColor")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        btnColor = (Button) findViewById(R.id.btnColor);
        if (data == null) {return;}
        int back = data.getIntExtra("back", 0);
        if (back == 0) {
            btnColor.setBackgroundResource(R.drawable.home);
            btnColor.setTextColor(R.color.white);
        }
        else if (back == 1) {
            btnColor.setBackgroundResource(R.drawable.red);
            btnColor.setTextColor(R.color.red);
        }
        else if (back == 2) {
            btnColor.setBackgroundResource(R.drawable.orange);
            btnColor.setTextColor(R.color.orange);
        }
        else if (back == 3) {
            btnColor.setBackgroundResource(R.drawable.yellow);
            btnColor.setTextColor(R.color.yellow);
        }
        else if (back == 4) {
            btnColor.setBackgroundResource(R.drawable.green);
            btnColor.setTextColor(R.color.green);
        }
        else if (back == 5) {
            btnColor.setBackgroundResource(R.drawable.lightblue);
            btnColor.setTextColor(R.color.lightblue);
        }
        else if (back == 6) {
            btnColor.setBackgroundResource(R.drawable.blue);
            btnColor.setTextColor(R.color.blue);
        }
        else if (back == 7) {
            btnColor.setBackgroundResource(R.drawable.purple);
            btnColor.setTextColor(R.color.purple);
        }
    }

//    public void onFlashLightClick(View view) {
//        Intent intent = new Intent(MainActivity.this, FlashLightActivity.class);
//        startActivity(intent);
//    }

}

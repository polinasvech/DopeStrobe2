package com.example.dopestrobe2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ColorActivity extends Activity
{
    private static final String TAG = "ColorActivity";
    Button btnRed;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
    }

    public void onRed(View v) {
        onColor(1);
    }

    public void onOrange(View view) {
        onColor(2);
    }

    public void onYellow(View view) {
        onColor(3);
    }

    public void onGreen(View view) {
        onColor(4);
    }

    public void onLightBlue(View view) {
        onColor(5);
    }

    public void onBlue(View view) {
        onColor(6);
    }

    public void onPurple(View view) {
        onColor(7);
    }

    public void onBack(View view) {
        onColor(0);
    }

    public void onColor(int back_id) {
        Intent intent = new Intent();
        intent.putExtra("back", back_id);
        setResult(RESULT_OK, intent);
        finish();
    }
}

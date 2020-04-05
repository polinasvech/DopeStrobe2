package com.example.dopestrobe2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";

    int back_id = 0;
    Button btnColor;
    Button btnLed;
    boolean isLed = false;

    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        boolean settingsCanWrite = Settings.System.canWrite(context);
        if(!settingsCanWrite) {
            // If do not have write settings permission then open the Can modify system settings panel.
            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
            startActivity(intent);
        }
    }

    public void onColor(View v) {
        Intent intent = new Intent(this, ColorActivity.class);
        startActivityForResult(intent, 1);
    }

    public void onStart(View v) {
        Intent intent = new Intent(this, ScreenActivity.class);
        intent.putExtra("back", back_id);
        startActivityForResult(intent, 1);
    }

    @SuppressLint("ResourceAsColor")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        btnColor = (Button) findViewById(R.id.btnColor);
        if (data == null) {
            return;
        }
        back_id = data.getIntExtra("back", 0);
        changeColorButton(back_id);
    }

    public void changeColorButton (int back_id) {
        int[] backgrounds = {R.drawable.home, R.drawable.red, R.drawable.orange,
                R.drawable.yellow, R.drawable.green, R.drawable.lightblue,
                R.drawable.blue, R.drawable.purple};
        btnColor.setBackgroundResource(backgrounds[back_id]);
        if (back_id == 0) { btnColor.setText(R.string.plus); }
        else { btnColor.setText(null); }
    }

    public void onLed(View view) {
        btnLed = (Button) findViewById(R.id.btnLed);
        if(!isLed) {
            btnLed.setBackgroundColor(getResources().getColor(R.color.white));
            btnLed.setTextColor(getResources().getColor(R.color.black));
            isLed = true;
        }
        else {
            btnLed.setBackground(getResources().getDrawable(R.drawable.led_shape));
            btnLed.setTextColor(getResources().getColor(R.color.white));
            isLed = false;
        }
    }

//    public void onFlashLightClick(View view) {
//        Intent intent = new Intent(MainActivity.this, FlashLightActivity.class);
//        startActivity(intent);
//    }

}

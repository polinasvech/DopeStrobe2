package com.example.dopestrobe2;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;


public class ScreenActivity extends AppCompatActivity {

    TextView txtFreq;
    SeekBar sbScreenFreq;
    TextView txtBright;
    SeekBar sbScreenBright;
    ConstraintLayout mConstraintLayout;
    Thread t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        mConstraintLayout = findViewById(R.id.constraintLayout);
        sbScreenFreq = findViewById(R.id.sbScreenFreq);
        txtFreq = findViewById(R.id.txtFreq);
        sbScreenBright = findViewById(R.id.sbScreenBright);
        txtBright = findViewById(R.id.txtBright);

        Intent intent = getIntent();
        final int back_id = intent.getIntExtra("back", 0);
        changeBackgroundColor(back_id);

        sbScreenFreq.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtFreq.setText(String.valueOf(progress));
                if(progress > 0) {
                    try {
                        startStrobe(progress, back_id);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  }
        });

        sbScreenBright.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtBright.setText(String.valueOf(progress));
                setBrightness(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  }
        });

    }

    private void changeBackgroundColor (int back_id) {
        int[] colors = {R.color.black, R.color.red, R.color.orange,
            R.color.yellow, R.color.green, R.color.lightblue,
                R.color.blue, R.color.purple};
        mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, colors[back_id]));
    }

    private void setBrightness(int brightness) {
        ContentResolver contentResolver = getApplicationContext().getContentResolver();
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, brightness);
    }
    private int getBrightness() {
        int brightness = 100;
        try {
            ContentResolver contentResolver = getApplicationContext().getContentResolver();
            brightness = Settings.System.getInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return brightness;
    }

    private void startStrobe (int freq, int back_id) throws InterruptedException {
        int[] colors = {0xff000000, 0xfffe0000, 0xffff8601, 0xfffefe02, 0xff2ffb06, 0xff07ffff, 0xff1502fe, 0xffea04fd};
        ObjectAnimator colorFade = ObjectAnimator.ofObject(mConstraintLayout,
                "backgroundColor",
                new ArgbEvaluator(),
                0xff000000,
                colors[back_id]);
        colorFade.setDuration(freq/2);
        colorFade.setRepeatCount(ValueAnimator.INFINITE);
        colorFade.setRepeatMode(ValueAnimator.REVERSE);
        colorFade.start();
    }
}
package com.example.dopestrobe2;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class sbLedFragment extends Fragment {

    TextView txtFreq;
    SeekBar sbFreq;
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sb_led, parent, false);

        sbFreq = view.findViewById(R.id.sbFreq);
        txtFreq = view.findViewById(R.id.txtFreq);

        txtFreq.setText(getString(R.string.ms, sbFreq.getProgress()));

        sbFreq.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String freq =  getString(R.string.ms, progress);
                txtFreq.setText(freq);
//                if(progress > 0) {
//                    try {
//                        startStrobe(progress, back_id);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  }
        });

        return view;
    }
}
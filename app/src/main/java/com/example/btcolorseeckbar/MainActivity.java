package com.example.btcolorseeckbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    TextView mTvHex,mTvRBG;
    SeekBar mSkB,mSkR,mSkA,mSkG;
    ImageView imageview;
    int mRed,mGreen,mBlue,mAlpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRed = mAlpha = mBlue = mGreen = 0;

        imageview = findViewById(R.id.imageView);
        mTvHex = findViewById(R.id.textViewHex);
        mTvRBG = findViewById(R.id.textViewRGB);
        mSkA = findViewById(R.id.seekbarAlpha);
        mSkB = findViewById(R.id.seekbarBlue);
        mSkG = findViewById(R.id.seekbarGreen);
        mSkR = findViewById(R.id.seekbarRed);

        mSkA.setMax(255);
        mSkR.setMax(255);
        mSkG.setMax(255);
        mSkB.setMax(255);


        mSkA.setOnSeekBarChangeListener(this);
        mSkR.setOnSeekBarChangeListener(this);
        mSkG.setOnSeekBarChangeListener(this);
        mSkB.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()){
            case R.id.seekbarAlpha:
                mAlpha = i;
                break;
            case R.id.seekbarRed:
                mRed = i;
                break;
            case R.id.seekbarGreen:
                mGreen = i;
                break;
            case R.id.seekbarBlue:
                mBlue = i;
                break;
        }
        imageview.setBackgroundColor(Color.argb(mAlpha,mRed,mGreen,mBlue));
        mTvRBG.setText(String.format("RBG %d %d %d %d ",mAlpha,mRed,mGreen,mBlue));
        mTvHex.setText(Integer.toHexString(Color.argb(mAlpha,mRed,mGreen,mBlue)));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
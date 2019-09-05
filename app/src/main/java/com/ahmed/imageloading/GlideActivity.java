package com.ahmed.imageloading;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class GlideActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    Button btnDrawable , btnUrl , btnGif , btnError , btnPlaceholder , btnOverride ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        initView();
    }

    private void initView() {
        imageView = findViewById(R.id.imageView);
        btnDrawable = findViewById(R.id.btnDrawable);
        btnUrl = findViewById(R.id.btnUrl);
        btnGif = findViewById(R.id.btnGif);
        btnError = findViewById(R.id.btnError);
        btnPlaceholder = findViewById(R.id.btnPlaceholder);

        btnDrawable.setOnClickListener(this);
        btnUrl.setOnClickListener(this);
        btnGif.setOnClickListener(this);
        btnError.setOnClickListener(this);
        btnPlaceholder.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDrawable:
                Glide.with(this).load(R.drawable.image).into(imageView);
                break;

            case R.id.btnUrl:
                Glide.with(this).load("https://s3.amazonaws.com/user-content.stoplight.io/8987/1541019969018").into(imageView);
                break;

            case R.id.btnGif:
                Glide.with(this).load(R.drawable.android_gif).into(imageView);
                break;

            case R.id.btnError:
                Glide.with(this).load("http://goo.gl/gEgYUdaaa").centerCrop().placeholder(R.drawable.placeholder).error(R.drawable.error).into(imageView);
                break;

            case R.id.btnPlaceholder:
                Glide.with(this).load("https://crackberry.com/sites/crackberry.com/files/topic_images/2013/ANDROID.png").centerCrop()
                        .placeholder(R.drawable.placeholder).error(R.drawable.error).into(imageView);
                break;
        }
    }



}

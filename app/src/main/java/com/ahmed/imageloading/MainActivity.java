package com.ahmed.imageloading;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void picasso(View view) {
        startActivity(new Intent(this , PicassoActivity.class));
    }

    public void glide(View view) {
        startActivity(new Intent(this , GlideActivity.class));
    }
}

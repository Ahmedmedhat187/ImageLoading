package com.ahmed.imageloading;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class PicassoActivity extends AppCompatActivity implements View.OnClickListener{

    int i = 0;
    ImageView imageView;
    Button btnDrawableImage, btnUrlImage, btnErrorImage, btnCallBackDone, btnCallBackError, btnResizeImage, btnRotateImage, btnScaleImage, btnTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

        initView();
    }

    private void initView() {
        imageView =  findViewById(R.id.imageView);
        btnDrawableImage = findViewById(R.id.btnDrawable);
        btnUrlImage =  findViewById(R.id.btnUrl);
        btnCallBackDone =  findViewById(R.id.btnGif);
        btnErrorImage =  findViewById(R.id.btnError);
        btnCallBackError =  findViewById(R.id.btnPlaceholder);
        btnResizeImage = findViewById(R.id.btnResize);
        btnRotateImage =  findViewById(R.id.btnRotate);
        btnScaleImage = findViewById(R.id.btnScale);
        btnTarget =  findViewById(R.id.btnTarget);

        btnDrawableImage.setOnClickListener(this);
        btnCallBackDone.setOnClickListener(this);
        btnUrlImage.setOnClickListener(this);
        btnCallBackError.setOnClickListener(this);
        btnResizeImage.setOnClickListener(this);
        btnErrorImage.setOnClickListener(this);
        btnRotateImage.setOnClickListener(this);
        btnScaleImage.setOnClickListener(this);
        btnTarget.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDrawable:
                Picasso.get().load(R.drawable.image).into(imageView);
                break;
            case R.id.btnUrl:
                Picasso.get().load("https://crackberry.com/sites/crackberry.com/files/topic_images/2013/ANDROID.png").placeholder(R.drawable.placeholder).into(imageView);
                break;
            case R.id.btnError:
                Picasso.get().load("www.journaldev.com").placeholder(R.drawable.placeholder).error(R.drawable.error).into(imageView);
                break;

            case R.id.btnPlaceholder:
                Picasso.get().load("www.journaldev.com").error(R.drawable.error).into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("TAG", "onSuccess");
                    }
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getApplicationContext(), "An error occurred " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btnGif:
                Picasso.get().load("https://cdn.pixabay.com/photo/2016/09/25/15/11/android-1693894_960_720.jpg").error(R.drawable.error).into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getApplicationContext(), "Done Successfully....", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getApplicationContext(), "An error occurred " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btnResize:
                Picasso.get().load(R.drawable.image).resize(200, 200).into(imageView);
                break;
            case R.id.btnRotate:
                Picasso.get().load(R.drawable.image).rotate(90f).into(imageView);
                break;
            case R.id.btnScale:
                if (i == 3)
                    i = 0;
                else {
                    if (i == 0) {
                        Picasso.get().load(R.drawable.image).fit().into(imageView);
                        Toast.makeText(getApplicationContext(), "Fit", Toast.LENGTH_SHORT).show();
                    } else if (i == 1) {
                        Picasso.get().load(R.drawable.image).resize(200, 200).centerCrop().into(imageView);
                        Toast.makeText(getApplicationContext(), "Center Crop", Toast.LENGTH_SHORT).show();
                    } else if (i == 2) {
                        Picasso.get().load(R.drawable.image).resize(300, 300).centerInside().into(imageView);
                        Toast.makeText(getApplicationContext(), "Center Inside", Toast.LENGTH_SHORT).show();
                    }
                    i++;
                }
                break;
            case R.id.btnTarget:
                Picasso.get().load("http://cdn.journaldev.com/wp-content/uploads/2017/01/android-constraint-layout-sdk-tool-install.png").placeholder(R.drawable.placeholder).error(R.drawable.error).into(target);
                break;
        }
    }

    private Target target = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            imageView.setImageBitmap(bitmap);
        }
        @Override
        public void onBitmapFailed(Exception e, Drawable errorDrawable) {
            imageView.setImageDrawable(errorDrawable);
        }
        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
            imageView.setImageDrawable(placeHolderDrawable);
        }
    };


}

package howiwork.emi.c.imran.howiwork.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import howiwork.emi.c.imran.howiwork.R;

public class SplashActivity extends AppCompatActivity {

    ImageView imageView_background1,imageView_background2,imageView_version;
    TextView textView_version;
    Button button_skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //set background image animation
        imageView_background1 = (ImageView) findViewById(R.id.imageView_background1);
        imageView_background1.setVisibility(View.GONE);
        imageView_background1.setVisibility(View.VISIBLE);
        Animation mAnimation = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, 0f,
                TranslateAnimation.RELATIVE_TO_PARENT, -1f);
        mAnimation.setDuration(10000);
        mAnimation.setRepeatCount(-1);
        mAnimation.setRepeatMode(Animation.INFINITE);
        mAnimation.setInterpolator(new LinearInterpolator());
        imageView_background1.setAnimation(mAnimation);

        imageView_background2 = (ImageView) findViewById(R.id.imageView_background2);
        imageView_background2.setVisibility(View.VISIBLE);
        Animation mAnimation1 = new TranslateAnimation(
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.ABSOLUTE, 0f,
                TranslateAnimation.RELATIVE_TO_SELF, 1f,
                TranslateAnimation.RELATIVE_TO_SELF, 0f);
        mAnimation1.setDuration(10000);
        mAnimation1.setRepeatCount(-1);
        mAnimation1.setRepeatMode(Animation.INFINITE);
        mAnimation1.setInterpolator(new LinearInterpolator());
        imageView_background2.setAnimation(mAnimation1);


        //set version image
        imageView_version = (ImageView) findViewById(R.id.imageView_version);
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                imageView_version.animate().rotationBy(360).withEndAction(this).setDuration(3000).setInterpolator(new LinearInterpolator()).start();
            }
        };
        imageView_version.animate().rotationBy(360).withEndAction(runnable2).setDuration(3000).setInterpolator(new LinearInterpolator()).start();

        //skip click to home activity
        button_skip = (Button)findViewById(R.id.button_skip);
        button_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(ii);
                finish();
            }
        });

        //set current version text
        textView_version = (TextView) findViewById(R.id.text_version);
        try {
            textView_version.setText(""+(getPackageManager().getPackageInfo(getPackageName(), 0)).versionName);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("-> inside version code",""+e);
        }
    }
}

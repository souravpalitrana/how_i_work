package howiwork.emi.c.imran.howiwork;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView_background1,imageView_background2,imageView_version;
    TextView textView_version;
    FrameLayout frame_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        //set current version text
        textView_version = (TextView) findViewById(R.id.text_version);
        try {
            textView_version.setText(""+(getPackageManager().getPackageInfo(getPackageName(), 0)).versionName);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("-> inside version code",""+e);
        }
    }
}

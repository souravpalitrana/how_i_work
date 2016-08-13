package howiwork.emi.c.imran.howiwork;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView_version;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set background image animation
        FrameLayout frame_back = (FrameLayout)findViewById(R.id.frame_back);
        frame_back.addView(new MovingBackGround(this),0);

        //set version image
        imageView= (ImageView) findViewById(R.id.imageView);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                imageView.animate().rotationBy(360).withEndAction(this).setDuration(3000).setInterpolator(new LinearInterpolator()).start();
            }
        };
        imageView.animate().rotationBy(360).withEndAction(runnable).setDuration(3000).setInterpolator(new LinearInterpolator()).start();

        //set current version
        textView_version = (TextView) findViewById(R.id.text_version);
        try {
            textView_version.setText(""+(getPackageManager().getPackageInfo(getPackageName(), 0)).versionName);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("-> inside version code",""+e);
        }
    }
}

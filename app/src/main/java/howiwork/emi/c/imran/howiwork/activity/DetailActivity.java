package howiwork.emi.c.imran.howiwork.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import howiwork.emi.c.imran.howiwork.R;
import howiwork.emi.c.imran.howiwork.framents.FiveFragment;
import howiwork.emi.c.imran.howiwork.framents.FourFragment;
import howiwork.emi.c.imran.howiwork.framents.HomeFragment;
import howiwork.emi.c.imran.howiwork.framents.ThreeFragment;
import howiwork.emi.c.imran.howiwork.framents.TwoFragment;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail);


    }
    @Override
    public void onBackPressed() {
        Intent ii = new Intent(DetailActivity.this,MainActivity.class);
        startActivity(ii);
        finish();
        //super.onBackPressed();
    }
}

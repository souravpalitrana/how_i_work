package howiwork.emi.c.imran.howiwork.framents;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import howiwork.emi.c.imran.howiwork.R;


public class HomeFragment extends Fragment{

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    SliderLayout sliderLayout_image;
    HashMap<String,Integer> file_maps;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        file_maps = new HashMap<String, Integer>();

        //slide home image
        sliderLayout_image = (SliderLayout)rootView.findViewById(R.id.sliderLayout_image);
        file_maps.put("Slide 1",R.drawable.ic_slider1);
        file_maps.put("Slide 2",R.drawable.ic_slider2);
        file_maps.put("Slide 3",R.drawable.ic_slider3);
        file_maps.put("Slide 4", R.drawable.ic_slider4);
        
        slideImageAction(rootView);
        
        return rootView;
    }

    private void slideImageAction(final View rootView) {
        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(rootView.getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {
                            Toast.makeText(rootView.getContext(),slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();

                        }
                    });

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            sliderLayout_image.addSlider(textSliderView);
        }
        sliderLayout_image.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout_image.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout_image.setCustomAnimation(new DescriptionAnimation());
        sliderLayout_image.setDuration(4000);
        sliderLayout_image.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d("Slider Demo", "Page Changed: " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}

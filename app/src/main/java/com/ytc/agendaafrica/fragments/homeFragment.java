package com.ytc.agendaafrica.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.ytc.agendaafrica.R;
import com.ytc.agendaafrica.Services.SyncService;
import com.ytc.agendaafrica.adapters.GoogleCardsNewsAdapter;
import com.ytc.agendaafrica.models.news;
import com.ytc.agendaafrica.util.AlertDialogManager;
import com.ytc.agendaafrica.util.JsonUtils;

import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class homeFragment extends Fragment implements  ViewPagerEx.OnPageChangeListener{


    private SliderLayout mDemoSlider;


    AlertDialogManager alert = new AlertDialogManager();
    private static ProgressBar loadingIndicator;
    private GoogleCardsNewsAdapter mGoogleCardsnewsAdapter;
    List<news> newsdata ;
    static CardView resetcontainer;
    Button resetbutton;
    ListView recyclerView;
    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        mDemoSlider = (SliderLayout) view.findViewById(R.id.slider);

        newsdata = SyncService.getNews();
        Slider();


        recyclerView = (ListView) view.findViewById(R.id.recycler_view_news);
        resetbutton= (Button) view.findViewById(R.id.reset);

        resetcontainer= (CardView) view.findViewById(R.id.resetcontainer);
        loadingIndicator = (ProgressBar) view.findViewById(R.id.newsloadingIndicator);
        loadingIndicator.setMax(100);
        loadingIndicator.setVisibility(View.VISIBLE);


        if(newsdata!=null){

            loadingIndicator.setVisibility(View.INVISIBLE);




        mGoogleCardsnewsAdapter = new GoogleCardsNewsAdapter(getActivity(),newsdata);

        recyclerView.setAdapter(mGoogleCardsnewsAdapter);
        }else {
            if (JsonUtils.isNetworkAvailable(getActivity())) {

                loadingIndicator.setVisibility(View.VISIBLE);
            } else {
//					showToast("No Network Connection!!!");
                alert.showAlertDialog(getActivity(), "Internet Connection Error",
                        "Please connect to working Internet connection", false);
            }

            showToast("No Network Connection!!!");

        }


        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                mGoogleCardsnewsAdapter = new GoogleCardsNewsAdapter(getActivity(),newsdata);

                recyclerView.setAdapter(mGoogleCardsnewsAdapter);
                loadingIndicator.setVisibility(View.INVISIBLE);
                resetcontainer.setVisibility(View.INVISIBLE);


            }
        });

        return view;
    }

    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    private void Slider() {
        //slider


        /**if there is news in the database do this**/


//        HashMap<String,String> url_maps = new HashMap<String, String>();
//        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
//        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
//        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
//        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("globalization",R.drawable.send);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }


        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);


    }



//    @Override
//    public void onSliderClick(BaseSliderView slider) {
//
//        //Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
//        android.support.v4.app.FragmentTransaction t = getSupportFragmentManager().beginTransaction();
//        t.replace(R.id.contentframe, new aboutFragment());
//        t.commit();
//    }


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



    public static void update_by_Sync() {

        try {

            resetcontainer.setVisibility(View.INVISIBLE);

            loadingIndicator.setVisibility(View.INVISIBLE);

        } catch (Exception e) {

        }

    }
}

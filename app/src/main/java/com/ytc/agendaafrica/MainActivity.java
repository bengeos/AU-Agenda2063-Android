package com.ytc.agendaafrica;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;

import com.ytc.agendaafrica.adapters.tabAdapter;
import com.ytc.agendaafrica.tab.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    private tabAdapter mAdapter;
    private String[] tabTitles = { "Home", "Agenda 2063" };
    int Numboftabs = 2;
    private static ViewPager viewPager;

    static CardView resetcontainer;

    SlidingTabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new tabAdapter(getSupportFragmentManager(), tabTitles, Numboftabs);

        // Assigning ViewPager View and setting the adapter
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(mAdapter);


        tabs = (SlidingTabLayout) findViewById(R.id.tab);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.colorAccent);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(viewPager);

    }

    public static void update_by_Sync() {
        viewPager.refreshDrawableState();
    }
}

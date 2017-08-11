package com.ytc.agendaafrica.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.ytc.agendaafrica.MainActivity;

/**
 * Created by Panacea-Soft on 7/15/15.
 * Contact Email : teamps.is.cool@gmail.com
 */

public class Utils {

    private static final Object TAG = "Play Service";
    public static MainActivity activity;
    private static final int REQUEST_GOOGLE_PLAY_SERVICES = 20;


    public static boolean setListViewHeightBasedOnItems(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter != null) {

            int numberOfItems = listAdapter.getCount();

            // Get total height of all items.
            int totalItemsHeight = 0;
            for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                View item = listAdapter.getView(itemPos, null, listView);
                item.measure(0, 0);
                totalItemsHeight += item.getMeasuredHeight();
            }

            // Get total height of all item dividers.
            int totalDividersHeight = listView.getDividerHeight() *
                    (numberOfItems -1);

            // Set list height.
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height =  (totalItemsHeight + totalDividersHeight);
            listView.setLayoutParams(params);
            listView.requestLayout();

            return true;

        } else {
            return false;
        }
    }


    public static boolean isGooglePlayServicesOK(Activity activity) {
        GoogleApiAvailability googleApiAvailability= GoogleApiAvailability.getInstance();
        int result=googleApiAvailability.isGooglePlayServicesAvailable(activity);
        if (result!= ConnectionResult.SUCCESS){
            if(googleApiAvailability.isUserResolvableError(result)){
                googleApiAvailability.getErrorDialog(activity,result,REQUEST_GOOGLE_PLAY_SERVICES)
                        .show();
            }else {

            }
            return false;
        }
        return true;

    }



}

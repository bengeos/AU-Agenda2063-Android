package com.ytc.agendaafrica.util;

import android.app.Activity;

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

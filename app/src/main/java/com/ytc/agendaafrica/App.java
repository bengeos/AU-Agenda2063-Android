package com.ytc.agendaafrica;

import android.app.Application;
import android.content.Intent;

import com.firebase.client.Firebase;
import com.ytc.agendaafrica.Services.SyncService;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by kzone on 6/17/2017.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

        // Newer version of Firebase
        if (!FirebaseApp.getApps(this).isEmpty()) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        }

        startService(new Intent(this, SyncService.class));

    }
}

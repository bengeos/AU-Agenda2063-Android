package com.ytc.agendaafrica.Services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ytc.agendaafrica.fragments.homeFragment;
import com.ytc.agendaafrica.models.news;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bengeos on 1/18/17.
 */

public class SyncService extends Service {
    private static String TAG = "SyncService";
    private FirebaseDatabase firebaseDatabase;
    public static DatabaseReference NewsRef;
    private Context myContext;
    private FirebaseAuth myAuth;

    public static List<news> NewsArray;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myContext = this;
        Log.i(TAG,"Sync Service Created");
        StartSyncing();
    }

    public SyncService() {
        NewsArray = new ArrayList<news>();
        firebaseDatabase = FirebaseDatabase.getInstance();
        NewsRef = firebaseDatabase.getReference("News");

    }


    public static List<news> getNews() {
        return NewsArray;
    }


    public void StartSyncing(){
        myAuth = FirebaseAuth.getInstance();
        FirebaseUser user = myAuth.getCurrentUser();
        if(user !=null){

            SyncNews();
            Log.d(TAG, "Already Signed in User:" + user.getUid());
        }else {
            Log.d(TAG, "Trying to Sign in Again");
            myAuth.signInWithEmailAndPassword("yatcafrica@gmail.com","abc12345678").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        SyncNews();
                        Log.d(TAG, "Successfully Signed in: "+task.getResult().getUser().getUid());
                    }else {
                        Log.d(TAG, "Sign in Failed : "+task.getException());
                    }
                }
            });
        }

    }



    private void SyncNews() {
        NewsRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                try{
//                    Log.d(TAG, "newsArray:-> " + dataSnapshot.getKey());

                news newsarray = dataSnapshot.getValue(news.class);
                    NewsArray.add(newsarray);

//                    for(int i = 0;i<newsArray.size();i++){
//
//                            prayersArray.remove(i);
//
//                    }
//                    if(prayersarray.getPrayertitle() != null && prayersarray.getPrayerdetail() != null && prayersarray.getId() != 0){
//                        prayersArray.add(prayersarray);
                        Log.d(TAG, "Prayer: Added: " + dataSnapshot.getChildren());
                        homeFragment.update_by_Sync();
//                    }else {
//                        Log.i(TAG,"Invalid Format: "+dataSnapshot.getKey());
//                    }
//                }catch (Exception e){

//                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                try{
                    Log.d(TAG, "Album:-> " + dataSnapshot.getKey());
                    news newsarray = dataSnapshot.getValue(news.class);

//                    App.myDatabase.addNewAlbum(album);
                    for(int i = 0;i<NewsArray.size();i++){

                        NewsArray.get(i).setId(newsarray.getId());
                        NewsArray.get(i).setNewsdetail(newsarray.getNewsdetail());
                        NewsArray.get(i).setNewsimg(newsarray.getNewsimg());
                        NewsArray.get(i).setNewstitle(newsarray.getNewstitle());
                        NewsArray.get(i).setLocation(newsarray.getLocation());
                        NewsArray.get(i).setPublisher(newsarray.getPublisher());
                        NewsArray.get(i).setTime(newsarray.getTime());

                    }
                    Log.d(TAG, "Tv: Added: " + dataSnapshot.getChildren());
                }catch (Exception e){

                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                try{
                    Log.d(TAG, "Album Removing " + dataSnapshot.getKey());
                    news newsarray = dataSnapshot.getValue(news.class);
                    for(int i = 0;i<NewsArray.size();i++){

                        NewsArray.remove(i);

                    }
                    Log.d(TAG, "Prayers: Removed: " + newsarray.getId());

                   }catch (Exception e){

                }
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }






}

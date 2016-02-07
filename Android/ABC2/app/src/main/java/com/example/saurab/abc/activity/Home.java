package com.example.saurab.abc.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;

import com.example.saurab.abc.R;
import com.example.saurab.abc.base.activity.BaseActivity;
import com.example.saurab.abc.util.Constants;
import com.example.saurab.abc.util.SharedPreferenceHelper;

/**
 * Created by saurab on 2/6/2016.
 */
public class Home extends BaseActivity
{
    TextView location_text;
    static String city;
    ProgressDialog pd;
    Boolean isLocation = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
       // user_Profile=(TextView)findViewById(R.id.profile);
        location_text=(TextView)findViewById(R.id.location_text);

       /* user_Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {

                     *//* Create an intent that will start the main activity. *//*
                        Intent mainIntent = new Intent(Home.this,
                                User_Profile.class);
                        mainIntent.putExtra("id", "1");

                        //SplashScreen.this.startActivity(mainIntent);
                        startActivity(mainIntent);
                     *//* Finish splash activity so user cant go back to it. *//*
                        Home.this.finish();

                     *//* Apply our splash exit (fade out) and main
                        entry (fade in) animation transitions. *//*
                        overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                    }
                }, 2000);
            }
        });*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        city = SharedPreferenceHelper.getCityName(this);
        if (!city.equals("")) {
            city = city.substring(0, 1).toUpperCase() + city.substring(1).toLowerCase();
            location_text.setText(city);
        } else {
            MainActivity.is_location = getLocation();
            if (MainActivity.is_location != null) {
                double lat = MainActivity.is_location.getLatitude();
                double lang = MainActivity.is_location.getLongitude();
                SharedPreferenceHelper.setLATITUDE("" + lat, this);
                SharedPreferenceHelper.setLONGITUDE("" + lang, this);

                city = getLocationName(lat, lang);
                city = city.substring(0, 1).toUpperCase() + city.substring(1).toLowerCase();
                SharedPreferenceHelper.setCityName(city, this);
                location_text.setText(city);

            } else {
                if (MainActivity.is_location == null && isLocation == false) {
                    MainActivity.is_location = getLocation();
                    pd = new ProgressDialog(Home.this);
                    pd.setMessage(Constants.INFO_DEVICE_LOCATION_INFO);
                    pd.setCancelable(false);
                    pd.show();


                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            pd.dismiss();
                            // finish();
                            // if (Splace.is_location == null) {
                            MainActivity.is_location = getLocation();
                            checkLocation();
                            // }
                        }
                    }, 6000);


                }
            }
        }
    }


    public void checkLocation() {
        //Splace.is_location = getLastKnownLocation();
        if (MainActivity.is_location == null) {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Home.this);

            // Setting Dialog Title
            alertDialog.setTitle(Constants.INFO_GPS_TITLE);

            // Setting Dialog Message
            alertDialog.setMessage(Constants.INFO_GPS_MESSAGE);
            alertDialog.setCancelable(false);

            // Setting Positive "Yes" Button
            alertDialog.setPositiveButton(Constants.STR_YES, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(intent);


                }
            });

            // Setting Negative "NO" Button
            alertDialog.setNegativeButton(Constants.STR_NO, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to invoke NO event

                     gotoClassWithoutfinish(LocationActivity.class);
                }
            });
            // Showing Alert Message
            alertDialog.show();

        }
    }
}

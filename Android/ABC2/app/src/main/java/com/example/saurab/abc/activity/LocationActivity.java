package com.example.saurab.abc.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saurab.abc.R;
import com.example.saurab.abc.adapter.PlaceHolder;
import com.example.saurab.abc.base.activity.BaseActivity;
import com.example.saurab.abc.util.Constants;
import com.example.saurab.abc.util.SharedPreferenceHelper;
import com.example.saurab.abc.util.Utility;
import com.google.android.gms.maps.model.LatLng;
/**
 * Created by saurab on 2/6/2016.
 */
public class LocationActivity extends BaseActivity implements View.OnClickListener {
    AutoCompleteTextView locationText;
    LatLng latLng;
    String addr;
    TextView changelocation_txt;
    //  Button submit_location;
    String location_info;
    ImageView back;
  //  Typeface tf_lt, tf_rg, tf_bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_activity);

       /* Bundle b = getIntent().getExtras();
        if (b != null) {
            location_info = b.getString("CHANGE_CITY");
        }*/
        changelocation_txt = (TextView) findViewById(R.id.header_text);
        back = (ImageView) findViewById(R.id.header_back);
        locationText = (AutoCompleteTextView) findViewById(R.id.et_search_location);
        //  submit_location = (Button) findViewById(R.id.submit_location);
/*

        tf_lt = Typeface.createFromAsset(getAssets(), Constants.FONT_NOVO_LIGHT);

        tf_rg = Typeface.createFromAsset(getAssets(), Constants.FONT_NOVO_REGULAR);

        tf_bd = Typeface.createFromAsset(getAssets(), Constants.FONT_NOVO_SBOLD);
*/

        changelocation_txt.setText("Select Location");

      //  Utility.setFont(this, tf_rg, locationText, changelocation_txt);
        //   Utility.setFont(this, tf_bd, submit_location);

        locationText.setAdapter(new PlaceHolder(this,
                R.layout.places_list_item));
        locationText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addr = (String) parent.getItemAtPosition(position);
                latLng = getLocationFromAddress(addr);

                double lat = latLng.latitude;
                double lng = latLng.longitude;
                String city = getLocationName(lat, lng);

                // SharedPreferenceHelper.setLATITUDE(lat);
                SharedPreferenceHelper.setLATITUDE("" + lat, LocationActivity.this);
                SharedPreferenceHelper.setLONGITUDE("" + lng, LocationActivity.this);
                SharedPreferenceHelper.setCityName(city, LocationActivity.this);

                finish();
            }
        });

        back.setOnClickListener(this);
        // submit_location.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        /*if (v == submit_location) {
            latLng = getLocationFromAddress(addr);

            double lat = latLng.latitude;
            double lng = latLng.longitude;
            String city = getLocationName(lat, lng);

            // SharedPreferenceHelper.setLATITUDE(lat);
            SharedPreferenceHelper.setLATITUDE("" + lat, this);
            SharedPreferenceHelper.setLONGITUDE("" + lng, this);
            SharedPreferenceHelper.setCityName(city, this);

            finish();
            // gotoClass(HomeActivity.class);

        }*/

        if (v == back) {
            finish();
            // gotoClass(HomeActivity.class);

        }
    }

    @Override
    public void onBackPressed() {


        finish();
       /* if(location_info.equals("FROM_HOME")){
            gotoClass(HomeActivity.class);
        }else {
            gotoClass(HomeActivity.class);
        }*/


    }
}


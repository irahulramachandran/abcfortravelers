package com.example.saurab.abc.base.activity;

/**
 * Created by saurab on 2/6/2016.
 */
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Build;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saurab.abc.R;
import com.example.saurab.abc.async.callback.AsyncCallBackInterface;
import com.example.saurab.abc.util.Constants;
import com.example.saurab.abc.util.SharedPreferenceHelper;
import com.example.saurab.abc.vo.HttpResponseVO;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class BaseActivity extends FragmentActivity implements AsyncCallBackInterface{

    public static int STORE_LOCATION = 0;
    public static int MULTI_STORE_LOCATION = 1;
    public static int ORDER_LIST = 2;
    public static int ORDER_DETAILS = 3;
    public static int FEED_BACK = 4;
    public static int THANK_YOU = 5;
    public static int CHANGE_PASSWORD = 6;

    protected Map<String, String> getCommonAuthHeaders(String name,
                                                       String email, String pwd) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(
                Constants.HTTP_HEADER_AUTHORIZATION,
                Constants.HTTP_HEADER_AUTHORIZATION_BASIC_APPEND
                        + " "
                        + BaseActivity.getAuthorizationHeader(name, email, pwd));
        headers.put(Constants.HTTP_HEADER_CONTENT_TYPE,
                Constants.HTTP_HEADER_ACCEPT_VAUE_JSON);
        return headers;
    }

    protected Map<String, String> getCommonAuthHeaders(String usr, String pwd) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(
                Constants.HTTP_HEADER_AUTHORIZATION,
                Constants.HTTP_HEADER_AUTHORIZATION_BASIC_APPEND
                        + " "
                        + BaseActivity.getAuthorizationHeader(usr, pwd));
        headers.put(Constants.HTTP_HEADER_CONTENT_TYPE,
                Constants.HTTP_HEADER_ACCEPT_VAUE_JSON);
        headers.put(Constants.HTTP_HEADER_TOKEN,
                SharedPreferenceHelper.getToken(this));
        return headers;
    }

    protected Map<String, String> getCommonAuthHeaders() {
        Map<String, String> headers = new HashMap<String, String>();
       /* headers.put(
                Constants.HTTP_HEADER_AUTHORIZATION,*/
                /*Constants.HTTP_HEADER_AUTHORIZATION_BASIC_APPEND
                        + Constants.SPACE
                        + BaseActivity.getAuthorizationHeader(
                        SharedPreferenceHelper.getUserEmailAndPassword(
                                this).getEmailID(),
                        SharedPreferenceHelper.getUserEmailAndPassword(
                                this).getPassword()));*/
        headers.put(Constants.HTTP_HEADER_CONTENT_TYPE,
                Constants.HTTP_HEADER_ACCEPT_VAUE_JSON);
        return headers;
    }

    protected void gotoClass(Class<?> classTo) {
        startActivity(new Intent(this, classTo));
        finish();
    }

    protected void gotoClassWithoutfinish(Class<?> classTo) {
        startActivity(new Intent(this, classTo));

    }

   /* @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    protected Point getScreenDimentions() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }*/

    protected void removeFragmentFromStack() {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack(null,
                FragmentManager.POP_BACK_STACK_INCLUSIVE);

    }

    protected void clearCurrentFragment() {
        FragmentManager manager = getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    /*protected void addfragment(Fragment fragment) {
        FragmentTransaction transaction;
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.home_frame_layout_for_fragments, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    protected void addfragment(Fragment fragment, boolean isBackStack) {
        FragmentTransaction transaction;
        transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.replace(R.id.home_frame_layout_for_fragments, fragment);
        if (isBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }*/
    public static Bitmap getFacebookProfilePicture(String userID) {
        Bitmap bitmap = null;
        try {
            URL imageURL = new URL("https://graph.facebook.com/" + userID + "/picture?type=large");
            bitmap = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;

    }

    // hide softkey pad
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }





    // load google plus profile image

    protected class LoadProfileImage extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public LoadProfileImage(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    protected void gotoClass(Intent intent) {
        startActivity(intent);
        finish();
    }

    public static String getAuthorizationHeader(String uname, String email,
                                                String pswd) {
        return Base64.encodeToString((uname + Constants.STR_COLON + email
                + Constants.STR_COLON + pswd).getBytes(), Base64.NO_WRAP);
    }

    public static String getAuthorizationHeader(String uname, String pswd) {
        return Base64
                .encodeToString(
                        (uname + Constants.STR_COLON + pswd).getBytes(),
                        Base64.NO_WRAP);
    }

    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo()
                .isConnectedOrConnecting());
    }

    protected void showMessage(String msg) {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        //  alertDialog.setTitle(Constants.STR_INFO);
        alertDialog.setMessage(msg);
        alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL,
                Constants.STR_CLOSE, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }

    // protected Intent buildIntentForUserNameAndPassword(Class<?> classTo) {
    // Intent intent = new Intent(this, classTo);
    // intent.putExtra("username", SharedPreferenceHelper
    // .getUserNameAndPassword(this).getUserName());
    // intent.putExtra("password", SharedPreferenceHelper
    // .getUserNameAndPassword(this).getUserName());
    // startActivity(intent);
    // finish();
    // return intent;
    //
    // }


    public String getSubLocality(double lattitude, double longitude) {
        Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
        String sublocality = "";
        try {
            List<Address> addresses = gcd.getFromLocation(lattitude, longitude,
                    1);

            if (addresses != null && addresses.size() > 0) {
                Address address = addresses.get(0);
                sublocality = address.getSubLocality(); //+" ,"+addresses.get(0).getSubLocality()
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sublocality;
    }





    protected void showErrorMessage(String msg) {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        // alertDialog.setTitle(Constants.STR_ERROR);
        alertDialog.setMessage(msg);
        alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL,
                Constants.STR_CLOSE, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }


    public String getCompleteAddressString(double LATITUDE, double LONGITUDE) {
        String strAdd = "";
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
            if (addresses != null) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");

                for (int i = 0; i < returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                }
                strAdd = strReturnedAddress.toString();
            } else {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strAdd;
    }

    protected void showErrorMessage(String msg, final Intent intent) {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        //alertDialog.setTitle(Constants.STR_ERROR);
        alertDialog.setMessage(msg);
        alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL,
                Constants.STR_CLOSE, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                        gotoClass(intent);
                    }
                });
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }

    protected void showAlert(String message, String positive, String negative, final Intent neg, final Intent pos) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        // Setting Dialog Title
        alertDialog.setTitle("Kid details...");

        // Setting Dialog Message
        alertDialog.setMessage(message);


        // Setting Positive "Yes" Button
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton(positive, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to invoke NO event
                gotoClass(pos);
                //  Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                // dialog.dismiss();
            }
        });


        alertDialog.setNegativeButton(negative, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to invoke NO event
                //  Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                gotoClass(neg);
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

// getting location from address

    protected LatLng getLocationFromAddress(String strAddress) {

        Geocoder coder = new Geocoder(this);
        List<Address> address = null;
        try {
            address = coder.getFromLocationName(strAddress, 5);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {

        }
        if (address == null) {
            // return null;
        }
        Address location = address.get(0);
        double lat = (double) location.getLatitude();
        double lng = (double) location.getLongitude();

        LatLng dest = new LatLng(lat, lng);
        return dest;

    }


    // for geting location...


    public Location getLocation() {
        Location location = null;
        try {
            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            boolean isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            boolean canGetLocation;

            double latitude;
            double longitude;
            long MIN_TIME_BW_UPDATES = 1000;
            float MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
            if (!isGPSEnabled && !isNetworkEnabled) {
            } else {
                canGetLocation = true;
                if (isNetworkEnabled) {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 3000, 10, new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {

                        }

                        @Override
                        public void onStatusChanged(String provider, int status, Bundle extras) {

                        }

                        @Override
                        public void onProviderEnabled(String provider) {

                        }

                        @Override
                        public void onProviderDisabled(String provider) {

                        }
                    });
                    Log.d("Network", "Network Enabled");
                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                        }
                    }
                }
                if (isGPSEnabled) {
                    if (location == null) {
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 10, new LocationListener() {
                            @Override
                            public void onLocationChanged(Location location) {

                            }

                            @Override
                            public void onStatusChanged(String provider, int status, Bundle extras) {

                            }

                            @Override
                            public void onProviderEnabled(String provider) {

                            }

                            @Override
                            public void onProviderDisabled(String provider) {

                            }
                        });
                        Log.d("GPS", "GPS Enabled");
                        if (locationManager != null) {
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }


    protected void showMessage(String msg, final Intent intent) {
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        //alertDialog.setTitle(Constants.STR_INFO);
        alertDialog.setMessage(msg);
        alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL,
                Constants.STR_CLOSE, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                        gotoClass(intent);
                    }
                });
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }


    public static boolean isNullOrEmpty(EditText s) {
        return s == null || s.getText() == null || s.getText().toString() == null
                || s.getText().toString().trim().equals(Constants.STR_BLANK);
    }

    public static boolean isNullOrEmpty(TextView s) {
        return s == null || s.getText() == null || s.getText().toString() == null
                || s.getText().toString().trim().equals(Constants.STR_BLANK);
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.toString().trim().equals(Constants.STR_BLANK)
                || s.equalsIgnoreCase(Constants.STR_NULL);
    }


    protected void setHeader(String text) {
       // ((TextView) findViewById(R.id.header_text)).setText(text);
    }

    protected void setHeaderBack(Class classTo) {

    }


    protected String getLocationName(double lattitude, double longitude) {

        String cityName = "Not Found";
        Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
        try {

            List<Address> addresses = gcd.getFromLocation(lattitude, longitude,
                    1);

            cityName = addresses.get(0).getLocality();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityName;

    }

    public String getAddressLine(double lattitude, double longitude) {
        Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
        String addressLine = "";
        try {
            List<Address> addresses = gcd.getFromLocation(lattitude, longitude,
                    1);

            if (addresses != null && addresses.size() > 0) {
                Address address = addresses.get(0);
                addressLine = address.getAddressLine(0) + " ," + addresses.get(0).getSubLocality();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return addressLine;
    }

    public String getState(double lattitude, double longitude) {
        Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
        String state = "";
        try {
            List<Address> addresses = gcd.getFromLocation(lattitude, longitude,
                    1);

            if (addresses != null && addresses.size() > 0) {
                Address address = addresses.get(0);
                state = address.getAdminArea();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return state;
    }

    public String getCountryNmae(double lattitude, double longitude) {
        Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
        String country = "";
        try {
            List<Address> addresses = gcd.getFromLocation(lattitude, longitude,
                    1);

            if (addresses != null && addresses.size() > 0) {
                Address address = addresses.get(0);
                country = address.getCountryName();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return country;
    }

    // get pincode..

    public String getPinCode(double lattitude, double longitude) {
        Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
        String pincode = "";
        try {
            List<Address> addresses = gcd.getFromLocation(lattitude, longitude,
                    1);

            if (addresses != null && addresses.size() > 0) {
                Address address = addresses.get(0);
                pincode = address.getPostalCode();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pincode;
    }


    protected Location getLastKnownLocation() {
        LocationManager mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        List<String> providers = mLocationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            Location l = mLocationManager.getLastKnownLocation(provider);

            if (l == null) {
                continue;
            }
            if (bestLocation == null
                    || l.getAccuracy() < bestLocation.getAccuracy()) {
                bestLocation = l;
            }
        }
        if (bestLocation == null) {
            return null;
        }
        return bestLocation;
    }

   /* public void callSearch(Context context) {
        DialogFragment newFragment = SearchPopUp.newInstance();
        newFragment.show(getFragmentManager(), "Enter Info");

    }*/

    @Override
    public void asyncCallBackFunction(HttpResponseVO result, String apiUrl) {

    }
}




package com.example.saurab.abc.fragment;

/**
 * Created by saurab on 2/6/2016.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Base64;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.saurab.abc.async.callback.AsyncCallBackInterface;
import com.example.saurab.abc.util.Constants;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class BaseFragment extends Fragment implements AsyncCallBackInterface {

    public Bundle b;
    /**
     * Used to save from reinitializing Views when onViewCreated is called again
     * after a popBackStack() call. To be used only when caching view state.
     */
    public boolean hasInitializedRootView = false;
    private View _rootView;

/*
    protected Point getScreenDimentions() {
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }*/
/*
    protected void addfragment(Fragment fragment, boolean isBackStack) {
        FragmentTransaction transaction;
        transaction = getActivity().getSupportFragmentManager()
                .beginTransaction();
        transaction.replace(R.id.home_frame_layout_for_fragments, fragment);
        if (isBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }*/

   /* protected void addfragment(Fragment fragment, boolean isBackStack, String tag) {
        FragmentTransaction transaction;
        transaction = getActivity().getSupportFragmentManager()
                .beginTransaction();
        transaction.replace(R.id.home_frame_layout_for_fragments, fragment, tag);
        if (isBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }*/

    protected void clearCurrentFragment() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    protected double formatToSingleDecimal(double value) {
        DecimalFormat oneDigit = new DecimalFormat("#,##0.0");
        double result = Double.valueOf(oneDigit.format(value));
        return result;
    }

    protected void gotoClass(Class<?> classTo, Activity context) {
        context.startActivity(new Intent(context, classTo));
        context.finish();
    }

    protected String getLocationName(double lattitude, double longitude) {

        String cityName = "Not Found";
        Geocoder gcd = new Geocoder(getActivity().getBaseContext(), Locale.getDefault());
        try {

            List<Address> addresses = gcd.getFromLocation(lattitude, longitude,
                    1);

            cityName = addresses.get(0).getSubLocality() + ", " + addresses.get(0).getLocality();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityName;

    }


   /* protected void setRatingHome(double rating, double ratingDisplay) {

        ImageView ratingHome = (ImageView) getView().findViewById(R.id.iv_rating_home);
        TextView ratingHomeText = (TextView) getView().findViewById(R.id.tv_rating_home);
        ratingHomeText.setText(Double.toString(ratingDisplay));


        if (rating == 0) {
            ratingHome.setImageResource(R.drawable.zero);


        } else if (rating == 0.5) {
            ratingHome.setImageResource(R.drawable.zero_point_five);

        } else if (rating == 1) {
            ratingHome.setImageResource(R.drawable.one);

        } else if (rating == 1.5) {
            ratingHome.setImageResource(R.drawable.one_point_five);

        } else if (rating == 2) {
            ratingHome.setImageResource(R.drawable.two);

        } else if (rating == 2.5) {
            ratingHome.setImageResource(R.drawable.two_point_five);

        } else if (rating == 3) {
            ratingHome.setImageResource(R.drawable.three);

        } else if (rating == 3.5) {
            ratingHome.setImageResource(R.drawable.three_point_five);

        } else if (rating == 4) {
            ratingHome.setImageResource(R.drawable.four);

        } else if (rating == 4.5) {
            ratingHome.setImageResource(R.drawable.four_point_five);

        } else if (rating == 5) {
            ratingHome.setImageResource(R.drawable.five);

        }

    }*/

   /* protected void setRatingHome(double rating, double ratingDisplay, ImageView iv, TextView tv) {

        ImageView ratingHome = iv;
        TextView ratingHomeText = tv;
        ratingHomeText.setText(Double.toString(ratingDisplay));


        if (rating == 0) {
            ratingHome.setImageResource(R.drawable.zero);


        } else if (rating == 0.5) {
            ratingHome.setImageResource(R.drawable.zero_point_five);

        } else if (rating == 1) {
            ratingHome.setImageResource(R.drawable.one);

        } else if (rating == 1.5) {
            ratingHome.setImageResource(R.drawable.one_point_five);

        } else if (rating == 2) {
            ratingHome.setImageResource(R.drawable.two);

        } else if (rating == 2.5) {
            ratingHome.setImageResource(R.drawable.two_point_five);

        } else if (rating == 3) {
            ratingHome.setImageResource(R.drawable.three);

        } else if (rating == 3.5) {
            ratingHome.setImageResource(R.drawable.three_point_five);

        } else if (rating == 4) {
            ratingHome.setImageResource(R.drawable.four);

        } else if (rating == 4.5) {
            ratingHome.setImageResource(R.drawable.four_point_five);

        } else if (rating == 5) {
            ratingHome.setImageResource(R.drawable.five);

        }

    }*/


    protected double roundToPointFive(double rating) {
        double d = rating - Math.floor(rating);
        int intRating = (int) (d * 10);
        switch (intRating) {
            case 0:
                d = 0.0;
                break;
            case 1:
                d = 0.0;
                break;
            case 2:
                d = 0.0;
                break;
            case 3:
                d = 0.5;
                break;
            case 4:
                d = 0.5;
                break;
            case 5:
                d = 0.5;
                break;
            case 6:
                d = 0.5;
                break;
            case 7:
                d = 0.5;
                break;
            case 8:
                d = 1;
                break;
            case 9:
                d = 1;
                break;
            case 10:
                d = 1;
                break;


        }
        return Math.floor(rating) + d;
    }


    protected void removeFragmentFromStack() {
        final FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.popBackStack(null,
                FragmentManager.POP_BACK_STACK_INCLUSIVE);

    }

 /*   protected void setUpBackInProfile(final String brandRefId, final String userRefId) {
        getView().findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFragmentFromStack();
                Fragment userProfileFragment = new UserProfileFragment();
                Bundle bundle = new Bundle();
                bundle.putString(Constants.JK_BRAND_REFERENCE_ID, brandRefId);
                bundle.putString(Constants.JK_USER_REF_ID, userRefId);
                userProfileFragment.setArguments(bundle);
                addfragment(userProfileFragment, true);
            }
        });
    }*/

    public static String getAuthorizationHeader(String uname, String pswd) {
        return Base64
                .encodeToString(
                        (uname + Constants.STR_COLON + pswd).getBytes(),
                        Base64.NO_WRAP);
    }




    protected void showMessage(String msg, Context context) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        //alertDialog.setTitle(Constants.STR_INFO);
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






    protected void showErrorMessage(String msg, Context context) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
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

    /* protected Location getLastKnownLocation() {
         LocationManager mLocationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
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
 */
    protected String convertBitmapToFilePath(Bitmap bitmap) {
        String file_path = Environment.getExternalStorageDirectory().getAbsolutePath() +
                "/tellofy";
        File dir = new File(file_path);
        if (!dir.exists())
            dir.mkdirs();
        File file = new File(dir, "tm.jpg");

        try {
            FileOutputStream fOut = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 85, fOut);
            fOut.flush();
            fOut.close();
        } catch (IOException e) {

        }
        return file.getAbsolutePath();

    }

    protected Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }
/*
    protected LatLng getLocationFromAddress(String strAddress) {

        Geocoder coder = new Geocoder(getActivity());
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
        double lat = location.getLatitude();
        double lng = location.getLongitude();

        LatLng dest = new LatLng(lat, lng);
        return dest;

    }

    protected void showLoader() {
        getView().findViewById(R.id.ll_load).setVisibility(View.VISIBLE);
        ((ProgressBar) getView().findViewById(R.id.pb_load)).getIndeterminateDrawable().setColorFilter(
                getResources().getColor(R.color.button_blue),
                android.graphics.PorterDuff.Mode.SRC_IN);
    }

    protected void hideLoader() {
        getView().findViewById(R.id.ll_load).setVisibility(View.GONE);
    }*/

/*
    protected void setUserHeader(UserProfileApiModel userProfile) {
        ((TextView) getView().findViewById(R.id.tv_name)).setText(userProfile.getFirstName() + " " + userProfile.getLastName());
        String imageUrl = EndPoint.IMAGE_BASE_URL + userProfile.getProfilePicFilePath();
        imageUrl = imageUrl.replace("\\", File.separator);
        Picasso.with(getActivity()).load(imageUrl).resize(50, 50).skipMemoryCache().placeholder(R.drawable.profile_pic).error(R.drawable.profile_pic).into((ImageView) getView().findViewById(R.id.iv_profile_pic));


    }

    @Override
    public void asyncCallBackFunction(HttpResponseVO result, String apiUrl) {

    }*/


}

package com.example.saurab.abc.util;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;

/**
 * Created by saurab on 2/6/2016.
 */
public class Utility {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String IN_PHONE_NUM_PATTERN = "[0-9]{10,11}";
    private static final String GEN_PHONE_NUM_PATTERN = "[0-9]{4,15}";
    private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
    private static final Pattern indiaPhoneNumberPattern = Pattern
            .compile(IN_PHONE_NUM_PATTERN);
    private static final Pattern genPhoneNumberPattern = Pattern
            .compile(GEN_PHONE_NUM_PATTERN);
    private static final Pattern indiaPincodePattern = Pattern
            .compile("[0-9]{6}");


    private static final Pattern passwordPatteren = Pattern
            .compile("^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9!@#$%&]+)$");

    public static boolean isValidEmail(String email) {
        return emailPattern.matcher(email).matches();
    }

    public static boolean isValidPassword(String password) {
        boolean isMatch = passwordPatteren.matcher(password).matches();
        boolean isNumber = false;
        isNumber = password.length() > 5;
        return isMatch && isNumber;
    }

    public static boolean isValidIndiaPhoneNumber(String number) {
        return indiaPhoneNumberPattern.matcher(number).matches();
    }

    public static boolean isValidPhoneNumber(String number) {
        return genPhoneNumberPattern.matcher(number).matches();
    }

    public static boolean isValidIndiaPincode(String pincode) {
        return indiaPincodePattern.matcher(pincode).matches();
    }

    public static String getFormattedURL(String URL,
                                         Map<String, String> keyValuePairs) {
        Set<String> keys = keyValuePairs.keySet();
        String returnStr = URL;
        for (String key : keys) {
            returnStr = returnStr.replace(key, keyValuePairs.get(key));
        }
        return returnStr;
    }

    public static boolean isPastDate(Long dateInMillis) {
        boolean isPast = false;
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(dateInMillis);
        isPast = c.getTime().before(new Date());
        return isPast;
    }

    public static String formatDate(String date, String inPattern,
                                    String outPattern) {
        String returnValue = null;
        SimpleDateFormat format = new SimpleDateFormat(inPattern);
        try {
            Date tempDate = format.parse(date);
            SimpleDateFormat outFormat = new SimpleDateFormat(outPattern);
            returnValue = outFormat.format(tempDate);
        } catch (ParseException e) {
            returnValue = date;
        }
        return returnValue;
    }

    public static String formatDate(long timeInMillis, String pattern) {
        String returnValue = null;
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timeInMillis);
//		System.out.println(c.get(Calendar.DAY_OF_WEEK));
//		if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
//		{
//			System.out.println("ITS a sunday");
//		}
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        returnValue = format.format(c.getTime());
        return returnValue;
    }

    public static long formatDateAsLong(String date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        format.setTimeZone(TimeZone.getDefault());
        Date tempDate = null;
        try {
            tempDate = format.parse(date);
        } catch (ParseException e) {
            tempDate = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(tempDate);
        return c.getTimeInMillis();
    }

    public static int[] splitDate(String startDate, String pattern) {
        int[] dateArr = new int[3];
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(startDate));
            dateArr[0] = c.get(Calendar.DATE);
            dateArr[1] = c.get(Calendar.MONTH);
            dateArr[2] = c.get(Calendar.YEAR);
        } catch (ParseException e) {
            // Should not normally occur;
        }
        return dateArr;
    }


    public static boolean isNullOrEmpty(EditText s) {
        return s == null
                || s.getText() == null
                || s.getText().toString() == null
                || s.getText().toString().trim()
                .equals(Constants.STR_BLANK);
    }

    public static boolean isNullOrEmpty(TextView s) {
        return s == null
                || s.getText() == null
                || s.getText().toString() == null
                || s.getText().toString().trim()
                .equals(Constants.STR_BLANK);
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.toString().trim().equals(Constants.STR_BLANK)
                || s.equalsIgnoreCase(Constants.STR_NULL);
    }

   /* public static boolean isValidDate(int day, int month, int year, int hour,
                                      int minute) {
        StringBuffer sb = new StringBuffer();
        sb.append(day).append(Constants.SPACE).append(month)
                .append(Constants.SPACE).append(year)
                .append(Constants.SPACE).append(hour)
                .append(Constants.SPACE).append(minute);
        try {
            Date date = new SimpleDateFormat("dd MM yyyy HH mm").parse(sb
                    .toString());
            if (date.before(new Date())) {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
        return true;
    }*/

    public static boolean isValidDate(String date, String inPattern) {
        try {
            Date temp = new SimpleDateFormat(inPattern).parse(date);
            if (temp.before(new Date())) {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static boolean isValidFromNToDate(String fromDate, String toDate,
                                             String inPattern) {
        try {
            Date fd = new SimpleDateFormat(inPattern).parse(fromDate);
            Date td = new SimpleDateFormat(inPattern).parse(toDate);
            if (fd.before(new Date())) {
                return false;
            }
            if (td.before(fd)) {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
        return true;
    }


    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9))
                    buf.append((char) ('0' + halfbyte));
                else
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    public static String MD5(String text) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] md5hash = new byte[32];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        md5hash = md.digest();
        return convertToHex(md5hash);
    }

    public static void setFont(String font, Context context, TextView... textViews) {
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/" + font);
        for (int i = 0; i < textViews.length; ++i) {
            textViews[i].setTypeface(tf);

        }

    }

    public static Typeface getTypeFace(String font, Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/" + font);
    }

    public static void setFont(Context context, Typeface tf, TextView... textViews) {
        for (int i = 0; i < textViews.length; ++i) {
            textViews[i].setTypeface(tf);

        }

    }

}

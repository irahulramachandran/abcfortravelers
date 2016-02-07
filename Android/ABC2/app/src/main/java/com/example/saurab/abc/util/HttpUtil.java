package com.example.saurab.abc.util;
import android.os.Environment;
import com.example.saurab.abc.vo.HttpResponseVO;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.net.HttpURLConnection;

/**
 * Created by saurab on 2/6/2016.
 */
public final class HttpUtil {

    public static void get(String url, Map<String, String> headers,
                           HttpResponseVO responseVo) throws IOException {
        try {
            DefaultHttpClient client = new DefaultHttpClient();

            HttpGet get = new HttpGet(url);
            Set<String> keySet = headers.keySet();
            for (String key : keySet) {
                get.addHeader(key, headers.get(key));
            }

            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();

            responseVo
                    .setResponseCode(response.getStatusLine().getStatusCode());
            InputStream inputStream = entity.getContent();
            ByteArrayOutputStream content = new ByteArrayOutputStream();

            // Read response into a buffered stream
            int readBytes = 0;
            byte[] sBuffer = new byte[512];
            while ((readBytes = inputStream.read(sBuffer)) != -1) {
                content.write(sBuffer, 0, readBytes);
            }
            responseVo.setResponse(new String(content.toByteArray()));
        } catch (IOException e) {
            responseVo.setError(e.getMessage());
        }
    }

    public static void post(String url, final byte[] data,
                            Map<String, String> headers, HttpResponseVO responseVo)
            throws IOException {

        HttpPost post = new HttpPost(url);
        Set<String> keySet = headers.keySet();
        for (String key : keySet) {
            post.addHeader(key, headers.get(key));
        }
        post.setEntity(new HttpEntity() {

            @Override
            public void writeTo(OutputStream outstream) throws IOException {
                outstream.write(data);
            }

            @Override
            public boolean isStreaming() {
                return false;
            }

            @Override
            public boolean isRepeatable() {
                return false;
            }

            @Override
            public boolean isChunked() {
                return false;
            }

            @Override
            public Header getContentType() {
                return new BasicHeader(Constants.HTTP_HEADER_CONTENT_TYPE,
                        "application/x-www-form-urlencoded");
            }

            @Override
            public long getContentLength() {
                return data.length;
            }

            @Override
            public Header getContentEncoding() {
                return null;
            }

            @Override
            public InputStream getContent() throws IOException,
                    IllegalStateException {
                InputStream is = new ByteArrayInputStream(data, 0, data.length);
                return is;
            }

            @Override
            public void consumeContent() throws IOException {

            }
        });

        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        InputStream inputStream = entity.getContent();
        ByteArrayOutputStream content = new ByteArrayOutputStream();
        responseVo.setResponseCode(response.getStatusLine().getStatusCode());
        // Read response into a buffered stream
        int readBytes = 0;
        byte[] sBuffer = new byte[512];
        while ((readBytes = inputStream.read(sBuffer)) != -1) {
            content.write(sBuffer, 0, readBytes);
        }
        responseVo.setResponse(new String(content.toByteArray()));
    }

    public static void delete(String url, Map<String, String> headers,
                              HttpResponseVO responseVo) throws IOException {
        DefaultHttpClient client = new DefaultHttpClient();

        HttpDelete delete = new HttpDelete(url);

        Set<String> keySet = headers.keySet();
        for (String key : keySet) {
            delete.addHeader(key, headers.get(key));
        }
        HttpResponse response = client.execute(delete);
        responseVo.setResponseCode(response.getStatusLine().getStatusCode());
    }

    public static void put(String url, final byte[] data,
                           Map<String, String> headers, HttpResponseVO responseVo)
            throws IOException {

        HttpPut post = new HttpPut(url);
        Set<String> keySet = headers.keySet();
        for (String key : keySet) {
            post.addHeader(key, headers.get(key));
        }

        post.setEntity(new HttpEntity() {

            @Override
            public void writeTo(OutputStream outstream) throws IOException {
                outstream.write(data);
            }

            @Override
            public boolean isStreaming() {
                return false;
            }

            @Override
            public boolean isRepeatable() {
                return false;
            }

            @Override
            public boolean isChunked() {
                return false;
            }

            @Override
            public Header getContentType() {
                return new BasicHeader(Constants.HTTP_HEADER_CONTENT_TYPE,
                        Constants.HTTP_HEADER_ACCEPT_VAUE_JSON);
            }

            @Override
            public long getContentLength() {
                return data.length;
            }

            @Override
            public Header getContentEncoding() {
                return null;
            }

            @Override
            public InputStream getContent() throws IOException,
                    IllegalStateException {
                InputStream is = new ByteArrayInputStream(data, 0, data.length);
                return is;
            }

            @Override
            public void consumeContent() throws IOException {

            }
        });

        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        InputStream inputStream = entity.getContent();
        ByteArrayOutputStream content = new ByteArrayOutputStream();
        responseVo.setResponseCode(response.getStatusLine().getStatusCode());
        // Read response into a buffered stream
        int readBytes = 0;
        byte[] sBuffer = new byte[512];
        while ((readBytes = inputStream.read(sBuffer)) != -1) {
            content.write(sBuffer, 0, readBytes);
        }
        responseVo.setResponse(new String(content.toByteArray()));

    }

    public static HttpResponseVO getPostResponse(String url,
                                                 final String data) throws IOException {

        HttpResponseVO responseVo = new HttpResponseVO();

        HttpPost post = new HttpPost(url);

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
        nameValuePairs.add(new BasicNameValuePair("data", data));
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        InputStream inputStream = entity.getContent();
        ByteArrayOutputStream content = new ByteArrayOutputStream();
        responseVo.setResponseCode(response.getStatusLine().getStatusCode());
        // Read response into a buffered stream
        int readBytes = 0;
        byte[] sBuffer = new byte[512];
        while ((readBytes = inputStream.read(sBuffer)) != -1) {
            content.write(sBuffer, 0, readBytes);
        }
        responseVo.setResponse(new String(content.toByteArray()));

        return responseVo;
    }

    public static boolean isExternalStorageAvailable() {
        boolean mExternalStorageAvailable = false;
        boolean mExternalStorageWriteable = false;
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state)) {
            mExternalStorageAvailable = mExternalStorageWriteable = true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            mExternalStorageAvailable = true;
            mExternalStorageWriteable = false;
        } else {
            mExternalStorageAvailable = mExternalStorageWriteable = false;
        }
        return (mExternalStorageAvailable && mExternalStorageWriteable);
    }

    public static void uploadFile(String endPoint, String path,
                                  HttpResponseVO vo) {
        HttpURLConnection connection = null;
        DataOutputStream outputStream = null;
        String pathToOurFile = path;
        String urlServer = endPoint;
        String filename = pathToOurFile.substring(pathToOurFile
                .lastIndexOf(File.separator) + 1);
        String lineEnd = "\r\n";
        String twoHyphens = "--";
        String boundary = "*****";

        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 1 * 1024 * 1024;

        try {
            FileInputStream fileInputStream = new FileInputStream(new File(
                    pathToOurFile));

            URL url = new URL(urlServer);
            connection = (HttpURLConnection) url.openConnection();

            // Allow Inputs &amp; Outputs.
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);

            // Set HTTP method to POST.
            connection.setRequestMethod("POST");

            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("Content-Type",
                    "multipart/form-data;boundary=" + boundary);

            outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(twoHyphens + boundary + lineEnd);
            outputStream
                    .writeBytes("Content-Disposition: form-data; name=\"uploadedfile\";filename=\""
                            + filename + "\"" + lineEnd);
            outputStream.writeBytes(lineEnd);

            bytesAvailable = fileInputStream.available();
            bufferSize = Math.min(bytesAvailable, maxBufferSize);
            buffer = new byte[bufferSize];

            // Read file
            bytesRead = fileInputStream.read(buffer, 0, bufferSize);

            while (bytesRead > 0) {
                outputStream.write(buffer, 0, bufferSize);
                bytesAvailable = fileInputStream.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                bytesRead = fileInputStream.read(buffer, 0, bufferSize);
            }

            outputStream.writeBytes(lineEnd);
            outputStream.writeBytes(twoHyphens + boundary + twoHyphens
                    + lineEnd);

            // Responses from the server (code and message)
            vo.setResponseCode(connection.getResponseCode());

            if (vo.getResponseCode() == Constants.HTTP_OK_200) {
                StringBuilder sb = new StringBuilder();
                byte[] tempBuf = new byte[1024];
                InputStream is = connection.getInputStream();
                while (is.read(tempBuf) != -1) {
                    sb.append(new String(tempBuf));
                }
                String s = sb.toString();
                s = s.replace("�", "");
                vo.setResponse(s);
            } else {
                StringBuilder sb = new StringBuilder();
                byte[] tempBuf = new byte[1024];
                InputStream is = connection.getErrorStream();
                while (is.read(tempBuf) != -1) {
                    sb.append(new String(tempBuf));
                }
                vo.setResponse(sb.toString());
            }

            fileInputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception ex) {
            vo.setError(ex.getMessage());
        }

    }
}

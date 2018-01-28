package com.example.nysil.newsnow;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;


public final class QueryNews {
    public static ArrayList<News> getData(String url) {

        //fist get URL from the provided string
        URL getURL=makeURL(url);

        //now we create a connectioon on this URL and get Json response in String

        String jsonResponse=null;
        jsonResponse=getJsonResponse(getURL);
        
        //now wehen we have got the whole json response
        //its timw to extract the needed data from it
        
        ArrayList<News> arrayList=null;
        
        arrayList=getNewsData(jsonResponse);





        return arrayList;
    }

    private static ArrayList<News> getNewsData(String jsonResponse) {

        if(jsonResponse==null)
        {
            return null;
        }

        ArrayList<News> arrayList=new ArrayList<>();
        try {
            JSONObject jsonRootObject=new JSONObject(jsonResponse);

            JSONArray jsonArray=jsonRootObject.getJSONArray("articles");

            for(int i=0; i<jsonArray.length(); i++)
            {
                JSONObject insideArrayObject= jsonArray.getJSONObject(i);

                String heading= insideArrayObject.getString("title");
                String story= insideArrayObject.getString("description");

                String imageUrl= insideArrayObject.getString("urlToImage");


                News nws=new News(heading, story, imageUrl);

                arrayList.add(nws);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }


    private static String getJsonResponse(URL getURL) {
        String jsonFromUrl;
        if (getURL == null) {
            return null;
        }
        else {
            jsonFromUrl = null;
            InputStream inputStream = null;
            HttpURLConnection httpURLConnection = null;
            try {
                httpURLConnection = (HttpURLConnection) getURL.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(25000);
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.connect();

                if (httpURLConnection.getResponseCode() == httpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                    jsonFromUrl = readFromStream(inputStream);

                } else {
                    Log.d("Error", "not connected");
                }

            } catch (IOException e) {
                System.out.println("Error during making connection and getting jsonresponse " + e);
            }
        }
        return jsonFromUrl;
     }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder getJson=new StringBuilder();
        
        
        if (inputStream == null) {
            return null;
        } else {

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String buffer = bufferedReader.readLine();
            while (buffer != null) {
                getJson.append(buffer);
                buffer = bufferedReader.readLine();
            }

        }
        return getJson.toString();

    }

    private static URL makeURL(String url) {

        if(url==null)
        {
            return null;
        }
        else {
            URL makeUrl=null;
            try {
                makeUrl = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return makeUrl;
        }
    }
}

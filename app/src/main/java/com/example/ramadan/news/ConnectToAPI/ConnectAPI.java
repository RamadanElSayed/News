package com.example.ramadan.news.ConnectToAPI;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by ramadan on 4/2/2017.
 */
public class ConnectAPI extends AsyncTask<String,String,String> {

    HttpURLConnection urlConnection =null;
    BufferedReader bufferedReader=null;
    String data;
    @Override
    protected String doInBackground(String... params) {
          // string ...params de array of string

        try {
            StringBuffer buffer=new StringBuffer();
            // url to connect
            URL url=new URL(params[0]);
            // to give it url to connect  open connection
            urlConnection = (HttpURLConnection) url.openConnection();

            // to read data and return in input stream
            InputStream inputStream=new BufferedInputStream(urlConnection.getInputStream());
            // file to read data
            bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";

            while ((line=bufferedReader.readLine())!=null)
            {
                buffer.append(line+"\n");
            }


            data=buffer.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}

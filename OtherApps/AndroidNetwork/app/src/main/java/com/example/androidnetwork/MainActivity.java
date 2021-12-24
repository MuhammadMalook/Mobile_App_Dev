package com.example.androidnetwork;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        //NetworkInfo info[] = manager.getAllNetworkInfo();
//        for (int i = 0; i < info.length; i++) {
//            Toast.makeText(this, "Network : "+info[i].getTypeName()+" is "+info[i].getState(), Toast.LENGTH_SHORT).show();
//        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String data = getData();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(data);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        JSONArray array = null;
                        try {
                            array = jsonObject.getJSONArray("persons");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject object = null;
                            try {
                                object = array.getJSONObject(i);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                Toast.makeText(getApplicationContext(), "data : "+object.get("name"), Toast.LENGTH_SHORT).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                });
            }
        });
        thread.start();
    }
    public String getData()
    {
        String completeData="";
        String url="https://protected-inlet-55078.herokuapp.com/person";
        try {
            URL link = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) link.openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String data="";

            while ((data = bufferedReader.readLine()) != null)
            {
                Log.d(TAG, "getData: "+data);
                completeData+=data;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return completeData;
    }
}
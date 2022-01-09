package com.example.volley_api;

import static com.android.volley.Request.Method.GET;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    String url = "https://protected-inlet-55078.herokuapp.com/person";
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.textview);
    }
    public void FetchData(View view)
    {
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                    txt.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                txt.setText(error.toString());
            }
        });
        queue.add(request);
    }
}
package com.clockworkant.movies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * This was taken and adapted from http://www.vogella.com/code/de.vogella.android.json/src/de/vogella/android/json/ReadJson.html
 * Vogella is a great resource but in this circumstance it is a nightmare.
 */
public class BadMainActivity extends ActionBarActivity {

    private TextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textview);
        new FetchAndDisplayMoviesTask().execute();
    }

    private class FetchAndDisplayMoviesTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            String resultString = "";
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet("http://api.rottentomatoes.com/api/public/v1.0/lists/dvds/new_releases.json?apikey=p459835aac72zf69tw2t8wmq");
            getRequest.setHeader("Accept", "application/json");
            try {
                HttpResponse response = (HttpResponse) httpclient.execute(getRequest);
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    InputStream instream = entity.getContent();
                    // convert content stream to a String
                    resultString = readStream(instream);
                    instream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return resultString;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s.trim());
                JSONArray movies = jsonObject.getJSONArray("movies");
                for (int i = 0; i < movies.length(); i++) {
                    JSONObject movie = movies.getJSONObject(i);
                    mTextView.append(movie.getString("title") + '\n');
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private String readStream(InputStream is) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();

            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return sb.toString();
        }
    }


}
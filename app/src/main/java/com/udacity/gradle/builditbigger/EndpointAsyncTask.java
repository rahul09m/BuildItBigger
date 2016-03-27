package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.rahulm09.android.jokedisplay.JokeDisplayActivity;
import com.rahulm09.builditbigger.backend.myApi.MyApi;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Created by Rahul on 27/03/2016.
 */
class EndpointAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new
                    AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1263.appspot.com/_ah/api/");



            myApiService = builder.build();
        }

        context = params[0];


        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        // Create Intent to launch JokeDisplayActivity
        Intent intent = new Intent(context, JokeDisplayActivity.class);
        // Put the string in the envelope
        intent.putExtra(JokeDisplayActivity.JOKE_KEY,result);
        context.startActivity(intent);
   // super.onPostExecute(result);
       // Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }
}
package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.SupplyJoke;

import com.rahulm09.android.jokedisplay.JokeDisplayActivity;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //new EndpointsAsyncTask().execute();
     //   new EndpointsAsyncTask().execute(this);
       // new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
       /* Intent intent = new Intent(this, JokeDisplayActivity.class);
        SupplyJoke joke = new SupplyJoke();
        String jokeString = joke.giveJoke();
        intent.putExtra(JokeDisplayActivity.JOKE_KEY, jokeString);
        startActivity(intent);*/
       // Log.d("Main","joke manin: "+jokeString);
       // TextView jokeView = (TextView)findViewById(R.id.joketextView);
       // jokeView.setText(jokeString);
        //Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();

        new EndpointAsyncTask().execute(this);
    }

   /*class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
 // class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

      private  MyApi myApiService = null;
        private Context context;

        @Override
        protected String doInBackground(Context... params) {
       // protected String doInBackground(Pair<Context, String>... params) {
            if(myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl("https://elegant-beach-125523.appspot.com/_ah/api/");



                myApiService = builder.build();
            }

            context = params[0];
            String name = "rahul";

            try {
               // return myApiService.sayHi(name).execute().getData();
                return myApiService.tellJoke().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Log.d("Final",result);
            Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        }
    }*/

}

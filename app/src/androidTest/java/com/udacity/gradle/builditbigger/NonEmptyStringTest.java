package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

/**
 * Created by Rahul on 27/03/2016.
 */
public class NonEmptyStringTest extends AndroidTestCase {

    String result = null;
    public void testEndpointAsyncTask()  {
        EndpointAsyncTask endpointsAsyncTask = new EndpointAsyncTask();
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }
}

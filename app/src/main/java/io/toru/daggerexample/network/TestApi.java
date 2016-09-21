package io.toru.daggerexample.network;

import android.util.Log;

/**
 * Created by toru on 2016. 9. 21..
 */

public class TestApi {
    private static final String TAG = TestApi.class.getSimpleName();
    public String test(){
        Log.w(TAG, "networkTest: ");
        return "Test API!!!";
    }
}

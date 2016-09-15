package io.toru.daggerexample.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

import io.toru.daggerexample.R;
import io.toru.daggerexample.app.MyApplication;
import io.toru.daggerexample.network.NetworkApi;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    public NetworkApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication)getApplication()).getComponent().inject(this);

        boolean isInjected = (api != null);
        if(isInjected){
            if(api.validateUser("Wonyoung", "Choi")){
                Log.w(TAG, "onCreate: validated!! ");
            }
        }
        else{
            Log.w(TAG, "onCreate: not injected");
        }
    }
}

package android.example.taptip.data;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.example.taptip.ui.MainActivity;
import android.util.Log;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;

public class FacebookHelper  {

    CallbackManager mCallbackManager;

    public void loginWithFacebook (Activity activity){

        mCallbackManager = CallbackManager.Factory.create();


        //Create Facebook response + CallBack.
        FacebookSdk.sdkInitialize(activity.getApplicationContext());

        LoginManager.getInstance().registerCallback(mCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.d("Success", loginResult.getAccessToken().getToken());

                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(activity, "Login Cancel", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(activity, exception.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });


    }


    public void loginButton (Activity activity){
        LoginManager.getInstance().logInWithReadPermissions(activity, Arrays.asList("public_profile", "user_friends"));

    }
    
}

package android.example.taptip.ui;

import androidx.annotation.StringDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.example.taptip.R;
import android.example.taptip.data.FirebaseHelper;
import android.example.taptip.databinding.ActivityForgetBinding;
import android.example.taptip.databinding.ActivityMainBinding;
import android.os.Bundle;
import android.view.View;

import com.facebook.appevents.suggestedevents.ViewOnClickListener;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class ForgetActivity extends AppCompatActivity {
    String number;

//    FirebaseHelper firebaseHelper = new FirebaseHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityForgetBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_forget);

        number = binding.extMobileNumber.getText().toString();


        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //deliver the number into second activity
//                App= new Intent(ForgetActivity.this,VerificationActivity.class);
//                i.putExtra("number",number);
//                startActivity(i);

                VerificationActivity fragment = VerificationActivity.newInstance();
                fragment.show(getSupportFragmentManager(),fragment.getTag());








            }
        });

    }
}
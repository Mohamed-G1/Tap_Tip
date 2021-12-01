package android.example.taptip.data;

import android.example.taptip.ui.ForgetActivity;
import android.example.taptip.ui.MainActivity;
import android.example.taptip.ui.VerificationActivity;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;


public class FirebaseHelper {

    String Number_byUser, Code_by_system;

    public FirebaseHelper(String number_byUser, String code_by_system) {
        Number_byUser = number_byUser;
        Code_by_system = code_by_system;
    }

    public void Send_Code_to_user(String number_enter_byUser) {
        PhoneAuthProvider.verifyPhoneNumber(
                PhoneAuthOptions
                        .newBuilder(FirebaseAuth.getInstance())
                        //.setActivity(VerificationActivity.this)
                        .setPhoneNumber("+2"+number_enter_byUser)
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setCallbacks(mCallbacks)
                        .build());

    }



    // Call Back
    public PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){


        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

//            verification.Code_by_system = s ;
        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();

            if(code!=null){
                finish_everything(code);
            }

        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {


        }
    };


    public void finish_everything(String code) {
//        verification.pinview.setText(code);
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(Code_by_system,code);
        sgin_in(credential);
    }



    public void sgin_in(PhoneAuthCredential credential) {
        FirebaseAuth auth =  FirebaseAuth.getInstance();
        auth.signInWithCredential(credential).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if ( task.isSuccessful()){

                }else {
                   // Toast.makeText(OtpActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();

                }

            }
        });
    }





    // resend OTP
    public void resend_OTP(String number_enter_byUser, PhoneAuthProvider.ForceResendingToken token) {

        PhoneAuthProvider.verifyPhoneNumber(
                PhoneAuthOptions
                        .newBuilder(FirebaseAuth.getInstance())
                        //.setActivity(context)
                        .setPhoneNumber("+2"+number_enter_byUser)
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setCallbacks(mCallbacks)
                        .setForceResendingToken(token)
                        .build());


    }


}

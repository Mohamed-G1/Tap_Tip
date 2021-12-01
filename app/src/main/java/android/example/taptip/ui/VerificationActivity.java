package android.example.taptip.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.example.taptip.R;
import android.example.taptip.data.FirebaseHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.chaos.view.PinView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class VerificationActivity extends BottomSheetDialogFragment {

//    public String Number_enter_byUser, Code_by_system , user_enter_code;
//    public PinView pinview;
//
    FirebaseHelper firebaseHelper = new FirebaseHelper("0111523213221","256585");


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.activity_verification,container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      //  ActivityVerificationBinding binding = DataBindingUtil.setContentView(get, R.layout.activity_verification);
//
//        // to received the data
//        Number_enter_byUser  = getArguments().getString("number");
//
//
//        firebaseHelper.onVerificationCompleted();
//        Toast.makeText(getContext(), "User sign in ", Toast.LENGTH_LONG).show();
//
//
//        firebaseHelper.onVerificationFailed();
//        Toast.makeText(getContext(), "error", Toast.LENGTH_LONG).show();
}

//
//    public void btnsubmit(View view){
//
//        //send code to user
//
//        firebaseHelper.Send_Code_to_user(Number_enter_byUser);
//
//        PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                Number_enter_byUser,
//                60,
//                TimeUnit.SECONDS,
//                getActivity(),
//                firebaseHelper.mCallbacks);
//              firebaseHelper.finish_everything(user_enter_code);
//    }



//       public void btnResend (View view ,PhoneAuthProvider.ForceResendingToken token ) {
//
//                  firebaseHelper.resend_OTP(Number_enter_byUser, token);
//               }


    public static VerificationActivity newInstance() {

        Bundle args = new Bundle();

        VerificationActivity fragment = new VerificationActivity();
        fragment.setArguments(args);
        return fragment;
    }



}
















//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//
//
//        int width = dm.widthPixels;
//        int height= dm.heightPixels;
//
//
//        getWindow().setLayout((int)(width*7),(height*5));
//
//        WindowManager.LayoutParams params = getWindow().getAttributes();
//        params.gravity = Gravity.CENTER;
//        params.x = 0;
//        params.y =372;
//
//
//
//        getWindow().setAttributes(params);


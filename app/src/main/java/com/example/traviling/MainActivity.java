package com.example.traviling;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.traveling.R;
import com.example.traviling.LoginSignUpForgetPassword.ForgotPasswordFragment;
import com.example.traviling.LoginSignUpForgetPassword.LoginFragment;
import com.example.traviling.LoginSignUpForgetPassword.SignUpFragment;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gotoLoginFragment();
    }

    public void gotoSignUpFragment(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMain, new SignUpFragment());
        ft.commit();
    }

    private void gotoLoginFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMain, new LoginFragment());
        ft.commit();
    }


    public void gotoForgotPasswordFragment(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMain, new ForgotPasswordFragment());
        ft.commit();
    }

    public void gotoLoginFragment(View view) {
    }
}


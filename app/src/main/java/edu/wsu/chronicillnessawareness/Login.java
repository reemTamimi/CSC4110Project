package edu.wsu.chronicillnessawareness;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.LoginFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    TextInputEditText textInputEditTextUsername, textInputEditTextPassword;
    Button buttonLogin;
    TextView textViewSignUp;
    ProgressBar progressBar;
    EditText ed_email,ed_password;
    TextView tv_registerlink;
     String username = "";
     String password = "";

     //private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed_email = (EditText)findViewById(R.id.txtEmail);
        ed_password = (EditText)findViewById(R.id.txtPwd);
        buttonLogin = (Button)findViewById(R.id.btnLogin);
        tv_registerlink = (TextView)findViewById(R.id.lnkRegister);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                username = ed_email.getText().toString();
                password = ed_password.getText().toString();
                if(username.equals("")){
                    ed_email.setError("email is missing");
                    return;
                }
                if(password.equals("")){
                    ed_password.setError("password is missing");
                    return;
                }
                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);



                }

        });
        tv_registerlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,SignUp.class);
                startActivity(intent);
            }
        });
    }
/*
    @Override
    protected void onStart() {
        super.onStart();

        if (currentUser != null)
        {
            SendUserToMainActivity();
        }
    }

    private void SendUserToMainActivity() {
        Intent loginIntent = new Intent(Login.this, MainActivity.class);
        startActivity(loginIntent);
    }

 */
}
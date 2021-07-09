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

import org.w3c.dom.Text;

import edu.wsu.chronicillnessawareness.Posts.Home;

public class Login extends AppCompatActivity {

    TextInputEditText textInputEditTextUsername, textInputEditTextPassword;
    Button buttonLogin;
    TextView textViewSignUp;
    ProgressBar progressBar;
    EditText ed_email,ed_password;
    TextView tv_registerlink;
     String username = "";
     String password = "";
     TextView forgot_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed_email = (EditText)findViewById(R.id.txtEmail);
        ed_password = (EditText)findViewById(R.id.txtPwd);
        buttonLogin = (Button)findViewById(R.id.btnLogin);
        tv_registerlink = (TextView)findViewById(R.id.lnkRegister);
        forgot_password = (TextView)findViewById(R.id.forgot_password);

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
                Intent intent = new Intent(Login.this, Home.class);
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
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
        

    }
}
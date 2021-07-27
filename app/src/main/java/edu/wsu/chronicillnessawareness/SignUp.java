package edu.wsu.chronicillnessawareness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class SignUp extends AppCompatActivity {

    private Button CreateAccountButton;
    private EditText UserEmail, UserPassword, FullName;
    private TextView AlreadyHaveAccountLink;

    private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        InitializeFields();

        AlreadyHaveAccountLink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                SendUserToLoginActivity();
            }
        });

        CreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateNewAccount();
            }
        });
    }

    private void CreateNewAccount(){
        String email = UserEmail.getText().toString();
        String password = UserPassword.getText().toString();
        String fullname = FullName.getText().toString();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter email!", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter password!", Toast.LENGTH_SHORT).show();
        }
        /*
        if (TextUtils.isEmpty(fullname)){
            Toast.makeText(this, "Please enter full name!", Toast.LENGTH_SHORT).show();
        }*/
        else{
            loadingBar.setTitle("Creating New Account");
            loadingBar.setMessage("Please wait, while your account is being created!");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                SendUserToLoginActivity();
                                Toast.makeText(SignUp.this, "Account created Successfully!", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }
                            else{
                                String message = task.getException().toString();
                                Toast.makeText(SignUp.this, "Error : " + message, Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }
                        }
                    });
        }
    }

    private void InitializeFields(){
        CreateAccountButton = (Button) findViewById(R.id.buttonSignUp);
        FullName = (EditText) findViewById(R.id.fullname);
        UserEmail = (EditText) findViewById(R.id.email);
        UserPassword = (EditText) findViewById(R.id.password);
        AlreadyHaveAccountLink = (TextView) findViewById(R.id.loginText);
        loadingBar = new ProgressDialog(this);
    }

    private void SendUserToLoginActivity() {
        Intent loginIntent = new Intent(SignUp.this, Login.class);
        startActivity(loginIntent);
    }
}
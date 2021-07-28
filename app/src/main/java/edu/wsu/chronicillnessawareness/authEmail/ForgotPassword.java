package edu.wsu.chronicillnessawareness.authEmail;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.tapadoo.alerter.Alerter;

import java.util.Objects;

import edu.wsu.chronicillnessawareness.R;

public class ForgotPassword extends AppCompatActivity {
    TextView signIn,signUp;
    private EditText mEmail;
    private FirebaseAuth mAuth;
    Button button;
    ProgressBar progressBar4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        progressBar4 = findViewById(R.id.progressBar4);
        signIn = findViewById(R.id.textView5);
        signUp = findViewById(R.id.textView6);
        mAuth = FirebaseAuth.getInstance();
        mEmail = findViewById(R.id.email);
        button = findViewById(R.id.button5);
        signIn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SignIn.class );
            startActivity(intent);
        });

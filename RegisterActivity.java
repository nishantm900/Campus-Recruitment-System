package com.example.nishant.campusreruitmentsystem;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText E1,E2,E3,E4,E5,E6;
    Button signUp;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        E1 =(EditText)findViewById(R.id.RegName);
        E2 =(EditText)findViewById(R.id.RegCity);
        E3 =(EditText)findViewById(R.id.RegSate);
        E4 =(EditText)findViewById(R.id.RegMobileno);
        E5 =(EditText)findViewById(R.id.RegEmail);
        E6 =(EditText)findViewById(R.id.RegPassword);
        signUp = (Button)findViewById(R.id.RegButton);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegData();

            }
        });

    }

    private void RegData() {
        String name = E1.getText().toString().trim();
        String city = E2.getText().toString().trim();
        String state = E3.getText().toString().trim();
        String mobileno = E4.getText().toString().trim();
        String email = E5.getText().toString().trim();
        String password = E6.getText().toString().trim();

        progressDialog.setMessage("PLEASE WAIT WHILE PROCESSING....");
        progressDialog.show();

        if (!TextUtils.isEmpty(name)&& !TextUtils.isEmpty(city)&& !TextUtils.isEmpty(state)&& !TextUtils.isEmpty(mobileno)&& !TextUtils.isEmpty(email)& !TextUtils.isEmpty(password)){
            if (email.endsWith("@gmail.com")|| email.endsWith("@yahoo.com")){
                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this,"REGISTRATION SUCCESSFULLY DONE....", Toast.LENGTH_LONG).show();


                    }
                });

            } else {
                progressDialog.dismiss();
                Toast.makeText(RegisterActivity.this,"REGISTRATION FAILED PLZ TRY AFTER SOME TIMES ....", Toast.LENGTH_LONG).show();

            }

        } else {
            progressDialog.dismiss();
            Toast.makeText(RegisterActivity.this,"PLEASE ENTER ALL FIELDS....", Toast.LENGTH_LONG).show();
        }

    }
}

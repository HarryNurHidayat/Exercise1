package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Email, Password;
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email=(EditText)findViewById(R.id.Email);
        Password=(EditText)findViewById(R.id.Password);
        Login=(Button)findViewById(R.id.Login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
                Bundle b = new Bundle();
                b.putString("a", Email.toString());
                b.putString("b", Password.toString());
                Intent i = new Intent(getApplicationContext(), ExerciseForm.class);
                i.putExtras(b);
                startActivity(i);
            }

        });
        cek_form(Email);
        cek_form(Password);
    }
    void Login()
    {
        if (Email.getText().length()<1)
        {
            Email.setBackgroundResource(R.drawable.form_error);
        }
        if (Password.getText().length()<1)
        {
            Password.setBackgroundResource(R.drawable.form_error);
        }
        else
        {

        }
    }

    void cek_form(EditText editText)
    {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count<1)
                {
                    Email.setBackgroundResource(R.drawable.form_error);
                }
                else
                {
                    Email.setBackgroundResource(R.drawable.formuser);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
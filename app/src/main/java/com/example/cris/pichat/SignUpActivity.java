package com.example.cris.pichat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.text.ParseException;


public class SignUpActivity extends ActionBarActivity {

    private EditText editNom;
    private EditText editPass;
    private EditText editMail;
    private Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editNom = (EditText) findViewById(R.id.usernameField);
        editPass = (EditText) findViewById(R.id.passwordField);
        editMail = (EditText) findViewById(R.id.emailField);

    }

    public void onClickRegistro(View view){
        if(editNom.getText().toString().equals("") || editPass.getText().toString().equals("") || editMail.getText().toString().equals("")){
            dialogoCamposVacios().show();

        }else{
            ParseUser user = new ParseUser();
            user.setUsername(editNom.getText().toString());
            user.setPassword(editPass.getText().toString());
            user.setEmail(editMail.getText().toString());


            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(com.parse.ParseException e) {
                    if (e == null) {
                        Toast.makeText(SignUpActivity.this, "Usuarioo registrado", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


        public Dialog dialogoCamposVacios() {

            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
            builder.setTitle("Atención!");
            builder.setMessage("Debe rellenar todos los campos");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });

            return builder.create();
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

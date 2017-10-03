package com.example.android.udacity_project1;

import android.app.AlertDialog;
// import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class Feedback extends AppCompatActivity {

    // Get the Intent that started this activity and extract the string
    // Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final EditText eText, eText2, eText3;
        Button btn2;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        eText = (EditText) findViewById(R.id.name);
        eText2 = (EditText) findViewById(R.id.address);
        eText3 = (EditText) findViewById(R.id.phone);
        btn2 = (Button) findViewById(R.id.submit);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str = eText.getText().toString();
                String str2 = eText2.getText().toString();
                String str3 = eText3.getText().toString();

                TelephonyManager teleMgr = (TelephonyManager) getSystemService(Feedback.TELEPHONY_SERVICE);
                String localeCountry = teleMgr.getNetworkCountryIso();
                if (localeCountry != null) {
                    Locale loc = new Locale("",localeCountry);
                    localeCountry = "" + loc;
                }

                eText.setText("");
                eText2.setText("");
                eText3.setText("");
                fillform(str, str2, str3, localeCountry);
            }
        });

        if (getResources().getDisplayMetrics().widthPixels > getResources().getDisplayMetrics().
                heightPixels) {
            Toast.makeText(this, R.string.land, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.port, Toast.LENGTH_SHORT).show();
        }
    }

    private void fillform(String str, String str2, String str3, String str4) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        if (str.length() == 0)
            alertDialogBuilder.setMessage("No Details to process :-(");
        else {
            alertDialogBuilder.setTitle("Your Details :");
            alertDialogBuilder.setMessage("Name: " + str + "\nAddress: " + str2 + "\nPhone Number: " + str3 + "\n\nYou are accessing this app from " + str4);
        }
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}


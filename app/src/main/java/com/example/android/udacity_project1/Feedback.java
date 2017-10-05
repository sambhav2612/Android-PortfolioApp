package com.example.android.udacity_project1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    String name = "", email = "", message = "";
    EditText eText = null, eText2 = null, eText3 = null;
    Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        if (getResources().getDisplayMetrics().widthPixels > getResources().getDisplayMetrics().
                heightPixels) {
            Toast.makeText(this, R.string.land, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.port, Toast.LENGTH_SHORT).show();
        }

        eText = (EditText) findViewById(R.id.name);
        eText2 = (EditText) findViewById(R.id.email);
        eText3 = (EditText) findViewById(R.id.message);
        btn = (Button) findViewById(R.id.submit);

    }

    public void submitForm(View view) {

        name = "";
        email = "";
        message = "";

        name += eText.getText().toString();
        email += eText2.getText().toString();
        message += eText3.getText().toString() + getString(R.string.new_line) + getString(R.string.sent_by) + getString(R.string.space) + name;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.setType("text/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.putExtra(Intent.EXTRA_CC, email);
        intent.putExtra(Intent.EXTRA_BCC, email);
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.feed));
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(intent);
    }

}


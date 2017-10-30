package com.example.android.udacity_project1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String subject, email, tot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subject = getString(R.string.submit_feedback).trim();
        email = getString(R.string.email).trim();
        tot = getString(R.string.feedback).trim();

        if (getResources().getDisplayMetrics().widthPixels > getResources().getDisplayMetrics().
                heightPixels) {
            Toast.makeText(this, R.string.land, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.port, Toast.LENGTH_SHORT).show();
        }
    }

    public void linkToSourceCode(View view) {
        Uri uri = Uri.parse("https://github.com/sambhav2612/Android-PortfolioApp"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        Toast.makeText(MainActivity.this,"opening the source code in chrome",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void openWebsite(View view) {
        Intent intent = new Intent(this, AboutMe.class);
        startActivity(intent);
    }

    public void fillFeedback(View view) {

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:" + email));

        emailIntent.setType("text/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, tot);

        try {
            startActivity(emailIntent);
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }

        startActivity(emailIntent);
    }
}

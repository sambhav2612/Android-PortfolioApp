package com.example.android.udacity_project1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        Intent intent = new Intent(this, Feedback.class);
        startActivity(intent);
    }
}

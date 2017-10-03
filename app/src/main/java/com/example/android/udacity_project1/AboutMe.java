package com.example.android.udacity_project1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AboutMe extends AppCompatActivity {

    // Get the Intent that started this activity and extract the string
    // Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        if (getResources().getDisplayMetrics().widthPixels > getResources().getDisplayMetrics().
                heightPixels) {
            Toast.makeText(this, R.string.land, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.port, Toast.LENGTH_SHORT).show();
        }
    }

    public void linkToSourceCode(View view) {
        Uri uri = Uri.parse("https://github.com/sambhav2612/android-project1"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        Toast.makeText(AboutMe.this,"opening the source code in chrome",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}

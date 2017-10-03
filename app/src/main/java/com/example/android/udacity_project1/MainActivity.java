package com.example.android.udacity_project1;

import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.AlertDialog;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button quit = (Button) findViewById(R.id.exit);
        quit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"exiting app... thanks for using!",Toast.LENGTH_SHORT).show();
                //Finish method is used to close all open activities.
                SystemClock.sleep(100);
                finish();

            }
        });

        if (getResources().getDisplayMetrics().widthPixels > getResources().getDisplayMetrics().
                heightPixels) {
            Toast.makeText(this, R.string.land, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.port, Toast.LENGTH_SHORT).show();
        }
    }

    public void alertLike(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Tu beer hai boss!");
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void alertNope(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Dafuk, why tho?");
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void alertNotYet(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Mark it down on your weekend binge list! Yes, it's that good :D");
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void openBrowser(View view) {
        Uri uri = Uri.parse("http://tvfplay.com/category/1/series/1"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        Toast.makeText(MainActivity.this,"opening link",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void feedback(View view) {
        Intent intent = new Intent(this, Feedback.class);
        startActivity(intent);
    }

    public void aboutMe(View view) {
        Intent intent = new Intent(this, AboutMe.class);
        startActivity(intent);
    }

}

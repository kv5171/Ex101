package com.example.ex101;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder msgDialog;
    LinearLayout layout;
    Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout)findViewById(R.id.layout);

        rnd = new Random();
    }

    public void startMsgDialog(View view) {
        msgDialog = new AlertDialog.Builder(this);

        msgDialog.setTitle("Hi!");
        msgDialog.setMessage("Its Part 1!");

        AlertDialog ad = msgDialog.create();
        ad.show();
    }

    public void startIconDialog(View view) {
        msgDialog = new AlertDialog.Builder(this);

        msgDialog.setTitle("There is an error!");
        msgDialog.setMessage("Its Part 2!");
        msgDialog.setIcon(R.drawable.close);

        AlertDialog ad = msgDialog.create();
        ad.show();
    }

    public void startBtnDialog(View view) {
        msgDialog = new AlertDialog.Builder(this);

        msgDialog.setTitle("There is an error!");
        msgDialog.setMessage("Its Part 3!");
        msgDialog.setIcon(R.drawable.close);
        msgDialog.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = msgDialog.create();
        ad.show();
    }

    public void startTwoBtnDialog(View view) {
        msgDialog = new AlertDialog.Builder(this);

        msgDialog.setTitle("Background change");
        msgDialog.setMessage("You can to change your background color");
        msgDialog.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                layout.setBackgroundColor(
                        Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            }
        });
        msgDialog.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = msgDialog.create();
        ad.show();
    }

    public void startThreeBtnDialog(View view) {
        msgDialog = new AlertDialog.Builder(this);

        msgDialog.setTitle("Background change");
        msgDialog.setMessage("You can to change your background color");
        msgDialog.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                layout.setBackgroundColor(
                        Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            }
        });
        msgDialog.setNeutralButton("rest", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                layout.setBackgroundColor(Color.WHITE);
            }
        });
        msgDialog.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = msgDialog.create();
        ad.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String title = (String) item.getTitle();

        if (title.equals("Credits"))
        {
            Intent si = new Intent(this, CreditsActivity.class);
            startActivity(si);
        }

        return true;
    }
}
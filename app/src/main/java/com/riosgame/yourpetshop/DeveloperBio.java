package com.riosgame.yourpetshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DeveloperBio extends AppCompatActivity {
    TextView developerbio;
    Button bioatras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_bio);
        developerbio = (TextView) findViewById(R.id.tv_bio);
        bioatras = (Button) findViewById(R.id.btatras);

        Toolbar mytulbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(mytulbar);
        getSupportActionBar().setTitle(null);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        bioatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Intent i = new Intent(DeveloperBio.this, MainActivity.class);
                //startActivity(i);
                finish();
            }
        });
    }
}

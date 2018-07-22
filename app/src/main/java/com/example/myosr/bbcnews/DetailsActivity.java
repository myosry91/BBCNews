package com.example.myosr.bbcnews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    TextView desc, tittle;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        desc = (TextView) findViewById(R.id.text_desc);
        tittle = (TextView) findViewById(R.id.text_title);
        imageView = (ImageView) findViewById(R.id.image_news);

        Intent intent = getIntent();

        desc.setText(intent.getStringExtra("desc"));
        tittle.setText(intent.getStringExtra("title"));
        Picasso.with(getApplicationContext()).load(intent.getStringExtra("image")).into(imageView);


    }

    public void goToBBCLink(View view) {
        Intent intent = getIntent();

        WebView browser = (WebView) findViewById(R.id.web_view);

        browser.loadUrl(intent.getStringExtra("url"));
    }

    public void goToHomePage(View view) {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
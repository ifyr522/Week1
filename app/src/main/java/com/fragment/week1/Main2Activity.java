package com.fragment.week1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView tv3;
    private TextView tv4;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        imageView = (ImageView) findViewById(R.id.imageview);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        tv3.setText(title);
        String content = intent.getStringExtra("content");
        tv4.setText(content);
        int pic = intent.getIntExtra("pic", 0);
        imageView.setImageResource(pic);

    }
}

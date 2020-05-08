package com.example.memory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SelectedAnswer extends AppCompatActivity implements View.OnClickListener {

    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_answer2);

        img1 = (ImageView)findViewById(R.id.bucs);
        img1.setTag(R.drawable.brady_bunch);
        img1.setOnClickListener(this);

        img2 = (ImageView)findViewById(R.id.eagles);
        img2.setTag(R.drawable.eagles);
        img2.setOnClickListener(this);

        img3 = (ImageView)findViewById(R.id.titans);
        img3.setTag(R.drawable.henry);
        img3.setOnClickListener(this);

        img4 = (ImageView)findViewById(R.id.jets);
        img4.setTag(R.drawable.jets);
        img4.setOnClickListener(this);

        img5 = (ImageView)findViewById(R.id.skins);
        img5.setTag(R.drawable.skins);
        img5.setOnClickListener(this);

        img6 = (ImageView)findViewById(R.id.steelers);
        img6.setTag(R.drawable.steel);
        img6.setOnClickListener(this);

        img7 = (ImageView)findViewById(R.id.sea);
        img7.setTag(R.drawable.the12thman);
        img7.setOnClickListener(this);

        img8 = (ImageView)findViewById(R.id.niners);
        img8.setTag(R.drawable.the49ers);
        img8.setOnClickListener(this);

        img9 = (ImageView)findViewById(R.id.eagles2);
        img9.setTag(R.drawable.eagles);
        img9.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        ImageView img = (ImageView)v;

        int img_resource_id = Integer.parseInt(img.getTag().toString());
        intent.putExtra("Answer", img_resource_id);
        setResult(2000, intent);
        finish();
    }
}

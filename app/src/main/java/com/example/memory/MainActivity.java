package com.example.memory;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView questionMark, answerBox;
    Button button;
    Toolbar toolbar;

    int imageArray[] = new int[] {
      R.drawable.brady_bunch,
      R.drawable.eagles,
      R.drawable.henry,
      R.drawable.jets,
      R.drawable.skins,
      R.drawable.steel,
      R.drawable.the12thman,
      R.drawable.the49ers
    };

    int answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Matching Game");
        setSupportActionBar(toolbar);

        questionMark = (ImageView)findViewById(R.id.questionMark);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectedAnswer.class);
                startActivityForResult(intent, 2000);
            }
        });

        img_Rand();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2000)
        {
            int answer_resource_id = data.getIntExtra("Answer", 0);
            answerBox = (ImageView) findViewById(R.id.answerBox);
            answerBox.setImageResource(answer_resource_id);

            if(answer_resource_id == answer)
            {
                Toast.makeText(this, "CONGRATS! You Found a Match!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Sorry, this is not a match! Please try again!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mainMenu:
                img_Rand();
                answerBox = (ImageView)findViewById(R.id.answerBox);
                answerBox.setImageResource(R.drawable.questions);
                break;
        }
        return true;
    }

    private void img_Rand() {
        int image = imageArray[new Random().nextInt(9)];
        questionMark.setImageResource(image);

        answer = image;
    }
}

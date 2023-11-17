package com.example.resepify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

        public class DetailActivity extends AppCompatActivity {

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_detailed);

                Intent intent = getIntent();
                String recipe_name = intent.getStringExtra("recipe_name");
                String recipe_time = intent.getStringExtra("recipe_time");

                TextView nameTextView = findViewById(R.id.detailName);
                TextView timeTextView = findViewById(R.id.detailTime);


                nameTextView.setText(recipe_name);
                timeTextView.setText(recipe_time);
            }
        }

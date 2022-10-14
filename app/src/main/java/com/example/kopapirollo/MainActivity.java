package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView koKep, gepKoKep;
    private Button  koBtn, papirBtn, olloBtn;
    private TextView emberScore, gepScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addEventListeners();
    }

    private void addEventListeners(){



    }

    private void init(){
        koKep = findViewById(R.id.koKep);
        gepKoKep = findViewById(R.id.gepKoKep);
        koBtn = findViewById(R.id.koBtn);
        papirBtn = findViewById(R.id.papirBtn);
        olloBtn = findViewById(R.id.olloBtn);
        emberScore = findViewById(R.id.emberScore);
        gepScore = findViewById(R.id.gepScore);
    }
}
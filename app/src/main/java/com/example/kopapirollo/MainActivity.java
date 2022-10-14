package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView koKep, gepKoKep;
    private Button  koBtn, papirBtn, olloBtn;
    private TextView emberScore, gepScore;
    private int gepValasztas;
    private Random rnd;
    private int gep;
    private int te;
    private AlertDialog.Builder ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addEventListeners();
    }

    private void addEventListeners(){

        koBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rnd = new Random();

                gepValasztas = rnd.nextInt(3)+1;
                switch (gepValasztas){
                    case 1:
                        gepKoKep.setImageResource(R.drawable.rock);
                        break;
                    case 2:
                        gepKoKep.setImageResource(R.drawable.paper);
                        break;
                    case 3:
                        gepKoKep.setImageResource(R.drawable.scissors);
                }

                koKep.setImageResource(R.drawable.rock);

                if(gepValasztas == 1){
                    Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                }else if(gepValasztas == 2){
                    Toast.makeText(MainActivity.this, "Vesztettél", Toast.LENGTH_SHORT).show();
                    gep++;
                    gepScore.setText("Computer: "+ gep);
                }else if(gepValasztas == 3){
                    Toast.makeText(MainActivity.this, "Nyertél", Toast.LENGTH_SHORT).show();
                    te++;
                    emberScore.setText("Ember: "+ te);
                }

                vege();

            }
        });

        papirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rnd = new Random();

                gepValasztas = rnd.nextInt(3)+1;
                switch (gepValasztas){
                    case 1:
                        gepKoKep.setImageResource(R.drawable.rock);
                        break;
                    case 2:
                        gepKoKep.setImageResource(R.drawable.paper);
                        break;
                    case 3:
                        gepKoKep.setImageResource(R.drawable.scissors);
                }

                koKep.setImageResource(R.drawable.paper);

                if(gepValasztas == 1){
                    Toast.makeText(MainActivity.this, "Nyertél", Toast.LENGTH_SHORT).show();
                    te++;
                    emberScore.setText("Ember: "+ te);
                }else if(gepValasztas == 2){
                    Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                }else if(gepValasztas == 3){
                    Toast.makeText(MainActivity.this, "Vesztettél", Toast.LENGTH_SHORT).show();
                    gep++;
                    gepScore.setText("Computer: "+ gep);
                }

                vege();

            }
        });

        olloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rnd = new Random();

                gepValasztas = rnd.nextInt(3)+1;
                switch (gepValasztas){
                    case 1:
                        gepKoKep.setImageResource(R.drawable.rock);
                        break;
                    case 2:
                        gepKoKep.setImageResource(R.drawable.paper);
                        break;
                    case 3:
                        gepKoKep.setImageResource(R.drawable.scissors);
                }

                koKep.setImageResource(R.drawable.scissors);

                if(gepValasztas == 1){
                    Toast.makeText(MainActivity.this, "Vesztettél", Toast.LENGTH_SHORT).show();
                    gep++;
                    gepScore.setText("Computer: "+ gep);
                }else if(gepValasztas == 2){
                    Toast.makeText(MainActivity.this, "Nyertél", Toast.LENGTH_SHORT).show();
                    te++;
                    emberScore.setText("Ember: "+ te);
                }else if(gepValasztas == 3){
                    Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                }

                vege();

            }
        });

    }

    private void vege(){

        if(te == 3){

            ad.setMessage("Szeretne új játékot kezdeni?");
            ad.setTitle("Győzelem");
            ad.setCancelable(false);
            ad.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            ad.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    emberScore.setText("Ember: 0");
                    gepScore.setText("Computer: 0");
                    koKep.setImageResource(R.drawable.rock);
                    gepKoKep.setImageResource(R.drawable.rock);
                    gepValasztas = 0;
                    gep = 0;
                    te = 0;
                }
            });
            ad.create().show();

        }else if( gep == 3){
            ad.setMessage("Szeretne új játékot kezdeni?");
            ad.setTitle("Vereség");
            ad.setCancelable(false);
            ad.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            ad.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    emberScore.setText("Ember: 0");
                    gepScore.setText("Computer: 0");
                    koKep.setImageResource(R.drawable.rock);
                    gepKoKep.setImageResource(R.drawable.rock);
                    gepValasztas = 0;
                    gep = 0;
                    te = 0;
                }
            });
            ad.create().show();
        }

    }

    private void init(){
        koKep = findViewById(R.id.koKep);
        gepKoKep = findViewById(R.id.gepKoKep);
        koBtn = findViewById(R.id.koBtn);
        papirBtn = findViewById(R.id.papirBtn);
        olloBtn = findViewById(R.id.olloBtn);
        emberScore = findViewById(R.id.emberScore);
        gepScore = findViewById(R.id.gepScore);

        gepValasztas = 0;
        gep = 0;
        te = 0;

        ad = new AlertDialog.Builder(MainActivity.this);
    }
}
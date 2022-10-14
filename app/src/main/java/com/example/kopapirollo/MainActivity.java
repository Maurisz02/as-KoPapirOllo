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
    private ImageView  koBtn, papirBtn, olloBtn;
    private TextView emberScore, gepScore, dontetlen;
    private int gepValasztas;
    private Random rnd;
    private int gep;
    private int te;
    private int dontetlenekSzama;
    private AlertDialog.Builder ad;
    private ImageView gHp1, gHp2, gHp3;
    private ImageView[] gHpTomb;
    private ImageView eHp1, eHp2, eHp3;
    private ImageView[] eHpTomb;
    private int gMaxHp;
    private int eMaxHp;

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

                setGepKep();

                koKep.setImageResource(R.drawable.rock);

                if(gepValasztas == 1){
                    Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                    dontetlenekSzama++;
                    dontetlen.setText("Döntetlenek száma: "+ dontetlenekSzama);
                }else if(gepValasztas == 2){
                    Toast.makeText(MainActivity.this, "Vesztettél", Toast.LENGTH_SHORT).show();
                    eletCsokkent("ember");
                    gep++;
                    gepScore.setText("Computer: "+ gep+" ");
                }else if(gepValasztas == 3){
                    Toast.makeText(MainActivity.this, "Nyertél", Toast.LENGTH_SHORT).show();
                    eletCsokkent("gep");
                    te++;
                    emberScore.setText("Ember: "+ te+" ");
                }

                vege();

            }
        });

        papirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setGepKep();

                koKep.setImageResource(R.drawable.paper);

                if(gepValasztas == 1){
                    Toast.makeText(MainActivity.this, "Nyertél", Toast.LENGTH_SHORT).show();
                    eletCsokkent("gep");
                    te++;
                    emberScore.setText("Ember: "+ te+" ");
                }else if(gepValasztas == 2){
                    Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                    dontetlenekSzama++;
                    dontetlen.setText("Döntetlenek száma: "+ dontetlenekSzama);
                }else if(gepValasztas == 3){
                    Toast.makeText(MainActivity.this, "Vesztettél", Toast.LENGTH_SHORT).show();
                    eletCsokkent("ember");
                    gep++;
                    gepScore.setText("Computer: "+ gep+" ");
                }

                vege();

            }
        });

        olloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               setGepKep();

                koKep.setImageResource(R.drawable.scissors);

                if(gepValasztas == 1){
                    Toast.makeText(MainActivity.this, "Vesztettél", Toast.LENGTH_SHORT).show();
                    eletCsokkent("ember");
                    gep++;
                    gepScore.setText("Computer: "+ gep+" ");
                }else if(gepValasztas == 2){
                    Toast.makeText(MainActivity.this, "Nyertél", Toast.LENGTH_SHORT).show();
                    eletCsokkent("gep");
                    te++;
                    emberScore.setText("Ember: "+ te+" ");
                }else if(gepValasztas == 3){
                    Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                    dontetlenekSzama++;
                    dontetlen.setText("Döntetlenek száma: "+ dontetlenekSzama);
                }

                vege();

            }
        });

    }

    private void setGepKep(){
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
                    emberScore.setText("Ember: 0"+ " ");
                    gepScore.setText("Computer: 0"+ " ");
                    dontetlen.setText("Döntetlenek száma: 0");
                    koKep.setImageResource(R.drawable.rock);
                    gepKoKep.setImageResource(R.drawable.rock);
                    gepValasztas = 0;
                    gep = 0;
                    te = 0;
                    dontetlenekSzama = 0;
                    eMaxHp = 3;
                    gMaxHp = 3;
                    gHp1.setImageResource(R.drawable.heart2);
                    gHp2.setImageResource(R.drawable.heart2);
                    gHp3.setImageResource(R.drawable.heart2);
                    eHp1.setImageResource(R.drawable.heart2);
                    eHp2.setImageResource(R.drawable.heart2);
                    eHp3.setImageResource(R.drawable.heart2);

                    gHpTomb = new ImageView[] {gHp1, gHp2, gHp3};
                    eHpTomb = new ImageView[] {eHp1, eHp2, eHp3};
                }
            });
            ad.create().show();
        }

    }

    private void eletCsokkent(String ki){
        if(ki == "ember"){
            if (eMaxHp > 0)
            {
                eMaxHp--;
                eHpTomb[eMaxHp].setImageResource(R.drawable.heart1);
            }
        }else if (ki == "gep"){
            if (gMaxHp > 0)
            {
                gMaxHp--;
                gHpTomb[gMaxHp].setImageResource(R.drawable.heart1);
            }
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
        dontetlen = findViewById(R.id.dontetlen);

        gepValasztas = 0;
        dontetlenekSzama = 0;
        gep = 0;
        te = 0;

        ad = new AlertDialog.Builder(MainActivity.this);

        gHp1 = findViewById(R.id.gHp1);
        gHp2 = findViewById(R.id.gHp2);
        gHp3 = findViewById(R.id.gHp3);
        gHpTomb = new ImageView[] {gHp1, gHp2, gHp3};

        eHp1 = findViewById(R.id.eHp1);
        eHp2 = findViewById(R.id.eHp2);
        eHp3 = findViewById(R.id.eHp3);
        eHpTomb = new ImageView[] {eHp1, eHp2, eHp3};

        eMaxHp = 3;
        gMaxHp = 3;
    }
}
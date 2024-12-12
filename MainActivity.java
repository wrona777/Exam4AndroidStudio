package com.example.eksam4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button throwBtn = findViewById(R.id.throwBtn);
        Button resetScore = findViewById(R.id.resetScore);

        TextView score = findViewById(R.id.scoreLabel);
        TextView gameScore = findViewById(R.id.gameScoreLabel);

        ImageView img1 = findViewById(R.id.imageView6);
        ImageView img2 = findViewById(R.id.imageView7);
        ImageView img3 = findViewById(R.id.imageView8);
        ImageView img4 = findViewById(R.id.imageView9);
        ImageView img5 = findViewById(R.id.imageView10);

        throwBtn.setOnClickListener(new View.OnClickListener() {
            int totalGameScore = 0;
            @Override
            public void onClick(View view) {
                int[] diceImages = {
                        R.drawable.k1,
                        R.drawable.k2,
                        R.drawable.k3,
                        R.drawable.k4,
                        R.drawable.k5,
                        R.drawable.k6
                };

                Random random = new Random();
                int dice1 = random.nextInt(6);
                int dice2 = random.nextInt(6);
                int dice3 = random.nextInt(6);
                int dice4 = random.nextInt(6);
                int dice5 = random.nextInt(6);

                img1.setImageResource(diceImages[dice1]);
                img2.setImageResource(diceImages[dice2]);
                img3.setImageResource(diceImages[dice3]);
                img4.setImageResource(diceImages[dice4]);
                img5.setImageResource(diceImages[dice5]);

                int currentScore = (dice1 + 1) + (dice2 + 1) + (dice3 + 1) + (dice4 + 1) + (dice5 + 1);
                totalGameScore += currentScore;

                score.setText("Wynik tego losowania: " + currentScore);
                gameScore.setText("Wynik gry: " + totalGameScore);
            }
        });

        resetScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setImageResource(R.drawable.question);
                img2.setImageResource(R.drawable.question);
                img3.setImageResource(R.drawable.question);
                img4.setImageResource(R.drawable.question);
                img5.setImageResource(R.drawable.question);

                score.setText("Wynik tego losowania: 0");
                gameScore.setText("Wynik gry: 0");
            }
        });
    }
}
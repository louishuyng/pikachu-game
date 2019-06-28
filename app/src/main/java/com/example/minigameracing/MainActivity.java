package com.example.minigameracing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView score;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;
    ImageButton ibtnPlay;

    int scoreValue = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Reflect();

        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);
        
        score.setText(String.valueOf(scoreValue));

        final CountDownTimer countDownTimer = new CountDownTimer(60000, 150) {
            @Override
            public void onTick(long l) {
                int number = 5;

                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);

                if (skOne.getProgress() >= skOne.getMax()) {
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "ONE WIN", Toast.LENGTH_SHORT).show();

                    if (cbOne.isChecked()) {
                        scoreValue += 10;
                        Toast.makeText(MainActivity.this, "You choose correctly", Toast.LENGTH_SHORT).show();
                    } else {
                        scoreValue -= 5;
                        Toast.makeText(MainActivity.this, "You failed", Toast.LENGTH_SHORT).show();
                    }
                    score.setText(String.valueOf(scoreValue));
                    EnableCheckBox();
                }
                if (skTwo.getProgress() >= skTwo.getMax()) {
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "TWO WIN", Toast.LENGTH_SHORT).show();

                    if (cbTwo.isChecked()) {
                        scoreValue += 10;
                        Toast.makeText(MainActivity.this, "You choose correctly", Toast.LENGTH_SHORT).show();
                    } else {
                        scoreValue -= 5;
                        Toast.makeText(MainActivity.this, "You failed", Toast.LENGTH_SHORT).show();
                    }
                    score.setText(String.valueOf(scoreValue));
                    EnableCheckBox();
                }
                if (skThree.getProgress() >= skThree.getMax()) {
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "THREE WIN", Toast.LENGTH_SHORT).show();

                    if (cbThree.isChecked()) {
                        scoreValue += 10;
                        Toast.makeText(MainActivity.this, "You choose correctly", Toast.LENGTH_SHORT).show();
                    } else {
                        scoreValue -= 5;
                        Toast.makeText(MainActivity.this, "You failed", Toast.LENGTH_SHORT).show();
                    }
                    score.setText(String.valueOf(scoreValue));
                    EnableCheckBox();
                }
                skOne.setProgress(skOne.getProgress() + one);
                skTwo.setProgress(skTwo.getProgress() + two);
                skThree.setProgress(skThree.getProgress() + three);
            }

            @Override
            public void onFinish() {
            }
        };

        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()) {
                    DisableCheckBox();
                    skOne.setProgress(0);
                    skTwo.setProgress(0);
                    skThree.setProgress(0);

                    ibtnPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                } else {
                    Toast.makeText(MainActivity.this, "Please Bet Picachu", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    cbOne.setChecked(false);
                    cbTwo.setChecked(false);
                }
            }
        });
    }

    private void EnableCheckBox() {
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);
    }

    private void DisableCheckBox() {
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
    }

    private void Reflect() {
        score = findViewById(R.id.score);
        ibtnPlay = findViewById(R.id.playbtn);
        cbOne = findViewById(R.id.checkBoxOne);
        cbTwo = findViewById(R.id.checkBoxTwo);
        cbThree = findViewById(R.id.checkBoxThree);
        skOne = findViewById(R.id.seekBarOne);
        skTwo = findViewById(R.id.seekBarTwo);
        skThree = findViewById(R.id.seekBarThree);
    }
}

package com.example.michael.higherlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newDispNumber();
    }

    public void buttonChoice(View view) {
        Button db = (Button) findViewById(R.id.dispNumb);
        int currDispNum = Integer.parseInt((String) db.getText());
        int nextDispNum = newDispNumber();

        if (view.getId() == R.id.higherButton && nextDispNum > currDispNum) {
            Toast.makeText(this, "Higher is Correct!", Toast.LENGTH_SHORT).show();
            Button correctBut = (Button) findViewById(R.id.correct);
            incrementStat(correctBut);
        } else if (view.getId() == R.id.lowerButton && newDispNumber() < currDispNum) {
            Toast.makeText(this, "Lower is Correct!", Toast.LENGTH_SHORT).show();
            Button correctBut = (Button) findViewById(R.id.correct);
            incrementStat(correctBut);
        } else { // Incorrect Answer
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
            Button incorrectBut = (Button) findViewById(R.id.incorrect);
            incrementStat(incorrectBut);
        }

    }

    public int newDispNumber() {
        Random rand = new Random();
        Button dn = (Button) findViewById(R.id.dispNumb);

        int nextDispNum = rand.nextInt(99) + 1;  // Random int between 1-100
        dn.setText(Integer.toString(nextDispNum));
        return nextDispNum;
    }

    public void incrementStat(Button b) {
        String s = (String) b.getText();
        String[] items = s.split(" ");
        items[1] = Integer.toString(Integer.parseInt(items[1]) + 1);

        b.setText(items[0] + " " + items[1]);
    }
}

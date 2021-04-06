package fr.app.kyomi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class GameC extends AppCompatActivity {

    private TextView txt1;
    private Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_c);


        // Game
        this.txt1 = findViewById(R.id.textView1);

        String[]  smileyOne = {"\uD83D\uDE1B", "\uD83D\uDC46", "\uD83D\uDC4B", "\uD83D\uDC45", "\uD83D\uDC40", "\uD83D\uDC8B"};
        String[] smileyTwo = {"\uD83E\uDD50", "\uD83C\uDF2E", "\uD83C\uDF69", "\uD83C\uDF46", "\uD83C\uDF52", "\uD83C\uDF51"};

        this.play = findViewById(R.id.btnPlay);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rdn1;
                rdn1 = (int)(Math.random() * 6);
                int rdn2;
                rdn2 = (int)(Math.random() * 6);

                System.out.println(rdn1);

                txt1.setTextSize(35);
                txt1.setText(smileyOne[rdn1] + "  ➡️  " + smileyTwo[rdn2]);
            }
        });



    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
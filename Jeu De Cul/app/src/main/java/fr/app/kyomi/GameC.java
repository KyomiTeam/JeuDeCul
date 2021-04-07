package fr.app.kyomi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.AttributedString;

public class GameC extends AppCompatActivity {

    private TextView txt1;
    private TextView txtAct;
    private Button play;
    private FloatingActionButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_c);


        // Game
        String player1 = MainActivity.p1.getText().toString();
        System.out.println("Player 1: " + player1);
        String player2 = MainActivity.p2.getText().toString();
        System.out.println("Player 2: " + player2);

        this.txt1 = findViewById(R.id.textView1);
        this.txtAct = findViewById(R.id.textAction);

        String[]  smileyOne = {"\uD83D\uDE1B", "\uD83D\uDC46", "\uD83D\uDC4B", "\uD83D\uDC45", "\uD83D\uDC40", "\uD83D\uDC8B"};
        String[]  action = {"toucher", "regarder", "embrasser", "lécher", "sucer", "claquer"};
        String[] smileyTwo = {"\uD83E\uDD50", "\uD83C\uDF2E", "\uD83C\uDF69", "\uD83C\uDF46", "\uD83C\uDF52", "\uD83C\uDF51"};
        String[]  object = {"lèvres", "fesses", "seins", "couilles", "bite", "chatte"};

        final int[] forPlayer1 = {0};

        this.play = findViewById(R.id.btnPlay);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rdn1;
                rdn1 = (int)(Math.random() * 6);
                int rdn2;
                rdn2 = (int)(Math.random() * 6);

                System.out.println("First Random: " + rdn1 + ", Second: " + rdn2);

                txt1.setTextSize(40);
                txt1.setText(smileyOne[rdn1] + "  ➡️  " + smileyTwo[rdn2]);

                txtAct.setTextSize(17);
                if (forPlayer1[0] == 0 ){
                    //txtAct.setText(player1 + " doit " + action[rdn1] + " le(s)/la " + object[rdn2] + " de " + player2);
                    txtAct.setText(Html.fromHtml("<b>"+player1+"</b> doit <u>" + action[rdn1] + "\n</u> le(s)/la <u>" + object[rdn2] + "</u> de <b>" + player2+"</b>"));
                    forPlayer1[0] = 1;
                } else {
                    //txtAct.setText(player2 + " doit " + action[rdn1] + " le(s)/la " + object[rdn2] + " de " + player1);
                    txtAct.setText(Html.fromHtml("<b>"+player2+"</b> doit <u>" + action[rdn1] + "\n</u> le(s)/la <u>" + object[rdn2] + "</u> de <b>" + player1+"</b>"));
                    forPlayer1[0] = 0;
                }
            }
        });

        this.back = findViewById(R.id.floatingActionButton2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondAct = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(secondAct);
                finish();
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
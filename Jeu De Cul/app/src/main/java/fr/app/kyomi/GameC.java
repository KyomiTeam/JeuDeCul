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
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.AttributedString;
import java.util.Random;

public class GameC extends AppCompatActivity {

    private TextView txt1;
    private TextView txtAct;
    private Button play;
    private FloatingActionButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_c);
        Toast.makeText(getApplicationContext(), "Partie lancée !", Toast.LENGTH_SHORT).show();


        // Game
        String player1 = MainActivity.p1.getText().toString();
        System.out.println("Player 1: " + player1);
        String player2 = MainActivity.p2.getText().toString();
        System.out.println("Player 2: " + player2);

        this.txt1 = findViewById(R.id.textView1);
        this.txtAct = findViewById(R.id.textAction);

        String[]  smileyOne = {"\uD83D\uDC46", "\uD83D\uDC40", "\uD83D\uDC8B", "\uD83D\uDC45", " \uD83D\uDCA6", "\uD83D\uDC4B"};
        String[]  action = {"toucher", "regarder", "embrasser", "lécher", "sucer", "claquer"};
        String[] smileyTwo = {"\uD83C\uDF2E", "\uD83E\uDD65", "\uD83D\uDC44", "\uD83C\uDF51", "\uD83C\uDF52", "\uD83C\uDF46"};
        String[]  object = {"chatte", "seins", "lèvres", "fesses", "couilles", "bite"};

        final int[] forPlayer1 = {0};

        this.play = findViewById(R.id.btnPlay);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rdn1;
                rdn1 = (int)(Math.random() * 6);
                int rdn2;
                //rdn2 = (int)(Math.random() * 6);

                System.out.println("First Random: " + rdn1);

                txt1.setTextSize(40);

                txtAct.setTextSize(17);
                if (forPlayer1[0] == 0 ){
                    rdn2 = new Random().nextInt(4);
                    System.out.println("Second Random: " + rdn2);

                    txt1.setText(smileyOne[rdn1] + "  ➡️  " + smileyTwo[rdn2]);
                    //txtAct.setText(player1 + " doit " + action[rdn1] + " le(s)/la " + object[rdn2] + " de " + player2);
                    txtAct.setText(Html.fromHtml("<b>"+player1+"</b> doit <u>" + action[rdn1] + "</u><br> le(s)/la <u>" + object[rdn2] + "</u> de <b>" + player2+"</b>"));

                    play.setText("A " + player2 + " de jouer !");
                    forPlayer1[0] = 1;
                } else {
                    rdn2 = new Random().nextInt(4)+2;
                    System.out.println("Second Random: " + rdn2);

                    txt1.setText(smileyOne[rdn1] + "  ➡️  " + smileyTwo[rdn2]);
                    //txtAct.setText(player2 + " doit " + action[rdn1] + " le(s)/la " + object[rdn2] + " de " + player1);
                    txtAct.setText(Html.fromHtml("<b>"+player2+"</b> doit <u>" + action[rdn1] + "</u><br> le(s)/la <u>" + object[rdn2] + "</u> de <b>" + player1+"</b>"));

                    play.setText("A " + player1 + " de jouer !");
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
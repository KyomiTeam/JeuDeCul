package fr.app.kyomi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button enter;
    private Button infos;
    public static EditText p1;
    public static EditText p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainv2);

        Toast.makeText(getApplicationContext(), "Jeu de Cul bien lancée...", Toast.LENGTH_SHORT).show();

        this.enter = findViewById(R.id.btnEnter);
        this.p1 = findViewById(R.id.p1);
        this.p2 = findViewById(R.id.p2);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent secondAct = new Intent(getApplicationContext(), GameC.class);
                startActivity(secondAct);
                finish();
            }
        });

        this.infos = findViewById(R.id.btnInfos);

        infos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Indisponible pour le moment.", Toast.LENGTH_SHORT).show();
            }
        });


    }
}


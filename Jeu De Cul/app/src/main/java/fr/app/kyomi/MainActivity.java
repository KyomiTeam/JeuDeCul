package fr.app.kyomi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainv2);

        Toast.makeText(getApplicationContext(), "Jeu de Cul bien lancée...", Toast.LENGTH_SHORT).show();

        this.enter = findViewById(R.id.btnEnter);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondAct = new Intent(getApplicationContext(), GameC.class);
                startActivity(secondAct);
                finish();
            }
        });

    }
}


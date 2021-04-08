package fr.app.kyomi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    private Button enter;
    private Button infos;
    public static EditText p1;
    public static EditText p2;
    private MainActivity activity;
    private  Button login, register;

    // Auto Updater
    private AppUpdateManager mAppUpdateManager;
    private static final int RC_APP_UPDATE = 100;


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
        this.activity = this;

        infos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomPopup customPopup = new CustomPopup(activity);
                customPopup.setTitle("Plus d'infos :", 30);
                customPopup.setSubTitle("Cette application créée par Kyomi (Simon P-B) a pour but de réduire la gène présente avant le rapport et de trouver une approche amusante !" +
                        "\nC'est un jeu uniquement jouable à deux. Il est prévus pour un homme et une femme." +
                        "\n\n----------------Utilisation----------------\n" +
                        "L'algorythme du jeu est prévut pour un homme et une femme. Afin que le jeu fonctionne correctement, veuillez entrer vos noms/pseudos dans le bon emplacement (Garçon/Fille)", 18);
                Toast.makeText(getApplicationContext(), "Infos chargée !", Toast.LENGTH_SHORT).show();
                customPopup.getOkayBtn().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customPopup.cancel();
                    }
                });
                customPopup.build();
            }
        });


        // Update
        mAppUpdateManager = AppUpdateManagerFactory.create(this);
        mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() {
            @Override
            public void onSuccess(AppUpdateInfo result) {
                if (result.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE && result.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)){
                    try {
                        mAppUpdateManager.startUpdateFlowForResult(result, AppUpdateType.FLEXIBLE, MainActivity.this, RC_APP_UPDATE);
                    } catch (IntentSender.SendIntentException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        mAppUpdateManager.registerListener(installStateUpdatedListener);


        // Login / register
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

    }

    private InstallStateUpdatedListener installStateUpdatedListener = new InstallStateUpdatedListener() {
        @Override
        public void onStateUpdate(InstallState state) {
            if (state.installStatus() == InstallStatus.DOWNLOADED){
                showCompletedUpdate();
            }
        }
    };

    @Override
    protected void onStop() {
        if (mAppUpdateManager!=null) mAppUpdateManager.unregisterListener(installStateUpdatedListener);
        super.onStop();
    }

    private void showCompletedUpdate() {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Nouvelle Mise à Jour !", Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("Installer", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAppUpdateManager.completeUpdate();
            }
        });
        snackbar.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == RC_APP_UPDATE && resultCode != RESULT_OK){
            Toast.makeText(this, "Mise à jour annulée !", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    // FireBase
    

}






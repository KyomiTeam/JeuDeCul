package fr.app.kyomi;

import android.app.Activity;
import android.app.Dialog;
import android.widget.Button;
import android.widget.TextView;

public class CustomPopup extends Dialog {

    // Fields
    private String title;
    private String subTitle;
    private Button okayBtn;
    private TextView titleView, subTilteView;

    // Constructeur
    public CustomPopup(Activity activity){
        super(activity, R.style.Theme_AppCompat_DayNight_Dialog);
        setContentView(R.layout.my_popup_template);

        this.title = "Title";
        this.subTitle = "Subtitle";
        this.okayBtn = findViewById(R.id.popOkay);
        this.titleView = findViewById(R.id.popTitle);
        this.subTilteView = findViewById(R.id.popSubtitle);
    }

    public void setTitle(String title, int size) {this.title = title; titleView.setTextSize(size);}
    public void setSubTitle(String subtitle, int size) {this.subTitle = subtitle; subTilteView.setTextSize(size);}
    public Button getOkayBtn() {return okayBtn;}

    public void build(){
        show();
        titleView.setText(title);
        subTilteView.setText(subTitle);
    }
}

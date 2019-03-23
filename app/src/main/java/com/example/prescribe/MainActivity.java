package com.example.prescribe;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private CardView newpres,viewpres,settingspres,creditpres,exitpres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newpres=findViewById(R.id.newbtndId);
        viewpres=findViewById(R.id.viewbtn);
        settingspres=findViewById(R.id.settingsbtn);
        creditpres=findViewById(R.id.creditbtn);
        exitpres=findViewById(R.id.exitbtn);
        OnClicknewpresListener();
        OnClickviewpresListener();
        OnClickexitpresListener();
    }
    public void OnClicknewpresListener(){
        newpres.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Patient_Info.class));
                    }
                }
        );
    }
    public void OnClickviewpresListener(){
        viewpres.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),View_Prescrib.class));
                    }
                }
        );
    }

    public void OnClickexitpresListener(){
        exitpres.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.exit(0);
                    }
                }
        );
    }
}

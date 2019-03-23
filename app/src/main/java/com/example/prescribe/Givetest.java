package com.example.prescribe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Givetest extends AppCompatActivity {
    private static final String[] COUNTRIES = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain","bangladesh"
    };
    ChipGroup testchipgrp;
    AutoCompleteTextView testautotv;
    EditText folloupdatetv,advicetv;
    public static List<String> testList=new ArrayList<>();
    public static String followupdate="",advice="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_givetest);
        testchipgrp=findViewById(R.id.testchipgrp);
        testautotv=findViewById(R.id.testautotv);
        folloupdatetv=findViewById(R.id.folloupdatetv);
        advicetv=findViewById(R.id.advicemultitv);

        ArrayAdapter<String> test_adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, COUNTRIES);
        testautotv.setAdapter(test_adapter);
        OnClicktestaddListener();
        OnClickshareListener();
        OnClicksendviasmsListener();
        //Toast.makeText(getApplicationContext(),followupdate+"  "+advice, Toast.LENGTH_LONG).show();
        try {
            loadchip(testchipgrp,testList);
            folloupdatetv.setText(followupdate);
            advicetv.setText(advice);

        }catch (Exception e)
        {

        }
    }

    public void OnClicktestaddListener(){
        Button  addtest=findViewById(R.id.addtest);
        addtest.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str=testautotv.getText().toString();
                        Chip chip=new Chip(Givetest.this);
                        if(str.length()>0)
                        {
                            chip.setText(str);
                            // chip.setCloseIconVisible(true);
                            chip.setCloseIconEnabled(true);
                            chip.setClickable(false);
                            chip.setCheckable(false);
                            //chip.setChecked(true);
                            chip.setOnCloseIconClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Chip chip=(Chip)v;
                                    testchipgrp.removeView(chip);
                                    testList.remove(chip.getText());
                                }
                            });
                            testchipgrp.addView(chip);
                            testchipgrp.setVisibility(View.VISIBLE);
                            testList.add( testautotv.getText().toString());
                            testautotv.setText("");
                        }
                       /* String temp="";
                        for(String item:testList){
                            temp=temp+item;
                        }
                        Toast.makeText(getApplicationContext(),temp+"", Toast.LENGTH_LONG).show();*/
                    }
                }
        );
    }

    public void loadchip(final ChipGroup chipgrp,List<String>Listdata)
    {
        if(Listdata.size()>0)
        {
            for (int i=0;i<Listdata.size();i++){
                String str=Listdata.get(i).toString();
                Chip chip=new Chip(Givetest.this);
                chip.setText(str);
                // chip.setCloseIconVisible(true);
                chip.setCloseIconEnabled(true);
                chip.setClickable(false);
                chip.setCheckable(false);
                //chip.setChecked(true);
                chip.setOnCloseIconClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Chip chip=(Chip)v;
                        chipgrp.removeView(chip);
                    }
                });
                chipgrp.addView(chip);
                chipgrp.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        followupdate=folloupdatetv.getText().toString();
        advice= advicetv.getText().toString();
       //Toast.makeText(getApplicationContext(),followupdate+"  "+advice, Toast.LENGTH_LONG).show();
    }

    public void OnClickshareListener(){
        Button  sharebtn=findViewById(R.id.sharebtn);
        sharebtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Intent shareIntent=new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("text/plain");
                        String sharebody="Your body here";
                        String shareSub="Your Subject here";
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                        shareIntent.putExtra(Intent.EXTRA_TEXT,sharebody);
                        startActivity(Intent.createChooser(shareIntent,"Share using"));
                    }
                }
        );
    }

    String get_current_date()
    {
        Date c = Calendar.getInstance().getTime();
        //System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);
        return formattedDate;
    }

    public void OnClicksendviasmsListener(){
        Button  sendviasms=findViewById(R.id.smsbtn);
        sendviasms.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), get_current_date()+"",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


}

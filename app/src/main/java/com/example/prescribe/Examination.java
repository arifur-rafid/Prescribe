package com.example.prescribe;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class Examination extends AppCompatActivity {
    private static final String[] Symptom = new String[] {
            "Vomiting", "Fever", "Pain"
    };
    private static final String[] GenExamination = new String[] {
            "Pulse- ", "B/P- ", "Resp- "
    };
    ChipGroup sympchipgrp,exampchipgrp;
    AutoCompleteTextView symptomtv,generalexamtv;
    public static List<String> sympList=new ArrayList<>();
    public static List<String> examineList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examination);
        symptomtv= findViewById(R.id.symptom_autotv);
        generalexamtv = findViewById(R.id.generalexamination_autotv);
        sympchipgrp=findViewById(R.id.sympchipgrp);
        exampchipgrp=findViewById(R.id.exampchipgrp);

        ArrayAdapter<String> symp_adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, Symptom);
        symptomtv.setAdapter(symp_adapter);
        //symptomtv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        ArrayAdapter<String> generalexam_adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, GenExamination);
        generalexamtv.setAdapter(generalexam_adapter);
        //generalexamtv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        OnClicknewpresListener();
        OnClicksympaddListener();
        OnClickexaminepaddListener();
        try {
            loadchip(sympchipgrp,sympList);
            loadchip( exampchipgrp,examineList);
        }catch (Exception e)
        {

        }
    }
    public void OnClicknewpresListener(){
        Button examinationbtn=findViewById(R.id.examinationbtn);
        examinationbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), Prescribe_medicine.class));
                    }
                }
        );
    }
    public void OnClicksympaddListener(){
        Button sympbtn=findViewById(R.id.sympbtn);
        sympbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str=symptomtv.getText().toString();
                        Chip chip=new Chip(Examination.this);
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
                                    sympchipgrp.removeView(chip);
                                    sympList.remove(chip.getText());
                                }
                            });
                            sympchipgrp.addView(chip);
                            sympchipgrp.setVisibility(View.VISIBLE);
                            sympList.add(symptomtv.getText().toString());
                            symptomtv.setText("");
                        }

                       /* String temp="";
                        for(String item:sympList){
                            temp=temp+item;
                        }
                        Toast.makeText(getApplicationContext(),temp+"", Toast.LENGTH_LONG).show();*/
                    }
                }
        );
    }

    public void OnClickexaminepaddListener(){
        Button examinbtn=findViewById(R.id.examinbtn);
        examinbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str=generalexamtv.getText().toString();
                        Chip chip=new Chip(Examination.this);
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
                                    exampchipgrp.removeView(chip);
                                    examineList.remove(chip.getText());
                                }
                            });
                            exampchipgrp.addView(chip);
                            exampchipgrp.setVisibility(View.VISIBLE);
                            examineList.add( generalexamtv.getText().toString());
                            generalexamtv.setText("");
                        }
                         /*  String temp="";
                        for(String item:examineList){
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
                Chip chip=new Chip(Examination.this);
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


}

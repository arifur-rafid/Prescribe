package com.example.prescribe;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Prescribe_medicine extends AppCompatActivity{
    FloatingActionButton addmed;
    Dialog addmeddialogue;
    EditText timetv,durationtv;
    ListView mListView;
    public static List<Medicine> medicineList=new ArrayList<>();
    public static String[] medicinedata=new String[]{
            "napa","ace","ace plus","histacine","paracetamol"};
    MedicineListAdapter m_adapter;
    AutoCompleteTextView automed;
    ArrayAdapter automed_adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);
        addmed=findViewById(R.id.addmed);
        mListView=(ListView)findViewById(R.id.med_listview);
        addmeddialogue=new Dialog(this);
        automed_adp =new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,medicinedata);

        OnClickaddmedListener();
        OnClickaddmedListener();
        OnClickPrescribemedicinenextListener();

        try {
            if (medicineList.size()>0)
            {
                populate_medicine_list();
            }
        }catch (Exception e){

        }

    }

    private void OnClickPrescribemedicinenextListener() {
        Button prescribemednextbtn=findViewById(R.id.presmednxtbtn);
        prescribemednextbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Givetest.class));
                    }
                }
        );
    }

    public void OnClickaddmedListener(){
        addmed.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //startActivity(new Intent(getApplicationContext(),Patient_Info.class));
                        addmeddialogue.setContentView(R.layout.addmedicine);
                        addmeddialogue.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        addmeddialogue.show();
                        automed=(AutoCompleteTextView)addmeddialogue.findViewById(R.id.autoCompleteTextView);
                        automed.setAdapter(automed_adp);
                        OnClickaddmedtolistListener();
                        OnClickaddmedcloseListener();
                    }
                }
        );
    }

    public void OnClickaddmedtolistListener(){
        Button addmedadd=(Button)addmeddialogue.findViewById(R.id.addmedadd);
        addmedadd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addmedtolist();
                        addmeddialogue.dismiss();
                    }
                }
        );
    }

    public void OnClickaddmedcloseListener(){
        Button addmedcancel=(Button)addmeddialogue.findViewById(R.id.addmeddialogcancel);
        addmedcancel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addmeddialogue.dismiss();
                    }
                }
        );
    }

    public void addmedtolist()
    {
        timetv=(EditText)addmeddialogue.findViewById(R.id.time);
        durationtv=(EditText)addmeddialogue.findViewById(R.id.duration);
        String medicine,time,duration;
        medicine=automed.getText().toString();
        time= timetv.getText().toString();
        duration=durationtv.getText().toString();
        Medicine m_data=new Medicine(medicine,time,duration,"xxx");
        medicineList.add(m_data);
        //Toast.makeText(getApplicationContext(),medicineList.get(0)+"", Toast.LENGTH_LONG).show();
        populate_medicine_list();
        //Toast.makeText(getApplicationContext(),medicine+" "+" "+time+" "+duration , Toast.LENGTH_LONG).show();
    }
    void populate_medicine_list()
    {
        m_adapter=new MedicineListAdapter(this,R.layout.adapter_view_layout,medicineList);
        mListView.setAdapter(m_adapter);
    }
}

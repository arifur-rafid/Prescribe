package com.example.prescribe;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Patient_Info extends AppCompatActivity {
    static String patient_name="",patient_ph_no="",patient_age="",patient_weight="",patient_height="",patient_gender="";
    Spinner gender_spin;
    RadioGroup gender_rg;
    RadioButton gender_radbtn;
    static int gender_ID;
    Button pati_info_next;
    TextView pati_name,pati_phn,pati_weight,pati_height,pati_age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__info);
        pati_name=findViewById(R.id.pati_name_tv);
        pati_phn=findViewById(R.id.pati_phntv);;
        pati_weight=findViewById(R.id.pati_weighttv);
        pati_height=findViewById(R.id.pati_highttv);
        pati_age=findViewById(R.id.pati_agetv);

        gender_rg=findViewById(R.id.gender_rg);
        //gender_radbtn=findViewById(gender_ID);
        pati_info_next=findViewById(R.id.pati_info_nextbtn);
        OnClickpati_infoListener();
        set_pati_info();
    }

    void set_pati_info()
    {
        pati_name.setText(patient_name);
        pati_phn.setText(patient_ph_no);
        pati_weight.setText(patient_weight);
        pati_height.setText(patient_height);
        pati_age.setText(patient_age);
        try {
            gender_radbtn=findViewById(gender_ID);
            gender_radbtn.setChecked(true);
        }catch (Exception e){

        }
    }
    public void OnClickpati_infoListener(){
        pati_info_next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gender_ID= gender_rg.getCheckedRadioButtonId();
                        gender_radbtn=findViewById(gender_ID);
                        patient_name= pati_name.getText().toString();
                        patient_ph_no= pati_phn.getText().toString();
                        patient_weight=pati_weight.getText().toString();
                        patient_height=pati_height.getText().toString();
                        patient_age=pati_age.getText().toString();
                        try {
                            patient_gender=gender_radbtn.getText().toString();
                        }catch (Exception e){

                        }
                        if(patient_name.length()==0|| patient_ph_no.length()==0||patient_age.length()==0||patient_gender.length()==0)
                        {
                            if(patient_name.length()==0)Toast.makeText(getApplicationContext(),"Enter Patient Name",Toast.LENGTH_LONG).show();
                            if(patient_ph_no.length()==0)Toast.makeText(getApplicationContext(),"Enter Patient Phone No.",Toast.LENGTH_LONG).show();
                            if(patient_age.length()==0)Toast.makeText(getApplicationContext(),"Enter Patient Age",Toast.LENGTH_LONG).show();
                            if(patient_gender.length()==0)Toast.makeText(getApplicationContext(),"Enter Patient's Gender ",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            startActivity(new Intent(getApplicationContext(),Examination.class));
                        }
                        //Toast.makeText(getApplicationContext(), patient_age.length()+"",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


}

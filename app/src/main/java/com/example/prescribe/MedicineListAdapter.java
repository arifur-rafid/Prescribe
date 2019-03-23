package com.example.prescribe;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import static com.example.prescribe.Prescribe_medicine.medicineList;

public class MedicineListAdapter extends ArrayAdapter<Medicine> {
    private static final String TAG="MedicineListAdapter";
    private Context mContext;
    int mResource;
    public MedicineListAdapter(@NonNull Context context, int resource, @NonNull List<Medicine> objects) {
        super(context, resource, objects);
        mContext =  context;
        mResource=resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        String med_name=getItem(position).getMed_name();
        String time=getItem(position).getTime();
        String duration=getItem(position).getDuration();
        String meal_time=getItem(position).getMeal_time();
        Medicine m=new Medicine(med_name,time,duration,"");

        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView =inflater.inflate(mResource,parent,false);
        TextView tv_med_name=(TextView)convertView.findViewById(R.id.med_name);
        TextView tv_time=(TextView)convertView.findViewById(R.id.time);
        TextView tv_meal=(TextView)convertView.findViewById(R.id.meal);
        TextView tv_duration=(TextView)convertView.findViewById(R.id.duration);

        Button closebtn=convertView.findViewById(R.id.listclosebtn);
        closebtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(medicineList.size()>0)
                        {
                            medicineList.remove(position);
                            notifyDataSetChanged();
                        }

                    }
                }
        );
        tv_med_name.setText(med_name);
        tv_time.setText("Time "+time);
        tv_meal.setText("Meal time "+meal_time);
        tv_duration.setText("Duration "+duration);

        return convertView;
        //return super.getView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Nullable
    @Override
    public Medicine getItem(int position) {
        return super.getItem(position);
    }
}



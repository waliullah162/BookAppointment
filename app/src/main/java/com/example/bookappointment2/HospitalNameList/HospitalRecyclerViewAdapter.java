package com.example.bookappointment2.HospitalNameList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookappointment2.R;

import java.util.List;

public class HospitalRecyclerViewAdapter extends RecyclerView.Adapter<HospitalRecyclerViewAdapter.MyViewHolder> {

private List<HospitalListModelClass>hospitalList;



  public HospitalRecyclerViewAdapter(List<HospitalListModelClass>hospitalList){
      this.hospitalList=hospitalList;
  }

    public class MyViewHolder extends RecyclerView.ViewHolder {

       // public ImageView hospital_imageView;
        public TextView name_textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

           // hospital_imageView=itemView.findViewById(R.id.hospitalImageViewId);
            name_textView=itemView.findViewById(R.id.hospitalNameId);

        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hospital_row,parent,false);

      return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

     HospitalListModelClass hospitalListModelClass=hospitalList.get(position);

     //write down the causes-------*******---------
      holder.name_textView.setText(hospitalListModelClass.getName());
    }

    @Override
    public int getItemCount() {
        return hospitalList.size();
    }


}

package com.example.bookappointment2.HospitalNameList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bookappointment2.MainActivity.MainActivity;
import com.example.bookappointment2.R;

import java.util.ArrayList;
import java.util.List;

public class HospitalRecyclerViewActivity extends AppCompatActivity {

    List<HospitalListModelClass>hospitalList= new ArrayList<>();
    Context context;

    private RecyclerView hospitalRecyclerView;
    private HospitalRecyclerViewAdapter hospitalRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_recycler_view);


        hospitalRecyclerView=findViewById(R.id.hospitalRecyclerViewId);
        hospitalRecyclerViewAdapter=new HospitalRecyclerViewAdapter(hospitalList);

        RecyclerView.LayoutManager mLayoutManager= new LinearLayoutManager(getApplicationContext());

        hospitalRecyclerView.setLayoutManager(mLayoutManager);

        //for preparing data
        prepareData();

        hospitalRecyclerView.setAdapter(hospitalRecyclerViewAdapter);

        hospitalRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, hospitalRecyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        HospitalListModelClass hospital_name=hospitalList.get(position);
                        Intent intent= new Intent(getApplicationContext(), MainActivity.class);

                        //Take text from recyclerViews item positions
                        intent.putExtra("resKey", hospital_name.getName());
                        setResult(2,intent);
                        finish();
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

    }

    public void prepareData(){

        String[] array=getResources().getStringArray(R.array.hospitals_list_string);
        for(String str:array){
            HospitalListModelClass item=new HospitalListModelClass(str);
            hospitalList.add(item);
        }

    }
}

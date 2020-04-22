package com.example.bookappointment2.HospitalLocations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.bookappointment2.MainActivity.MainActivity;
import com.example.bookappointment2.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListViewActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private ExpandableListViewAdapter expandableListViewAdapter;

    List<String>listDataGroup;
    HashMap<String,List<String>>listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);



        initViews();

        initListener();

        initObject();

        initListData();

    }


    private void initViews(){

        expandableListView=findViewById(R.id.expandableListViewId);


    }

    private void initListener(){


        //child click listener

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                String childText= (String) expandableListViewAdapter.getChild(i,i1);
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);

                //for passing the childText

                intent.putExtra("expChildKey",childText);
                setResult(1,intent);
                finish();

                return false;
            }
        });


        //group expand listener
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {


            }
        });


        //group collasp listener

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {

            }
        });

    }


    private void initObject(){


        listDataGroup= new ArrayList<>();
        listDataChild= new HashMap<>();

        expandableListViewAdapter= new ExpandableListViewAdapter(getApplicationContext(),listDataGroup,listDataChild);

        expandableListView.setAdapter(expandableListViewAdapter);

    }


    private void initListData(){


        //Adding group data

        listDataGroup.add("Dhaka");
        listDataGroup.add("Chittangong");
        listDataGroup.add("Rajshahi");
        listDataGroup.add("Sylhet");
        listDataGroup.add("Rangpur");
        listDataGroup.add("Barisal");
        listDataGroup.add("Khulna");
        listDataGroup.add("Mymensingh");



      //array of string

        String[] array;



       //All district of Dhaka division

        List<String>districts_of_dhaka=new ArrayList();

        array=getResources().getStringArray(R.array.district_of_dhaka_string);

        for(String item : array){
            districts_of_dhaka.add(item);
        }


        //All district of Chittaganj


        List<String>districts_of_chittagong=new ArrayList();

        array=getResources().getStringArray(R.array.district_of_chittagong_string);

        for(String item : array){
            districts_of_chittagong.add(item);
        }



        // All district of Rajshahi

        List<String>districts_of_rajshahi=new ArrayList();

        array=getResources().getStringArray(R.array.district_of_rajshahi_string);

        for(String item : array){
            districts_of_rajshahi.add(item);
        }




        //All district of sylhet


        List<String>districts_of_sylhet=new ArrayList();

        array=getResources().getStringArray(R.array.district_of_sylhet_string);

        for(String item : array){
            districts_of_sylhet.add(item);
        }



        //All district of Rangpur


        List<String>districts_of_rangpur=new ArrayList();

        array=getResources().getStringArray(R.array.district_of_rangpur_string);

        for(String item : array){
            districts_of_rangpur.add(item);
        }

        //All district of Barisal


        List<String>districts_of_barisal=new ArrayList();

        array=getResources().getStringArray(R.array.district_of_barisal_string);

        for(String item : array){
            districts_of_barisal.add(item);
        }



        //All district of Khulna


        List<String>districts_of_khulna=new ArrayList();

        array=getResources().getStringArray(R.array.district_of_khulna_string);

        for(String item : array){
            districts_of_khulna.add(item);
        }


        //All district of mymensingh


        List<String>districts_of_mymensingh=new ArrayList();

        array=getResources().getStringArray(R.array.district_of_mymensingh_string);

        for(String item : array){
            districts_of_mymensingh.add(item);
        }


        //Adding child data

        listDataChild.put(listDataGroup.get(0),districts_of_dhaka);
        listDataChild.put(listDataGroup.get(1),districts_of_chittagong);
        listDataChild.put(listDataGroup.get(2),districts_of_rajshahi);
        listDataChild.put(listDataGroup.get(3),districts_of_sylhet);
        listDataChild.put(listDataGroup.get(4),districts_of_rangpur);
        listDataChild.put(listDataGroup.get(5),districts_of_barisal);
        listDataChild.put(listDataGroup.get(6),districts_of_khulna);
        listDataChild.put(listDataGroup.get(7),districts_of_mymensingh);


        expandableListViewAdapter.notifyDataSetChanged();

    }


}

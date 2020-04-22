package com.example.bookappointment2.MainActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookappointment2.HospitalLocations.ExpandableListViewActivity;
import com.example.bookappointment2.HospitalNameList.HospitalRecyclerViewActivity;
import com.example.bookappointment2.R;
import com.example.bookappointment2.SearchAvailabeDoctorDatabase.MyDatabaseHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TextView textView;
    private Button locationBtn, hospitalBtn, specialitiesBtn, dateBtn;
    Intent intent;

    //Database

    MyDatabaseHelper myDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        toolbar=findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);

       textView=toolbar.findViewById(R.id.toolbar_title);


       //Adding back button to the toolbar

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        //btn find

        locationBtn=findViewById(R.id.locationBtnId);
        hospitalBtn=findViewById(R.id.hospitalBtnId);
        specialitiesBtn=findViewById(R.id.specialitiesBtnId);
        dateBtn=findViewById(R.id.dateBtnId);


        locationBtn.setOnClickListener(this);
        hospitalBtn.setOnClickListener(this);
        specialitiesBtn.setOnClickListener(this);
        dateBtn.setOnClickListener(this);


        //object creation of my database helper

        //Context

        myDatabaseHelper=new MyDatabaseHelper(this);

        SQLiteDatabase sqLiteHelper=myDatabaseHelper.getWritableDatabase();






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            //back button id
            case android.R.id.home:
                this.finish();

                //actions in menu
            case R.id.action_refresh:
                Toast.makeText(this,"Refresh Selected",Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_settings:
                Toast.makeText(this,"Settings Selected", Toast.LENGTH_SHORT).show();
                break;

                default:
                    break;

        }
        return true;
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.locationBtnId :
                intent=new Intent(MainActivity.this, ExpandableListViewActivity.class);
                startActivityForResult(intent,1);
                break;

            case R.id.hospitalBtnId:
                intent=new Intent(MainActivity.this, HospitalRecyclerViewActivity.class);
                startActivityForResult(intent,2);
                break;
                //default:

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode==1){
            String value=data.getStringExtra("expChildKey");
            locationBtn.setText(value);
        }
        else if(requestCode==2){
            String value=data.getStringExtra("resKey");
            hospitalBtn.setText(value);
        }

    }
}

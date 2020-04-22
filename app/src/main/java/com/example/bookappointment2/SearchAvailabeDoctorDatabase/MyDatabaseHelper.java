package com.example.bookappointment2.SearchAvailabeDoctorDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {



// Database Version
    private static final int DATABASE_VERSION=10;

    //Database Name

    private static final String DATABASE_NAME="DoctorAppointment.db";

    //Table Name

    private static final String TABLE_DOCTOR="Doctor_Table";
    private static final String TABLE_HOSPITAL="Hospital_Table";
    private static final String TABLE_Appointment="Appointment_Table";
    private static final String TABLE_PATIENT="Patient_Table";

    //Doctor Table Column name
    private static final String Dr_Id="_did";
    private static final String Dr_Name="dr_name";
    private static final String Dr_specialities="dr_specialities";
    private static final String Abailabe_date="abailable_date";
    private static final String Chamber="chamber";


    //Hospital Table Column name
    private static final String Hospital_Id="hospital_id";
    private static final String Hospital_Name="hospital_name";
    private static final String Hospital_Location="location";


    //Appointment Table column name

    private static final String App_id="app_id";
    private static final String Patient_id="patient_id";
    //private static final String Dr_Id="dr_id";
   // private static final String Hospital_Id="hospital_id";
    private static final String App_date_time="app_date_tiem";


    //Context

    Context context;

    //Create Table statement

    //Create Doctor Table

    private static final String CREATE_TABLE_DOCTOR= "CREATE TABLE"+TABLE_DOCTOR+"("+Dr_Id+"INTEGER PRIMARY KEY AUTO INCREMENT,"+Dr_Name+"VARCHAR(255),"
            +Dr_specialities+"VARCHAR(255),"+Abailabe_date+"VARCHAR(20),"+Chamber+"VARCHAR(220)"+")";


    //Create Hospital Table


    private static final String CREATE_TABLE_HOSPITAL= "CREATE TABLE"+TABLE_HOSPITAL+"("+Hospital_Id+"INTEGER PRIMARY KEY AUTO INCREMENT,"+Hospital_Name+"VARCHAR(255),"
            +Hospital_Location+"VARCHAR(255)"+")";

  //Create Appointment Table

    private static final String CREATE_TABLE_Appointment= "CREATE TABLE"+TABLE_Appointment+"("+App_id+"INTEGER PRIMARY KEY AUTO INCREMENT,"+Patient_id+"VARCHAR(255),"
            +Dr_Id+"INTEGER,"+Hospital_Id+"VARCHAR(20),"+App_date_time+"VARCHAR(220)"+")";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

       try{

           Toast.makeText(context,"On create is called",Toast.LENGTH_LONG).show();

           //Create required Table
           sqLiteDatabase.execSQL(TABLE_DOCTOR);
           sqLiteDatabase.execSQL(TABLE_HOSPITAL);
           sqLiteDatabase.execSQL(TABLE_Appointment);
        }catch (Exception e){
           Toast.makeText(context,"Exception"+e,Toast.LENGTH_LONG).show();

       }


    }

    //i-old versions
    //i1-new version
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //on upgrade drop olders table


        try{

            Toast.makeText(context,"On upgrade is called",Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_DOCTOR);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_HOSPITAL);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_Appointment);

        } catch(Exception e){

            Toast.makeText(context,"Exception"+e,Toast.LENGTH_LONG).show();
        }


        onCreate(sqLiteDatabase);


    }

    public long insertData(String drName, String drSpecial, String abailDate,String chamber, String hosName, String hosLocation, String AppDateTime){

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Dr_Name,drName);
        values.put(Dr_specialities,drSpecial);
        values.put(Abailabe_date,abailDate);
        values.put(Chamber,chamber);
        values.put(Hospital_Name,hosName);
        values.put(Hospital_Location,hosLocation);
        values.put(App_date_time,AppDateTime);

        long rowId=sqLiteDatabase.insert(TABLE_DOCTOR,null,values);

        return rowId;
    }















}

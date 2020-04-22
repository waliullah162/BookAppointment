package com.example.bookappointment2.HospitalNameList;

public class HospitalListModelClass {



    private String name;

    // hospital_imageView;

    HospitalListModelClass(){

    }


    HospitalListModelClass(String name){

        this.name=name;

    }


    public String getName(){

        return name;
    }

    public void setName(String name){
        this.name=name;
    }



}

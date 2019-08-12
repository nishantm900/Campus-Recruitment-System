package com.example.nishant.campusreruitmentsystem;

public class ModelClass {
    //////////Student Data/////
    public String name;
    public String email;
    public String cgpa;
    public String age;
    public String bio;

    ///////////type for activity//////////
    public String type;

    /////////////Company Data//////////////

    public String compName;
    public String compAdd;
    public String compAbout;
    /////////////////////////////

    public ModelClass(String name, String email, String CGPA, String AGE, String BIO, String type){}

    public ModelClass(String compName, String compAdd, String compAbout, String type){
        this.compName = compName;
        this.compAdd = compAdd;
        this.compAbout = compAbout;
        this.type = type;

    }


}

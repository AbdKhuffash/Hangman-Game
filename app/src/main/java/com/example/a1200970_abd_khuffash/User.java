package com.example.a1200970_abd_khuffash;


import java.io.Serializable;

public class User implements Serializable {

    private int Id;
    private String fName;
    private String lName;
    private int Tries=6;

    public User(int id, String fName, String lName) {
        Id = id;
        this.fName = fName;
        this.lName = lName;

    }

    public User() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getTries() {
        return Tries;
    }

    public void setTries(int tries) {
        Tries = tries;
    }

    @Override
    public String toString() {
        return fName+" "+lName + "\n" +Id;
    }
}

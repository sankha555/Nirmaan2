
package com.nirmaan_bits.nirmaan;

public class Contact {


    private String name;
    private String year;
    private String num;
    private String pl;

    public Contact(String mName, String mYear, String mContact, String pl) {
        this.name = mName;
        this.year = mYear;
        this.num = mContact;
        this.pl = pl;


    }

    public Contact(String mName) {

    }

    public String getmName() {
        return name;
    }

    public void setmName(String mName) {
        this.name = mName;
    }

    public String getmYear() {
        return year;
    }

    public void setmYear(String mYear) {
        this.year = mYear;
    }

    public String getmContact() {
        return num;
    }

    public void setmContact(String mContact) {
        this.num = mContact;
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    public  Contact(){}
}


package com.wise.tailorshome1;

import android.app.Application;

/**
 * Created by harsh on 3/19/2018.
 */

public class Global extends Application {
    private static String EMAIL;

    public String getemail() {
        return EMAIL;
    }

    public void setemail(String someVariable) {
        EMAIL = someVariable;
    }
}

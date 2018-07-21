package com.wise.tailorshome1;

/**
 * Created by harsh on 7/18/2018.
 */

public class ordersGetterSetter {
    private String oid;
    private String odate, otime;

    public ordersGetterSetter(String oid, String odate, String otime) {
        this.oid = oid;
        this.odate = odate;
        this.otime = otime;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOdate() {
        return odate;
    }

    public void setOdate(String odate) {
        this.odate = odate;
    }

    public String getOtime() {
        return otime;
    }

    public void setOtime(String otime) {
        this.otime = otime;
    }
}


package com.ssw.bnk.swint.jdbc.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OpgEnt_notify {

    private String uniqid;
    private String status;

   
    public OpgEnt_notify() {
        super();
    }

   
    public OpgEnt_notify(String uniqid, String status) {
        this.uniqid = uniqid;
        this.status = status;
    }


    public String getUniqid() {
        return uniqid;
    }

    public void setUniqid(String uniqid) {
        this.uniqid = uniqid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
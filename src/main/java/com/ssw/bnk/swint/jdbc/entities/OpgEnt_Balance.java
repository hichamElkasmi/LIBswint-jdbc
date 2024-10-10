/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssw.bnk.swint.jdbc.entities;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author S2M
 */

@Getter @Setter
public class OpgEnt_Balance {
    
    public String available;
    public String currency;

    public OpgEnt_Balance(String available, String currency) {
        this.available = available;
        this.currency = currency;
    }

    public OpgEnt_Balance() {
    }
    
    
    
    
    
    
}

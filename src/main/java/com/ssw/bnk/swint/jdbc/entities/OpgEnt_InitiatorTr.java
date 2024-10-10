/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssw.bnk.swint.jdbc.entities;

import java.util.Date;

/**
 *
 * @author S2M
 */
public class OpgEnt_InitiatorTr {

    public String account;
    public String numberOfTransaction;
    public String startDate;
    public String endDate;
    public String transactionNumber;

    public OpgEnt_InitiatorTr(String account, String numberOfTransaction, String startDate, String endDate, String transactionNumber) {
        this.account = account;
        this.numberOfTransaction = numberOfTransaction;
        this.startDate = startDate;
        this.endDate = endDate;
        this.transactionNumber = transactionNumber;
    }

    public OpgEnt_InitiatorTr() {
    }

    public String getAccount() {
        return account;
    }

    public String getNumberOfTransaction() {
        return numberOfTransaction;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setNumberOfTransaction(String numberOfTransaction) {
        this.numberOfTransaction = numberOfTransaction;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

}

package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_AtmMonitoring {
	private String atm_group;
	private String atm_mode;
	private String terminal;
	private String institution;

    public OpgEnt_AtmMonitoring(String atm_group, String atm_mode, String terminal, String institution) {
        this.atm_group = atm_group;
        this.atm_mode = atm_mode;
        this.terminal = terminal;
        this.institution = institution;
    }

    public String getAtm_group() {
        return atm_group;
    }

    public String getAtm_mode() {
        return atm_mode;
    }

    public String getTerminal() {
        return terminal;
    }

    public String getInstitution() {
        return institution;
    }

    public void setAtm_group(String atm_group) {
        this.atm_group = atm_group;
    }

    public void setAtm_mode(String atm_mode) {
        this.atm_mode = atm_mode;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    @Override
    public String toString() {
        return "OpgEnt_AtmMonitoring{" + "atm_group=" + atm_group + ", atm_mode=" + atm_mode + ", terminal=" + terminal + ", institution=" + institution + '}';
    }

}

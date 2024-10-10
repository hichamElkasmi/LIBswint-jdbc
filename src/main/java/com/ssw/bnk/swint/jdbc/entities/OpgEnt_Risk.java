package com.ssw.bnk.swint.jdbc.entities;

public class OpgEnt_Risk {

	private String risk_code;
	private String periodicity_id;
	private String periodicity_code;
	private String transaction_type;
	private String transaction_mode;
	private String tans_max;
	private String mnt_limite;
	private String limite_number;
	private String internet;
	private String domain_type;
	private String Status;
        
        public OpgEnt_Risk() {
        }
        
	public OpgEnt_Risk(String risk_code, String periodicity_id, String periodicity_code, String transaction_type,
			String transaction_mode, String tans_max, String mnt_limite, String limite_number) {
		super();
		this.risk_code = risk_code;
		this.periodicity_id = periodicity_id;
		this.periodicity_code = periodicity_code;
		this.transaction_type = transaction_type;
		this.transaction_mode = transaction_mode;
		this.tans_max = tans_max;
		this.mnt_limite = mnt_limite;
		this.limite_number = limite_number;
	}

	public String getRisk_code() {
		return risk_code;
	}

	public void setRisk_code(String risk_code) {
		this.risk_code = risk_code;
	}

	public String getPeriodicity_id() {
		return periodicity_id;
	}

	public void setPeriodicity_id(String periodicity_id) {
		this.periodicity_id = periodicity_id;
	}

	public String getPeriodicity_code() {
		return periodicity_code;
	}

	public void setPeriodicity_code(String periodicity_code) {
		this.periodicity_code = periodicity_code;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public String getTransaction_mode() {
		return transaction_mode;
	}

	public void setTransaction_mode(String transaction_mode) {
		this.transaction_mode = transaction_mode;
	}

	public String getTans_max() {
		return tans_max;
	}

	public void setTans_max(String tans_max) {
		this.tans_max = tans_max;
	}

	public String getMnt_limite() {
		return mnt_limite;
	}

	public void setMnt_limite(String mnt_limite) {
		this.mnt_limite = mnt_limite;
	}

	public String getLimite_number() {
		return limite_number;
	}

	public void setLimite_number(String limite_number) {
		this.limite_number = limite_number;
	}

        public String getInternet() {
            return internet;
        }

        public String getDomain_type() {
            return domain_type;
        }

        public String getStatus() {
            return Status;
        }

        public void setInternet(String internet) {
            this.internet = internet;
        }

        public void setDomain_type(String domain_type) {
            this.domain_type = domain_type;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }
        
	@Override
	public String toString() {
		return "OpgEnt_Risk [risk_code=" + risk_code + ", periodicity_id=" + periodicity_id + ", periodicity_code="
				+ periodicity_code + ", transaction_type=" + transaction_type + ", transaction_mode=" + transaction_mode
				+ ", tans_max=" + tans_max + ", mnt_limite=" + mnt_limite + ", limite_number=" + limite_number + "]";
	}

}

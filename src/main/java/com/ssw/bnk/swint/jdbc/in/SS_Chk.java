package com.ssw.bnk.swint.jdbc.in;

import static com.ssw.bnk.swint.jdbc.in.SS_Df.*;
import com.ssw.bnk.swint.jdbc.entities.*;

/*
 *
 *
 * @author MOKHLISS
 */
public class SS_Chk {

	private String codeErreur;
	private String msgErreur;

	private final short LEN_CODE_20 = 20;
	private final short LEN_MAC_200 = 200;
	private final short LEN_ID_40 = 40;
	private final short LEN_ACC_24 = 24;
	public static final short LEN_MXTRX = 99;

	private final short LEN_nameoncard_24 = 24;
	private final short LEN_firstname_40 = 40;
	private final short LEN_middlename_40 = 40;
	private final short LEN_lastname_40 = 40;
	private final short LEN_firstnamear_40 = 40;
	private final short LEN_middlenamear_40 = 40;
	private final short LEN_lastnamear_40 = 40;
	private final short LEN_customertype_1 = 1;
	private final short LEN_accounttype_1 = 1;
	private final short LEN_autoreload_1 = 1;
	private final short LEN_customeraddress_80 = 80;
	private final short LEN_phonenumber_20 = 20;
	private final short LEN_nationalid_20 = 20;
	private final short LEN_operation_20 = 6;

	private final short LEN_applicationid_24 = 24;
	private final short LEN_action_1 = 1;

	private final short LEN_customerid_24 = 24;
	private final short LEN_typeaccount_1 = 1;
	private final short LEN_bankaccounttype_10 = 10;
	private final short LEN_gender_1 = 1;
	private final short LEN_birthdatelocation_40 = 40;
	private final short LEN_corporatename_25 = 25;
	private final short LEN_zipaddress_5 = 5;
	private final short LEN_fax_19 = 19;
	private final short LEN_reloadaccountnumber_24 = 24;

	public String code() {
		return codeErreur;
	}

	public String msg() {
		return msgErreur;
	}

	public boolean checkDataAuth(OpgEnt_Header header) {
		if (header == null) {
			codeErreur = SS_Df.ccode(ENT_HEADER_NULL);
			msgErreur = SS_Df.cmsg(ENT_HEADER_NULL);
			return false;
		} else {
			return checkStringEmpty(header.getMac(), HEAD_MAC_EMPTY)
					&& checkStringLenght(header.getMac(), LEN_MAC_200, HEAD_MAC_LENGHT)
					&& checkStringEmpty(header.getIdmsg(), HEAD_ID_EMPTY)
					&& checkStringLenght(header.getIdmsg(), LEN_ID_40, HEAD_ID_LENGHT);
		}
	}

	public boolean checkStringEmpty(String str, int idMsg) {

		if (!isFilled(str)) {
			codeErreur = SS_Df.ccode(idMsg);
			msgErreur = SS_Df.cmsg(idMsg);
			return false;
		}
		return true;
	}

	public boolean isFilled(String str) {

		return (str != null) && (!str.isEmpty());
	}

	public boolean checkStringLenght(String str, int len, int idMsg) {
		try {
			if (str.length() > len) {
				codeErreur = SS_Df.ccode(idMsg);
				msgErreur = SS_Df.cmsg(idMsg);
				return false;
			}
		} catch (Exception e) {
			codeErreur = SS_Df.ccode(idMsg);
			msgErreur = SS_Df.cmsg(idMsg);
			return false;
		}
		return true;
	}

	public boolean checkDataAccount(String accountNbr) {
		return checkStringEmpty(accountNbr, ACCOUNT_EMPTY) && checkStringLenght(accountNbr, LEN_ACC_24, ACCOUNT_LENGHT)
				&& checkNumericString(accountNbr, ACCOUNT_VALUE);
	}

	public boolean checkDataBranch(String branchCode) {
		return checkStringEmpty(branchCode, BRANCH_EMPTY) && checkStringLenght(branchCode, LEN_CODE_20, BRANCH_LENGHT)
				&& checkNumericString(branchCode, BRANCH_VALUE);
	}

	public boolean checkDataStatus(String status) {
		return checkStringEmpty(status, STATUS_EMPTY);
	}

	// Format MM/YY
	public boolean checkDataExpiry(String expiry) {
		return checkStringEmpty(expiry, EXPIRY_EMPTY) && checkDateFormat(expiry, EXPIRY_FORMAT);
	}

	// Format DD/MM/YYYY
	public boolean checkDataBirthdate(String birthdate) {
		return checkStringEmpty(birthdate, BIRTH_DATE_EMPTY) && checkDateFormat2(birthdate, BIRTH_DATE_FORMAT);
	}

	public boolean checkDataCard(String card) {
		return checkStringEmpty(card, CARD_EMPTY) && checkNumericString(card, CARD_NUM);
	}

	public boolean checkDataData(String data) {
		return checkStringEmpty(data, DATA_EMPTY);
	}

	public boolean checkDataNewpan(String newPan) {
		return checkStringEmpty(newPan, NEW_PAN_EMPTY);
	}
        public boolean checkDataDebitprogramcode(String debitprogramcode) {
		return checkNumericString(debitprogramcode, DEBIT_PROGRAM_NUM)
				&& checkStringEmpty(debitprogramcode, DEBIT_PROGRAM_EMPTY);
	}

	public boolean checkDataInstitution(String institution) {
		return checkStringEmpty(institution, INSTITUTION) && checkNumericString(institution, INSTITUTION_NUM);
	}

	public boolean checkDataPinGeneration(String pinGeneration) {
		return checkStringEmpty(pinGeneration, PIN_GENERATION);
	}

	public boolean checkDataReplacementReason(String replacementRes) {
		return checkStringEmpty(replacementRes, REPLACEMENT_REASON_EMPTY);
	}

	public boolean checkResponseEmpty(String response) {
		return checkStringEmpty(response, PACKAGE_NON_COMPILE);
	}

	public boolean checkDataStartNumeric(String start) {
		return checkNumericString(start, START);
	}

	public boolean checkDataEndNumeric(String end) {
		return checkNumericString(end, END);
	}

	public boolean compareTwoNumber(String start, String end) {

		
		int startInt, endInt;
		
		if (start.equals(" ") || start.isEmpty() || end.equals(" ") || end.isEmpty() )
			return true;

		startInt = Integer.parseInt(start);
		endInt = Integer.parseInt(end);

		try {
			if (startInt > endInt) {
				codeErreur = SS_Df.ccode(START_COMPARE_END);
				msgErreur = SS_Df.cmsg(START_COMPARE_END);
				return false;
			}

		} catch (Exception e) {
			codeErreur = SS_Df.ccode(START_COMPARE_END);
			msgErreur = SS_Df.cmsg(START_COMPARE_END);
			return false;
		}

		return true;
	}

	public boolean checkDataNameoncard(String nameoncard) {
		return checkStringEmpty(nameoncard, NAME_ON_CARD_EMPTY)
				&& checkStringLenght(nameoncard, LEN_nameoncard_24, NAME_ON_CARD_LENGHT);
	}

	public boolean checkDataFirstname(String firstname) {
		return checkStringEmpty(firstname, FISRT_NAME_EMPTY)
				&& checkStringLenght(firstname, LEN_firstname_40, FIRST_NAME_LENGHT);
	}

	public boolean checkDataMiddlename(String middlename) {
		return checkStringEmpty(middlename, MIDDLE_NAME_EMPTY)
				&& checkStringLenght(middlename, LEN_middlename_40, MIDDLE_NAME_LENGHT);
	}

	public boolean checkDataLastname(String lastname) {
		return checkStringEmpty(lastname, LAST_NAME_EMPTY)
				&& checkStringLenght(lastname, LEN_lastname_40, LAST_NAME_LENGHT);
	}

	public boolean checkDataFirstnamear(String firstnamear) {
		return checkStringEmpty(firstnamear, FIRST_NAME_AR_EMPTY)
				&& checkStringLenght(firstnamear, LEN_firstnamear_40, FIRST_NAME_AR_LENGHT);
	}

	public boolean checkDataMiddlenamear(String middlenamear) {
		return checkStringEmpty(middlenamear, MIDDLE_NAME_AR_EMPTY)
				&& checkStringLenght(middlenamear, LEN_middlenamear_40, MIDDLE_NAME_AR_LENGHT);
	}

	public boolean checkDataLastnamear(String lastnamear) {
		return checkStringEmpty(lastnamear, LAST_NAME_AR_EMPTY)
				&& checkStringLenght(lastnamear, LEN_lastnamear_40, LAST_NAME_AR_LENGHT);
	}

	public boolean checkDataCustomertype(String customertype) {
		return checkStringEmpty(customertype, CUSTOMER_TYPE_EMPTY)
				&& checkStringLenght(customertype, LEN_customertype_1, CUSTOMER_TYPE_LENGHT);
	}

	public boolean checkDataAccounttype(String accounttype) {
		return checkStringEmpty(accounttype, ACCOUNT_TYPE_EMPTY)
				&& checkStringLenght(accounttype, LEN_accounttype_1, ACCOUNT_TYPE_LENGHT);
	}

	public boolean checkDataAutoreload(String autoreload) {
		return checkStringEmpty(autoreload, AUTO_RELOAD_EMPTY)
				&& checkStringLenght(autoreload, LEN_autoreload_1, AUTO_RELOAD_LENGHT);
	}

	public boolean checkDataCustomeraddress(String customeraddress) {
		return checkStringEmpty(customeraddress, CUSTOMER_ADDRESS_EMPTY)
				&& checkStringLenght(customeraddress, LEN_customeraddress_80, CUSTOMER_ADDRESS_LENGHT);
	}

	public boolean checkDataPhonenumber(String phonenumber) {
		return checkStringEmpty(phonenumber, PHONE_NUMBER_EMPTY)
				&& checkStringLenght(phonenumber, LEN_phonenumber_20, PHONE_NUMBER_LENGHT);
	}

	public boolean checkDataNationalid(String nationalid) {
		return checkStringEmpty(nationalid, NATIONAL_ID_EMPTY)
				&& checkStringLenght(nationalid, LEN_nationalid_20, NATIONAL_ID_LENGHT);
	}

	public boolean checkDataOperation(String operation) {
		return checkStringEmpty(operation, OPERATION_EMPTY)
				&& checkStringLenght(operation, LEN_operation_20, OPERATION_LENGHT);
	}

	public boolean checkDataNationalidtype(String nationalidtype) {
		return checkNumericString(nationalidtype, NATIONAL_ID_TYPE_NUM)
				&& checkStringEmpty(nationalidtype, NATIONAL_ID_TYPE_EMPTY);
	}

	public boolean checkDataBankcode(String bankcode) {
		return checkNumericString(bankcode, BANK_CODE_NUM) && checkStringEmpty(bankcode, BANK_CODE_EMPTY);
	}

	public boolean checkDataCurrencycode(String currencycode) {
		return checkNumericString(currencycode, CURRENCY_CODE_NUM)
				&& checkStringEmpty(currencycode, CURRENCY_CODE_EMPTY);
	}

	public boolean checkDataBranchcode(String branchcode) {
		return checkNumericString(branchcode, BRANCH_CODE_NUM) && checkStringEmpty(branchcode, BRANCH_CODE_EMPTY);
	}

	public boolean checkDataCardprogramcode(String cardprogramcode) {
		return checkNumericString(cardprogramcode, CARD_PROGRAM_CODE_NUM)
				&& checkStringEmpty(cardprogramcode, CARD_PROGRAM_CODE_EMPTY);
	}

	public boolean checkDataPrepaidprogramcode(String prepaidprogramcode) {
		return checkNumericString(prepaidprogramcode, PREPAID_PROGRAM_CODE_NUM)
				&& checkStringEmpty(prepaidprogramcode, PREPAID_PROGRAM_CODE_EMPTY);
	}

	public boolean checkDataCitycode(String citycode) {
		return checkNumericString(citycode, CITY_CODE_NUM) && checkStringEmpty(citycode, CITY_CODE_EMPTY);
	}

	public boolean checkDataApplicationId(String applicationid) {
		return checkStringEmpty(applicationid, APPLICATIONN_ID_EMPTY)
				&& checkStringLenght(applicationid, LEN_applicationid_24, APPLICATIONN_ID_LENGHT);
	}

	public boolean checkDataAction(String action) {
		return checkStringEmpty(action, ACTION_EMPTY) && checkStringLenght(action, LEN_action_1, ACTION_LENGHT);
	}

	/*
	 * public boolean checkDataApplicationid(String applicationid) { return
	 * checkStringEmpty(applicationid, APPLICATION_ID_EMPTY) &&
	 * checkStringLenght(applicationid, LEN_applicationid_24,
	 * APPLICATION_ID_LENGHT); }
	 */

	public boolean checkDataCustomerid(String customerid) {
		return checkStringEmpty(customerid, CUSTOMER_ID_EMPTY)
				&& checkStringLenght(customerid, LEN_customerid_24, CUSTOMER_ID_LENGHT);
	}

	public boolean checkDataTypeaccount(String typeaccount) {
		return checkStringEmpty(typeaccount, TYPE_ACCOUNT_EMPTY)
				&& checkStringLenght(typeaccount, LEN_typeaccount_1, TYPE_ACCOUNT_LENGHT);
	}

	public boolean checkDataBankaccounttype(String bankaccounttype) {
		return checkStringEmpty(bankaccounttype, BANK_ACCOUNT_TYPE_EMPTY)
				&& checkStringLenght(bankaccounttype, LEN_bankaccounttype_10, BANK_ACCOUNT_TYPE_LENGHT);
	}

	public boolean checkDataGender(String gender) {
		return checkStringEmpty(gender, GENDER_EMPTY) && checkStringLenght(gender, LEN_gender_1, GENDER_LENGHT);
	}

	public boolean checkDataBirthdatelocation(String birthdatelocation) {
		return checkStringEmpty(birthdatelocation, BIRTH_DATE_LOCATION_EMPTY)
				&& checkStringLenght(birthdatelocation, LEN_birthdatelocation_40, BIRTH_DATE_LOCATION_LENGHT);
	}

	public boolean checkDataCorporatename(String corporatename) {
		return checkStringEmpty(corporatename, CORPORATE_NAME_EMPTY)
				&& checkStringLenght(corporatename, LEN_corporatename_25, CORPORATE_NAME_LENGHT);
	}

	public boolean checkDataZipaddress(String zipaddress) {
		return checkStringEmpty(zipaddress, ZIP_ADDRESS_EMPTY)
				&& checkStringLenght(zipaddress, LEN_zipaddress_5, ZIP_ADDRESS_LENGHT);
	}

	public boolean checkDataFax(String fax) {
		return checkStringEmpty(fax, FAX_EMPTY) && checkStringLenght(fax, LEN_fax_19, FAX_LENGHT);
	}

	public boolean checkDataProfetionalposition(String profetionalposition) {
		return checkNumericString(profetionalposition, PROFETIONAL_POS_NUM)
				&& checkStringEmpty(profetionalposition, PROFETIONAL_POS_EMPTY);
	}

	public boolean checkDataMaritalstatus(String maritalstatus) {
		return checkNumericString(maritalstatus, MARITAL_STATUS_NUM)
				&& checkStringEmpty(maritalstatus, MARITAL_STATUS_EMPTY);
	}

	public boolean checkDataTitle(String title) {
		return checkNumericString(title, TITLE_NUM) && checkStringEmpty(title, TITLE_EMPTY);
	}

	public boolean checkDataDebitprogram(String debitprogram) {
		return checkNumericString(debitprogram, DEBIT_PROGRAM_NUM)
				&& checkStringEmpty(debitprogram, DEBIT_PROGRAM_EMPTY);
	}

	public boolean checkDataCountry(String country) {
		return checkNumericString(country, COUNTRY_NUM) && checkStringEmpty(country, COUNTRY_EMPTY);
	}

	public boolean checkDataAddresstype(String addresstype) {
		return checkNumericString(addresstype, ADDRESS_TYPE_NUM) && checkStringEmpty(addresstype, ADDRESS_TYPE_EMPTY);
	}

	public boolean checkDataAccountnumber(String accountNbr) {
		return checkStringEmpty(accountNbr, ACCOUNT_EMPTY) && checkStringLenght(accountNbr, LEN_ACC_24, ACCOUNT_LENGHT);
	}

	public boolean checkDataPaymentmode(String paymentmode) {
		return checkStringEmpty(paymentmode, PAYMENT_MODE_EMPTY) && checkNumericString(paymentmode, PAYMENT_MODE_NUM);
	}

	public boolean checkDataReloadfee(String reloadfee) {
		return checkStringEmpty(reloadfee, RELOAD_FEE_EMPTY) && checkNumericString(reloadfee, RELOAD_FEE_NUM);
	}

	public boolean checkDataReloadamount(String reloadamount) {
               return true;
	}

	public boolean checkDataReloadaccountnumber(String reloadaccountnumber) {
		return checkStringEmpty(reloadaccountnumber, RELOAD_ACCOUNT_EMPTY)
				&& checkStringLenght(reloadaccountnumber, LEN_reloadaccountnumber_24, RELOAD_ACCOUNT_LENGHT);
	}

	private boolean checkNumericString(String str, int idMsg) {
		boolean isNumeric = true;
		try {
			if (str == null)
				isNumeric = false;
			else {
				for (char c : str.toCharArray())
					if (c < '0' || c > '9')
						isNumeric = false;
			}
			if (!isNumeric) {
				codeErreur = SS_Df.ccode(idMsg);
				msgErreur = SS_Df.cmsg(idMsg);
				return false;
			}
		} catch (Exception e) {
			codeErreur = SS_Df.ccode(idMsg);
			msgErreur = SS_Df.cmsg(idMsg);
			return false;
		}

		return true;

	}

	// Fromat : MM/YY
	private boolean checkDateFormat(String str, int idMsg) {
		boolean isDateFormat = true;
		int compteur;

		try {

			if (str == null) {
				isDateFormat = false;
			} else {
				compteur = 0;
				for (char c : str.toCharArray()) {
					if ((compteur == 0 || compteur == 1 || compteur == 3 || compteur == 4) && (c < '0' || c > '9')) {
						isDateFormat = false;
					}
					if (compteur == 2) {
						if (c != '/') {
							isDateFormat = false;
						}
					}
					compteur += 1;
				}
			}
			if (!isDateFormat || str.length() != 5) {
				codeErreur = SS_Df.ccode(idMsg);
				msgErreur = SS_Df.cmsg(idMsg);
				return false;
			}
		} catch (Exception e) {
			codeErreur = SS_Df.ccode(idMsg);
			msgErreur = SS_Df.cmsg(idMsg);
			return false;
		}

		return true;
	}

	// Fromat : DD/MM/YYYY
	public boolean checkDateFormat2(String str, int idMsg) {
		boolean isDateFormat = true;
		int compteur;
		
		if (str.isEmpty())
			return true;

		try {

			if (str == null) {
				isDateFormat = false;
			} else {
				compteur = 0;

				for (char c : str.toCharArray()) {
					if ((compteur == 0 || compteur == 1 || compteur == 3 || compteur == 4 || compteur == 6
							|| compteur == 7 || compteur == 8 || compteur == 9) && (c < '0' || c > '9')) {
						isDateFormat = false;
					}
					if (compteur == 2 && c != '/')
						isDateFormat = false;

					if (compteur == 5 && c != '/')
						isDateFormat = false;

					compteur += 1;
				}
			}
			if (!isDateFormat || str.length() != 10) {
				codeErreur = SS_Df.ccode(idMsg);
				msgErreur = SS_Df.cmsg(idMsg);
				return false;
			}
		} catch (Exception e) {
			codeErreur = SS_Df.ccode(idMsg);
			msgErreur = SS_Df.cmsg(idMsg);
			return false;
		}

		return true;
	}

	// Creation d'une fonction globale pour tous les controles Varchar:
	public boolean checkDataVarchar(String field, String msg, int code, int len, char obligation) {
		String message;

		code = RELOAD_ACCOUNT_LENGHT + code + ID_CHECK;

		if (obligation == 'O' && !isFilled(field)) {
			codeErreur = String.valueOf(code);
			msgErreur = msg + " COULD NOT BE EMPTY";
			return false;
		}
		
		if (field.equals(" ") || field.isEmpty() )
			return true;

		message = msg + " LENGHT IS INCORRECT, MAX " + len;
		try {
			if (field.length() > len) {
				codeErreur = String.valueOf(code);
				msgErreur = message;
				return false;
			}
		} catch (Exception e) {
			codeErreur = String.valueOf(code);
			msgErreur = message;
			return false;
		}

		return true;
	}

	// Creation d'une fonction globale pour tous les controles Number:
	public boolean checkDataNumber(String field, String msg, int code, char obligation) {
		
		String message;
		boolean isNumeric = true;

		code = RELOAD_ACCOUNT_LENGHT + code + ID_CHECK;

		if (obligation == 'O' && !isFilled(field)) {
			codeErreur = String.valueOf(code);
			msgErreur = msg + " COULD NOT BE EMPTY";
			return false;
		}
		
		if (field.equals(" ") || field.isEmpty() )
			return true;
		
		message = msg+" VALUE INCORRECT, SHOULD BE NUMERIC";
	
		try {
			if (field == null)
				isNumeric = false;
			else {
				for (char c : field.toCharArray())
					if (c < '0' || c > '9')
						isNumeric = false;
				if (field.isEmpty()) 
					isNumeric = true;
					
			}
			if (!isNumeric) {
				codeErreur = String.valueOf(code);
				msgErreur = message;
				return false;
			}
		} catch (Exception e) {
			codeErreur = String.valueOf(code);
			msgErreur = message;
			return false;
		}
		
		return true;
	}
	
	// Creation d'une fonction globale pour le Phone Number
		public boolean checkDataPhoneNumber(String field, String msg, int code, char obligation) {
			
			String message;
			boolean isNumeric = true;

			code = RELOAD_ACCOUNT_LENGHT + code + ID_CHECK;

			if (obligation == 'O' && !isFilled(field)) {
				codeErreur = String.valueOf(code);
				msgErreur = msg + " COULD NOT BE EMPTY";
				return false;
			}
			
			if (obligation == 'O' && (field.equals(" ") || field.isEmpty())) {
				codeErreur = String.valueOf(code);
				msgErreur = msg + " COULD NOT BE EMPTY";
				return false;
			}
			
			if (field.equals(" ") || field.isEmpty() )
				return true;
			
			message = msg+" VALUE INCORRECT, SHOULD BE NUMERIC, EXAMPLE 218xxxxxxxxx ";
		
			try {
				if (field == null)
					isNumeric = false;
				else {
					for (char c : field.toCharArray())
						if (c < '0' || c > '9')
							isNumeric = false;
					if (field.isEmpty()) 
						isNumeric = true;
						
				}
				if (!isNumeric) {
					codeErreur = String.valueOf(code);
					msgErreur = message;
					return false;
				}
			} catch (Exception e) {
				codeErreur = String.valueOf(code);
				msgErreur = message;
				return false;
			}
			
			message = msg+" SHOULD BE START WITH '218', EXAMPLE '218XXXXXXXXX' ";
			
			if (!field.substring(0,3).equalsIgnoreCase("218")){
				
				codeErreur = String.valueOf(code);
				msgErreur = message;
				return false;
			}
			
			message = msg + " LENGHT IS INCORRECT, SHOULD BE 12, EXAMPLE '218XXXXXXXXX' ";
			
			if (field.length() != 12){
				codeErreur = String.valueOf(code);
				msgErreur = message;
				return false;
			}
			
			return true;
		}
		
		public boolean checkIfYesOrNo(String field, String msg, int code,char obligation) {
			String message;

			code = RELOAD_ACCOUNT_LENGHT + code + ID_CHECK;

			if (obligation == 'O' && (field.equals(" ") || field.isEmpty())) {
				codeErreur = String.valueOf(code);
				msgErreur = msg + " COULD NOT BE EMPTY, THIS FIELD ACCEPT ONLY 'Y' or 'N' IN UPPER CASE.";
				return false;
			}
			
			if (field.equals(" ") || field.isEmpty() )
				return true;

			message = msg + " VALUE INCORRECT, THIS FIELD ACCEPT ONLY 'Y' or 'N' IN UPPER CASE.";
			try {
				if (!field.equals("Y") && !field.equals("N")  ) {
					codeErreur = String.valueOf(code);
					msgErreur = message;
					return false;
				}
			} catch (Exception e) {
				codeErreur = String.valueOf(code);
				msgErreur = message;
				return false;
			}

			return true;
		}
	 public boolean checkIfEmpty(String condition) {
			if (condition != null) {
				if (condition.isEmpty())
					return true;
				else
					return false;
			}
			return true;
	 }
	 
	 public boolean checkStringLenght(String condition) {
			if (condition.length() >= 16 && condition.length() <= LEN_fax_19) 
					return true;
			return false;
	 }
	 
	 public boolean checkIfNumeric(String condition) {
		 return condition.matches("[0-9]+");
	 }
         
         public boolean checkDataPin(String pin) {
		return checkStringEmpty(pin, PIN_EMPTY);
	}
        public boolean checkDataUniqid(String uniqid) {
                if (uniqid == null || uniqid.trim().isEmpty()) {
                    return false;
                }
                if (uniqid.length() != 10) { 
                    return false;
                }
                if (!uniqid.matches("^[0-9]+$")) {
                    return false;
                }
                return true;
        }

        


}
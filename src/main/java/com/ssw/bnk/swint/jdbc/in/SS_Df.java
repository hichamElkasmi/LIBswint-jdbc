/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssw.bnk.swint.jdbc.in;


/**
 *
 * @author rmokh
 */
public class SS_Df {
 
    public static final int ID_CHECK                = 10000;
    public static final int HEAD_MAC_EMPTY          = 0;
    public static final int HEAD_MAC_LENGHT         = HEAD_MAC_EMPTY+1;
    public static final int HEAD_ID_EMPTY           = HEAD_MAC_LENGHT+1;
    public static final int HEAD_ID_LENGHT          = HEAD_ID_EMPTY+1;
    public static final int INIT_IDENT_EMPTY        = HEAD_ID_LENGHT+1;
    public static final int INIT_IDENT_LENGHT       = INIT_IDENT_EMPTY+1;
    public static final int INIT_IDENT_VALUE        = INIT_IDENT_LENGHT+1;
    public static final int INIT_TYPE_EMPTY         = INIT_IDENT_VALUE+1;
    public static final int INIT_TYPE_VALUE         = INIT_TYPE_EMPTY+1;
    public static final int INIT_WALLET_CODE_EMPTY  = INIT_TYPE_VALUE+1;
    public static final int INIT_WALLET_CODE_LENGHT = INIT_WALLET_CODE_EMPTY+1;
    public static final int INIT_WALLET_CODE_VALUE  = INIT_WALLET_CODE_LENGHT+1;
    public static final int FILTER_NTRANS_LENGHT    = INIT_WALLET_CODE_VALUE+1;
    public static final int FILTER_NTRANS_VALUE     = FILTER_NTRANS_LENGHT+1;
    public static final int FILTER_IDTRANS_LENGHT   = FILTER_NTRANS_VALUE+1;
    public static final int FILTER_DSTART_FIELD     = FILTER_IDTRANS_LENGHT+1;
    public static final int FILTER_DEND_FIELD       = FILTER_DSTART_FIELD+1;
    public static final int BANK_EMPTY              = FILTER_DEND_FIELD+1;
    public static final int BANK_LENGHT             = BANK_EMPTY+1;
    public static final int BANK_VALUE              = BANK_LENGHT+1;
    public static final int REQ_DATE                = BANK_VALUE+1;
    public static final int REQ_AMOUNT_EMPTY        = REQ_DATE+1;
    public static final int REQ_AMOUNT_LENGHT       = REQ_AMOUNT_EMPTY+1;
    public static final int REQ_AMOUNT_VALUE        = REQ_AMOUNT_LENGHT+1;
    public static final int REQ_CURRENCY_EMPTY      = REQ_AMOUNT_VALUE+1;
    public static final int REQ_CURRENCY_LENGHT     = REQ_CURRENCY_EMPTY+1;
    public static final int REQ_ADDID_EMPTY         = REQ_CURRENCY_LENGHT+1;
    public static final int REQ_ADDID_LENGHT        = REQ_ADDID_EMPTY+1;
    public static final int REQ_ADDID_VALUE         = REQ_ADDID_LENGHT+1;  
    public static final int REQ_ADDDATA_EMPTY       = REQ_ADDID_VALUE+1;
    public static final int REQ_ADDDATA_LENGHT      = REQ_ADDDATA_EMPTY+1;
    public static final int REQ_ADDDATA_VALUE       = REQ_ADDDATA_LENGHT+1;
    public static final int REQ_LABEL_LENGHT        = REQ_ADDDATA_VALUE+1;
    public static final int NATID_EMPTY             = REQ_LABEL_LENGHT+1;
    public static final int NATID_LENGHT            = NATID_EMPTY+1;
    public static final int PHONE_EMPTY             = NATID_LENGHT+1;
    public static final int PHONE_LENGHT            = PHONE_EMPTY+1;
    public static final int PHONE_VALUE             = PHONE_LENGHT+1;
    public static final int BRANCH_EMPTY            = PHONE_VALUE+1;
    public static final int BRANCH_LENGHT           = BRANCH_EMPTY+1;
    public static final int BRANCH_VALUE            = BRANCH_LENGHT+1;
    public static final int CUSTOMER_LENGHT         = BRANCH_VALUE+1;
    public static final int CUSTOMER_VALUE          = CUSTOMER_LENGHT+1;
    public static final int CUSTOMER_EMPTY          = CUSTOMER_VALUE+1;
    public static final int ACCOUNT_EMPTY           = CUSTOMER_EMPTY+1;
    public static final int ACCOUNT_LENGHT          = ACCOUNT_EMPTY+1;
    public static final int ACCOUNT_VALUE           = ACCOUNT_LENGHT+1;
    public static final int ACC_PROGRAM_EMPTY       = ACCOUNT_VALUE+1;
    public static final int ACC_PROGRAM_LENGHT      = ACC_PROGRAM_EMPTY+1;
    public static final int ACC_PROGRAM_VALUE       = ACC_PROGRAM_LENGHT+1;
    public static final int DATE_EMPTY              = ACC_PROGRAM_VALUE+1;
    public static final int DATE_LENGHT             = DATE_EMPTY+1;
    public static final int DATE_VALUE              = DATE_LENGHT+1;
    public static final int DATE_FORMAT_SMALL       = DATE_VALUE+1;
    public static final int DATE_FORMAT_LONG        = DATE_FORMAT_SMALL+1;
    public static final int ENRL_EN_FSTNAME_EMPTY   = DATE_FORMAT_LONG+1;
    public static final int ENRL_EN_FSTNAME_LENGHT  = ENRL_EN_FSTNAME_EMPTY+1;
    public static final int ENRL_EN_LSTNAME_EMPTY   = ENRL_EN_FSTNAME_LENGHT+1;
    public static final int ENRL_EN_LSTNAME_LENGHT  = ENRL_EN_LSTNAME_EMPTY+1;
    public static final int ENRL_AR_FSTNAME_EMPTY   = ENRL_EN_LSTNAME_LENGHT+1;
    public static final int ENRL_AR_FSTNAME_LENGHT  = ENRL_AR_FSTNAME_EMPTY+1;
    public static final int ENRL_AR_LSTNAME_EMPTY   = ENRL_AR_FSTNAME_LENGHT+1;
    public static final int ENRL_AR_LSTNAME_LENGHT  = ENRL_AR_LSTNAME_EMPTY+1;
    public static final int ENRL_GENDER_VALUE       = ENRL_AR_LSTNAME_LENGHT+1;
    public static final int ENRL_TITEL_VALUE        = ENRL_GENDER_VALUE+1;
    public static final int ENRL_DBIRTH             = ENRL_TITEL_VALUE+1;
    public static final int ENRL_POB_LENGHT         = ENRL_DBIRTH+1;
    public static final int ENRL_NAT_LENGHT         = ENRL_POB_LENGHT+1;
    public static final int ENRL_MAIL_LENGHT        = ENRL_NAT_LENGHT+1;
    public static final int ENRL_MAIL_VALUE         = ENRL_MAIL_LENGHT+1;
    public static final int ENRL_DPSPRT             = ENRL_MAIL_VALUE+1;
    public static final int ENRL_PSRTID_LENGHT      = ENRL_DPSPRT+1;
    public static final int ENRL_ADRTYP_EMPTY       = ENRL_PSRTID_LENGHT+1;
    public static final int ENRL_ADRTYP_LENGHT      = ENRL_ADRTYP_EMPTY+1;
    public static final int ENRL_ADRTYP_VALUE       = ENRL_ADRTYP_LENGHT+1;
    public static final int ENRL_ADRCRS_EMPTY       = ENRL_ADRTYP_VALUE+1;
    public static final int ENRL_ADRCRS_LENGHT      = ENRL_ADRCRS_EMPTY+1;
    public static final int ENRL_ADRCRS_VALUE       = ENRL_ADRCRS_LENGHT+1;
    public static final int ENRL_ADR1_EMPTY         = ENRL_ADRCRS_VALUE+1;
    public static final int ENRL_ADR1_LENGHT        = ENRL_ADR1_EMPTY+1;
    public static final int ENRL_ADR2_LENGHT        = ENRL_ADR1_LENGHT+1;
    public static final int ENRL_ADRSTR_LENGHT      = ENRL_ADR2_LENGHT+1;
    public static final int ENRL_ADRSPD_LENGHT      = ENRL_ADRSTR_LENGHT+1;
    public static final int ENRL_ADRCTY_LENGHT      = ENRL_ADRSPD_LENGHT+1;
    public static final int ENRL_ADRPSTL_LENGHT     = ENRL_ADRCTY_LENGHT+1;
    public static final int ENRL_ADRCTR_LENGHT      = ENRL_ADRPSTL_LENGHT+1;
    public static final int ENRL_ADRCTR_VALUE       = ENRL_ADRCTR_LENGHT+1;
    public static final int ENRL_ADRPSTL_VALUE      = ENRL_ADRCTR_VALUE+1;
    public static final int ENRL_ADRCTY_VALUE       = ENRL_ADRPSTL_VALUE+1;
    public static final int ENRL_ADRSPD_VALUE       = ENRL_ADRCTY_VALUE+1;
    public static final int ENRL_ADR_COUNT          = ENRL_ADRSPD_VALUE+1;
    public static final int ENRL_MERCHANTID_LENGHT  = ENRL_ADR_COUNT+1;
    public static final int ENRL_MERCHANTNAME_EMPTY = ENRL_MERCHANTID_LENGHT+1;
    public static final int ENRL_MERCHANTNAME_LENGHT= ENRL_MERCHANTNAME_EMPTY+1;
    public static final int MER_ACTIVITY_EMPTY      = ENRL_MERCHANTNAME_LENGHT+1;
    public static final int MER_ACTIVITY_LENGHT     = MER_ACTIVITY_EMPTY+1;
    public static final int MER_ACTIVITY_VALUE      = MER_ACTIVITY_LENGHT+1;
    public static final int MER_PROGRAM_EMPTY       = MER_ACTIVITY_VALUE+1;
    public static final int MER_PROGRAM_LENGHT      = MER_PROGRAM_EMPTY+1;
    public static final int MER_PROGRAM_VALUE       = MER_PROGRAM_LENGHT+1;
    public static final int ENT_HEADER_NULL         = MER_PROGRAM_VALUE+1;
    public static final int ENT_DATA_NULL           = ENT_HEADER_NULL+1;
    public static final int ENT_INITIATOR_NULL      = ENT_DATA_NULL+1;
    public static final int ENT_IDENTITY_NULL       = ENT_INITIATOR_NULL+1;
    public static final int ENT_CRITERIA_NULL       = ENT_IDENTITY_NULL+1;
    public static final int ENT_FILTER_NULL         = ENT_CRITERIA_NULL+1;
    public static final int ENT_REQUEST_NULL        = ENT_FILTER_NULL+1; 
    
    public static final int STATUS_EMPTY               = ENT_REQUEST_NULL+1;
    public static final int EXPIRY_EMPTY               = STATUS_EMPTY+1;
    public static final int CARD_EMPTY                 = EXPIRY_EMPTY+1;
    public static final int DATA_EMPTY                 = CARD_EMPTY+1;
    public static final int NEW_PAN_EMPTY              = DATA_EMPTY+1;
    public static final int REPLACEMENT_REASON_EMPTY   = NEW_PAN_EMPTY+1;
    public static final int EXPIRY_FORMAT              = REPLACEMENT_REASON_EMPTY+1;
    public static final int INSTITUTION                = EXPIRY_FORMAT+1;
    public static final int PIN_GENERATION             = INSTITUTION+1;
    public static final int PACKAGE_NON_COMPILE        = PIN_GENERATION+1;  
    public static final int START                      = PACKAGE_NON_COMPILE+1;  
    public static final int END                        = START+1;  
    public static final int START_COMPARE_END          = END+1;
    
    public static final int NAME_ON_CARD_EMPTY       =  START_COMPARE_END      + 1 ;          
    public static final int FISRT_NAME_EMPTY         =  NAME_ON_CARD_EMPTY     + 1 ;
    public static final int MIDDLE_NAME_EMPTY        =  FISRT_NAME_EMPTY       + 1 ;
    public static final int LAST_NAME_EMPTY          =  MIDDLE_NAME_EMPTY      + 1 ;
    public static final int FIRST_NAME_AR_EMPTY      =  LAST_NAME_EMPTY        + 1 ;
    public static final int MIDDLE_NAME_AR_EMPTY     =  FIRST_NAME_AR_EMPTY    + 1 ;
    public static final int LAST_NAME_AR_EMPTY       =  MIDDLE_NAME_AR_EMPTY   + 1 ;
    public static final int CUSTOMER_TYPE_EMPTY      =  LAST_NAME_AR_EMPTY     + 1 ;
    public static final int ACCOUNT_TYPE_EMPTY       =  CUSTOMER_TYPE_EMPTY    + 1 ;
    public static final int AUTO_RELOAD_EMPTY        =  ACCOUNT_TYPE_EMPTY     + 1 ;
    public static final int CUSTOMER_ADDRESS_EMPTY   =  AUTO_RELOAD_EMPTY      + 1 ;
    public static final int PHONE_NUMBER_EMPTY       =  CUSTOMER_ADDRESS_EMPTY + 1 ;
    public static final int NATIONAL_ID_EMPTY        =  PHONE_NUMBER_EMPTY     + 1 ;
    public static final int OPERATION_EMPTY          =  NATIONAL_ID_EMPTY      + 1 ;
    
    public static final int NAME_ON_CARD_LENGHT       =  OPERATION_EMPTY         + 1 ;          
    public static final int FIRST_NAME_LENGHT         =  NAME_ON_CARD_LENGHT     + 1 ;
    public static final int MIDDLE_NAME_LENGHT        =  FIRST_NAME_LENGHT       + 1 ;
    public static final int LAST_NAME_LENGHT          =  MIDDLE_NAME_LENGHT      + 1 ;
    public static final int FIRST_NAME_AR_LENGHT      =  LAST_NAME_LENGHT        + 1 ;
    public static final int MIDDLE_NAME_AR_LENGHT     =  FIRST_NAME_AR_LENGHT    + 1 ;
    public static final int LAST_NAME_AR_LENGHT       =  MIDDLE_NAME_AR_LENGHT   + 1 ;
    public static final int CUSTOMER_TYPE_LENGHT      =  LAST_NAME_AR_LENGHT     + 1 ;
    public static final int ACCOUNT_TYPE_LENGHT       =  CUSTOMER_TYPE_LENGHT    + 1 ;
    public static final int AUTO_RELOAD_LENGHT        =  ACCOUNT_TYPE_LENGHT     + 1 ;
    public static final int CUSTOMER_ADDRESS_LENGHT   =  AUTO_RELOAD_LENGHT      + 1 ;
    public static final int PHONE_NUMBER_LENGHT       =  CUSTOMER_ADDRESS_LENGHT + 1 ;
    public static final int NATIONAL_ID_LENGHT        =  PHONE_NUMBER_LENGHT     + 1 ;
    public static final int OPERATION_LENGHT          =  NATIONAL_ID_LENGHT      + 1 ;
    
    public static final int NATIONAL_ID_TYPE_NUM      = OPERATION_LENGHT         + 1;
    public static final int BANK_CODE_NUM             = NATIONAL_ID_TYPE_NUM     + 1;
    public static final int CURRENCY_CODE_NUM         = BANK_CODE_NUM            + 1;
    public static final int BRANCH_CODE_NUM           = CURRENCY_CODE_NUM        + 1;
    public static final int CARD_PROGRAM_CODE_NUM     = BRANCH_CODE_NUM          + 1;
    public static final int PREPAID_PROGRAM_CODE_NUM  = CARD_PROGRAM_CODE_NUM    + 1;
    public static final int CITY_CODE_NUM             = PREPAID_PROGRAM_CODE_NUM + 1;
    
    public static final int NATIONAL_ID_TYPE_EMPTY      = CITY_CODE_NUM              + 1;
    public static final int BANK_CODE_EMPTY             = NATIONAL_ID_TYPE_EMPTY     + 1;
    public static final int CURRENCY_CODE_EMPTY         = BANK_CODE_EMPTY            + 1;
    public static final int BRANCH_CODE_EMPTY           = CURRENCY_CODE_EMPTY        + 1;
    public static final int CARD_PROGRAM_CODE_EMPTY     = BRANCH_CODE_EMPTY          + 1;
    public static final int PREPAID_PROGRAM_CODE_EMPTY  = CARD_PROGRAM_CODE_EMPTY    + 1;
    public static final int CITY_CODE_EMPTY             = PREPAID_PROGRAM_CODE_EMPTY + 1;
    
    public static final int APPLICATIONN_ID_EMPTY       = CITY_CODE_EMPTY            + 1;
    public static final int APPLICATIONN_ID_LENGHT      = APPLICATIONN_ID_EMPTY      + 1;
    public static final int ACTION_EMPTY                = APPLICATIONN_ID_LENGHT     + 1;
    public static final int ACTION_LENGHT               = ACTION_EMPTY               + 1;
    
    public static final int BIRTH_DATE_EMPTY            = ACTION_LENGHT               + 1;
    public static final int BIRTH_DATE_FORMAT           = BIRTH_DATE_EMPTY        + 1;
    
    public static final int APPLICATION_ID_EMPTY       = BIRTH_DATE_FORMAT           + 1;
    public static final int CUSTOMER_ID_EMPTY          = APPLICATION_ID_EMPTY        + 1;
    public static final int TYPE_ACCOUNT_EMPTY         = CUSTOMER_ID_EMPTY           + 1;
    public static final int BANK_ACCOUNT_TYPE_EMPTY    = TYPE_ACCOUNT_EMPTY          + 1;
    public static final int GENDER_EMPTY               = BANK_ACCOUNT_TYPE_EMPTY     + 1;
    public static final int BIRTH_DATE_LOCATION_EMPTY  = GENDER_EMPTY                + 1;
    public static final int CORPORATE_NAME_EMPTY       = BIRTH_DATE_LOCATION_EMPTY   + 1;
    public static final int ZIP_ADDRESS_EMPTY          = CORPORATE_NAME_EMPTY        + 1;
    public static final int FAX_EMPTY                  = ZIP_ADDRESS_EMPTY           + 1;

    public static final int APPLICATION_ID_LENGHT       = FAX_EMPTY                  + 1;
    public static final int CUSTOMER_ID_LENGHT          = APPLICATION_ID_LENGHT      + 1;
    public static final int TYPE_ACCOUNT_LENGHT         = CUSTOMER_ID_LENGHT         + 1;
    public static final int BANK_ACCOUNT_TYPE_LENGHT    = TYPE_ACCOUNT_LENGHT        + 1;
    public static final int GENDER_LENGHT               = BANK_ACCOUNT_TYPE_LENGHT   + 1;
    public static final int BIRTH_DATE_LOCATION_LENGHT  = GENDER_LENGHT              + 1;
    public static final int CORPORATE_NAME_LENGHT       = BIRTH_DATE_LOCATION_LENGHT + 1;
    public static final int ZIP_ADDRESS_LENGHT          = CORPORATE_NAME_LENGHT      + 1;
    public static final int FAX_LENGHT                  = ZIP_ADDRESS_LENGHT         + 1;
    
    public static final int PROFETIONAL_POS_NUM  = FAX_LENGHT          + 1;
    public static final int MARITAL_STATUS_NUM   = PROFETIONAL_POS_NUM + 1;
    public static final int TITLE_NUM            = MARITAL_STATUS_NUM  + 1;
    public static final int DEBIT_PROGRAM_NUM    = TITLE_NUM           + 1;	   
    public static final int COUNTRY_NUM          = DEBIT_PROGRAM_NUM   + 1;	   
    public static final int ADDRESS_TYPE_NUM     = COUNTRY_NUM         + 1;	 

    public static final int PROFETIONAL_POS_EMPTY  = ADDRESS_TYPE_NUM       + 1;
    public static final int MARITAL_STATUS_EMPTY   = PROFETIONAL_POS_EMPTY  + 1;
    public static final int TITLE_EMPTY            = MARITAL_STATUS_EMPTY   + 1;
    public static final int DEBIT_PROGRAM_EMPTY    = TITLE_EMPTY            + 1;	   
    public static final int COUNTRY_EMPTY          = DEBIT_PROGRAM_EMPTY    + 1;	   
    public static final int ADDRESS_TYPE_EMPTY     = COUNTRY_EMPTY          + 1;
    public static final int CARD_NUM               = ADDRESS_TYPE_EMPTY     + 1;
    public static final int INSTITUTION_NUM        = CARD_NUM     + 1;
    
    public static final int PAYMENT_MODE_EMPTY  = INSTITUTION_NUM     + 1;
    public static final int RELOAD_FEE_EMPTY    = PAYMENT_MODE_EMPTY  + 1;
    public static final int RELOAD_AMOUNT_EMPTY = RELOAD_FEE_EMPTY    + 1;		

    public static final int PAYMENT_MODE_NUM     = RELOAD_AMOUNT_EMPTY + 1;	
    public static final int RELOAD_FEE_NUM       = PAYMENT_MODE_NUM    + 1;	
    public static final int RELOAD_AMOUNT_NUM    = RELOAD_FEE_NUM      + 1;	
    public static final int RELOAD_ACCOUNT_EMPTY = RELOAD_AMOUNT_NUM      + 1;	
    public static final int RELOAD_ACCOUNT_LENGHT = RELOAD_ACCOUNT_EMPTY  + 1;	
    public static final int PHONE_NUMBER_NUM = RELOAD_ACCOUNT_LENGHT  + 1;	
    public static final int DEBIT_PROGRAM_CODE_EMPTY  = PHONE_NUMBER_NUM    + 1;
    public static final int DEBIT_PROGRAM_CODE_NUM  = DEBIT_PROGRAM_CODE_EMPTY    + 1;
    
    public static final int PIN_EMPTY                 = DEBIT_PROGRAM_CODE_NUM+1;
    public static final int PIN_NUM               = PIN_EMPTY     + 1;
    
    public static final String OK_SS = "00000";
    public static final int ID_STATUS   = 0;
    public static final int ST_APPROVED = 0;
    public static final int ST_WAIT     = ST_APPROVED+1;
    public static final int ST_REJECTED = ST_WAIT+1;
    public static final int ST_ERROR    = ST_REJECTED+1;
    public static final int ST_NODATA   = ST_ERROR+1;
    
    public static final int ID_ERROR   = 20000;
    public static final int ER_CLEAN   = -1;
    public static final int ER_AUTH    = 0;
    public static final int ER_INPUT   = ER_AUTH+1;
    public static final int ER_PROCESS = ER_INPUT+1;
    public static final int ER_ERROR   = ER_PROCESS+1;
    public static final int ER_DATA    = ER_ERROR+1;
    public static final int ER_PARSE    = ER_DATA+1;
    public static final int ER_STREAM    = ER_PARSE+1;
    
    private static final String[] LIST_ERRORS={
        /*ER_AUTH*/"INCORRECT AUTHENTIFICATION REQ",
        /*ER_INPUT*/"INCORRECT INPUT",
        /*ER_PROCESS*/"PROCESSING ERROR: ",
        /*ER_ERROR*/"OTHER ERROR: ",
        /*ER_DATA*/"ERROR GET DATA: ",
        /*ER_PARSE*/"ERROR PARSING: ",
        /*ER_STREAM*/"ERROR STREAM: "
    };
    
    private static final String[] LIST_STATUS={
        /*ST_APPROVED*/"APPROVED",
        /*ST_WAIT*/"WAITING FOR APPROVAL",
        /*ST_REJECTED*/"NOT APPROVED",
        /*ST_ERROR*/"ERROR",
        /*ST_NODATA*/"NO DATA FOUND"
    };
     
    private static final String[] LIST_CHECKS={
        /*HEAD_MAC_EMPTY*/"MAC FIELD COULD NOT BE EMPTY",
        /*HEAD_MAC_LENGHT*/"MAC FIELD LENGHT IS INCORRECT, MAX 200",
        /*HEAD_ID_EMPTY*/"ID MSG REQUEST FIELD COULD NOT BE EMPTY",
        /*HEAD_ID_LENGHT*/"ID MSG REQUEST LENGHT IS INCORRECT, MAX 40",
        /*INIT_IDENT_EMPTY*/"INITIATOR IDENTIFIER FIELD COULD NOT BE EMPTY",
        /*INIT_IDENT_LENGHT*/"INITIATOR IDENTIFIER LENGHT IS INCORRECT, MAX 20",
        /*INIT_IDENT_VALUE*/"INITIATOR IDENTIFIER VALUE INCORRECT, SHOULD BE NUMERIC",
        /*INIT_TYPE_EMPTY*/"INITIATOR TYPE FIELD COULD NOT BE EMPTY",
        /*INIT_TYPE_VALUE*/"INITIATOR TYPE FIELD VALUE INCORRECT, SHOULD BE 'M' OR 'C'",
        /*INIT_WALLET_CODE_EMPTY*/"INITIATOR WALLET CODE FIELD COULD NOT BE EMPTY",
        /*INIT_WALLET_CODE_LENGHT*/"INITIATOR WALLET CODE LENGHT IS INCORRECT, MAX 20",
        /*INIT_WALLET_CODE_VALUE*/"INITIATOR WALLET CODE VALUE INCORRECT, SHOULD BE NUMERIC",
        /*FILTER_NTRANS_LENGHT*/"NTRANS FIELD LENGHT IS INCORRECT, MIN (1 TRX) & MAX (99 TRX)",
        /*FILTER_NTRANS_VALUE*/"NTRANS FIELD VALUE INCORRECT, SHOULD BE NUMERIC, MAX (99 TRX)",
        /*FILTER_IDTRANS_LENGHT*/"IDTRANS FIELD LENGHT IS INCORRECT, MIN (1 TRX) & MAX (40 TRX)",
        /*FILTER_DSTART_FIELD*/"START",
        /*FILTER_DEND_FIELD*/"END",
        /*BANK_EMPTY*/"BANK CODE FIELD COULD NOT BE EMPTY",
        /*BANK_LENGHT*/"BANK CODE LENGHT IS INCORRECT, MAX 20",
        /*BANK_VALUE*/"BANK CODE FIELD VALUE INCORRECT, SHOULD BE NUMERIC",
        /*REQ_DATE*/"REQUEST",    
        /*REQ_AMOUNT_EMPTY*/"AMOUNT FIELD COULD NOT BE EMPTY EKH",   
        /*REQ_AMOUNT_LENGHT*/"AMOUNT LENGHT IS INCORRECT, MAX 20",  
        /*REQ_AMOUNT_VALUE*/"AMOUNT VALUE INCORRECT, SHOULD BE NUMERIC",   
        /*REQ_CURRENCY_EMPTY*/"CURRENCY FIELD COULD NOT BE EMPTY", 
        /*REQ_CURRENCY_LENGHT*/"CURRENCY LENGHT IS INCORRECT, MAX 3",
        /*REQ_ADDID_EMPTY*/"ADD ID FIELD COULD NOT BE EMPTY",    
        /*REQ_ADDID_LENGHT*/"ADD ID LENGHT IS INCORRECT, MAX 20",   
        /*REQ_ADDID_VALUE*/"ADD ID VALUE INCORRECT, SHOULD BE NUMERIC",    
        /*REQ_ADDDATA_EMPTY*/"ADD DATA FIELD COULD NOT BE EMPTY",  
        /*REQ_ADDDATA_LENGHT*/"ADD DATA LENGHT IS INCORRECT, MAX 15",
        /*REQ_ADDDATA_VALUE*/"ADD DATA VALUE INCORRECT, SHOULD BE NUMERIC",
        /*REQ_LABEL_LENGHT*/"LABEL LENGHT IS INCORRECT, MAX 50",
        /*NATID_EMPTY*/"NATIONAL ID FIELD COULD NOT BE EMPTY",
        /*NATID_LENGHT*/"NATIONAL ID LENGHT IS INCORRECT, MAX 30",
        /*PHONE_EMPTY*/"MOBILE NUMBER FIELD COULD NOT BE EMPTY",
        /*PHONE_LENGHT*/"MOBILE NUMBER LENGHT IS INCORRECT, MAX 20",
        /*PHONE_VALUE*/"MOBILE NUMBER VALUE INCORRECT, SHOULD BE NUMERIC STARTED WITH 218 NOT (00) NOR (+)",
        /*BRANCH_EMPTY*/"BRANCH CODE FIELD COULD NOT BE EMPTY",
        /*BRANCH_LENGHT*/"BRANCH CODE LENGHT IS INCORRECT, MAX 20",
        /*BRANCH_VALUE*/"BRANCH CODE VALUE INCORRECT, SHOULD BE NUMERIC",
        /*CUSTOMER_LENGHT*/"CUSTOMER CODE LENGHT IS INCORRECT, MAX 20",
        /*CUSTOMER_VALUE*/"CUSTOMER CODE VALUE INCORRECT, SHOULD BE NUMERIC",
        /*CUSTOMER_EMPTY*/"CUSTOMER CODE FIELD COULD NOT BE EMPTY",
        /*ACCOUNT_EMPTY*/"ACCOUNT FIELD COULD NOT BE EMPTY",
        /*ACCOUNT_LENGHT*/"ACCOUNT LENGHT IS INCORRECT, MAX 24",
        /*ACCOUNT_VALUE*/"ACCOUNT VALUE INCORRECT, SHOULD BE NUMERIC",
        /*ACC_PROGRAM_EMPTY*/"ACCOUNT PROGRAM CODE FIELD COULD NOT BE EMPTY",
        /*ACC_PROGRAM_LENGHT*/"ACCOUNT PROGRAM CODE LENGHT IS INCORRECT, MAX 20",
        /*ACC_PROGRAM_VALUE*/"ACCOUNT PROGRAM CODE VALUE INCORRECT, SHOULD BE NUMERIC",
        /*DATE_EMPTY*/" DATE FIELD COULD NOT BE EMPTY, FORMAT ",
        /*DATE_LENGHT*/" DATE FIELD LENGHT IS INCORRECT, FORMAT ",
        /*DATE_VALUE*/" DATE FIELD VALUE IS INCORRECT, FORMAT ",
        /*DATE_FORMAT_SMALL*/"yyyy-MM-dd",
        /*DATE_FORMAT_LONG*/"yyyy-MM-dd HH:mm:ss",
        /*ENRL_EN_FSTNAME_EMPTY*/"ENGLISH FIRST NAME COULD NOT BE EMPTY",
        /*ENRL_EN_FSTNAME_LENGHT*/"ENGLISH FIRST NAME LENGHT IS INCORRECT, MAX 40",
        /*ENRL_EN_LSTNAME_EMPTY*/"ENGLISH LAST NAME COULD NOT BE EMPTY",
        /*ENRL_EN_LSTNAME_LENGHT*/"ENGLISH LAST NAME LENGHT IS INCORRECT, MAX 40",
        /*ENRL_AR_FSTNAME_EMPTY*/"ARABIC FIRST NAME COULD NOT BE EMPTY",
        /*ENRL_AR_FSTNAME_LENGHT*/"ARABIC FIRST NAME LENGHT IS INCORRECT, MAX 40",
        /*ENRL_AR_LSTNAME_EMPTY*/"ARABIC LAST NAME COULD NOT BE EMPTY",
        /*ENRL_AR_LSTNAME_LENGHT*/"ARABIC LAST NAME LENGHT IS INCORRECT, MAX 40",
        /*ENRL_GENDER_VALUE*/"GENDER VALUE INCORRECT, SHOULD BE 'M' OR 'F'",
        /*ENRL_TITEL_VALUE*/"TITEL VALUE INCORRECT, SHOULD BE NUMERIC WITH ONE OF VALUES '1'=Mr,'2'=Mrs OR '3'=Miss",
        /*ENRL_DBIRTH*/"BIRTH",
        /*ENRL_POB_LENGHT*/"PLACE OF BIRTH LENGHT IS INCORRECT, MAX 15",
        /*ENRL_NAT_LENGHT*/"NATIONALITY LENGHT IS INCORRECT, MAX 20",
        /*ENRL_MAIL_LENGHT*/"EMAIL ADR LENGHT IS INCORRECT, MAX 128",
        /*ENRL_MAIL_VALUE*/"EMAIL VALUE IS INCORRECT",
        /*ENRL_DPSPRT*/"PASSPORT EXP",
        /*ENRL_PSRTID_LENGHT*/"PASSPORT ID LENGHT IS INCORRECT, MAX 20",
        /*ENRL_ADRTYP_EMPTY*/"ADDRESS TYPE COULD NOT BE EMPTY",
        /*ENRL_ADRTYP_LENGHT*/"ADDRESS TYPE IS INCORRECT, SHOULD BE NUMERIC WITH POSSIBLE VALUES (01 , 02 , 03 , 04, 05 OR 06)",
        /*ENRL_ADRTYP_VALUE*/"ADDRESS TYPE IS INCORRECT, SHOULD BE NUMERIC WITH POSSIBLE VALUES (01 , 02 , 03 , 04, 05 OR 06)",
        /*ENRL_ADRCRS_EMPTY*/"ADDRESS CORRESPONDENCE COULD NOT BE EMPTY",
        /*ENRL_ADRCRS_LENGHT*/"ADDRESS CORRESPONDENCE IS INCORRECT, SHOULD BE NUMERIC WITH POSSIBLE VALUES (01 , 02 , 03 , 04, 05 OR 06)",
        /*ENRL_ADRCRS_VALUE*/"ADDRESS CORRESPONDENCE IS INCORRECT, SHOULD BE NUMERIC WITH POSSIBLE VALUES (01 , 02 , 03 , 04, 05 OR 06)",
        /*ENRL_ADR1_EMPTY*/"ADDRESS A COULD NOT BE EMPTY",
        /*ENRL_ADR1_LENGHT*/"ADDRESS A LENGHT IS INCORRECT, MAX 80",
        /*ENRL_ADR2_LENGHT*/"ADDRESS B LENGHT IS INCORRECT, MAX 80",
        /*ENRL_ADRSTR_LENGHT*/"ADDRESS STREET LENGHT IS INCORRECT, MAX 40",
        /*ENRL_ADRSPD_LENGHT*/"ZIP CODE ADDRESS LENGHT IS INCORRECT, MAX 5",
        /*ENRL_ADRCTY_LENGHT*/"CITY CODE ADDRESS LENGHT IS INCORRECT, MAX 10",
        /*ENRL_ADRPSTL_LENGHT*/"POSTAL CODE LENGHT IS INCORRECT, MAX 20",
        /*ENRL_ADRCTR_LENGHT*/"COUNTRY CODE LENGHT IS INCORRECT, MAX 10",
        /*ENRL_ADRCTR_VALUE*/"COUNTRY CODE VALUE INCORRECT, SHOULD BE NUMERIC",
        /*ENRL_ADRPSTL_VALUE*/"POSTAL CODE VALUE INCORRECT, SHOULD BE NUMERIC",
        /*ENRL_ADRCTY_VALUE*/"CITY CODE VALUE INCORRECT, SHOULD BE NUMERIC",
        /*ENRL_ADRSPD_VALUE*/"ZIP CODE ADDRESS VALUE INCORRECT, SHOULD BE NUMERIC",
        /*ENRL_ADR_COUNT*/"ADDRESS COUNT INCORRECT, AT LEAST ONE ADDRESS SHOULD BE FILLED",
        /*ENRL_MERCHANTID_LENGHT*/"MERCHANT ID LENGHT IS INCORRECT, MAX 20",
        /*ENRL_MERCHANTNAME_EMPTY*/"MERCHANT NAME COULD NOT BE EMPTY",
        /*ENRL_MERCHANTNAME_LENGHT*/"MERCHANT NAME LENGHT IS INCORRECT, MAX 40",
        /*MER_ACTIVITY_EMPTY*/"MERCHANT ACTIVITY CODE COULD NOT BE EMPTY",
        /*MER_ACTIVITY_LENGHT*/"MERCHANT ACTIVITY CODE LENGHT IS INCORRECT, MAX 20",
        /*MER_ACTIVITY_VALUE*/"MERCHANT ACTIVITY CODE VALUE INCORRECT, SHOULD BE NUMERIC",
        /*MER_PROGRAM_EMPTY*/"MERCHANT PROGRAM CODE COULD NOT BE EMPTY",
        /*MER_PROGRAM_LENGHT*/"MERCHANT PROGRAM CODE LENGHT IS INCORRECT, MAX 20",
        /*MER_PROGRAM_VALUE*/"MERCHANT PROGRAM CODE VALUE INCORRECT, SHOULD BE NUMERIC",
        /*ENT_HEADER_NULL*/"HEADER ENTITY NOT FOUND",
        /*ENT_DATA_NULL*/"DATA ENTITY NOT FOUND",
        /*ENT_INITIATOR_NULL*/"INITIATOR ENTITY NOT FOUND",
        /*ENT_IDENTITY_NULL*/"IDENTITY ENTITY NOT FOUND",
        /*ENT_CRITERIA_NULL*/"CRITERIA ENTITY NOT FOUND",
        /*ENT_FILTER_NULL*/"FILTER ENTITY NOT FOUND",
        /*ENT_REQUEST_NULL*/"REQUEST ENTITY NOT FOUND",
        /*STATUS_EMPTY*/"STATUS COULD NOT BE EMPTY", 
        /*EXPIRY_EMPTY*/"EXPIRY COULD NOT BE EMPTY", 
        /*CARDT_EMPTY*/"CARD COULD NOT BE EMPTY" ,
        /*DATA_EMPTY*/"DATA COULD NOT BE EMPTY",
        /*NEW_PAN_EMPTY*/"NEW PAN COULD NOT BE EMPTY",
        /*REPLACEMENT_REASON_EMPTY*/"REPLACEMENT REASON COULD NOT BE EMPTY",
        /*EXPIRY_DATE_FORMAT*/"THE DATE FORMAT SHOULD BE MM/YY",
        /*INSTITUTION*/"INSTITUTION COULD NOT BE EMPTY",
        /*PIN GENERATION*/"PIN GENERATION COULD NOT BE EMPTY",
        /*Package non compilé*/"Cannot run an invalid object",
        /*START*/"START VALUE INCORRECT, SHOULD BE NUMERIC",
        /*END*/"END VALUE INCORRECT, SHOULD BE NUMERIC",
        /*START_COMPARE_END*/"END MUST BE LONGER THAN START",
        /*NAME ON CARD      */"NAME ON CARD COULD NOT BE EMPTY",
        /*FISRT NAME        */"FISRT NAME COULD NOT BE EMPTY",
        /*MIDDLE NAME       */"MIDDLE NAME COULD NOT BE EMPTY",
        /*LAST NAME         */"LAST NAME COULD NOT BE EMPTY",
        /*FIRST NAME AR     */"FIRST NAME AR COULD NOT BE EMPTY",
        /*MIDDLE NAME AR    */"MIDDLE NAME AR COULD NOT BE EMPTY",
        /*LAST NAME AR      */"LAST NAME AR COULD NOT BE EMPTY",
        /*CUSTOMER TYPE     */"CUSTOMER TYPE COULD NOT BE EMPTY",
        /*ACCOUNT TYPE      */"ACCOUNT TYPE COULD NOT BE EMPTY",
        /*AUTO RELOAD       */"AUTO RELOAD COULD NOT BE EMPTY",
        /*CUSTOMER ADDRESS  */"CUSTOMER ADDRESS COULD NOT BE EMPTY",
        /*PHONE NUMBER      */"PHONE NUMBER COULD NOT BE EMPTY",
        /*NATIONAL ID       */"NATIONAL ID COULD NOT BE EMPTY",
        /*OPERATION         */"OPERATION COULD NOT BE EMPTY",
        /*NAME ON CARD    */"NAME ON CARD LENGHT IS INCORRECT, MAX 24",
        /*FISRT NAME      */"FISRT NAME LENGHT IS INCORRECT, MAX 40",
        /*MIDDLE NAME     */"MIDDLE NAME LENGHT IS INCORRECT, MAX 40",
        /*LAST NAME       */"LAST NAME LENGHT IS INCORRECT, MAX 40",
        /*FIRST NAME AR   */"FIRST NAME AR LENGHT IS INCORRECT, MAX 40",
        /*MIDDLE NAME AR  */"MIDDLE NAME AR LENGHT IS INCORRECT, MAX 40",
        /*LAST NAME AR    */"LAST NAME AR LENGHT IS INCORRECT, MAX 40",
        /*CUSTOMER TYPE   */"CUSTOMER TYPE LENGHT IS INCORRECT, MAX 1",
        /*ACCOUNT TYPE    */"ACCOUNT TYPE LENGHT IS INCORRECT, MAX 1",
        /*AUTO RELOAD     */"AUTO RELOAD LENGHT IS INCORRECT, MAX 1",
        /*CUSTOMER ADDRESS*/"CUSTOMER ADDRESS LENGHT IS INCORRECT, MAX 80",
        /*PHONE NUMBER    */"PHONE NUMBER LENGHT IS INCORRECT, MAX 20",
        /*NATIONAL ID     */"NATIONAL ID LENGHT IS INCORRECT, MAX 20",
        /*OPERATION       */"OPERATION LENGHT IS INCORRECT, MAX 6",
        /*NATIONAL ID TYPE NUM    */"NATIONAL ID TYPE  VALUE INCORRECT, SHOULD BE NUMERIC",
        /*BANK CODE NUM           */"BANK CODE  VALUE INCORRECT, SHOULD BE NUMERIC",
        /*CURRENCY CODE NUM       */"CURRENCY CODE  VALUE INCORRECT, SHOULD BE NUMERIC",
        /*BRANCH CODE NUM         */"BRANCH CODE  VALUE INCORRECT, SHOULD BE NUMERIC",
        /*CARD PROGRAM CODE NUM   */"CARD PROGRAM CODE  VALUE INCORRECT, SHOULD BE NUMERIC",
        /*PREPAID PROGRAM CODE NUM*/"PREPAID PROGRAM CODE  VALUE INCORRECT, SHOULD BE NUMERIC",
        /*CITY CODE NUM           */"CITY CODE  VALUE INCORRECT, SHOULD BE NUMERIC",
        /*NATIONAL ID TYPE NUM    */"NATIONAL ID TYPE COULD NOT BE EMPTY",
        /*BANK CODE NUM           */"BANK CODE COULD NOT BE EMPTY",
        /*CURRENCY CODE NUM       */"CURRENCY CODE COULD NOT BE EMPTY",
        /*BRANCH CODE NUM         */"BRANCH CODE COULD NOT BE EMPTY",
        /*CARD PROGRAM CODE NUM   */"CARD PROGRAM CODE COULD NOT BE EMPTY",
        /*PREPAID PROGRAM CODE NUM*/"PREPAID PROGRAM CODE COULD NOT BE EMPTY",
        /*CITY CODE NUM           */"CITY CODE COULD NOT BE EMPTY",
        /*APPLICATION_ID_EMPTY*/"APPLICATION ID COULD NOT BE EMPTY",
        /*APPLICATION_ID_LENGHT*/"APPLICATION ID LENGHT IS INCORRECT, MAX 24",
        /*ACTION_EMPTY*/"ACTIONCOULD NOT BE EMPTY",
        /*ACTION_LENGHT*/"ACTION LENGHT IS INCORRECT, MAX 1",
        /*BIRTH_DATE_EMPTY*/"BIRTH DATE COULD NOT BE EMPTY", 
        /*BIRTH_DATE_FORMAT*/"THE DATE FORMAT SHOULD BE DD/MM/YYYY",
        /*APPLICATION_ID_EMPTY*/"APPLICATION ID COULD NOT BE EMPTY",
        /*CUSTOMER_ID_EMPTY*/"CUSTOMER ID COULD NOT BE EMPTY",
        /*TYPE_ACCOUNT_EMPTY*/"TYPE ACCOUNT COULD NOT BE EMPTY",
        /*BANK_ACCOUNT_TYPE_EMPTY*/"NAME ON CARD COULD NOT BE EMPTY",
        /*GENDER_EMPTY*/"BANK ACCOUNT TYPE COULD NOT BE EMPTY",
        /*BIRTH_DATE_LOCATION_EMPTY*/"BIRTH DATE LOCATION COULD NOT BE EMPTY",
        /*CORPORATE_NAME_EMPTY*/"CORPORATE NAME COULD NOT BE EMPTY",
        /*ZIP_ADDRESS_EMPTY*/"ZIP ADDRESS COULD NOT BE EMPTY",
        /*FAX_EMPTY*/"FAX COULD NOT BE EMPTY",
        /*APPLICATION_ID_LENGHT*/"APPLICATION ID COULD NOT BE LENGHT",
        /*CUSTOMER_ID_LENGHT*/"CUSTOMER ID COULD NOT BE LENGHT",
        /*TYPE_ACCOUNT_LENGHT*/"TYPE ACCOUNT COULD NOT BE LENGHT",
        /*BANK_ACCOUNT_TYPE_LENGHT*/"NAME ON CARD COULD NOT BE LENGHT",
        /*GENDER_LENGHT*/"BANK ACCOUNT TYPE COULD NOT BE LENGHT",
        /*BIRTH_DATE_LOCATION_LENGHT*/"BIRTH DATE LOCATION COULD NOT BE LENGHT",
        /*CORPORATE_NAME_LENGHT*/"CORPORATE NAME COULD NOT BE LENGHT",
        /*ZIP_ADDRESS_LENGHT*/"ZIP ADDRESS COULD NOT BE LENGHT",
        /*FAX_LENGHT*/"FAX COULD NOT BE LENGHT",
        /*PROFETIONAL_POS_NUM   */"PROFETIONAL POS VALUE INCORRECT, SHOULD BE NUMERIC",
        /*MARITAL_STATUS_NUM    */"MARITAL STATUS VALUE INCORRECT, SHOULD BE NUMERIC",
        /*TITLE_NUM             */"TITLE VALUE INCORRECT, SHOULD BE NUMERIC",
        /*DEBIT_PROGRAM_NUM     */"DEBIT PROGRAM VALUE INCORRECT, SHOULD BE NUMERIC",
        /*COUNTRY_NUM           */"COUNTRY VALUE INCORRECT, SHOULD BE NUMERIC",
        /*ADDRESS_TYPE_NUM      */"ADDRESS TYPE VALUE INCORRECT, SHOULD BE NUMERIC",
        /*PROFETIONAL_POS_EMPTY    */"PROFETIONAL POS COULD NOT BE EMPTY",
        /*MARITAL_STATUS_EMPTY     */"MARITAL STATUS COULD NOT BE EMPTY",
        /*TITLE_EMPTY              */"TITLE COULD NOT BE EMPTY",
        /*DEBIT_PROGRAM_EMPTY      */"DEBIT COULD NOT BE EMPTY",
        /*COUNTRY_EMPTY            */"COUNTRY COULD NOT BE EMPTY",
        /*ADDRESS_TYPE_EMPTY       */"ADDRESS COULD NOT BE EMPTY",
        /*CARD_NUM      */"CARD VALUE INCORRECT, SHOULD BE NUMERIC",
        /*INSTITUTION_NUM      */"INSTITUTION VALUE INCORRECT, SHOULD BE NUMERIC",
        /*PAYMENT_MODE_EMPTY       */"PAYMENT MODE NOT BE EMPTY",
        /*RELOAD_FEE_EMPTY       */"RELOAD FEE NOT BE EMPTY",
        /*RELOAD_AMOUNT_EMPTY       */"THE THE RELOAD AMOUNT NOT BE EMPTY",
        /*PAYMENT_MODE_NUM      */"PAYMENT MODE VALUE INCORRECT, SHOULD BE NUMERIC",
        /*RELOAD_FEE_NUM      */"RELOAD FEE VALUE INCORRECT, SHOULD BE NUMERIC",
        /*RELOAD_AMOUNT_NUM      */"YOW RELOAD AMOUNT VALUE INCORRECT, SHOULD BE NUMERIC",
        /*RELOAD_ACCOUNT_EMPTY       */"RELOAD ACCOUNT NOT BE EMPTY",
        /*RELOAD_ACCOUNT_LENGHT    */"RELOAD ACCOUNT LENGHT IS INCORRECT, MAX 24",
        /*PHONE_NUMBER_NUM     */"PHONE NUMBER VALUE INCORRECT, SHOULD BE NUMERIC"
          
    };
    
    public static String ccode(int idxError){
        return String.valueOf(idxError+ID_CHECK);
    }
    
    public static String cmsg(int idxError){
        return LIST_CHECKS[idxError];
    }
    
    public static String scode(int idxError){
        return String.valueOf(idxError+ID_STATUS);
    }
    
    public static String smsg(int idxError){
        return LIST_STATUS[idxError];
    }
    
    public static String ecode(int idxError){
        if (idxError<0) return "";
        return String.valueOf(idxError+ID_ERROR);
    }
    
    public static String emsg(int idxError){
        if (idxError<0) return "";
        return LIST_ERRORS[idxError];
    }
}

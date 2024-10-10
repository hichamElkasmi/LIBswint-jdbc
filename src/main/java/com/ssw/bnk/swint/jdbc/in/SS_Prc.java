package com.ssw.bnk.swint.jdbc.in;

import com.owlike.genson.Genson;
import com.ssw.bnk.swint.jdbc.*;
import static com.ssw.bnk.swint.jdbc.SS_INIT.isLiveCtx;
import com.ssw.bnk.swint.jdbc.entities.*;
import static com.ssw.bnk.swint.jdbc.in.SS_Df.*;
import com.ssw.bnk.swint.jdbc.requests.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 *
 * @author MOKHLISS
 */
public class SS_Prc {

	// BLA
	private static final String ALGO = "SHA-256";
	private static final String KEY_CLIENT = "142DF54EF47ZE78B";
	private static final String KEY_HOST = "552A15CF5889EAFF";

	private static final short CLR = 0;
	private static final short SQL = 1;
	private static final short REQ = 2;
	private static final short RES = 3;

	private static final OpgEnt_Header DEFAULT_HEAD = new OpgEnt_Header("999999999999", "999999999999");
	private static final String PACKAGE  = "call opengatev2.opengate_issuer";
	private static final String PACKAGE2 = "call opengatev2.opengate_card_management";
	private static final String PACKAGE3 = "call opengatev2.opengate_repository";
	private static final String PACKAGE4 = "call opengatev2.opengate_acquirer";
        private static final String PACKAGE5 = "call opengatev2.opengate_tools";


	private static final String GET_BALANCE[] = { " <getBalance> ", "{" + PACKAGE + ".getbalance(?,?)}" };
	private static final String CHANGE_STATUS[] = { " <changeStatus ", "{" + PACKAGE2 + ".change_status(?,?)}" };
	private static final String FIRST_ACTIVATION[] = { " <firstactivation ", "{" + PACKAGE2 + ".firstactivation(?,?)}" };
	private static final String RESET_PIN[] = { " <resetPin ", "{" + PACKAGE2 + ".reset_pin(?,?)}" };
	private static final String GET_REPOSITORY[] = { " <getrepository ", "{" + PACKAGE3 + ".get_repository(?,?)}" };
	private static final String REPLACEMENT[] = { " <replacement ", "{" + PACKAGE2 + ".replacement(?,?)}" };
	private static final String RENEW[] = { " <renew ", "{" + PACKAGE2 + ".renew(?,?)}" };
	private static final String CARD_LIST[] = { " <cardlist ", "{" + PACKAGE2 + ".card_list(?,?)}" };
	private static final String ACCOUNT_LIST[] = { " <accountlist ", "{" + PACKAGE2 + ".account_list(?,?)}" };
	private static final String CUSTOMER_LIST[] = { " <customerlist ", "{" + PACKAGE2 + ".customer_list(?,?)}" };
	private static final String PINGSERVER[] = { " <ping ", "{" + PACKAGE5 + ".ping(?,?)}" };
	
	private static final String PREPAID_APPLICATION[] = { " <prepaidapplication ",
			"{" + PACKAGE2 + ".prepaidapplication(?,?)}" };
	
	private static final String PREPAID_APPLI_VALIDATION[] = { " <prepaidapplicationvalidation ",
			"{" + PACKAGE2 + ".prepaidapplicationvalidation(?,?)}" };
	
	private static final String PREPAID_APPLICATION_LIST[] = { " <prepaidapplicationlist ",
			"{" + PACKAGE2 + ".prepaidapplication_list(?,?)}" };
	
	private static final String DEBIT_APPLICATION[] = { " <debitapplication ",
			"{" + PACKAGE2 + ".debitapplication(?,?)}" };
	
	private static final String DEBIT_APPLI_VALIDATION[] = { " <debitapplicationvalidation ",
			"{" + PACKAGE2 + ".debitapplicationvalidation(?,?)}" };
	
	private static final String DEBIT_APPLICATION_LIST[] = { " <debitapplicationlist ",
			"{" + PACKAGE2 + ".debitapplication_list(?,?)}" };
	
	private static final String REDEMPTION[] = { " <remption ",
			"{" + PACKAGE2 + ".redemption(?,?)}" };
	
	private static final String RELOAD[] = { " <reload ",
			"{" + PACKAGE2 + ".reload(?,?)}" };
	
	private static final String MERCHANT[] = { " <merchantapplication ",
			"{" + PACKAGE4 + ".merchantapplication(?,?)}" };
	
	private static final String MERCHANT_APPLICATION_UPDATE[] = { " <merchantapplicationupdate ",
			"{" + PACKAGE4 + ".merchantapplicationupdate(?,?)}" };
	
	private static final String MERCHANT_UPDATE[] = { " <merchantupdate ",
			"{" + PACKAGE4 + ".merchantupdate(?,?)}" };
	
	private static final String MERCHANT_APPLI_VALIDATION[] = { " <merchantapplicationvalidation ",
			"{" + PACKAGE4 + ".merchantapplicationvalidation(?,?)}" };
	
	private static final String MERCHANT_APPLICATION_LIST[] = { " <merchantapplicationlist ",
			"{" + PACKAGE4 + ".merchantapplication_list(?,?)}" };
	
	private static final String POS_TERMINAL_APPLICATION[] = { " <posterminalposapplication ",
			"{" + PACKAGE4 + ".posterminal_posapplication(?,?)}" };
	
	private static final String POS_TERMINAL_LIST[] = { " <posterminallist ",
			"{" + PACKAGE4 + ".posterminal_list(?,?)}" };
	
	private static final String POS_APPLICATION_LIST[] = { " <posapplicationlist ",
			"{" + PACKAGE4 + ".posapplication_list(?,?)}" };
	
	private static final String AUTHORIZATION_LIST[] = { " <authorizationlist ",
			"{" + PACKAGE2 + ".authorization_list(?,?)}" };
	
	private static final String GET_TRANSACTION[] = { " <getTransaction ", "{" + PACKAGE + ".gettrnxhistory(?,?)}" };
	
	private static final String GET_ACCOUNT_TRANSFER[] = { " <accounttransfer ", "{" + PACKAGE + ".accounttransfert(?,?)}" };
	
	private static final String CHECK_BOOK_REQUEST[] = { " <checkbookrequest ", "{" + PACKAGE + ".checkbookrequest(?,?)}" };
	
		// HZ
	
	private static final String CREDIT_APPLICATION[] = { " <creditapplication ",
			"{" + PACKAGE2 + ".creditapplication(?,?)}" };

	private static final String CREDIT_APPLI_VALIDATION[] = { " <creditapplicationvalidation ",
			"{" + PACKAGE2 + ".creditapplicationvalidation(?,?)}" };
	
	private static final String CREDIT_APPLICATION_LIST[] = { " <creditapplicationlist ",
			"{" + PACKAGE2 + ".creditapplication_list(?,?)}" };
	
	private static final String MOBILE_UPDATE[] = { " <mobileupdate ",
			"{" + PACKAGE2 + ".update_mobile(?,?)}" };
	
	private static final String ACCOUNT_UPDATE[] = { " <accountupdate ",
			"{" + PACKAGE2 + ".update_account(?,?)}" };
	
	private static final String MERCHANT_STATUS[] = { " <merchantstatus ",
			"{" + PACKAGE4 + ".update_merchant_status(?,?)}" };
	
	private static final String INTERFACE_LIST[] = { " <interfacelist ",
			"{" + PACKAGE4 + ".interface_list(?,?)}" };
	
	
	private static final String INTERNET_MAIL_ORDER_STATUS[] = { " <internetmailorderstatus ",
			"{" + PACKAGE2 + ".InternetMailOrder_status(?,?)}" };
			
	private static final String ANONYM_PREPAID[] = { " <anonymprepaid ",
			"{" + PACKAGE2 + ".anonymPrepaidCard(?,?)}" };
	
	private static final String MERCHANT_COMMISSION[] = { " <merchantcommission ",
			"{" + PACKAGE4 + ".update_merchant_commission(?,?)}" };

	private static final String MANAGE_ADDRESS[] = { " <manageaddress ",
			"{" + PACKAGE2 + ".address_manage(?,?)}" };
			
	private static final String ADD_CHARGEBACK[] = { " <addchargeback ",
			"{" + PACKAGE2 + ".ChargeBack(?,?)}" };
	
	private static final String PURCHASE_AUTH[] = { " <purchaseauth ",
			"{" + PACKAGE2 + ".purchaseauth(?,?)}" };
        
        private static final String DEBIT_APPLICATION_VIRTUAL_CARD[] = { " <debitapplication_virtual_card ", "{" + PACKAGE2 + ".debitapplication_virtual_card(?,?)}" };
	private static final String VALIDATE_CARD_PIN[] = { " <validate_card_pin ", "{" + PACKAGE2 + ".validate_card_pin(?,?)}" };
        private static final String VALIDATE_CARD_PIN0209[] = { " <validate_card_pin0209 ", "{" + PACKAGE2 + ".validate_card_pin0209(?,?)}" };
        private static final String NOTIFY[] = { " <notify ", "{" + PACKAGE2 + ".notify(?,?)}" };
        private static final String GET_CARD_PRINT_DATA[] = { " <get_card_print_data ", "{" + PACKAGE2 + ".get_card_print_data(?,?)}" };


        private static final String get_message_from_db[] = { " <getMessageFromDB ", "{" + PACKAGE2 + ".get_message_from_db(?)}" };


	private static final String AUTH_REVERSAL[] = { " <authreversal ","{" + PACKAGE2 + ".authreversal(?,?)}" }; 
	private static final String PURCHASE_ADVICE[] = { " <purchaseadvice ","{" + PACKAGE2 + ".PurchaseAdvice(?,?)}" }; 
	private static final String UPDATE_RISK_CODE[] = { " <updateriskcode ", "{" + PACKAGE2 + ".update_risk_card(?,?)}" };
	private static final String ANONYM_DEBIT[] = { " <anonymdebit ", "{" + PACKAGE2 + ".anonymDebitCard(?,?)}" };
        private static final String GET_TERMINARLS_BY_MERCHANT_ID[] = { " <getterminalsbymerchantid ", "{" + PACKAGE4 + ".GET_TERMINARLS_BY_MERCHANT_ID(?,?)}" };
	private static final String GET_MERCHANT_TRANSACTIONS[] = { " <getmerchanttransactions ", "{" + PACKAGE4 + ".GET_MERCHANT_TRANSACTIONS(?,?)}" };
	private static final String GET_MERCHANT_TERMINAL_TRANSACTIONS[] = { " <getmerchantterminaltransactions ","{" + PACKAGE4 + ".GET_MERCHANT_TERMINAL_TRANSACTIONS(?,?)}" };
	private static final String GET_CARD_RISK[] = { " <getcardrisk ", "{" + PACKAGE2 + ".GET_CARD_RISK(?,?)}" };
	private static final String GET_POS_MONITORING[] = { " <getposmonitoring ", "{" + PACKAGE4 + ".GET_POS_MONITORING(?,?)}" };
	private static final String DEBIT_APPLICATION_TEMP[] = { " <debitapplicationtemp ", "{" + PACKAGE2 + ".debitapplicationtemp(?,?)}" };
	private static final String SEND_PIN_BY_SMS[] = { " <sendpinbysms ", "{" + PACKAGE2 + ".SEND_PIN_BY_SMS(?,?)}" };
	private static final String SEND_PIN_BY_EMAIL[] = { " <sendpinbyemail ", "{" + PACKAGE2 + ".SEND_PIN_BY_EMAIL(?,?)}" };
	private static final String SEND_SMS_ALERT[] = { " <sendsmsalert ", "{" + PACKAGE2 + ".SEND_SMS_ALERT(?,?)}" };
	private static final String ATM_MONITORING[] = { " <atmmonitoring ", "{" + PACKAGE4 + ".ATM_MONITORING(?,?)}" };
	private static final String UPDATE_RISK_CARD_NEW[] = { " <updateriskcardnew ", "{" + PACKAGE2 + ".UPDATE_RISK_CARD_NEW(?,?)}" };
	private static final String GET_PROGRAM_RISK[] = { " <getprogramrisk ", "{" + PACKAGE2 + ".GET_PROGRAM_RISK(?,?)}" };
	private static final String GET_CARD_LIMIT_RISK[] = { " <getcardlimitrisk ", "{" + PACKAGE2 + ".GET_CARD_LIMIT_RISK(?,?)}" };
	private static final String GET_STATUS_TYPE_TRANS_CARD[] = { " <getstatustypetrans ", "{" + PACKAGE2 + ".GET_STATUS_TYPE_TRANS_CARD(?,?)}" };
	
public SS_Prc() {

	}

	public OpgEnt_Auth processAuthentification(OpgEnt_Header header) {
		String originalString, evvString;
		byte[] encodedhash;
		MessageDigest digest;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status = new SS_Stt(scode(ST_APPROVED), smsg(ST_APPROVED), ecode(ER_CLEAN), emsg(ER_CLEAN));

		if (!sS_Chk.checkDataAuth(header)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());

			return (new OpgEnt_Auth(getHostHeader(DEFAULT_HEAD.getIdmsg()), sS_Status));

		}

		try {
			digest = MessageDigest.getInstance(ALGO);
			originalString = header.getIdmsg() + KEY_CLIENT;
			encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
			evvString = DatatypeConverter.printHexBinary(encodedhash).substring(0, 16);

			if (!evvString.equalsIgnoreCase(header.getMac())) {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), ecode(ER_AUTH), emsg(ER_AUTH));
			}
		} catch (Exception e) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), ecode(ER_AUTH), emsg(ER_AUTH));
		}

		return (new OpgEnt_Auth(getHostHeader(header.getIdmsg()), sS_Status));
	}

	private OpgEnt_Header getHostHeader(String idMsg) {
		String originalString, evvString;
		byte[] encodedhash;
		MessageDigest digest;
		OpgEnt_Header header;

		try {

			digest = MessageDigest.getInstance(ALGO);
			originalString = idMsg + KEY_HOST;

			encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
			evvString = DatatypeConverter.printHexBinary(encodedhash).substring(0, 16);
			header = new OpgEnt_Header(idMsg, evvString);

		} catch (Exception e) {
			header = DEFAULT_HEAD;
		}

		return header;
	}

	// BLA
	public String formatJsonOutput(SS_Ret sSReturn) {
		String jsonString;
		Genson genson;
		try {
			genson = SS_INIT.builder.create();
			jsonString = genson.serialize(sSReturn);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			jsonString = null;
		}
		return jsonString;
	}

	public String formatJsonOutput(SS_ER sSReturn) {
		String jsonString;
		Genson genson;
		try {
			genson = SS_INIT.builder.create();
			jsonString = genson.serialize(sSReturn);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			jsonString = null;
		}
		return jsonString;
	}

	public String formatJsonOutput(OpgEnt_Header header) {
		String jsonString;
		Genson genson;
		try {
			genson = SS_INIT.builder.create();
			jsonString = genson.serialize(header);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			jsonString = null;
		}
		return jsonString;
	}

	public String formatJsonOutput(SS_Ba sSReturn) {
		String jsonString;
		Genson genson;
		try {
			genson = SS_INIT.builder.create();
			jsonString = genson.serialize(sSReturn);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			jsonString = null;
		}
		return jsonString;
	}

	// By SABRI Med

	public String clobToString(Clob data) {
		StringBuilder sb = new StringBuilder();
		try {
			Reader reader = data.getCharacterStream();
			BufferedReader br = new BufferedReader(reader);

			String line;
			while (null != (line = br.readLine())) {
				sb.append(line);
			}
			br.close();
		} catch (SQLException e) {
			// handle this exception
		} catch (IOException e) {
			// handle this exception
		}
		return sb.toString();
	}

	public String TransformStringToJson(String authHeader, String response) {
        //SLAOUI DOUNIA 16042021 ajout body
        //SLAOUI DOUNIA 16042021 DECODAGE UTF8
        try
        {
              byte[] utf8Bytes = response.getBytes("ISO-8859-1");
                response = new String(utf8Bytes, "UTF-8");
                } catch (IOException e) {
			// handle this exception
		}
		response = "{\"header\":" + authHeader + ",\"body\":" + response + "}";
		return response;

	}

	public String getBalance(OpgReq_Balance reqBalance) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		SS_Ba ss_ba = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqBalance);

		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqBalance.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataInstitution(reqBalance.getInitiator().getInstitution())
			    ){
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = GET_BALANCE[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						if (response.contains("balance")) {

							JSONObject json = (JSONObject) new JSONParser().parse(response);
							JSONObject balance = (JSONObject) json.get("balance");
							JSONObject status = (JSONObject) json.get("status");
							ss_ba = new SS_Ba(auth.getHeader(),
									new OpgEnt_Balance(balance.get("available").toString(),
											balance.get("currency").toString()),
									new OpgEnt_Status(status.get("errorcode").toString(),
											status.get("errordesc").toString()));
							response = formatJsonOutput(ss_ba);
                                                        
                                                     
                                                        

						} else {

							JSONObject json = (JSONObject) new JSONParser().parse(response);
							JSONObject status = (JSONObject) json.get("status");
							ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
									status.get("errordesc").toString()));
							response = formatJsonOutput(ss_er);

						}

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String changeStatusCard(OpgReq_CardStUp cardStUp) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
                String authHeader="";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(cardStUp);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(cardStUp.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataStatus(cardStUp.getInitiator().getStatus())
					&& sS_Chk.checkDataExpiry(cardStUp.getInitiator().getExpiry())
					&& sS_Chk.checkDataCard(cardStUp.getInitiator().getCard())
					&& sS_Chk.checkDataInstitution(cardStUp.getInitiator().getInstitution())) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = CHANGE_STATUS[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);
                                                authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);
                                                        

						//JSONObject json = (JSONObject) new JSONParser().parse(response);
						//JSONObject status = (JSONObject) json.get("status");
						//ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
						//		status.get("errordesc").toString()));
						//response = formatJsonOutput(ss_er);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
        
      	public String firstActivation(OpgReq_CardFirstActivation cardFirActi) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
                String authHeader="";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(cardFirActi);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(cardFirActi.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataCard(cardFirActi.getInitiator().getCard())
					&& sS_Chk.checkDataInstitution(cardFirActi.getInitiator().getInstitution())) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = FIRST_ACTIVATION[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);
                                                authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);
					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
        
	public String resetPin(OpgReq_ResetPin reqResetPin) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
                String authHeader ="";
		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqResetPin);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqResetPin.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataExpiry(reqResetPin.getInitiator().getExpiry())
					&& sS_Chk.checkDataCard(reqResetPin.getInitiator().getCard())
					&& sS_Chk.checkDataInstitution(reqResetPin.getInitiator().getInstitution())) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = RESET_PIN[SQL];
						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);
                                                authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String getRepository(OpgReq_GetRepos reqGetRepo) {
		SS_Ret ss_ret = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		Clob repoRes = null;
		String authHeader ="";
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqGetRepo);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqGetRepo.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataData(reqGetRepo.getInitiator().getData())
				&& sS_Chk.checkDataInstitution(reqGetRepo.getInitiator().getInstitution())	
					) {
				try {

					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = GET_REPOSITORY[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, repoRes);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.executeUpdate();
						repoRes = callableStatement.getClob(2);
						response = clobToString(repoRes);
                                         
                                                authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}

				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);

				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String replacement(OpgReq_Replacement reqReplacement) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
                String authHeader="";
		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqReplacement);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqReplacement.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataNewpan(reqReplacement.getInitiator().getNew_pan())
					&& sS_Chk.checkDataReplacementReason(reqReplacement.getInitiator().getReplacement_reason())
					&& sS_Chk.checkDataExpiry(reqReplacement.getInitiator().getExpiry())
					&& sS_Chk.checkDataCard(reqReplacement.getInitiator().getCard())
					&& sS_Chk.checkDataInstitution(reqReplacement.getInitiator().getInstitution())) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = REPLACEMENT[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						//JSONObject json = (JSONObject) new JSONParser().parse(response);
						//JSONObject status = (JSONObject) json.get("status");
						//ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
								//status.get("errordesc").toString()));
						//response = formatJsonOutput(ss_er);
                                                authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);
					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String reNew(OpgReq_ReNew reqRenew) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
                String authHeader="";

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqRenew);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqRenew.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataExpiry(reqRenew.getInitiator().getExpiry())
					&& sS_Chk.checkDataCard(reqRenew.getInitiator().getCard())
					&& sS_Chk.checkDataInstitution(reqRenew.getInitiator().getInstitution())
					&& sS_Chk.checkDataPinGeneration(reqRenew.getInitiator().getPin_generation())) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = RENEW[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						//JSONObject json = (JSONObject) new JSONParser().parse(response);
						//JSONObject status = (JSONObject) json.get("status");
						//ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
								//status.get("errordesc").toString()));
						//response = formatJsonOutput(ss_er);
            authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String cardList(OpgReq_CardList reqCardList) {
		SS_Ret ss_ret = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob cardListResponse = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqCardList);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqCardList.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataInstitution(reqCardList.getFilter().getInstitution())
					&& sS_Chk.checkDataVarchar(reqCardList.getFilter().getCard(),"CARD",94, 16,'F')
					&& sS_Chk.checkDataStartNumeric(reqCardList.getFilter().getStart())
					&& sS_Chk.checkDataEndNumeric(reqCardList.getFilter().getEnd())
					&& sS_Chk.compareTwoNumber(reqCardList.getFilter().getStart(), reqCardList.getFilter().getEnd())
					&& sS_Chk.checkDataNumber(reqCardList.getFilter().getPan(),"PAN", 96, 'F')
                                		
					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = CARD_LIST[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, cardListResponse);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.executeUpdate();
						cardListResponse = callableStatement.getClob(2);
                                                
                                               response = clobToString(cardListResponse);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String accountList(OpgReq_AccountList reqAccountList) {
		SS_Ret ss_ret = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob accountListResponse = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqAccountList);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqAccountList.getHeader());
		if (auth.checkStatus()) {
			if (sS_Chk.checkDataInstitution(reqAccountList.getFilter().getInstitution())
					&& sS_Chk.checkDataStartNumeric(reqAccountList.getFilter().getStart())
					&& sS_Chk.checkDataEndNumeric(reqAccountList.getFilter().getEnd()) 
                                        && sS_Chk.compareTwoNumber( reqAccountList.getFilter().getStart(), reqAccountList.getFilter().getEnd())) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = ACCOUNT_LIST[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, accountListResponse);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.executeUpdate();
						accountListResponse = callableStatement.getClob(2);
						response = clobToString(accountListResponse);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);

			}
		} else { 
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String customerList(OpgReq_CustomerList reqCustomerList) {
		SS_Ret ss_ret = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob customerListResponse = null;

		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqCustomerList);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqCustomerList.getHeader());
		if (auth.checkStatus()) {
			if (sS_Chk.checkDataInstitution(reqCustomerList.getFilter().getInstitution())
					&& sS_Chk.checkDataStartNumeric(reqCustomerList.getFilter().getStart())
					&& sS_Chk.checkDataEndNumeric(reqCustomerList.getFilter().getEnd()) && sS_Chk.compareTwoNumber(
							reqCustomerList.getFilter().getStart(), reqCustomerList.getFilter().getEnd())) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = CUSTOMER_LIST[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, customerListResponse);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.executeUpdate();
						customerListResponse = callableStatement.getClob(2);
						response = clobToString(customerListResponse);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);

			}
		} else {
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String prepaidApplication(OpgReq_PrepaidApplication reqPrepApplication) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob prepPrepaidAppResponse = null;
		String authHeader = "";
              

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqPrepApplication);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// System.out.println("Arabic :
		// "+reqPrepApplication.getInitiator().getLastnamear());
		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqPrepApplication.getHeader());
		if (auth.checkStatus()) {
			
			
			if (reqPrepApplication.getInitiator().getOperation().equalsIgnoreCase("DELETE"))
			{
				
				if (sS_Chk.checkDataInstitution(reqPrepApplication.getInitiator().getInstitution())
						&& sS_Chk.checkDataOperation(reqPrepApplication.getInitiator().getOperation())
						&& sS_Chk.checkDataVarchar(reqPrepApplication.getInitiator().getApplicationid(), "APPLICATION ID",87, 24,'O')	

				) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = PREPAID_APPLICATION[SQL];

							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.registerOutParameter(2, Types.NVARCHAR);
							callableStatement.execute();
							response = callableStatement.getString(2);

							//JSONObject json = (JSONObject) new JSONParser().parse(response);
							//JSONObject status = (JSONObject) json.get("status");
							//ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
									//status.get("errordesc").toString()));
							//response = formatJsonOutput(ss_er);
                                                             authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);

						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());

					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
				
			}
			
			if (reqPrepApplication.getInitiator().getOperation().equalsIgnoreCase("UPDATE"))
			{
				
				if (sS_Chk.checkDataInstitution(reqPrepApplication.getInitiator().getInstitution())
						&& sS_Chk.checkDataNameoncard(reqPrepApplication.getInitiator().getNameoncard())
						&& sS_Chk.checkDataFirstname(reqPrepApplication.getInitiator().getFirstname())
						&& sS_Chk.checkDataMiddlename(reqPrepApplication.getInitiator().getMiddlename())
						&& sS_Chk.checkDataLastname(reqPrepApplication.getInitiator().getLastname())
						// &&
						// sS_Chk.checkDataFirstname(reqPrepApplication.getInitiator().getFirstnamear())
						// &&
						// sS_Chk.checkDataMiddlename(reqPrepApplication.getInitiator().getMiddlenamear())
						// &&
						// sS_Chk.checkDataLastname(reqPrepApplication.getInitiator().getLastnamear())
						&& sS_Chk.checkDataCustomertype(reqPrepApplication.getInitiator().getCustomertype())
						&& sS_Chk.checkDataAccounttype(reqPrepApplication.getInitiator().getAccounttype())
						&& sS_Chk.checkDataAutoreload(reqPrepApplication.getInitiator().getAutoreload())
						&& sS_Chk.checkDataCustomeraddress(reqPrepApplication.getInitiator().getCustomeraddress())
						//&& sS_Chk.checkDataPhonenumber(reqPrepApplication.getInitiator().getPhonenumber())
						&& sS_Chk.checkDataPhoneNumber(reqPrepApplication.getInitiator().getPhonenumber(),"PHONE NUMBER",93,'O')
						&& sS_Chk.checkDataNationalid(reqPrepApplication.getInitiator().getNationalid())
						&& sS_Chk.checkDataOperation(reqPrepApplication.getInitiator().getOperation())
						&& sS_Chk.checkDataNationalidtype(reqPrepApplication.getInitiator().getNationalidtype())
						// && sS_Chk.checkDataBankcode(reqPrepApplication.getInitiator().getbankcode) a
						// voir avec Hicham hit makaynch f requete li sift lia
						&& sS_Chk.checkDataCurrencycode(reqPrepApplication.getInitiator().getCurrencycode())
						&& sS_Chk.checkDataBranchcode(reqPrepApplication.getInitiator().getBranchcode())
						&& sS_Chk.checkDataCardprogramcode(reqPrepApplication.getInitiator().getCardprogramcode())
						&& sS_Chk.checkDataPrepaidprogramcode(reqPrepApplication.getInitiator().getPrepaidprogramcode())
						&& sS_Chk.checkDataCitycode(reqPrepApplication.getInitiator().getCitycode())
						&& sS_Chk.checkDataBirthdate(reqPrepApplication.getInitiator().getBirthdate())
						&& sS_Chk.checkDataVarchar(reqPrepApplication.getInitiator().getApplicationid(), "APPLICATION ID",87, 24,'O')	

				) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = PREPAID_APPLICATION[SQL];

							//callableStatement = connection.prepareCall(program);
							//callableStatement.setString(1, requestJson);
							//callableStatement.registerOutParameter(2, Types.NVARCHAR);
							//callableStatement.execute();
							//response = callableStatement.getString(2);
							
							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);	
							callableStatement.setClob(2, prepPrepaidAppResponse);
							callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
							callableStatement.executeUpdate();
							prepPrepaidAppResponse = callableStatement.getClob(2);
							response = clobToString(prepPrepaidAppResponse);
							authHeader = formatJsonOutput(auth.getHeader());
							response = TransformStringToJson(authHeader, response);

							/*JSONObject json = (JSONObject) new JSONParser().parse(response);
							JSONObject status = (JSONObject) json.get("status");
							ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
									status.get("errordesc").toString()));
							response = formatJsonOutput(ss_er);
							*/
 
						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);

						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());

					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
				
			}
			
			if (reqPrepApplication.getInitiator().getOperation().equalsIgnoreCase("ADD"))
			{
				
				if (sS_Chk.checkDataInstitution(reqPrepApplication.getInitiator().getInstitution())
						&& sS_Chk.checkDataNameoncard(reqPrepApplication.getInitiator().getNameoncard())
						&& sS_Chk.checkDataFirstname(reqPrepApplication.getInitiator().getFirstname())
						&& sS_Chk.checkDataMiddlename(reqPrepApplication.getInitiator().getMiddlename())
						&& sS_Chk.checkDataLastname(reqPrepApplication.getInitiator().getLastname())
						// &&
						// sS_Chk.checkDataFirstname(reqPrepApplication.getInitiator().getFirstnamear())
						// &&
						// sS_Chk.checkDataMiddlename(reqPrepApplication.getInitiator().getMiddlenamear())
						// &&
						// sS_Chk.checkDataLastname(reqPrepApplication.getInitiator().getLastnamear())
						&& sS_Chk.checkDataCustomertype(reqPrepApplication.getInitiator().getCustomertype())
						&& sS_Chk.checkDataAccounttype(reqPrepApplication.getInitiator().getAccounttype())
						&& sS_Chk.checkDataAutoreload(reqPrepApplication.getInitiator().getAutoreload())
						&& sS_Chk.checkDataCustomeraddress(reqPrepApplication.getInitiator().getCustomeraddress())
						//&& sS_Chk.checkDataPhonenumber(reqPrepApplication.getInitiator().getPhonenumber())
						&& sS_Chk.checkDataPhoneNumber(reqPrepApplication.getInitiator().getPhonenumber(),"PHONE NUMBER",93,'O')
						&& sS_Chk.checkDataNationalid(reqPrepApplication.getInitiator().getNationalid())
						&& sS_Chk.checkDataOperation(reqPrepApplication.getInitiator().getOperation())
						&& sS_Chk.checkDataNationalidtype(reqPrepApplication.getInitiator().getNationalidtype())
						// && sS_Chk.checkDataBankcode(reqPrepApplication.getInitiator().getbankcode) a
						// voir avec Hicham hit makaynch f requete li sift lia
						&& sS_Chk.checkDataCurrencycode(reqPrepApplication.getInitiator().getCurrencycode())
						&& sS_Chk.checkDataBranchcode(reqPrepApplication.getInitiator().getBranchcode())
						&& sS_Chk.checkDataCardprogramcode(reqPrepApplication.getInitiator().getCardprogramcode())
						&& sS_Chk.checkDataPrepaidprogramcode(reqPrepApplication.getInitiator().getPrepaidprogramcode())
						&& sS_Chk.checkDataCitycode(reqPrepApplication.getInitiator().getCitycode())
						&& sS_Chk.checkDataBirthdate(reqPrepApplication.getInitiator().getBirthdate())

				) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = PREPAID_APPLICATION[SQL];

							//callableStatement = connection.prepareCall(program);
							//callableStatement.setString(1, requestJson);
							//callableStatement.registerOutParameter(2, Types.NVARCHAR);
							//callableStatement.execute();
							//response = callableStatement.getString(2);
							
							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							
							callableStatement.setClob(2, prepPrepaidAppResponse);
							callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
							callableStatement.executeUpdate();
							prepPrepaidAppResponse = callableStatement.getClob(2);
							response = clobToString(prepPrepaidAppResponse);
							authHeader = formatJsonOutput(auth.getHeader());
							response = TransformStringToJson(authHeader, response);

							/*JSONObject json = (JSONObject) new JSONParser().parse(response);
							JSONObject status = (JSONObject) json.get("status");
							ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
									status.get("errordesc").toString()));
							response = formatJsonOutput(ss_er);
							*/

						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);

						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());

					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
				
			}

			
			
			
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String prepaidAppliValidation(OpgReq_PrepaidAppliValidation reqPrepaidAppliValidation) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
                String authHeader ;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqPrepaidAppliValidation);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqPrepaidAppliValidation.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataInstitution(reqPrepaidAppliValidation.getInitiator().getInstitution())
					&& sS_Chk.checkDataApplicationId(reqPrepaidAppliValidation.getInitiator().getApplicationid())
					&& sS_Chk.checkDataAction(reqPrepaidAppliValidation.getInitiator().getAction())) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = PREPAID_APPLI_VALIDATION[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						//JSONObject json = (JSONObject) new JSONParser().parse(response);
						//JSONObject status = (JSONObject) json.get("status");
						//ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
							//	status.get("errordesc").toString()));
						//response = formatJsonOutput(ss_er);
                                                  authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String prepaidApplicationList(OpgReq_PrepaidApplicationList reqPrepaidAppList) {
		SS_Ret ss_ret = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob prepAppListResponse = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqPrepaidAppList);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqPrepaidAppList.getHeader());
		if (auth.checkStatus()) {
			if (sS_Chk.checkDataInstitution(reqPrepaidAppList.getFilter().getInstitution())
					
			   && sS_Chk.checkDataVarchar(reqPrepaidAppList.getFilter().getAccountnumber(),"ACCOUNT NUMBER",54, 24,'F')
			   && sS_Chk.checkDataVarchar(reqPrepaidAppList.getFilter().getApplicationid(),"APPLICATION ID",55, 24,'F')
			   && sS_Chk.checkDataVarchar(reqPrepaidAppList.getFilter().getApplicationid(),"NATIONAL ID",56, 20,'F')
			   && sS_Chk.checkDataNumber(reqPrepaidAppList.getFilter().getApplicationcode(),"APPLICATION CODE", 57, 'F')
			   && sS_Chk.checkDataNumber(reqPrepaidAppList.getFilter().getBranchcode(),"BRANCH CODE", 58, 'F')
			   && sS_Chk.checkDataNumber(reqPrepaidAppList.getFilter().getStart(),"START", 59, 'F')
			   && sS_Chk.checkDataNumber(reqPrepaidAppList.getFilter().getEnd(),"END", 60, 'F')
			   && sS_Chk.checkDataVarchar(reqPrepaidAppList.getFilter().getCustomerid(),"CUSTOMER ID",61, 24,'F') 
			   && sS_Chk.compareTwoNumber(reqPrepaidAppList.getFilter().getStart(), reqPrepaidAppList.getFilter().getEnd())
					
					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = PREPAID_APPLICATION_LIST[SQL];
						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, prepAppListResponse);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.executeUpdate();
						prepAppListResponse = callableStatement.getClob(2);
						response = clobToString(prepAppListResponse);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);

			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String debitApplication(OpgReq_DebitApplication reqDebitApplication) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob debitAppResponse = null;
		String authHeader = "";

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqDebitApplication);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// System.out.println("Arabic :
		// "+reqPrepApplication.getInitiator().getLastnamear());
		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqDebitApplication.getHeader());
		if (auth.checkStatus()) {
			
			if (reqDebitApplication.getInitiator().getOperation().equalsIgnoreCase("DELETE"))
			{
				
				if (sS_Chk.checkDataInstitution(reqDebitApplication.getInitiator().getInstitution())
						&& sS_Chk.checkDataOperation(reqDebitApplication.getInitiator().getOperation())				
						&& sS_Chk.checkDataApplicationId(reqDebitApplication.getInitiator().getApplicationid())
						) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = DEBIT_APPLICATION[SQL];

							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.registerOutParameter(2, Types.NVARCHAR);
							callableStatement.execute();
							response = callableStatement.getString(2);

							//JSONObject json = (JSONObject) new JSONParser().parse(response);
							//JSONObject status = (JSONObject) json.get("status");
							//ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
								//	status.get("errordesc").toString()));
							//response = formatJsonOutput(ss_er);
                                                         authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);

						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());

					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
				
			}
			
			
			if ( reqDebitApplication.getInitiator().getOperation().equalsIgnoreCase("ADD"))
			{
				
				if (sS_Chk.checkDataInstitution(reqDebitApplication.getInitiator().getInstitution())
						&& sS_Chk.checkDataNameoncard(reqDebitApplication.getInitiator().getNameoncard())
						&& sS_Chk.checkDataFirstname(reqDebitApplication.getInitiator().getFirstname())
						&& sS_Chk.checkDataMiddlename(reqDebitApplication.getInitiator().getMiddlename())
						&& sS_Chk.checkDataLastname(reqDebitApplication.getInitiator().getLastname())
						// sS_Chk.checkDataFirstname(reqDebitApplication.getInitiator().getFirstnamear())
						// sS_Chk.checkDataMiddlename(reqDebitApplication.getInitiator().getMiddlenamear())
						// sS_Chk.checkDataLastname(reqDebitApplication.getInitiator().getLastnamear())
						&& sS_Chk.checkDataCustomertype(reqDebitApplication.getInitiator().getCustomertype())
						&& sS_Chk.checkDataAccounttype(reqDebitApplication.getInitiator().getAccounttype())
						&& sS_Chk.checkDataCustomeraddress(reqDebitApplication.getInitiator().getCustomeraddress())
						//&& sS_Chk.checkDataPhonenumber(reqDebitApplication.getInitiator().getPhonenumber())
						&& sS_Chk.checkDataPhoneNumber(reqDebitApplication.getInitiator().getPhonenumber(),"PHONE NUMBER",93,'O')
						&& sS_Chk.checkDataNationalid(reqDebitApplication.getInitiator().getNationalid())
						&& sS_Chk.checkDataOperation(reqDebitApplication.getInitiator().getOperation())
						&& sS_Chk.checkDataNationalidtype(reqDebitApplication.getInitiator().getNationalidtype())
						&& sS_Chk.checkDataCurrencycode(reqDebitApplication.getInitiator().getCurrencycode())
						&& sS_Chk.checkDataBranchcode(reqDebitApplication.getInitiator().getBranchcode())
						&& sS_Chk.checkDataCardprogramcode(reqDebitApplication.getInitiator().getCardprogramcode())
						&& sS_Chk.checkDataCitycode(reqDebitApplication.getInitiator().getCitycode())
						&& sS_Chk.checkDataBirthdate(reqDebitApplication.getInitiator().getBirthdate())					
						//&& sS_Chk.checkDataApplicationId(reqDebitApplication.getInitiator().getApplicationid())
						&& sS_Chk.checkDataAccountnumber(reqDebitApplication.getInitiator().getAccountnumber())
						&& sS_Chk.checkDataCustomerid(reqDebitApplication.getInitiator().getCustomerid())
						&& sS_Chk.checkDataTypeaccount(reqDebitApplication.getInitiator().getAccounttype())
						&& sS_Chk.checkDataAccounttype(reqDebitApplication.getInitiator().getAccounttype())
						&& sS_Chk.checkDataGender(reqDebitApplication.getInitiator().getGender())
						&& sS_Chk.checkDataBirthdatelocation(reqDebitApplication.getInitiator().getBirthdatelocation())
						&& sS_Chk.checkDataCorporatename(reqDebitApplication.getInitiator().getCorporatename())
						&& sS_Chk.checkDataFax(reqDebitApplication.getInitiator().getFax())
						&& sS_Chk.checkDataProfetionalposition(reqDebitApplication.getInitiator().getProfetionalposition())
						&& sS_Chk.checkDataMaritalstatus(reqDebitApplication.getInitiator().getMaritalstatus())
						&& sS_Chk.checkDataTitle(reqDebitApplication.getInitiator().getTitle())
						&& sS_Chk.checkDataDebitprogram(reqDebitApplication.getInitiator().getDebitprogram())
						&& sS_Chk.checkDataCountry(reqDebitApplication.getInitiator().getCountry())
						&& sS_Chk.checkDataAddresstype(reqDebitApplication.getInitiator().getAddresstype())
						) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = DEBIT_APPLICATION[SQL];

							//callableStatement = connection.prepareCall(program);
							//callableStatement.setString(1, requestJson);
							//callableStatement.registerOutParameter(2, Types.NVARCHAR);
							//callableStatement.execute();
							//response = callableStatement.getString(2);
							//JSONObject json = (JSONObject) new JSONParser().parse(response);
							//JSONObject status = (JSONObject) json.get("status");
							//ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
							//		status.get("errordesc").toString()));
							//response = formatJsonOutput(ss_er);
							
							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.setClob(2, debitAppResponse);
							callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
							callableStatement.executeUpdate();
							debitAppResponse = callableStatement.getClob(2);
							response = clobToString(debitAppResponse);
							authHeader = formatJsonOutput(auth.getHeader());
							response = TransformStringToJson(authHeader, response);

						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);

						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());

					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
				
			}
			
			if (reqDebitApplication.getInitiator().getOperation().equalsIgnoreCase("UPDATE"))
					{
						
						if (sS_Chk.checkDataInstitution(reqDebitApplication.getInitiator().getInstitution())
								&& sS_Chk.checkDataNameoncard(reqDebitApplication.getInitiator().getNameoncard())
								&& sS_Chk.checkDataFirstname(reqDebitApplication.getInitiator().getFirstname())
								&& sS_Chk.checkDataMiddlename(reqDebitApplication.getInitiator().getMiddlename())
								&& sS_Chk.checkDataLastname(reqDebitApplication.getInitiator().getLastname())
								// sS_Chk.checkDataFirstname(reqDebitApplication.getInitiator().getFirstnamear())
								// sS_Chk.checkDataMiddlename(reqDebitApplication.getInitiator().getMiddlenamear())
								// sS_Chk.checkDataLastname(reqDebitApplication.getInitiator().getLastnamear())
								&& sS_Chk.checkDataCustomertype(reqDebitApplication.getInitiator().getCustomertype())
								&& sS_Chk.checkDataAccounttype(reqDebitApplication.getInitiator().getAccounttype())
								&& sS_Chk.checkDataCustomeraddress(reqDebitApplication.getInitiator().getCustomeraddress())
								
								&& sS_Chk.checkDataPhoneNumber(reqDebitApplication.getInitiator().getPhonenumber(),"PHONE NUMBER",93,'O')
								//&& sS_Chk.checkDataPhonenumber(reqDebitApplication.getInitiator().getPhonenumber())
								&& sS_Chk.checkDataNationalid(reqDebitApplication.getInitiator().getNationalid())
								&& sS_Chk.checkDataOperation(reqDebitApplication.getInitiator().getOperation())
								&& sS_Chk.checkDataNationalidtype(reqDebitApplication.getInitiator().getNationalidtype())
								&& sS_Chk.checkDataCurrencycode(reqDebitApplication.getInitiator().getCurrencycode())
								&& sS_Chk.checkDataBranchcode(reqDebitApplication.getInitiator().getBranchcode())
								&& sS_Chk.checkDataCardprogramcode(reqDebitApplication.getInitiator().getCardprogramcode())
								&& sS_Chk.checkDataCitycode(reqDebitApplication.getInitiator().getCitycode())
								&& sS_Chk.checkDataBirthdate(reqDebitApplication.getInitiator().getBirthdate())					
								&& sS_Chk.checkDataApplicationId(reqDebitApplication.getInitiator().getApplicationid())
								&& sS_Chk.checkDataAccountnumber(reqDebitApplication.getInitiator().getAccountnumber())
								&& sS_Chk.checkDataCustomerid(reqDebitApplication.getInitiator().getCustomerid())
								&& sS_Chk.checkDataTypeaccount(reqDebitApplication.getInitiator().getAccounttype())
								&& sS_Chk.checkDataAccounttype(reqDebitApplication.getInitiator().getAccounttype())
								&& sS_Chk.checkDataGender(reqDebitApplication.getInitiator().getGender())
								&& sS_Chk.checkDataBirthdatelocation(reqDebitApplication.getInitiator().getBirthdatelocation())
								&& sS_Chk.checkDataCorporatename(reqDebitApplication.getInitiator().getCorporatename())
								&& sS_Chk.checkDataFax(reqDebitApplication.getInitiator().getFax())
								&& sS_Chk.checkDataProfetionalposition(reqDebitApplication.getInitiator().getProfetionalposition())
								&& sS_Chk.checkDataMaritalstatus(reqDebitApplication.getInitiator().getMaritalstatus())
								&& sS_Chk.checkDataTitle(reqDebitApplication.getInitiator().getTitle())
								&& sS_Chk.checkDataDebitprogram(reqDebitApplication.getInitiator().getDebitprogram())
								&& sS_Chk.checkDataCountry(reqDebitApplication.getInitiator().getCountry())
								&& sS_Chk.checkDataAddresstype(reqDebitApplication.getInitiator().getAddresstype())
								
								
								) {
							try {
								if (isLiveCtx()) {
									connection = SS_INIT.getDBConnection();
									String program = DEBIT_APPLICATION[SQL];

									/*
									callableStatement = connection.prepareCall(program);
									callableStatement.setString(1, requestJson);
									callableStatement.registerOutParameter(2, Types.NVARCHAR);
									callableStatement.execute();
									response = callableStatement.getString(2);

									JSONObject json = (JSONObject) new JSONParser().parse(response);
									JSONObject status = (JSONObject) json.get("status");
									ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
											status.get("errordesc").toString()));
									response = formatJsonOutput(ss_er);
									*/
									callableStatement = connection.prepareCall(program);
									callableStatement.setString(1, requestJson);
									callableStatement.setClob(2, debitAppResponse);
									callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
									callableStatement.executeUpdate();
									debitAppResponse = callableStatement.getClob(2);
									response = clobToString(debitAppResponse);
									authHeader = formatJsonOutput(auth.getHeader());
									response = TransformStringToJson(authHeader, response);

								} else {
									sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
									ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
									response = formatJsonOutput(ss_ret);

								}
							} catch (Exception e) {
								sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
										emsg(ER_PROCESS) + e.getMessage());

							} finally {
								if (callableStatement != null) {
									try {
										callableStatement.close();
									} catch (SQLException ex) {
										Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
									}
								}
								if (connection != null) {
									try {
										connection.close();
									} catch (Exception ignore) {
									}
								}
							}
						} else {
							sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);
						}
						
					}
					
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	// J'ai utilisÃ© le meme code que PrepaidApplicationValidation
	public String debitAppliValidation(OpgReq_PrepaidAppliValidation reqDebitAppliValidation) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
                String authHeader="";

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqDebitAppliValidation);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqDebitAppliValidation.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataInstitution(reqDebitAppliValidation.getInitiator().getInstitution())
					&& sS_Chk.checkDataApplicationId(reqDebitAppliValidation.getInitiator().getApplicationid())
					&& sS_Chk.checkDataAction(reqDebitAppliValidation.getInitiator().getAction())) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = DEBIT_APPLI_VALIDATION[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						//JSONObject json = (JSONObject) new JSONParser().parse(response);
						//JSONObject status = (JSONObject) json.get("status");
						//ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
							//	status.get("errordesc").toString()));
						//response = formatJsonOutput(ss_er);
                                                 authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	// Meme code que prepaidApplicationList
	public String debitApplicationList(OpgReq_PrepaidApplicationList reqDebitAppList) {
		SS_Ret ss_ret = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob prepAppListResponse = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqDebitAppList);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqDebitAppList.getHeader());
		if (auth.checkStatus()) {
			if (sS_Chk.checkDataInstitution(reqDebitAppList.getFilter().getInstitution())
					&& sS_Chk.checkDataVarchar(reqDebitAppList.getFilter().getAccountnumber(),"ACCOUNT NUMBER",62, 24,'F')
					&& sS_Chk.checkDataVarchar(reqDebitAppList.getFilter().getApplicationid(),"APPLICATION ID",63, 24,'F')
			        && sS_Chk.checkDataVarchar(reqDebitAppList.getFilter().getApplicationid(),"NATIONAL ID",64, 20,'F')
			    	&& sS_Chk.checkDataNumber(reqDebitAppList.getFilter().getApplicationcode(),"APPLICATION CODE", 65, 'F')
					&& sS_Chk.checkDataNumber(reqDebitAppList.getFilter().getBranchcode(),"BRANCH CODE", 66, 'F')
					&& sS_Chk.checkDataNumber(reqDebitAppList.getFilter().getStart(),"START", 67, 'F')
					&& sS_Chk.checkDataNumber(reqDebitAppList.getFilter().getEnd(),"END", 68, 'F')
					&& sS_Chk.checkDataVarchar(reqDebitAppList.getFilter().getCustomerid(),"CUSTOMER ID",69, 24,'F') 
					&& sS_Chk.compareTwoNumber(reqDebitAppList.getFilter().getStart(), reqDebitAppList.getFilter().getEnd())) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = DEBIT_APPLICATION_LIST[SQL];
						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, prepAppListResponse);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.executeUpdate();
						prepAppListResponse = callableStatement.getClob(2);
						response = clobToString(prepAppListResponse);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);

			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	public String redemption (OpgReq_Redemption reqRedemption) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
                String authHeader="";

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqRedemption);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqRedemption.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataInstitution(reqRedemption.getInitiator().getInstitution())
					&& sS_Chk.checkDataCard(reqRedemption.getInitiator().getCard())
					&& sS_Chk.checkDataNumber(reqRedemption.getInitiator().getReason(),"REASON", 95, 'O')
					&& sS_Chk.checkDataNumber(reqRedemption.getInitiator().getFee(),"FEE", 94, 'F')
					
					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = REDEMPTION[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						//JSONObject json = (JSONObject) new JSONParser().parse(response);
						//JSONObject status = (JSONObject) json.get("status");
						//ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
							//	status.get("errordesc").toString()));
						//response = formatJsonOutput(ss_er);
                                                  authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	public String reload (OpgReq_Reload reqReload) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
                String authHeader="";

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqReload);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqReload.getHeader());
		if (auth.checkStatus()) {
			if (	sS_Chk.checkDataInstitution(reqReload.getInitiator().getInstitution()) 
		 && sS_Chk.checkDataCard(reqReload.getInitiator().getCard()) 
		 && sS_Chk.checkDataCurrencycode(reqReload.getInitiator().getCurrency()) 
		 && sS_Chk.checkDataPaymentmode(reqReload.getInitiator().getPaymentmode()) 
		 && sS_Chk.checkDataReloadaccountnumber(reqReload.getInitiator().getReloadaccountnumber())
                                ){
				try {                              
                                    connection = SS_INIT.getDBConnection();
                                    String program = RELOAD[SQL];
                                    callableStatement = connection.prepareCall(program);
                                    callableStatement.setString(1, requestJson);
                                    callableStatement.registerOutParameter(2, Types.NVARCHAR);
                                    callableStatement.execute();				
                                    response = callableStatement.getString(2);					
                                    authHeader = formatJsonOutput(auth.getHeader());
                                    response = TransformStringToJson(authHeader, response);
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	public String merchant (OpgReq_Merchant reqMerchant) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		
		List<OpgEnt_MerPaymentMode>  paymentmode;
		List<OpgEnt_Address>  address;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob prepMerchAppResponse = null;
		String authHeader = "";
		
		paymentmode = reqMerchant.getMerchant().getPaymentmode();
		address     = reqMerchant.getMerchant().getAddress();

		reqMerchant.getMerchant().setCategory(" ");
		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			if (reqMerchant.getMerchant().getCategory().isEmpty())
				reqMerchant.getMerchant().setCategory(" ");
			requestJson = genson.serialize(reqMerchant);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}
		
		
		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqMerchant.getHeader());
		if (auth.checkStatus()) {
			
			if (reqMerchant.getMerchant().getOperation().equalsIgnoreCase("DELETE"))
			{
				
				if (sS_Chk.checkDataInstitution(reqMerchant.getMerchant().getInstitution())
			               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOperation(), "OPERATION", 1, 6,'O')
			               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getMerchantappid(), "MERCHANT APP ID", 3, 40,'O'))

								 {
							try {
								if (isLiveCtx()) {
									connection = SS_INIT.getDBConnection();
									String program = MERCHANT[SQL];
									callableStatement = connection.prepareCall(program);
									callableStatement.setString(1, requestJson);
									callableStatement.registerOutParameter(2, Types.NVARCHAR);
									callableStatement.execute();
									response = callableStatement.getString(2);

									//JSONObject json = (JSONObject) new JSONParser().parse(response);
								//	JSONObject status = (JSONObject) json.get("status");
								//	ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
										//	status.get("errordesc").toString()));
								   authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);
								} else {
									sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
									ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
									response = formatJsonOutput(ss_ret);
								}
							} catch (Exception e) {
								sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
										emsg(ER_PROCESS) + e.getMessage());
							} finally {
								if (callableStatement != null) {
									try {
										callableStatement.close();
									} catch (SQLException ex) {
										Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
									}
								}
								if (connection != null) {
									try {
										connection.close();
									} catch (Exception ignore) {
									}
								}
							}
						} else {
							sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);
						}
				
			}
			
			
			if (reqMerchant.getMerchant().getOperation().equalsIgnoreCase("ADD"))
			{
				
				for (OpgEnt_Address field : address) {
			     	   
					if( !(sS_Chk.checkDataVarchar(field.getAddress1(),"ADDRESS1", 23, 80,'O'))
					|| !(sS_Chk.checkDataVarchar(field.getAddress2(), "ADDRESS2", 24, 80,'F'))
					|| !(sS_Chk.checkDataVarchar(field.getAddressstre(), "ADDRESSTRE", 25, 20,'F'))
					|| !(sS_Chk.checkDataVarchar(field.getAddresszipd(), "ADDRESS ZIP ID", 26, 24,'F'))
					//|| !(sS_Chk.checkDataVarchar(field.getPhonenumber1(), "PHONE NUMBER 1", 27, 20,'F'))
					//|| !(sS_Chk.checkDataVarchar(field.getPhonenumber2(), "PHONE NUMBER 2", 28, 20,'O'))
					|| !sS_Chk.checkDataPhoneNumber(field.getPhonenumber1(),"PHONE NUMBER 1",93,'O')
					|| !sS_Chk.checkDataPhoneNumber(field.getPhonenumber2(),"PHONE NUMBER 2",93,'F')
					|| !(sS_Chk.checkDataVarchar(field.getFax(), "FAX", 29, 20,'F'))
					|| !(sS_Chk.checkDataVarchar(field.getEmail(), "EMAIL", 30, 40,'F'))
					|| !(sS_Chk.checkDataNumber(field.getAddresstype(), "ADDRESS TYPE", 31,'O'))
					|| !(sS_Chk.checkDataNumber(field.getAddresscorresp(), "ADDRESS CORRESP", 32,'O')) 
					|| !(sS_Chk.checkDataNumber(field.getCountry(), "COUNTRY", 33,'O')) 
					|| !(sS_Chk.checkDataNumber(field.getCity(), "CITY", 34,'O')) 

			     	   ) {
						
						sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
						return response;
						
					     }
			        }
				
				if ( paymentmode != null)
				{
					for (OpgEnt_MerPaymentMode field : paymentmode) {
				     	   
						if(  !(sS_Chk.checkDataNumber(field.getPaymentmodecode(), "PAYMENT CODE", 20,'O')) 
						  || !( sS_Chk.checkDataVarchar(field.getPaymentmodedefault(), "PAYMENt MODE DEFAULT", 21, 1,'O'))
						  || !(sS_Chk.checkDataNumber(field.getPaymentmoderate(),"PAYMENT MODE RATE", 22, 'O'))
				     	   ) {
							
							sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);
							return response;
							
						     }
				        }
				}
			
			if (sS_Chk.checkDataInstitution(reqMerchant.getMerchant().getInstitution())
               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOperation(), "OPERATION", 1, 6,'O')
               && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getCompanytype(),"COMPANY TYPE", 2, 'F')
               //&& sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getMerchantappid(), "MERCHANT APP ID", 3, 40,'O')
               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getMerchantid(), "MERCHANT ID", 4, 40,'F')
               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getMerchantoldnew(), "MERCHANT OLD NEW", 5, 1,'O')
               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getCorporatename(), "CORPORATE NAME", 6, 40,'O')
               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getNameDBA(), "NAME DBA", 7, 40,'O')
               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getContractnumber(), "CONTRACT NUMBER", 8, 20,'O')
               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOwnerfirstname(), "OWNER FIRST NAME", 9, 40,'O')
               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOwnerlastname(), "OWNER LAST NAME", 10, 40,'O') 
               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOwnernationalid(), "OWNER NATIONL ID", 11, 20,'O')
               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOwnerpassportnumber(), "OWNER PASSPRT NUMBER", 12, 20,'O')
               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOwnerbirthlocation(), "OWNER BIRTHDAY LOCATION", 13, 15,'F')
               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOwnergender(), "OWNER GENDER", 14, 1,'F')
               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOwnerrtitle(), "OWNER TIITLE", 15, 1,'F')
               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOwnernationality(), "OWNER NATIONALITY", 16, 20,'O')
               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getAccountoldnew(), "ACCOUNT OLD NEW", 17, 1,'O')
               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getMxpaccountnumber(), "MXP ACCOUNT NUMBER", 18, 24,'O')
               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getBankaccountnumber(), "BANK ACCOUNT NUMBER", 19, 24,'O')
               && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getBranch(),"BRANCH", 35, 'F')
			   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getLicence(),"LICENCE", 36, 'F')
			   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getSerialnumber(),"SERIAL NUMBER", 37, 'F')
			   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getCommercialregister(),"COMMERCIAL REGISTER", 38, 'F')
			   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getCapitalamount(),"CAPITAL AMOUNT", 39, 'F')
			   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getSocialsecuritynumber(),"SOCIAL SECUIRTY NUMBER", 40, 'F')
			   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getTaxidentity(),"TAX IDENTITY", 41, 'F')
			   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getMerchantcategory(),"CATEGORY", 43, 'O')
			   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getMerchantprogram(),"MERCHANT PROGRAM", 44, 'O')
			   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getCurrency(),"CURRENCY", 45, 'O')
			   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getCategory(),"CATEGORY", 45, 'F')
			   && sS_Chk.checkDateFormat2(reqMerchant.getMerchant().getOwnerbirthdate(),BIRTH_DATE_FORMAT)


					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = MERCHANT[SQL];
						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						
						callableStatement.setClob(2, prepMerchAppResponse);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.executeUpdate();
						prepMerchAppResponse = callableStatement.getClob(2);
						response = clobToString(prepMerchAppResponse);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
			
		 }
			
			if (reqMerchant.getMerchant().getOperation().equalsIgnoreCase("UPDATE_OLD"))
				{
					
					for (OpgEnt_Address field : address) {
				     	   
						if( !(sS_Chk.checkDataVarchar(field.getAddress1(),"ADDRESS1", 23, 80,'O'))
						|| !(sS_Chk.checkDataVarchar(field.getAddress2(), "ADDRESS2", 24, 80,'F'))
						|| !(sS_Chk.checkDataVarchar(field.getAddressstre(), "ADDRESSTRE", 25, 20,'F'))
						|| !(sS_Chk.checkDataVarchar(field.getAddresszipd(), "ADDRESS ZIP ID", 26, 24,'F'))
						//|| !(sS_Chk.checkDataVarchar(field.getPhonenumber1(), "PHONE NUMBER 1", 27, 20,'F'))
						//|| !(sS_Chk.checkDataVarchar(field.getPhonenumber2(), "PHONE NUMBER 2", 28, 20,'O'))
						|| !sS_Chk.checkDataPhoneNumber(field.getPhonenumber1(),"PHONE NUMBER 1",93,'O')
						|| !sS_Chk.checkDataPhoneNumber(field.getPhonenumber2(),"PHONE NUMBER 2",93,'F')
						|| !(sS_Chk.checkDataVarchar(field.getFax(), "FAX", 29, 20,'F'))
						|| !(sS_Chk.checkDataVarchar(field.getEmail(), "EMAIL", 30, 40,'F'))
						|| !(sS_Chk.checkDataNumber(field.getAddresstype(), "ADDRESS TYPE", 31,'O'))
						|| !(sS_Chk.checkDataNumber(field.getAddresscorresp(), "ADDRESS CORRESP", 32,'O')) 
						|| !(sS_Chk.checkDataNumber(field.getCountry(), "COUNTRY", 33,'O')) 
						|| !(sS_Chk.checkDataNumber(field.getCity(), "CITY", 34,'O')) 

				     	   ) {
							
							sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);
							return response;
							
						     }
				        }
					
					for (OpgEnt_MerPaymentMode field : paymentmode) {
				     	   
						if(  !(sS_Chk.checkDataNumber(field.getPaymentmodecode(), "PAYMENT CODE", 20,'O')) 
						  || !( sS_Chk.checkDataVarchar(field.getPaymentmodedefault(), "PAYMENt MODE DEFAULT", 21, 1,'O'))
						  || !(sS_Chk.checkDataNumber(field.getPaymentmoderate(),"PAYMENT MODE RATE", 22, 'O'))
				     	   ) {
							
							sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);
							return response;
							
						     }
				        }
					
				
				
				if (sS_Chk.checkDataInstitution(reqMerchant.getMerchant().getInstitution())
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOperation(), "OPERATION", 1, 6,'O')
	               && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getCompanytype(),"COMPANY TYPE", 2, 'F')
	               //&& sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getMerchantappid(), "MERCHANT APP ID", 3, 40,'O')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getMerchantid(), "MERCHANT ID", 4, 40,'F')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getMerchantoldnew(), "MERCHANT OLD NEW", 5, 1,'O')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getCorporatename(), "CORPORATE NAME", 6, 40,'O')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getNameDBA(), "NAME DBA", 7, 40,'O')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getContractnumber(), "CONTRACT NUMBER", 8, 20,'O')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOwnerfirstname(), "OWNER FIRST NAME", 9, 40,'O')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOwnerlastname(), "OWNER LAST NAME", 10, 40,'O') 
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOwnernationalid(), "OWNER NATIONL ID", 11, 20,'O')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOwnerpassportnumber(), "OWNER PASSPRT NUMBER", 12, 20,'O')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOwnerbirthlocation(), "OWNER BIRTHDAY LOCATION", 13, 15,'F')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOwnergender(), "OWNER GENDER", 14, 1,'F')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOwnerrtitle(), "OWNER TIITLE", 15, 1,'F')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOwnernationality(), "OWNER NATIONALITY", 16, 20,'O')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getAccountoldnew(), "ACCOUNT OLD NEW", 17, 1,'O')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getMxpaccountnumber(), "MXP ACCOUNT NUMBER", 18, 24,'O')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getBankaccountnumber(), "BANK ACCOUNT NUMBER", 19, 24,'O')
	               && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getBranch(),"BRANCH", 35, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getLicence(),"LICENCE", 36, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getSerialnumber(),"SERIAL NUMBER", 37, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getCommercialregister(),"COMMERCIAL REGISTER", 38, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getCapitalamount(),"CAPITAL AMOUNT", 39, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getSocialsecuritynumber(),"SOCIAL SECUIRTY NUMBER", 40, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getTaxidentity(),"TAX IDENTITY", 41, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getMerchantcategory(),"CATEGORY", 43, 'O')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getMerchantprogram(),"MERCHANT PROGRAM", 44, 'O')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getCurrency(),"CURRENCY", 45, 'O')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getCategory(),"CATEGORY", 45, 'F')
				   && sS_Chk.checkDateFormat2(reqMerchant.getMerchant().getOwnerbirthdate(),BIRTH_DATE_FORMAT)


						) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = MERCHANT[SQL];
							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.registerOutParameter(2, Types.NVARCHAR);
							callableStatement.execute();
							response = callableStatement.getString(2);
							//JSONObject json = (JSONObject) new JSONParser().parse(response);
							//JSONObject status = (JSONObject) json.get("status");
							//ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
							//status.get("errordesc").toString()));
							//response = formatJsonOutput(ss_er);
                                                           authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);
						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());
					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
				
			 }
			
			
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret); 
			return response;
		}
		return response;
	}

	public String merchantAppliValidation(OpgReq_MerchantAppliValidation reqMerchantAppliValidation) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
                String authHeader="";
		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqMerchantAppliValidation);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqMerchantAppliValidation.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataInstitution(reqMerchantAppliValidation.getInitiator().getInstitution())
					&& sS_Chk.checkDataApplicationId(reqMerchantAppliValidation.getInitiator().getApplicationid())
					&& sS_Chk.checkDataAction(reqMerchantAppliValidation.getInitiator().getAction())) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = MERCHANT_APPLI_VALIDATION[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						//JSONObject json = (JSONObject) new JSONParser().parse(response);
						//JSONObject status = (JSONObject) json.get("status");
						//ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
								//status.get("errordesc").toString()));
						//response = formatJsonOutput(ss_er);
                                                   authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	public String merchantApplicationList(OpgReq_MerchantApplicationList reqMerchantAppList) {
		SS_Ret ss_ret = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob prepAppListResponse = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqMerchantAppList);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqMerchantAppList.getHeader());
		if (auth.checkStatus()) {
			if (sS_Chk.checkDataInstitution(reqMerchantAppList.getFilter().getInstitution())
					
			   && sS_Chk.checkDataVarchar(reqMerchantAppList.getFilter().getMxpaccountnumber(), "MXP ACCOUNT NUMBER",46, 24,'F')	
			   && sS_Chk.checkDataVarchar(reqMerchantAppList.getFilter().getBankaccountnumber(),"BANK ACCOUNT NUMBER",47, 24,'F')
			   && sS_Chk.checkDataVarchar(reqMerchantAppList.getFilter().getApplicationid(),"APPLICATION ID",48, 24,'F')
			   && sS_Chk.checkDataVarchar(reqMerchantAppList.getFilter().getApplicationid(),"NATIONAL ID",49, 20,'F')
			   && sS_Chk.checkDataNumber(reqMerchantAppList.getFilter().getApplicationcode(),"APPLICATION CODE", 50, 'F')
			   && sS_Chk.checkDataNumber(reqMerchantAppList.getFilter().getBranchcode(),"BRANCH CODE", 51, 'F')
			   && sS_Chk.checkDataNumber(reqMerchantAppList.getFilter().getStart(),"START", 52, 'F')
			   && sS_Chk.checkDataNumber(reqMerchantAppList.getFilter().getEnd(),"END", 53, 'F')
			   && sS_Chk.compareTwoNumber(reqMerchantAppList.getFilter().getStart(), reqMerchantAppList.getFilter().getEnd())
					
					
					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = MERCHANT_APPLICATION_LIST[SQL];
						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, prepAppListResponse);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.executeUpdate();
						prepAppListResponse = callableStatement.getClob(2);
						response = clobToString(prepAppListResponse);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);

			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	public String posTerminalApplication (OpgReq_PosTerminalApplication reqPosTerminalApplication) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob posTerminalAppResponse = null;
		String authHeader = "";

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqPosTerminalApplication);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqPosTerminalApplication.getHeader());
		if (auth.checkStatus()) {

			if (reqPosTerminalApplication.getInitiator().getOperation().equalsIgnoreCase("DELETE"))
			{

				if (sS_Chk.checkDataInstitution(reqPosTerminalApplication.getInitiator().getInstitution())
						&& sS_Chk.checkDataVarchar(reqPosTerminalApplication.getInitiator().getTerminalid(),"TERMINAL ID",74, 24,'O')
						&& sS_Chk.checkDataVarchar(reqPosTerminalApplication.getInitiator().getOperation(),"OPERATION", 80,6, 'O')
						
						)
						{
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = POS_TERMINAL_APPLICATION[SQL];

							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.registerOutParameter(2, Types.NVARCHAR);
							callableStatement.execute();
							response = callableStatement.getString(2);

							//JSONObject json = (JSONObject) new JSONParser().parse(response);
							//JSONObject status = (JSONObject) json.get("status");
							//ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
								//	status.get("errordesc").toString()));
							//response = formatJsonOutput(ss_er);
                                                           authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);
						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());
					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
			}
			
			if (reqPosTerminalApplication.getInitiator().getOperation().equalsIgnoreCase("ADD"))
			{
				
				if (sS_Chk.checkDataInstitution(reqPosTerminalApplication.getInitiator().getInstitution())
						
						&& sS_Chk.checkDataVarchar(reqPosTerminalApplication.getInitiator().getMerchantid(),"MERCHANT ID",70, 24,'O')
						&& sS_Chk.checkDataNumber(reqPosTerminalApplication.getInitiator().getCurrencycode(),"CURRENCY CODE", 71, 'O')
						&& sS_Chk.checkDataNumber(reqPosTerminalApplication.getInitiator().getConfiguration(),"CONFIGURATION", 72, 'O')
						&& sS_Chk.checkDataVarchar(reqPosTerminalApplication.getInitiator().getTerminalname(),"TERMINAL NAME",73, 20,'O')
						&& sS_Chk.checkDataVarchar(reqPosTerminalApplication.getInitiator().getTerminalid(),"TERMINAL ID",74, 24,'O')
						&& sS_Chk.checkDataNumber(reqPosTerminalApplication.getInitiator().getTerminalstatus(),"TERMINAL STATUS", 75, 'O')
						&& sS_Chk.checkDataNumber(reqPosTerminalApplication.getInitiator().getHsmkeycode(),"HSM KEY CODE", 76, 'O')
						&& sS_Chk.checkDataVarchar(reqPosTerminalApplication.getInitiator().getSerialnumber(),"SERIAL NUMBER", 77,20, 'O')
						&& sS_Chk.checkDataVarchar(reqPosTerminalApplication.getInitiator().getApplicationversion(),"APPLICATION VERSION", 79,19, 'O')
						&& sS_Chk.checkDataVarchar(reqPosTerminalApplication.getInitiator().getOperation(),"OPERATION", 80,6, 'O')
						
						)
						{
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = POS_TERMINAL_APPLICATION[SQL];

							/*callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.registerOutParameter(2, Types.NVARCHAR);
							callableStatement.execute();
							response = callableStatement.getString(2);

							JSONObject json = (JSONObject) new JSONParser().parse(response);
							JSONObject status = (JSONObject) json.get("status");
							ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
									status.get("errordesc").toString()));
							response = formatJsonOutput(ss_er);*/
							
							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.setClob(2, posTerminalAppResponse);
							callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
							callableStatement.executeUpdate();
							posTerminalAppResponse = callableStatement.getClob(2);
							response = clobToString(posTerminalAppResponse);
							authHeader = formatJsonOutput(auth.getHeader());
							response = TransformStringToJson(authHeader, response);

						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);
						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());
					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}	   
			}
			
			if (reqPosTerminalApplication.getInitiator().getOperation().equalsIgnoreCase("UPDATE"))
					{
						
						if (sS_Chk.checkDataInstitution(reqPosTerminalApplication.getInitiator().getInstitution())
								
								&& sS_Chk.checkDataVarchar(reqPosTerminalApplication.getInitiator().getMerchantid(),"MERCHANT ID",70, 24,'O')
								&& sS_Chk.checkDataNumber(reqPosTerminalApplication.getInitiator().getCurrencycode(),"CURRENCY CODE", 71, 'O')
								&& sS_Chk.checkDataNumber(reqPosTerminalApplication.getInitiator().getConfiguration(),"CONFIGURATION", 72, 'O')
								&& sS_Chk.checkDataVarchar(reqPosTerminalApplication.getInitiator().getTerminalname(),"TERMINAL NAME",73, 20,'O')
								&& sS_Chk.checkDataVarchar(reqPosTerminalApplication.getInitiator().getTerminalid(),"TERMINAL ID",74, 24,'O')
								&& sS_Chk.checkDataNumber(reqPosTerminalApplication.getInitiator().getTerminalstatus(),"TERMINAL STATUS", 75, 'O')
								&& sS_Chk.checkDataNumber(reqPosTerminalApplication.getInitiator().getHsmkeycode(),"HSM KEY CODE", 76, 'O')
								//&& sS_Chk.checkDataVarchar(reqPosTerminalApplication.getInitiator().getSerialnumber(),"SERIAL NUMBER", 77,20, 'F')
								&& sS_Chk.checkDataVarchar(reqPosTerminalApplication.getInitiator().getApplicationversion(),"APPLICATION VERSION", 79,19, 'O')
								&& sS_Chk.checkDataVarchar(reqPosTerminalApplication.getInitiator().getOperation(),"OPERATION", 80,6, 'O')
								
								&& sS_Chk.checkIfYesOrNo(reqPosTerminalApplication.getInitiator().getPurchase(),"PURCHASE", 97, 'O')
								&& sS_Chk.checkIfYesOrNo(reqPosTerminalApplication.getInitiator().getVoidis(),"VOIDIS", 98, 'O')
								&& sS_Chk.checkIfYesOrNo(reqPosTerminalApplication.getInitiator().getBillpayment(),"BILLPAYMENT", 99, 'O')
								&& sS_Chk.checkIfYesOrNo(reqPosTerminalApplication.getInitiator().getMoneytransfer(),"MONEYTRANSFER", 100, 'O')
								&& sS_Chk.checkIfYesOrNo(reqPosTerminalApplication.getInitiator().getPinchange(),"PINCHANGE", 101, 'O')
								&& sS_Chk.checkIfYesOrNo(reqPosTerminalApplication.getInitiator().getCashadvance(),"CASHADVANCE", 102, 'O')
								&& sS_Chk.checkIfYesOrNo(reqPosTerminalApplication.getInitiator().getEvoucher(),"EVOUCHER", 103, 'O')
								&& sS_Chk.checkIfYesOrNo(reqPosTerminalApplication.getInitiator().getRefund(),"REFUND", 104, 'O')
								&& sS_Chk.checkIfYesOrNo(reqPosTerminalApplication.getInitiator().getBalanceinquiry(),"BALANCEINQUIRY", 105, 'O')
								&& sS_Chk.checkIfYesOrNo(reqPosTerminalApplication.getInitiator().getMinistatement(),"MINISTATEMENT", 106, 'O')
								
								)
								{
							try {
								if (isLiveCtx()) {
									connection = SS_INIT.getDBConnection();
									String program = POS_TERMINAL_APPLICATION[SQL];

									/*callableStatement = connection.prepareCall(program);
									callableStatement.setString(1, requestJson);
									callableStatement.registerOutParameter(2, Types.NVARCHAR);
									callableStatement.execute();
									response = callableStatement.getString(2);

									JSONObject json = (JSONObject) new JSONParser().parse(response);
									JSONObject status = (JSONObject) json.get("status");
									ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
											status.get("errordesc").toString()));
									response = formatJsonOutput(ss_er);*/
									
									callableStatement = connection.prepareCall(program);
									callableStatement.setString(1, requestJson);
									callableStatement.setClob(2, posTerminalAppResponse);
									callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
									callableStatement.executeUpdate();
									posTerminalAppResponse = callableStatement.getClob(2);
									response = clobToString(posTerminalAppResponse);
									authHeader = formatJsonOutput(auth.getHeader());
									response = TransformStringToJson(authHeader, response);

								} else {
									sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
									ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
									response = formatJsonOutput(ss_ret);
								}
							} catch (Exception e) {
								sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
										emsg(ER_PROCESS) + e.getMessage());
							} finally {
								if (callableStatement != null) {
									try {
										callableStatement.close();
									} catch (SQLException ex) {
										Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
									}
								}
								if (connection != null) {
									try {
										connection.close();
									} catch (Exception ignore) {
									}
								}
							}
						} else {
							sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);
						}	   
					}
			
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String posTerminalList (OpgReq_PosTerminalList reqPosTerminalList) {
		SS_Ret ss_ret = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob prepAppListResponse = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqPosTerminalList);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqPosTerminalList.getHeader());
		if (auth.checkStatus()) {
			if (sS_Chk.checkDataInstitution(reqPosTerminalList.getFilter().getInstitution())
					
			   && sS_Chk.checkDataVarchar(reqPosTerminalList.getFilter().getTerminalid(), "TERMINAL ID",81, 24,'F')	
			   && sS_Chk.checkDataNumber(reqPosTerminalList.getFilter().getStart(),"START", 82, 'F')
			   && sS_Chk.checkDataNumber(reqPosTerminalList.getFilter().getEnd(),"END", 83, 'F')
			   && sS_Chk.compareTwoNumber(reqPosTerminalList.getFilter().getStart(), reqPosTerminalList.getFilter().getEnd())
					
					
					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = POS_TERMINAL_LIST[SQL];
						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, prepAppListResponse);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.executeUpdate();
						prepAppListResponse = callableStatement.getClob(2);
						response = clobToString(prepAppListResponse);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);

			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	public String posApplicationList (OpgReq_PosApplicationList reqPosApplicationList) {
		SS_Ret ss_ret = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob prepAppListResponse = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqPosApplicationList);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqPosApplicationList.getHeader());
		if (auth.checkStatus()) {
			if (sS_Chk.checkDataInstitution(reqPosApplicationList.getFilter().getInstitution())
					
			   && sS_Chk.checkDataVarchar(reqPosApplicationList.getFilter().getApplicationid(), "APPLICATION ID",84, 24,'F')	
			   && sS_Chk.checkDataNumber(reqPosApplicationList.getFilter().getStart(),"START", 85, 'F')
			   && sS_Chk.checkDataNumber(reqPosApplicationList.getFilter().getEnd(),"END", 86, 'F')
			   && sS_Chk.compareTwoNumber(reqPosApplicationList.getFilter().getStart(), reqPosApplicationList.getFilter().getEnd())
					
					
					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = POS_APPLICATION_LIST[SQL];
						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, prepAppListResponse);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.executeUpdate();
						prepAppListResponse = callableStatement.getClob(2);
						response = clobToString(prepAppListResponse);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);

			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	public String authorizitionList(OpgReq_AuthorizitaionList reqAuthorizitaionList) {
		SS_Ret ss_ret = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob prepAppListResponse = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqAuthorizitaionList);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqAuthorizitaionList.getHeader());
		if (auth.checkStatus()) {
			if (sS_Chk.checkDataInstitution(reqAuthorizitaionList.getFilter().getInstitution())
					
			   && sS_Chk.checkDataVarchar(reqAuthorizitaionList.getFilter().getIdtrans(),"TRANSACTION ID",88, 24,'F')

			   //startdate
			   //enddate
			   && sS_Chk.checkDataNumber(reqAuthorizitaionList.getFilter().getTransactiontype(),"TRANSACTIOn TYPE", 89, 'F')
			   && sS_Chk.checkDataNumber(reqAuthorizitaionList.getFilter().getStart(),"START", 90, 'F')
			   && sS_Chk.checkDataNumber(reqAuthorizitaionList.getFilter().getEnd(),"END", 91, 'F')
			   && sS_Chk.compareTwoNumber(reqAuthorizitaionList.getFilter().getStart(), reqAuthorizitaionList.getFilter().getEnd())
					
					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = AUTHORIZATION_LIST[SQL];
						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, prepAppListResponse);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.executeUpdate();
						prepAppListResponse = callableStatement.getClob(2);
						response = clobToString(prepAppListResponse);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);

			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	public String getTransaction(OpgReq_GetTransaction reqGetTransaction) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
                String authHeader="";

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqGetTransaction);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqGetTransaction.getHeader());
		if (auth.checkStatus()) {

			if ( sS_Chk.checkDataInstitution(reqGetTransaction.getInitiator().getInstitution())
					&&	sS_Chk.checkDataAccount(reqGetTransaction.getInitiator().getAccount())
					&& sS_Chk.checkDataBranch(reqGetTransaction.getInitiator().getBranch())) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = GET_TRANSACTION[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);
                                         
                                                 
						//JSONObject json = (JSONObject) new JSONParser().parse(response);
						//JSONObject status = (JSONObject) json.get("STATUS");
						//ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("ERRORCODE").toString(),
							//	status.get("ERRORDESC").toString()));
						//response = formatJsonOutput(ss_er);
                                                   authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	public String accountTransfer(OpgReq_AccountTransfer reqAccountTransfer) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
                String authHeader="";

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqAccountTransfer);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqAccountTransfer.getHeader());
		if (auth.checkStatus()) {

			if ( sS_Chk.checkDataInstitution(reqAccountTransfer.getInitiator().getInstitution())
					&&	sS_Chk.checkDataAccount(reqAccountTransfer.getInitiator().getAccount())
					&& sS_Chk.checkDataBranch(reqAccountTransfer.getInitiator().getBranch())) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = GET_ACCOUNT_TRANSFER[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						//JSONObject json = (JSONObject) new JSONParser().parse(response);
						//JSONObject status = (JSONObject) json.get("STATUS");
						//ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("ERRORCODE").toString(),
							//	status.get("ERRORDESC").toString()));
					//	response = formatJsonOutput(ss_er);
                                          authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);
						
						

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
        
 
        
 
        
        	public String PingServer(OpgReq_PingServerRequest reqPingServerRequest) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
                String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqPingServerRequest);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqPingServerRequest.getHeader());
		if (auth.checkStatus()) {

			
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = PINGSERVER[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);
						
						//JSONObject json = (JSONObject) new JSONParser().parse(response);
						//JSONObject status = (JSONObject) json.get("STATUS");
						//ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("ERRORCODE").toString(),
							//	status.get("ERRORDESC").toString()));
					
					
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);


					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			 
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	

        
        
        
        
        
        
	public String checkBookRequest(OpgReq_CheckBookRequest reqCheckBookRequest) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
                String authHeader="";

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqCheckBookRequest);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqCheckBookRequest.getHeader());
		if (auth.checkStatus()) {

			if ( sS_Chk.checkDataInstitution(reqCheckBookRequest.getInitiator().getInstitution())
					&&	sS_Chk.checkDataAccount(reqCheckBookRequest.getInitiator().getAccount())
					 && sS_Chk.checkDataNumber(reqCheckBookRequest.getInitiator().getPages(),"PAGES", 91, 'F')
					 && sS_Chk.checkDataVarchar(reqCheckBookRequest.getInitiator().getCheckbooktype(), "CHECK BOOK REQUEST",92, 6,'F')
					
					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = CHECK_BOOK_REQUEST[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);
						
						//JSONObject json = (JSONObject) new JSONParser().parse(response);
						///JSONObject status = (JSONObject) json.get("STATUS");
						//ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("ERRORCODE").toString(),
							//	status.get("ERRORDESC").toString()));
						//response = formatJsonOutput(ss_er);
                                                   authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);
						
						

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	
	public String merchantUpdate (OpgReq_MerchantUpdate reqMerchant) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		
		List<OpgEnt_MerPaymentMode>  paymentmode;
		List<OpgEnt_Address>  address;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob prepMerchAppResponse = null;
		String authHeader = "";
		
		paymentmode = reqMerchant.getMerchant().getPaymentmode();
		address     = reqMerchant.getMerchant().getAddress();

		//reqMerchant.getMerchant().setCategory(" ");
		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			//if (reqMerchant.getMerchant().getCategory().isEmpty())
			//	reqMerchant.getMerchant().setCategory(" ");
			requestJson = genson.serialize(reqMerchant);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}
		
		
		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqMerchant.getHeader());
		if (auth.checkStatus()) {
			
			//System.out.println(reqMerchant.getMerchant().toString());
			System.out.println(requestJson);
				
			if (reqMerchant.getMerchant().getOperation().equalsIgnoreCase("UPDATE"))
				{
					
				if(address != null)
				{
					for (OpgEnt_Address field : address) {
				     	   
						if( !(sS_Chk.checkDataVarchar(field.getAddress1(),"ADDRESS1", 23, 80,'O'))
						|| !(sS_Chk.checkDataVarchar(field.getAddress2(), "ADDRESS2", 24, 80,'F'))
						|| !(sS_Chk.checkDataVarchar(field.getAddressstre(), "ADDRESSTRE", 25, 20,'F'))
						|| !(sS_Chk.checkDataVarchar(field.getAddresszipd(), "ADDRESS ZIP ID", 26, 24,'F'))
						//|| !(sS_Chk.checkDataVarchar(field.getPhonenumber1(), "PHONE NUMBER 1", 27, 20,'F'))
						//|| !(sS_Chk.checkDataVarchar(field.getPhonenumber2(), "PHONE NUMBER 2", 28, 20,'O'))
						|| !sS_Chk.checkDataPhoneNumber(field.getPhonenumber1(),"PHONE NUMBER 1",93,'O')
						|| !sS_Chk.checkDataPhoneNumber(field.getPhonenumber2(),"PHONE NUMBER 2",93,'F')
						|| !(sS_Chk.checkDataVarchar(field.getFax(), "FAX", 29, 20,'F'))
						|| !(sS_Chk.checkDataVarchar(field.getEmail(), "EMAIL", 30, 40,'F'))
						|| !(sS_Chk.checkDataNumber(field.getAddresstype(), "ADDRESS TYPE", 31,'O'))
						|| !(sS_Chk.checkDataNumber(field.getAddresscorresp(), "ADDRESS CORRESP", 32,'O')) 
						|| !(sS_Chk.checkDataNumber(field.getCountry(), "COUNTRY", 33,'O')) 
						|| !(sS_Chk.checkDataNumber(field.getCity(), "CITY", 34,'O')) 

				     	   ) {
							
							sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);
							return response;
							
						     }
				        }
				}
						
					if (paymentmode != null)
					{
						for (OpgEnt_MerPaymentMode field : paymentmode) {
					     	   
							if(  !(sS_Chk.checkDataNumber(field.getPaymentmodecode(), "PAYMENT CODE", 20,'O')) 
							  || !( sS_Chk.checkDataVarchar(field.getPaymentmodedefault(), "PAYMENt MODE DEFAULT", 21, 1,'O'))
							  || !(sS_Chk.checkDataNumber(field.getPaymentmoderate(),"PAYMENT MODE RATE", 22, 'O'))
					     	   ) {
								
								sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
								ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
								response = formatJsonOutput(ss_ret);
								return response;
								
							     }
					        }
					}

				if (sS_Chk.checkDataInstitution(reqMerchant.getMerchant().getInstitution())
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOperation(), "OPERATION", 1, 6,'O')
	               
	               && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getCompanytype(),"COMPANY TYPE", 2, 'F')
	               //&& sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getMerchantappid(), "MERCHANT APP ID", 3, 40,'O')
	               //&& sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getMerchantid(), "MERCHANT ID", 4, 40,'F')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getCorporatename(), "CORPORATE NAME", 6, 40,'F')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getNameDBA(), "NAME DBA", 7, 40,'F')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getContractnumber(), "CONTRACT NUMBER", 8, 20,'F')
	               && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getBranch(),"BRANCH", 35, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getLicence(),"LICENCE", 36, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getSerialnumber(),"SERIAL NUMBER", 37, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getCommercialregister(),"COMMERCIAL REGISTER", 38, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getCapitalamount(),"CAPITAL AMOUNT", 39, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getSocialsecuritynumber(),"SOCIAL SECUIRTY NUMBER", 40, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getTaxidentity(),"TAX IDENTITY", 41, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getMerchantprogram(),"MERCHANT PROGRAM", 44, 'F')
				   
						) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = MERCHANT_APPLICATION_UPDATE[SQL];
							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);

							callableStatement.setClob(2, prepMerchAppResponse);
							callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
							callableStatement.executeUpdate();
							prepMerchAppResponse = callableStatement.getClob(2);
							response = clobToString(prepMerchAppResponse);
							authHeader = formatJsonOutput(auth.getHeader());
							response = TransformStringToJson(authHeader, response);

						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);
						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());
					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
				
			 }
			
			
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret); 
			return response;
		}
		return response;
	}
	
	
	public String merchantUpdateNoApplication (OpgReq_MerchantUpdateNoApplication reqMerchant) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		
		List<OpgEnt_MerPaymentMode>  paymentmode;
		List<OpgEnt_Address>  address;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob prepMerchAppResponse = null;
		String authHeader = "";
		
		paymentmode = reqMerchant.getMerchant().getPaymentmode();
		address     = reqMerchant.getMerchant().getAddress();

		//reqMerchant.getMerchant().setCategory(" ");
		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			//if (reqMerchant.getMerchant().getCategory().isEmpty())
			//	reqMerchant.getMerchant().setCategory(" ");
			requestJson = genson.serialize(reqMerchant);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}
		
		
		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqMerchant.getHeader());
		if (auth.checkStatus()) {
			
			//System.out.println(reqMerchant.getMerchant().toString());
			System.out.println(requestJson);
				
			if (reqMerchant.getMerchant().getOperation().equalsIgnoreCase("UPDATE"))
				{
					
				if(address != null)
				{
					for (OpgEnt_Address field : address) {
				     	   
						if( !(sS_Chk.checkDataVarchar(field.getAddress1(),"ADDRESS1", 23, 80,'O'))
						|| !(sS_Chk.checkDataVarchar(field.getAddress2(), "ADDRESS2", 24, 80,'F'))
						|| !(sS_Chk.checkDataVarchar(field.getAddressstre(), "ADDRESSTRE", 25, 20,'F'))
						|| !(sS_Chk.checkDataVarchar(field.getAddresszipd(), "ADDRESS ZIP ID", 26, 24,'F'))
						//|| !(sS_Chk.checkDataVarchar(field.getPhonenumber1(), "PHONE NUMBER 1", 27, 20,'F'))
						//|| !(sS_Chk.checkDataVarchar(field.getPhonenumber2(), "PHONE NUMBER 2", 28, 20,'O'))
						|| !sS_Chk.checkDataPhoneNumber(field.getPhonenumber1(),"PHONE NUMBER 1",93,'O')
						|| !sS_Chk.checkDataPhoneNumber(field.getPhonenumber2(),"PHONE NUMBER 2",93,'F')
						|| !(sS_Chk.checkDataVarchar(field.getFax(), "FAX", 29, 20,'F'))
						|| !(sS_Chk.checkDataVarchar(field.getEmail(), "EMAIL", 30, 40,'F'))
						|| !(sS_Chk.checkDataNumber(field.getAddresstype(), "ADDRESS TYPE", 31,'O'))
						|| !(sS_Chk.checkDataNumber(field.getAddresscorresp(), "ADDRESS CORRESP", 32,'O')) 
						|| !(sS_Chk.checkDataNumber(field.getCountry(), "COUNTRY", 33,'O')) 
						|| !(sS_Chk.checkDataNumber(field.getCity(), "CITY", 34,'O')) 

				     	   ) {
							
							sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);
							return response;
							
						     }
				        }
				}
						
					if (paymentmode != null)
					{
						for (OpgEnt_MerPaymentMode field : paymentmode) {
					     	   
							if(  !(sS_Chk.checkDataNumber(field.getPaymentmodecode(), "PAYMENT CODE", 20,'O')) 
							  || !( sS_Chk.checkDataVarchar(field.getPaymentmodedefault(), "PAYMENt MODE DEFAULT", 21, 1,'O'))
							  || !(sS_Chk.checkDataNumber(field.getPaymentmoderate(),"PAYMENT MODE RATE", 22, 'O'))
					     	   ) {
								
								sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
								ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
								response = formatJsonOutput(ss_ret);
								return response;
								
							     }
					        }
					}

				if (sS_Chk.checkDataInstitution(reqMerchant.getMerchant().getInstitution())
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getOperation(), "OPERATION", 1, 6,'O')
	               
	               && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getCompanytype(),"COMPANY TYPE", 2, 'F')
	               //&& sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getMerchantappid(), "MERCHANT APP ID", 3, 40,'O')
	               //&& sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getMerchantid(), "MERCHANT ID", 4, 40,'F')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getCorporatename(), "CORPORATE NAME", 6, 40,'F')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getNameDBA(), "NAME DBA", 7, 40,'F')
	               && sS_Chk.checkDataVarchar(reqMerchant.getMerchant().getContractnumber(), "CONTRACT NUMBER", 8, 20,'F')
	               && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getBranch(),"BRANCH", 35, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getLicence(),"LICENCE", 36, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getSerialnumber(),"SERIAL NUMBER", 37, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getCommercialregister(),"COMMERCIAL REGISTER", 38, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getCapitalamount(),"CAPITAL AMOUNT", 39, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getSocialsecuritynumber(),"SOCIAL SECUIRTY NUMBER", 40, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getTaxidentity(),"TAX IDENTITY", 41, 'F')
				   && sS_Chk.checkDataNumber(reqMerchant.getMerchant().getMerchantprogram(),"MERCHANT PROGRAM", 44, 'F')
				   
						) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = MERCHANT_UPDATE[SQL];
							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);

							callableStatement.setClob(2, prepMerchAppResponse);
							callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
							callableStatement.executeUpdate();
							prepMerchAppResponse = callableStatement.getClob(2);
							response = clobToString(prepMerchAppResponse);
							authHeader = formatJsonOutput(auth.getHeader());
							response = TransformStringToJson(authHeader, response);

						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);
						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());
					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
				
			 }
			
			
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret); 
			return response;
		}
		return response;
	}
	
	
		//Hasnaa Zaid
	
	public String creditApplication(OpgReq_CreditApplication reqCreditApplication) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob creditAppResponse = null;
		String authHeader = "";

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqCreditApplication);
                       
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// System.out.println("Arabic :
		// "+reqPrepApplication.getInitiator().getLastnamear());
		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqCreditApplication.getHeader());
		if (auth.checkStatus()) {
			
			if (reqCreditApplication.getInitiator().getOperation().equalsIgnoreCase("DELETE"))
			{
				
				if (sS_Chk.checkDataInstitution(reqCreditApplication.getInitiator().getBankcode())
						&& sS_Chk.checkDataOperation(reqCreditApplication.getInitiator().getOperation())				
						&& sS_Chk.checkDataApplicationId(reqCreditApplication.getInitiator().getApplicationid())
						) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = CREDIT_APPLICATION[SQL];

							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.registerOutParameter(2, Types.NVARCHAR);
							callableStatement.execute();
							response = callableStatement.getString(2);

							JSONObject json = (JSONObject) new JSONParser().parse(response);
							JSONObject status = (JSONObject) json.get("status");
							ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
									status.get("errordesc").toString()));
							response = formatJsonOutput(ss_er);

						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);

						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());

					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
				
			}
			
			
			if ( reqCreditApplication.getInitiator().getOperation().equalsIgnoreCase("ADD"))
			{
				
				if (sS_Chk.checkDataInstitution(reqCreditApplication.getInitiator().getBankcode())
						&& sS_Chk.checkDataNameoncard(reqCreditApplication.getInitiator().getNameoncard())
						//&& sS_Chk.checkDataFirstname(reqCreditApplication.getInitiator().getFirstname())
						//&& sS_Chk.checkDataMiddlename(reqCreditApplication.getInitiator().getMiddlename())
						//&& sS_Chk.checkDataLastname(reqCreditApplication.getInitiator().getLastname())
						//&& sS_Chk.checkDataFirstname(reqCreditApplication.getInitiator().getFirstnamear())
						//&& sS_Chk.checkDataMiddlename(reqCreditApplication.getInitiator().getMiddlenamear())
						//&& sS_Chk.checkDataLastname(reqCreditApplication.getInitiator().getLastnamear())
						&& sS_Chk.checkDataCustomertype(reqCreditApplication.getInitiator().getCustomertype())
						&& sS_Chk.checkDataAccounttype(reqCreditApplication.getInitiator().getAccounttype())
						&& sS_Chk.checkDataCustomeraddress(reqCreditApplication.getInitiator().getCustomeraddress())
						//&& sS_Chk.checkDataPhonenumber(reqCreditApplication.getInitiator().getPhonenumber())
						&& sS_Chk.checkDataPhoneNumber(reqCreditApplication.getInitiator().getPhonenumber(),"PHONE NUMBER",93,'O')
						&& sS_Chk.checkDataNationalid(reqCreditApplication.getInitiator().getNationalid())
						&& sS_Chk.checkDataOperation(reqCreditApplication.getInitiator().getOperation())
						&& sS_Chk.checkDataNationalidtype(reqCreditApplication.getInitiator().getNationalidtype())
						&& sS_Chk.checkDataCurrencycode(reqCreditApplication.getInitiator().getCurrencycode())
						&& sS_Chk.checkDataBranchcode(reqCreditApplication.getInitiator().getBranchcode())
						&& sS_Chk.checkDataCardprogramcode(reqCreditApplication.getInitiator().getCardprogramcode())
						&& sS_Chk.checkDataCitycode(reqCreditApplication.getInitiator().getCitycode())
						&& sS_Chk.checkDataBirthdate(reqCreditApplication.getInitiator().getBirthdate())					
						//&& sS_Chk.checkDataApplicationId(reqCreditApplication.getInitiator().getApplicationid())
						&& sS_Chk.checkDataAccountnumber(reqCreditApplication.getInitiator().getAccountnumber())
						&& sS_Chk.checkDataCustomerid(reqCreditApplication.getInitiator().getCustomerid())
						&& sS_Chk.checkDataGender(reqCreditApplication.getInitiator().getGender())
						&& sS_Chk.checkDataBirthdatelocation(reqCreditApplication.getInitiator().getBirthdatelocation())
						&& sS_Chk.checkDataCorporatename(reqCreditApplication.getInitiator().getCorporatename())
						&& sS_Chk.checkDataFax(reqCreditApplication.getInitiator().getFax())
						//&& sS_Chk.checkDataProfetionalposition(reqCreditApplication.getInitiator().getProfetionalposition())
						//&& sS_Chk.checkDataMaritalstatus(reqCreditApplication.getInitiator().getMaritalstatus())
						&& sS_Chk.checkDataTitle(reqCreditApplication.getInitiator().getTitle())
						&& sS_Chk.checkDataDebitprogram(reqCreditApplication.getInitiator().getCreditprogram())
						&& sS_Chk.checkDataCountry(reqCreditApplication.getInitiator().getCountry())
						&& sS_Chk.checkDataAddresstype(reqCreditApplication.getInitiator().getAddresstype())
						&& sS_Chk.checkDataAddresstype(reqCreditApplication.getInitiator().getZipaddress())
						&& sS_Chk.checkDataNumber(reqCreditApplication.getInitiator().getLimitcredit(),"LIMIT CREDIT", 107, 'O')

						
						
						) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = CREDIT_APPLICATION[SQL];

							//callableStatement = connection.prepareCall(program);
							//callableStatement.setString(1, requestJson);
							//callableStatement.registerOutParameter(2, Types.NVARCHAR);
							//callableStatement.execute();
							//response = callableStatement.getString(2);
							//JSONObject json = (JSONObject) new JSONParser().parse(response);
							//JSONObject status = (JSONObject) json.get("status");
							//ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
							//		status.get("errordesc").toString()));
							//response = formatJsonOutput(ss_er);
							
							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.setClob(2, creditAppResponse);
							callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
							callableStatement.executeUpdate();
							creditAppResponse = callableStatement.getClob(2);
							response = clobToString(creditAppResponse);
							authHeader = formatJsonOutput(auth.getHeader());
							response = TransformStringToJson(authHeader, response);

						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);

						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());

					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
				
			}
			
			if (reqCreditApplication.getInitiator().getOperation().equalsIgnoreCase("UPDATE"))
					{
						
						if (sS_Chk.checkDataInstitution(reqCreditApplication.getInitiator().getBankcode())
								//&& sS_Chk.checkDataNameoncard(reqCreditApplication.getInitiator().getNameoncard())
								&& sS_Chk.checkDataFirstname(reqCreditApplication.getInitiator().getFirstname())
								&& sS_Chk.checkDataMiddlename(reqCreditApplication.getInitiator().getMiddlename())
								&& sS_Chk.checkDataLastname(reqCreditApplication.getInitiator().getLastname())
								// sS_Chk.checkDataFirstname(reqCreditApplication.getInitiator().getFirstnamear())
								// sS_Chk.checkDataMiddlename(reqCreditApplication.getInitiator().getMiddlenamear())
								// sS_Chk.checkDataLastname(reqCreditApplication.getInitiator().getLastnamear())
								&& sS_Chk.checkDataCustomertype(reqCreditApplication.getInitiator().getCustomertype())
								&& sS_Chk.checkDataAccounttype(reqCreditApplication.getInitiator().getAccounttype())
								&& sS_Chk.checkDataCustomeraddress(reqCreditApplication.getInitiator().getCustomeraddress())
								
								&& sS_Chk.checkDataPhoneNumber(reqCreditApplication.getInitiator().getPhonenumber(),"PHONE NUMBER",93,'O')
								//&& sS_Chk.checkDataPhonenumber(reqCreditApplication.getInitiator().getPhonenumber())
								//&& sS_Chk.checkDataNationalid(reqCreditApplication.getInitiator().getNationalid())
								&& sS_Chk.checkDataOperation(reqCreditApplication.getInitiator().getOperation())
								//&& sS_Chk.checkDataNationalidtype(reqCreditApplication.getInitiator().getNationalidtype())
								&& sS_Chk.checkDataCurrencycode(reqCreditApplication.getInitiator().getCurrencycode())
								//&& sS_Chk.checkDataBranchcode(reqCreditApplication.getInitiator().getBranchcode())
								&& sS_Chk.checkDataCardprogramcode(reqCreditApplication.getInitiator().getCardprogramcode())
								&& sS_Chk.checkDataCitycode(reqCreditApplication.getInitiator().getCitycode())
								//&& sS_Chk.checkDataBirthdate(reqCreditApplication.getInitiator().getBirthdate())					
								&& sS_Chk.checkDataApplicationId(reqCreditApplication.getInitiator().getApplicationid())
								//&& sS_Chk.checkDataAccountnumber(reqCreditApplication.getInitiator().getAccountnumber())
								//&& sS_Chk.checkDataCustomerid(reqCreditApplication.getInitiator().getCustomerid())
								//&& sS_Chk.checkDataAccounttype(reqCreditApplication.getInitiator().getAccounttype())
								//&& sS_Chk.checkDataGender(reqCreditApplication.getInitiator().getGender())
								//&& sS_Chk.checkDataBirthdatelocation(reqCreditApplication.getInitiator().getBirthdatelocation())
								//&& sS_Chk.checkDataCorporatename(reqCreditApplication.getInitiator().getCorporatename())
								//&& sS_Chk.checkDataFax(reqCreditApplication.getInitiator().getFax())
								//&& sS_Chk.checkDataProfetionalposition(reqCreditApplication.getInitiator().getProfetionalposition())
								//&& sS_Chk.checkDataMaritalstatus(reqCreditApplication.getInitiator().getMaritalstatus())
								&& sS_Chk.checkDataTitle(reqCreditApplication.getInitiator().getTitle())
								&& sS_Chk.checkDataDebitprogram(reqCreditApplication.getInitiator().getCreditprogram())
								&& sS_Chk.checkDataCountry(reqCreditApplication.getInitiator().getCountry())
								&& sS_Chk.checkDataAddresstype(reqCreditApplication.getInitiator().getAddresstype())
								&& sS_Chk.checkDataAddresstype(reqCreditApplication.getInitiator().getZipaddress())
								&& sS_Chk.checkDataNumber(reqCreditApplication.getInitiator().getLimitcredit(),"LIMIT CREDIT", 107, 'O')
								
								) {
							try {
								if (isLiveCtx()) {
									connection = SS_INIT.getDBConnection();
									String program = CREDIT_APPLICATION[SQL];

									/*
									callableStatement = connection.prepareCall(program);
									callableStatement.setString(1, requestJson);
									callableStatement.registerOutParameter(2, Types.NVARCHAR);
									callableStatement.execute();
									response = callableStatement.getString(2);

									JSONObject json = (JSONObject) new JSONParser().parse(response);
									JSONObject status = (JSONObject) json.get("status");
									ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
											status.get("errordesc").toString()));
									response = formatJsonOutput(ss_er);
									*/
									callableStatement = connection.prepareCall(program);
									callableStatement.setString(1, requestJson);
									callableStatement.setClob(2, creditAppResponse);
									callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
									callableStatement.executeUpdate();
									creditAppResponse = callableStatement.getClob(2);
									response = clobToString(creditAppResponse);
									authHeader = formatJsonOutput(auth.getHeader());
									response = TransformStringToJson(authHeader, response);

								} else {
									sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
									ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
									response = formatJsonOutput(ss_ret);

								}
							} catch (Exception e) {
								sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
										emsg(ER_PROCESS) + e.getMessage());

							} finally {
								if (callableStatement != null) {
									try {
										callableStatement.close();
									} catch (SQLException ex) {
										Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
									}
								}
								if (connection != null) {
									try {
										connection.close();
									} catch (Exception ignore) {
									}
								}
							}
						} else {
							sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);
						}
						
					}
					
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	

	public String creditAppliValidation(OpgReq_CreditApplicationValidation reqCreditAppliValidation) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqCreditAppliValidation);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqCreditAppliValidation.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataInstitution(reqCreditAppliValidation.getInitiator().getBankcode())
					&& sS_Chk.checkDataApplicationId(reqCreditAppliValidation.getInitiator().getApplicationid())
					&& sS_Chk.checkDataAction(reqCreditAppliValidation.getInitiator().getAction())) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = CREDIT_APPLI_VALIDATION[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						JSONObject json = (JSONObject) new JSONParser().parse(response);
						JSONObject status = (JSONObject) json.get("status");
						ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
								status.get("errordesc").toString()));
						response = formatJsonOutput(ss_er);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	
	public String creditApplicationList(OpgReq_CreditApplicationList reqCreditAppList) {
		SS_Ret ss_ret = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob prepAppListResponse = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqCreditAppList);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqCreditAppList.getHeader());
		if (auth.checkStatus()) {
			if (sS_Chk.checkDataInstitution(reqCreditAppList.getFilter().getBankcode())
			   && sS_Chk.checkDataVarchar(reqCreditAppList.getFilter().getApplicationid(),"APPLICATION ID",55, 24,'F')
			 //  && sS_Chk.checkDataNumber(reqCreditAppList.getFilter().getApplicationcode(),"APPLICATION CODE", 57, 'F')
			   && sS_Chk.checkDataNumber(reqCreditAppList.getFilter().getBranchcode(),"BRANCH CODE", 58, 'F')
			   && sS_Chk.checkDataVarchar(reqCreditAppList.getFilter().getCustomerid(),"CUSTOMER ID",61, 24,'F') 
					
					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = CREDIT_APPLICATION_LIST[SQL];
						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, prepAppListResponse);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.executeUpdate();
						prepAppListResponse = callableStatement.getClob(2);
						response = clobToString(prepAppListResponse);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);

			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	
	public String updatemobile(OpgReq_UpdateMobile mobileUp) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(mobileUp);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(mobileUp.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataInstitution(mobileUp.getInitiator().getBankcode())
					&& sS_Chk.checkDataCard(mobileUp.getInitiator().getCardcode())
					&& sS_Chk.checkDataPhonenumber(mobileUp.getInitiator().getPhonenumber())
					&& sS_Chk.checkDataNumber(mobileUp.getInitiator().getPhonenumber(),"PHONE NUMBER MUST BE NUMERIC",126,'O')
					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = MOBILE_UPDATE[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						JSONObject json = (JSONObject) new JSONParser().parse(response);
						JSONObject status = (JSONObject) json.get("status");
						ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
								status.get("errordesc").toString()));
						response = formatJsonOutput(ss_er);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	
	public String updateaccount(OpgReq_UpdateAccount accountUp) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(accountUp);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(accountUp.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataInstitution(accountUp.getInitiator().getBankcode())
					&& sS_Chk.checkDataAccountnumber(accountUp.getInitiator().getAccountnumber())
					&& sS_Chk.checkDataAccountnumber(accountUp.getInitiator().getNewaccountnumber())
					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = ACCOUNT_UPDATE[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						JSONObject json = (JSONObject) new JSONParser().parse(response);
						JSONObject status = (JSONObject) json.get("status");
						ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
								status.get("errordesc").toString()));
						response = formatJsonOutput(ss_er);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	
	public String changeStatusMerchant(OpgReq_MerchantStatus merchantStUp) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(merchantStUp);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(merchantStUp.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataStatus(merchantStUp.getInitiator().getStatus())
					&& sS_Chk.checkDataNumber(merchantStUp.getInitiator().getMerchantID(),"MERCHANT ID", 108, 'O')
					&& sS_Chk.checkDataInstitution(merchantStUp.getInitiator().getBankcode())) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = MERCHANT_STATUS[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						JSONObject json = (JSONObject) new JSONParser().parse(response);
						JSONObject status = (JSONObject) json.get("status");
						ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
								status.get("errordesc").toString()));
						response = formatJsonOutput(ss_er);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	
	public String InterfaceList(OpgReq_InterfaceList reqInterfaceList) {
		SS_Ret ss_ret = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob prepAppListResponse = null;

		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqInterfaceList);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqInterfaceList.getHeader());
		if (auth.checkStatus()) {
			if (sS_Chk.checkDataInstitution(reqInterfaceList.getFilter().getBankcode())
					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = INTERFACE_LIST[SQL];
						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, prepAppListResponse);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.executeUpdate();
						prepAppListResponse = callableStatement.getClob(2);
						response = clobToString(prepAppListResponse);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);

			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	
	public String InternetMailOrderStatus(OpgReq_InternetMailOrderStatus IntMailStUp) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(IntMailStUp);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(IntMailStUp.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataStatus(IntMailStUp.getInitiator().getEcommerce())
					&& sS_Chk.checkDataCard(IntMailStUp.getInitiator().getCard())
					&& sS_Chk.checkDataInstitution(IntMailStUp.getInitiator().getBankcode())
					
					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = INTERNET_MAIL_ORDER_STATUS[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						JSONObject json = (JSONObject) new JSONParser().parse(response);
						JSONObject status = (JSONObject) json.get("status");
						ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
								status.get("errordesc").toString()));
						response = formatJsonOutput(ss_er);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	

	public String anonymPrepaidCard(OpgReq_anonymPrepaidCard ReqanonymPrepaidCard) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(ReqanonymPrepaidCard);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(ReqanonymPrepaidCard.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataBranchcode(ReqanonymPrepaidCard.getInitiator().getBranchcode())
					&& sS_Chk.checkDataNumber(ReqanonymPrepaidCard.getInitiator().getTarget_audience(),"Target audience", 111, 'O')
					&& sS_Chk.checkDataNumber(ReqanonymPrepaidCard.getInitiator().getInitamount(),"AMOUNT", 109, 'O')
					&& sS_Chk.checkDataCurrencycode(ReqanonymPrepaidCard.getInitiator().getCurrencyid())
					&& sS_Chk.checkDataCardprogramcode(ReqanonymPrepaidCard.getInitiator().getCardprogramcode())
					&& sS_Chk.checkDataPrepaidprogramcode(ReqanonymPrepaidCard.getInitiator().getPrepaidprogramcode())
					&& sS_Chk.checkDataInstitution(ReqanonymPrepaidCard.getInitiator().getBankcode())
					&& sS_Chk.checkDataNumber(ReqanonymPrepaidCard.getInitiator().getQuantity(),"QUANTITY", 110, 'O')
					&& sS_Chk.checkDataVarchar(ReqanonymPrepaidCard.getInitiator().getCardcategory(),"CARD CATEGORY", 112,24, 'O')
					
					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = ANONYM_PREPAID[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						JSONObject json = (JSONObject) new JSONParser().parse(response);
						JSONObject status = (JSONObject) json.get("status");
						ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
								status.get("errordesc").toString()));
						response = formatJsonOutput(ss_er);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	
	public String changeCommissionMerchant(OpgReq_MerchantCommissionUpdate merchantCommissionUp) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(merchantCommissionUp);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(merchantCommissionUp.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataNumber(merchantCommissionUp.getInitiator().getMerchantcode(),"MERCHANT CODE", 108, 'O')
					&& sS_Chk.checkDataInstitution(merchantCommissionUp.getInitiator().getBankcode())
					&& sS_Chk.checkDataNumber(merchantCommissionUp.getInitiator().getMercommission(),"MERCHANT COMMISSION", 113, 'O')
					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = MERCHANT_COMMISSION[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						JSONObject json = (JSONObject) new JSONParser().parse(response);
						JSONObject status = (JSONObject) json.get("status");
						ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
								status.get("errordesc").toString()));
						response = formatJsonOutput(ss_er);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	
	public String addChargeBack (OpgReq_AddChargeBack reqAddChargeBack)	 {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqAddChargeBack);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqAddChargeBack.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataCard(reqAddChargeBack.getInitiator().getCard())
					&& sS_Chk.checkDataNumber(reqAddChargeBack.getInitiator().getReference(),"REFFERENCE", 114, 'O')
					&& sS_Chk.checkDataInstitution(reqAddChargeBack.getInitiator().getBankcode())
					&& sS_Chk.checkDataNumber(reqAddChargeBack.getInitiator().getReason(),"REASON", 115, 'O')
					//&& sS_Chk.checkDataVarchar(reqAddChargeBack.getInitiator().getBin(),"BIN", 116,20, 'O')
					
					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = ADD_CHARGEBACK[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						JSONObject json = (JSONObject) new JSONParser().parse(response);
						JSONObject status = (JSONObject) json.get("status");
						ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
								status.get("errordesc").toString()));
						response = formatJsonOutput(ss_er);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	

	


	public String AuthReversal (OpgReq_AuthReversal reqAuthReversal)	 {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqAuthReversal);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqAuthReversal.getHeader());
		if (auth.checkStatus()) {

			if (reqAuthReversal.getInitiator().getOperation().equalsIgnoreCase("AUTHREV"))
			{
				
				if (sS_Chk.checkDataInstitution(reqAuthReversal.getInitiator().getBankcode())
						&& sS_Chk.checkDataCard(reqAuthReversal.getInitiator().getCard())
						&& sS_Chk.checkDataVarchar(reqAuthReversal.getInitiator().getProcode(),"PROC CODE", 117,3, 'O')
						&& sS_Chk.checkDataNumber(reqAuthReversal.getInitiator().getTransactioncode(),"TRANSACTION CODE", 118, 'O')
						&& sS_Chk.checkDataExpiry(reqAuthReversal.getInitiator().getExpirydate())
						&& sS_Chk.checkDataCurrencycode(reqAuthReversal.getInitiator().getCurrency())
						&& sS_Chk.checkDataVarchar(reqAuthReversal.getInitiator().getCvv(),"CVV", 119,3, 'O')
						&& sS_Chk.checkDataNumber(reqAuthReversal.getInitiator().getMerchantcode(),"MERCHANT CODE", 108, 'O')
						&& sS_Chk.checkDataNumber(reqAuthReversal.getInitiator().getAuthcode(),"AUTH CODE", 121, 'O')
						&& sS_Chk.checkDataNumber(reqAuthReversal.getInitiator().getAmount(),"AMOUNT", 109, 'O')

						) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = AUTH_REVERSAL[SQL];

							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.registerOutParameter(2, Types.NVARCHAR);
							callableStatement.execute();
							response = callableStatement.getString(2);

							JSONObject json = (JSONObject) new JSONParser().parse(response);
							JSONObject status = (JSONObject) json.get("status");
							ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
									status.get("errordesc").toString()));
							response = formatJsonOutput(ss_er);
						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);

						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());

					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
				
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	
	public String PurchaseAdvice (OpgReq_PurchaseAdvice reqPurchaseAdvice)	 {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqPurchaseAdvice);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqPurchaseAdvice.getHeader());
		if (auth.checkStatus()) {

			if (reqPurchaseAdvice.getInitiator().getOperation().equalsIgnoreCase("ADVICE"))
			{
				
				if ( sS_Chk.checkDataInstitution(reqPurchaseAdvice.getInitiator().getBankcode())
						&& sS_Chk.checkDataCard(reqPurchaseAdvice.getInitiator().getCard())
						&& sS_Chk.checkDataVarchar(reqPurchaseAdvice.getInitiator().getProcode(),"PROC CODE", 117,3, 'O')
						&& sS_Chk.checkDataNumber(reqPurchaseAdvice.getInitiator().getTransactioncode(),"TRANSACTION CODE", 118, 'O')
						&& sS_Chk.checkDataExpiry(reqPurchaseAdvice.getInitiator().getExpirydate())
						&& sS_Chk.checkDataCurrencycode(reqPurchaseAdvice.getInitiator().getCurrency())
						&& sS_Chk.checkDataVarchar(reqPurchaseAdvice.getInitiator().getCvv(),"CVV", 119,3, 'O')
						&& sS_Chk.checkDataNumber(reqPurchaseAdvice.getInitiator().getMerchantcode(),"MERCHANT CODE", 108, 'O')
						&& sS_Chk.checkDataVarchar(reqPurchaseAdvice.getInitiator().getMoto(),"MOTO", 120,3, 'O')
						&& sS_Chk.checkDataNumber(reqPurchaseAdvice.getInitiator().getAmount(),"AMOUNT", 109, 'O')
						&& sS_Chk.checkDataNumber(reqPurchaseAdvice.getInitiator().getTerminal(),"Terminal", 128, 'O')
						


						) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = PURCHASE_ADVICE[SQL];

							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.registerOutParameter(2, Types.NVARCHAR);
							callableStatement.execute();
							response = callableStatement.getString(2);

							JSONObject json = (JSONObject) new JSONParser().parse(response);
							JSONObject status = (JSONObject) json.get("status");
							ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
									status.get("errordesc").toString()));
							response = formatJsonOutput(ss_er);
						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);

						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());

					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
				
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	
	public String ManageAddress (OpgReq_ManageAddress reqManageAddr)	 {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqManageAddr);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqManageAddr.getHeader());
		if (auth.checkStatus()) {

			if (reqManageAddr.getInitiator().getOperation().equalsIgnoreCase("ADD"))
			{
				
				if (sS_Chk.checkDataInstitution(reqManageAddr.getInitiator().getBankcode())
						&& sS_Chk.checkDataVarchar(reqManageAddr.getInitiator().getEntity(),"Entity", 122,20, 'O')
						&& sS_Chk.checkDataNumber(reqManageAddr.getInitiator().getEntityid(),"ENTITY ID CODE", 123, 'O')
						&& sS_Chk.checkDataCustomeraddress(reqManageAddr.getInitiator().getAddress1())
						&& sS_Chk.checkDataCustomeraddress(reqManageAddr.getInitiator().getAddress2())
						&& sS_Chk.checkDataCustomeraddress(reqManageAddr.getInitiator().getAdr_STR())
						&& sS_Chk.checkDataCitycode(reqManageAddr.getInitiator().getCity())
						&& sS_Chk.checkDataPhonenumber(reqManageAddr.getInitiator().getPhone())
						&& sS_Chk.checkDataZipaddress(reqManageAddr.getInitiator().getZipaddress())
						&& sS_Chk.checkDataFax(reqManageAddr.getInitiator().getFax())
						&& sS_Chk.checkDataBranch(reqManageAddr.getInitiator().getBranchcode())
						&& sS_Chk.checkDataAddresstype(reqManageAddr.getInitiator().getAdr_type())
						&& sS_Chk.checkDataNumber(reqManageAddr.getInitiator().getAdr_id(),"ADDRESS ID CODE", 124, 'O')

						

						) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = MANAGE_ADDRESS[SQL];

							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.registerOutParameter(2, Types.NVARCHAR);
							callableStatement.execute();
							response = callableStatement.getString(2);

							JSONObject json = (JSONObject) new JSONParser().parse(response);
							JSONObject status = (JSONObject) json.get("status");
							ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
									status.get("errordesc").toString()));
							response = formatJsonOutput(ss_er);
						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);

						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());

					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
				
			}
			
			
			if (reqManageAddr.getInitiator().getOperation().equalsIgnoreCase("UPDATE"))
			{
				
				if (sS_Chk.checkDataInstitution(reqManageAddr.getInitiator().getBankcode())
						&& sS_Chk.checkDataVarchar(reqManageAddr.getInitiator().getEntity(),"Entity", 122,20, 'O')
						&& sS_Chk.checkDataNumber(reqManageAddr.getInitiator().getEntityid(),"ENTITY ID CODE", 123, 'O')
						&& sS_Chk.checkDataCustomeraddress(reqManageAddr.getInitiator().getAddress1())
						&& sS_Chk.checkDataCustomeraddress(reqManageAddr.getInitiator().getAddress2())
						&& sS_Chk.checkDataCustomeraddress(reqManageAddr.getInitiator().getAdr_STR())
						&& sS_Chk.checkDataCitycode(reqManageAddr.getInitiator().getCity())
						&& sS_Chk.checkDataPhonenumber(reqManageAddr.getInitiator().getPhone())
						&& sS_Chk.checkDataZipaddress(reqManageAddr.getInitiator().getZipaddress())
						&& sS_Chk.checkDataFax(reqManageAddr.getInitiator().getFax())
						&& sS_Chk.checkDataBranch(reqManageAddr.getInitiator().getBranchcode())
						&& sS_Chk.checkDataAddresstype(reqManageAddr.getInitiator().getAdr_type())
						&& sS_Chk.checkDataNumber(reqManageAddr.getInitiator().getAdr_id(),"ADDRESS ID CODE", 124, 'O')

						

						) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = MANAGE_ADDRESS[SQL];

							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.registerOutParameter(2, Types.NVARCHAR);
							callableStatement.execute();
							response = callableStatement.getString(2);

							JSONObject json = (JSONObject) new JSONParser().parse(response);
							JSONObject status = (JSONObject) json.get("status");
							ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
									status.get("errordesc").toString()));
							response = formatJsonOutput(ss_er);
						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);

						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());

					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
				
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	
	public String UpdateRiskCard (OpgReq_RiskCardUpdate reqRiskCardUpdate)	 {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqRiskCardUpdate);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqRiskCardUpdate.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataCard(reqRiskCardUpdate.getInitiator().getCard())
					&& sS_Chk.checkDataInstitution(reqRiskCardUpdate.getInitiator().getBankcode())
					&& sS_Chk.checkDataNumber(reqRiskCardUpdate.getInitiator().getRiskcode(),"RISK CODE", 125, 'O')
					
					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = UPDATE_RISK_CODE[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						JSONObject json = (JSONObject) new JSONParser().parse(response);
						JSONObject status = (JSONObject) json.get("status");
						ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
								status.get("errordesc").toString()));
						response = formatJsonOutput(ss_er);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	
	public String PurchaseAuth(OpgReq_PurchaseAuth reqPurchaseAuth) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;//
		SS_Ba ss_ba = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqPurchaseAuth);

		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqPurchaseAuth.getHeader());
		if (auth.checkStatus()) {

					if (    sS_Chk.checkDataInstitution(reqPurchaseAuth.getInitiator().getBankcode())
							&& sS_Chk.checkDataCard(reqPurchaseAuth.getInitiator().getCard())
							&& sS_Chk.checkDataVarchar(reqPurchaseAuth.getInitiator().getProcode(),"PROC CODE", 117,3, 'O')
							&& sS_Chk.checkDataNumber(reqPurchaseAuth.getInitiator().getTransactioncode(),"TRANSACTION CODE", 118, 'O')
							&& sS_Chk.checkDataExpiry(reqPurchaseAuth.getInitiator().getExpirydate())
							&& sS_Chk.checkDataCurrencycode(reqPurchaseAuth.getInitiator().getCurrency())
							&& sS_Chk.checkDataVarchar(reqPurchaseAuth.getInitiator().getCvv(),"CVV", 119,3, 'O')
							&& sS_Chk.checkDataNumber(reqPurchaseAuth.getInitiator().getMerchantcode(),"MERCHANT CODE", 108, 'O')
							&& sS_Chk.checkDataVarchar(reqPurchaseAuth.getInitiator().getMoto(),"MOTO", 120,3, 'O')
							&& sS_Chk.checkDataNumber(reqPurchaseAuth.getInitiator().getAmount(),"AMOUNT", 109, 'O')
							&& sS_Chk.checkDataNumber(reqPurchaseAuth.getInitiator().getTerminal(),"Terminal", 128, 'O')



							){
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = PURCHASE_AUTH[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						if (response.contains("balance")) {

							JSONObject json = (JSONObject) new JSONParser().parse(response);
							JSONObject balance = (JSONObject) json.get("balance");
							JSONObject status = (JSONObject) json.get("status");
							ss_ba = new SS_Ba(auth.getHeader(),
									new OpgEnt_Balance(balance.get("available").toString(),
											balance.get("currency").toString()),
									new OpgEnt_Status(status.get("errorcode").toString(),
											status.get("errordesc").toString()));
							response = formatJsonOutput(ss_ba);

						} else {

							JSONObject json = (JSONObject) new JSONParser().parse(response);
							JSONObject status = (JSONObject) json.get("status");
							ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
									status.get("errordesc").toString()));
							response = formatJsonOutput(ss_er);

						}

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	public String anonymDebitCard(OpgReq_anonymDebitCard ReqanonymDebitCard) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(ReqanonymDebitCard);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(ReqanonymDebitCard.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataBranchcode(ReqanonymDebitCard.getInitiator().getBranchcode())
					&& sS_Chk.checkDataNumber(ReqanonymDebitCard.getInitiator().getTarget_audience(),"Target audience", 111, 'O')
					&& sS_Chk.checkDataNumber(ReqanonymDebitCard.getInitiator().getInitamount(),"AMOUNT", 109, 'O')
					&& sS_Chk.checkDataCurrencycode(ReqanonymDebitCard.getInitiator().getCurrencyid())
					&& sS_Chk.checkDataCardprogramcode(ReqanonymDebitCard.getInitiator().getCardprogramcode())
					&& sS_Chk.checkDataDebitprogramcode(ReqanonymDebitCard.getInitiator().getDebitprogramcode())
					&& sS_Chk.checkDataInstitution(ReqanonymDebitCard.getInitiator().getBankcode())
					&& sS_Chk.checkDataNumber(ReqanonymDebitCard.getInitiator().getQuantity(),"QUANTITY", 110, 'O')
					&& sS_Chk.checkDataVarchar(ReqanonymDebitCard.getInitiator().getCardcategory(),"CARD CATEGORY", 112,24, 'O')
					
					) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = ANONYM_DEBIT[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						JSONObject json = (JSONObject) new JSONParser().parse(response);
						JSONObject status = (JSONObject) json.get("status");
						ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
								status.get("errordesc").toString()));
						response = formatJsonOutput(ss_er);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
		public String getTerminalsByMerchantId(OpgReq_MerchantTerminalsList opgReq_MerchantTerminalsList) {
//		opgReq_MerchantTerminalsList = new OpgReq_MerchantTerminalsList(DEFAULT_HEAD, null);
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob merchantTerminalResponse = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(opgReq_MerchantTerminalsList);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(opgReq_MerchantTerminalsList.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataVarchar(opgReq_MerchantTerminalsList.getInitiator().getMerchantId(), "Merchant id", 111,15, 'O')
				&& sS_Chk.checkDataVarchar(opgReq_MerchantTerminalsList.getInitiator().getInstitution(),"Insitution", 119, 10, 'O')) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = GET_TERMINARLS_BY_MERCHANT_ID[SQL];
						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, merchantTerminalResponse);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.execute();
						merchantTerminalResponse = callableStatement.getClob(2);
						response = clobToString(merchantTerminalResponse);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);
					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String getMerchantTransactions(OpgReq_MerchantTransactionsList opgReq_MerchantTransactionsList) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob merchantTransactionList = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(opgReq_MerchantTransactionsList);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(opgReq_MerchantTransactionsList.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataVarchar(opgReq_MerchantTransactionsList.getInitiator().getMerchantId(), "Merchant id",
					116, 15, 'O')
					&& sS_Chk.checkDataStartNumeric(opgReq_MerchantTransactionsList.getInitiator().getStart())
					&& sS_Chk.checkDataEndNumeric(opgReq_MerchantTransactionsList.getInitiator().getEnd())) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = GET_MERCHANT_TRANSACTIONS[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, merchantTransactionList);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.execute();
						merchantTransactionList = callableStatement.getClob(2);
						response = clobToString(merchantTransactionList);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);
					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String getMerchantTerminalTransactions(
			OpgReq_MerchantTerminalTransactionList opgReq_MerchantTerminalTransactionList) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob merchantTransactionList = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(opgReq_MerchantTerminalTransactionList);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(opgReq_MerchantTerminalTransactionList.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataVarchar(opgReq_MerchantTerminalTransactionList.getFilter().getMerchantId(), "Merchant id", 116, 15, 'O')
					&& sS_Chk.checkDataVarchar(opgReq_MerchantTerminalTransactionList.getFilter().getTerminalId(),
							"Terminal id", 117, 16, 'O')
					&& sS_Chk.checkDataStartNumeric(opgReq_MerchantTerminalTransactionList.getFilter().getStart())
					&& sS_Chk.checkDataEndNumeric(opgReq_MerchantTerminalTransactionList.getFilter().getEnd())) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = GET_MERCHANT_TERMINAL_TRANSACTIONS[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, merchantTransactionList);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.execute();
						merchantTransactionList = callableStatement.getClob(2);
						response = clobToString(merchantTransactionList);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);
					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String getCardRisk(OpgReq_CardRisk opgReq_CardRisk) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob merchantTransactionList = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(opgReq_CardRisk);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(opgReq_CardRisk.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataVarchar(opgReq_CardRisk.getFilter().getBankcode(),"BANK", 120, 16, 'O')) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = GET_CARD_RISK[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, merchantTransactionList);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.execute();
						merchantTransactionList = callableStatement.getClob(2);
						response = clobToString(merchantTransactionList);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);
					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String getPosMonitoring(OpgReq_PosMonitoring opgReq_PosMonitoring) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob merchantTransactionList = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(opgReq_PosMonitoring);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(opgReq_PosMonitoring.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataStartNumeric(opgReq_PosMonitoring.getFilter().getStart())
					&& sS_Chk.checkDataEndNumeric(opgReq_PosMonitoring.getFilter().getEnd())) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = GET_POS_MONITORING[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, merchantTransactionList);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.execute();
						merchantTransactionList = callableStatement.getClob(2);
						response = clobToString(merchantTransactionList);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);
					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String sendPinBySMS(OpgReq_PinBySms opgReq_PinBySms) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob merchantTransactionList = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(opgReq_PinBySms);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(opgReq_PinBySms.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataVarchar(opgReq_PinBySms.getInitiator().getCardcode(), "Card Number", 120, 16, 'O')
					&& sS_Chk.checkDataVarchar(opgReq_PinBySms.getInitiator().getInstitution(), "Bank", 121, 17, 'O')) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = SEND_PIN_BY_SMS[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, merchantTransactionList);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.execute();
						merchantTransactionList = callableStatement.getClob(2);
						response = clobToString(merchantTransactionList);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);
					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
        
	public String sendPinByEmail(OpgReq_PinByEmail opgReq_PinByEmail) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob merchantTransactionList = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(opgReq_PinByEmail);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(opgReq_PinByEmail.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataVarchar(opgReq_PinByEmail.getInitiator().getCardcode(), "Card Number", 120, 16, 'O')
					&& sS_Chk.checkDataVarchar(opgReq_PinByEmail.getInitiator().getInstitution(), "Bank", 121, 17, 'O')) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = SEND_PIN_BY_EMAIL[SQL];
						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, merchantTransactionList);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.execute();
						merchantTransactionList = callableStatement.getClob(2);
						response = clobToString(merchantTransactionList);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);
					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

        public String sendSmsAlert (OpgReq_SendSmsAlert opgReq_sendSmsAlert) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(opgReq_sendSmsAlert);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(opgReq_sendSmsAlert.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataVarchar(opgReq_sendSmsAlert.getInitiator().getInstitution(), "Bank", 121, 17, 'O')) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = SEND_SMS_ALERT[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);
                                                
					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

        public String atmMonitoring (OpgReq_AtmMonitoring opgReq_AtmMonitoring) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(opgReq_AtmMonitoring);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(opgReq_AtmMonitoring.getHeader());
		if (auth.checkStatus()) {
			if (sS_Chk.checkDataVarchar(opgReq_AtmMonitoring.getInitiator().getInstitution(), "BANK", 121, 10, 'O')) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = ATM_MONITORING[SQL];
						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);
					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { 
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
        
        
	public String debitApplicationTemp(OpgReq_DebitApplicationTemp reqDebitApplicationTemp) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob debitAppResponse = null;
		String authHeader = "";

		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqDebitApplicationTemp);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}
                
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqDebitApplicationTemp.getHeader());
		if (auth.checkStatus()) {

			if (reqDebitApplicationTemp.getInitiator().getOperation().equalsIgnoreCase("DELETE")) {

				if (sS_Chk.checkDataInstitution(reqDebitApplicationTemp.getInitiator().getInstitution())
						&& sS_Chk.checkDataOperation(reqDebitApplicationTemp.getInitiator().getOperation())
						&& sS_Chk.checkDataApplicationId(reqDebitApplicationTemp.getInitiator().getApplicationid())) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = DEBIT_APPLICATION_TEMP[SQL];
							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.registerOutParameter(2, Types.NVARCHAR);
							callableStatement.execute();
							response = callableStatement.getString(2);
							authHeader = formatJsonOutput(auth.getHeader());
							response = TransformStringToJson(authHeader, response);

						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);

						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());

					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}

			}

			if (reqDebitApplicationTemp.getInitiator().getOperation().equalsIgnoreCase("ADD")) {
				if (sS_Chk.checkDataInstitution(reqDebitApplicationTemp.getInitiator().getInstitution())
						&& sS_Chk.checkDataNameoncard(reqDebitApplicationTemp.getInitiator().getNameoncard())
						&& sS_Chk.checkDataFirstname(reqDebitApplicationTemp.getInitiator().getFirstname())
						&& sS_Chk.checkDataMiddlename(reqDebitApplicationTemp.getInitiator().getMiddlename())
						&& sS_Chk.checkDataLastname(reqDebitApplicationTemp.getInitiator().getLastname())
						&& sS_Chk.checkDataCustomertype(reqDebitApplicationTemp.getInitiator().getCustomertype())
						&& sS_Chk.checkDataAccounttype(reqDebitApplicationTemp.getInitiator().getAccounttype())
						&& sS_Chk.checkDataCustomeraddress(reqDebitApplicationTemp.getInitiator().getCustomeraddress())
						&& sS_Chk.checkDataPhoneNumber(reqDebitApplicationTemp.getInitiator().getPhonenumber(),"PHONE NUMBER", 93, 'O')
						&& sS_Chk.checkDataNationalid(reqDebitApplicationTemp.getInitiator().getNationalid())
						&& sS_Chk.checkDataOperation(reqDebitApplicationTemp.getInitiator().getOperation())
						&& sS_Chk.checkDataNationalidtype(reqDebitApplicationTemp.getInitiator().getNationalidtype())
						&& sS_Chk.checkDataCurrencycode(reqDebitApplicationTemp.getInitiator().getCurrencycode())
						&& sS_Chk.checkDataBranchcode(reqDebitApplicationTemp.getInitiator().getBranchcode())
						&& sS_Chk.checkDataCardprogramcode(reqDebitApplicationTemp.getInitiator().getCardprogramcode())
						&& sS_Chk.checkDataCitycode(reqDebitApplicationTemp.getInitiator().getCitycode())
						&& sS_Chk.checkDataBirthdate(reqDebitApplicationTemp.getInitiator().getBirthdate())
						&& sS_Chk.checkDataAccountnumber(reqDebitApplicationTemp.getInitiator().getAccountnumber())
						&& sS_Chk.checkDataCustomerid(reqDebitApplicationTemp.getInitiator().getCustomerid())
						&& sS_Chk.checkDataTypeaccount(reqDebitApplicationTemp.getInitiator().getAccounttype())
						&& sS_Chk.checkDataAccounttype(reqDebitApplicationTemp.getInitiator().getAccounttype())
						&& sS_Chk.checkDataGender(reqDebitApplicationTemp.getInitiator().getGender())
						&& sS_Chk.checkDataBirthdatelocation(reqDebitApplicationTemp.getInitiator().getBirthdatelocation())
						&& sS_Chk.checkDataCorporatename(reqDebitApplicationTemp.getInitiator().getCorporatename())
						&& sS_Chk.checkDataFax(reqDebitApplicationTemp.getInitiator().getFax())
						&& sS_Chk.checkDataProfetionalposition(reqDebitApplicationTemp.getInitiator().getProfetionalposition())
						&& sS_Chk.checkDataMaritalstatus(reqDebitApplicationTemp.getInitiator().getMaritalstatus())
						&& sS_Chk.checkDataTitle(reqDebitApplicationTemp.getInitiator().getTitle())
						&& sS_Chk.checkDataDebitprogram(reqDebitApplicationTemp.getInitiator().getDebitprogram())
						&& sS_Chk.checkDataCountry(reqDebitApplicationTemp.getInitiator().getCountry())
						&& sS_Chk.checkDataAddresstype(reqDebitApplicationTemp.getInitiator().getAddresstype())
				) {
					if ("m".equalsIgnoreCase(reqDebitApplicationTemp.getInitiator().getOption())) {
						if (sS_Chk.checkIfEmpty(reqDebitApplicationTemp.getInitiator().getCardNumber()) 
                                                        || !sS_Chk.checkIfNumeric(reqDebitApplicationTemp.getInitiator().getCardNumber()) 
                                                        || !sS_Chk.checkStringLenght(reqDebitApplicationTemp.getInitiator().getCardNumber())) {
							sS_Status = new SS_Stt(); 
							if (sS_Chk.checkIfEmpty(reqDebitApplicationTemp.getInitiator().getCardNumber())) {
									sS_Status.setDescstatus("CARD NUMBER CANNOT BE EMPTY");
							}
							else if (sS_Chk.checkStringLenght(reqDebitApplicationTemp.getInitiator().getCardNumber()) == false) {
								sS_Status.setDescstatus("CARD NUMBER MUST CONTAIN FROM 16 TO 19 DIGITS");
							}
							else if (sS_Chk.checkIfNumeric(reqDebitApplicationTemp.getInitiator().getCardNumber()) == false) {
								sS_Status.setDescstatus("CARD NUMBER Must Be a Numeric Value");
							}
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);
						} else {
							try {
								System.out.println("in if block");
								if (isLiveCtx()) {
									connection = SS_INIT.getDBConnection();
									String program = DEBIT_APPLICATION_TEMP[SQL];
									callableStatement = connection.prepareCall(program);
									callableStatement.setString(1, requestJson);
									callableStatement.setClob(2, debitAppResponse);
									callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
									callableStatement.executeUpdate();
									debitAppResponse = callableStatement.getClob(2);
									response = clobToString(debitAppResponse);
									authHeader = formatJsonOutput(auth.getHeader());
									response = TransformStringToJson(authHeader, response);

								} else {
									sS_Status = new SS_Stt();
									sS_Status.setMsgerror("Option can accept only : m, M, A, a values");
									ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
									response = formatJsonOutput(ss_ret);
								}
							} catch (Exception e) {
								sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
										emsg(ER_PROCESS) + e.getMessage());

							} finally {
								if (callableStatement != null) {
									try {
										callableStatement.close();
									} catch (SQLException ex) {
										Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
									}
								}
								if (connection != null) {
									try {
										connection.close();
									} catch (Exception ignore) {
									}
								}
							}
						}
					} else if (reqDebitApplicationTemp.getInitiator().getOption().equalsIgnoreCase("a")
							|| reqDebitApplicationTemp.getInitiator().getOption().isEmpty()) {
						try {
							System.out.println("in else if block");
							if (isLiveCtx()) {
								connection = SS_INIT.getDBConnection();
								String program = DEBIT_APPLICATION_TEMP[SQL];
								callableStatement = connection.prepareCall(program);
								callableStatement.setString(1, requestJson);
								callableStatement.setClob(2, debitAppResponse);
								callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
								callableStatement.executeUpdate();
								debitAppResponse = callableStatement.getClob(2);
								response = clobToString(debitAppResponse);
								authHeader = formatJsonOutput(auth.getHeader());
								response = TransformStringToJson(authHeader, response);
 							} else {
								sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN),
										emsg(ER_CLEAN));
								ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
								response = formatJsonOutput(ss_ret);
							}
						} catch (Exception e) {
							sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
									emsg(ER_PROCESS) + e.getMessage());

						} finally {
							if (callableStatement != null) {
								try {
									callableStatement.close();
								} catch (SQLException ex) {
									Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
								}
							}
							if (connection != null) {
								try {
									connection.close();
								} catch (Exception ignore) {
								}
							}
						}
					} else {
						sS_Status = new SS_Stt("", "Option can be either m,M,a,A or empty", "", "");
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
			}

			if (reqDebitApplicationTemp.getInitiator().getOperation().equalsIgnoreCase("UPDATE")) {

				if (sS_Chk.checkDataInstitution(reqDebitApplicationTemp.getInitiator().getInstitution())
						&& sS_Chk.checkDataNameoncard(reqDebitApplicationTemp.getInitiator().getNameoncard())
						&& sS_Chk.checkDataFirstname(reqDebitApplicationTemp.getInitiator().getFirstname())
						&& sS_Chk.checkDataMiddlename(reqDebitApplicationTemp.getInitiator().getMiddlename())
						&& sS_Chk.checkDataLastname(reqDebitApplicationTemp.getInitiator().getLastname())
						&& sS_Chk.checkDataCustomertype(reqDebitApplicationTemp.getInitiator().getCustomertype())
						&& sS_Chk.checkDataAccounttype(reqDebitApplicationTemp.getInitiator().getAccounttype())
						&& sS_Chk.checkDataCustomeraddress(reqDebitApplicationTemp.getInitiator().getCustomeraddress())
						&& sS_Chk.checkDataPhoneNumber(reqDebitApplicationTemp.getInitiator().getPhonenumber(), "PHONE NUMBER", 93, 'O')
						&& sS_Chk.checkDataNationalid(reqDebitApplicationTemp.getInitiator().getNationalid())
						&& sS_Chk.checkDataOperation(reqDebitApplicationTemp.getInitiator().getOperation())
						&& sS_Chk.checkDataNationalidtype(reqDebitApplicationTemp.getInitiator().getNationalidtype())
						&& sS_Chk.checkDataCurrencycode(reqDebitApplicationTemp.getInitiator().getCurrencycode())
						&& sS_Chk.checkDataBranchcode(reqDebitApplicationTemp.getInitiator().getBranchcode())
						&& sS_Chk.checkDataCardprogramcode(reqDebitApplicationTemp.getInitiator().getCardprogramcode())
						&& sS_Chk.checkDataCitycode(reqDebitApplicationTemp.getInitiator().getCitycode())
						&& sS_Chk.checkDataBirthdate(reqDebitApplicationTemp.getInitiator().getBirthdate())
						&& sS_Chk.checkDataApplicationId(reqDebitApplicationTemp.getInitiator().getApplicationid())
						&& sS_Chk.checkDataAccountnumber(reqDebitApplicationTemp.getInitiator().getAccountnumber())
						&& sS_Chk.checkDataCustomerid(reqDebitApplicationTemp.getInitiator().getCustomerid())
						&& sS_Chk.checkDataTypeaccount(reqDebitApplicationTemp.getInitiator().getAccounttype())
						&& sS_Chk.checkDataAccounttype(reqDebitApplicationTemp.getInitiator().getAccounttype())
						&& sS_Chk.checkDataGender(reqDebitApplicationTemp.getInitiator().getGender())
						&& sS_Chk.checkDataBirthdatelocation( reqDebitApplicationTemp.getInitiator().getBirthdatelocation())
						&& sS_Chk.checkDataCorporatename(reqDebitApplicationTemp.getInitiator().getCorporatename())
						&& sS_Chk.checkDataFax(reqDebitApplicationTemp.getInitiator().getFax())
						&& sS_Chk.checkDataProfetionalposition( reqDebitApplicationTemp.getInitiator().getProfetionalposition())
						&& sS_Chk.checkDataMaritalstatus(reqDebitApplicationTemp.getInitiator().getMaritalstatus())
						&& sS_Chk.checkDataTitle(reqDebitApplicationTemp.getInitiator().getTitle())
						&& sS_Chk.checkDataDebitprogram(reqDebitApplicationTemp.getInitiator().getDebitprogram())
						&& sS_Chk.checkDataCountry(reqDebitApplicationTemp.getInitiator().getCountry())
						&& sS_Chk.checkDataAddresstype(reqDebitApplicationTemp.getInitiator().getAddresstype())
				) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = DEBIT_APPLICATION_TEMP[SQL];
							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.setClob(2, debitAppResponse);
							callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
							callableStatement.executeUpdate();
							debitAppResponse = callableStatement.getClob(2);
							response = clobToString(debitAppResponse);
							authHeader = formatJsonOutput(auth.getHeader());
							response = TransformStringToJson(authHeader, response);
						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);

						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());

					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}

			}

		} else { 
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String UpdateRiskCardNew(OpgReq_Risk reqRiskCardUpdate) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		Arrays.sort(new int[] {9,1,3,4});
		

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;

                try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqRiskCardUpdate);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqRiskCardUpdate.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataVarchar(reqRiskCardUpdate.getInitiator().getRisk_code(), "Risk Code", 120, 16, 'O')
					&& sS_Chk.checkDataVarchar(reqRiskCardUpdate.getInitiator().getPeriodicity_id(), "Periodicity", 120,
							16, 'O')
					&& sS_Chk.checkDataVarchar(reqRiskCardUpdate.getInitiator().getPeriodicity_code(),
							"Periodicity CODE", 120, 16, 'O')
					&& sS_Chk.checkDataVarchar(reqRiskCardUpdate.getInitiator().getTransaction_type(),
							"Transaction Type", 120, 16, 'O')
					&& sS_Chk.checkDataVarchar(reqRiskCardUpdate.getInitiator().getTransaction_mode(),
							"Transaction mode", 120, 16, 'O')

			) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = UPDATE_RISK_CARD_NEW[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						JSONObject json = (JSONObject) new JSONParser().parse(response);
						JSONObject status = (JSONObject) json.get("status");
						ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
								status.get("errordesc").toString()));
						response = formatJsonOutput(ss_er);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

	public String getProgramRisk(OpgReq_ProgramRisk OpgReq_ProgramRisk) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob merchantTransactionList = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(OpgReq_ProgramRisk);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(OpgReq_ProgramRisk.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataVarchar(OpgReq_ProgramRisk.getFilter().getCardCode(), "Card Code", 120, 16, 'O')) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = GET_PROGRAM_RISK[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, merchantTransactionList);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.execute();
						merchantTransactionList = callableStatement.getClob(2);
						response = clobToString(merchantTransactionList);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);
					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else {
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}


	public String updateRiskNewList(OpgReq_RiskList opgReq_RiskList ) {
		String response = "";
		try {
			for(OpgEnt_Risk riskListTemp : opgReq_RiskList.getInitiator()) {
				response = this.UpdateRiskCardNewUpdate(riskListTemp, opgReq_RiskList.getHeader());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public String UpdateRiskCardNewUpdate(OpgEnt_Risk reqRiskCardUpdate, OpgEnt_Header header) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		OpgReq_Risk riskCardUpdate = new OpgReq_Risk();
		OpgEnt_Risk opgEnt_Risk = new OpgEnt_Risk();
		riskCardUpdate.setInitiator(opgEnt_Risk);
		riskCardUpdate.setHeader(header);

		
		riskCardUpdate.getInitiator().setRisk_code(reqRiskCardUpdate.getRisk_code());
		riskCardUpdate.getInitiator().setPeriodicity_id(reqRiskCardUpdate.getPeriodicity_id());
		riskCardUpdate.getInitiator().setPeriodicity_code(reqRiskCardUpdate.getPeriodicity_code());
		riskCardUpdate.getInitiator().setTransaction_type(reqRiskCardUpdate.getTransaction_type());
		riskCardUpdate.getInitiator().setTransaction_mode(reqRiskCardUpdate.getTransaction_mode());
		riskCardUpdate.getInitiator().setTans_max(reqRiskCardUpdate.getTans_max());;
		riskCardUpdate.getInitiator().setMnt_limite(reqRiskCardUpdate.getMnt_limite());
		riskCardUpdate.getInitiator().setLimite_number(reqRiskCardUpdate.getLimite_number());
		riskCardUpdate.getInitiator().setDomain_type(reqRiskCardUpdate.getDomain_type());
		riskCardUpdate.getInitiator().setInternet(reqRiskCardUpdate.getInternet());
		riskCardUpdate.getInitiator().setStatus(reqRiskCardUpdate.getStatus());
		System.out.println(riskCardUpdate.getInitiator().getStatus());
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(riskCardUpdate);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(riskCardUpdate.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataVarchar(riskCardUpdate.getInitiator().getRisk_code(), "Risk Code", 120, 16, 'O')
					&& sS_Chk.checkDataVarchar(riskCardUpdate.getInitiator().getPeriodicity_id(), "Periodicity", 120,
							16, 'O')
					&& sS_Chk.checkDataVarchar(riskCardUpdate.getInitiator().getPeriodicity_code(),
							"Periodicity CODE", 120, 50, 'O')
					&& sS_Chk.checkDataVarchar(riskCardUpdate.getInitiator().getTransaction_type(),
							"Transaction Type", 120, 50, 'O')
					&& sS_Chk.checkDataVarchar(riskCardUpdate.getInitiator().getTransaction_mode(),
							"Transaction mode", 120, 50, 'F')

			) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = UPDATE_RISK_CARD_NEW[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.registerOutParameter(2, Types.NVARCHAR);
						callableStatement.execute();
						response = callableStatement.getString(2);

						JSONObject json = (JSONObject) new JSONParser().parse(response);
						JSONObject status = (JSONObject) json.get("status");
						ss_er = new SS_ER(auth.getHeader(), new OpgEnt_Status(status.get("errorcode").toString(),
								status.get("errordesc").toString()));
						response = formatJsonOutput(ss_er);

					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	public String getCardlimitRisk(OpgReq_CardRisk opgReq_CardRisk) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob merchantTransactionList = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(opgReq_CardRisk);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(opgReq_CardRisk.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataVarchar(opgReq_CardRisk.getFilter().getBankcode(), "BANK", 120, 10, 'O')) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = GET_CARD_LIMIT_RISK[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, merchantTransactionList);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.execute();
						merchantTransactionList = callableStatement.getClob(2);
						response = clobToString(merchantTransactionList);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);
					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	// END NCH 18072022
	
////NCH 20072022
	public String getstatustypetrans(OpgReq_TransSatuts OpgReq_TransSatuts) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;
		String authHeader = "";

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob merchantTransactionList = null;

		// Convert Json Request To String
		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(OpgReq_TransSatuts);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		// Authentification
		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(OpgReq_TransSatuts.getHeader());
		if (auth.checkStatus()) {

			if (sS_Chk.checkDataVarchar(OpgReq_TransSatuts.getFilter().getCardCode(), "Card Code", 120, 16, 'O')) {
				try {
					if (isLiveCtx()) {
						connection = SS_INIT.getDBConnection();
						String program = GET_STATUS_TYPE_TRANS_CARD[SQL];

						callableStatement = connection.prepareCall(program);
						callableStatement.setString(1, requestJson);
						callableStatement.setClob(2, merchantTransactionList);
						callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
						callableStatement.execute();
						merchantTransactionList = callableStatement.getClob(2);
						response = clobToString(merchantTransactionList);
						authHeader = formatJsonOutput(auth.getHeader());
						response = TransformStringToJson(authHeader, response);
					} else {
						sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
						ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
						response = formatJsonOutput(ss_ret);
					}
				} catch (Exception e) {
					sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
							emsg(ER_PROCESS) + e.getMessage());
				} finally {
					if (callableStatement != null) {
						try {
							callableStatement.close();
						} catch (SQLException ex) {
							Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (Exception ignore) {
						}
					}
				}
			} else {
				sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
				ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
				response = formatJsonOutput(ss_ret);
			}
		} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	
	public String debitApplication_virtual_card(OpgReq_VirtualCard reqvirtualcard) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob debitAppResponse = null;
		String authHeader = "";

		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(reqvirtualcard);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(reqvirtualcard.getHeader());
		if (auth.checkStatus()) {


				if (            sS_Chk.checkDataNameoncard(reqvirtualcard.getInitiator().getNameoncard())
						&& sS_Chk.checkDataPhoneNumber(reqvirtualcard.getInitiator().getPhonenumber(), "PHONE NUMBER", 93, 'O')
						&& sS_Chk.checkDataCardprogramcode(reqvirtualcard.getInitiator().getCardprogramcode())
						&& sS_Chk.checkDataAccountnumber(reqvirtualcard.getInitiator().getAccountnumber())
						&& sS_Chk.checkDataCustomerid(reqvirtualcard.getInitiator().getCustomerid())
				) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = DEBIT_APPLICATION_VIRTUAL_CARD[SQL];
							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.setClob(2, debitAppResponse);
							callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
							callableStatement.executeUpdate();
							debitAppResponse = callableStatement.getClob(2);
							response = clobToString(debitAppResponse);
							authHeader = formatJsonOutput(auth.getHeader());
							response = TransformStringToJson(authHeader, response);

						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);

						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());

					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}

			

					} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
        
        public String vaildate_card_pin (OpgReq_ValidateCardPin opgReq_ValidateCardPin) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob debitAppResponse = null;
		String authHeader = "";

		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(opgReq_ValidateCardPin);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(opgReq_ValidateCardPin.getHeader());
		if (auth.checkStatus()) {
				if ( sS_Chk.checkDataNameoncard(opgReq_ValidateCardPin.getInitiator().getCard())
						&& sS_Chk.checkDataInstitution(opgReq_ValidateCardPin.getInitiator().getInstitution())
				) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = VALIDATE_CARD_PIN[SQL];
							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.setClob(2, debitAppResponse);
							callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
							callableStatement.executeUpdate();
							debitAppResponse = callableStatement.getClob(2);
							response = clobToString(debitAppResponse);
							authHeader = formatJsonOutput(auth.getHeader());
							response = TransformStringToJson(authHeader, response);

						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);

						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());

					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
					} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

 public String vaildate_card_pin0209 (OpgReq_get_card_print_data opgReq_get_card_print_data) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob debitAppResponse = null;
		String authHeader = "";

		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(opgReq_get_card_print_data);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(opgReq_get_card_print_data.getHeader());
		if (auth.checkStatus()) {
				if ( sS_Chk.checkDataNameoncard(opgReq_get_card_print_data.getInitiator().getCard())
						&& sS_Chk.checkDataInstitution(opgReq_get_card_print_data.getInitiator().getInstitution())
				) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = VALIDATE_CARD_PIN[SQL];
							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.setClob(2, debitAppResponse);
							callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
							callableStatement.executeUpdate();
							debitAppResponse = callableStatement.getClob(2);
							response = clobToString(debitAppResponse);
							authHeader = formatJsonOutput(auth.getHeader());
							response = TransformStringToJson(authHeader, response);

						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);

						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());

					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
					} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}
	

public String GET_CARD_PRINT_DATA (OpgReq_get_card_print_data opgReq_get_card_print_data) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob debitAppResponse = null;
		String authHeader = "";

		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(opgReq_get_card_print_data);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(opgReq_get_card_print_data.getHeader());
		if (auth.checkStatus()) {
				if ( sS_Chk.checkDataNameoncard(opgReq_get_card_print_data.getInitiator().getCard())
						&& sS_Chk.checkDataInstitution(opgReq_get_card_print_data.getInitiator().getInstitution())
				) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = GET_CARD_PRINT_DATA[SQL];
							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.setClob(2, debitAppResponse);
							callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
							callableStatement.executeUpdate();
							debitAppResponse = callableStatement.getClob(2);
							response = clobToString(debitAppResponse);
							authHeader = formatJsonOutput(auth.getHeader());
							response = TransformStringToJson(authHeader, response);

						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);

						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());

					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
					} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}

 public String notify(OpgReq_notify opgReq_notify) {
		SS_Ret ss_ret = null;
		SS_ER ss_er = null;

		CallableStatement callableStatement = null;
		Connection connection = null;
		String requestJson;
		String response = "";
		Genson genson;
		SS_Chk sS_Chk = new SS_Chk();
		SS_Stt sS_Status;
		Clob debitAppResponse = null;
		String authHeader = "";

		try {
			genson = SS_INIT.builder.create();
			requestJson = genson.serialize(opgReq_notify);
		} catch (Exception ex) {
			Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
			requestJson = null;
		}

		OpgEnt_Auth auth;
		auth = (new SS_Prc()).processAuthentification(opgReq_notify.getHeader());
		if (auth.checkStatus()) {
				if ( sS_Chk.checkDataUniqid(opgReq_notify.getInitiator().getUniqid())
						&& sS_Chk.checkDataStatus(opgReq_notify.getInitiator().getStatus())
				) {
					try {
						if (isLiveCtx()) {
							connection = SS_INIT.getDBConnection();
							String program = NOTIFY[SQL];
							callableStatement = connection.prepareCall(program);
							callableStatement.setString(1, requestJson);
							callableStatement.setClob(2, debitAppResponse);
							callableStatement.registerOutParameter(2, java.sql.Types.CLOB);
							callableStatement.executeUpdate();
							debitAppResponse = callableStatement.getClob(2);
							response = clobToString(debitAppResponse);
							authHeader = formatJsonOutput(auth.getHeader());
							response = TransformStringToJson(authHeader, response);

						} else {
							sS_Status = new SS_Stt(scode(ST_NODATA), smsg(ST_NODATA), ecode(ER_CLEAN), emsg(ER_CLEAN));
							ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
							response = formatJsonOutput(ss_ret);

						}
					} catch (Exception e) {
						sS_Status = new SS_Stt(scode(ST_ERROR), smsg(ST_ERROR), ecode(ER_PROCESS),
								emsg(ER_PROCESS) + e.getMessage());

					} finally {
						if (callableStatement != null) {
							try {
								callableStatement.close();
							} catch (SQLException ex) {
								Logger.getLogger(SS_Prc.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						if (connection != null) {
							try {
								connection.close();
							} catch (Exception ignore) {
							}
						}
					}
				} else {
					sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
					ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
					response = formatJsonOutput(ss_ret);
				}
					} else { // Authentification Failed
			ss_ret = new SS_Ret(auth.getHeader(), auth.getStatus());
			response = formatJsonOutput(ss_ret);
		}

		if (!sS_Chk.checkResponseEmpty(response)) {
			sS_Status = new SS_Stt(scode(ST_REJECTED), smsg(ST_REJECTED), sS_Chk.code(), sS_Chk.msg());
			ss_ret = new SS_Ret(auth.getHeader(), sS_Status);
			response = formatJsonOutput(ss_ret);
			return response;
		}
		return response;
	}     

}

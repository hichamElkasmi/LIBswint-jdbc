package com.ssw.bnk.swint.jdbc;

import com.ssw.bnk.swint.jdbc.in.SS_Prc;
import com.ssw.bnk.swint.jdbc.in.*;
import com.ssw.bnk.swint.jdbc.requests.*;
import com.owlike.genson.Genson;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hicham ELKASMI
 */
public class SS_Entry {
    
    public String formatJsonOutput(SS_Ret sSReturn){
        String jsonString;
        Genson genson;
        try {
            genson = SS_INIT.builder.create();
            jsonString = genson.serialize(sSReturn);
        } catch (Exception ex) {
            Logger.getLogger(SS_Entry.class.getName()).log(Level.SEVERE, null, ex);
            jsonString=null;
        }
        return jsonString;
    }

    public String getBalance (OpgReq_Balance reqBalance) {
        return (new SS_Prc()).getBalance(reqBalance);
    }
      
     public String changeCardStatus (OpgReq_CardStUp reqCardStUp) {
         return (new SS_Prc()).changeStatusCard(reqCardStUp);
     }
     
     
    public String firstActivation (OpgReq_CardFirstActivation reqCardFirActi) {
         return (new SS_Prc()).firstActivation(reqCardFirActi);
     }
     public String resetPin (OpgReq_ResetPin reqResetPin) {
         return (new SS_Prc()).resetPin(reqResetPin);
     }
     
     public String getRepository (OpgReq_GetRepos reqGetRepos) {
         return (new SS_Prc()).getRepository(reqGetRepos);
     }
     
     public String replacement (OpgReq_Replacement reqReplacement) {
         return (new SS_Prc()).replacement(reqReplacement);
     }
     
     public String reNew (OpgReq_ReNew reqReNew) {
         return (new SS_Prc()).reNew(reqReNew);
     }
     
     public String cardList (OpgReq_CardList reqCardList) {
         return (new SS_Prc()).cardList(reqCardList);
     }
     
     public String accountList (OpgReq_AccountList reqAccountList) {
         return (new SS_Prc()).accountList(reqAccountList);
     }
     
     public String customerList (OpgReq_CustomerList reqCustomerList) {
         return (new SS_Prc()).customerList(reqCustomerList);
     }
     
     public String prepaidApplication (OpgReq_PrepaidApplication reqPrepApplication) {
         return (new SS_Prc()).prepaidApplication(reqPrepApplication);
     }
     
     public String prepaidAppliValidation (OpgReq_PrepaidAppliValidation reqPrepaidAppliValidation) {
         return (new SS_Prc()).prepaidAppliValidation(reqPrepaidAppliValidation);
     }
     
     public String prepaidApplicationList (OpgReq_PrepaidApplicationList reqPrepaidAppliList) {
         return (new SS_Prc()).prepaidApplicationList(reqPrepaidAppliList);
     }
     
     public String debitApplication (OpgReq_DebitApplication reqDebitApplication) {
         return (new SS_Prc()).debitApplication(reqDebitApplication);
     }
     
     // meme code que prepaidAppliValidation
     public String debitAppliValidation (OpgReq_PrepaidAppliValidation reqDebitAppliValidation) {
         return (new SS_Prc()).debitAppliValidation(reqDebitAppliValidation);
     }
     
     public String debitApplicationList (OpgReq_PrepaidApplicationList reqDebitAppliList) {
         return (new SS_Prc()).debitApplicationList(reqDebitAppliList);
     }
     
     public String redemption (OpgReq_Redemption reqRedemption) {
         return (new SS_Prc()).redemption(reqRedemption);
     }
     
     public String reload (OpgReq_Reload reqReload) {
         return (new SS_Prc()).reload(reqReload);
     }
     
     public String merchant (OpgReq_Merchant reqMerchant) {
         return (new SS_Prc()).merchant(reqMerchant);
     }
     
     public String merchantUpdate (OpgReq_MerchantUpdate reqMerchant) {
         return (new SS_Prc()).merchantUpdate(reqMerchant);
     }
     
     public String merchantUpdateNoApplication (OpgReq_MerchantUpdateNoApplication reqMerchant) {
         return (new SS_Prc()).merchantUpdateNoApplication(reqMerchant);
     }
     
     public String merchantAppliValidation (OpgReq_MerchantAppliValidation reqMerchantAppliValidation) {
         return (new SS_Prc()).merchantAppliValidation(reqMerchantAppliValidation);
     }
     
     public String merchantApplicationList (OpgReq_MerchantApplicationList reqMerchantAppliList) {
         return (new SS_Prc()).merchantApplicationList(reqMerchantAppliList);
     }
     
     public String posTerminalApplication (OpgReq_PosTerminalApplication reqPosTerminalApplication) {
         return (new SS_Prc()).posTerminalApplication(reqPosTerminalApplication);
     }
     
     public String posTerminalList (OpgReq_PosTerminalList reqPosTerminalList) {
         return (new SS_Prc()).posTerminalList(reqPosTerminalList);
     }
     
     public String posApplicationList (OpgReq_PosApplicationList reqPosApplicationList) {
         return (new SS_Prc()).posApplicationList(reqPosApplicationList);
     }
     
     public String authorizitionList (OpgReq_AuthorizitaionList reqAuthorizitaionList) {
         return (new SS_Prc()).authorizitionList(reqAuthorizitaionList);
     }
     
     public String getTransaction (OpgReq_GetTransaction reqGetTransaction ) {
         return (new SS_Prc()).getTransaction(reqGetTransaction );
     }
     
     public String accountTransfer (OpgReq_AccountTransfer reqAccountTransfer ) {
         return (new SS_Prc()).accountTransfer(reqAccountTransfer );
     }
     
     public String checkBookRequest (OpgReq_CheckBookRequest CheckBookRequest) {
         return (new SS_Prc()).checkBookRequest(CheckBookRequest);
     }
      public String pingserver (OpgReq_PingServerRequest PingServerRequest) {
         return (new SS_Prc()).PingServer(PingServerRequest);
     }
     
         //Hasnaa Zaid
     
     // meme code que prepaidApplicationList
     public String creditApplication (OpgReq_CreditApplication reqCreditApplication) {
         return (new SS_Prc()).creditApplication(reqCreditApplication);
     }
     
     public String creditAppliValidation (OpgReq_CreditApplicationValidation reqCreditAppliValidation) {
         return (new SS_Prc()).creditAppliValidation(reqCreditAppliValidation);
     }
     
     public String creditApplicationList (OpgReq_CreditApplicationList reqCreditAppliList) {
         return (new SS_Prc()).creditApplicationList(reqCreditAppliList);
     }
     
     public String updatemobile (OpgReq_UpdateMobile reqUpMobile) {
         return (new SS_Prc()).updatemobile(reqUpMobile);
     }
     
     public String updateaccount (OpgReq_UpdateAccount reqUpAccount) {
         return (new SS_Prc()).updateaccount(reqUpAccount);
     }
     
     public String updatemerchantstatus (OpgReq_MerchantStatus reqUpMerchantSt) {
         return (new SS_Prc()).changeStatusMerchant(reqUpMerchantSt);
     }
     
     public String interfaceList (OpgReq_InterfaceList reqInterfaceList) {
         return (new SS_Prc()).InterfaceList(reqInterfaceList);
     }
     
     public String internetmailorderstatus (OpgReq_InternetMailOrderStatus reqUpIntMailOrderSt) {
         return (new SS_Prc()).InternetMailOrderStatus(reqUpIntMailOrderSt);
     }
     
     public String anonymPrepaidCard  (OpgReq_anonymPrepaidCard  ReqanonymPrepaidCard) {
         return (new SS_Prc()).anonymPrepaidCard(ReqanonymPrepaidCard);
     }
     
     public String changeCommissionMerchant (OpgReq_MerchantCommissionUpdate reqUpMerchantCommission) {
         return (new SS_Prc()).changeCommissionMerchant(reqUpMerchantCommission);
     }
     
     public String manageaddress (OpgReq_ManageAddress reqmanageAdress) {
         return (new SS_Prc()).ManageAddress(reqmanageAdress);
     }
     
     public String addChargeBack (OpgReq_AddChargeBack reqAddChargeBack) {
         return (new SS_Prc()).addChargeBack(reqAddChargeBack);
     }
     
     public String purchaseAuth (OpgReq_PurchaseAuth reqPurchaseAuth) {
         return (new SS_Prc()).PurchaseAuth(reqPurchaseAuth);
     }
     
     public String AuthReversal (OpgReq_AuthReversal reqAuthReversal) {
         return (new SS_Prc()).AuthReversal(reqAuthReversal);
     }
     
     public String PurchaseAdvice (OpgReq_PurchaseAdvice reqPurchaseAdvice) {
         return (new SS_Prc()).PurchaseAdvice(reqPurchaseAdvice);
     }
     
     public String UpdateRiskCard (OpgReq_RiskCardUpdate reqRiskCardUpdate) {
         return (new SS_Prc()).UpdateRiskCard(reqRiskCardUpdate);
     }
     
     public String anonymDebitCard  (OpgReq_anonymDebitCard  ReqanonymDebitCard) {
         return (new SS_Prc()).anonymDebitCard(ReqanonymDebitCard);
     }
     
     public String getTerminalsByMerchantId(OpgReq_MerchantTerminalsList opgReq_MerchantTerminalsList) {
		return (new SS_Prc()).getTerminalsByMerchantId(opgReq_MerchantTerminalsList);
     }
	
    public String getMerchantTransactions(OpgReq_MerchantTransactionsList opgReq_MerchantTransactionsList) {
            return (new SS_Prc()).getMerchantTransactions(opgReq_MerchantTransactionsList);
    }
    public String getMerchantTerminalTransactions(OpgReq_MerchantTerminalTransactionList opgReq_MerchantTerminalTransactionList) {
            return (new SS_Prc()).getMerchantTerminalTransactions(opgReq_MerchantTerminalTransactionList);
    }
    public String getCardRisk(OpgReq_CardRisk opgReq_CardRisk) {
            return (new SS_Prc()).getCardRisk(opgReq_CardRisk);
    }
    public String getPosMonitoring(OpgReq_PosMonitoring opgReq_PosMonitoring) {
            return (new SS_Prc()).getPosMonitoring(opgReq_PosMonitoring);
    }
    public String sendPinBySms(OpgReq_PinBySms opgReq_PinBySms) {
            return (new SS_Prc()).sendPinBySMS(opgReq_PinBySms);
    }

    public String sendPinByEmail (OpgReq_PinByEmail opgReq_PinByEmail) {
            return (new SS_Prc()).sendPinByEmail(opgReq_PinByEmail);
    }

    public String sendSmsAler (OpgReq_SendSmsAlert opgReq_SendSmsAlert) {
            return (new SS_Prc()).sendSmsAlert(opgReq_SendSmsAlert);
    }

    public String atmMonitoring (OpgReq_AtmMonitoring opgReq_AtmMonitoring) {
            return (new SS_Prc()).atmMonitoring(opgReq_AtmMonitoring);
    }

    public String debitApplicationTemp(OpgReq_DebitApplicationTemp reqDebitApplication) {
            return (new SS_Prc()).debitApplicationTemp(reqDebitApplication);
    }

    public String updateRiskCardNew(OpgReq_Risk reqCardRisk) {
            return (new SS_Prc()).UpdateRiskCardNew(reqCardRisk);
    }

    public String updateRisksCardNew(OpgReq_RiskList reqCardRiskList) {
            return (new SS_Prc()).updateRiskNewList(reqCardRiskList);
    }

    public String getProgramRisk(OpgReq_ProgramRisk opgReq_ProgramRisk) {
            return (new SS_Prc()).getProgramRisk(opgReq_ProgramRisk);
    }

    public String getCardlimitRisk(OpgReq_CardRisk opgReq_CardRisk) {
            return (new SS_Prc()).getCardlimitRisk(opgReq_CardRisk);
    }

    public String getstatustypetrans(OpgReq_TransSatuts OpgReq_TransSatuts) {
            return (new SS_Prc()).getstatustypetrans(OpgReq_TransSatuts);
    }

    public String DEBIT_APPLICATION_VIRTUAL_CARD(OpgReq_VirtualCard reqvirtualcard) {
            return (new SS_Prc()).debitApplication_virtual_card(reqvirtualcard);
    }

    public String VALIDATE_CARD_PIN(OpgReq_ValidateCardPin opgReq_ValidateCardPin) {
            return (new SS_Prc()).vaildate_card_pin(opgReq_ValidateCardPin);
    }
 public String NOTIFY(OpgReq_notify opgReq_notify) {
            return (new SS_Prc()).notify(opgReq_notify);
    }

 public String GET_CARD_PRINT_DATA(OpgReq_get_card_print_data opgReq_get_card_print_data) {
            return (new SS_Prc()).GET_CARD_PRINT_DATA(opgReq_get_card_print_data);
    }
 

  
    
     
}   

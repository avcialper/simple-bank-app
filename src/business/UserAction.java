
package business;

import dataAcces.DatabaseOperation;
import entities.UserInfo;
import java.util.Random;

public class UserAction {
    
    DatabaseOperation databaseOperation = new DatabaseOperation();
    
    // Generate new iban number.
    public int generateIbanNumber(){
        Random random = new Random();
        boolean booleanIban = true;
        String ibanConcat = "";
        int randomIban = 0;
        while(booleanIban){
            for(int i = 0; i< 4; i++)
                ibanConcat += String.valueOf(random.nextInt(10));
            randomIban = Integer.valueOf(ibanConcat);
            booleanIban = databaseOperation.registeredIbanNumberControl(randomIban);
        }
        return randomIban;
    }
    
    // Generate new account number.
    public int generateAccountNumber(){
        Random random = new Random();
        boolean booleanAccountNumber = true;
        String accountConcat = "";
        int randomAccountNumber = 0;
        while(booleanAccountNumber){
            for(int i = 0; i < 6; i++)
                accountConcat += String.valueOf(random.nextInt(10));
            randomAccountNumber = Integer.valueOf(accountConcat);
            booleanAccountNumber = databaseOperation.registeredAccountNumberControl(randomAccountNumber);
        }
        return randomAccountNumber;
    }
    
    // Login with id number.
    public boolean userLoginWithIdNumber(int idNumber, int password){
        boolean query = databaseOperation.idNumberAndPasswordCheck(idNumber, password);
        if(query)
            return true;
        else
            return false;
    }
    
    // Login with account number.
    public boolean userLoginWithAccountNumber(int accountNumber, int password){
        boolean query = databaseOperation.accountNumberAndPasswordCheck(accountNumber, password);
        if(query)
            return true;
        else
            return false;
    }
    
    // Get user information from database using account number.
    public UserInfo getUserInfoWithAccountNumber(int accountNumber){
        UserInfo memberInfo = databaseOperation.getUserInfoFromDatabaseWithAccountNumber(accountNumber);
        return memberInfo;
    }
    
    // Get user information from database using id number.
    public UserInfo getUserInfoWithIdNumber(int idNumber){
        UserInfo memberInfo = databaseOperation.getUserInfoFromDatabaseWithIdNumber(idNumber);
        return memberInfo;
    }
    
    // Get user information from database using iban number.
    public UserInfo getUserInfoWithIban(int ibanNumber){
        UserInfo memberInfo = databaseOperation.getUserInfoFromDatabaseWithIbanNumber(ibanNumber);
        return memberInfo;
    }
}

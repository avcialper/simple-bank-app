
package business;

import dataAcces.DatabaseOperation;
import entities.UserInfo;
import java.util.Random;

public class UserAction {
    
    DatabaseOperation databaseOperation = new DatabaseOperation();
    
    public int creatIbanNumber(){
        // Yeni iban numarası oluşturma
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
    
    public int creatAccountNumber(){
        // Hesap numarası oluşturma
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
    
    public boolean userLoginWithIdNumber(int idNumber, int password){
        // TC numarası ile giriş yapma
        boolean query = databaseOperation.idNumberAndPasswordCheck(idNumber, password);
        if(query)
            return true;
        else
            return false;
    }
    
    public boolean userLoginWithAccountNumber(int accountNumber, int password){
        // Hesap no ile giriş yapma
        boolean query = databaseOperation.accountNumberAndPasswordCheck(accountNumber, password);
        if(query)
            return true;
        else
            return false;
    }
    
    public UserInfo getUserInfoWithAccountNumber(int accountNumber){
        // Hesap numarası ile kullanıcı bilgilerini veritabanından çekme
        UserInfo memberInfo = databaseOperation.getUserInfoFromDatabaseWithAccountNumber(accountNumber);
        return memberInfo;
    }
    
    public UserInfo getUserInfoWithIdNumber(int idNumber){
        // TC ile kullanıcı bilgilerini veritabanından çekme
        UserInfo memberInfo = databaseOperation.getUserInfoFromDatabaseWithIdNumber(idNumber);
        return memberInfo;
    }
    
    public UserInfo getUserInfoWithIban(int ibanNumber){
        // İban ile kullanıcı bilgilerini veritabanından çekme
        UserInfo memberInfo = databaseOperation.getUserInfoFromDatabaseWithIbanNumber(ibanNumber);
        return memberInfo;
    }
}

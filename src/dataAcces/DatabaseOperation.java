package dataAcces;

import entities.UserInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseOperation {
    
    private static String userName = "root";
    private static String userPassword = "";
    private static String host = "localhost";
    private static String databaseName = "bank";
    private static int port = 3306;
    
    private static Connection connection = null;
    private static Statement statment = null;
    private static PreparedStatement preparedStatment = null;
    
    
    public static boolean loginCheck = true;
    
    public DatabaseOperation(){
        // Veritabanı ile bağlantı kurma
        String url = "jdbc:mysql://" + host + ":" + port + "/" + databaseName + "?useUnicode=ture&chacaterEncoding=utf8";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found");
        }
        try {
            connection = DriverManager.getConnection(url, userName, userPassword);
            System.out.println("Connection Successful");
            loginCheck = true;
        } catch (SQLException ex) {
            System.out.println("Connection Failed");
        }
    }
    
    public boolean registeredIbanNumberControl(int ibanNumber) {
        // Yeni oluşturulan ibanın önceden var olup olmadığının kontrolü
        String query = "Select * From users Where ibanNumber = ?";
        try {
            preparedStatment = connection.prepareStatement(query);
            preparedStatment.setInt(1, ibanNumber);
            ResultSet resultSet = preparedStatment.executeQuery();
            return resultSet.next();    // İban sistemde kayıtlı ise geriye true değeri döndürür
        } catch (SQLException ex) {
        }
        return true;
    }
    
    public boolean registeredAccountNumberControl(int accountNumber){
        // Yeni oluşturulan hesap numarasının önceden  var olup olmadığının kontrolü
        String query = "Select * From users Where accountNumber = ?";
        try {
            preparedStatment = connection.prepareStatement(query);
            preparedStatment.setInt(1, accountNumber);
            ResultSet resultSet = preparedStatment.executeQuery();
            return resultSet.next();    // Hesap numarası sistemde kayıtlı ise geriye true değeri döndürür
        } catch (SQLException ex) {
        }
        return true;
    }
    
    public boolean registeredIdNumberCheck(int idNumber){
        // Aynı kimlik numarasının daha önce kayıtlı olup olmadığının kontrolü
        String query = "Select * From users Where idNumber = ?";
        try {
            preparedStatment = connection.prepareStatement(query);
            preparedStatment.setInt(1, idNumber);
            ResultSet resultSet = preparedStatment.executeQuery();
            return resultSet.next(); // kimlik numarası önceden sisteme kaydedilmiş ise true değer döndürür
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public boolean registeredEmailCheck(String email){
        String query = "Select * From users Where email = ?";
        try {
            preparedStatment= connection.prepareStatement(query);
            preparedStatment.setString(1, email);
            ResultSet resultSet = preparedStatment.executeQuery();
            return resultSet.next();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public boolean idNumberAndPasswordCheck(int idNumber, int password){
        // Giriş için girilen kimlik numarası var mı varsa şifre ile uyuşuyor mu kontrolü
        String query = "Select * From users Where idNumber = ? and password = ?";
        try {
            preparedStatment = connection.prepareStatement(query);
            preparedStatment.setInt(1, idNumber);
            preparedStatment.setInt(2, password);
            ResultSet resultSet = preparedStatment.executeQuery();
            return resultSet.next(); // kimlik numarası ve şifre varsa geriye ture değer döndürür
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public boolean accountNumberAndPasswordCheck(int accountNumber, int password){
        // Giriş için girilen hesap numarası var mı varsa şifre ile uyuşuyor mu kontrolü
        String query = "Select * From users Where accountNumber = ?  and password = ?";
        try {
            preparedStatment = connection.prepareStatement(query);
            preparedStatment.setInt(1, accountNumber);
            preparedStatment.setInt(2, password);
            ResultSet resultSet = preparedStatment.executeQuery();
            return resultSet.next(); // Hesap numarası ve şifre varsa geriye true değer döndürür
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public void creatNewAccount(UserInfo memberInfo) {
        // Veritabanına yeni kullanıcı kaydı yapma
        String newAccount = "Insert Into users(ibanNumber, accountNumber, idNumber, password, name, surname, tlBalance,"
                + "dolarBalance, euroBalance, email) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            preparedStatment = connection.prepareStatement(newAccount);
            preparedStatment.setInt(1, memberInfo.getIbanNumber());
            preparedStatment.setInt(2, memberInfo.getAccountNumber());
            preparedStatment.setInt(3, memberInfo.getIdNumber());
            preparedStatment.setInt(4, memberInfo.getPassword());
            preparedStatment.setString(5, memberInfo.getName());
            preparedStatment.setString(6, memberInfo.getSurname());
            preparedStatment.setDouble(7, memberInfo.getTlBalance());
            preparedStatment.setDouble(8, memberInfo.getDolarBalance());
            preparedStatment.setDouble(9, memberInfo.getEuroBalance());
            preparedStatment.setString(10, memberInfo.getEmail());
            preparedStatment.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public UserInfo getUserInfoFromDatabaseWithAccountNumber(int getAccountNumber) {
        // Hesap numarası ile veritabanından kullanıcı bilgileri çekme
        String query = "Select * From users Where accountNumber = ?";
        try {
            preparedStatment = connection.prepareStatement(query);
            preparedStatment.setInt(1, getAccountNumber);
            ResultSet resultSet = preparedStatment.executeQuery();
            if(resultSet.next()){
                int idNumber = resultSet.getInt("idNumber");
                int password = resultSet.getInt("password");
                int ibanNumber = resultSet.getInt("ibanNumber");
                int accountNumber = getAccountNumber;
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                double tlBalance = resultSet.getDouble("tlBalance");
                double dolarBalance = resultSet.getDouble("dolarBalance");
                double euroBalance = resultSet.getDouble("euroBalance");
                String email = resultSet.getString("email");
                UserInfo memberInfo = new UserInfo(idNumber, name, surname, password, tlBalance, dolarBalance, euroBalance, ibanNumber, accountNumber,email);
                return memberInfo;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public UserInfo getUserInfoFromDatabaseWithIdNumber(int getIdNumber) {
        // kimlik numarası ile veritabanından kullanıcı bilgileri çekme
        String query = "Select * From users Where idNumber = ?";
        try {
            preparedStatment = connection.prepareStatement(query);
            preparedStatment.setInt(1, getIdNumber);
            ResultSet resultSet = preparedStatment.executeQuery();
            if(resultSet.next()){
                int idNumber = getIdNumber;
                int password = resultSet.getInt("password");
                int ibanNumber = resultSet.getInt("ibanNumber");
                int accountNumber = resultSet.getInt("accountNumber");
                double tlBalance = resultSet.getDouble("tlBalance");
                double dolarBalance = resultSet.getDouble("dolarBalance");
                double euroBalance = resultSet.getDouble("euroBalance");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                UserInfo memberInfo = new UserInfo(idNumber, name, surname, password, tlBalance, dolarBalance, euroBalance, ibanNumber, accountNumber,email);
                return memberInfo;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public UserInfo getUserInfoFromDatabaseWithIbanNumber(int getIbanNumber){
        // İban ile veritabanından kullanıcı bilgileri çekme
        String query = "Select * From users Where ibanNumber = ?";
        try {
            preparedStatment = connection.prepareStatement(query);
            preparedStatment.setInt(1, getIbanNumber);
            ResultSet resultSet = preparedStatment.executeQuery();
            if(resultSet.next()){
                int idNumber = resultSet.getInt("idNumber");
                int password = resultSet.getInt("password");
                int ibanNumber = getIbanNumber;
                int accounNumber = resultSet.getInt("accountNumber");
                double tlBalance = resultSet.getDouble("tlBalance");
                double dolarBalance = resultSet.getDouble("dolarBalance");
                double euroBalance = resultSet.getDouble("euroBalance");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String email = resultSet.getString("email");
                UserInfo memberInfo = new UserInfo(idNumber, name, surname, password, tlBalance, dolarBalance, euroBalance, ibanNumber, accounNumber, email);
                return memberInfo;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean updateUserInfo(UserInfo userInfo){
        // Kullanıcı bilgilerini güncelleme
        String query = "Update users set name = ?, surname = ?, email = ?, password = ? where idNumber = ?";
        try {
            preparedStatment = connection.prepareStatement(query);
            preparedStatment.setString(1, userInfo.getName());
            preparedStatment.setString(2, userInfo.getSurname());
            preparedStatment.setString(3, userInfo.getEmail());
            preparedStatment.setInt(4, userInfo.getPassword());
            preparedStatment.setInt(5, userInfo.getIdNumber());
            preparedStatment.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean updateMoneyBalance(UserInfo memberInfo){
        // Para değerlerini güncelleme
        String query = "Update users set tlBalance = ?, dolarBalance = ?, euroBalance = ? where idNumber = ?";
        try {
            preparedStatment =  connection.prepareStatement(query);
            preparedStatment.setDouble(1, memberInfo.getTlBalance());
            preparedStatment.setDouble(2, memberInfo.getDolarBalance());
            preparedStatment.setDouble(3, memberInfo.getEuroBalance());
            preparedStatment.setInt(4, memberInfo.getIdNumber());
            preparedStatment.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

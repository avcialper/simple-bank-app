
import business.UserAction;
import dataAcces.DatabaseOperation;
import entities.MoneysInfo;
import entities.UserInfo;
import java.awt.CardLayout;
import java.awt.Event;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class bankWindow extends javax.swing.JFrame {
    
    UserAction userAction = new UserAction();
    DatabaseOperation databaseOperation = new DatabaseOperation();
    UserInfo userInfo = null;
    MoneysInfo moneysInfo = null;
    CardLayout cardLayout;
    String myCard = "loginCard";
    String moneyType = "";
    boolean timerB = false;
    public bankWindow() {
        initComponents();
        cardLayout = (CardLayout)(cards.getLayout());
        if(DatabaseOperation.loginCheck){
            showMessage("VERİTABANI İLE BAĞLANTI SAĞLANAMADI");
            System.exit(0);
        }
    }
    
    
    public void allExitButton(){
        timerB = false;
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(myCard.equals("registerCard") || myCard.equals("menuCard")){
                    cardLayout.show(cards, "loginCard");
                    timerB = true;
                }
                else if(myCard.equals("loginCard"))
                    timerB = true;
                else{
                    cardLayout.show(cards, "menuCard");
                    timerB = true;
                }
            }
        };
        Timer timer = new Timer(1500, al);
        timer.setRepeats(false);
        timer.start();
        cardLayout.show(cards, "windowCard");
        
        if(timerB)
            timer.stop();
    }
    
    public boolean registerInfoIsEmpty(){
        String informations[] = {
            registerNameText.getText(),
            registerSurnameText.getText(),
            registerIdNumberText.getText(),
            registerEmailText.getText(),
            String.valueOf(registerPasswordText.getPassword()),
            String.valueOf(registerAgainPasswordText.getPassword())
        };
        for(int i = 0; i < informations.length; i++){
            if(informations[i].equals(""))
                return true;
        }
        return false;
    }
    
    void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
    
    public boolean eMailRegex(String eMail) {
        String eMailRegex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(eMailRegex);
        if (pattern.matcher(eMail).matches()) {
            return false;
        } else {
            return true;
        }
    }
    
    public double[] dolarPrice() {
        Random random = new Random();
        double sellDolar = 0;
        double buyDolar = 0;
        while (true) {
            sellDolar = random.nextDouble() + 18;
            buyDolar = random.nextDouble() + 18;
            if ((buyDolar - 0.3) > sellDolar) {
                double[] ret = {sellDolar, buyDolar};
                return ret;
            }
        }
    }
    
    public double[] euroPrice() {
        Random random = new Random();
        double sellEuro = 0;
        double buyEuro = 0;
        while (true) {
            sellEuro = random.nextDouble() + 17;
            buyEuro = random.nextDouble() + 17;
            if ((buyEuro - 0.3) > sellEuro) {
                double ret[] = {sellEuro, buyEuro};
                return ret;
            }
        }
    }
    
    public String changeDecimalFormat(double money) {
        return new DecimalFormat("##.##").format(money);
    }
    
    public double calculateMoney(){
        return userInfo.getTlBalance() + userInfo.getDolarBalance() * moneysInfo.getSellDolar()
                    + userInfo.getEuroBalance() * moneysInfo.getSellEuro();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPageButtonGroup = new javax.swing.ButtonGroup();
        depButtonGroup1 = new javax.swing.ButtonGroup();
        depButtonGroup2 = new javax.swing.ButtonGroup();
        withdrawButonGroup = new javax.swing.ButtonGroup();
        currencyButtonGroup1 = new javax.swing.ButtonGroup();
        currencyButtonGroup2 = new javax.swing.ButtonGroup();
        cards = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        idNumberRadioButton = new javax.swing.JRadioButton();
        accountNumberRadioButton = new javax.swing.JRadioButton();
        loginTextField = new javax.swing.JTextField();
        loginPasswordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        newRegisterButton = new javax.swing.JButton();
        loginPasswordVisible = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        registerPanel = new javax.swing.JPanel();
        registerExitButton = new javax.swing.JButton();
        regsiterNameLabel = new javax.swing.JLabel();
        registerSurnameLabel = new javax.swing.JLabel();
        registerIdNumberLabel = new javax.swing.JLabel();
        registerPasswordLabel = new javax.swing.JLabel();
        registerPasswordAgainLabel = new javax.swing.JLabel();
        registerEmailLabel = new javax.swing.JLabel();
        registerIbanNumberLabel = new javax.swing.JLabel();
        registerAccountNumberLabel = new javax.swing.JLabel();
        registerNameText = new javax.swing.JTextField();
        registerIdNumberText = new javax.swing.JTextField();
        registerSurnameText = new javax.swing.JTextField();
        registerEmailText = new javax.swing.JTextField();
        registerIbanNumberText = new javax.swing.JTextField();
        registerAccountNumberText = new javax.swing.JTextField();
        registerPasswordText = new javax.swing.JPasswordField();
        registerAgainPasswordText = new javax.swing.JPasswordField();
        registerPasswordVisible = new javax.swing.JCheckBox();
        registerButton = new javax.swing.JButton();
        copyButton = new javax.swing.JButton();
        menuPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        nameSurnameLabel = new javax.swing.JLabel();
        ibanLabel = new javax.swing.JLabel();
        accounNumberLabel = new javax.swing.JLabel();
        ibanCopyButton = new javax.swing.JButton();
        accounNumberCopyButton = new javax.swing.JButton();
        balanceLabel = new javax.swing.JLabel();
        withdrawButton = new javax.swing.JButton();
        currencyTransactionsButton = new javax.swing.JButton();
        userOperationButton = new javax.swing.JButton();
        depositeButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        depositePanel = new javax.swing.JPanel();
        depositeExitButton = new javax.swing.JButton();
        myAccount = new javax.swing.JRadioButton();
        anotherAccount = new javax.swing.JRadioButton();
        depOpPanel = new javax.swing.JPanel();
        depBalanceLabel = new javax.swing.JLabel();
        depTlButton = new javax.swing.JRadioButton();
        depDolarButton = new javax.swing.JRadioButton();
        depEuroButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        depIbanLabel = new javax.swing.JLabel();
        depAmounthText = new javax.swing.JTextField();
        depIbanText = new javax.swing.JTextField();
        depApproveButton = new javax.swing.JButton();
        withdrawPanel = new javax.swing.JPanel();
        withdrawExitButton = new javax.swing.JButton();
        wtTlRadioButton = new javax.swing.JRadioButton();
        wtDolarRadioButton = new javax.swing.JRadioButton();
        wtEuroRadioButton = new javax.swing.JRadioButton();
        wtOPanel = new javax.swing.JPanel();
        wtBalanceLabel = new javax.swing.JLabel();
        wtAmounthLabel = new javax.swing.JLabel();
        wtAmounthText = new javax.swing.JTextField();
        wtApproveButton = new javax.swing.JButton();
        updatePanel = new javax.swing.JPanel();
        updateExitButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        updateNameText = new javax.swing.JTextField();
        updateSurnameText = new javax.swing.JTextField();
        updateEmailText = new javax.swing.JTextField();
        updatePasswordVisibleBox = new javax.swing.JCheckBox();
        updateExitButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        oldPasswordText = new javax.swing.JPasswordField();
        updatePasswordText = new javax.swing.JPasswordField();
        updateAgainPasswordText = new javax.swing.JPasswordField();
        currencyPanel = new javax.swing.JPanel();
        currencyExitButton = new javax.swing.JButton();
        currencyDolarRadioButton = new javax.swing.JRadioButton();
        currencyEuroRadioButton = new javax.swing.JRadioButton();
        currencyOp = new javax.swing.JPanel();
        buyRadioButton = new javax.swing.JRadioButton();
        sellRadioButton = new javax.swing.JRadioButton();
        sellBuyLabel = new javax.swing.JLabel();
        currencyLabel = new javax.swing.JLabel();
        currencyTlLabel = new javax.swing.JLabel();
        currencyTlLabel1 = new javax.swing.JLabel();
        currencyAmounthText = new javax.swing.JTextField();
        currencyApproveButton = new javax.swing.JButton();
        windowPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(300, 200, 0, 0));
        setPreferredSize(new java.awt.Dimension(650, 360));
        setResizable(false);

        cards.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cards.setPreferredSize(new java.awt.Dimension(550, 348));
        cards.setLayout(new java.awt.CardLayout());

        loginPanel.setBackground(new java.awt.Color(41, 8, 26));
        loginPanel.setMaximumSize(new java.awt.Dimension(675, 316));

        idNumberRadioButton.setBackground(new java.awt.Color(41, 8, 26));
        loginPageButtonGroup.add(idNumberRadioButton);
        idNumberRadioButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        idNumberRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        idNumberRadioButton.setText("KİMLİK NUMARSI");
        idNumberRadioButton.setBorder(null);
        idNumberRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idNumberRadioButtonActionPerformed(evt);
            }
        });

        accountNumberRadioButton.setBackground(new java.awt.Color(41, 8, 26));
        loginPageButtonGroup.add(accountNumberRadioButton);
        accountNumberRadioButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        accountNumberRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        accountNumberRadioButton.setText("HESAP NUMARASI");
        accountNumberRadioButton.setBorder(null);
        accountNumberRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountNumberRadioButtonActionPerformed(evt);
            }
        });

        loginTextField.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        loginTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginTextFieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginTextFieldMouseEntered(evt);
            }
        });

        loginPasswordField.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        loginPasswordField.setToolTipText("");
        loginPasswordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginPasswordFieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginPasswordFieldMouseEntered(evt);
            }
        });

        loginButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        loginButton.setText("GİRİŞ YAP");
        loginButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 5));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        newRegisterButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        newRegisterButton.setText("KAYIT OL");
        newRegisterButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 5));
        newRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRegisterButtonActionPerformed(evt);
            }
        });

        loginPasswordVisible.setBackground(new java.awt.Color(41, 8, 26));
        loginPasswordVisible.setForeground(new java.awt.Color(153, 0, 0));
        loginPasswordVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginPasswordVisibleActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("RASH BANK");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                    .addComponent(loginPasswordField)
                                    .addComponent(newRegisterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(4, 4, 4)
                                .addComponent(loginPasswordVisible)
                                .addGap(50, 50, 50)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(accountNumberRadioButton)
                                    .addComponent(idNumberRadioButton)))))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addComponent(idNumberRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(accountNumberRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginPasswordVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newRegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        cards.add(loginPanel, "loginCard");

        registerPanel.setBackground(new java.awt.Color(41, 8, 26));

        registerExitButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerExitButton.setText("GERİ");
        registerExitButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 142, 26), 5));
        registerExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerExitButtonActionPerformed(evt);
            }
        });

        regsiterNameLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        regsiterNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        regsiterNameLabel.setText("Ad : ");

        registerSurnameLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerSurnameLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerSurnameLabel.setText("Soyad : ");

        registerIdNumberLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerIdNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerIdNumberLabel.setText("Kimlik Numarası : ");

        registerPasswordLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerPasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerPasswordLabel.setText("Şifre : ");

        registerPasswordAgainLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerPasswordAgainLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerPasswordAgainLabel.setText("Şifre Tekrar : ");

        registerEmailLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerEmailLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerEmailLabel.setText("E-posta : ");

        registerIbanNumberLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerIbanNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerIbanNumberLabel.setText("İban : ");

        registerAccountNumberLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerAccountNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerAccountNumberLabel.setText("Hesap Numarası : ");

        registerNameText.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        registerIdNumberText.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        registerSurnameText.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        registerEmailText.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        registerIbanNumberText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        registerIbanNumberText.setEnabled(false);

        registerAccountNumberText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        registerAccountNumberText.setEnabled(false);

        registerPasswordText.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        registerAgainPasswordText.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        registerPasswordVisible.setBackground(new java.awt.Color(41, 8, 26));
        registerPasswordVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPasswordVisibleActionPerformed(evt);
            }
        });

        registerButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerButton.setText("HESAP OLUŞTUR");
        registerButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 142, 26), 4));
        registerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        registerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        copyButton.setBackground(new java.awt.Color(41, 8, 26));
        copyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/copyy.png"))); // NOI18N
        copyButton.setBorder(new javax.swing.border.MatteBorder(null));
        copyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout registerPanelLayout = new javax.swing.GroupLayout(registerPanel);
        registerPanel.setLayout(registerPanelLayout);
        registerPanelLayout.setHorizontalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(registerPanelLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(registerSurnameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(regsiterNameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(registerIdNumberLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(registerAccountNumberLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(registerIdNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registerSurnameText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registerAccountNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registerNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(registerPanelLayout.createSequentialGroup()
                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(registerPasswordLabel)
                                    .addComponent(registerPasswordAgainLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(registerPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(registerAgainPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(registerPanelLayout.createSequentialGroup()
                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(registerPanelLayout.createSequentialGroup()
                                        .addComponent(copyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(registerIbanNumberLabel))
                                    .addComponent(registerEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(registerEmailText, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                    .addComponent(registerIbanNumberText))))
                        .addGap(15, 15, 15)
                        .addComponent(registerPasswordVisible))
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(registerExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        registerPanelLayout.setVerticalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerExitButton)
                .addGap(18, 18, 18)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registerNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(regsiterNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registerSurnameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registerSurnameLabel))
                        .addGap(12, 12, 12)
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registerIdNumberLabel)
                            .addComponent(registerIdNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registerAccountNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registerAccountNumberLabel)))
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(registerPanelLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(registerPasswordAgainLabel)
                                    .addComponent(registerAgainPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(registerEmailLabel)
                                    .addComponent(registerEmailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(registerPasswordVisible)
                            .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(registerPasswordLabel)
                                .addComponent(registerPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(copyButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(registerIbanNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(registerIbanNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        cards.add(registerPanel, "registerCard");

        menuPanel.setBackground(new java.awt.Color(41, 8, 26));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 5));

        nameSurnameLabel.setBackground(new java.awt.Color(255, 255, 255));
        nameSurnameLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        nameSurnameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameSurnameLabel.setText("nameSurnameLabel");

        ibanLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        ibanLabel.setForeground(new java.awt.Color(255, 255, 255));
        ibanLabel.setText("ibanLabel");

        accounNumberLabel.setBackground(new java.awt.Color(255, 255, 255));
        accounNumberLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        accounNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        accounNumberLabel.setText("accountNumberLabel");

        ibanCopyButton.setBackground(new java.awt.Color(102, 102, 102));
        ibanCopyButton.setForeground(new java.awt.Color(102, 102, 102));
        ibanCopyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/copyy.png"))); // NOI18N
        ibanCopyButton.setBorder(null);
        ibanCopyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ibanCopyButtonActionPerformed(evt);
            }
        });

        accounNumberCopyButton.setBackground(new java.awt.Color(102, 102, 102));
        accounNumberCopyButton.setForeground(new java.awt.Color(102, 102, 102));
        accounNumberCopyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/copyy.png"))); // NOI18N
        accounNumberCopyButton.setBorder(null);
        accounNumberCopyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accounNumberCopyButtonActionPerformed(evt);
            }
        });

        balanceLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        balanceLabel.setForeground(new java.awt.Color(255, 255, 255));
        balanceLabel.setText("balanceLabel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameSurnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ibanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accounNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ibanCopyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accounNumberCopyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(balanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameSurnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ibanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ibanCopyButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(accounNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accounNumberCopyButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(balanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        withdrawButton.setBackground(new java.awt.Color(0, 51, 51));
        withdrawButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        withdrawButton.setForeground(new java.awt.Color(255, 255, 255));
        withdrawButton.setText("PARA ÇEKME");
        withdrawButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), new java.awt.Color(0, 0, 0)));
        withdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawButtonActionPerformed(evt);
            }
        });

        currencyTransactionsButton.setBackground(new java.awt.Color(0, 51, 51));
        currencyTransactionsButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        currencyTransactionsButton.setForeground(new java.awt.Color(255, 255, 255));
        currencyTransactionsButton.setText("DÖVİZ İŞLEMLERİ");
        currencyTransactionsButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), new java.awt.Color(0, 0, 0)));
        currencyTransactionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currencyTransactionsButtonActionPerformed(evt);
            }
        });

        userOperationButton.setBackground(new java.awt.Color(0, 51, 51));
        userOperationButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        userOperationButton.setForeground(new java.awt.Color(255, 255, 255));
        userOperationButton.setText("KULLANICI İŞLEMLERİ");
        userOperationButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), new java.awt.Color(0, 0, 0)));
        userOperationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userOperationButtonActionPerformed(evt);
            }
        });

        depositeButton.setBackground(new java.awt.Color(0, 51, 51));
        depositeButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        depositeButton.setForeground(new java.awt.Color(255, 255, 255));
        depositeButton.setText("PARA YATIRMA/GÖNDERME");
        depositeButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), new java.awt.Color(0, 0, 0)));
        depositeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositeButtonActionPerformed(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(0, 51, 51));
        logoutButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("ÇIKIŞ");
        logoutButton.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), new java.awt.Color(0, 0, 0)));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(userOperationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(menuPanelLayout.createSequentialGroup()
                                .addComponent(withdrawButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(depositeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(currencyTransactionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(withdrawButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyTransactionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depositeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userOperationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        cards.add(menuPanel, "menuCard");

        depositePanel.setBackground(new java.awt.Color(41, 8, 26));

        depositeExitButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        depositeExitButton.setText("GERİ");
        depositeExitButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 142, 26), 5));
        depositeExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositeExitButtonActionPerformed(evt);
            }
        });

        myAccount.setBackground(new java.awt.Color(41, 8, 26));
        depButtonGroup1.add(myAccount);
        myAccount.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        myAccount.setForeground(new java.awt.Color(255, 255, 255));
        myAccount.setText("KENDİ HESABIMA");
        myAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myAccountActionPerformed(evt);
            }
        });

        anotherAccount.setBackground(new java.awt.Color(41, 8, 26));
        depButtonGroup1.add(anotherAccount);
        anotherAccount.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        anotherAccount.setForeground(new java.awt.Color(255, 255, 255));
        anotherAccount.setText("BAŞKA HESABA");
        anotherAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anotherAccountActionPerformed(evt);
            }
        });

        depOpPanel.setBackground(new java.awt.Color(102, 102, 102));
        depOpPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 5));

        depBalanceLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        depBalanceLabel.setForeground(new java.awt.Color(255, 255, 255));
        depBalanceLabel.setText("depBalance");

        depTlButton.setBackground(new java.awt.Color(102, 102, 102));
        depButtonGroup2.add(depTlButton);
        depTlButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        depTlButton.setForeground(new java.awt.Color(255, 255, 255));
        depTlButton.setText("TL");
        depTlButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depTlButtonActionPerformed(evt);
            }
        });

        depDolarButton.setBackground(new java.awt.Color(102, 102, 102));
        depButtonGroup2.add(depDolarButton);
        depDolarButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        depDolarButton.setForeground(new java.awt.Color(255, 255, 255));
        depDolarButton.setText("DOLAR");
        depDolarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depDolarButtonActionPerformed(evt);
            }
        });

        depEuroButton.setBackground(new java.awt.Color(102, 102, 102));
        depButtonGroup2.add(depEuroButton);
        depEuroButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        depEuroButton.setForeground(new java.awt.Color(255, 255, 255));
        depEuroButton.setText("EURO");
        depEuroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depEuroButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TUTAR :");

        depIbanLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        depIbanLabel.setForeground(new java.awt.Color(255, 255, 255));
        depIbanLabel.setText("İBAN :");

        depAmounthText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        depIbanText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        depApproveButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        depApproveButton.setText("ONAYLA");
        depApproveButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 142, 26), 5));
        depApproveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depApproveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout depOpPanelLayout = new javax.swing.GroupLayout(depOpPanel);
        depOpPanel.setLayout(depOpPanelLayout);
        depOpPanelLayout.setHorizontalGroup(
            depOpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, depOpPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(depOpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(depBalanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depApproveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(depOpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, depOpPanelLayout.createSequentialGroup()
                        .addComponent(depIbanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(depIbanText, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, depOpPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(depAmounthText, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
            .addGroup(depOpPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(depTlButton)
                .addGap(18, 18, 18)
                .addComponent(depDolarButton)
                .addGap(18, 18, 18)
                .addComponent(depEuroButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        depOpPanelLayout.setVerticalGroup(
            depOpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(depOpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(depOpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depTlButton)
                    .addComponent(depDolarButton)
                    .addComponent(depEuroButton))
                .addGap(18, 18, 18)
                .addGroup(depOpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depAmounthText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depBalanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(depOpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depIbanText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depIbanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depApproveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout depositePanelLayout = new javax.swing.GroupLayout(depositePanel);
        depositePanel.setLayout(depositePanelLayout);
        depositePanelLayout.setHorizontalGroup(
            depositePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(depositePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(depositePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(depositePanelLayout.createSequentialGroup()
                        .addComponent(depOpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(72, 72, 72))
                    .addGroup(depositePanelLayout.createSequentialGroup()
                        .addGroup(depositePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(depositePanelLayout.createSequentialGroup()
                                .addComponent(myAccount)
                                .addGap(18, 18, 18)
                                .addComponent(anotherAccount))
                            .addComponent(depositeExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        depositePanelLayout.setVerticalGroup(
            depositePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(depositePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(depositeExitButton)
                .addGap(18, 18, 18)
                .addGroup(depositePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myAccount)
                    .addComponent(anotherAccount))
                .addGap(18, 18, 18)
                .addComponent(depOpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        cards.add(depositePanel, "depositeCard");

        withdrawPanel.setBackground(new java.awt.Color(41, 8, 26));

        withdrawExitButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        withdrawExitButton.setText("GERİ");
        withdrawExitButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 142, 26), 5));
        withdrawExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawExitButtonActionPerformed(evt);
            }
        });

        wtTlRadioButton.setBackground(new java.awt.Color(41, 8, 26));
        withdrawButonGroup.add(wtTlRadioButton);
        wtTlRadioButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        wtTlRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        wtTlRadioButton.setText("TL");
        wtTlRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wtTlRadioButtonActionPerformed(evt);
            }
        });

        wtDolarRadioButton.setBackground(new java.awt.Color(41, 8, 26));
        withdrawButonGroup.add(wtDolarRadioButton);
        wtDolarRadioButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        wtDolarRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        wtDolarRadioButton.setText("DOLAR");
        wtDolarRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wtDolarRadioButtonActionPerformed(evt);
            }
        });

        wtEuroRadioButton.setBackground(new java.awt.Color(41, 8, 26));
        withdrawButonGroup.add(wtEuroRadioButton);
        wtEuroRadioButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        wtEuroRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        wtEuroRadioButton.setText("EURO");
        wtEuroRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wtEuroRadioButtonActionPerformed(evt);
            }
        });

        wtOPanel.setBackground(new java.awt.Color(102, 102, 102));
        wtOPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        wtBalanceLabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        wtBalanceLabel.setForeground(new java.awt.Color(255, 255, 255));
        wtBalanceLabel.setText("withdrawBalance");

        wtAmounthLabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        wtAmounthLabel.setForeground(new java.awt.Color(255, 255, 255));
        wtAmounthLabel.setText("TUTAR :");

        wtAmounthText.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N

        wtApproveButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        wtApproveButton.setText("ONAYLA");
        wtApproveButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 142, 26), 5));
        wtApproveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wtApproveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wtOPanelLayout = new javax.swing.GroupLayout(wtOPanel);
        wtOPanel.setLayout(wtOPanelLayout);
        wtOPanelLayout.setHorizontalGroup(
            wtOPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wtOPanelLayout.createSequentialGroup()
                .addGroup(wtOPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wtOPanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(wtAmounthLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wtAmounthText, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(wtOPanelLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(wtApproveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(wtOPanelLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(wtBalanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        wtOPanelLayout.setVerticalGroup(
            wtOPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wtOPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(wtBalanceLabel)
                .addGap(18, 18, 18)
                .addGroup(wtOPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wtAmounthLabel)
                    .addComponent(wtAmounthText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(wtApproveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout withdrawPanelLayout = new javax.swing.GroupLayout(withdrawPanel);
        withdrawPanel.setLayout(withdrawPanelLayout);
        withdrawPanelLayout.setHorizontalGroup(
            withdrawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(withdrawPanelLayout.createSequentialGroup()
                .addGroup(withdrawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(withdrawPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(withdrawExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(withdrawPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(withdrawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wtDolarRadioButton)
                            .addComponent(wtTlRadioButton)
                            .addComponent(wtEuroRadioButton))
                        .addGap(63, 63, 63)
                        .addComponent(wtOPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        withdrawPanelLayout.setVerticalGroup(
            withdrawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(withdrawPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(withdrawExitButton)
                .addGap(32, 32, 32)
                .addGroup(withdrawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(withdrawPanelLayout.createSequentialGroup()
                        .addComponent(wtTlRadioButton)
                        .addGap(42, 42, 42)
                        .addComponent(wtDolarRadioButton)
                        .addGap(43, 43, 43)
                        .addComponent(wtEuroRadioButton))
                    .addComponent(wtOPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        cards.add(withdrawPanel, "withdrawCard");

        updatePanel.setBackground(new java.awt.Color(41, 8, 26));

        updateExitButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        updateExitButton.setText("GERİ");
        updateExitButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 142, 26), 5));
        updateExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateExitButtonActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("AD :");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SOYAD :");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("E-POSTA :");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("YENİ ŞİFRE :");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ŞİFRE TEKRAR :");

        updateNameText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        updateSurnameText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        updateEmailText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        updatePasswordVisibleBox.setBackground(new java.awt.Color(41, 8, 26));
        updatePasswordVisibleBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePasswordVisibleBoxActionPerformed(evt);
            }
        });

        updateExitButton1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        updateExitButton1.setText("KAYDET");
        updateExitButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 142, 26), 5));
        updateExitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateExitButton1ActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ESKİ ŞİFRE :");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/thunder.png"))); // NOI18N

        oldPasswordText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        updatePasswordText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        updateAgainPasswordText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        javax.swing.GroupLayout updatePanelLayout = new javax.swing.GroupLayout(updatePanel);
        updatePanel.setLayout(updatePanelLayout);
        updatePanelLayout.setHorizontalGroup(
            updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updatePanelLayout.createSequentialGroup()
                        .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updatePasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateAgainPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(updatePanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(updatePanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(oldPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addGroup(updatePanelLayout.createSequentialGroup()
                                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(updateNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updateSurnameText, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updateEmailText, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(updatePasswordVisibleBox)))
                .addGap(27, 27, 27)
                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateExitButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updatePanelLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        updatePanelLayout.setVerticalGroup(
            updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatePanelLayout.createSequentialGroup()
                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updatePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(updateExitButton))
                    .addGroup(updatePanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(updatePanelLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(updateExitButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(updatePanelLayout.createSequentialGroup()
                                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(updateNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(updateSurnameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(updateEmailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(updatePasswordVisibleBox, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(oldPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updatePasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updateAgainPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        cards.add(updatePanel, "updateCard");

        currencyPanel.setBackground(new java.awt.Color(41, 8, 26));

        currencyExitButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        currencyExitButton.setText("GERİ");
        currencyExitButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 142, 26), 5));
        currencyExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currencyExitButtonActionPerformed(evt);
            }
        });

        currencyDolarRadioButton.setBackground(new java.awt.Color(41, 8, 26));
        currencyButtonGroup1.add(currencyDolarRadioButton);
        currencyDolarRadioButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        currencyDolarRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        currencyDolarRadioButton.setText("DOLAR");
        currencyDolarRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currencyDolarRadioButtonActionPerformed(evt);
            }
        });

        currencyEuroRadioButton.setBackground(new java.awt.Color(41, 8, 26));
        currencyButtonGroup1.add(currencyEuroRadioButton);
        currencyEuroRadioButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        currencyEuroRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        currencyEuroRadioButton.setText("EURO");
        currencyEuroRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currencyEuroRadioButtonActionPerformed(evt);
            }
        });

        currencyOp.setBackground(new java.awt.Color(102, 102, 102));
        currencyOp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 5));

        buyRadioButton.setBackground(new java.awt.Color(102, 102, 102));
        currencyButtonGroup2.add(buyRadioButton);
        buyRadioButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        buyRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        buyRadioButton.setText("AL");

        sellRadioButton.setBackground(new java.awt.Color(102, 102, 102));
        currencyButtonGroup2.add(sellRadioButton);
        sellRadioButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        sellRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        sellRadioButton.setText("SAT");

        sellBuyLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        sellBuyLabel.setForeground(new java.awt.Color(255, 255, 255));
        sellBuyLabel.setText("jLabel2");
        sellBuyLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        currencyLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        currencyLabel.setForeground(new java.awt.Color(255, 255, 255));
        currencyLabel.setText("currencyLabel");
        currencyLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        currencyTlLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        currencyTlLabel.setForeground(new java.awt.Color(255, 255, 255));
        currencyTlLabel.setText("currencyTlLabel");
        currencyTlLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        currencyTlLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        currencyTlLabel1.setForeground(new java.awt.Color(255, 255, 255));
        currencyTlLabel1.setText("TUTAR : ");

        currencyAmounthText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        currencyAmounthText.setText("0");

        currencyApproveButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        currencyApproveButton.setText("ONAYLA");
        currencyApproveButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 142, 26), 5));
        currencyApproveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currencyApproveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout currencyOpLayout = new javax.swing.GroupLayout(currencyOp);
        currencyOp.setLayout(currencyOpLayout);
        currencyOpLayout.setHorizontalGroup(
            currencyOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currencyOpLayout.createSequentialGroup()
                .addGroup(currencyOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(currencyOpLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(currencyOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(currencyOpLayout.createSequentialGroup()
                                .addComponent(buyRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(sellRadioButton)
                                .addGap(32, 32, 32)
                                .addComponent(sellBuyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(currencyOpLayout.createSequentialGroup()
                                .addGroup(currencyOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(currencyOpLayout.createSequentialGroup()
                                        .addComponent(currencyTlLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(currencyAmounthText, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(currencyOpLayout.createSequentialGroup()
                                        .addComponent(currencyTlLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(currencyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(47, 47, 47))))
                    .addGroup(currencyOpLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(currencyApproveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        currencyOpLayout.setVerticalGroup(
            currencyOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currencyOpLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(currencyOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buyRadioButton)
                    .addComponent(sellRadioButton)
                    .addComponent(sellBuyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(currencyOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currencyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyTlLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(currencyOpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currencyTlLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyAmounthText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(currencyApproveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout currencyPanelLayout = new javax.swing.GroupLayout(currencyPanel);
        currencyPanel.setLayout(currencyPanelLayout);
        currencyPanelLayout.setHorizontalGroup(
            currencyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currencyPanelLayout.createSequentialGroup()
                .addGroup(currencyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(currencyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(currencyExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(currencyPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(currencyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currencyEuroRadioButton)
                            .addComponent(currencyDolarRadioButton))
                        .addGap(18, 18, 18)
                        .addComponent(currencyOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        currencyPanelLayout.setVerticalGroup(
            currencyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currencyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currencyExitButton)
                .addGroup(currencyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(currencyPanelLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(currencyDolarRadioButton)
                        .addGap(32, 32, 32)
                        .addComponent(currencyEuroRadioButton))
                    .addGroup(currencyPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(currencyOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        cards.add(currencyPanel, "currencyCard");

        windowPanel.setBackground(new java.awt.Color(41, 8, 26));

        jLabel10.setFont(new java.awt.Font("Copperplate Gothic Bold", 3, 70)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("RA");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/thunderW.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Copperplate Gothic Bold", 3, 70)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("H");

        javax.swing.GroupLayout windowPanelLayout = new javax.swing.GroupLayout(windowPanel);
        windowPanel.setLayout(windowPanelLayout);
        windowPanelLayout.setHorizontalGroup(
            windowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(windowPanelLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );
        windowPanelLayout.setVerticalGroup(
            windowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, windowPanelLayout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(windowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(windowPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82))
        );

        cards.add(windowPanel, "windowCard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accountNumberRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountNumberRadioButtonActionPerformed
        if(accountNumberRadioButton.isSelected())
            loginTextField.setText("HESAP NUMARASI");
        else
            loginTextField.setText("");
        loginPasswordField.setText("ŞİFRE");
        loginPasswordField.setEchoChar((char)0);
    }//GEN-LAST:event_accountNumberRadioButtonActionPerformed

    private void idNumberRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idNumberRadioButtonActionPerformed
        if(idNumberRadioButton.isSelected())
            loginTextField.setText("KİMLİK NUMARASI");
        else
            loginTextField.setText("");
        loginPasswordField.setText("ŞİFRE");
        loginPasswordField.setEchoChar((char)0);
    }//GEN-LAST:event_idNumberRadioButtonActionPerformed

    private void loginTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginTextFieldMouseClicked
        if(loginTextField.getText().equals("HESAP NUMARASI") || loginTextField.getText().equals("KİMLİK NUMARASI"))
            loginTextField.setText("");
        if((idNumberRadioButton.isSelected() || accountNumberRadioButton.isSelected()) 
                && String.valueOf(loginPasswordField.getPassword()).equals("")) {
            loginPasswordField.setText("ŞİFRE");
            loginPasswordField.setEchoChar((char)0);
        }
    }//GEN-LAST:event_loginTextFieldMouseClicked

    private void loginPasswordFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginPasswordFieldMouseClicked
        if(String.valueOf(loginPasswordField.getPassword()).equals("ŞİFRE")){
            loginPasswordField.setText("");
            if(loginPasswordVisible.isSelected())
                loginPasswordField.setEchoChar((char)0);
            else
                loginPasswordField.setEchoChar('•');
        }
        if (idNumberRadioButton.isSelected() && loginTextField.getText().equals(""))
            loginTextField.setText("KİMLİK NUMARASI");
        else if (accountNumberRadioButton.isSelected() && loginTextField.getText().equals(""))
            loginTextField.setText("HESAP NUMARASI");
    }//GEN-LAST:event_loginPasswordFieldMouseClicked

    private void loginPasswordVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginPasswordVisibleActionPerformed
        if(loginPasswordVisible.isSelected())
            loginPasswordField.setEchoChar((char)0);
        else {
            if(String.valueOf(loginPasswordField.getPassword()).equals("ŞİFRE"))
                loginPasswordField.setEchoChar((char)0);
            else
                loginPasswordField.setEchoChar('•');
        }
    }//GEN-LAST:event_loginPasswordVisibleActionPerformed

    private void loginTextFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginTextFieldMouseEntered
        if(idNumberRadioButton.isSelected())
            loginTextField.setToolTipText("Kimlik numarası 8 haneli olmak zorundadır.");
        else if (accountNumberRadioButton.isSelected())
            loginTextField.setToolTipText("Hesap numarası 6 haneli olmak zorundadır.");
    }//GEN-LAST:event_loginTextFieldMouseEntered

    private void loginPasswordFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginPasswordFieldMouseEntered
        loginPasswordField.setToolTipText("Şifre 6 haneli olmak zorundadır.");
    }//GEN-LAST:event_loginPasswordFieldMouseEntered

    private void newRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRegisterButtonActionPerformed
        registerNameText.setText("");
        registerSurnameText.setText("");
        registerIdNumberText.setText("");
        registerEmailText.setText("");
        registerPasswordText.setText("");
        registerAgainPasswordText.setText("");
        registerIbanNumberText.setText("");
        registerAccountNumberText.setText("");
        registerAccountNumberLabel.setVisible(false);
        registerAccountNumberText.setVisible(false);
        registerIbanNumberLabel.setVisible(false);
        registerIbanNumberText.setVisible(false);
        copyButton.setVisible(false);
        registerButton.setText("HESAP OLUŞTUR");
        myCard = "registerCard";
        cardLayout.show(cards, myCard);
    }//GEN-LAST:event_newRegisterButtonActionPerformed

    private void registerExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerExitButtonActionPerformed
       allExitButton();
    }//GEN-LAST:event_registerExitButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        registerIdNumberText.setToolTipText("Kimlik numarası 8 haneli olmak zorundadır.");
        registerPasswordText.setToolTipText("Şifre 6 haneli olmalıdır.");
        if(registerButton.getText().equals("HESAP OLUŞTUR")) {
            if(registerInfoIsEmpty())
                showMessage("ALANLAR BOŞ BIRAKILAMAZ.");
            else if (registerIdNumberText.getText().length() != 8)
                showMessage("KİMLİK NUMARASI 8 KARAKTERLİ OLMAK ZORUNDADIR.");
            else if (databaseOperation.registeredIdNumberCheck(Integer.valueOf(registerIdNumberText.getText())))
                showMessage("KİMLİK NUMARASI SİSTEME KAYITLI.");
            else if(String.valueOf(registerPasswordText.getPassword()).length() != 6)
                showMessage("ŞİFRE 6 KARAKTERLİ OLMAK ZORUNDADIR");
            else if(String.valueOf(registerPasswordText.getPassword()).equals("000000"))
                showMessage("ŞİFRE 000000 OLAMAZ");
            else if (!String.valueOf(registerPasswordText.getPassword()).equals(String.valueOf(registerAgainPasswordText.getPassword())))
                showMessage("ŞİFRE İLE ŞİFRE TEKRARI UYUŞMAMAKTADIR.");
            else if (eMailRegex(registerEmailText.getText()))
                showMessage("E-MAİL KURALLARA UYGUN DEĞİLDİR.");
            else if(databaseOperation.registeredEmailCheck(registerEmailText.getText()))
                showMessage("SİSTEME KAYITLI E-MAİL");
            else {
                registerIbanNumberText.setText(String.valueOf(userAction.creatIbanNumber()));
                registerAccountNumberText.setText(String.valueOf(userAction.creatAccountNumber()));
                registerAccountNumberLabel.setVisible(true);
                registerAccountNumberText.setVisible(true);
                registerIbanNumberLabel.setVisible(true);
                registerIbanNumberText.setVisible(true);
                copyButton.setVisible(true);
                registerButton.setText("ONAYLA VE KAYDET");
            }
        } else if ((registerButton.getText().equals("ONAYLA VE KAYDET"))) {
            if(registerInfoIsEmpty())
                showMessage("ALANLAR BOŞ BIRAKILAMAZ.");
            else if (registerIdNumberText.getText().length() != 8)
                showMessage("KİMLİK NUMARASI 8 KARAKTERLİ OLMAK ZORUNDADIR.");
            else if (databaseOperation.registeredIdNumberCheck(Integer.valueOf(registerIdNumberText.getText())))
                showMessage("KİMLİK NUMARASI SİSTEME KAYITLI.");
            else if(String.valueOf(registerPasswordText.getPassword()).length() != 6)
                showMessage("ŞİFRE 6 KARAKTERLİ OLMAK ZORUNDADIR");
            else if (!String.valueOf(registerPasswordText.getPassword()).equals(String.valueOf(registerAgainPasswordText.getPassword())))
                showMessage("ŞİFRE İLE ŞİFRE TEKRARI UYUŞMAMAKTADIR.");
            else if (eMailRegex(registerEmailText.getText()))
                showMessage("E-MAİL KURALLARA UYGUN DEĞİLDİR.");
            else {
                int idNumber = Integer.valueOf(registerIdNumberText.getText());
                int ibanNumber = Integer.valueOf(registerIbanNumberText.getText());
                int accountNumber = Integer.valueOf(registerAccountNumberText.getText());
                int password = Integer.valueOf(String.valueOf(registerPasswordText.getPassword()));
                String name = registerNameText.getText();
                String surname = registerSurnameText.getText();
                String eMail = registerEmailText.getText();
                userInfo = new UserInfo(idNumber, name, surname, password, 0, 0, 0, ibanNumber, accountNumber, eMail);
                databaseOperation.creatNewAccount(userInfo);
                loginPageButtonGroup.clearSelection();
                loginTextField.setText((""));
                loginPasswordField.setText("");
                loginPasswordVisible.setSelected(false);
                loginPasswordField.setEchoChar('•');
                showMessage("KAYIT TAMAMLANDI");
                cardLayout.show(cards, "loginCard");
            }
        } 
        
    }//GEN-LAST:event_registerButtonActionPerformed

    private void registerPasswordVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPasswordVisibleActionPerformed
        if(registerPasswordVisible.isSelected()){
            registerPasswordText.setEchoChar((char)0);
            registerAgainPasswordText.setEchoChar((char)0);
        } else {
            registerPasswordText.setEchoChar('•');
            registerAgainPasswordText.setEchoChar('•');
        }
    }//GEN-LAST:event_registerPasswordVisibleActionPerformed

    private void copyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyButtonActionPerformed
        StringSelection stringSelection = new StringSelection("Hesap Numarası : " + registerAccountNumberText.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }//GEN-LAST:event_copyButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        boolean checkLogin = false;
        if(loginTextField.getText().equals("") || String.valueOf(loginPasswordField.getPassword()).equals("") ||
                loginTextField.getText().equals("KİMLİK NUMARASI") || loginTextField.getText().equals("HESAP NUMARASI"))
            showMessage("ALANLAR BOŞ BIRAKILAMAZ");
        else if(!idNumberRadioButton.isSelected() && !accountNumberRadioButton.isSelected())
            showMessage("LÜTFEN BİR GİRİŞ TÜRÜ SEÇİNİZ");
        else if (String.valueOf(loginPasswordField.getPassword()).length() != 6)
                showMessage("ŞİFRE 6 KARAKTERLİ OLMAK ZORUNDADIR");
        else{
            checkLogin = userAction.userLoginWithIdNumber(Integer.valueOf(loginTextField.getText()),
                    Integer.valueOf(String.valueOf(loginPasswordField.getPassword())));
            if(!checkLogin)
                checkLogin = userAction.userLoginWithAccountNumber(Integer.valueOf(loginTextField.getText()),
                    Integer.valueOf(String.valueOf(loginPasswordField.getPassword())));
            if(!checkLogin)
                showMessage("GİRİŞ BİLGİLERİ HATALI");
        }
        if(checkLogin){
            if(idNumberRadioButton.isSelected())
                userInfo = userAction.getUserInfoWithIdNumber(Integer.valueOf(loginTextField.getText()));
            else
                userInfo = userAction.getUserInfoWithAccountNumber(Integer.valueOf(loginTextField.getText()));
            
            double[] dolar = dolarPrice();
            double[] euro = euroPrice();
            moneysInfo = new MoneysInfo(dolar[1], dolar[0], euro[1], euro[0]);
            balanceLabel.setText("BAKİYE : " + changeDecimalFormat(calculateMoney()) + "₺");
            nameSurnameLabel.setText(userInfo.getName() + " " + userInfo.getSurname());
            ibanLabel.setText("İban : " + userInfo.getIbanNumber());
            accounNumberLabel.setText("Hesap Numarası : " + userInfo.getAccountNumber());
            loginPageButtonGroup.clearSelection();
            loginPasswordVisible.setSelected(false);
            loginPasswordField.setText("");
            loginPasswordField.setEchoChar('•');
            loginTextField.setText("");
            myCard = "menuCard";
            cardLayout.show(cards, myCard);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void ibanCopyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ibanCopyButtonActionPerformed
        StringSelection stringSelection = new StringSelection("İban : " + String.valueOf(userInfo.getIbanNumber()));
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }//GEN-LAST:event_ibanCopyButtonActionPerformed

    private void accounNumberCopyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accounNumberCopyButtonActionPerformed
        StringSelection stringSelection = new StringSelection("Hesap Numarası : " + String.valueOf(userInfo.getAccountNumber()));
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }//GEN-LAST:event_accounNumberCopyButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        allExitButton();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void depositeExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositeExitButtonActionPerformed
        myCard = "menuCard";
        allExitButton();
    }//GEN-LAST:event_depositeExitButtonActionPerformed

    private void myAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myAccountActionPerformed
        depIbanLabel.setVisible(false);
        depIbanText.setVisible(false);
        depOpPanel.setVisible(true);
    }//GEN-LAST:event_myAccountActionPerformed

    private void anotherAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anotherAccountActionPerformed
        depIbanLabel.setVisible(true);
        depIbanText.setVisible(true);
        depOpPanel.setVisible(true);
    }//GEN-LAST:event_anotherAccountActionPerformed

    private void depositeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositeButtonActionPerformed
        depButtonGroup1.clearSelection();
        depButtonGroup2.clearSelection();
        depBalanceLabel.setVisible(false);
        depIbanLabel.setVisible(false);
        depIbanText.setVisible(false);
        depIbanText.setText("");
        depAmounthText.setText("");
        depOpPanel.setVisible(false);
        moneyType = "";
        myCard = "depositeCard";
        cardLayout.show(cards, myCard);
    }//GEN-LAST:event_depositeButtonActionPerformed

    private void depTlButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depTlButtonActionPerformed
        moneyType = "TL";
        depBalanceLabel.setText("BAKİYE : " + changeDecimalFormat(userInfo.getTlBalance()) + "₺");
        depBalanceLabel.setVisible(true);
    }//GEN-LAST:event_depTlButtonActionPerformed

    private void depDolarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depDolarButtonActionPerformed
        moneyType = "DOLAR";
        depBalanceLabel.setText("BAKİYE : " + changeDecimalFormat(userInfo.getDolarBalance()) + "$");
        depBalanceLabel.setVisible(true);
    }//GEN-LAST:event_depDolarButtonActionPerformed

    private void depEuroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depEuroButtonActionPerformed
        moneyType = "EURO";
        depBalanceLabel.setText("BAKİYE : " + changeDecimalFormat(userInfo.getEuroBalance()) + "€");
        depBalanceLabel.setVisible(true);
    }//GEN-LAST:event_depEuroButtonActionPerformed

    private void depApproveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depApproveButtonActionPerformed
        if(myAccount.isSelected()){
            if(moneyType.equals("")){
                showMessage("PARA BİRİMİ SEÇİNİZ");
                return;
            }
            else if(depAmounthText.getText().equals("")){
                showMessage("TUTAR GİRİNİZ");
                return;
            }
            else if(Integer.valueOf(depAmounthText.getText()) < 0) {
                showMessage("TUTAR NEGATİF OLAMAZ");
                return;
            }
            else if(Integer.valueOf(depAmounthText.getText()) == 0) {
                showMessage("TUTAR 0 OLAMAZ");
                return;
            }
            double addedMoney = Double.valueOf(depAmounthText.getText());
            if(moneyType.equals("TL"))
                userInfo.setTlBalance(addedMoney + userInfo.getTlBalance());
            else if(moneyType.equals("DOLAR"))
                userInfo.setDolarBalance(addedMoney + userInfo.getDolarBalance());
            else if(moneyType.equals("EURO"))
                userInfo.setEuroBalance(addedMoney + userInfo.getEuroBalance());
            if(databaseOperation.updateMoneyBalance(userInfo)){
                moneyType = "";
                showMessage("İŞLEM ONAYLANDI");
                balanceLabel.setText(changeDecimalFormat(calculateMoney()));
                myCard = "menuCard";
                cardLayout.show(cards, myCard);
            }
        } else if(anotherAccount.isSelected()) {
            if(moneyType.equals("")){
                showMessage("PARA BİRİMİ SEÇİNİZ");
                return;
            }
            else if(depAmounthText.getText().equals("") || depIbanText.getText().equals("")){
                showMessage("ALANLARI DOLDURUNUZ");
                return;
            }
            else if(Integer.valueOf(depAmounthText.getText()) < 0) {
                showMessage("TUTAR NEGATİF DEĞER ALAMAZ");
                return;
            }
            else if(Integer.valueOf(depAmounthText.getText()) == 0) {
                showMessage("TUTAR 0 OLAMAZ");
                return;
            }
            double sentMoney = Double.valueOf(depAmounthText.getText());
            int recipientAccountIban = Integer.valueOf(depIbanText.getText());
            if(databaseOperation.registeredIbanNumberControl(Integer.valueOf(depIbanText.getText()))) {
                UserInfo recipient = databaseOperation.getUserInfoFromDatabaseWithIbanNumber(Integer.valueOf(depIbanText.getText()));
                if(moneyType.equals("TL")){
                    if(userInfo.getTlBalance() < sentMoney) {
                        showMessage("YETERSİZ BAKİYE");
                        return;
                    }
                    else {
                        userInfo.setTlBalance(userInfo.getTlBalance() - sentMoney);
                        recipient.setTlBalance(recipient.getTlBalance() + sentMoney);
                    }
                } else if(moneyType.equals("DOLAR")){
                    if(userInfo.getDolarBalance() < sentMoney){
                        showMessage("YETERSİZ BAKİYE");
                        return;
                    }
                    else {
                        userInfo.setDolarBalance(userInfo.getDolarBalance() - sentMoney);
                        recipient.setDolarBalance(recipient.getDolarBalance() + sentMoney);
                    }
                } else if(moneyType.equals("EURO")){
                    if(userInfo.getEuroBalance() < sentMoney){
                        showMessage("YETERSİZ BAKİYE");
                        return;
                    }
                    else {
                        userInfo.setEuroBalance(userInfo.getEuroBalance() - sentMoney);
                        recipient.setEuroBalance(recipient.getEuroBalance() + sentMoney);
                    }
                } else {
                    showMessage("PARA BİRİMİ SEÇİNİZ");
                    return;
                }
                if(databaseOperation.updateMoneyBalance(userInfo) && databaseOperation.updateMoneyBalance(recipient)){
                    moneyType = "";
                    myCard = "menuCard";
                    balanceLabel.setText(changeDecimalFormat(calculateMoney()));
                    showMessage("İŞLEM ONAYLANDI");
                    cardLayout.show(cards, myCard);
                } else 
                    showMessage("İŞLEM BAŞARISIZ");
            }
            else
                showMessage("KULLANICI BULUNAMADI");
        }
    }//GEN-LAST:event_depApproveButtonActionPerformed

    private void withdrawExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawExitButtonActionPerformed
        allExitButton();
    }//GEN-LAST:event_withdrawExitButtonActionPerformed

    private void withdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawButtonActionPerformed
        moneyType = "";
        myCard = "withdrawCard";
        wtBalanceLabel.setText("BAKİYE : ");
        wtAmounthText.setText("");
        withdrawButonGroup.clearSelection();
        cardLayout.show(cards, myCard);
    }//GEN-LAST:event_withdrawButtonActionPerformed

    private void wtApproveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wtApproveButtonActionPerformed
        if(moneyType.equals("")){
            showMessage("PARA BİRİMİ SEÇİNİZ");
            return;
        }
        else if(wtAmounthText.getText().equals("")){
            showMessage("TUTAR GİRİNİZ");
            return;
        }
        else if(Integer.valueOf(wtAmounthText.getText()) <= 0){
            showMessage("GEÇERLİ TUTAR GİRİNİZ");
            return;
        }
        double wtMoney = Double.valueOf(wtAmounthText.getText());
        if(moneyType.equals("TL")){
            if(wtMoney > userInfo.getTlBalance()){
                showMessage("YETERSİZ BAKİYE");
                return;
            }
            userInfo.setTlBalance(userInfo.getTlBalance() - wtMoney);
        } else if (moneyType.equals("DOLAR")){
            if(wtMoney > userInfo.getDolarBalance()){
                showMessage("YETERSİZ BAKİYE");
                return;
            }
            userInfo.setDolarBalance(userInfo.getDolarBalance() - wtMoney);
        } else {
            if(wtMoney > userInfo.getEuroBalance()){
                showMessage("YETERSİZ BAKİYE");
                return;
            }
            userInfo.setEuroBalance(userInfo.getEuroBalance() - wtMoney);
        }
        if(databaseOperation.updateMoneyBalance(userInfo)) {
            moneyType = "";
            myCard = "menuCard";
            showMessage("İŞLEM ONAYLANDI");
            balanceLabel.setText(changeDecimalFormat(calculateMoney()));
            cardLayout.show(cards, myCard);
        } else
            showMessage("İŞLEM BAŞARISIZ");
    }//GEN-LAST:event_wtApproveButtonActionPerformed

    private void wtTlRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wtTlRadioButtonActionPerformed
        moneyType = "TL";
        wtBalanceLabel.setText("BAKİYE : " + userInfo.getTlBalance() + "₺");
    }//GEN-LAST:event_wtTlRadioButtonActionPerformed

    private void wtDolarRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wtDolarRadioButtonActionPerformed
        moneyType = "DOLAR";
        wtBalanceLabel.setText("BAKİYE : " + userInfo.getDolarBalance() + "$");
    }//GEN-LAST:event_wtDolarRadioButtonActionPerformed

    private void wtEuroRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wtEuroRadioButtonActionPerformed
        moneyType = "EURO";
        wtBalanceLabel.setText("BAKİYE : " + userInfo.getEuroBalance() + "€");
    }//GEN-LAST:event_wtEuroRadioButtonActionPerformed

    private void currencyTransactionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currencyTransactionsButtonActionPerformed
        currencyButtonGroup1.clearSelection();
        currencyButtonGroup2.clearSelection();
        sellBuyLabel.setText("");
        currencyAmounthText.setText("");
        currencyLabel.setText("");
        currencyTlLabel.setText(changeDecimalFormat(userInfo.getTlBalance()) + "₺");
        currencyOp.setVisible(false);
        moneyType = "";
        myCard = "currencyCard";
        cardLayout.show(cards, myCard);
    }//GEN-LAST:event_currencyTransactionsButtonActionPerformed

    private void currencyExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currencyExitButtonActionPerformed
        allExitButton();
        currencyLabel.setText(myCard);
    }//GEN-LAST:event_currencyExitButtonActionPerformed

    private void currencyDolarRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currencyDolarRadioButtonActionPerformed
        moneyType = "DOLAR";
        currencyLabel.setText(changeDecimalFormat(userInfo.getDolarBalance()) + "$");
        sellBuyLabel.setText("AL : " + changeDecimalFormat(moneysInfo.getBuyDolar()) + "   SAT : " + changeDecimalFormat(moneysInfo.getSellDolar()));
        currencyOp.setVisible(true);
    }//GEN-LAST:event_currencyDolarRadioButtonActionPerformed

    private void currencyEuroRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currencyEuroRadioButtonActionPerformed
        moneyType = "EURO";
        currencyLabel.setText(changeDecimalFormat(userInfo.getEuroBalance()) + "€");
        sellBuyLabel.setText("AL : " + changeDecimalFormat(moneysInfo.getBuyEuro()) + "   SAT : " + changeDecimalFormat(moneysInfo.getSellEuro()));
        currencyOp.setVisible(true);
    }//GEN-LAST:event_currencyEuroRadioButtonActionPerformed

    private void currencyApproveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currencyApproveButtonActionPerformed
        if(currencyDolarRadioButton.isSelected()){
            if(!buyRadioButton.isSelected() && !sellRadioButton.isSelected()){
                showMessage("AL/SAT İŞLEMLERİNDEN HERHANGİ BİRİNİ SEÇİNİZ");
                return;
            } else if(currencyAmounthText.getText().equals("")){
                showMessage("TUTAR GİRİNİZ");
                return;
            } else if(Integer.valueOf(currencyAmounthText.getText()) <= 0) {
                showMessage("GEÇERLİ TUTAR GİRİNİZ");
                return;
            }
            double currencyAmounth = Double.valueOf(currencyAmounthText.getText());
            if(buyRadioButton.isSelected()){
                if(currencyAmounth * moneysInfo.getBuyDolar() > userInfo.getTlBalance()){
                    showMessage("YETERSİZ BAKİYE");
                    return;
                } else {
                    userInfo.setTlBalance(userInfo.getTlBalance() - currencyAmounth * moneysInfo.getBuyDolar());
                    userInfo.setDolarBalance(userInfo.getDolarBalance() + currencyAmounth);
                }
            } else if(sellRadioButton.isSelected()){
                if(currencyAmounth > userInfo.getDolarBalance()){
                    showMessage("YETERSİZ BAKİYE");
                    return;
                } else{
                    userInfo.setTlBalance(userInfo.getTlBalance() + currencyAmounth * moneysInfo.getSellDolar());
                    userInfo.setDolarBalance(userInfo.getDolarBalance() - currencyAmounth);
                }
            }
        } else if(currencyEuroRadioButton.isSelected()){
            if(!buyRadioButton.isSelected() && !sellRadioButton.isSelected()) {
                showMessage("AL/SAT İŞLEMLERİNDEN HERHANGİ BİRİNİ SEÇİNİZ");
                return;
            } else if(currencyAmounthText.getText().equals("")){
                showMessage("TUTAR GİRİNİZ");
                return;
            } else if(Integer.valueOf(currencyAmounthText.getText()) <= 0) {
                showMessage("GEÇERLİ TUTAR GİRİNİZ");
                return;
            }
            double currencyAmounth = Double.valueOf(currencyAmounthText.getText());
            if(buyRadioButton.isSelected()){
                if(currencyAmounth * moneysInfo.getBuyEuro() > userInfo.getTlBalance()){
                    showMessage("YETERSİZ BAKİYE");
                    return;
                } else {
                    userInfo.setTlBalance(userInfo.getTlBalance() - currencyAmounth * moneysInfo.getBuyEuro());
                    userInfo.setEuroBalance(userInfo.getEuroBalance() + currencyAmounth);
                }
            } else if(sellRadioButton.isSelected()){
                if(currencyAmounth > userInfo.getEuroBalance()){
                    showMessage("YETERSİZ BAKİYE");
                    return;
                } else{
                    userInfo.setTlBalance(userInfo.getTlBalance() + currencyAmounth * moneysInfo.getSellEuro());
                    userInfo.setEuroBalance(userInfo.getEuroBalance() - currencyAmounth);
                }
            }
        }
        if(databaseOperation.updateMoneyBalance(userInfo)){
            showMessage("İŞLEM ONAYLANDI");
            moneyType = "";
            myCard = "menuCard";
            balanceLabel.setText(changeDecimalFormat(calculateMoney()));
            cardLayout.show(cards, myCard);
        } else
            showMessage("İŞLEM BAŞARISIZ");
    }//GEN-LAST:event_currencyApproveButtonActionPerformed

    private void updateExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateExitButtonActionPerformed
        allExitButton();
    }//GEN-LAST:event_updateExitButtonActionPerformed

    private void userOperationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userOperationButtonActionPerformed
        updateNameText.setText(userInfo.getName());
        updateSurnameText.setText(userInfo.getSurname());
        updateEmailText.setText(userInfo.getEmail());
        oldPasswordText.setText("");
        updatePasswordText.setText("");
        updateAgainPasswordText.setText("");
        updatePasswordVisibleBox.setSelected(false);
        myCard = "updateCard";
        cardLayout.show(cards, myCard);
    }//GEN-LAST:event_userOperationButtonActionPerformed

    private void updatePasswordVisibleBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePasswordVisibleBoxActionPerformed
        if(updatePasswordVisibleBox.isSelected()){
            oldPasswordText.setEchoChar((char)0);
            updatePasswordText.setEchoChar((char)0);
            updateAgainPasswordText.setEchoChar((char)0);
        } else {
            oldPasswordText.setEchoChar('•');
            updatePasswordText.setEchoChar('•');
            updateAgainPasswordText.setEchoChar('•');
        }
    }//GEN-LAST:event_updatePasswordVisibleBoxActionPerformed

    private void updateExitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateExitButton1ActionPerformed
        if(updateNameText.getText().equals("") || updateSurnameText.getText().equals("") || updateEmailText.getText().equals("") ||
                String.valueOf(oldPasswordText.getPassword()).equals("") || String.valueOf(updatePasswordText.getPassword()).equals("") ||
                String.valueOf(updateAgainPasswordText.getPassword()).equals(""))
            showMessage("ALANLARI DOLDURUNUZ");
        else if (eMailRegex(updateEmailText.getText()))
            showMessage("E-MAİL KURALLARA UYGUN DEĞİLDİR.");
        else if(databaseOperation.registeredEmailCheck(updateEmailText.getText()))
            showMessage("SİSTEME KAYITLI E-MAİL");
        else if( String.valueOf(oldPasswordText.getPassword()).length() != 6 ||
            String.valueOf(updatePasswordText.getPassword()).length() != 6 ||
            String.valueOf(updateAgainPasswordText.getPassword()).length() != 6)
            showMessage("ŞİFRE 6 KARAKTERLİ OLMAK ZORUNDADIR");
        else if(!String.valueOf(userInfo.getPassword()).equals(String.valueOf(oldPasswordText.getPassword())))
            showMessage("ESKİ ŞİFRE HATALI");
        else if(String.valueOf(updatePasswordText.getPassword()).equals("000000"))
            showMessage("ŞİFRE 000000 OLAMAZ");
        else if(String.valueOf(userInfo.getPassword()).equals(String.valueOf(updatePasswordText.getPassword())))
            showMessage("YENİ ŞİFRE ESKİ ŞİFRE İLE AYNI OLMAMALIDIR");
        else if(!String.valueOf(updatePasswordText.getPassword()).equals(String.valueOf(updateAgainPasswordText.getPassword())))
            showMessage("YENİ ŞİFRE VE TEKRARI UYUŞMAMAKTADIR");
        else{
            userInfo.setName(updateNameText.getText());
            userInfo.setSurname(updateSurnameText.getText());
            userInfo.setEmail(updateEmailText.getText());
            userInfo.setPassword(Integer.valueOf(String.valueOf(updatePasswordText.getPassword())));
            if(databaseOperation.updateUserInfo(userInfo)){
                myCard = "menuCard";
                showMessage("İŞLEM ONAYLANDI");
                cardLayout.show(cards, myCard);
            } else
                showMessage("İŞLEM BAŞARISIZ");
        }
    }//GEN-LAST:event_updateExitButton1ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bankWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accounNumberCopyButton;
    private javax.swing.JLabel accounNumberLabel;
    private javax.swing.JRadioButton accountNumberRadioButton;
    private javax.swing.JRadioButton anotherAccount;
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JRadioButton buyRadioButton;
    private javax.swing.JPanel cards;
    private javax.swing.JButton copyButton;
    private javax.swing.JTextField currencyAmounthText;
    private javax.swing.JButton currencyApproveButton;
    private javax.swing.ButtonGroup currencyButtonGroup1;
    private javax.swing.ButtonGroup currencyButtonGroup2;
    private javax.swing.JRadioButton currencyDolarRadioButton;
    private javax.swing.JRadioButton currencyEuroRadioButton;
    private javax.swing.JButton currencyExitButton;
    private javax.swing.JLabel currencyLabel;
    private javax.swing.JPanel currencyOp;
    private javax.swing.JPanel currencyPanel;
    private javax.swing.JLabel currencyTlLabel;
    private javax.swing.JLabel currencyTlLabel1;
    private javax.swing.JButton currencyTransactionsButton;
    private javax.swing.JTextField depAmounthText;
    private javax.swing.JButton depApproveButton;
    private javax.swing.JLabel depBalanceLabel;
    private javax.swing.ButtonGroup depButtonGroup1;
    private javax.swing.ButtonGroup depButtonGroup2;
    private javax.swing.JRadioButton depDolarButton;
    private javax.swing.JRadioButton depEuroButton;
    private javax.swing.JLabel depIbanLabel;
    private javax.swing.JTextField depIbanText;
    private javax.swing.JPanel depOpPanel;
    private javax.swing.JRadioButton depTlButton;
    private javax.swing.JButton depositeButton;
    private javax.swing.JButton depositeExitButton;
    private javax.swing.JPanel depositePanel;
    private javax.swing.JButton ibanCopyButton;
    private javax.swing.JLabel ibanLabel;
    private javax.swing.JRadioButton idNumberRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.ButtonGroup loginPageButtonGroup;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField loginPasswordField;
    private javax.swing.JCheckBox loginPasswordVisible;
    private javax.swing.JTextField loginTextField;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JRadioButton myAccount;
    private javax.swing.JLabel nameSurnameLabel;
    private javax.swing.JButton newRegisterButton;
    private javax.swing.JPasswordField oldPasswordText;
    private javax.swing.JLabel registerAccountNumberLabel;
    private javax.swing.JTextField registerAccountNumberText;
    private javax.swing.JPasswordField registerAgainPasswordText;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel registerEmailLabel;
    private javax.swing.JTextField registerEmailText;
    private javax.swing.JButton registerExitButton;
    private javax.swing.JLabel registerIbanNumberLabel;
    private javax.swing.JTextField registerIbanNumberText;
    private javax.swing.JLabel registerIdNumberLabel;
    private javax.swing.JTextField registerIdNumberText;
    private javax.swing.JTextField registerNameText;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JLabel registerPasswordAgainLabel;
    private javax.swing.JLabel registerPasswordLabel;
    private javax.swing.JPasswordField registerPasswordText;
    private javax.swing.JCheckBox registerPasswordVisible;
    private javax.swing.JLabel registerSurnameLabel;
    private javax.swing.JTextField registerSurnameText;
    private javax.swing.JLabel regsiterNameLabel;
    private javax.swing.JLabel sellBuyLabel;
    private javax.swing.JRadioButton sellRadioButton;
    private javax.swing.JPasswordField updateAgainPasswordText;
    private javax.swing.JTextField updateEmailText;
    private javax.swing.JButton updateExitButton;
    private javax.swing.JButton updateExitButton1;
    private javax.swing.JTextField updateNameText;
    private javax.swing.JPanel updatePanel;
    private javax.swing.JPasswordField updatePasswordText;
    private javax.swing.JCheckBox updatePasswordVisibleBox;
    private javax.swing.JTextField updateSurnameText;
    private javax.swing.JButton userOperationButton;
    private javax.swing.JPanel windowPanel;
    private javax.swing.ButtonGroup withdrawButonGroup;
    private javax.swing.JButton withdrawButton;
    private javax.swing.JButton withdrawExitButton;
    private javax.swing.JPanel withdrawPanel;
    private javax.swing.JLabel wtAmounthLabel;
    private javax.swing.JTextField wtAmounthText;
    private javax.swing.JButton wtApproveButton;
    private javax.swing.JLabel wtBalanceLabel;
    private javax.swing.JRadioButton wtDolarRadioButton;
    private javax.swing.JRadioButton wtEuroRadioButton;
    private javax.swing.JPanel wtOPanel;
    private javax.swing.JRadioButton wtTlRadioButton;
    // End of variables declaration//GEN-END:variables
}

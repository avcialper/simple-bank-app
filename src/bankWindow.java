
import business.UserAction;
import dataAcces.DatabaseOperation;
import entities.MoneysInfo;
import entities.UserInfo;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class bankWindow extends javax.swing.JFrame {
    
    // Creating the items to use.
    UserAction userAction = new UserAction();
    DatabaseOperation databaseOperation = new DatabaseOperation();
    UserInfo userInfo = null;
    MoneysInfo moneysInfo = null;
    CardLayout cardLayout;
    String myCard = "loginCard";
    String moneyType = "";
    boolean timerBool = false;
    public bankWindow() {
        initComponents();
        cardLayout = (CardLayout)(cards.getLayout());
        if(!DatabaseOperation.loginCheck){
            showMessage("DATABASE CONNECTION FAILED");
            System.exit(0);
        }
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon/wallet.png")));
    }
    
    // Go to previous page.
    public void allExit(){
        timerBool = false;
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(myCard.equals("registerCard") || myCard.equals("menuCard")){
                    myCard = "loginCard";
                    cardLayout.show(cards, myCard);
                    timerBool = true;
                }
                else{
                    myCard = "menuCard";
                    cardLayout.show(cards, myCard);
                    timerBool = true;
                }
            }
        };
        Timer timer = new Timer(750, al);
        timer.setRepeats(false);
        timer.start();
        cardLayout.show(cards, "transitionCard");
        if(timerBool)
            timer.stop();
    }
    
    // Go to next page.
    public void changeWindowDelay(){
        timerBool = false;
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, myCard);
                timerBool = true;
            }
        };
        Timer timer = new Timer(750, al);
        timer.setRepeats(false);
        timer.start();
        cardLayout.show(cards, "transitionCard");
        if(timerBool)
            timer.stop();
    }
    
    // Checking that the value contains only numbers or .
    public boolean valueType(String text){
        String typeRegex;
        if(myCard.equals("loginCard") || myCard.equals("registerCard") || myCard.equals("updateCard"))
            typeRegex = "[0-9]+";
        else
            typeRegex = "[0-9]*[.,]{0,1}[0-9]{0,2}";
        Pattern pattern = Pattern.compile(typeRegex);
        return !pattern.matcher(text).matches();
    }
    
    // Check for spaces.
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
    
    // Shows message.
    void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
    
    // Check e-mail availability.
    public boolean eMailRegex(String eMail) {
        String eMailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(eMailRegex);
        return !pattern.matcher(eMail).matches();
    }
    
    // Set dollar price.
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
    
    // Set euro price.
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
    
    // Change decimal format.
    public String changeDecimalFormat(double money) {
        return new DecimalFormat("##.##").format(money);
    }
    
    // Convert all money to TL.
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
        title = new javax.swing.JLabel();
        loginB = new javax.swing.JLabel();
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
        registerB = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        nameSurnameLabel = new javax.swing.JLabel();
        ibanLabel = new javax.swing.JLabel();
        accounNumberLabel = new javax.swing.JLabel();
        ibanCopyButton = new javax.swing.JButton();
        accounNumberCopyButton = new javax.swing.JButton();
        balanceLabel = new javax.swing.JLabel();
        detailButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        withdrawButton = new javax.swing.JButton();
        currencyTransactionsButton = new javax.swing.JButton();
        userOperationButton = new javax.swing.JButton();
        depositeButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        menuB = new javax.swing.JLabel();
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
        depositeB = new javax.swing.JLabel();
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
        withdrawB = new javax.swing.JLabel();
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
        oldPasswordText = new javax.swing.JPasswordField();
        updatePasswordText = new javax.swing.JPasswordField();
        updateAgainPasswordText = new javax.swing.JPasswordField();
        changePassword = new javax.swing.JCheckBox();
        updateB = new javax.swing.JLabel();
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
        currencyB = new javax.swing.JLabel();
        transitionPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        transitionB = new javax.swing.JLabel();
        detailPanel = new javax.swing.JPanel();
        detailNameLabel = new javax.swing.JLabel();
        detailIdLabel = new javax.swing.JLabel();
        detailIbanLabel = new javax.swing.JLabel();
        detailAccountNumberLabel = new javax.swing.JLabel();
        detailEmailLabel = new javax.swing.JLabel();
        detailSurnameLabel = new javax.swing.JLabel();
        detailTLLabel = new javax.swing.JLabel();
        detailDolarLabel = new javax.swing.JLabel();
        detailEuroLabel = new javax.swing.JLabel();
        detailAllChangeTLLabel = new javax.swing.JLabel();
        detailExitButton = new javax.swing.JButton();
        copyUserInformatin = new javax.swing.JButton();
        detailB = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(300, 200, 0, 0));
        setResizable(false);

        cards.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cards.setLayout(new java.awt.CardLayout());

        loginPanel.setBackground(new java.awt.Color(9, 6, 26));
        loginPanel.setMaximumSize(new java.awt.Dimension(683, 300));
        loginPanel.setPreferredSize(new java.awt.Dimension(683, 330));
        loginPanel.setLayout(null);

        loginPageButtonGroup.add(idNumberRadioButton);
        idNumberRadioButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        idNumberRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        idNumberRadioButton.setText("KİMLİK NUMARSI");
        idNumberRadioButton.setBorder(null);
        idNumberRadioButton.setFocusPainted(false);
        idNumberRadioButton.setOpaque(false);
        idNumberRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idNumberRadioButtonActionPerformed(evt);
            }
        });
        loginPanel.add(idNumberRadioButton);
        idNumberRadioButton.setBounds(380, 110, 197, 28);

        accountNumberRadioButton.setBackground(new java.awt.Color(9, 6, 26));
        loginPageButtonGroup.add(accountNumberRadioButton);
        accountNumberRadioButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        accountNumberRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        accountNumberRadioButton.setText("HESAP NUMARASI");
        accountNumberRadioButton.setBorder(null);
        accountNumberRadioButton.setFocusPainted(false);
        accountNumberRadioButton.setOpaque(false);
        accountNumberRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountNumberRadioButtonActionPerformed(evt);
            }
        });
        loginPanel.add(accountNumberRadioButton);
        accountNumberRadioButton.setBounds(380, 150, 202, 36);

        loginTextField.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        loginTextField.setForeground(new java.awt.Color(255, 255, 255));
        loginTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(12, 91, 160)));
        loginTextField.setOpaque(false);
        loginTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginTextFieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginTextFieldMouseEntered(evt);
            }
        });
        loginPanel.add(loginTextField);
        loginTextField.setBounds(100, 100, 200, 32);

        loginPasswordField.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        loginPasswordField.setForeground(new java.awt.Color(255, 255, 255));
        loginPasswordField.setToolTipText("");
        loginPasswordField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(12, 91, 160)));
        loginPasswordField.setOpaque(false);
        loginPasswordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginPasswordFieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginPasswordFieldMouseEntered(evt);
            }
        });
        loginPanel.add(loginPasswordField);
        loginPasswordField.setBounds(100, 150, 200, 32);

        loginButton.setBackground(new java.awt.Color(255, 255, 255));
        loginButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("GİRİŞ YAP");
        loginButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(12, 91, 160)));
        loginButton.setContentAreaFilled(false);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginPanel.add(loginButton);
        loginButton.setBounds(130, 200, 150, 40);

        newRegisterButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        newRegisterButton.setForeground(new java.awt.Color(255, 255, 255));
        newRegisterButton.setText("KAYIT OL");
        newRegisterButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 4, 0, new java.awt.Color(12, 91, 160)));
        newRegisterButton.setContentAreaFilled(false);
        newRegisterButton.setFocusPainted(false);
        newRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRegisterButtonActionPerformed(evt);
            }
        });
        loginPanel.add(newRegisterButton);
        newRegisterButton.setBounds(130, 240, 150, 40);

        loginPasswordVisible.setBackground(new java.awt.Color(9, 6, 26));
        loginPasswordVisible.setForeground(new java.awt.Color(153, 0, 0));
        loginPasswordVisible.setFocusPainted(false);
        loginPasswordVisible.setOpaque(false);
        loginPasswordVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginPasswordVisibleActionPerformed(evt);
            }
        });
        loginPanel.add(loginPasswordVisible);
        loginPasswordVisible.setBounds(310, 140, 20, 30);

        title.setFont(new java.awt.Font("Copperplate Gothic Bold", 3, 48)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("RASH BANK");
        loginPanel.add(title);
        title.setBounds(163, 29, 369, 53);

        loginB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/backG.jpg"))); // NOI18N
        loginPanel.add(loginB);
        loginB.setBounds(0, 0, 683, 360);

        cards.add(loginPanel, "loginCard");

        registerPanel.setBackground(new java.awt.Color(9, 6, 26));
        registerPanel.setPreferredSize(new java.awt.Dimension(683, 300));
        registerPanel.setLayout(null);

        registerExitButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        registerExitButton.setForeground(new java.awt.Color(255, 255, 255));
        registerExitButton.setText("GERİ");
        registerExitButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 4, 0, new java.awt.Color(12, 91, 160)));
        registerExitButton.setContentAreaFilled(false);
        registerExitButton.setFocusPainted(false);
        registerExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerExitButtonActionPerformed(evt);
            }
        });
        registerPanel.add(registerExitButton);
        registerExitButton.setBounds(12, 13, 56, 22);

        regsiterNameLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        regsiterNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        regsiterNameLabel.setText("Ad : ");
        registerPanel.add(regsiterNameLabel);
        regsiterNameLabel.setBounds(120, 63, 35, 18);

        registerSurnameLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerSurnameLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerSurnameLabel.setText("Soyad : ");
        registerPanel.add(registerSurnameLabel);
        registerSurnameLabel.setBounds(95, 100, 60, 18);

        registerIdNumberLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerIdNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerIdNumberLabel.setText("Kimlik Numarası : ");
        registerPanel.add(registerIdNumberLabel);
        registerIdNumberLabel.setBounds(29, 136, 126, 18);

        registerPasswordLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerPasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerPasswordLabel.setText("Şifre : ");
        registerPanel.add(registerPasswordLabel);
        registerPasswordLabel.setBounds(400, 100, 48, 18);

        registerPasswordAgainLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerPasswordAgainLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerPasswordAgainLabel.setText("Şifre Tekrar : ");
        registerPanel.add(registerPasswordAgainLabel);
        registerPasswordAgainLabel.setBounds(350, 140, 98, 18);

        registerEmailLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerEmailLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerEmailLabel.setText("E-posta : ");
        registerPanel.add(registerEmailLabel);
        registerEmailLabel.setBounds(370, 60, 72, 18);

        registerIbanNumberLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerIbanNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerIbanNumberLabel.setText("İban : ");
        registerPanel.add(registerIbanNumberLabel);
        registerIbanNumberLabel.setBounds(401, 170, 47, 24);

        registerAccountNumberLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerAccountNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerAccountNumberLabel.setText("Hesap Numarası : ");
        registerPanel.add(registerAccountNumberLabel);
        registerAccountNumberLabel.setBounds(26, 173, 129, 18);

        registerNameText.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerNameText.setForeground(new java.awt.Color(255, 255, 255));
        registerNameText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        registerNameText.setOpaque(false);
        registerPanel.add(registerNameText);
        registerNameText.setBounds(167, 60, 150, 20);

        registerIdNumberText.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerIdNumberText.setForeground(new java.awt.Color(255, 255, 255));
        registerIdNumberText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        registerIdNumberText.setOpaque(false);
        registerPanel.add(registerIdNumberText);
        registerIdNumberText.setBounds(167, 133, 150, 20);

        registerSurnameText.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerSurnameText.setForeground(new java.awt.Color(255, 255, 255));
        registerSurnameText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        registerSurnameText.setOpaque(false);
        registerPanel.add(registerSurnameText);
        registerSurnameText.setBounds(167, 97, 150, 20);

        registerEmailText.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerEmailText.setForeground(new java.awt.Color(255, 255, 255));
        registerEmailText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        registerEmailText.setOpaque(false);
        registerPanel.add(registerEmailText);
        registerEmailText.setBounds(460, 60, 145, 20);

        registerIbanNumberText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        registerIbanNumberText.setForeground(new java.awt.Color(255, 255, 255));
        registerIbanNumberText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        registerIbanNumberText.setEnabled(false);
        registerIbanNumberText.setOpaque(false);
        registerPanel.add(registerIbanNumberText);
        registerIbanNumberText.setBounds(460, 170, 145, 20);

        registerAccountNumberText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        registerAccountNumberText.setForeground(new java.awt.Color(255, 255, 255));
        registerAccountNumberText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        registerAccountNumberText.setEnabled(false);
        registerAccountNumberText.setOpaque(false);
        registerPanel.add(registerAccountNumberText);
        registerAccountNumberText.setBounds(167, 170, 150, 20);

        registerPasswordText.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerPasswordText.setForeground(new java.awt.Color(255, 255, 255));
        registerPasswordText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        registerPasswordText.setOpaque(false);
        registerPanel.add(registerPasswordText);
        registerPasswordText.setBounds(460, 100, 145, 20);

        registerAgainPasswordText.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerAgainPasswordText.setForeground(new java.awt.Color(255, 255, 255));
        registerAgainPasswordText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(12, 91, 160)));
        registerAgainPasswordText.setOpaque(false);
        registerPanel.add(registerAgainPasswordText);
        registerAgainPasswordText.setBounds(460, 140, 145, 20);

        registerPasswordVisible.setBackground(new java.awt.Color(9, 6, 26));
        registerPasswordVisible.setContentAreaFilled(false);
        registerPasswordVisible.setFocusPainted(false);
        registerPasswordVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPasswordVisibleActionPerformed(evt);
            }
        });
        registerPanel.add(registerPasswordVisible);
        registerPasswordVisible.setBounds(620, 100, 21, 21);

        registerButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        registerButton.setForeground(new java.awt.Color(255, 255, 255));
        registerButton.setText("HESAP OLUŞTUR");
        registerButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(12, 91, 160)));
        registerButton.setContentAreaFilled(false);
        registerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        registerButton.setFocusPainted(false);
        registerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        registerPanel.add(registerButton);
        registerButton.setBounds(250, 230, 190, 41);

        copyButton.setBackground(new java.awt.Color(9, 6, 26));
        copyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/copyWhite.png"))); // NOI18N
        copyButton.setBorder(new javax.swing.border.MatteBorder(null));
        copyButton.setBorderPainted(false);
        copyButton.setContentAreaFilled(false);
        copyButton.setFocusPainted(false);
        copyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyButtonActionPerformed(evt);
            }
        });
        registerPanel.add(copyButton);
        copyButton.setBounds(324, 170, 21, 24);

        registerB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/backG.jpg"))); // NOI18N
        registerPanel.add(registerB);
        registerB.setBounds(0, 0, 690, 360);

        cards.add(registerPanel, "registerCard");

        menuPanel.setBackground(new java.awt.Color(9, 6, 26));
        menuPanel.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 5, new java.awt.Color(102, 0, 102)));
        jPanel1.setPreferredSize(new java.awt.Dimension(610, 131));
        jPanel1.setLayout(null);

        nameSurnameLabel.setBackground(new java.awt.Color(255, 255, 255));
        nameSurnameLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        nameSurnameLabel.setText("nameSurnameLabel");
        nameSurnameLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(102, 0, 102)));
        jPanel1.add(nameSurnameLabel);
        nameSurnameLabel.setBounds(12, 13, 246, 27);

        ibanLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        ibanLabel.setText("ibanLabel");
        ibanLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(102, 0, 102)));
        jPanel1.add(ibanLabel);
        ibanLabel.setBounds(12, 47, 246, 27);

        accounNumberLabel.setBackground(new java.awt.Color(255, 255, 255));
        accounNumberLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        accounNumberLabel.setText("accountNumberLabel");
        accounNumberLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(102, 0, 102)));
        jPanel1.add(accounNumberLabel);
        accounNumberLabel.setBounds(12, 81, 246, 27);

        ibanCopyButton.setBackground(new java.awt.Color(102, 102, 102));
        ibanCopyButton.setForeground(new java.awt.Color(102, 102, 102));
        ibanCopyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/copyBlack.png"))); // NOI18N
        ibanCopyButton.setBorder(null);
        ibanCopyButton.setBorderPainted(false);
        ibanCopyButton.setContentAreaFilled(false);
        ibanCopyButton.setFocusPainted(false);
        ibanCopyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ibanCopyButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ibanCopyButton);
        ibanCopyButton.setBounds(263, 47, 26, 16);

        accounNumberCopyButton.setBackground(new java.awt.Color(102, 102, 102));
        accounNumberCopyButton.setForeground(new java.awt.Color(102, 102, 102));
        accounNumberCopyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/copyBlack.png"))); // NOI18N
        accounNumberCopyButton.setBorder(null);
        accounNumberCopyButton.setBorderPainted(false);
        accounNumberCopyButton.setContentAreaFilled(false);
        accounNumberCopyButton.setFocusPainted(false);
        accounNumberCopyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accounNumberCopyButtonActionPerformed(evt);
            }
        });
        jPanel1.add(accounNumberCopyButton);
        accounNumberCopyButton.setBounds(263, 81, 26, 16);

        balanceLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        balanceLabel.setText("balanceLabel");
        balanceLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(102, 0, 102)));
        jPanel1.add(balanceLabel);
        balanceLabel.setBounds(330, 10, 200, 30);

        detailButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        detailButton.setText("DETAY");
        detailButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 4, 0, new java.awt.Color(102, 0, 102)));
        detailButton.setContentAreaFilled(false);
        detailButton.setFocusPainted(false);
        detailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailButtonActionPerformed(evt);
            }
        });
        jPanel1.add(detailButton);
        detailButton.setBounds(389, 69, 68, 29);

        refreshButton.setBackground(new java.awt.Color(102, 102, 102));
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        refreshButton.setBorderPainted(false);
        refreshButton.setContentAreaFilled(false);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        jPanel1.add(refreshButton);
        refreshButton.setBounds(540, 10, 57, 41);

        menuPanel.add(jPanel1);
        jPanel1.setBounds(23, 22, 610, 131);

        withdrawButton.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        withdrawButton.setForeground(new java.awt.Color(255, 255, 255));
        withdrawButton.setText("PARA ÇEKME");
        withdrawButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(12, 91, 160)));
        withdrawButton.setContentAreaFilled(false);
        withdrawButton.setFocusPainted(false);
        withdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawButtonActionPerformed(evt);
            }
        });
        menuPanel.add(withdrawButton);
        withdrawButton.setBounds(23, 166, 160, 52);

        currencyTransactionsButton.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        currencyTransactionsButton.setForeground(new java.awt.Color(255, 255, 255));
        currencyTransactionsButton.setText("DÖVİZ İŞLEMLERİ");
        currencyTransactionsButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(12, 91, 160)));
        currencyTransactionsButton.setContentAreaFilled(false);
        currencyTransactionsButton.setFocusPainted(false);
        currencyTransactionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currencyTransactionsButtonActionPerformed(evt);
            }
        });
        menuPanel.add(currencyTransactionsButton);
        currencyTransactionsButton.setBounds(473, 166, 164, 52);

        userOperationButton.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        userOperationButton.setForeground(new java.awt.Color(255, 255, 255));
        userOperationButton.setText("KULLANICI İŞLEMLERİ");
        userOperationButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(12, 91, 160)));
        userOperationButton.setContentAreaFilled(false);
        userOperationButton.setFocusPainted(false);
        userOperationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userOperationButtonActionPerformed(evt);
            }
        });
        menuPanel.add(userOperationButton);
        userOperationButton.setBounds(114, 236, 210, 52);

        depositeButton.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        depositeButton.setForeground(new java.awt.Color(255, 255, 255));
        depositeButton.setText("PARA YATIRMA/GÖNDERME");
        depositeButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(12, 91, 160)));
        depositeButton.setContentAreaFilled(false);
        depositeButton.setFocusPainted(false);
        depositeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositeButtonActionPerformed(evt);
            }
        });
        menuPanel.add(depositeButton);
        depositeButton.setBounds(195, 166, 260, 52);

        logoutButton.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("ÇIKIŞ");
        logoutButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(12, 91, 160)));
        logoutButton.setContentAreaFilled(false);
        logoutButton.setFocusPainted(false);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        menuPanel.add(logoutButton);
        logoutButton.setBounds(370, 230, 170, 60);

        menuB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/backG.jpg"))); // NOI18N
        menuPanel.add(menuB);
        menuB.setBounds(0, 0, 690, 360);

        cards.add(menuPanel, "menuCard");

        depositePanel.setBackground(new java.awt.Color(9, 6, 26));
        depositePanel.setPreferredSize(new java.awt.Dimension(683, 360));
        depositePanel.setLayout(null);

        depositeExitButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        depositeExitButton.setForeground(new java.awt.Color(255, 255, 255));
        depositeExitButton.setText("GERİ");
        depositeExitButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 4, 0, new java.awt.Color(12, 91, 160)));
        depositeExitButton.setContentAreaFilled(false);
        depositeExitButton.setFocusPainted(false);
        depositeExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositeExitButtonActionPerformed(evt);
            }
        });
        depositePanel.add(depositeExitButton);
        depositeExitButton.setBounds(12, 13, 56, 22);

        myAccount.setBackground(new java.awt.Color(9, 6, 26));
        depButtonGroup1.add(myAccount);
        myAccount.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        myAccount.setForeground(new java.awt.Color(255, 255, 255));
        myAccount.setText("KENDİ HESABIMA");
        myAccount.setContentAreaFilled(false);
        myAccount.setFocusable(false);
        myAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myAccountActionPerformed(evt);
            }
        });
        depositePanel.add(myAccount);
        myAccount.setBounds(50, 53, 167, 27);

        anotherAccount.setBackground(new java.awt.Color(9, 6, 26));
        depButtonGroup1.add(anotherAccount);
        anotherAccount.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        anotherAccount.setForeground(new java.awt.Color(255, 255, 255));
        anotherAccount.setText("BAŞKA HESABA");
        anotherAccount.setContentAreaFilled(false);
        anotherAccount.setFocusable(false);
        anotherAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anotherAccountActionPerformed(evt);
            }
        });
        depositePanel.add(anotherAccount);
        anotherAccount.setBounds(235, 53, 149, 27);

        depOpPanel.setBackground(new java.awt.Color(204, 204, 204));
        depOpPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 5, new java.awt.Color(102, 0, 102)));
        depOpPanel.setFocusable(false);
        depOpPanel.setLayout(null);

        depBalanceLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        depBalanceLabel.setText("depBalance");
        depBalanceLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(102, 0, 102)));
        depBalanceLabel.setFocusable(false);
        depOpPanel.add(depBalanceLabel);
        depBalanceLabel.setBounds(29, 59, 184, 27);

        depTlButton.setBackground(new java.awt.Color(102, 102, 102));
        depButtonGroup2.add(depTlButton);
        depTlButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        depTlButton.setText("TL");
        depTlButton.setContentAreaFilled(false);
        depTlButton.setFocusPainted(false);
        depTlButton.setFocusable(false);
        depTlButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depTlButtonActionPerformed(evt);
            }
        });
        depOpPanel.add(depTlButton);
        depTlButton.setBounds(29, 14, 44, 26);

        depDolarButton.setBackground(new java.awt.Color(102, 102, 102));
        depButtonGroup2.add(depDolarButton);
        depDolarButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        depDolarButton.setText("DOLAR");
        depDolarButton.setContentAreaFilled(false);
        depDolarButton.setFocusPainted(false);
        depDolarButton.setFocusable(false);
        depDolarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depDolarButtonActionPerformed(evt);
            }
        });
        depOpPanel.add(depDolarButton);
        depDolarButton.setBounds(92, 14, 79, 26);

        depEuroButton.setBackground(new java.awt.Color(102, 102, 102));
        depButtonGroup2.add(depEuroButton);
        depEuroButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        depEuroButton.setText("EURO");
        depEuroButton.setContentAreaFilled(false);
        depEuroButton.setFocusPainted(false);
        depEuroButton.setFocusable(false);
        depEuroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depEuroButtonActionPerformed(evt);
            }
        });
        depOpPanel.add(depEuroButton);
        depEuroButton.setBounds(189, 14, 69, 26);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("TUTAR :");
        jLabel3.setFocusable(false);
        depOpPanel.add(jLabel3);
        jLabel3.setBounds(231, 59, 70, 27);

        depIbanLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        depIbanLabel.setText("İBAN :");
        depIbanLabel.setFocusable(false);
        depOpPanel.add(depIbanLabel);
        depIbanLabel.setBounds(244, 103, 57, 27);

        depAmounthText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        depAmounthText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(102, 0, 102)));
        depAmounthText.setOpaque(false);
        depOpPanel.add(depAmounthText);
        depAmounthText.setBounds(306, 59, 217, 27);

        depIbanText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        depIbanText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(102, 0, 102)));
        depIbanText.setOpaque(false);
        depOpPanel.add(depIbanText);
        depIbanText.setBounds(306, 103, 217, 27);

        depApproveButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        depApproveButton.setText("ONAYLA");
        depApproveButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(12, 91, 160)));
        depApproveButton.setContentAreaFilled(false);
        depApproveButton.setFocusPainted(false);
        depApproveButton.setFocusable(false);
        depApproveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depApproveButtonActionPerformed(evt);
            }
        });
        depOpPanel.add(depApproveButton);
        depApproveButton.setBounds(81, 99, 98, 39);

        depositePanel.add(depOpPanel);
        depOpPanel.setBounds(49, 97, 560, 180);

        depositeB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/backG.jpg"))); // NOI18N
        depositePanel.add(depositeB);
        depositeB.setBounds(0, 0, 690, 360);

        cards.add(depositePanel, "depositeCard");

        withdrawPanel.setBackground(new java.awt.Color(9, 6, 26));
        withdrawPanel.setLayout(null);

        withdrawExitButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        withdrawExitButton.setForeground(new java.awt.Color(255, 255, 255));
        withdrawExitButton.setText("GERİ");
        withdrawExitButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 4, 0, new java.awt.Color(12, 91, 160)));
        withdrawExitButton.setContentAreaFilled(false);
        withdrawExitButton.setFocusPainted(false);
        withdrawExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawExitButtonActionPerformed(evt);
            }
        });
        withdrawPanel.add(withdrawExitButton);
        withdrawExitButton.setBounds(12, 13, 56, 22);

        wtTlRadioButton.setBackground(new java.awt.Color(9, 6, 26));
        withdrawButonGroup.add(wtTlRadioButton);
        wtTlRadioButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        wtTlRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        wtTlRadioButton.setText("TL");
        wtTlRadioButton.setContentAreaFilled(false);
        wtTlRadioButton.setFocusPainted(false);
        wtTlRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wtTlRadioButtonActionPerformed(evt);
            }
        });
        withdrawPanel.add(wtTlRadioButton);
        wtTlRadioButton.setBounds(33, 74, 44, 26);

        wtDolarRadioButton.setBackground(new java.awt.Color(9, 6, 26));
        withdrawButonGroup.add(wtDolarRadioButton);
        wtDolarRadioButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        wtDolarRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        wtDolarRadioButton.setText("DOLAR");
        wtDolarRadioButton.setContentAreaFilled(false);
        wtDolarRadioButton.setFocusPainted(false);
        wtDolarRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wtDolarRadioButtonActionPerformed(evt);
            }
        });
        withdrawPanel.add(wtDolarRadioButton);
        wtDolarRadioButton.setBounds(33, 143, 79, 26);

        wtEuroRadioButton.setBackground(new java.awt.Color(9, 6, 26));
        withdrawButonGroup.add(wtEuroRadioButton);
        wtEuroRadioButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        wtEuroRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        wtEuroRadioButton.setText("EURO");
        wtEuroRadioButton.setContentAreaFilled(false);
        wtEuroRadioButton.setFocusPainted(false);
        wtEuroRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wtEuroRadioButtonActionPerformed(evt);
            }
        });
        withdrawPanel.add(wtEuroRadioButton);
        wtEuroRadioButton.setBounds(33, 213, 69, 26);

        wtOPanel.setBackground(new java.awt.Color(204, 204, 204));
        wtOPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 5, new java.awt.Color(102, 0, 102)));

        wtBalanceLabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        wtBalanceLabel.setText("withdrawBalance");
        wtBalanceLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(102, 0, 102)));

        wtAmounthLabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        wtAmounthLabel.setText("TUTAR :");

        wtAmounthText.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        wtAmounthText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(102, 0, 102)));
        wtAmounthText.setOpaque(false);

        wtApproveButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        wtApproveButton.setText("ONAYLA");
        wtApproveButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(12, 91, 160)));
        wtApproveButton.setContentAreaFilled(false);
        wtApproveButton.setFocusPainted(false);
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
                        .addGap(117, 117, 117)
                        .addComponent(wtApproveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(wtOPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(wtAmounthLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(wtOPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wtBalanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wtAmounthText, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        wtOPanelLayout.setVerticalGroup(
            wtOPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wtOPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(wtBalanceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(wtOPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wtAmounthLabel)
                    .addComponent(wtAmounthText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(wtApproveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        withdrawPanel.add(wtOPanel);
        wtOPanel.setBounds(175, 74, 455, 183);

        withdrawB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/backG.jpg"))); // NOI18N
        withdrawPanel.add(withdrawB);
        withdrawB.setBounds(0, 0, 690, 340);

        cards.add(withdrawPanel, "withdrawCard");

        updatePanel.setBackground(new java.awt.Color(9, 6, 26));
        updatePanel.setLayout(null);

        updateExitButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        updateExitButton.setForeground(new java.awt.Color(255, 255, 255));
        updateExitButton.setText("GERİ");
        updateExitButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 4, 0, new java.awt.Color(12, 91, 160)));
        updateExitButton.setContentAreaFilled(false);
        updateExitButton.setFocusPainted(false);
        updateExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateExitButtonActionPerformed(evt);
            }
        });
        updatePanel.add(updateExitButton);
        updateExitButton.setBounds(12, 13, 56, 22);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("AD :");
        updatePanel.add(jLabel2);
        jLabel2.setBounds(68, 93, 33, 24);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SOYAD :");
        updatePanel.add(jLabel4);
        jLabel4.setBounds(36, 130, 65, 26);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("E-POSTA :");
        updatePanel.add(jLabel5);
        jLabel5.setBounds(20, 177, 81, 24);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("YENİ ŞİFRE :");
        updatePanel.add(jLabel6);
        jLabel6.setBounds(322, 135, 103, 24);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ŞİFRE TEKRAR :");
        updatePanel.add(jLabel7);
        jLabel7.setBounds(297, 177, 128, 25);

        updateNameText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        updateNameText.setForeground(new java.awt.Color(255, 255, 255));
        updateNameText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(102, 0, 102)));
        updateNameText.setOpaque(false);
        updatePanel.add(updateNameText);
        updateNameText.setBounds(106, 93, 191, 21);

        updateSurnameText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        updateSurnameText.setForeground(new java.awt.Color(255, 255, 255));
        updateSurnameText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(102, 0, 102)));
        updateSurnameText.setOpaque(false);
        updatePanel.add(updateSurnameText);
        updateSurnameText.setBounds(106, 130, 191, 21);

        updateEmailText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        updateEmailText.setForeground(new java.awt.Color(255, 255, 255));
        updateEmailText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(102, 0, 102)));
        updateEmailText.setOpaque(false);
        updatePanel.add(updateEmailText);
        updateEmailText.setBounds(106, 177, 191, 21);

        updatePasswordVisibleBox.setBackground(new java.awt.Color(9, 6, 26));
        updatePasswordVisibleBox.setOpaque(false);
        updatePasswordVisibleBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePasswordVisibleBoxActionPerformed(evt);
            }
        });
        updatePanel.add(updatePasswordVisibleBox);
        updatePasswordVisibleBox.setBounds(621, 93, 21, 24);

        updateExitButton1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        updateExitButton1.setForeground(new java.awt.Color(255, 255, 255));
        updateExitButton1.setText("KAYDET");
        updateExitButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(12, 91, 160)));
        updateExitButton1.setContentAreaFilled(false);
        updateExitButton1.setFocusPainted(false);
        updateExitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateExitButton1ActionPerformed(evt);
            }
        });
        updatePanel.add(updateExitButton1);
        updateExitButton1.setBounds(268, 220, 147, 49);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ESKİ ŞİFRE :");
        updatePanel.add(jLabel8);
        jLabel8.setBounds(322, 93, 103, 24);

        oldPasswordText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        oldPasswordText.setForeground(new java.awt.Color(255, 255, 255));
        oldPasswordText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(102, 0, 102)));
        oldPasswordText.setOpaque(false);
        updatePanel.add(oldPasswordText);
        oldPasswordText.setBounds(430, 93, 190, 21);

        updatePasswordText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        updatePasswordText.setForeground(new java.awt.Color(255, 255, 255));
        updatePasswordText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(102, 0, 102)));
        updatePasswordText.setOpaque(false);
        updatePanel.add(updatePasswordText);
        updatePasswordText.setBounds(430, 135, 190, 21);

        updateAgainPasswordText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        updateAgainPasswordText.setForeground(new java.awt.Color(255, 255, 255));
        updateAgainPasswordText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(102, 0, 102)));
        updateAgainPasswordText.setOpaque(false);
        updatePanel.add(updateAgainPasswordText);
        updateAgainPasswordText.setBounds(430, 177, 190, 21);

        changePassword.setBackground(new java.awt.Color(9, 6, 26));
        changePassword.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        changePassword.setForeground(new java.awt.Color(255, 255, 255));
        changePassword.setText("ŞİFREYİ DEĞİŞTİR");
        changePassword.setFocusPainted(false);
        changePassword.setOpaque(false);
        updatePanel.add(changePassword);
        changePassword.setBounds(430, 48, 190, 26);

        updateB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/backG.jpg"))); // NOI18N
        updatePanel.add(updateB);
        updateB.setBounds(0, -4, 683, 350);

        cards.add(updatePanel, "updateCard");

        currencyPanel.setBackground(new java.awt.Color(9, 6, 26));
        currencyPanel.setLayout(null);

        currencyExitButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        currencyExitButton.setForeground(new java.awt.Color(255, 255, 255));
        currencyExitButton.setText("GERİ");
        currencyExitButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 4, 0, new java.awt.Color(12, 91, 160)));
        currencyExitButton.setContentAreaFilled(false);
        currencyExitButton.setFocusPainted(false);
        currencyExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currencyExitButtonActionPerformed(evt);
            }
        });
        currencyPanel.add(currencyExitButton);
        currencyExitButton.setBounds(12, 13, 56, 22);

        currencyDolarRadioButton.setBackground(new java.awt.Color(9, 6, 26));
        currencyButtonGroup1.add(currencyDolarRadioButton);
        currencyDolarRadioButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        currencyDolarRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        currencyDolarRadioButton.setText("DOLAR");
        currencyDolarRadioButton.setContentAreaFilled(false);
        currencyDolarRadioButton.setFocusPainted(false);
        currencyDolarRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currencyDolarRadioButtonActionPerformed(evt);
            }
        });
        currencyPanel.add(currencyDolarRadioButton);
        currencyDolarRadioButton.setBounds(35, 114, 79, 26);

        currencyEuroRadioButton.setBackground(new java.awt.Color(9, 6, 26));
        currencyButtonGroup1.add(currencyEuroRadioButton);
        currencyEuroRadioButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        currencyEuroRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        currencyEuroRadioButton.setText("EURO");
        currencyEuroRadioButton.setContentAreaFilled(false);
        currencyEuroRadioButton.setFocusPainted(false);
        currencyEuroRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currencyEuroRadioButtonActionPerformed(evt);
            }
        });
        currencyPanel.add(currencyEuroRadioButton);
        currencyEuroRadioButton.setBounds(35, 173, 69, 26);

        currencyOp.setBackground(new java.awt.Color(204, 204, 204));
        currencyOp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 5, new java.awt.Color(102, 0, 102)));
        currencyOp.setLayout(null);

        buyRadioButton.setBackground(new java.awt.Color(102, 102, 102));
        currencyButtonGroup2.add(buyRadioButton);
        buyRadioButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        buyRadioButton.setText("AL");
        buyRadioButton.setContentAreaFilled(false);
        buyRadioButton.setFocusPainted(false);
        currencyOp.add(buyRadioButton);
        buyRadioButton.setBounds(29, 27, 45, 26);

        sellRadioButton.setBackground(new java.awt.Color(102, 102, 102));
        currencyButtonGroup2.add(sellRadioButton);
        sellRadioButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        sellRadioButton.setText("SAT");
        sellRadioButton.setContentAreaFilled(false);
        sellRadioButton.setFocusPainted(false);
        currencyOp.add(sellRadioButton);
        sellRadioButton.setBounds(92, 27, 56, 26);

        sellBuyLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        sellBuyLabel.setText("jLabel2");
        sellBuyLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(102, 0, 102)));
        currencyOp.add(sellBuyLabel);
        sellBuyLabel.setBounds(181, 27, 231, 27);

        currencyLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        currencyLabel.setText("currencyLabel");
        currencyLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(102, 0, 102)));
        currencyOp.add(currencyLabel);
        currencyLabel.setBounds(266, 67, 146, 27);

        currencyTlLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        currencyTlLabel.setText("currencyTlLabel");
        currencyTlLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(102, 0, 102)));
        currencyOp.add(currencyTlLabel);
        currencyTlLabel.setBounds(29, 67, 156, 27);

        currencyTlLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        currencyTlLabel1.setText("TUTAR : ");
        currencyOp.add(currencyTlLabel1);
        currencyTlLabel1.setBounds(29, 107, 69, 27);

        currencyAmounthText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        currencyAmounthText.setText("0");
        currencyAmounthText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(102, 0, 102)));
        currencyAmounthText.setOpaque(false);
        currencyOp.add(currencyAmounthText);
        currencyAmounthText.setBounds(103, 107, 309, 27);

        currencyApproveButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        currencyApproveButton.setText("ONAYLA");
        currencyApproveButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 4, new java.awt.Color(12, 91, 160)));
        currencyApproveButton.setContentAreaFilled(false);
        currencyApproveButton.setFocusPainted(false);
        currencyApproveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currencyApproveButtonActionPerformed(evt);
            }
        });
        currencyOp.add(currencyApproveButton);
        currencyApproveButton.setBounds(187, 147, 103, 39);

        currencyPanel.add(currencyOp);
        currencyOp.setBounds(132, 60, 460, 210);

        currencyB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/backG.jpg"))); // NOI18N
        currencyPanel.add(currencyB);
        currencyB.setBounds(0, 0, 683, 340);

        cards.add(currencyPanel, "currencyCard");

        transitionPanel.setBackground(new java.awt.Color(9, 6, 26));
        transitionPanel.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Copperplate Gothic Bold", 3, 70)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("RA");
        transitionPanel.add(jLabel10);
        jLabel10.setBounds(162, 112, 118, 89);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/thunderW.png"))); // NOI18N
        transitionPanel.add(jLabel11);
        jLabel11.setBounds(287, 83, 115, 148);

        jLabel12.setFont(new java.awt.Font("Copperplate Gothic Bold", 3, 70)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("H");
        transitionPanel.add(jLabel12);
        jLabel12.setBounds(409, 83, 88, 148);

        transitionB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/backG.jpg"))); // NOI18N
        transitionPanel.add(transitionB);
        transitionB.setBounds(0, 0, 690, 340);

        cards.add(transitionPanel, "transitionCard");

        detailPanel.setBackground(new java.awt.Color(9, 6, 26));
        detailPanel.setPreferredSize(new java.awt.Dimension(683, 360));
        detailPanel.setLayout(null);

        detailNameLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        detailNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        detailNameLabel.setText("detailName");
        detailNameLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(102, 0, 102)));
        detailPanel.add(detailNameLabel);
        detailNameLabel.setBounds(47, 48, 260, 30);

        detailIdLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        detailIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        detailIdLabel.setText("detailId");
        detailIdLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(102, 0, 102)));
        detailPanel.add(detailIdLabel);
        detailIdLabel.setBounds(47, 85, 260, 30);

        detailIbanLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        detailIbanLabel.setForeground(new java.awt.Color(255, 255, 255));
        detailIbanLabel.setText("detailIban");
        detailIbanLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(102, 0, 102)));
        detailPanel.add(detailIbanLabel);
        detailIbanLabel.setBounds(47, 122, 260, 30);

        detailAccountNumberLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        detailAccountNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        detailAccountNumberLabel.setText("detailAccountNumber");
        detailAccountNumberLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(102, 0, 102)));
        detailPanel.add(detailAccountNumberLabel);
        detailAccountNumberLabel.setBounds(47, 159, 260, 30);

        detailEmailLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        detailEmailLabel.setForeground(new java.awt.Color(255, 255, 255));
        detailEmailLabel.setText("detailEMail");
        detailEmailLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(102, 0, 102)));
        detailPanel.add(detailEmailLabel);
        detailEmailLabel.setBounds(47, 196, 260, 30);

        detailSurnameLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        detailSurnameLabel.setForeground(new java.awt.Color(255, 255, 255));
        detailSurnameLabel.setText("detailSurname");
        detailSurnameLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(102, 0, 102)));
        detailPanel.add(detailSurnameLabel);
        detailSurnameLabel.setBounds(335, 48, 260, 30);

        detailTLLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        detailTLLabel.setForeground(new java.awt.Color(255, 255, 255));
        detailTLLabel.setText("detailTL");
        detailTLLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(102, 0, 102)));
        detailPanel.add(detailTLLabel);
        detailTLLabel.setBounds(335, 85, 260, 30);

        detailDolarLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        detailDolarLabel.setForeground(new java.awt.Color(255, 255, 255));
        detailDolarLabel.setText("detailDolar");
        detailDolarLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(102, 0, 102)));
        detailPanel.add(detailDolarLabel);
        detailDolarLabel.setBounds(335, 122, 260, 30);

        detailEuroLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        detailEuroLabel.setForeground(new java.awt.Color(255, 255, 255));
        detailEuroLabel.setText("detailEuro");
        detailEuroLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(102, 0, 102)));
        detailPanel.add(detailEuroLabel);
        detailEuroLabel.setBounds(335, 159, 260, 30);

        detailAllChangeTLLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        detailAllChangeTLLabel.setForeground(new java.awt.Color(255, 255, 255));
        detailAllChangeTLLabel.setText("detailAllChangeTL");
        detailAllChangeTLLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(102, 0, 102)));
        detailPanel.add(detailAllChangeTLLabel);
        detailAllChangeTLLabel.setBounds(335, 196, 260, 30);

        detailExitButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        detailExitButton.setForeground(new java.awt.Color(255, 255, 255));
        detailExitButton.setText("GERİ");
        detailExitButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 4, 0, new java.awt.Color(12, 91, 160)));
        detailExitButton.setContentAreaFilled(false);
        detailExitButton.setFocusPainted(false);
        detailExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailExitButtonActionPerformed(evt);
            }
        });
        detailPanel.add(detailExitButton);
        detailExitButton.setBounds(12, 13, 56, 22);

        copyUserInformatin.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        copyUserInformatin.setForeground(new java.awt.Color(255, 255, 255));
        copyUserInformatin.setText("BİLGİLERİ KOPYALA");
        copyUserInformatin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 5, new java.awt.Color(12, 91, 160)));
        copyUserInformatin.setContentAreaFilled(false);
        copyUserInformatin.setFocusPainted(false);
        copyUserInformatin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyUserInformatinActionPerformed(evt);
            }
        });
        detailPanel.add(copyUserInformatin);
        copyUserInformatin.setBounds(222, 244, 212, 37);

        detailB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/backG.jpg"))); // NOI18N
        detailPanel.add(detailB);
        detailB.setBounds(0, 0, 690, 340);

        cards.add(detailPanel, "detailPanel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accountNumberRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountNumberRadioButtonActionPerformed
        if(accountNumberRadioButton.isSelected())
            loginTextField.setText("HESAP N.");
        else
            loginTextField.setText("");
        loginPasswordField.setText("ŞİFRE");
        loginPasswordField.setEchoChar((char)0);
    }//GEN-LAST:event_accountNumberRadioButtonActionPerformed

    private void idNumberRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idNumberRadioButtonActionPerformed
        if(idNumberRadioButton.isSelected())
            loginTextField.setText("KİMLİK N.");
        else
            loginTextField.setText("");
        loginPasswordField.setText("ŞİFRE");
        loginPasswordField.setEchoChar((char)0);
    }//GEN-LAST:event_idNumberRadioButtonActionPerformed

    private void loginTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginTextFieldMouseClicked
        if(loginTextField.getText().equals("HESAP N.") || loginTextField.getText().equals("KİMLİK N."))
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
            loginTextField.setText("KİMLİK N.");
        else if (accountNumberRadioButton.isSelected() && loginTextField.getText().equals(""))
            loginTextField.setText("HESAP N.");
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
        registerPasswordVisible.setSelected(false);
        registerPasswordText.setEchoChar('•');
        registerAgainPasswordText.setEchoChar('•');
        registerButton.setText("HESAP OLUŞTUR");
        myCard = "registerCard";
        changeWindowDelay();
    }//GEN-LAST:event_newRegisterButtonActionPerformed

    private void registerExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerExitButtonActionPerformed
        loginPageButtonGroup.clearSelection();
        loginTextField.setText((""));
        loginPasswordField.setText("");
        loginPasswordVisible.setSelected(false);
        loginPasswordField.setEchoChar('•');
        allExit();
    }//GEN-LAST:event_registerExitButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        registerIdNumberText.setToolTipText("Kimlik numarası 8 haneli olmak zorundadır.");
        registerPasswordText.setToolTipText("Şifre 6 haneli olmalıdır.");
        if(registerButton.getText().equals("HESAP OLUŞTUR")) {
            if(registerInfoIsEmpty())
                showMessage("ALANLAR BOŞ BIRAKILAMAZ.");
            else if(valueType(registerIdNumberText.getText()))
                showMessage("KİMLİK NUMARASI SADECE SAYI İÇERMELİDİR.");
            else if (registerIdNumberText.getText().length() != 8)
                showMessage("KİMLİK NUMARASI 8 HANELİ OLMAK ZORUNDADIR.");
            else if (databaseOperation.registeredIdNumberCheck(Integer.valueOf(registerIdNumberText.getText())))
                showMessage("KİMLİK NUMARASI SİSTEME KAYITLI.");
            else if (valueType(String.valueOf(registerPasswordText.getPassword())))
                showMessage("ŞİFRE YALNIZCA SAYI İÇERMELİDİR.");
            else if(String.valueOf(registerPasswordText.getPassword()).length() != 6)
                showMessage("ŞİFRE 6 HANELİ OLMAK ZORUNDADIR");
            else if(String.valueOf(registerPasswordText.getPassword()).equals("000000"))
                showMessage("ŞİFRE 000000 OLAMAZ");
            else if (!String.valueOf(registerPasswordText.getPassword()).equals(String.valueOf(registerAgainPasswordText.getPassword())))
                showMessage("ŞİFRE İLE ŞİFRE TEKRARI UYUŞMAMAKTADIR.");
            else if (eMailRegex(registerEmailText.getText()))
                showMessage("E-MAİL KURALLARA UYGUN DEĞİLDİR.");
            else if(databaseOperation.registeredEmailCheck(registerEmailText.getText()))
                showMessage("SİSTEME KAYITLI E-MAİL");
            else {
                registerIbanNumberText.setText(String.valueOf(userAction.generateIbanNumber()));
                registerAccountNumberText.setText(String.valueOf(userAction.generateAccountNumber()));
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
            else if(valueType(registerIdNumberText.getText()))
                showMessage("KİMLİK NUMARASI SADECE SAYI İÇERMELİDİR.");
            else if (registerIdNumberText.getText().length() != 8)
                showMessage("KİMLİK NUMARASI 8 HANELİ OLMAK ZORUNDADIR.");
            else if (databaseOperation.registeredIdNumberCheck(Integer.valueOf(registerIdNumberText.getText())))
                showMessage("KİMLİK NUMARASI SİSTEME KAYITLI.");
            else if (valueType(String.valueOf(registerPasswordText.getPassword())))
                showMessage("ŞİFRE YALNIZCA SAYI İÇERMELİDİR.");
            else if(String.valueOf(registerPasswordText.getPassword()).length() != 6)
                showMessage("ŞİFRE 6 HANELİ OLMAK ZORUNDADIR");
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
                allExit();
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
        else if(idNumberRadioButton.isSelected() && loginTextField.getText().length() != 8)
            showMessage("KİMLİK NUMARASI 8 HANELİ OLMAK ZORUNDADIR");
        else if(accountNumberRadioButton.isSelected() && loginTextField.getText().length() != 6)
            showMessage("HESAP NUMARASI 6 HANELİ OLMAK ZORUNDADIR");
        else if(valueType(loginTextField.getText()) || valueType(String.valueOf(loginPasswordField.getPassword())))
            showMessage("GİRİŞ BİLGİLERİ HARF İÇEREMEZ");
        else if (String.valueOf(loginPasswordField.getPassword()).length() != 6)
                showMessage("ŞİFRE 6 HANELİ OLMAK ZORUNDADIR");
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
            changeWindowDelay();
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
        allExit();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void depositeExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositeExitButtonActionPerformed
        allExit();
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
        changeWindowDelay();
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
            else if(valueType(depAmounthText.getText())){
                showMessage("HATALI TUTAR GİRİŞİ.\n(TUTAR HARF İÇEREMEZ, VİRGÜLDEN SONRA EN FAZLA 2 BASAMAK GELEBİLİR.)");
                return;
            }
            else if(Double.parseDouble(depAmounthText.getText().trim().replace(',', '.')) < 0) {
                showMessage("TUTAR NEGATİF OLAMAZ");
                return;
            }
            else if(Double.parseDouble(depAmounthText.getText().trim().replace(',', '.')) == 0) {
                showMessage("TUTAR 0 OLAMAZ");
                return;
            }
            double addedMoney = Double.parseDouble(depAmounthText.getText().trim().replace(',', '.'));
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
                allExit();
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
            else if(valueType(depAmounthText.getText())){
                System.out.println("afşl");
                showMessage("TUTAR HARF İÇEREMEZ");
                return;
            }
            else if(Double.parseDouble(depAmounthText.getText().trim().replace(',', '.')) < 0) {
                showMessage("TUTAR NEGATİF DEĞER ALAMAZ");
                return;
            }
            else if(Double.parseDouble(depAmounthText.getText().trim().replace(',', '.')) == 0) {
                showMessage("TUTAR 0 OLAMAZ");
                return;
            }
            double sentMoney = Double.parseDouble(depAmounthText.getText().trim().replace(',', '.'));
            if(valueType(depIbanText.getText())){
                showMessage("İBAN HARF İÇEREMEZ");
                return;
            }
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
                    balanceLabel.setText("Bakiye : " + changeDecimalFormat(calculateMoney()) + "₺");
                    showMessage("İŞLEM ONAYLANDI");
                    allExit();
                } else 
                    showMessage("İŞLEM BAŞARISIZ");
            }
            else
                showMessage("KULLANICI BULUNAMADI");
        }
    }//GEN-LAST:event_depApproveButtonActionPerformed

    private void withdrawExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawExitButtonActionPerformed
        allExit();
    }//GEN-LAST:event_withdrawExitButtonActionPerformed

    private void wtApproveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wtApproveButtonActionPerformed
        if(moneyType.equals("")){
            showMessage("PARA BİRİMİ SEÇİNİZ");
            return;
        }
        else if(wtAmounthText.getText().equals("")){
            showMessage("TUTAR GİRİNİZ");
            return;
        }
        else if(valueType(wtAmounthText.getText())){
            showMessage("HATALI TUTAR GİRİŞİ.\n(TUTAR HARF İÇEREMEZ, VİRGÜLDEN SONRA EN FAZLA 2 BASAMAK GELEBİLİR.)");
            return;
        }
        else if(Double.parseDouble(wtAmounthText.getText().trim().replace(',', '.')) <= 0){
            showMessage("GEÇERLİ TUTAR GİRİNİZ");
            return;
        }
        double wtMoney = Double.valueOf((wtAmounthText.getText().trim()).replace(',', '.'));
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
            showMessage("İŞLEM ONAYLANDI");
            balanceLabel.setText("Bakiye : " + changeDecimalFormat(calculateMoney()) + "₺");
            allExit();
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
        changeWindowDelay();
    }//GEN-LAST:event_currencyTransactionsButtonActionPerformed

    private void currencyExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currencyExitButtonActionPerformed
        allExit();
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
            }
            else if(valueType(currencyAmounthText.getText())){
                showMessage("HATALI TUTAR GİRİŞİ.\n(TUTAR HARF İÇEREMEZ, VİRGÜLDEN SONRA EN FAZLA 2 BASAMAK GELEBİLİR.)");
                return;
            }
            else if(Double.parseDouble(currencyAmounthText.getText().trim().replace(',', '.')) <= 0) {
                showMessage("GEÇERLİ TUTAR GİRİNİZ");
                return;
            }
            double currencyAmounth = Double.parseDouble(currencyAmounthText.getText().trim().replace(',', '.'));
            if(buyRadioButton.isSelected()){
                if(currencyAmounth * moneysInfo.getBuyDolar() > userInfo.getTlBalance()){
                    showMessage("YETERSİZ BAKİYE");
                    return;
                } else {
                    userInfo.setTlBalance(userInfo.getTlBalance() - Double.parseDouble(changeDecimalFormat(currencyAmounth * moneysInfo.getBuyDolar()).replace(",", ".")));
                    userInfo.setDolarBalance(userInfo.getDolarBalance() + currencyAmounth);
                }
            } else if(sellRadioButton.isSelected()){
                if(currencyAmounth > userInfo.getDolarBalance()){
                    showMessage("YETERSİZ BAKİYE");
                    return;
                } else{
                    userInfo.setTlBalance(userInfo.getTlBalance() + Double.parseDouble(changeDecimalFormat(currencyAmounth * moneysInfo.getSellDolar()).replace(",", ".")));
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
            }
            else if(valueType(currencyAmounthText.getText())){
                showMessage("TUTAR HARF İÇEREMEZ");
                return;
            }
            else if(Double.parseDouble(currencyAmounthText.getText().trim().replace(',', '.')) <= 0) {
                showMessage("GEÇERLİ TUTAR GİRİNİZ");
                return;
            }
            double currencyAmounth = Double.parseDouble(currencyAmounthText.getText().trim().replace(',', '.'));
            if(buyRadioButton.isSelected()){
                if(currencyAmounth * moneysInfo.getBuyEuro() > userInfo.getTlBalance()){
                    showMessage("YETERSİZ BAKİYE");
                    return;
                } else {
                    userInfo.setTlBalance(userInfo.getTlBalance() - Double.parseDouble(changeDecimalFormat(currencyAmounth * moneysInfo.getBuyEuro()).replace(",", ".")));
                    userInfo.setEuroBalance(userInfo.getEuroBalance() + currencyAmounth);
                }
            } else if(sellRadioButton.isSelected()){
                if(currencyAmounth > userInfo.getEuroBalance()){
                    showMessage("YETERSİZ BAKİYE");
                    return;
                } else{
                    userInfo.setTlBalance(userInfo.getTlBalance() + Double.parseDouble(changeDecimalFormat(currencyAmounth * moneysInfo.getSellEuro()).replace(",", ".")));
                    userInfo.setEuroBalance(userInfo.getEuroBalance() - currencyAmounth);
                }
            }
        }
        if(databaseOperation.updateMoneyBalance(userInfo)){
            showMessage("İŞLEM ONAYLANDI");
            moneyType = "";
            balanceLabel.setText("Bakiye : " + changeDecimalFormat(calculateMoney()) + "₺");
            allExit();
        } else
            showMessage("İŞLEM BAŞARISIZ");
    }//GEN-LAST:event_currencyApproveButtonActionPerformed

    private void updateExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateExitButtonActionPerformed
        allExit();
    }//GEN-LAST:event_updateExitButtonActionPerformed

    private void userOperationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userOperationButtonActionPerformed
        changePassword.setSelected(false);
        updateNameText.setText(userInfo.getName());
        updateSurnameText.setText(userInfo.getSurname());
        updateEmailText.setText(userInfo.getEmail());
        oldPasswordText.setText("");
        updatePasswordText.setText("");
        updateAgainPasswordText.setText("");
        updatePasswordVisibleBox.setSelected(false);
        myCard = "updateCard";
        changeWindowDelay();
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
        if(changePassword.isSelected()){
            if(updateNameText.getText().equals("") || updateSurnameText.getText().equals("") || updateEmailText.getText().equals("") ||
                String.valueOf(oldPasswordText.getPassword()).equals("") || String.valueOf(updatePasswordText.getPassword()).equals("") ||
                String.valueOf(updateAgainPasswordText.getPassword()).equals("")){
                showMessage("ALANLARI DOLDURUNUZ");
                return;
            }
            else if(valueType(String.valueOf(oldPasswordText.getPassword())) || valueType(String.valueOf(updateAgainPasswordText.getPassword()))){
                showMessage("ŞİFRE HARF İÇEREMEZ");
                return;
            }
            else if( String.valueOf(oldPasswordText.getPassword()).length() != 6 ||
                String.valueOf(updatePasswordText.getPassword()).length() != 6 ||
                String.valueOf(updateAgainPasswordText.getPassword()).length() != 6){
                showMessage("ŞİFRE 6 HANELİ OLMAK ZORUNDADIR");
                return;
            }
            else if(!(userInfo.getPassword() == Integer.parseInt(String.valueOf(oldPasswordText.getPassword())))){
                showMessage("ESKİ ŞİFRE HATALI");
                return;
            }
            else if(String.valueOf(updatePasswordText.getPassword()).equals("000000")){
                showMessage("ŞİFRE 000000 OLAMAZ");
                return;
            }
            else if(String.valueOf(userInfo.getPassword()).equals(String.valueOf(updatePasswordText.getPassword()))){
                showMessage("YENİ ŞİFRE ESKİ ŞİFRE İLE AYNI OLMAMALIDIR");
                return;
            }
            else if(!String.valueOf(updatePasswordText.getPassword()).equals(String.valueOf(updateAgainPasswordText.getPassword()))){
                showMessage("YENİ ŞİFRE VE TEKRARI UYUŞMAMAKTADIR");
                return;
            }
            else
                userInfo.setPassword(Integer.parseInt(String.valueOf(updatePasswordText.getPassword())));
        }
        else if (eMailRegex(updateEmailText.getText())){
            showMessage("E-MAİL KURALLARA UYGUN DEĞİLDİR.");
            return;
        }
        else if(!updateEmailText.getText().equals(userInfo.getEmail())){
            if(databaseOperation.registeredEmailCheck(updateEmailText.getText())){
                showMessage("SİSTEME KAYITLI E-MAİL");
                return;
            }
        }
        else if(updateEmailText.getText().equals(userInfo.getEmail()) && updateNameText.getText().equals(userInfo.getName())
                && updateSurnameText.getText().equals(userInfo.getSurname())){
            showMessage("HERHANGİ BİR DEĞİŞİKLİK YAPILMADI");
            allExit();
            return;
        }
        userInfo.setName(updateNameText.getText());
        userInfo.setSurname(updateSurnameText.getText());
        userInfo.setEmail(updateEmailText.getText());
        if (databaseOperation.updateUserInfo(userInfo)) {
            balanceLabel.setText("BAKİYE : " + changeDecimalFormat(calculateMoney()) + "₺");
            nameSurnameLabel.setText(userInfo.getName() + " " + userInfo.getSurname());
            ibanLabel.setText("İban : " + userInfo.getIbanNumber());
            accounNumberLabel.setText("Hesap Numarası : " + userInfo.getAccountNumber());
            showMessage("İŞLEM ONAYLANDI");
            allExit();
        } else
            showMessage("İŞLEM BAŞARISIZ");
    }//GEN-LAST:event_updateExitButton1ActionPerformed

    private void detailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailButtonActionPerformed
        myCard = "detailPanel";
        detailNameLabel.setText("Ad : " + userInfo.getName());
        detailSurnameLabel.setText("Soyad : " + userInfo.getSurname());
        detailAccountNumberLabel.setText("Hesap Numarası : " + String.valueOf(userInfo.getAccountNumber()));
        detailAllChangeTLLabel.setText("Hesap Bakiyesi : " + changeDecimalFormat(calculateMoney()) + "₺");
        detailDolarLabel.setText("Dolar : " + changeDecimalFormat(userInfo.getDolarBalance()) + "$");
        detailEmailLabel.setText("E-mail : " + userInfo.getEmail());
        detailEuroLabel.setText(("Euro : " + changeDecimalFormat(userInfo.getEuroBalance())) + "£");
        detailIbanLabel.setText("İban : " + String.valueOf(userInfo.getIbanNumber()));
        detailIdLabel.setText("Kimlik Numarası : " + String.valueOf(userInfo.getIdNumber()));
        detailTLLabel.setText("TL : " + changeDecimalFormat(userInfo.getTlBalance()) + "₺");
        changeWindowDelay();
    }//GEN-LAST:event_detailButtonActionPerformed

    private void detailExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailExitButtonActionPerformed
        allExit();
    }//GEN-LAST:event_detailExitButtonActionPerformed

    private void copyUserInformatinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyUserInformatinActionPerformed
        String information = 
                "Ad : " + userInfo.getName() +
                "\nSoyad : " + userInfo.getSurname() + 
                "\nKimlik Numarası : " + userInfo.getIdNumber() +
                "\nHesap Numarası : " + userInfo.getAccountNumber() +
                "\nİban : " + userInfo.getIbanNumber() +
                "\nE-posta : " + userInfo.getEmail() +
                "\nTL Bakiye : " + userInfo.getTlBalance() +
                "₺\nDolar Bakiye : " + userInfo.getDolarBalance() +
                "$\nEuro Bakiye : " + userInfo.getEuroBalance() +
                "€\nToplam Bakiye : " + changeDecimalFormat(calculateMoney());
        StringSelection stringSelection = new StringSelection(information);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        showMessage("BİLGİLER KOPYALANDI");
    }//GEN-LAST:event_copyUserInformatinActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        userInfo = databaseOperation.getUserInfoFromDatabaseWithAccountNumber(userInfo.getAccountNumber());
        balanceLabel.setText("BAKİYE : " + changeDecimalFormat(calculateMoney()) + "₺");
        nameSurnameLabel.setText(userInfo.getName() + " " + userInfo.getSurname());
        ibanLabel.setText("İban : " + userInfo.getIbanNumber());
        accounNumberLabel.setText("Hesap Numarası : " + userInfo.getAccountNumber());
        changeWindowDelay();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void withdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawButtonActionPerformed
        moneyType = "";
        myCard = "withdrawCard";
        wtBalanceLabel.setText("BAKİYE : ");
        wtAmounthText.setText("");
        withdrawButonGroup.clearSelection();
        changeWindowDelay();
    }//GEN-LAST:event_withdrawButtonActionPerformed

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
    private javax.swing.JCheckBox changePassword;
    private javax.swing.JButton copyButton;
    private javax.swing.JButton copyUserInformatin;
    private javax.swing.JTextField currencyAmounthText;
    private javax.swing.JButton currencyApproveButton;
    private javax.swing.JLabel currencyB;
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
    private javax.swing.JLabel depositeB;
    private javax.swing.JButton depositeButton;
    private javax.swing.JButton depositeExitButton;
    private javax.swing.JPanel depositePanel;
    private javax.swing.JLabel detailAccountNumberLabel;
    private javax.swing.JLabel detailAllChangeTLLabel;
    private javax.swing.JLabel detailB;
    private javax.swing.JButton detailButton;
    private javax.swing.JLabel detailDolarLabel;
    private javax.swing.JLabel detailEmailLabel;
    private javax.swing.JLabel detailEuroLabel;
    private javax.swing.JButton detailExitButton;
    private javax.swing.JLabel detailIbanLabel;
    private javax.swing.JLabel detailIdLabel;
    private javax.swing.JLabel detailNameLabel;
    private javax.swing.JPanel detailPanel;
    private javax.swing.JLabel detailSurnameLabel;
    private javax.swing.JLabel detailTLLabel;
    private javax.swing.JButton ibanCopyButton;
    private javax.swing.JLabel ibanLabel;
    private javax.swing.JRadioButton idNumberRadioButton;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loginB;
    private javax.swing.JButton loginButton;
    private javax.swing.ButtonGroup loginPageButtonGroup;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField loginPasswordField;
    private javax.swing.JCheckBox loginPasswordVisible;
    private javax.swing.JTextField loginTextField;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel menuB;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JRadioButton myAccount;
    private javax.swing.JLabel nameSurnameLabel;
    private javax.swing.JButton newRegisterButton;
    private javax.swing.JPasswordField oldPasswordText;
    private javax.swing.JButton refreshButton;
    private javax.swing.JLabel registerAccountNumberLabel;
    private javax.swing.JTextField registerAccountNumberText;
    private javax.swing.JPasswordField registerAgainPasswordText;
    private javax.swing.JLabel registerB;
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
    private javax.swing.JLabel title;
    private javax.swing.JLabel transitionB;
    private javax.swing.JPanel transitionPanel;
    private javax.swing.JPasswordField updateAgainPasswordText;
    private javax.swing.JLabel updateB;
    private javax.swing.JTextField updateEmailText;
    private javax.swing.JButton updateExitButton;
    private javax.swing.JButton updateExitButton1;
    private javax.swing.JTextField updateNameText;
    private javax.swing.JPanel updatePanel;
    private javax.swing.JPasswordField updatePasswordText;
    private javax.swing.JCheckBox updatePasswordVisibleBox;
    private javax.swing.JTextField updateSurnameText;
    private javax.swing.JButton userOperationButton;
    private javax.swing.JLabel withdrawB;
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

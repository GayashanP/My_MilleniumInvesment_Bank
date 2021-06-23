package milleniuminvesment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class SQLMan {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "nothing";
    private static final String COMMON = "mi_common";
    private static final String CUSTOMER_BILLS = "mi_customer_bills";
    private static final String CUSTOMER_LOGS = "mi_customer_logs";
    private static final String BILLS_LOGS = "mi_bills_logs";
    private static final String MAIL = "mi_mails";
    private static final String BANK_NAME = "MILLENNIUM INVESTMENT";

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static boolean commonFound = false;
    private static boolean customersBillsFound = false;
    private static boolean customersLogFound = false;
    private static boolean billsLogFound = false;
    private static boolean mailFound = false;

    public static void init() {
        try {
            Common.progressHandle("CREATING DATABASE CONNECTION", 0);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Common.progressHandle("CONNECTED DATABASE CONNECTION", 5);
            Common.progressHandle("CREATING STATEMENT", 0);
            statement = connection.createStatement();
            Common.progressHandle("CREATED STATEMENT", 5);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Connection error " + e);
            System.exit(0);
        }
    }

    public static void close(){
        try {
            statement.close();
            connection.close();
            resultSet.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static boolean checkDatabases() {
        String query = "show databases;";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String db = resultSet.getString(1);
                if (db.equals(COMMON)) {
                    commonFound = true;
                    continue;
                }
                if (db.equals(CUSTOMER_BILLS)) {
                    customersBillsFound = true;
                    continue;
                }
                if (db.equals(CUSTOMER_LOGS)) {
                    customersLogFound = true;
                    continue;
                }
                if (db.equals(BILLS_LOGS)) {
                    billsLogFound = true;
                }
                if (db.equals(MAIL)) {
                    mailFound = true;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error checking databases " + e);
            System.exit(0);
        }
        if (commonFound && customersBillsFound && customersLogFound && billsLogFound) {
            return true;
        }
        return false;
    }

    public static void createDatabases() {

        String create_db = "create database ";
        String common_interest = "CREATE TABLE `" + COMMON + "`.`interest` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `rate` VARCHAR(45) NOT NULL,\n" +
                "  `update_date` VARCHAR(45) NOT NULL,\n" +
                "  `end_date` VARCHAR(45) NOT NULL,\n" +
                "  PRIMARY KEY (`id`));";
        String common_customers = "CREATE TABLE `" + COMMON + "`.`customers` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `username` VARCHAR(45) NOT NULL,\n" +
                "  `password` VARCHAR(45) NOT NULL,\n" +
                "  `branch` VARCHAR(45) NOT NULL,\n" +
                "  `date_created` VARCHAR(45) NOT NULL,\n" +
                "  `last_interest_update` VARCHAR(45) NOT NULL,\n" +
                "  `balance` VARCHAR(45) NOT NULL,\n" +
                "  `is_blocked` VARCHAR(45) NOT NULL,\n" +
                "  PRIMARY KEY (`id`));\n";
        String common_bills = "CREATE TABLE `" + COMMON + "`.`bills` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `bill` VARCHAR(45) NOT NULL,\n" +
                "  `bill_type` VARCHAR(45) NOT NULL,\n" +
                "  `balance` VARCHAR(45) NOT NULL,\n" +
                "  PRIMARY KEY (`id`));";

        try {
            if (billsLogFound) {
                Common.progressHandle("FOUND BILL LOGS",5);
            } else {
                Common.progressHandle("CREATING BILL LOGS",0);
                statement.executeUpdate(create_db + BILLS_LOGS + ";");
                Common.progressHandle("CREATED BILL LOGS",0);
            }
            if (commonFound) {
                Common.progressHandle("FOUND COMMON",40);
            } else {

                Common.progressHandle("CREATING COMMON",0);
                statement.executeUpdate(create_db + COMMON + ";");
                Common.progressHandle("CREATED COMMON",5);

                Common.progressHandle("CREATING COMMON INTEREST",0);
                statement.executeUpdate(common_interest);
                Common.progressHandle("CREATED COMMON INTEREST",5);

                Common.progressHandle("CREATING COMMON CUSTOMERS",0);
                statement.executeUpdate(common_customers);
                Common.progressHandle("CREATED COMMON CUSTOMERS",5);

                Common.progressHandle("CREATING COMMON BILLS",0);
                statement.executeUpdate(common_bills);
                Common.progressHandle("CREATED COMMON BILLS",5);

                addBillItems();
            }

            if (customersLogFound) {
                Common.progressHandle("FOUND CUSTOMER LOGS",5);
            } else {
                Common.progressHandle("CREATING CUSTOMER LOGS",0);
                statement.executeUpdate(create_db + CUSTOMER_LOGS + ";");
                Common.progressHandle("CREATED CUSTOMER LOGS",5);
            }

            if (customersBillsFound) {
                Common.progressHandle("FOUND CUSTOMER BILLS",5);
            } else {
                Common.progressHandle("CREATING CUSTOMER BILLS",0);
                statement.executeUpdate(create_db + CUSTOMER_BILLS + ";");
                Common.progressHandle("CREATED CUSTOMER LOGS",5);
            }
            if (mailFound) {
                Common.progressHandle("FOUND MAIL BOX",0);
            } else {
                Common.progressHandle("CREATING MAIL BOX",0);
                statement.executeUpdate(create_db + MAIL + ";");
                Common.progressHandle("CREATED MAIL BOX",5);


                newCustomer("admin","none",Common.BANK_NAME);
                Common.progressHandle("ADDED ADMIN MAIL",5);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error creating databases " + e);
            System.exit(0);
        }

    }



    private static void addBillItems() {

        Common.progressHandle("INSERTING PRE-BILLS",0);

        for (int i = 0; i < Common.BILLS.length; i++) {
            String bill = Common.BILLS[i];
            String billType = Common.BILL_TYPES[i];
            String query = "insert into " + COMMON + ".bills (bill,bill_type,balance) values ('" + bill + "','" + billType + "','0');";
            String createTable = "CREATE TABLE `" + BILLS_LOGS + "`.`" + bill + "` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `username` VARCHAR(45) NOT NULL,\n" +
                    "  `amount` VARCHAR(45) NOT NULL,\n" +
                    "  `account` VARCHAR(45) NOT NULL,\n" +
                    "  `transaction_date` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            try {
                statement.executeUpdate(createTable);
                statement.executeUpdate(query);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error inserting bills " + e);
                System.exit(0);
            }
        }
        Common.progressHandle("INSERTED PRE-BILLS",15);

    }

    public static boolean hasMail(String username) {

        String query = "select * from " + MAIL + "." + username + " where have_read = 'unread';";
        try {
            resultSet = statement.executeQuery(query);
            return resultSet.next();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error reading unread message status " + e);
        }
        JOptionPane.showMessageDialog(null, "Error reading unread message status ");
        return true;
    }

    public static String[] getAdminSummary() {
        String billSizeQuery = "select balance from " + COMMON + ".bills;";
        int billsSize = 0;
        double billBalance = 0;
        int customerCount = 0;
        double worth = 0;
        try {
            resultSet = statement.executeQuery(billSizeQuery);
            while (resultSet.next()) {
                billsSize++;
                billBalance += Double.parseDouble(resultSet.getString(1));
            }
            resultSet = statement.executeQuery("select balance from " + COMMON + ".customers;");
            while (resultSet.next()) {
                customerCount++;
                worth += Double.parseDouble(resultSet.getString(1));
            }


        } catch (Exception ignored) {
        }
        return new String[]{"24", String.valueOf(billsSize), String.valueOf(billBalance), String.valueOf(customerCount), "25", String.valueOf(worth)};
    }

    public static void dropEveryDatabases() {
        String drop = "drop database ";
        String[] array = {COMMON, CUSTOMER_LOGS, CUSTOMER_BILLS, BILLS_LOGS, MAIL};
        for (String db : array) {
            try {
                statement.executeUpdate(drop + db + ";");
            } catch (Exception e) {}
        }
    }

    public static void transactionsTableUpdate(String username, DefaultTableModel table) {
        String getTransactions = "select * from " + CUSTOMER_LOGS + "." + username + ";";
        try {
            resultSet = statement.executeQuery(getTransactions);
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String date = resultSet.getString(2);
                String amount = resultSet.getString(3);
                String description = resultSet.getString(4);
                table.addRow(new Object[]{id, date, amount, description});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error getting transactions " + e);
        }
    }

    public static void mailBoxUpdate(DefaultTableModel table, String username) {
        String user = username.equals("ADMIN") ? "ADMIN" : username;
        String getRows = "select * from " + MAIL + "." + user + ";";
        try {
            resultSet = statement.executeQuery(getRows);
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String message = resultSet.getString(2);
                String fromOrTo = resultSet.getString(3);
                String status = resultSet.getString(4);
                String date = resultSet.getString(5);
                String have_read = resultSet.getString(6);
                table.addRow(new Object[]{id,message,fromOrTo,status,date,have_read});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error reading mail box" + e);
        }
    }

    public static void loadCustomerTable(DefaultTableModel table) {
        String query = "select * from " + COMMON + ".customers ;";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String branch = resultSet.getString(4);
                String date_created = resultSet.getString(5);
                String last_interest_update = resultSet.getString(6);
                String balance = resultSet.getString(7);
                String blocked = resultSet.getString(8);
                table.addRow(new Object[]{id,username,password,branch,date_created,last_interest_update,balance,blocked});
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error reading customers table " + e);
            return;
        }
    }

    public static void billsLog(DefaultTableModel table, String bill) {
        String query = "select * from " + BILLS_LOGS + "." + bill.toLowerCase() + ";";
        try {
            resultSet = statement.executeQuery(query);
            if(!resultSet.next()){
                return;
            }
            do {
                String id = resultSet.getString(1);
                String from = resultSet.getString(2);
                String amount = resultSet.getString(3);
                String account = resultSet.getString(4);
                String transactionDate = resultSet.getString(5);
                table.addRow(new Object[]{id,from,amount,account,transactionDate});
            }while(resultSet.next());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error reading bill log " + e);
            e.printStackTrace();
        }
    }

    public static String[] loginCheck(String username, String password) {

        String query = "select branch, balance, is_blocked from " + COMMON + ".customers where username = '" + username + "' and password = '" + password + "';";

        try {
            resultSet = statement.executeQuery(query);
            if (!resultSet.next()) {
                return new String[]{"not"};
            } else {
                String branch = resultSet.getString(1);
                String balance = resultSet.getString(2);
                String isBlocked = resultSet.getString(3);
                if(isBlocked.equals("true")){
                    return new String[]{"blocked", branch, balance};
                }
                return new String[]{"found", branch, balance};
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error reading usernames and passwords" + e);
            System.exit(0);
        }
        return new String[]{"not"};
    }

    public static void generateInterest() {
        double rate = getRate();
        List<String> customers = new ArrayList<>();
        String query = "select username from " + COMMON + "." + "customers ;";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if(resultSet.getString(1).toLowerCase().equals("admin")){
                    continue;
                }
                customers.add(resultSet.getString(1));
            }
            updateCustomersBalance(customers, rate);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error reading users " + e);
        }
    }

    private static void updateCustomersBalance(List<String> customers, double rate) {
        for (String user : customers) {
            String got = "select balance,last_interest_update from " + COMMON + ".customers where username = '" + user + "';";
            try {
                resultSet = statement.executeQuery(got);
                if(!resultSet.next()){
                    return;
                }
                String gotBalance = resultSet.getString(1);
                String lastUpdateDate = resultSet.getString(2);
                double add = Common.generateInterest(Double.parseDouble(gotBalance), rate, lastUpdateDate);
                if(add == 0){
                    return;
                }
                String today = Common.getToday();
                String newBalance = String.valueOf(Double.parseDouble(gotBalance) + add);
                statement.executeUpdate("UPDATE " + COMMON + ".customers" + " SET balance = " + newBalance + ", last_interest_update = " + today + " WHERE username = '" + user + "';");
                String query = "insert into " + CUSTOMER_LOGS + "." + user + " (transaction_date, amount, description) values ('" + today + "','" + String.valueOf(add) + "','interest');";
                statement.executeUpdate(query);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error getting balance " + e);
            }
        }
    }

    private static double getRate() {
        String interestQuery = "select rate,end_date from " + COMMON + ".interest ;";
        double rate = 0;
        try {
            resultSet = statement.executeQuery(interestQuery);
            String tempDate;
            while (resultSet.next()) {
                tempDate = resultSet.getString(2);
                if(Common.isNotExpiredDate(tempDate)){
                    rate = Double.parseDouble(resultSet.getString(1));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error reading interest rates " + e);
            return 0;
        }
        return rate;
    }

    private static boolean checkCustomer(String username) {
        String query = "select * from " + COMMON + ".customers where username = '" + username + "' ;";
        try {
            resultSet = statement.executeQuery(query);
            return resultSet.next();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error searching user " + e);
        }
        JOptionPane.showMessageDialog(null, "Error Occurred!");
        return true;
    }

    public static boolean newCustomer(String username, String password, String branch) {
        try {
            if (checkCustomer(username)) {
                JOptionPane.showMessageDialog(null, "Username is already exists!");
                return false;
            }
            String today = Common.getToday();
            String insertToCommon = "insert into " + COMMON + ".customers (username,password,branch,date_created,last_interest_update,balance,is_blocked) values " +
                    "('" + username + "','" + password + "','" + branch + "','" + today + "','" + today + "','0','false');";
            statement.executeUpdate(insertToCommon);

            String insertLog = "CREATE TABLE `" + CUSTOMER_LOGS + "`.`" + username + "` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `transaction_date` VARCHAR(45) NOT NULL,\n" +
                    "  `amount` VARCHAR(45) NOT NULL,\n" +
                    "  `description` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            statement.executeUpdate(insertLog);

            String billLog = "CREATE TABLE `" + CUSTOMER_BILLS + "`.`" + username + "` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `bill` VARCHAR(45) NOT NULL,\n" +
                    "  `bill_type` VARCHAR(45) NOT NULL,\n" +
                    "  `account` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            statement.executeUpdate(billLog);

            String mailCreate = "CREATE TABLE `" + MAIL + "`.`" + username + "` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `message` VARCHAR(45) NOT NULL,\n" +
                    "  `username` VARCHAR(45) NOT NULL,\n" +
                    "  `status` VARCHAR(45) NOT NULL,\n" +
                    "  `date` VARCHAR(45) NOT NULL,\n" +
                    "  `have_read` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            statement.executeUpdate(mailCreate);

            if(!username.toLowerCase().equals("admin")){
                JOptionPane.showMessageDialog(null, "Successfully Signed Up!");
            }
            return true;
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error reading customers table " + x);
            x.printStackTrace();
            return false;
        }
    }

    public static String updateBalanceAndGetNew(String username, double amount, String description) {
        boolean isMinus = description.equals("withdraw") || description.startsWith("pay");
        String getBalance = "select balance from " + COMMON + ".customers where username = '" + username + "' ;";
        double newBalance = 0;
        try {
            resultSet = statement.executeQuery(getBalance);
            if(resultSet.next()){
                getBalance = resultSet.getString(1);
            }
            if(isMinus){
                newBalance = Double.parseDouble(getBalance) - amount;
            }
            else{
                newBalance = Double.parseDouble(getBalance) + amount;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error getting user balance! " + e);
        }
        double correctAmount = (isMinus)? -amount: amount;
        String addLog = "insert into " + CUSTOMER_LOGS + "." + username + " (transaction_date,amount,description) values ('" + Common.getToday() + "','" + correctAmount + "','" + description + "');";
        String updateBalance = "update " + COMMON + ".customers set balance = " + newBalance + " where username = '" + username + "';";
        try {
            statement.executeUpdate(addLog);
            statement.executeUpdate(updateBalance);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error adding new log");
            return "";
        }
        return String.valueOf(newBalance);
    }

    public static void sendMoney(String username, double amount, String to) {
        if (!checkCustomer(to.toUpperCase())) {
            JOptionPane.showMessageDialog(null, "Cannot find the user!");
            return;
        }
        updateBalanceAndGetNew(username, amount, "sent to " + to);
        updateBalanceAndGetNew(to, amount, "received from " + username);
    }

    public static String[] getBillType() {
        List<String> list = new ArrayList<>();
        list.add("-- select type --");
        String query = "select bill_type from " + COMMON + ".bills ;";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String temp = resultSet.getString(1);
                if (!list.contains(temp.toUpperCase())) {
                    list.add(temp.toUpperCase());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error reading bill types " + e);
            return new String[]{};
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).toUpperCase();
        }
        Arrays.sort(result);
        return result;
    }

    public static String[] getBills(String bill_type) {
        List<String> list = new ArrayList<>();
        String query = "select bill from " + COMMON + ".bills where bill_type = '" + bill_type.toLowerCase() + "' ;";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String bill = resultSet.getString(1);
                if (!list.contains(bill.toUpperCase())) {
                    list.add(bill.toUpperCase());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error reading biils");
            return new String[]{};
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static boolean addNewBill(String username, String bill, String billType, String acc) {
        if (hasDuplicateBill(username, acc, bill)) {
            JOptionPane.showMessageDialog(null, "Already added bills");
            return false;
        }
        String addBill = "insert into " + CUSTOMER_BILLS + "." + username + " (bill,bill_type,account) values ('" + bill + "','" + billType + "','" + acc + "'); ";
        try {
            statement.executeUpdate(addBill);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error adding user's new bill " + e);
            return false;
        }
    }

    private static boolean hasDuplicateBill(String username, String acc, String bill) {
        String query = "select bill from " + CUSTOMER_BILLS + "." + username + " where account = '" + acc + "' ;";
        try {
            resultSet = statement.executeQuery(query);
            return resultSet.next();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error checking duplicate customer bills " + e);
            return true;
        }
    }

    public static void sendMail(String from, String to, String msg, boolean all) {

        String senderQuery = "insert into " + MAIL + "." + from + " (message,username,status,date,have_read) values ('" + msg + "','" + to + "','sent','" + Common.getToday() + "','--') ;";
        String receiverQuery = "insert into " + MAIL + "." + to + " (message,username,status,date,have_read) values ('" + msg + "','" + from + "','received','" + Common.getToday() + "','unread') ;";

        if (all) {
            try {
                senderQuery = "insert into " + MAIL + "." + from + " (message,username,status,date,have_read) values ('" + msg + "','ALL','sent','" + Common.getToday() + "','--') ;";
                statement.executeUpdate(senderQuery);
                String getUsers = "select username from '" + COMMON + "',customers' ;";
                resultSet = statement.executeQuery(getUsers);
                while (resultSet.next()) {
                    String username = resultSet.getString(1);
                    receiverQuery = "insert into " + MAIL + "." + to + " (message,username,status,date,have_read) values ('" + msg + "','ADMIN','received','" + Common.getToday() + "','unread') ;";
                    statement.executeUpdate(receiverQuery);
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error sending emails to all " + e);
                return;
            }
        }
        if (!checkCustomer(to)) {
            JOptionPane.showMessageDialog(null, "Cannot find receiver");
            return;
        }
        try {
            statement.executeUpdate(senderQuery);
            statement.executeUpdate(receiverQuery);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error sending emails " + e);
        }
    }

    public static void setReadOrUnread(String username, String[] ids, boolean toMarksAsRead) {
        String to = (toMarksAsRead) ? "read" : "unread";
        for (String id : ids) {
            String query = "update " + MAIL + "." + username + " set have_read = '" + to + "' where id = '" + id + "' ;";
            try {
                statement.executeUpdate(query);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error changing read/unread option " + e);
                return;
            }
        }
    }

    public static void deleteMails(String username, String[] ids) {
        for (String id : ids) {
            String query = "delete from " + MAIL + "." + username + " where id = " + Integer.parseInt(id) + ";";
            try {
                statement.executeUpdate(query);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error deleting emails " + e);
                return;
            }
        }
    }

    public static ArrayList<String[]> getUserBills(String username) {
        ArrayList<String[]> results = new ArrayList<>();
        String query = "select bill_type, bill from " + CUSTOMER_BILLS + "." + username + ";";
        try{
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String billType = resultSet.getString(1);;
                String bill = resultSet.getString(2);;
                results.add(new String[]{billType,bill});
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error getting user's bills " + e);
        }
        return results;
    }

    public static String payBills(String username, String amount, String billType, String bill) {
        String newBalance = updateBalanceAndGetNew(username,Double.parseDouble(amount),"pay-" + bill);
        String getAccount = "select account from " + CUSTOMER_BILLS + "." + username + " where bill = '" + bill.toLowerCase() + "';";
        try {
            resultSet = statement.executeQuery(getAccount);
            if(!resultSet.next()){
                return "0";
            }
            String account = resultSet.getString(1);
            String insertToBillLog = "insert into " + BILLS_LOGS + "." + bill.toLowerCase() + " (transaction_date,username,amount,account) values ('" + Common.getToday() + "','" + username + "','" + amount + "','" + account + "') ;";
            statement.executeUpdate(insertToBillLog);

            String currentBillBalance = "select balance from " + COMMON + ".bills where bill = '" + bill.toLowerCase() + "';";
            resultSet = statement.executeQuery(currentBillBalance);
            if(!resultSet.next()){
                return "0";
            }
            currentBillBalance = resultSet.getString(1);
            String newBillBalance = String.valueOf(Double.parseDouble(currentBillBalance) + Double.parseDouble(amount));
            String updateNewBillBalance = "update " + COMMON + ".bills set balance = '" + newBillBalance + "' where bill = '" + bill.toLowerCase() + "';";
            statement.executeUpdate(updateNewBillBalance);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error inserting pay bills log " + e);
        }
        return updateBalanceAndGetNew(username,Double.parseDouble(amount),"pay_" + bill);
    }

    public static void changePassword(String username, String newPassword, String current) {
        String passTest = "select password from " + COMMON + ".customers where username = '" + username + "';";
        try {
            resultSet = statement.executeQuery(passTest);
            if(!resultSet.next()){
                JOptionPane.showMessageDialog(null,"Error changing password at SQLMan,changePassword");
                return;
            }
            if(!resultSet.getString(1).equals(current)){
                JOptionPane.showMessageDialog(null,"Invalid current password!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String query = "update " + COMMON + ".customers set password = '" + newPassword + "' where username = '" + username + "';";
        try {
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Successfully changed password!");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error changing password! " + e);
        }
    }

    public static String[] getBillsSets() {
        List<String> results = new ArrayList<>();
        String query = "select bill from " + COMMON + ".bills ;";
        try {
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                results.add(resultSet.getString(1));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error reading common.bills logs " + e);
            return new String[0];
        }
        String[] billSet = new String[results.size()];
        for (int i = 0; i < results.size(); i++) {
            billSet[i] = results.get(i);
        }
        return billSet;
    }

    public static String[] getBillsOfBillType(String billType) {
        List<String> items = new ArrayList<>();
        String query = "select bill from " + COMMON + ".bills where bill_type = '" + billType + "';";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                items.add(resultSet.getString(1));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error reading common.bill " + e);
        }

        String[] results = new String[items.size()];
        for (int i = 0; i < items.size(); i++) {
            results[i] = items.get(i).toUpperCase();
        }
        Arrays.sort(results);
        return results;
    }

    public static boolean hasDuplicateBill(String name) {
        String query = "select * from " + COMMON + ".bills where bill = '" + name + "';";
        try {
            resultSet = statement.executeQuery(query);
            return resultSet.next();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error reading common.bill " + e);
        }
        JOptionPane.showMessageDialog(null, "Something wrong at SQLMan.hasDuplicateBill");
        return true;
    }

    public static void addNewBillByAdmin(String billType, String bill) {
        String insertToCommon = "insert into " + COMMON + ".bills (bill_type,bill,balance) values ('" + billType + "','" + bill + "','0' ) ;";
        String createTable = "CREATE TABLE `" + BILLS_LOGS + "`.`" + bill + "` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `username` VARCHAR(45) NOT NULL,\n" +
                "  `amount` VARCHAR(45) NOT NULL,\n" +
                "  `account` VARCHAR(45) NOT NULL,\n" +
                "  `transaction_date` VARCHAR(45) NOT NULL,\n" +
                "  PRIMARY KEY (`id`));";
        try {
            statement.executeUpdate(insertToCommon);
            statement.executeUpdate(createTable);
            JOptionPane.showMessageDialog(null, "Successfully added new bill");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error adding new bill in Admin " + e);
        }
    }

    public static boolean deleteBill(String bill) {
        String query = "delete from " + COMMON + ".bills where bill = '" + bill + "';";
        String dropTable = "drop table " + BILLS_LOGS + "." + bill + ";";
        try {
            statement.executeUpdate(query);
            statement.executeUpdate(dropTable);
            JOptionPane.showMessageDialog(null, "Successfully deleted bill");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error deleting bill " + e);
            return false;
        }
    }

    public static boolean addNewInterest(double rate, String endData) {
        endData = endData.replace(endData.split("-")[1],String.valueOf(Common.indexWithMonths.get(endData.split("-")[1].toLowerCase())));
        String query = "insert into " + COMMON + ".interest (rate,update_date,end_date) values ('" + String.valueOf(rate) + "','" + Common.getToday() + "','" + endData + "');";
        try {
            statement.executeUpdate(query);
            return true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error inserting new interest rate " + e);
            return false;
        }
    }

    public static String calculateBalanceAndUpdateCommonCustomerTable(String username) {
        String getRecords = "select amount from " + CUSTOMER_LOGS + "." + username + ";";
        double tempBalance = 0;
        try{
            resultSet = statement.executeQuery(getRecords);
            while (resultSet.next()){
                tempBalance += Double.parseDouble(resultSet.getString(1));
            }
            String updateCommonTable = "update " + COMMON + ".customers set balance = '" + tempBalance + "' where username = '" + username + "';";
            statement.executeUpdate(updateCommonTable);
            return String.valueOf(tempBalance);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error reading balance records and update common.customer balance " + e);
            return "0";
        }
    }

    public static void deleteCustomers(String[] ids) {
        for(String id : ids){
            if(avoidAdminRemovingAndDeleting(id)){
                continue;
            }
            String query = "delete " + COMMON + ".customers where id = '" + id + "';";
            String getUsername = "select username from " + COMMON + ".customers where id = '" + id +"';";
            try {
                resultSet = statement.executeQuery(getUsername);
                if(!resultSet.next()){
                    return;
                }
                String username = resultSet.getString(1);
                String dropLogs = "DROP TABLE " + CUSTOMER_LOGS + "." + username + ";";
                String dropBills = "DROP TABLE " + CUSTOMER_BILLS + "." + username + ";";

                statement.executeUpdate(dropLogs);
                statement.executeUpdate(dropBills);
                statement.executeUpdate(query);
            }catch (Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error deleting customers " + e );
            }
        }
    }

    public static void blockAndUnblock(String[] ids, boolean toBlock) {
        String status = (toBlock)? "true":"false";
        for(String id : ids){
            if(avoidAdminRemovingAndDeleting(id)){
                continue;
            }
            String query = "update " + COMMON + ".customers set is_blocked = '" + status + "' where id = " + id + ";";
            try {
                statement.executeUpdate(query);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Error blocking/unblocking querying " + e);
                return;
            }
        }
    }

    private static boolean avoidAdminRemovingAndDeleting(String id) {
        String query = "select username from " + COMMON + ".customers where id = '" + id + "';";
        try {
            resultSet = statement.executeQuery(query);
            if(!resultSet.next()){
                return true;
            }
            if(resultSet.getString(1).toLowerCase().equals("admin")){
                JOptionPane.showMessageDialog(null,"You can't change yourself!");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static int getLastMailID(String username) {
        String query = "select id from " + MAIL + "." + username + ";";
        int last = 0, temp;
        try {
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                temp = Integer.parseInt(resultSet.getString(1));
                if(last < temp){
                    last = temp;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return last;
    }

    public static int getLastTransactionID(String username) {
        int last = 0;
        String query = "select id from " + CUSTOMER_LOGS + "." + username + ";";
        try {
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                if(last < Integer.parseInt(resultSet.getString(1))){
                    last = Integer.parseInt(resultSet.getString(1));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return last;
    }

    public static int getCustomersLastID() {
        int last = 0;
        String query = "select id from " + COMMON + "." + "customers";
        try {
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                if( last < Integer.parseInt(resultSet.getString(1)) ){
                    last = Integer.parseInt(resultSet.getString(1));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return last;
    }
}

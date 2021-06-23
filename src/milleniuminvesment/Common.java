/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milleniuminvesment;


import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Gayashan Pananwala
 */

public class Common {

    public static final String BANK_NAME = "MILLENNIUM INVESTMENT";

    private static final int NEXT_YEARS = 10;
    public static final int INTERVAL = 100;

    public static final String[] BILLS = {"CEB", "LECO", "AWM_CAPITAL_LEASING", "ABANS", "ARPICO", "IDEAL", "LB", "NATION_LANKA", "TRADE&INVESTMENTS", "VALLIBEL", "AIA", "CEYLINCO", "CEYBANK", "SRI_LANKA", "UNION", "AIRTEL", "DIALOG", "MOBITEL", "HUTCH", "SLT", "DIALOG_TV", "PEO_TV", "LANKABELL"};
    public static final String[] BILL_TYPES = {"ELECTRICITY", "ELECTRICITY", "FINANCE", "FINANCE", "FINANCE", "FINANCE", "FINANCE", "FINANCE", "FINANCE", "FINANCE", "INSURANCE", "INSURANCE", "INSURANCE", "INSURANCE", "INSURANCE", "TELEPHONE", "TELEPHONE", "TELEPHONE", "TELEPHONE", "TELEPHONE", "TELEPHONE", "TELEPHONE", "TELEPHONE", "WATER"};

    public static final String[] DISTRICTS = {"Ampara", "Anuradhapura", "Badulla", "Batticaloa", "Colombo", "Galle", "Gampaha", "Hambantota", "Jaffna", "Kalutara", "Kandy", "Kegalle", "Kilinochchi", "Kurunegala", "Mannar", "Matale", "Matara", "Monaragala", "Mullaitivu", "NuwaraEliya", "Polonnaruwa", "Puttalam", "Ratnapura", "Trincomalee", "Vavuniya"};

    private static HashMap<Integer, String> monthsWithIndex;
    public static HashMap<String, Integer> indexWithMonths;
    private static HashMap<Integer, Integer> monthDays;

    public static JLabel label;
    public static JProgressBar bar;
    public static int bar_value;
    public static JFrame loading;


    public static void fillHashMaps() {

        monthDays = new HashMap<>();
        monthsWithIndex = new HashMap<>();
        indexWithMonths = new HashMap<>();

        monthsWithIndex.put(1, "January");
        monthsWithIndex.put(2, "February");
        monthsWithIndex.put(3, "March");
        monthsWithIndex.put(4, "April");
        monthsWithIndex.put(5, "May");
        monthsWithIndex.put(6, "June");
        monthsWithIndex.put(7, "July");
        monthsWithIndex.put(8, "August");
        monthsWithIndex.put(9, "September");
        monthsWithIndex.put(10, "October");
        monthsWithIndex.put(11, "November");
        monthsWithIndex.put(12, "December");

        monthDays.put(1, 31);
        monthDays.put(2, 28);
        monthDays.put(3, 31);
        monthDays.put(4, 30);
        monthDays.put(5, 31);
        monthDays.put(6, 30);
        monthDays.put(7, 31);
        monthDays.put(8, 31);
        monthDays.put(9, 30);
        monthDays.put(10, 31);
        monthDays.put(11, 30);
        monthDays.put(12, 31);

        indexWithMonths.put("january", 1);
        indexWithMonths.put("february", 2);
        indexWithMonths.put("march", 3);
        indexWithMonths.put("april", 4);
        indexWithMonths.put("may", 5);
        indexWithMonths.put("june", 6);
        indexWithMonths.put("july", 7);
        indexWithMonths.put("august", 8);
        indexWithMonths.put("september", 9);
        indexWithMonths.put("october", 10);
        indexWithMonths.put("november", 11);
        indexWithMonths.put("december", 12);

        leapYearCorrection(Integer.parseInt(getToday().split("-")[1]));
    }

    public static void progressHandle(String description, int barVal){
        bar_value += barVal;
        bar.setValue(bar_value);
        loading.setTitle(BANK_NAME + " - " + description );
//        label.setText(description);
        try {
            Thread.sleep(INTERVAL);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

    }

    private static void leapYearCorrection(int year) {
        if (year % 4 == 0) {
            if (year % 400 == 0) {
                monthDays.put(2, 29);
            } else if (year % 100 == 0) {
                monthDays.put(2, 28);
            } else {
                monthDays.put(2, 29);
            }
        }
    }

    public static String[] getNextYears() {

        String[] nextYears = new String[NEXT_YEARS];
        nextYears[0] = "-select-";
        int thisYear = Integer.parseInt(getToday().split("-")[2]);
        for (int i = 1; i < NEXT_YEARS; i++) {
            nextYears[i] = String.valueOf(thisYear++);
        }
        return nextYears;
    }

    public static String[] getMonthDays(String selectedMonth, int year) {
        String[] monthDaysSet;

        String[] today = getToday().split("-");
        int todayDay = Integer.parseInt(today[0]);
        int todayMonth = Integer.parseInt(today[1]);
        int todayYear = Integer.parseInt(today[2]);

        int lastDay = monthDays.get(indexWithMonths.get(selectedMonth.toLowerCase()));
        int idx = 1;

        if (year == todayYear && todayMonth == indexWithMonths.get(selectedMonth.toLowerCase())) {
            monthDaysSet = new String[lastDay - todayDay + 1];
            monthDaysSet[0] = "-select-";
            while (++todayDay <= lastDay) {
                monthDaysSet[idx++] = String.valueOf(todayDay);
            }
        }else{
            monthDaysSet = new String[lastDay + 1];
            monthDaysSet[0] = "-select-";
            while(idx <= lastDay){
                monthDaysSet[idx] = String.valueOf(idx);
                idx++;
            }
        }

        return monthDaysSet;
    }

    public static String[] getNextMonths(String selectedYear) {
        String[] nextMonths;
        if (selectedYear.equals(getToday().split("-")[2])) {
            int thisMonthIndex = Integer.parseInt(getToday().split("-")[1]);
            nextMonths = new String[12 - thisMonthIndex + 1 + 1];
            nextMonths[0] = "-select-";
            int idx = 1;
            while (thisMonthIndex < 13) {
                nextMonths[idx++] = monthsWithIndex.get(thisMonthIndex++);
            }
        } else {
            nextMonths = new String[13];
            nextMonths[0] = "-select-";
            int idx = 1;
            while (idx < 13) {
                nextMonths[idx] = monthsWithIndex.get(idx);
                idx++;
            }
        }
        return nextMonths;
    }


    public static double generateInterest(double balance, double rate, String updateDate) {
        String[] today = getToday().split("-");
        String[] old = updateDate.split("-");
        int difference = 0;
        try {
            difference = (Integer.parseInt(today[2]) - Integer.parseInt(old[2])) * 12 + Integer.parseInt(today[1]) - Integer.parseInt(old[1]);
        }catch (Exception e){
            return 0;
        }
        return rate * balance * difference;
    }

    public static String getToday() {
        DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        String today = df.format(date);
        return today;
    }

    public static boolean isNotExpiredDate(String tempDate) {
        String[] checkingDateArray = tempDate.split("-");
        String[] todayArray = getToday().split("-");

        int checkDay = Integer.parseInt(checkingDateArray[0]);
        int checkMonth = Integer.parseInt(checkingDateArray[1]);
        int checkYear = Integer.parseInt(checkingDateArray[2]);

        int todayDay = Integer.parseInt(todayArray[0]);
        int todayMonth = Integer.parseInt(todayArray[1]);
        int todayYear = Integer.parseInt(todayArray[2]);

        if(todayYear < checkYear) {
            return true;
        }
        if(todayMonth < checkMonth){
            return true;
        }
        return todayDay <= checkDay;
    }
}




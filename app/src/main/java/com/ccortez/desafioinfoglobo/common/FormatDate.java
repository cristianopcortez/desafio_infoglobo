package com.ccortez.desafioinfoglobo.common;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormatDate {

    private static final String TAG = FormatDate.class.getSimpleName();

    public static String parseDate(String date_json) {

        String date;
        date = date_json.substring(0,10);
        date = date.substring(8,10)+"/"+date.substring(5,7)+"/"+date.substring(0,4);


        return date;
    }

    public static String parseHora(String hora) {

        hora = hora.substring(11,16);

        return hora;
    }

    public static int getHora(String hora){

        //hora = parseHora(hora);
        hora = hora.substring(0,2);
        return Integer.parseInt(hora);

    }

    public static int getMinutos(String hora){

        //hora = parseHora(hora);
        hora = hora.substring(3);
        return Integer.parseInt(hora);

    }

    public static int getDia(String hora){

        //hora = parseDate(hora);
        hora = hora.substring(0,2);
        return Integer.parseInt(hora);

    }

    public static int getMes(String hora){

        //hora = parseDate(hora);
        hora = hora.substring(3,5);
        return Integer.parseInt(hora);

    }

    public static int getAno(String hora){

        //hora = parseDate(hora);
        hora = hora.substring(6,10);
        return Integer.parseInt(hora);

    }

    public static boolean isDataIgual(int diaEvento, int mesEvento, int anoEvento){
        int diaAparelho = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int mesAparelho = Calendar.getInstance().get(Calendar.MONTH)+1;
        int anoAparelho = Calendar.getInstance().get(Calendar.YEAR);


        if (anoAparelho == anoEvento && mesAparelho == mesEvento && diaAparelho == diaEvento)
            return true;
        return false;
    }

    public static Date getJavaDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        try {
            sdf.setLenient(false);   // this is important!
//            return sdf.parse(date + " " + hour);
            return sdf.parse(date);
        } catch (ParseException e) {
            Log.e(TAG, "erro formatando data. Parametros com problema", e);
        }
        return null;
    }

    public static Date getJavaDateBR(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            sdf.setLenient(false);   // this is important!
//            return sdf.parse(date + " " + hour);
            return sdf.parse(date);
        } catch (ParseException e) {
            Log.e(TAG, "erro formatando data. Parametros com problema", e);
        }
        return null;
    }

    public static Date getJavaDateBRZeroHour(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            sdf.setLenient(false);   // this is important!
//            return sdf.parse(date + " " + hour);
            return sdf.parse(date);
        } catch (ParseException e) {
            Log.e(TAG, "erro formatando data. Parametros com problema", e);
        }
        return null;
    }

    public static Date getJavaDateFromRemote(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            sdf.setLenient(false);   // this is important!
//            return sdf.parse(date + " " + hour);
            return sdf.parse(date);
        } catch (ParseException e) {
            Log.e(TAG, "erro formatando data. Parametros com problema", e);
        }
        return null;
    }

    public static String getStringFromDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(date);
//        System.out.println("Converted String: " + strDate);
        return strDate;
    }

    public static String getStringHourFromDate(Date date){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String res = dateFormat.format(date);
        return res;
    }

    public static String getStringFromDate(Date date, String regexPattern) {
        DateFormat dateFormat = new SimpleDateFormat(regexPattern);
        String strDate = dateFormat.format(date);
//        System.out.println("Converted String: " + strDate);
        return strDate;
    }

    public static String getStringHoursFromDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm");
        String strDate = dateFormat.format(date);
//        System.out.println("Converted String: " + strDate);
        return strDate;
    }

}

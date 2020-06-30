package fr.sg.poc.kata.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {

    public Utilities() {
        super();
    }

    /**
     * Pour avoir la date.
     * @return
     */
    public static Date getCurrentDate() {
        long time = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultdate = new Date(time);
        return resultdate;
    }

    /**
     * Pour lire le choix des clients de la console.
     * @return
     */
    public static String MenuChoice() {

        String inputString = null;
        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            inputString = bufferRead.readLine();
        }catch(IOException ex)
        {
            ex.printStackTrace();
        }
        return inputString;
    }
}

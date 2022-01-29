package com.jexample.pocketdecoder.utils.tables;

import com.jexample.pocketdecoder.utils.Constants;

import java.util.Hashtable;

public class ChaldeanTable {

    private static ChaldeanTable instance;
    private final Hashtable<Character, Integer> CHALDEAN_HASH_TABLE = new Hashtable<>();

    private ChaldeanTable() {
        CHALDEAN_HASH_TABLE.put(Constants.A, 1);
        CHALDEAN_HASH_TABLE.put(Constants.B, 2);
        CHALDEAN_HASH_TABLE.put(Constants.C, 3);
        CHALDEAN_HASH_TABLE.put(Constants.D, 4);
        CHALDEAN_HASH_TABLE.put(Constants.E, 5);
        CHALDEAN_HASH_TABLE.put(Constants.F, 8);
        CHALDEAN_HASH_TABLE.put(Constants.G, 3);
        CHALDEAN_HASH_TABLE.put(Constants.H, 5);
        CHALDEAN_HASH_TABLE.put(Constants.I, 1);
        CHALDEAN_HASH_TABLE.put(Constants.J, 1);
        CHALDEAN_HASH_TABLE.put(Constants.K, 2);
        CHALDEAN_HASH_TABLE.put(Constants.L, 3);
        CHALDEAN_HASH_TABLE.put(Constants.M, 4);
        CHALDEAN_HASH_TABLE.put(Constants.N, 5);
        CHALDEAN_HASH_TABLE.put(Constants.O, 7);
        CHALDEAN_HASH_TABLE.put(Constants.P, 8);
        CHALDEAN_HASH_TABLE.put(Constants.Q, 1);
        CHALDEAN_HASH_TABLE.put(Constants.R, 2);
        CHALDEAN_HASH_TABLE.put(Constants.S, 3);
        CHALDEAN_HASH_TABLE.put(Constants.T, 4);
        CHALDEAN_HASH_TABLE.put(Constants.U, 6);
        CHALDEAN_HASH_TABLE.put(Constants.V, 6);
        CHALDEAN_HASH_TABLE.put(Constants.W, 6);
        CHALDEAN_HASH_TABLE.put(Constants.X, 5);
        CHALDEAN_HASH_TABLE.put(Constants.Y, 1);
        CHALDEAN_HASH_TABLE.put(Constants.Z, 7);
    }

    public static ChaldeanTable getInstance() {
        if (instance == null) {
            instance = new ChaldeanTable();
        }
        return instance;
    }

    public String getChaldeanEquation(String word) {
        int result = 0;
        String equation = "";

        char[] wordInChars = word.toUpperCase().toCharArray();
        if (wordInChars.length > 0) {
            for (int i = 0; i < wordInChars.length; i++) {
                if (equation.equals(""))
                    equation = String.valueOf(CHALDEAN_HASH_TABLE.get(wordInChars[i]));
                else
                    equation = equation + "+" + CHALDEAN_HASH_TABLE.get(wordInChars[i]);
                result += CHALDEAN_HASH_TABLE.get(wordInChars[i]);
            }
        }
        return equation + " = " + result;
    }

    public String getChaldeanResult(String word) {
        int result = 0;

        char[] wordInChars = word.toUpperCase().toCharArray();
        if (wordInChars.length > 0) {
            for (int i = 0; i < wordInChars.length; i++) {
                result += CHALDEAN_HASH_TABLE.get(wordInChars[i]);
            }
        }
        return String.valueOf(result);
    }

}

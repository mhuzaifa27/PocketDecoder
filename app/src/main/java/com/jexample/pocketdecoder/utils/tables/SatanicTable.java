package com.jexample.pocketdecoder.utils.tables;

import com.jexample.pocketdecoder.utils.Constants;

import java.util.Hashtable;

public class SatanicTable {

    private static SatanicTable instance;
    private final Hashtable<Character, Integer> SATANIC_HASH_TABLE = new Hashtable<>();

    private SatanicTable() {
        SATANIC_HASH_TABLE.put(Constants.A, 36);
        SATANIC_HASH_TABLE.put(Constants.B, 37);
        SATANIC_HASH_TABLE.put(Constants.C, 38);
        SATANIC_HASH_TABLE.put(Constants.D, 39);
        SATANIC_HASH_TABLE.put(Constants.E, 40);
        SATANIC_HASH_TABLE.put(Constants.F, 41);
        SATANIC_HASH_TABLE.put(Constants.G, 42);
        SATANIC_HASH_TABLE.put(Constants.H, 43);
        SATANIC_HASH_TABLE.put(Constants.I, 44);
        SATANIC_HASH_TABLE.put(Constants.J, 45);
        SATANIC_HASH_TABLE.put(Constants.K, 46);
        SATANIC_HASH_TABLE.put(Constants.L, 47);
        SATANIC_HASH_TABLE.put(Constants.M, 48);
        SATANIC_HASH_TABLE.put(Constants.N, 49);
        SATANIC_HASH_TABLE.put(Constants.O, 50);
        SATANIC_HASH_TABLE.put(Constants.P, 51);
        SATANIC_HASH_TABLE.put(Constants.Q, 52);
        SATANIC_HASH_TABLE.put(Constants.R, 53);
        SATANIC_HASH_TABLE.put(Constants.S, 54);
        SATANIC_HASH_TABLE.put(Constants.T, 55);
        SATANIC_HASH_TABLE.put(Constants.U, 56);
        SATANIC_HASH_TABLE.put(Constants.V, 57);
        SATANIC_HASH_TABLE.put(Constants.W, 58);
        SATANIC_HASH_TABLE.put(Constants.X, 59);
        SATANIC_HASH_TABLE.put(Constants.Y, 60);
        SATANIC_HASH_TABLE.put(Constants.Z, 61);
    }

    public static SatanicTable getInstance() {
        if (instance == null) {
            instance = new SatanicTable();
        }
        return instance;
    }

    public String getSatanicEquation(String word) {
        int result = 0;
        String equation = "";

        char[] wordInChars = word.toUpperCase().toCharArray();
        if (wordInChars.length > 0) {
            for (int i = 0; i < wordInChars.length; i++) {
                if (wordInChars[i] != ' ') {
                    if (equation.equals(""))
                        equation = String.valueOf(SATANIC_HASH_TABLE.get(wordInChars[i]));
                    else
                        equation = equation + "+" + SATANIC_HASH_TABLE.get(wordInChars[i]);
                    result += SATANIC_HASH_TABLE.get(wordInChars[i]);
                }
            }
        }
        return "= " + equation;
    }

    public String getEngExtResult(String word) {
        int result = 0;

        char[] wordInChars = word.toUpperCase().toCharArray();
        if (wordInChars.length > 0) {
            for (int i = 0; i < wordInChars.length; i++) {
                if (wordInChars[i] != ' ')
                    result += SATANIC_HASH_TABLE.get(wordInChars[i]);
            }
        }
        return String.valueOf(result);
    }

}

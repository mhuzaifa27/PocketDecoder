package com.jexample.pocketdecoder.utils.tables;

import com.jexample.pocketdecoder.utils.Constants;

import java.util.Hashtable;

public class OrdinalTable {

    private static OrdinalTable instance;
    private final Hashtable<Character, Integer> ORDINAL_HASH_TABLE = new Hashtable<>();

    private OrdinalTable() {
        ORDINAL_HASH_TABLE.put(Constants.A, 1);
        ORDINAL_HASH_TABLE.put(Constants.B, 2);
        ORDINAL_HASH_TABLE.put(Constants.C, 3);
        ORDINAL_HASH_TABLE.put(Constants.D, 4);
        ORDINAL_HASH_TABLE.put(Constants.E, 5);
        ORDINAL_HASH_TABLE.put(Constants.F, 6);
        ORDINAL_HASH_TABLE.put(Constants.G, 7);
        ORDINAL_HASH_TABLE.put(Constants.H, 8);
        ORDINAL_HASH_TABLE.put(Constants.I, 9);
        ORDINAL_HASH_TABLE.put(Constants.J, 10);
        ORDINAL_HASH_TABLE.put(Constants.K, 11);
        ORDINAL_HASH_TABLE.put(Constants.L, 12);
        ORDINAL_HASH_TABLE.put(Constants.M, 13);
        ORDINAL_HASH_TABLE.put(Constants.N, 14);
        ORDINAL_HASH_TABLE.put(Constants.O, 15);
        ORDINAL_HASH_TABLE.put(Constants.P, 16);
        ORDINAL_HASH_TABLE.put(Constants.Q, 17);
        ORDINAL_HASH_TABLE.put(Constants.R, 18);
        ORDINAL_HASH_TABLE.put(Constants.S, 19);
        ORDINAL_HASH_TABLE.put(Constants.T, 20);
        ORDINAL_HASH_TABLE.put(Constants.U, 21);
        ORDINAL_HASH_TABLE.put(Constants.V, 22);
        ORDINAL_HASH_TABLE.put(Constants.W, 23);
        ORDINAL_HASH_TABLE.put(Constants.X, 24);
        ORDINAL_HASH_TABLE.put(Constants.Y, 25);
        ORDINAL_HASH_TABLE.put(Constants.Z, 26);
    }

    public static OrdinalTable getInstance() {
        if (instance == null) {
            instance = new OrdinalTable();
        }
        return instance;
    }
    public String getOrdinalEquation(String word) {
        int result = 0;
        String equation = "";

        char[] wordInChars = word.toUpperCase().toCharArray();
        if (wordInChars.length > 0) {
            for (int i = 0; i < wordInChars.length; i++) {
                if (wordInChars[i] != ' ') {
                    if (equation.equals(""))
                        equation = String.valueOf(ORDINAL_HASH_TABLE.get(wordInChars[i]));
                    else
                        equation = equation + "+" + ORDINAL_HASH_TABLE.get(wordInChars[i]);
                    result += ORDINAL_HASH_TABLE.get(wordInChars[i]);
                }
            }
        }
        return  "= " + equation;
    }

    public String getOrdinalResult(String word) {
        int result = 0;

        char[] wordInChars = word.toUpperCase().toCharArray();
        if (wordInChars.length > 0) {
            for (int i = 0; i < wordInChars.length; i++) {
                if (wordInChars[i] != ' ')
                    result += ORDINAL_HASH_TABLE.get(wordInChars[i]);
            }
        }
        return String.valueOf(result);
    }

}

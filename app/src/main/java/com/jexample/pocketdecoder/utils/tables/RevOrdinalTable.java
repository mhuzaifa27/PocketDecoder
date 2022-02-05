package com.jexample.pocketdecoder.utils.tables;

import com.jexample.pocketdecoder.utils.Constants;

import java.util.Hashtable;

public class RevOrdinalTable {

    private static RevOrdinalTable instance;
    private final Hashtable<Character, Integer> REV_ORDINAL_HASH_TABLE = new Hashtable<>();

    private RevOrdinalTable() {
        REV_ORDINAL_HASH_TABLE.put(Constants.A, 26);
        REV_ORDINAL_HASH_TABLE.put(Constants.B, 25);
        REV_ORDINAL_HASH_TABLE.put(Constants.C, 24);
        REV_ORDINAL_HASH_TABLE.put(Constants.D, 23);
        REV_ORDINAL_HASH_TABLE.put(Constants.E, 22);
        REV_ORDINAL_HASH_TABLE.put(Constants.F, 21);
        REV_ORDINAL_HASH_TABLE.put(Constants.G, 20);
        REV_ORDINAL_HASH_TABLE.put(Constants.H, 19);
        REV_ORDINAL_HASH_TABLE.put(Constants.I, 18);
        REV_ORDINAL_HASH_TABLE.put(Constants.J, 17);
        REV_ORDINAL_HASH_TABLE.put(Constants.K, 16);
        REV_ORDINAL_HASH_TABLE.put(Constants.L, 15);
        REV_ORDINAL_HASH_TABLE.put(Constants.M, 14);
        REV_ORDINAL_HASH_TABLE.put(Constants.N, 13);
        REV_ORDINAL_HASH_TABLE.put(Constants.O, 12);
        REV_ORDINAL_HASH_TABLE.put(Constants.P, 11);
        REV_ORDINAL_HASH_TABLE.put(Constants.Q, 10);
        REV_ORDINAL_HASH_TABLE.put(Constants.R, 9);
        REV_ORDINAL_HASH_TABLE.put(Constants.S, 8);
        REV_ORDINAL_HASH_TABLE.put(Constants.T, 7);
        REV_ORDINAL_HASH_TABLE.put(Constants.U, 6);
        REV_ORDINAL_HASH_TABLE.put(Constants.V, 5);
        REV_ORDINAL_HASH_TABLE.put(Constants.W, 4);
        REV_ORDINAL_HASH_TABLE.put(Constants.X, 3);
        REV_ORDINAL_HASH_TABLE.put(Constants.Y, 2);
        REV_ORDINAL_HASH_TABLE.put(Constants.Z, 1);
    }

    public static RevOrdinalTable getInstance() {
        if (instance == null) {
            instance = new RevOrdinalTable();
        }
        return instance;
    }

    public String getRevOrdinalEquation(String word) {
        int result = 0;
        String equation = "";

        char[] wordInChars = word.toUpperCase().toCharArray();
        if (wordInChars.length > 0) {
            for (int i = 0; i < wordInChars.length; i++) {
                if (wordInChars[i] != ' ') {
                    if (equation.equals(""))
                        equation = String.valueOf(REV_ORDINAL_HASH_TABLE.get(wordInChars[i]));
                    else
                        equation = equation + "+" + REV_ORDINAL_HASH_TABLE.get(wordInChars[i]);
                    result += REV_ORDINAL_HASH_TABLE.get(wordInChars[i]);
                }
            }
        }
        return "= " + equation;
    }

    public String getRevOrdinalResult(String word) {
        int result = 0;

        char[] wordInChars = word.toUpperCase().toCharArray();
        if (wordInChars.length > 0) {
            for (int i = 0; i < wordInChars.length; i++) {
                if (wordInChars[i] != ' ')
                    result += REV_ORDINAL_HASH_TABLE.get(wordInChars[i]);
            }
        }
        return String.valueOf(result);
    }

}

package com.jexample.pocketdecoder.utils.tables;

import com.jexample.pocketdecoder.utils.Constants;

import java.util.Hashtable;

public class SumerianTable {

    private static SumerianTable instance;
    private final Hashtable<Character, Integer> SUMERIAN_HASH_TABLE = new Hashtable<>();

    private SumerianTable() {
        SUMERIAN_HASH_TABLE.put(Constants.A, 6);
        SUMERIAN_HASH_TABLE.put(Constants.B, 12);
        SUMERIAN_HASH_TABLE.put(Constants.C, 18);
        SUMERIAN_HASH_TABLE.put(Constants.D, 24);
        SUMERIAN_HASH_TABLE.put(Constants.E, 30);
        SUMERIAN_HASH_TABLE.put(Constants.F, 36);
        SUMERIAN_HASH_TABLE.put(Constants.G, 42);
        SUMERIAN_HASH_TABLE.put(Constants.H, 48);
        SUMERIAN_HASH_TABLE.put(Constants.I, 54);
        SUMERIAN_HASH_TABLE.put(Constants.J, 60);
        SUMERIAN_HASH_TABLE.put(Constants.K, 66);
        SUMERIAN_HASH_TABLE.put(Constants.L, 72);
        SUMERIAN_HASH_TABLE.put(Constants.M, 78);
        SUMERIAN_HASH_TABLE.put(Constants.N, 84);
        SUMERIAN_HASH_TABLE.put(Constants.O, 90);
        SUMERIAN_HASH_TABLE.put(Constants.P, 96);
        SUMERIAN_HASH_TABLE.put(Constants.Q, 102);
        SUMERIAN_HASH_TABLE.put(Constants.R, 108);
        SUMERIAN_HASH_TABLE.put(Constants.S, 114);
        SUMERIAN_HASH_TABLE.put(Constants.T, 120);
        SUMERIAN_HASH_TABLE.put(Constants.U, 126);
        SUMERIAN_HASH_TABLE.put(Constants.V, 132);
        SUMERIAN_HASH_TABLE.put(Constants.W, 138);
        SUMERIAN_HASH_TABLE.put(Constants.X, 144);
        SUMERIAN_HASH_TABLE.put(Constants.Y, 150);
        SUMERIAN_HASH_TABLE.put(Constants.Z, 156);
    }

    public static SumerianTable getInstance() {
        if (instance == null) {
            instance = new SumerianTable();
        }
        return instance;
    }

    public String getSumerianEquation(String word) {
        int result = 0;
        String equation = "";

        char[] wordInChars = word.toUpperCase().toCharArray();
        if (wordInChars.length > 0) {
            for (int i = 0; i < wordInChars.length; i++) {
                if (wordInChars[i] != ' ') {
                    if (equation.equals("")) {
                        equation = String.valueOf(SUMERIAN_HASH_TABLE.get(wordInChars[i]));
                    } else {
                        equation = equation + "+" + SUMERIAN_HASH_TABLE.get(wordInChars[i]);
                    }
                    result += SUMERIAN_HASH_TABLE.get(wordInChars[i]);
                }
            }
        }
        return "= " + equation;
    }

    public String getSumerianResult(String word) {
        int result = 0;

        char[] wordInChars = word.toUpperCase().toCharArray();
        if (wordInChars.length > 0) {
            for (int i = 0; i < wordInChars.length; i++) {
                if (wordInChars[i] != ' ')
                    result += SUMERIAN_HASH_TABLE.get(wordInChars[i]);
            }
        }
        return String.valueOf(result);
    }

}

package com.jexample.pocketdecoder.utils.tables;

import com.jexample.pocketdecoder.utils.Constants;

import java.util.Hashtable;

public class RevSumerianTable {

    private static RevSumerianTable instance;
    private final Hashtable<Character, Integer> REV_SUMERIAN_HASH_TABLE = new Hashtable<>();

    private RevSumerianTable() {
        REV_SUMERIAN_HASH_TABLE.put(Constants.A, 156);
        REV_SUMERIAN_HASH_TABLE.put(Constants.B, 150);
        REV_SUMERIAN_HASH_TABLE.put(Constants.C, 144);
        REV_SUMERIAN_HASH_TABLE.put(Constants.D, 138);
        REV_SUMERIAN_HASH_TABLE.put(Constants.E, 132);
        REV_SUMERIAN_HASH_TABLE.put(Constants.F, 126);
        REV_SUMERIAN_HASH_TABLE.put(Constants.G, 120);
        REV_SUMERIAN_HASH_TABLE.put(Constants.H, 114);
        REV_SUMERIAN_HASH_TABLE.put(Constants.I, 108);
        REV_SUMERIAN_HASH_TABLE.put(Constants.J, 102);
        REV_SUMERIAN_HASH_TABLE.put(Constants.K, 96);
        REV_SUMERIAN_HASH_TABLE.put(Constants.L, 90);
        REV_SUMERIAN_HASH_TABLE.put(Constants.M, 84);
        REV_SUMERIAN_HASH_TABLE.put(Constants.N, 78);
        REV_SUMERIAN_HASH_TABLE.put(Constants.O, 72);
        REV_SUMERIAN_HASH_TABLE.put(Constants.P, 66);
        REV_SUMERIAN_HASH_TABLE.put(Constants.Q, 60);
        REV_SUMERIAN_HASH_TABLE.put(Constants.R, 54);
        REV_SUMERIAN_HASH_TABLE.put(Constants.S, 48);
        REV_SUMERIAN_HASH_TABLE.put(Constants.T, 42);
        REV_SUMERIAN_HASH_TABLE.put(Constants.U, 36);
        REV_SUMERIAN_HASH_TABLE.put(Constants.V, 30);
        REV_SUMERIAN_HASH_TABLE.put(Constants.W, 24);
        REV_SUMERIAN_HASH_TABLE.put(Constants.X, 18);
        REV_SUMERIAN_HASH_TABLE.put(Constants.Y, 12);
        REV_SUMERIAN_HASH_TABLE.put(Constants.Z, 6);
    }

    public static RevSumerianTable getInstance() {
        if (instance == null) {
            instance = new RevSumerianTable();
        }
        return instance;
    }

    public String getRevSumerianEquation(String word) {
        int result = 0;
        String equation = "";

        char[] wordInChars = word.toUpperCase().toCharArray();
        if (wordInChars.length > 0) {
            for (int i = 0; i < wordInChars.length; i++) {
                if (equation.equals(""))
                    equation = String.valueOf(REV_SUMERIAN_HASH_TABLE.get(wordInChars[i]));
                else
                    equation = equation + "+" + REV_SUMERIAN_HASH_TABLE.get(wordInChars[i]);
                result += REV_SUMERIAN_HASH_TABLE.get(wordInChars[i]);
            }
        }
        return equation + " = " + result;
    }
    public String getRevSumerianResult(String word) {
        int result = 0;

        char[] wordInChars = word.toUpperCase().toCharArray();
        if (wordInChars.length > 0) {
            for (int i = 0; i < wordInChars.length; i++) {
                result += REV_SUMERIAN_HASH_TABLE.get(wordInChars[i]);
            }
        }
        return String.valueOf(result);
    }

}

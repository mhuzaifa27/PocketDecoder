package com.jexample.pocketdecoder.utils.tables;

import com.jexample.pocketdecoder.utils.Constants;

import java.util.Hashtable;

public class EngExtTable {

    private static EngExtTable instance;
    private final Hashtable<Character, Integer> ENG_EXT_HASH_TABLE = new Hashtable<>();

    private EngExtTable() {
        ENG_EXT_HASH_TABLE.put(Constants.A, 1);
        ENG_EXT_HASH_TABLE.put(Constants.B, 2);
        ENG_EXT_HASH_TABLE.put(Constants.C, 3);
        ENG_EXT_HASH_TABLE.put(Constants.D, 4);
        ENG_EXT_HASH_TABLE.put(Constants.E, 5);
        ENG_EXT_HASH_TABLE.put(Constants.F, 6);
        ENG_EXT_HASH_TABLE.put(Constants.G, 7);
        ENG_EXT_HASH_TABLE.put(Constants.H, 8);
        ENG_EXT_HASH_TABLE.put(Constants.I, 9);
        ENG_EXT_HASH_TABLE.put(Constants.J, 10);
        ENG_EXT_HASH_TABLE.put(Constants.K, 20);
        ENG_EXT_HASH_TABLE.put(Constants.L, 30);
        ENG_EXT_HASH_TABLE.put(Constants.M, 40);
        ENG_EXT_HASH_TABLE.put(Constants.N, 50);
        ENG_EXT_HASH_TABLE.put(Constants.O, 60);
        ENG_EXT_HASH_TABLE.put(Constants.P, 70);
        ENG_EXT_HASH_TABLE.put(Constants.Q, 80);
        ENG_EXT_HASH_TABLE.put(Constants.R, 90);
        ENG_EXT_HASH_TABLE.put(Constants.S, 100);
        ENG_EXT_HASH_TABLE.put(Constants.T, 200);
        ENG_EXT_HASH_TABLE.put(Constants.U, 300);
        ENG_EXT_HASH_TABLE.put(Constants.V, 400);
        ENG_EXT_HASH_TABLE.put(Constants.W, 500);
        ENG_EXT_HASH_TABLE.put(Constants.X, 600);
        ENG_EXT_HASH_TABLE.put(Constants.Y, 700);
        ENG_EXT_HASH_TABLE.put(Constants.Z, 800);
    }

    public static EngExtTable getInstance() {
        if (instance == null) {
            instance = new EngExtTable();
        }
        return instance;
    }

    public String getEngExtEquation(String word) {
        int result = 0;
        String equation = "";

        char[] wordInChars = word.toUpperCase().toCharArray();
        if (wordInChars.length > 0) {
            for (int i = 0; i < wordInChars.length; i++) {
                if (equation.equals(""))
                    equation = String.valueOf(ENG_EXT_HASH_TABLE.get(wordInChars[i]));
                else
                    equation = equation + "+" + ENG_EXT_HASH_TABLE.get(wordInChars[i]);
                result += ENG_EXT_HASH_TABLE.get(wordInChars[i]);
            }
        }
        return equation + " = " + result;
    }
    public String getEngExtResult(String word) {
        int result = 0;

        char[] wordInChars = word.toUpperCase().toCharArray();
        if (wordInChars.length > 0) {
            for (int i = 0; i < wordInChars.length; i++) {
                result += ENG_EXT_HASH_TABLE.get(wordInChars[i]);
            }
        }
        return String.valueOf(result);
    }

}

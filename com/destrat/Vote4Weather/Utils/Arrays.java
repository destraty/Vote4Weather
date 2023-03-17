package com.destrat.Vote4Weather.Utils;

import java.util.ArrayList;

public class Arrays
{
    public static ArrayList<String> voters;
    public static ArrayList<String> votersClear;
    public static ArrayList<String> votersKeep;
    
    static {
        Arrays.voters = new ArrayList<String>();
        Arrays.votersClear = new ArrayList<String>();
        Arrays.votersKeep = new ArrayList<String>();
    }
    
    public static void clearArrays() {
        Arrays.voters.clear();
        Arrays.votersClear.clear();
        Arrays.votersKeep.clear();
    }
}

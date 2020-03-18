package com.timedafaculdade.quizpaises;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HandlePaises {
    private static final String TAG = "HandlePaises";

    public Map<List<String>, List<Integer>> getCountriesRandomly(int amount, CountriesDatabase db) {
        Map<String, Integer> map = db.getCountries();
        int mapSize = map.size();
        Log.d(TAG, "getTenCountriesRandomly: size of original countries map " + mapSize);


        List keys = Arrays.asList(map.keySet().toArray());
        List values = Arrays.asList(map.values().toArray());

        List<String> newKeys = new ArrayList<>();
        List<Integer> newValues = new ArrayList<>();

        Log.d(TAG, "getCountriesRandomly: size of new lists " + keys.size() + " " + values.size());

        for (int i = 0; i < amount; i++) {
            int rand = new Random().nextInt(mapSize);
            Log.i(TAG, "getCountriesRandomly: index we're on " + i + " rand generated " + rand);
            newKeys.add((String) keys.get(rand));
            newValues.add((Integer) values.get(rand));

        }
        Log.d(TAG, "getCountriesRandomly: size of newLists " + newKeys.size() + " " + newValues.size());

        Map<List<String>, List<Integer>> newMap = new HashMap<>();
        newMap.put(newKeys, newValues);
        return newMap;
    }

    public List<Questao> getQuestoes() {
        CountriesDatabase db = new CountriesDatabase();

        Map<List<String>, List<Integer>> map = getCountriesRandomly(40, db);
        List<Questao> questaoQueue = new ArrayList<>();

        List<String> nomePaises = new ArrayList<>();
        List<Integer> codigoPaises = new ArrayList<>();

        for (Map.Entry<List<String>, List<Integer>> v: map.entrySet()) {
            nomePaises.addAll(v.getKey());
            codigoPaises.addAll(v.getValue());
        }

        for (int i = 0; i < 10; i++) {
            int rand = new Random().nextInt(4);
            switch (rand) {
                case 0:
                    questaoQueue.add(new Questao(
                            nomePaises.get(i),
                            nomePaises.get(i + 10),
                            nomePaises.get(i + 20),
                            nomePaises.get(i + 30),
                            codigoPaises.get(i),
                            0
                    ));
                    break;
                case 1:
                    questaoQueue.add(new Questao(
                            nomePaises.get(i + 10),
                            nomePaises.get(i),
                            nomePaises.get(i + 20),
                            nomePaises.get(i + 30),
                            codigoPaises.get(i),
                            1
                    ));
                    break;
                case 2:
                    questaoQueue.add(new Questao(
                            nomePaises.get(i + 10),
                            nomePaises.get(i + 20),
                            nomePaises.get(i),
                            nomePaises.get(i + 30),
                            codigoPaises.get(i),
                            2
                    ));
                    break;
                case 3:
                    questaoQueue.add(new Questao(
                            nomePaises.get(i + 10),
                            nomePaises.get(i + 20),
                            nomePaises.get(i + 30),
                            nomePaises.get(i),
                            codigoPaises.get(i),
                            3
                    ));
                    break;
            }
        }
        Log.d(TAG, "getQuestoes: " + questaoQueue);
        return questaoQueue;
    }
}

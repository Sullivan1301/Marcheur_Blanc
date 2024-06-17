package com.hei.Marcheur_Blanc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carte {
    private Map<Lieu, List<Lieu>> adjList = new HashMap<>();

    public void ajouterLieu(Lieu lieu){
        adjList.putIfAbsent(lieu, new ArrayList<>());
    }

    public void ajouterRue(Rue rue){
        adjList.get(rue.getLieu1()).add(rue.getLieu2());
        adjList.get(rue.getLieu2()).add(rue.getLieu1());
    }

    public List<Lieu> getAdjacents(Lieu lieu){
        return adjList.getOrDefault(lieu, new ArrayList<>());
    }
}

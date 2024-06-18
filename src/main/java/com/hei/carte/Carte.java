package com.hei.carte;

import com.hei.Marcheur_Blanc.Lieu;
import com.hei.Marcheur_Blanc.Rue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carte {
    private final Map<Lieu, List<Lieu>> adjacence = new HashMap<>();

    public void ajouterLieu(Lieu lieu){
        adjacence.putIfAbsent(lieu, new ArrayList<>());
    }

    public void ajouterRue(Rue rue){
        adjacence.get(rue.getOrigine()).add(rue.getDestination());
        adjacence.get(rue.getDestination()).add(rue.getOrigine());
    }

    public List<Lieu> getAdjacents(Lieu lieu){
        return adjacence.getOrDefault(lieu, new ArrayList<>());
    }
}

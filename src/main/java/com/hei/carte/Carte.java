package com.hei.carte;

import com.hei.Marcheur_Blanc.Lieu;
import com.hei.Marcheur_Blanc.Rue;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Carte {
    @Getter
    private final List<Lieu> lieux = new ArrayList<>();
    @Getter
    private final List<Rue> rues = new ArrayList<>();

    public void ajouterLieu(Lieu lieu){
        if (!lieux.contains(lieu)){
            lieux.add(lieu);
        }
    }

    public void ajouterRue(Rue rue){
        if (!rues.contains(rue)){
            rues.add(rue);
            rue.getLieu1().ajouterLieuAdjacent(rue.getLieu2());
            rue.getLieu2().ajouterLieuAdjacent(rue.getLieu1());
        }
    }
}

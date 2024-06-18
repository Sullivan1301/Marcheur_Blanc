package com.hei.Marcheur_Blanc;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Lieu {
    private final String nom;
    private final List<Lieu> lieuxAdjacents = new ArrayList<>();

    @Override
    public String toString(){
        return nom;
    }

    public void ajouterLieuAdjacent(Lieu lieu) {
        lieuxAdjacents.add(lieu);
    }

}

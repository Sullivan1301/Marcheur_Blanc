package com.hei.Marcheur_Blanc;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Data
@Getter
@ToString(of = "nom")
@EqualsAndHashCode(exclude = "lieuxAdjacents")
public class Lieu {
    private final String nom;
    private final List<Lieu> lieuxAdjacents = new ArrayList<>();


    public void ajouterLieuAdjacent(Lieu lieu) {
       if(!lieuxAdjacents.contains(lieu)){
           lieuxAdjacents.add(lieu);
           lieu.ajouterLieuAdjacentInterne(this);
       }
    }
    private void ajouterLieuAdjacentInterne(Lieu lieu){
        lieuxAdjacents.add(lieu);
    }
}

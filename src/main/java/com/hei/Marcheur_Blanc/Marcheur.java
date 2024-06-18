package com.hei.Marcheur_Blanc;

import com.hei.carte.Carte;

import java.util.*;

public class Marcheur {
    private final Random random = new Random();

    public List<Lieu> trouverChemin(Carte carte, Lieu depart, Lieu destination) {
        List<Lieu> chemin = new ArrayList<>();
        chemin.add(depart);
        Set<Lieu> visites = new HashSet<>();
        visites.add(depart);

        if (explorer(carte, depart, destination, chemin, visites)){
            return chemin;
        } else {
            return Collections.emptyList();
        }
    }

    private boolean explorer(Carte carte, Lieu courant, Lieu destination, List<Lieu> chemin, Set<Lieu> visites){
        if (courant.equals(destination)){
            return true;
        }
        List<Lieu> adjacents = carte.getAdjacents(courant);
        Collections.shuffle(adjacents, random);

        for (Lieu prochain : adjacents){
            if (!visites.contains(prochain)){
                visites.add(prochain);
                chemin.add(prochain);
                if(explorer(carte, prochain, destination, chemin, visites)){
                    return true;
                }
                chemin.removeLast();
                visites.remove(prochain);
            }
        }
        return false;
    }

    public void marche(Carte carte, Lieu depart, Lieu destination) {
        List<Lieu> chemin = trouverChemin(carte, depart, destination);
        if (chemin.isEmpty()) {
            System.out.println("Aucun chemin trouvé de " + depart + " à " + destination);
        } else {
            System.out.println("Chemin emprunté : " + chemin);
        }
    }
  }

package com.hei.Marcheur_Blanc;

import com.hei.carte.Carte;

import java.util.*;

public class Marcheur {
    private final Random random = new Random();
    private final Carte carte = new Carte();

    public List<Lieu> trouverChemin(Lieu depart, Lieu destination) {
        List<Lieu> chemin = new ArrayList<>();
        chemin.add(depart);
        Set<Lieu> visites = new HashSet<>();
        visites.add(depart);

        carte.ajouterLieu(depart);

        if (explorer(depart, destination, chemin, visites)){
            return chemin;
        } else {
            return Collections.emptyList();
        }
    }

    private boolean explorer(Lieu courant, Lieu destination, List<Lieu> chemin, Set<Lieu> visites){
        if (courant.equals(destination)){
            return true;
        }
        List<Lieu> adjacents = carte.getLieuxAdjacents();
        Collections.shuffle(adjacents, random);

        for (Lieu prochain : adjacents){
            if (!visites.contains(prochain)){
                visites.add(prochain);
                chemin.add(prochain);
                carte.ajouterLieu(prochain);
                carte.ajouterRue(new Rue(courant, prochain));
                if(explorer(prochain, destination, chemin, visites)){
                    return true;
                }
                chemin.removeLast();
                visites.remove(prochain);
            }
        }
        return false;
    }

    public void marche(Lieu depart, Lieu destination) {
        List<Lieu> chemin = trouverChemin(depart, destination);
        if (chemin.isEmpty()) {
            System.out.println("Aucun chemin trouvé de " + depart + " à " + destination);
        } else {
            System.out.println("Chemin emprunté : " + chemin);
        }
        System.out.println("Carte decouverte: " + carte.getLieux() + " avec les rues " + carte.getRues());
    }
  }

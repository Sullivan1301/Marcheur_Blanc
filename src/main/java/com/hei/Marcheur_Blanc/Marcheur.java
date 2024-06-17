package com.hei.Marcheur_Blanc;

import java.util.*;

public class Marcheur {
    private final Random random = new Random();

    public List<Lieu> trouverChemin(Carte carte, Lieu depart, Lieu destination) {
        List<Lieu> chemin = new ArrayList<>();
        chemin.add(depart);
        Set<Lieu> visites = new HashSet<>();
        visites.add(depart);

        while (!chemin.get(chemin.size() - 1).equals(destination)) {
            Lieu dernierLieu = chemin.get(chemin.size() - 1);
            List<Lieu> adjacents = carte.getAdjacents(dernierLieu);
            adjacents.removeAll(visites);

            if (adjacents.isEmpty()) {
                chemin.remove(chemin.size() - 1);
                if (chemin.isEmpty()) {
                    System.out.println("Aucun chemin truvé de " + depart + " à " + destination);
                    return Collections.emptyList();
                }
            } else {
                Lieu prochainLieu = adjacents.get(random.nextInt(adjacents.size()));
                chemin.add(prochainLieu);
                visites.add(prochainLieu);
            }
        }
        return chemin;
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

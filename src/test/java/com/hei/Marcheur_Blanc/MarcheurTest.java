package com.hei.Marcheur_Blanc;

import org.junit.jupiter.api.Test;

public class MarcheurTest {

    @Test
    public void test_marche(){
        Carte carte = new Carte();
        Lieu hei = new Lieu("HEI");
        Lieu pullman = new Lieu("Pullman");
        Lieu sekolintsika = new Lieu("Sekolintsika");
        Lieu marais = new Lieu("Marais");
        Lieu balancoire = new Lieu("Balancoire");
        Lieu nexta = new Lieu("Nexta");
        Lieu esti = new Lieu("ESTI");
        Lieu boulevard_de_l_Europe = new Lieu("Boulevard de l Europe");

        carte.ajouterLieu(hei);
        carte.ajouterLieu(pullman);
        carte.ajouterLieu(sekolintsika);
        carte.ajouterLieu(marais);
        carte.ajouterLieu(balancoire);
        carte.ajouterLieu(nexta);
        carte.ajouterLieu(esti);
        carte.ajouterLieu(boulevard_de_l_Europe);

        carte.ajouterRue(new Rue(hei, pullman));
        carte.ajouterRue(new Rue(hei, sekolintsika));
        carte.ajouterRue(new Rue(sekolintsika, marais));
        carte.ajouterRue(new Rue(pullman, nexta));
        carte.ajouterRue(new Rue(pullman, balancoire ));
        carte.ajouterRue(new Rue(hei, balancoire));
        carte.ajouterRue(new Rue(balancoire, esti ));
        carte.ajouterRue(new Rue(balancoire, boulevard_de_l_Europe));
        carte.ajouterRue(new Rue(boulevard_de_l_Europe, esti));

        Marcheur sullivan = new Marcheur();
        sullivan.marche(carte, hei, esti);
    }

    @Test
    public void pas_de_chemin(){
        Carte carte = new Carte();
        Lieu hei = new Lieu("HEI");
        Lieu pullman = new Lieu("Pullman");
        Lieu esti = new Lieu("ESTI");

        carte.ajouterLieu(hei);
        carte.ajouterLieu(pullman);
        carte.ajouterLieu(esti);

        carte.ajouterRue(new Rue(hei, pullman));

        Marcheur nayah = new Marcheur();
        nayah.marche(carte, hei, esti);
    }

    @Test
    public void chemin_aleatoire_multiples_rues() {
        Carte carte = new Carte();
        Lieu hei = new Lieu("HEI");
        Lieu pullman = new Lieu("Pullman");
        Lieu balancoire = new Lieu("Balancoire");
        Lieu esti = new Lieu("ESTI");
        Lieu autre_lieu = new Lieu("autre lieu");

        carte.ajouterLieu(hei);
        carte.ajouterLieu(pullman);
        carte.ajouterLieu(balancoire);
        carte.ajouterLieu(esti);
        carte.ajouterLieu(autre_lieu);

        carte.ajouterRue(new Rue(hei, pullman));
        carte.ajouterRue(new Rue(pullman, balancoire ));
        carte.ajouterRue(new Rue(hei, balancoire));
        carte.ajouterRue(new Rue(balancoire, esti ));
        carte.ajouterRue(new Rue(pullman, autre_lieu));
        carte.ajouterRue(new Rue(autre_lieu, esti));

        Marcheur joro = new Marcheur();
        joro.marche(carte, hei, esti);
    }
}
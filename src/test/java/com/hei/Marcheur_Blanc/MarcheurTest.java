package com.hei.Marcheur_Blanc;

import org.junit.jupiter.api.Test;

public class MarcheurTest {

    @Test
    public void test_marche_sans_carte() {
        Lieu hei = new Lieu("HEI");
        Lieu pullman = new Lieu("Pullman");
        Lieu sekolintsika = new Lieu("Sekolintsika");
        Lieu marais = new Lieu("Marais");
        Lieu balancoire = new Lieu("Balancoire");
        Lieu nexta = new Lieu("Nexta");
        Lieu esti = new Lieu("ESTI");
        Lieu boulevard_de_l_Europe = new Lieu("Boulevard de l Europe");

        hei.ajouterLieuAdjacent(pullman);
        hei.ajouterLieuAdjacent(sekolintsika);
        hei.ajouterLieuAdjacent(balancoire);

        sekolintsika.ajouterLieuAdjacent(marais);
        marais.ajouterLieuAdjacent(sekolintsika);

        pullman.ajouterLieuAdjacent(nexta);
        pullman.ajouterLieuAdjacent(balancoire);

        balancoire.ajouterLieuAdjacent(esti);
        balancoire.ajouterLieuAdjacent(boulevard_de_l_Europe);
        boulevard_de_l_Europe.ajouterLieuAdjacent(esti);

        Marcheur sullivan = new Marcheur();
        sullivan.marche(hei, esti);
    }

    @Test
    public void pas_de_chemin() {
        Lieu hei = new Lieu("HEI");
        Lieu pullman = new Lieu("Pullman");
        Lieu esti = new Lieu("ESTI");

        hei.ajouterLieuAdjacent(pullman);

        Marcheur joro = new Marcheur();
        joro.marche(hei, esti);
    }

    @Test
    public void rue_avec_impasse() {
        Lieu hei = new Lieu("HEI");
        Lieu pullman = new Lieu("Pullman");
        Lieu nexta = new Lieu("Nexta");
        Lieu balancoire = new Lieu("Balancoire");
        Lieu impasse = new Lieu("Impasse");
        Lieu esti = new Lieu("ESTI");
        Lieu sekolintsika = new Lieu("Sekolintsika");
        Lieu boulevard_de_l_Europe = new Lieu("Boulevard de l Europe");

        hei.ajouterLieuAdjacent(pullman);
        hei.ajouterLieuAdjacent(balancoire);
        hei.ajouterLieuAdjacent(sekolintsika);

        pullman.ajouterLieuAdjacent(nexta);
        pullman.ajouterLieuAdjacent(balancoire);

        nexta.ajouterLieuAdjacent(impasse);

        balancoire.ajouterLieuAdjacent(esti);
        balancoire.ajouterLieuAdjacent(boulevard_de_l_Europe);

        boulevard_de_l_Europe.ajouterLieuAdjacent(esti);

        Marcheur aina = new Marcheur();
        aina.marche(hei, esti);
    }
}
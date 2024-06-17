package com.hei.Marcheur_Blanc;

import lombok.*;


@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Lieu {
    private  String nom;

    @Override
    public String toString(){
        return nom;
    }
}

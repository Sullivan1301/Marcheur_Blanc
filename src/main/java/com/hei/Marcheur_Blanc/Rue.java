package com.hei.Marcheur_Blanc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rue {
    private Lieu origine;
    private Lieu destination;
}

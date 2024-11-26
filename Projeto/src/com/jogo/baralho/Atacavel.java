package com.jogo.baralho;
import java.util.ArrayList;

public interface Atacavel {
    void atacar(Criatura inimigo, ArrayList<Criatura> outrasCriaturasInimigas);
}


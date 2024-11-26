package com.jogo.baralho;
import com.jogo.game.Jogo;

public class Encantamento extends Carta {
   protected String efeitoContinuo;

    public Encantamento(String nome, int custoMana, String efeitoContinuo) {
        super(nome, custoMana);
        this.efeitoContinuo = efeitoContinuo;
    }
    public String getEfeitoContinuo() {
        return efeitoContinuo;
    }
    public void setEfeitoContinuo(String efeitoContinuo) {
        this.efeitoContinuo = efeitoContinuo;
    }
    @Override
    public void usarCarta() {
        System.out.println(getNome() + " foi ativado com efeito contínuo: " + efeitoContinuo);
    }

    public void aplicar(Jogo jogo, int jogador) {
        // Defina o efeito permanente do encantamento aqui
        System.out.printf("Jogador %d aplicou o encantamento: %s! Efeito permanente: %s\n", jogador, nome, efeitoContinuo);

        // Exemplo: aumentar mana permanentemente para o jogador
        if (efeitoContinuo.equals("aumentarMana")) {
            if (jogador == 1) {
                jogo.setManaJogador1(jogo.getManaJogador1() + 2);
            } else {
                jogo.setManaJogador2(jogo.getManaJogador2() + 2);
            }
        } else if (efeitoContinuo.equals("diminuirMana")) {
            if (jogador == 1) {
                jogo.setManaJogador2(jogo.getManaJogador2() - 2);
            } else {
                jogo.setManaJogador1(jogo.getManaJogador1() - 2);
            }
        } else if (efeitoContinuo.equals("ataque")) {
            if (jogador == 1) {
                jogo.setVidaJogador2(jogo.getVidaJogador2() - 10);
            } else{
                jogo.setVidaJogador1(jogo.getVidaJogador1() - 10);
            }
        } else if (efeitoContinuo.equals("escudo")) {
            if (jogador == 1) {
                jogo.setVidaJogador1(jogo.getVidaJogador1() + 10);
            } else{
                jogo.setVidaJogador2(jogo.getVidaJogador2() + 10);
            }
        }
    }

    public String toString() {
        return super.toString() + ", Efeito Contínuo: " + efeitoContinuo;
    }
}


public class Feitico extends Carta {
    protected String efeito;

    public Feitico(String nome, int custoMana, String efeito) {
        super(nome, custoMana);
        this.efeito = efeito;
    }
    public String getEfeito() {
        return efeito;
    }
    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }
    @Override
    public void usarCarta() {
        System.out.println(getNome() + " foi lançado com efeito: " + efeito);
    }
    public void usar(Jogo jogo, int jogador) {
        // Defina os efeitos do feitiço aqui (por exemplo, dano, cura, etc.)
        System.out.printf("Jogador %d usou o feitiço: %s! Efeito: %s\n",jogador,nome, efeito);

        // Exemplo de efeito de feitiço: cura ou dano
        if (efeito.equals("cura")) {
            if (jogador == 1) {
                jogo.setVidaJogador1(jogo.getVidaJogador1() + 4); // Cura Jogador 1
            } else {
                jogo.setVidaJogador2(jogo.getVidaJogador2() + 4); // Cura Jogador 2
            }
        } else if (efeito.equals("dano")) {
            if (jogador == 1) {
                jogo.setVidaJogador2(jogo.getVidaJogador2() - 2); // Dano ao Jogador 2
            } else {
                jogo.setVidaJogador1(jogo.getVidaJogador1() - 2); // Dano ao Jogador 1
            }
        } else if (efeito.equals("defesa")) {
            if (jogador == 1) {
                jogo.setVidaJogador1(jogo.getVidaJogador1() + 2);
            } else {
                jogo.setVidaJogador2(jogo.getVidaJogador2() + 2);
            }
        }
    }

    public String toString() {
        return super.toString() + ", Efeito: " + efeito;
    }
}

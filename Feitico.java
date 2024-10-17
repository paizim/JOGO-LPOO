public class Feitico extends Carta {
    String efeito;

    public Feitico(String nome, int custoMana, String efeito) {
        super(nome, custoMana);
        this.efeito = efeito;
    }
    public void usar(Jogo jogo, int jogador) {
        // Defina os efeitos do feitiço aqui (por exemplo, dano, cura, etc.)
        System.out.printf("Jogador %d usou o feitiço: %s! Efeito: %s\n", jogador, nome, efeito);

        // Exemplo de efeito de feitiço: cura ou dano
        if (efeito.equals("cura")) {
            if (jogador == 1) {
                jogo.vidaJogador1 += 10; // Cura Jogador 1
            } else {
                jogo.vidaJogador2 += 10; // Cura Jogador 2
            }
        } else if (efeito.equals("dano")) {
            if (jogador == 1) {
                jogo.vidaJogador2 -= 10; // Dano ao Jogador 2
            } else {
                jogo.vidaJogador1 -= 10; // Dano ao Jogador 1
            }
        }
    }

    public String toString() {
        return super.toString() + ", Efeito: " + efeito;
    }
}

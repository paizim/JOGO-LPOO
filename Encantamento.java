public class Encantamento extends Carta {
    String efeitoContinuo;

    public Encantamento(String nome, int custoMana, String efeitoContinuo) {
        super(nome, custoMana);
        this.efeitoContinuo = efeitoContinuo;
    }
    public void aplicar(Jogo jogo, int jogador) {
        // Defina o efeito permanente do encantamento aqui
        System.out.printf("Jogador %d aplicou o encantamento: %s! Efeito permanente: %s\n", jogador, nome, efeitoContinuo);

        // Exemplo: aumentar mana permanentemente para o jogador
        if (efeitoContinuo.equals("aumentarMana")) {
            if (jogador == 1) {
                jogo.manaJogador1 += 2;  // Aumenta mana permanentemente do Jogador 1
            } else {
                jogo.manaJogador2 += 2;  // Aumenta mana permanentemente do Jogador 2
            }
        }
    }

    public String toString() {
        return super.toString() + ", Efeito Contínuo: " + efeitoContinuo;
    }
}


public class Encantamento extends Carta {
    String efeitoContinuo;

    public Encantamento(String nome, int custoMana, String efeitoContinuo) {
        super(nome, custoMana);
        this.efeitoContinuo = efeitoContinuo;
    }

    public String toString() {
        return super.toString() + ", Efeito Contínuo: " + efeitoContinuo;
    }
}


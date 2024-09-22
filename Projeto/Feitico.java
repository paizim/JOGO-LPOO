public class Feitico extends Carta {
    String efeito;

    public Feitico(String nome, int custoMana, String efeito) {
        super(nome, custoMana);
        this.efeito = efeito;
    }

    public String toString() {
        return super.toString() + ", Efeito: " + efeito;
    }
}

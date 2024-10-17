public class Criatura extends Carta {
    int poder;
    int resistencia;
    String habilidade;

    public Criatura(String nome, int custoMana, int poder, int resistencia, String habilidade) {
        super(nome, custoMana);
        this.poder = poder;
        this.resistencia = resistencia;
        this.habilidade = habilidade;

    }

    public String toString() {
        return super.toString() + ", Poder: " + poder + ", Resistência: " + resistencia + ", Habilidade: " + habilidade;
    }
}


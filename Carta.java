public class Carta {
    String nome;
    int custoMana;

    public Carta(String nome, int custoMana) {
        this.nome = nome;
        this.custoMana = custoMana;
    }

    public String toString() {
        return "Nome: " + nome + ", Custo de Mana: " + custoMana;
    }
}

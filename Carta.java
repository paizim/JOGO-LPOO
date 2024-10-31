public class Carta {
    protected String nome;
    protected int custoMana;

    public Carta(String nome, int custoMana) {
        this.nome = nome;
        this.custoMana = custoMana;
    }

    public String getNome() {
        return nome;
    }

    public int getCustoMana() {
        return custoMana;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Custo de Mana: " + custoMana;
    }
}

import java.util.ArrayList;

public class Criatura extends Carta {
    protected int poder;
    protected int resistencia;
    protected int mana;
    private ArrayList<String> habilidades;
    private boolean provocada = false;

    public Criatura(String nome, int poder, int resistencia, int mana, ArrayList<String> habilidades) {
        super(nome, poder);
        this.poder = poder;
        this.resistencia = resistencia;
        this.mana = mana;
        this.habilidades = habilidades;
    }

    public void atacar(Criatura inimigo, ArrayList<Criatura> outrasCriaturasInimigas) {
        if (inimigo.habilidades.contains("Provocar") && !this.habilidades.contains("Esquiva")) {
            System.out.println(inimigo.getNome() + " tem a habilidade Provocar. " + this.getNome() + " é forçado a atacar.");
        }

        if (!habilidades.contains("Rapidez") && !provocada) {
            System.out.println(nome + " não pode atacar neste turno (não tem Rapidez).");
            return;
        }

        System.out.println(nome + " está atacando " + inimigo.getNome() + " causando " + poder + " de dano!");
        inimigo.receberDano(poder);

        if (habilidades.contains("Splash")) {
            System.out.println(nome + " ativa a habilidade Splash, espalhando metade do dano para as outras criaturas inimigas.");
            int danoSplash = poder / 2;
            for (Criatura criatura : outrasCriaturasInimigas) {
                if (criatura != inimigo) {
                    System.out.println("A criatura " + criatura.getNome() + " recebe " + danoSplash + " de dano por causa do Splash.");
                    criatura.receberDano(danoSplash);
                }
            }
        }
    }

    public void receberDano(int dano) {
        if (habilidades.contains("Esquiva")) {
            System.out.println(nome + " ativa a habilidade Esquiva e desvia do ataque.");
            return;
        }

        if (habilidades.contains("Regeneração")) {
            System.out.println(nome + " ativa a habilidade Regeneração e restaura 2 pontos de resistência.");
            resistencia += 2;
        }

        resistencia -= dano;
        System.out.println(nome + " recebeu " + dano + " de dano. Resistência restante: " + resistencia);
        if (resistencia <= 0) {
            System.out.println(nome + " foi derrotado!");
        }
    }

    public String getNome() {
        return nome;
    }

    public void mostrarAtributos() {
        System.out.println("Criatura: " + getNome() + " | Poder: " + poder + " | Resistência: " + resistencia);
        System.out.print("Habilidades: ");
        for (String habilidade : habilidades) {
            System.out.print(habilidade + " ");
        }
        System.out.println();
    }

    public void aplicarProvocar() {
        provocada = true;
    }

    public boolean temHabilidade(String habilidade) {
        return habilidades.contains(habilidade);
    }

    public int getPoder() {
        return poder;
    }

    public int getResistencia() {
        return resistencia;
    }

    public int getMana() {
        return mana;
    }

    public void adicionarHabilidade(String habilidade) {
        if (!habilidades.contains(habilidade)) {
            habilidades.add(habilidade);
        }
    }

    public void removerHabilidade(String habilidade) {
        habilidades.remove(habilidade);
    }
}

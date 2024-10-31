import java.util.ArrayList;

public class Criatura extends Carta {
    protected int poder;
    protected int resistencia;
    protected ArrayList<String> habilidades;
    protected boolean provocada = false;

    public Criatura(String nome, int poder, int resistencia, int custoMana, ArrayList<String> habilidades) {
        super(nome, custoMana);
        this.poder = poder;
        this.resistencia = resistencia;
        this.habilidades = habilidades;
    }
    @Override
    public void usarCarta() {
        System.out.println(getNome() + " entra em campo com " + poder + " de poder e " + resistencia + " de resistência.");
        mostrarAtributos();  // Exibir atributos da criatura ao ser usada
    }
    public void atacar(Criatura inimigo, ArrayList<Criatura> outrasCriaturasInimigas) {
        if (inimigo.temHabilidade("Provocar") && !this.temHabilidade("Esquiva")) {
            System.out.println(inimigo.getNome() + " tem a habilidade Provocar. " + this.getNome() + " é forçado a atacar.");
        }

        if (!temHabilidade("Rapidez") && !provocada) {
            System.out.println(nome + " não pode atacar neste turno (não tem Rapidez).");
            return;
        }

        System.out.println(nome + " está atacando " + inimigo.getNome() + " causando " + poder + " de dano!");
        inimigo.receberDano(poder);

        if (temHabilidade("Splash")) {
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
        if (temHabilidade("Esquiva")) {
            System.out.println(nome + " ativa a habilidade Esquiva e desvia do ataque.");
            return;
        }

        if (temHabilidade("Regeneração")) {
            System.out.println(nome + " ativa a habilidade Regeneração e restaura 2 pontos de resistência.");
            resistencia += 2;
        }

        resistencia -= dano;
        System.out.println(nome + " recebeu " + dano + " de dano. Resistência restante: " + resistencia);
        if (resistencia <= 0) {
            System.out.println(nome + " foi derrotado!");
        }
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

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }
}
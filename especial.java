package projeto;

public class Criatura extends Carta {
    private int ataque;
    private int defesa;
    private int vida;
    

    private boolean provocar;
    private boolean rapidez;
    private boolean esquiva;

    public Criatura(String nome, int ataque, int defesa, int vida, boolean provocar, boolean rapidez, boolean esquiva) {
        super(nome, ataque);
        this.ataque = ataque;
        this.defesa = defesa;
        this.vida = vida;
        this.provocar = provocar;
        this.rapidez = rapidez;
        this.esquiva = esquiva;
    }

    @Override
    public void mostrarAtributos() {
        System.out.println("Criatura: " + nome + " | Ataque: " + ataque + " | Defesa: " + defesa + " | Vida: " + vida + " | Custo: " + custo);
        System.out.print("Habilidades: ");
        if (provocar) {
            System.out.print("Provocar ");
        }
        if (rapidez) {
            System.out.print("Rapidez ");
        }
        if (esquiva) {
            System.out.print("Esquiva ");
        }
        System.out.println();
    }

    public void ativarHabilidades(Criatura inimigo) {
        if (provocar) {
            System.out.println(this.nome + " está provocando. O inimigo deve atacá-la primeiro!");
            inimigo.definirAlvo(this);  
        }
        if (rapidez) {
            System.out.println(this.nome + " pode atacar no mesmo turno em que é jogada.");
            this.permitirAtaque();  
        }
        if (esquiva) {
            System.out.println(this.nome + " tem chance de esquivar de ataques.");
            if (Math.random() > 0.5) {
                System.out.println(this.nome + " esquivou do ataque!");
            } else {
                System.out.println(this.nome + " não conseguiu esquivar.");
            }
        }
    }
}

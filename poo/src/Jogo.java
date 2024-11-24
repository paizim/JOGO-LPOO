import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private int nivelJogador1 = 1;
    private int nivelJogador2 = 1;
    private int experienciaJogador1 = 0;
    private int experienciaJogador2 = 0;
    private ArrayList<Carta> deck1;
    private ArrayList<Carta> deck2;
    private ArrayList<Carta> maoJogador1;
    private ArrayList<Carta> maoJogador2;
    private ArrayList<Carta> cartasJogadasJogador1;
    private ArrayList<Carta> cartasJogadasJogador2;
    private ArrayList<Criatura> campoJogador1;
    private ArrayList<Criatura> campoJogador2;
    private ArrayList<Carta> cemiterio; // Cemitério para cartas destruídas
    private int vidaJogador1 = 15;
    private int vidaJogador2 = 15;
    private String personagem1;
    private String personagem2;
    private String classe1;
    private String classe2;
    private boolean vezDoJogador1;
    private Random random;
    private Scanner scanner;
    private int manaJogador1 = 1; // Mana inicial do Jogador 1
    private int manaJogador2 = 1; // Mana inicial do Jogador 2

    public Jogo() {
        this.deck1 = Decks.criarDeck1();
        this.deck2 = Decks.criarDeck2();
        this.maoJogador1 = new ArrayList<>();
        this.maoJogador2 = new ArrayList<>();
        this.cartasJogadasJogador1 = new ArrayList<>();
        this.cartasJogadasJogador2 = new ArrayList<>();
        this.cemiterio = new ArrayList<>(); // Inicializando o cemitério
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        this.campoJogador1 = new ArrayList<>();
        this.campoJogador2 = new ArrayList<>();
    }

    public int getVidaJogador1() {
        return this.vidaJogador1;
    }

    public void setVidaJogador1(int vidaJogador1) {
        this.vidaJogador1 = vidaJogador1;
    }

    public int getVidaJogador2() {
        return this.vidaJogador2;
    }

    public void setVidaJogador2(int vidaJogador2) {
        this.vidaJogador2 = vidaJogador2;
    }

    public int getManaJogador1() {
        return this.manaJogador1;
    }

    public void setManaJogador1(int manaJogador1) {
        this.manaJogador1 = manaJogador1;
    }

    public int getManaJogador2() {
        return this.manaJogador2;
    }

    public void setManaJogador2(int manaJogador2) {
        this.manaJogador2 = manaJogador2;
    }
    public ArrayList<Carta> getDeck1() {
        return deck1;
    }

    public ArrayList<Carta> getDeck2() {
        return deck2;
    }

    public void introducao() {
        System.out.println("SEJAM BEM VINDOS ÀS CRÔNICAS DE ARCANA, EM QUE VOCÊS DECIDIRÃO O FUTURO DO MUNDO TABEFE EM UMA BATALHA ENTRE OS DEFENSORES DA HUMANIDADE CONTRA A HORDA DE GOBLINS.");
        System.out.println("JOGADOR 1 DIGITE O NOME DE SEU PERSONAGEM: ");
        personagem1 = scanner.nextLine().toUpperCase();
        System.out.printf("SEU PERSONAGEM: %s / VIDA: %d\n", personagem1, vidaJogador1);
        System.out.println("JOGADOR 2 DIGITE O NOME DE SEU PERSONAGEM: ");
        personagem2 = scanner.nextLine().toUpperCase();
        System.out.printf("SEU PERSONAGEM: %s / VIDA: %d\n", personagem2, vidaJogador2);
    }

    public static ArrayList<Carta> criarDeck1() {
        ArrayList<Carta> deck = new ArrayList<>();

        ArrayList<String> habilidadesCavaleiro = new ArrayList<>();
        deck.add(new Criatura("Cavaleiro", 1, 6, 3, habilidadesCavaleiro));

        ArrayList<String> habilidadesPaladino = new ArrayList<>();
        habilidadesPaladino.add("Regeneração");
        deck.add(new Criatura("Paladino", 3, 7, 4, habilidadesPaladino));

        ArrayList<String> habilidadesArqueiro = new ArrayList<>();
        habilidadesArqueiro.add("Rapidez");
        deck.add(new Criatura("Arqueiro", 1, 3, 2, habilidadesArqueiro));

        ArrayList<String> habilidadesEspadachim = new ArrayList<>();
        habilidadesEspadachim.add("Esquiva");
        deck.add(new Criatura("Espadachim", 2, 4, 4, habilidadesEspadachim));

        ArrayList<String> habilidadesGrifo = new ArrayList<>();
        habilidadesGrifo.add("Splash");
        deck.add(new Criatura("Grifo Guardião", 6, 6, 6, habilidadesGrifo));

        ArrayList<String> habilidadesDragao = new ArrayList<>();
        habilidadesDragao.add("Provocar");
        deck.add(new Criatura("Dragão", 9, 9, 9, habilidadesDragao));

        ArrayList<String> habilidadesGuerreiro = new ArrayList<>();
        deck.add(new Criatura("Guerreiro", 4, 6, 6, habilidadesGuerreiro));

        ArrayList<String> habilidadesCleriga = new ArrayList<>();
        habilidadesCleriga.add("Regeneração");
        deck.add(new Criatura("Clériga", 3, 6, 5, habilidadesCleriga));

        ArrayList<String> habilidadesSentinela = new ArrayList<>();
        habilidadesSentinela.add("Provocar");
        deck.add(new Criatura("Sentinela", 1, 5, 3, habilidadesSentinela));

        ArrayList<String> habilidadesGuardiao = new ArrayList<>();
        deck.add(new Criatura("Guardião", 2, 7, 4, habilidadesGuardiao));

        deck.add(new Feitico("Cura Divina", 4, "cura"));
        deck.add(new Feitico("Escudo da Virtude", 3, "defesa"));
        deck.add(new Feitico("Chama Purificadora", 2, "dano"));
        deck.add(new Feitico("Bênção do Rei", 2, "defesa"));
        deck.add(new Feitico("Reviver os Caídos", 4, "cura"));
        deck.add(new Feitico("Barreira Celestial", 3, "defesa"));
        deck.add(new Feitico("Golpe Devastador", 3, "dano"));
        deck.add(new Feitico("Golpe da Justiça", 4, "dano"));
        deck.add(new Feitico("Vento da Vitória", 4, "dano"));
        deck.add(new Feitico("Luz Purificadora", 4, "cura"));
        deck.add(new Encantamento("Proteção Sagrada", 5, "escudo"));
        deck.add(new Encantamento("Benção de Avalon", 5, "escudo"));
        deck.add(new Encantamento("Muralha Impenetrável", 5, "escudo"));
        deck.add(new Encantamento("Fúria dos Deuses", 5, "ataque"));
        deck.add(new Encantamento("Campo de Força Divino", 3, "aumentarMana"));
        deck.add(new Encantamento("Aura da Luz", 3, "aumentarMana"));
        deck.add(new Encantamento("Chama Sagrada", 3, "diminuirMana"));
        deck.add(new Encantamento("Escudo de Cristal", 5, "escudo"));
        deck.add(new Encantamento("Bênção Real", 3, "diminuirMana"));
        deck.add(new Encantamento("Campo de Energia Arcana", 5, "ataque"));
        return deck;
    }

    public static ArrayList<Carta> criarDeck2() {
        ArrayList<Carta> deck = new ArrayList<>();

        ArrayList<String> habilidadesGuerreiroGoblin = new ArrayList<>();
        deck.add(new Criatura("Guerreiro Goblin", 1, 5, 4, habilidadesGuerreiroGoblin));

        ArrayList<String> habilidadesOgros = new ArrayList<>();
        habilidadesOgros.add("Provocar");
        deck.add(new Criatura("Ogros", 1, 7, 6, habilidadesOgros));

        ArrayList<String> habilidadesXamaGoblin = new ArrayList<>();
        habilidadesXamaGoblin.add("Esquiva");
        deck.add(new Criatura("Xamã Goblin", 2, 9, 5, habilidadesXamaGoblin));

        ArrayList<String> habilidadesLadrao = new ArrayList<>();
        habilidadesLadrao.add("Rapidez");
        deck.add(new Criatura("Ladrão", 2, 2, 3, habilidadesLadrao));

        ArrayList<String> habilidadesGoblinExplosivo = new ArrayList<>();
        habilidadesGoblinExplosivo.add("Splash");
        deck.add(new Criatura("Goblin Explosivo", 2, 1, 2, habilidadesGoblinExplosivo));

        ArrayList<String> habilidadesTroll = new ArrayList<>();
        deck.add(new Criatura("Troll", 3, 5, 4, habilidadesTroll));

        ArrayList<String> habilidadesBerserkerOrc = new ArrayList<>();
        habilidadesBerserkerOrc.add("Regeneração");
        deck.add(new Criatura("Berserker Orc", 3, 4, 5, habilidadesBerserkerOrc));

        ArrayList<String> habilidadesDragaoNegro = new ArrayList<>();
        habilidadesDragaoNegro.add("Provocar");
        deck.add(new Criatura("Dragão Negro", 8, 9, 9, habilidadesDragaoNegro));

        ArrayList<String> habilidadesGoblinVenenoso = new ArrayList<>();
        deck.add(new Criatura("Goblin Venenoso", 2, 2, 3, habilidadesGoblinVenenoso));

        ArrayList<String> habilidadesGigante = new ArrayList<>();
        deck.add(new Criatura("Gigante", 5, 7, 7, habilidadesGigante));

        deck.add(new Feitico("Fogo Infernal", 3, "dano"));
        deck.add(new Feitico("Sangue do Inimigo", 3, "cura"));
        deck.add(new Feitico("Sentido Aguçado", 1, "defesa"));
        deck.add(new Feitico("Vingança Silenciosa", 4, "dano"));
        deck.add(new Feitico("Raiva Primordial", 4, "dano"));
        deck.add(new Feitico("Rugido do Dragão", 6, "dano"));
        deck.add(new Encantamento("Aumentar Velocidade", 3, "aumentarMana"));
        deck.add(new Encantamento("Mente Sanguinária", 4, "diminuirMana"));
        deck.add(new Encantamento("Bênção do Sacrifício", 2, "escudo"));
        deck.add(new Encantamento("Campo de Batalla", 3, "aumentarMana"));
        deck.add(new Encantamento("Necromancia", 5, "escudo"));
        return deck;
    }

    public void reino1() {
        System.out.printf("ESCOLHA UM REINO, %s (DEFENSORES DA HUMANIDADE ou HORDA DOS GOBLINS): ", personagem1);
        classe1 = scanner.nextLine().toUpperCase();
        while (!classe1.equals("DEFENSORES DA HUMANIDADE") && !classe1.equals("HORDA DOS GOBLINS")) {
            System.out.println("CLASSE INVÁLIDA. TENTE NOVAMENTE.");
            classe1 = scanner.nextLine().toUpperCase();
        }
        System.out.printf(personagem1 + "PERTENCE AOS %s.\n", classe1);
    }

    public void reino2() {
        System.out.printf("ESCOLHA UM REINO, %s (DEFENSORES DA HUMANIDADE ou HORDA DOS GOBLINS): ", personagem2);
        classe2 = scanner.nextLine().toUpperCase();
        while (!classe2.equals("DEFENSORES DA HUMANIDADE") && !classe2.equals("HORDA DOS GOBLINS")) {
            System.out.println("CLASSE INVÁLIDA. TENTE NOVAMENTE.");
            classe2 = scanner.nextLine().toUpperCase();
        }
        System.out.printf(personagem2 + "PERTENCE AOS %s.\n", classe2);
    }

    private void ganharExperiencia(int jogador) {
        if (jogador == 1) {
            experienciaJogador1 += 10; // Ganhar 10 de experiência a cada turno
            System.out.printf("Jogador 1 ganhou 10 de experiência! Total: %d\n", experienciaJogador1);
            verificarSubirNivel(1);
        } else {
            experienciaJogador2 += 10; // Ganhar 10 de experiência a cada turno
            System.out.printf("Jogador 2 ganhou 10 de experiência! Total: %d\n", experienciaJogador2);
            verificarSubirNivel(2);
        }
    }

    private void verificarSubirNivel(int jogador) {
        int experienciaParaSubir = 100 * (jogador == 1 ? nivelJogador1 : nivelJogador2); // Exemplo: 100 XP por nível
        if ((jogador == 1 && experienciaJogador1 >= experienciaParaSubir) ||
                (jogador == 2 && experienciaJogador2 >= experienciaParaSubir)) {
            if (jogador == 1) {
                nivelJogador1++;
                System.out.printf("Jogador 1 subiu para o nível %d!\n", nivelJogador1);
            } else {
                nivelJogador2++;
                System.out.printf("Jogador 2 subiu para o nível %d!\n", nivelJogador2);
            }
        }
    }

    private void decidirQuemComeca() {
        System.out.println("TIREM PAR OU IMPAR PARA VER QUEM COMEÇA.");
        String escolhaJogador1;
        String escolhaJogador2;

        // Loop até que ambos façam escolhas válidas
        do {
            System.out.print(personagem1 + ", DIGITE SUA ESCOLHA (PAR OU IMPAR): ");
            escolhaJogador1 = scanner.nextLine().toUpperCase();
        } while (!escolhaJogador1.equals("PAR") && !escolhaJogador1.equals("IMPAR"));

        do {
            System.out.print(personagem2 + ", DIGITE SUA ESCOLHA (PAR OU IMPAR): ");
            escolhaJogador2 = scanner.nextLine().toUpperCase();
        } while (!escolhaJogador2.equals("PAR") && !escolhaJogador2.equals("IMPAR"));

        // Sorteio do número
        int numeroSorteado = random.nextInt(10) + 1; // Número entre 1 e 10
        boolean resultadoPar = (numeroSorteado % 2 == 0);
        System.out.printf("O NÚMERO SORTEADO É: %d (%s)\n", numeroSorteado, resultadoPar ? "PAR" : "IMPAR");

        // Determina quem começa
        if (escolhaJogador1.equals(resultadoPar ? "PAR" : "IMPAR")) {
            vezDoJogador1 = true;
            System.out.println("JOGADOR 1 COMEÇA O JOGO!");
        } else {
            vezDoJogador1 = false;
            System.out.println("JOGADOR 2 COMEÇA O JOGO!");
        }
    }

    public void iniciar() {
        introducao();
        reino1();
        reino2();
        distribuirCartas();
        decidirQuemComeca();
        while (vidaJogador1 > 0 && vidaJogador2 > 0) {
            manaJogador1 += 1; // Aumenta a mana do Jogador 1
            manaJogador2 += 1; // Aumenta a mana do Jogador 2
            jogarTurno();
            if (vidaJogador1 <= 0 || vidaJogador2 <= 0) break;
        }
        mostrarVencedor();
    }

    private void distribuirCartas() {
        System.out.println("Distribuindo 5 cartas aleatórias para cada jogador...");
        // Distribuir 5 cartas para o Jogador 1
        ArrayList<Carta> deckJogador1 = escolherDeck(classe1);
        for (int i = 0; i < 5; i++) {
            int indiceCarta = random.nextInt(deckJogador1.size());
            Carta carta = deckJogador1.remove(indiceCarta); // Remove do deck1
            maoJogador1.add(carta); // Adiciona na mão do Jogador 1
        }

        // Distribuir 5 cartas para o Jogador 2
        ArrayList<Carta> deckJogador2 = escolherDeck(classe2);
        for (int i = 0; i < 5; i++) {
            int indiceCarta = random.nextInt(deckJogador2.size());
            Carta carta = deckJogador2.remove(indiceCarta); // Remove do deck2
            maoJogador2.add(carta); // Adiciona na mão do Jogador 2
        }

        // Exibir cartas iniciais para ambos os jogadores
        System.out.println("Cartas do Jogador 1:");
        for (Carta c : maoJogador1) {
            System.out.println(c);
        }
        System.out.println("Cartas do Jogador 2:");
        for (Carta c : maoJogador2) {
            System.out.println(c);
        }
    }
    private ArrayList<Carta> escolherDeck(String classe) {
        if (classe.equals("DEFENSORES DA HUMANIDADE")) {
            return criarDeck1(); // Retorna o deck dos Defensores da Humanidade
        } else {
            return criarDeck2(); // Retorna o deck da Horda dos Goblins
        }
    }

    private void exibirCemiterio() {
        System.out.println("Cartas destruídas (Cemitério):");
        for (Carta carta : cemiterio) {
            System.out.println(carta);
        }
    }

    void mostrarVencedor() {
        if (vidaJogador1 <= 0) {
            System.out.println(personagem2 + "venceu!");
        } else if (vidaJogador2 <= 0) {
            System.out.println(personagem1 + "venceu!");
        }
        exibirCemiterio();
    }

    // Função para jogar uma criatura no campo
    private void usarCriatura(int jogador, Criatura criatura) {
        if (jogador == 1) {
            maoJogador1.remove(criatura);
            campoJogador1.add(criatura);
            manaJogador1 -= criatura.getCustoMana();
            System.out.println("Jogador 1 jogou a criatura: " + criatura.getNome());
            criatura.mostrarAtributos();
        } else {
            maoJogador2.remove(criatura);
            campoJogador2.add(criatura);
            manaJogador2 -= criatura.getCustoMana();
            System.out.println("Jogador 2 jogou a criatura: " + criatura.getNome());
            criatura.mostrarAtributos();
        }
    }

    private void colocarNoCampo(int jogador, int indiceCarta) {
        Carta carta = (jogador == 1) ? maoJogador1.remove(indiceCarta) : maoJogador2.remove(indiceCarta);
        if (jogador == 1) {
            campoJogador1.add((Criatura) carta);
            System.out.println("Jogador 1 colocou " + carta.getNome() + " no campo de batalha.");
        } else {
            campoJogador2.add((Criatura) carta);
            System.out.println("Jogador 2 colocou " + carta.getNome() + " no campo de batalha.");
        }
    }


    private void ataque(int jogador, Criatura criatura) {
        ArrayList<Criatura> campoOponente = (jogador == 1) ? campoJogador2 : campoJogador1;

        if (!campoOponente.isEmpty()) {
            System.out.println("Escolha uma criatura no campo do oponente para atacar:");
            for (int i = 0; i < campoOponente.size(); i++) {
                Criatura criaturaOponente = (Criatura) campoOponente.get(i);
                System.out.println((i + 1) + ": " + criaturaOponente.getNome() + " - Poder: " + criaturaOponente.getPoder() + ", Resistência: " + criaturaOponente.getResistencia());
            }
            System.out.print("Escolha o número da criatura: ");
            int escolha = scanner.nextInt();

            if (escolha > 0 && escolha <= campoOponente.size()) {
                Criatura criaturaOponente = (Criatura) campoOponente.get(escolha - 1);
                realizarCombate(criatura, criaturaOponente);

                // Modificação permanente de resistência após o combate
                int danoCausado = criatura.getPoder();
                int novaResistencia = criaturaOponente.getResistencia() - danoCausado;
                criaturaOponente.setResistencia(novaResistencia);
                System.out.println(criaturaOponente.getNome() + " agora tem " + novaResistencia + " de resistência.");

                if (novaResistencia <= 0) {
                    // Eliminar a criatura oponente se a resistência chegar a zero ou menos
                    campoOponente.remove(escolha - 1);
                    System.out.println(criaturaOponente.getNome() + " foi eliminado!");
                }
            } else {
                System.out.println("Escolha inválida.");
            }
        } else {
            if (jogador == 1) {
                vidaJogador2 -= criatura.getPoder();
                System.out.println("Jogador 1 atacou Jogador 2, causando " + criatura.getPoder() + " de dano.");
            } else {
                vidaJogador1 -= criatura.getPoder();
                System.out.println("Jogador 2 atacou Jogador 1, causando " + criatura.getPoder() + " de dano.");
            }
        }
    }


    // Função para resolver combate entre duas criaturas
    private void realizarCombate(Criatura atacante, Criatura defensora) {
        int resistenciaDefensora = defensora.getResistencia() - atacante.getPoder();
        defensora.setResistencia(Math.max(0, resistenciaDefensora)); // Evita que a resistência fique negativa

        int resistenciaAtacante = atacante.getResistencia() - defensora.getPoder();
        atacante.setResistencia(Math.max(0, resistenciaAtacante)); // Evita que a resistência fique negativa

        System.out.println(atacante.getNome() + " atacou " + defensora.getNome());
        System.out.println(defensora.getNome() + " tem " + defensora.getResistencia() + " de resistência restante.");
        System.out.println(atacante.getNome() + " tem " + atacante.getResistencia() + " de resistência restante.");

        if (defensora.getResistencia() <= 0) {
            ArrayList<Criatura> campoOponente = (campoJogador1.contains(atacante)) ? campoJogador2 : campoJogador1;
            campoOponente.remove(defensora);
            cemiterio.add(defensora);
            System.out.println(defensora.getNome() + " foi destruída!");
        }

        if (atacante.getResistencia() <= 0) {
            ArrayList<Criatura> campoAtual = (campoJogador1.contains(atacante)) ? campoJogador1 : campoJogador2;
            campoAtual.remove(atacante);
            cemiterio.add(atacante);
            System.out.println(atacante.getNome() + " foi destruída!");
        }
    }

    private void jogarTurno() {
        // Fase de Compra - Ambos compram uma carta
        if (!escolherDeck(classe1).isEmpty()) {
            Carta novaCarta1 = escolherDeck(classe1).remove(random.nextInt(escolherDeck(classe1).size()));
            maoJogador1.add(novaCarta1);
            System.out.println("Jogador 1 puxou " + novaCarta1.getNome());
        }
        if (!escolherDeck(classe2).isEmpty()) {
            Carta novaCarta2 = escolherDeck(classe2).remove(random.nextInt(escolherDeck(classe2).size()));
            maoJogador2.add(novaCarta2);
            System.out.println("Jogador 2 puxou " + novaCarta2.getNome());
        }
        int jogadorAtual = vezDoJogador1 ? 1 : 2;
        // Fase de Colocação - Ambos colocam uma carta, começando pelo Jogador 1
        for (int i = 0; i < 2; i++) {
            ArrayList<Carta> maoAtual = jogadorAtual == 1 ? maoJogador1 : maoJogador2;
            int manaAtual = (jogadorAtual == 1) ? manaJogador1 : manaJogador2;

            System.out.printf("Jogador %d: Vida: %d, Mana: %d\n", jogadorAtual,
                    jogadorAtual == 1 ? vidaJogador1 : vidaJogador2, manaAtual);

            System.out.printf("Jogador %d, escolha uma carta para colocar no campo (0 para passar):\n", jogadorAtual);

            for (int j = 0; j < maoAtual.size(); j++) {
                Carta carta = maoAtual.get(j);
                String atributos = (carta instanceof Criatura) ?
                        String.format(" [Poder: %d, Resistência: %d]", ((Criatura) carta).getPoder(), ((Criatura) carta).getResistencia()) : "";
                System.out.println((j + 1) + ". " + carta.nome + " (Custo de Mana: " + carta.custoMana + ")" + atributos);
            }

            int escolha = scanner.nextInt() - 1;
            if (escolha != -1 && escolha >= 0 && escolha < maoAtual.size()) {
                Carta cartaEscolhida = maoAtual.get(escolha);
                try {
                    if (cartaEscolhida.custoMana > manaAtual) {
                        throw new ManaInsuficienteException("Mana insuficiente para jogar a carta " + cartaEscolhida.nome + ".");
                    }
                    if (cartaEscolhida instanceof Criatura) {
                        if (jogadorAtual == 1) {
                            campoJogador1.add((Criatura) cartaEscolhida);
                        } else {
                            campoJogador2.add((Criatura) cartaEscolhida);
                        }
                        maoAtual.remove(escolha);
                        System.out.printf("%s foi colocada no campo.\n", cartaEscolhida.nome);
                        Criatura criatura = (Criatura) cartaEscolhida;
                        if(criatura.temHabilidade("Provocar")){
                            System.out.println(criatura.getNome() + " agora está com a habilidade Provocar ativa!");
                        } else if (criatura.temHabilidade("Rapidez")) {
                            System.out.println(criatura.getNome() + " agora está com a habilidade Rapidez ativa!");
                        } else if (criatura.temHabilidade("Esquiva")) {
                            System.out.println(criatura.getNome() + " agora está com a habilidade Esquiva ativa!");
                        } else if (criatura.temHabilidade("Regeneração")) {
                            System.out.println(criatura.getNome() + " agora está com a habilidade Regeneração ativa!");
                        } else if (criatura.temHabilidade("Splash")) {
                            System.out.println(criatura.getNome() + " agora está com a habilidade Splash ativa!");
                        }
                    } else if (cartaEscolhida instanceof Feitico) {
                        Feitico feitico = (Feitico) cartaEscolhida;
                        feitico.usar(this, jogadorAtual);
                        maoAtual.remove(escolha); // Remover a carta da mão após usar um feitiço
                        System.out.printf("%s foi jogado!\n", feitico.getNome());
                    } else if (cartaEscolhida instanceof Encantamento) {
                        Encantamento encantamento = (Encantamento) cartaEscolhida;
                        encantamento.aplicar(this, jogadorAtual);
                        maoAtual.remove(escolha); // Remover a carta da mão após aplicar o encantamento
                        System.out.printf("%s foi aplicado!\n", encantamento.getNome());
                    }
                    if (jogadorAtual == 1) {
                        manaJogador1 -= cartaEscolhida.custoMana;
                    } else {
                        manaJogador2 -= cartaEscolhida.custoMana;
                    }
                } catch (ManaInsuficienteException e) {
                    System.out.println(e.getMessage());
                }
            }
            jogadorAtual = (jogadorAtual == 1) ? 2 : 1;
        }
        // Fase de Ataque - Ambos atacam, começando pelo Jogador
        for (int jogador = 1; jogador <= 2; jogador++) {
            ArrayList<Criatura> campoAtual = jogador == 1 ? campoJogador1 : campoJogador2;
            ArrayList<Criatura> campoOponente = jogador == 1 ? campoJogador2 : campoJogador1;
            int vidaOponente = jogador == 1 ? vidaJogador2 : vidaJogador1;

            if (!campoAtual.isEmpty()) {
                System.out.printf("Jogador %d, escolha uma criatura para atacar:\n", jogador);
                for (int i = 0; i < campoAtual.size(); i++) {
                    Criatura criatura = campoAtual.get(i);
                    System.out.printf("%d. %s (Poder: %d, Resistência: %d)\n", i + 1, criatura.nome, criatura.getPoder(), criatura.getResistencia());
                }

                int escolhaAtacante = scanner.nextInt() - 1;
                if (escolhaAtacante >= 0 && escolhaAtacante < campoAtual.size()) {
                    Criatura atacante = campoAtual.get(escolhaAtacante);

                    if (!campoOponente.isEmpty()) {
                        System.out.println("Escolha uma criatura do oponente para atacar:");
                        for (int i = 0; i < campoOponente.size(); i++) {
                            Criatura defensora = campoOponente.get(i);
                            System.out.printf("%d. %s (Poder: %d, Resistência: %d)\n", i + 1, defensora.nome, defensora.getPoder(), defensora.getResistencia());
                        }
                        int escolhaDefensora = scanner.nextInt() - 1;
                        if (escolhaDefensora >= 0 && escolhaDefensora < campoOponente.size()) {
                            Criatura defensora = campoOponente.get(escolhaDefensora);
                            realizarCombate(atacante, defensora);
                            if (defensora.getResistencia() <= 0) {
                                campoOponente.remove(defensora);
                                System.out.printf("A criatura %s foi destruída!\n", defensora.nome);
                            }
                        }
                    } else {
                        if (jogador == 1) {
                            int dano = atacante.getPoder();
                            vidaJogador2 -= dano; // Exemplo de dano fixo
                            System.out.printf("Jogador 1 atacou diretamente Jogador 2, causando %d de dano.\n", dano);
                        } else {
                            int dano = atacante.getPoder();
                            vidaJogador1 -= dano;
                            System.out.printf("Jogador 2 atacou diretamente Jogador 1, causando %d de dano.\n", dano);
                        }
                    }
                } else {
                    System.out.println("Escolha inválida.");
                }
            } else {
                System.out.printf("Jogador %d não tem criaturas para atacar.\n", jogador);
            }
        }

        // Exibir pontuação final de ambos os jogadores ao fim do turno
        System.out.printf("Fim do turno: Vida Jogador 1: %d, Vida Jogador 2: %d\n", vidaJogador1, vidaJogador2);
        ganharExperiencia(1); // Jogador 1 ganha experiência
        ganharExperiencia(2); // Jogador 2 ganha experiência
    }
}























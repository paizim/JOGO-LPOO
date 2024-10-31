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
    private int vidaJogador1 = 100;
    private int vidaJogador2 = 100;
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

    public void introducao() {
        System.out.println("SEJAM BEM VINDOS ÀS CRÔNICAS DE ARCANA, EM QUE VOCÊS DECIDIRÃO O FUTURO DO MUNDO TABEFE EM UMA BATALHA ENTRE OS DEFENSORES DA HUMANIDADE CONTRA A HORDA DE GOBLINS.");
        System.out.println("JOGADOR 1 DIGITE O NOME DE SEU PERSONAGEM: ");
        personagem1 = scanner.nextLine().toUpperCase();
        System.out.printf("SEU PERSONAGEM: %s / VIDA: %d\n", personagem1, vidaJogador1);
        reino1();
        System.out.println("JOGADOR 2 DIGITE O NOME DE SEU PERSONAGEM: ");
        personagem2 = scanner.nextLine().toUpperCase();
        System.out.printf("SEU PERSONAGEM: %s / VIDA: %d\n", personagem2, vidaJogador2);
        reino2();
        decidirQuemComeca();
    }

    public void reino1() {
        System.out.printf("ESCOLHA UM REINO, %s (DEFENSORES DA HUMANIDADE ou HORDA DOS GOBLINS): ", personagem1);
        classe1 = scanner.nextLine().toUpperCase();
        while (!classe1.equals("DEFENSORES DA HUMANIDADE") && !classe1.equals("HORDA DOS GOBLINS")) {
            System.out.println("CLASSE INVÁLIDA. TENTE NOVAMENTE.");
            classe1 = scanner.nextLine().toUpperCase();
        }
        System.out.printf("SEU PERSONAGEM PERTENCE AOS %s.\n", classe1);
    }

    public void reino2() {
        System.out.printf("ESCOLHA UM REINO, %s (DEFENSORES DA HUMANIDADE ou HORDA DOS GOBLINS): ", personagem2);
        classe2 = scanner.nextLine().toUpperCase();
        while (!classe2.equals("DEFENSORES DA HUMANIDADE") && !classe2.equals("HORDA DOS GOBLINS")) {
            System.out.println("CLASSE INVÁLIDA. TENTE NOVAMENTE.");
            classe2 = scanner.nextLine().toUpperCase();
        }
        System.out.printf("SEU PERSONAGEM PERTENCE AOS %s.\n", classe2);
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
        System.out.print("JOGADOR 1, DIGITE SUA ESCOLHA (PAR OU IMPAR): ");
        String escolhaJogador1 = scanner.nextLine().toUpperCase();
        System.out.print("JOGADOR 2, DIGITE SUA ESCOLHA (PAR OU IMPAR): ");
        String escolhaJogador2 = scanner.nextLine().toUpperCase();

        while ((!escolhaJogador1.equals("PAR") && !escolhaJogador1.equals("IMPAR")) ||
                (!escolhaJogador2.equals("PAR") && !escolhaJogador2.equals("IMPAR"))) {
            System.out.println("Escolha inválida. Ambos os jogadores devem escolher entre 'PAR' e 'IMPAR'.");
            decidirQuemComeca(); // Permitir nova tentativa
            return;
        }

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
        introducao(); // Chamar a introdução antes de iniciar o jogo
        distribuirCartas();
        while (vidaJogador1 > 0 && vidaJogador2 > 0) {
            manaJogador1 += 1; // Aumenta a mana do Jogador 1
            manaJogador2 += 1; // Aumenta a mana do Jogador 2
            jogarTurno(1);
            if (vidaJogador1 <= 0 || vidaJogador2 <= 0) break;

            // Jogador 2 joga
            jogarTurno(2);
        }
        mostrarVencedor();
    }

    private void distribuirCartas() {
        System.out.println("Distribuindo 5 cartas aleatórias para cada jogador...");
        // Distribuir 5 cartas para o Jogador 1
        for (int i = 0; i < 4; i++) {
            int indiceCarta = random.nextInt(deck1.size());
            Carta carta = deck1.remove(indiceCarta); // Remove do deck1
            maoJogador1.add(carta); // Adiciona na mão do Jogador 1
        }

        // Distribuir 5 cartas para o Jogador 2
        for (int i = 0; i < 4; i++) {
            int indiceCarta = random.nextInt(deck2.size());
            Carta carta = deck2.remove(indiceCarta); // Remove do deck2
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

    private void puxarNovaCarta(int jogador) {
        ArrayList<Carta> deck = (jogador == 1) ? deck1 : deck2;
        if (!deck.isEmpty()) {
            Carta novaCarta = deck.remove(random.nextInt(deck.size()));
            if (jogador == 1) {
                maoJogador1.add(novaCarta);
                System.out.println("Jogador 1 puxou " + novaCarta.getNome());
            } else {
                maoJogador2.add(novaCarta);
                System.out.println("Jogador 2 puxou " + novaCarta.getNome());
            }
        } else {
            System.out.println("O deck do Jogador " + jogador + " está vazio!");
        }
    }

    private void exibirCemiterio() {
        System.out.println("Cartas destruídas (Cemitério):");
        for (Carta carta : cemiterio) {
            System.out.println(carta);
        }
    }

    // Função para jogar uma criatura no campo
    private void usarCriatura(int jogador, Criatura criatura) {
        if (jogador == 1) {
            maoJogador1.remove(criatura);
            campoJogador1.add(criatura);
            manaJogador1 -= criatura.getCustoMana();
            System.out.println("Jogador 1 jogou a criatura: " + criatura.getNome());
        } else {
            maoJogador2.remove(criatura);
            campoJogador2.add(criatura);
            manaJogador2 -= criatura.getCustoMana();
            System.out.println("Jogador 2 jogou a criatura: " + criatura.getNome());
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

    void mostrarVencedor() {
        if (vidaJogador1 <= 0) {
            System.out.println("Jogador 2 venceu!");
        } else if (vidaJogador2 <= 0) {
            System.out.println("Jogador 1 venceu!");
        }
        exibirCemiterio();
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

    private void jogarTurno(int jogador) {
        ArrayList<Carta> maoAtual = jogador == 1 ? maoJogador1 : maoJogador2;
        System.out.printf("É a vez do Jogador %d! Vida: %d, Mana: %d\n", jogador,
                jogador == 1 ? vidaJogador1 : vidaJogador2,
                jogador == 1 ? manaJogador1 : manaJogador2);

        // Jogar uma nova carta
        System.out.println("Escolha uma carta para jogar (0 para passar a vez):");
        for (int i = 0; i < maoAtual.size(); i++) {
            System.out.println(i + 1 + ". " + maoAtual.get(i));
        }

        int escolha = scanner.nextInt() - 1;
        if (escolha == -1) {
            System.out.println("Você passou a vez.");
            return; // Passa a vez
        }

        if (escolha >= 0 && escolha < maoAtual.size()) {
            Carta cartaEscolhida = maoAtual.get(escolha);
            if (cartaEscolhida.custoMana <= (jogador == 1 ? manaJogador1 : manaJogador2)) {
                // Coloca a carta no campo
                if (cartaEscolhida instanceof Criatura) {
                    // Adiciona a criatura ao campo
                    if (jogador == 1) {
                        campoJogador1.add((Criatura) cartaEscolhida);
                    } else {
                        campoJogador2.add((Criatura) cartaEscolhida);
                    }
                    maoAtual.remove(escolha); // Remove da mão
                    System.out.printf("%s foi colocada no campo.\n", cartaEscolhida.nome);
                }

                // Reduz a mana após jogar a carta
                if (jogador == 1) {
                    manaJogador1 -= cartaEscolhida.custoMana;
                } else {
                    manaJogador2 -= cartaEscolhida.custoMana;
                }
            } else {
                System.out.println("Mana insuficiente para jogar essa carta.");
            }
        } else {
            System.out.println("Escolha inválida.");
        }

        // Atacar criaturas inimigas
        ArrayList<Criatura> campoOponente = (jogador == 1) ? campoJogador2 : campoJogador1;
        ArrayList<Criatura> campoAtual = (jogador == 1) ? campoJogador1 : campoJogador2;

        // Permitir ataques enquanto houver criaturas no campo do oponente
        while (!campoOponente.isEmpty()) {
            System.out.println("Escolha uma criatura no seu campo para atacar uma criatura do oponente:");
            for (int i = 0; i < campoAtual.size(); i++) {
                System.out.println((i + 1) + ". " + campoAtual.get(i).nome);
            }

            int escolhaAtacante = scanner.nextInt() - 1;
            if (escolhaAtacante >= 0 && escolhaAtacante < campoAtual.size()) {
                Criatura atacante = (Criatura) campoAtual.get(escolhaAtacante); // Casting correto
                System.out.println("Escolha uma criatura do oponente para atacar:");
                for (int i = 0; i < campoOponente.size(); i++) {
                    System.out.println((i + 1) + ". " + campoOponente.get(i).nome);
                }

                int escolhaDefensora = scanner.nextInt() - 1;
                if (escolhaDefensora >= 0 && escolhaDefensora < campoOponente.size()) {
                    Criatura defensora = campoOponente.get(escolhaDefensora);
                    realizarCombate(atacante, defensora);

                    // Se a criatura do oponente for destruída, remova-a do campo
                    if (defensora.getResistencia() <= 0) {
                        campoOponente.remove(defensora);
                        System.out.printf("A criatura %s foi destruída!\n", defensora.nome);
                    }

                    // Verifique se o jogo deve continuar com o próximo ataque
                    if (campoOponente.isEmpty()) {
                        System.out.println("Não há mais criaturas no campo do oponente. Você pode atacar diretamente o jogador.");
                        break; // Sair do loop de ataque se não há mais criaturas
                    }
                } else {
                    System.out.println("Escolha inválida.");
                }
            } else {
                System.out.println("Escolha inválida.");
            }
        }

        // Se não houver criaturas no campo do oponente, atacar diretamente o jogador
        if (campoOponente.isEmpty()) {
            if (jogador == 1) {
                vidaJogador2 -= 5; // Exemplo de dano fixo
                System.out.println("Jogador 1 atacou diretamente Jogador 2, causando 5 de dano.");
            } else {
                vidaJogador1 -= 5;
                System.out.println("Jogador 2 atacou diretamente Jogador 1, causando 5 de dano.");
            }
        }

        // Ganhar experiência (se aplicável)
        ganharExperiencia(jogador);
    }
}












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
        for (int i = 0; i < 5; i++) {
            int indiceCarta = random.nextInt(deck1.size());
            Carta carta = deck1.remove(indiceCarta); // Remove do deck1
            maoJogador1.add(carta); // Adiciona na mão do Jogador 1
        }

        // Distribuir 5 cartas para o Jogador 2
        for (int i = 0; i < 5; i++) {
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

    private void exibirCemiterio() {
        System.out.println("Cartas destruídas (Cemitério):");
        for (Carta carta : cemiterio) {
            System.out.println(carta);
        }
    }

    private void mostrarVencedor() {
        if (vidaJogador1 <= 0) {
            System.out.println("Jogador 2 venceu!");
        } else if (vidaJogador2 <= 0) {
            System.out.println("Jogador 1 venceu!");
        }
        exibirCemiterio();
    }

    private void jogarTurno(int jogador) {
            ArrayList<Carta> maoAtual = jogador == 1 ? maoJogador1 : maoJogador2;
            System.out.printf("É a vez do Jogador %d (%s)! Vida: %d, Mana: %d\n", jogador,
                    jogador == 1 ? personagem1 : personagem2,
                    jogador == 1 ? vidaJogador1 : vidaJogador2,
                    jogador == 1 ? manaJogador1 : manaJogador2);

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
                    if (cartaEscolhida instanceof Criatura) {
                        // Atacar uma criatura inimiga em campo
                        System.out.println("Escolha uma criatura inimiga em campo para atacar (0 para cancelar):");
                        ArrayList<Carta> maoInimiga = jogador == 1 ? maoJogador2 : maoJogador1;
                        ArrayList<Criatura> criaturasInimigasEmCampo = new ArrayList<>();

                        // Exibir criaturas inimigas em campo
                        for (Carta c : maoInimiga) {
                            if (c instanceof Criatura) {
                                criaturasInimigasEmCampo.add((Criatura) c);
                                System.out.println((criaturasInimigasEmCampo.size()) + ". " + c);
                            }
                        }

                        // Verifica se há criaturas inimigas em campo
                        if (!criaturasInimigasEmCampo.isEmpty()) {
                            int escolhaCriatura = scanner.nextInt() - 1;

                            if (escolhaCriatura >= 0 && escolhaCriatura < criaturasInimigasEmCampo.size()) {
                                Criatura criaturaInimiga = criaturasInimigasEmCampo.get(escolhaCriatura);
                                System.out.printf("Jogador %d atacou a criatura %s com %s!\n", jogador, criaturaInimiga.nome, cartaEscolhida.nome);

                                // Calcular dano
                                int dano = ((Criatura) cartaEscolhida).poder;

                                // Aplica dano à criatura inimiga
                                criaturaInimiga.resistencia -= dano;

                                // Verifica se a criatura inimiga foi destruída
                                if (criaturaInimiga.resistencia <= 0) {
                                    cemiterio.add(criaturaInimiga);
                                    maoInimiga.remove(criaturaInimiga);
                                    System.out.printf("A criatura %s foi destruída!\n", criaturaInimiga.nome);
                                } else {
                                    System.out.printf("A criatura %s ficou com %d de resistência após o ataque.\n", criaturaInimiga.nome, criaturaInimiga.resistencia);
                                }
                            } else {
                                System.out.println("Escolha inválida.");
                            }
                        } else {
                            System.out.println("Não há criaturas inimigas em campo para atacar.");
                        }
                    }  else if (cartaEscolhida instanceof Feitico) {
                    Feitico feitico = (Feitico) cartaEscolhida;
                    feitico.usar(this, jogador);
                } else if (cartaEscolhida instanceof Encantamento) {
                    Encantamento encantamento = (Encantamento) cartaEscolhida;
                    encantamento.aplicar(this, jogador);
                }
                    // Reduz a mana após jogar a carta
                    if (jogador == 1) {
                        manaJogador1 -= cartaEscolhida.custoMana;
                    } else {
                        manaJogador2 -= cartaEscolhida.custoMana;
                    }

                    // Adiciona a carta jogada à lista de cartas jogadas
                    if (jogador == 1) {
                        cartasJogadasJogador1.add(cartaEscolhida);
                    } else {
                        cartasJogadasJogador2.add(cartaEscolhida);
                    }
                } else {
                    System.out.println("Mana insuficiente para jogar essa carta.");
                }
            } else {
                System.out.println("Escolha inválida.");
            }

            ganharExperiencia(jogador);
        }
    }












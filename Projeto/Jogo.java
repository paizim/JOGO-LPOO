import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Jogo {
    private ArrayList<Carta> deck1;
    private ArrayList<Carta> deck2;
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
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    public void introducao() {
        System.out.println("SEJAM BEM VINDOS ÁS CRÔNICAS DE ARCANA, EM QUE VOCÊS DECIDIRAM O FUTURO DO MUNDO TABEFE EM UMA BATALHA ENTRE OS DEFENSORES DA HUMANIDADE CONTRA A HORDA DE GOBLINS.");
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
        if (classe1.equals("DEFENSORES DA HUMANIDADE")) {
            System.out.printf("SEU PERSONAGEM PERTENCE AOS %s.\n", classe1);
        } else if (classe1.equals("HORDA DOS GOBLINS")) {
            System.out.printf("SEU PERSONAGEM PERTENCE AOS %s.\n", classe1);
        } else {
            System.out.println("CLASSE INVÁLIDA.");
            reino1(); // Permitir nova escolha
        }
    }

    public void reino2() {
        System.out.printf("ESCOLHA UM REINO, %s (DEFENSORES DA HUMANIDADE ou HORDA DOS GOBLINS): ", personagem2);
        classe2 = scanner.nextLine().toUpperCase();
        if (classe2.equals("DEFENSORES DA HUMANIDADE")) {
            System.out.printf("SEU PERSONAGEM PERTENCE AOS %s.\n", classe2);
        } else if (classe2.equals("HORDA DOS GOBLINS")) {
            System.out.printf("SEU PERSONAGEM PERTENCE AOS %s.\n", classe2);
        } else {
            System.out.println("CLASSE INVÁLIDA.");
            reino2(); // Permitir nova escolha
        }
    }

    private void decidirQuemComeca() {
        System.out.println("TIREM PAR OU IMPAR PARA VER QUEM COMEÇA.");
        System.out.println("JOGADOR 1, DIGITE SUA ESCOLHA (PAR OU IMPAR): ");
        String escolhaJogador1 = scanner.nextLine().toUpperCase();
        System.out.println("JOGADOR 2, DIGITE SUA ESCOLHA (PAR OU IMPAR): ");
        String escolhaJogador2 = scanner.nextLine().toUpperCase();

        if (!escolhaJogador1.equals("PAR") && !escolhaJogador1.equals("IMPAR") ||
                !escolhaJogador2.equals("PAR") && !escolhaJogador2.equals("IMPAR")) {
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
        while (vidaJogador1 > 0 && vidaJogador2 > 0) {
            manaJogador1 += 1; // Aumenta a mana do Jogador 1
            manaJogador2 += 1; // Aumenta a mana do Jogador 2
            jogarTurno(vezDoJogador1 ? 1 : 2);
            vezDoJogador1 = !vezDoJogador1; // Alterna a vez dos jogadores
        }
        mostrarVencedor();
    }

    private void jogarTurno(int jogador) {
        ArrayList<Carta> deckAtual = jogador == 1 ? deck1 : deck2;
        System.out.printf("É a vez do Jogador %d (%s)! Vida: %d, Mana: %d\n", jogador,
                jogador == 1 ? personagem1 : personagem2,
                jogador == 1 ? vidaJogador1 : vidaJogador2,
                jogador == 1 ? manaJogador1 : manaJogador2);

        System.out.println("Escolha uma carta para jogar (0 para sair):");
        for (int i = 0; i < deckAtual.size(); i++) {
            System.out.println(i + 1 + ". " + deckAtual.get(i));
        }

        int escolha = scanner.nextInt() - 1;
        if (escolha >= 0 && escolha < deckAtual.size()) {
            Carta cartaEscolhida = deckAtual.get(escolha);
            if (cartaEscolhida.custoMana <= (jogador == 1 ? manaJogador1 : manaJogador2)) {
                if (cartaEscolhida instanceof Criatura) {
                    // Simula ataque
                    System.out.printf("Jogador %d jogou a carta %s!\n", jogador, cartaEscolhida.nome);
                    if (jogador == 1) {
                        vidaJogador2 -= ((Criatura) cartaEscolhida).poder;
                    } else {
                        vidaJogador1 -= ((Criatura) cartaEscolhida).poder;
                    }
                    // Reduz a mana do jogador após jogar a carta
                    if (jogador == 1) {
                        manaJogador1 -= cartaEscolhida.custoMana;
                    } else {
                        manaJogador2 -= cartaEscolhida.custoMana;
                    }
                } else {
                    System.out.printf("Jogador %d jogou um feitiço: %s!\n", jogador, cartaEscolhida.nome);
                    // Adicione lógica para feitiços
                    // Aqui você pode implementar a lógica para feitiços, como restaurar vida ou causar dano
                }
            } else {
                System.out.println("Mana insuficiente para jogar essa carta.");
            }
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    private void mostrarVencedor() {
        if (vidaJogador1 <= 0) {
            System.out.println("Jogador 2 venceu!");
        } else if (vidaJogador2 <= 0) {
            System.out.println("Jogador 1 venceu!");
        }
    }
}








import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private Random random = new Random();
    private boolean vezDoJogador1;
    private String personagem1, personagem2;
    private int vida1 = 100, vida2 = 100;
    private int atk = 0;
    private String escolha = "cavaleiro, mago, atirador, ogro, arlekin, bombardeiro";
    private int atkCavaleiro = 10, atkMago = 15, atkAtirador = 12;
    private int atkOgro = 20, atkArlekin = 5, atkBombardeiro = 17;
    private String classe1, classe2;
    private String deck1, deck2;
    private int rodada = 0;

    public void introducao() {
        System.out.println("BEM VINDO AO MUNDO TABEFE, EM QUE VOCÊ ESCOLHERÁ SEU PERSONAGEM E IRÁ COMBATER SEUS INIMIGOS.");
        System.out.println("JOGADOR 1 DIGITE O NOME DE SEU PERSONAGEM: ");
        personagem1 = new Scanner(System.in).nextLine().toUpperCase();
        System.out.printf("SEU PERSONAGEM: %s / VIDA: %d\n", personagem1, vida1);
        System.out.println("JOGADOR 2 DIGITE O NOME DE SEU PERSONAGEM: ");
        personagem2 = new Scanner(System.in).nextLine().toUpperCase();
        System.out.printf("SEU PERSONAGEM: %s / VIDA: %d\n", personagem2, vida2);
        decidirQuemComeca();
    }
    private void decidirQuemComeca() {
        System.out.println("TIREM PAR OU IMPAR PARA VER QUEM COMEÇA.");

        System.out.println("JOGADOR 1, DIGITE SUA ESCOLHA (PAR OU IMPAR): ");
        String escolhaJogador1 = new Scanner(System.in).nextLine().toUpperCase();

        System.out.println("JOGADOR 2, DIGITE SUA ESCOLHA (PAR OU IMPAR): ");
        String escolhaJogador2 = new Scanner(System.in).nextLine().toUpperCase();

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

    public void reino1() {
        System.out.println("EM NOSSO MUNDO EXISTEM OS REINOS DOS HUMANOS E GOBLINS.");
        System.out.printf("ESCOLHA UM REINO %s: ", personagem1);
        Scanner teclado = new Scanner(System.in);
        classe1 = teclado.nextLine().toUpperCase();
        if (classe1.equals("HUMANOS")) {
            System.out.printf("SEU PERSONAGEM PERTENCE AOS %s.", classe1);
        } else if (classe1.equals("GOBLINS")) {
            System.out.printf("SEU PERSONAGEM PERTENCE AOS %s.", classe1);
        } else {
            System.out.println("CLASSE INVÁLIDA.");
        }
    }

    public void deckPersonagem1() {
        deck1 = "\nSEU DECK É COMPOSTO POR CAVALEIROS, MAGOS E ATIRADORES";
        deck2 = "\nSEU DECK É COMPOSTO POR OGROS, ARLEKINS E BOMBARDEIROS";
        if (classe1.equals("HUMANOS")) {
            System.out.println(deck1);
        } else if (classe1.equals("GOBLINS")) {
            System.out.println(deck2);
        }
    }

    public void reino2() {
        System.out.printf("\nESCOLHA UM REINO %s: ", personagem2);
        classe2 = new Scanner(System.in).nextLine().toUpperCase();
        if (classe2.equals("HUMANOS")) {
            System.out.printf("SEU PERSONAGEM PERTENCE AOS %s.", classe2);
        } else if (classe2.equals("GOBLINS")) {
            System.out.printf("SEU PERSONAGEM PERTENCE AOS %s.", classe2);
        } else {
            System.out.println("CLASSE INVÁLIDA.");
        }
    }

    public void deckPersonagem2() {
        deck1 = "\nSEU DECK É COMPOSTO POR CAVALEIROS, MAGOS E ATIRADORES";
        deck2 = "\nSEU DECK É COMPOSTO POR OGROS, ARLEKINS E BOMBARDEIROS";
        if (classe2.equals("HUMANOS")) {
            System.out.println(deck1);
        } else if (classe2.equals("GOBLINS")) {
            System.out.println(deck2);
        }
    }
        public void iniciarBatalha() {
            while (vida1 > 0 && vida2 > 0) {
                if (vezDoJogador1){
                // Jogador 1 ataca
                realizarTurno(personagem1, personagem2, true);
                if (vida2 <= 0) {
                    System.out.printf("%s VENCEU O JOGO!",personagem1);
                    break;
                }

                // Jogador 2 ataca
                realizarTurno(personagem2, personagem1, false);
                if (vida1 <= 0) {
                    System.out.printf("%s VENCEU O JOGO!",personagem2);
                    break;
                }
                vezDoJogador1 = false;
                }else {
                    realizarTurno(personagem1, personagem2, false);
                    if (vida1 <= 0) {
                        System.out.println("JOGADOR 2 VENCEU O JOGO!");
                        break;
                    }
                    vezDoJogador1 = true;

                }
            }
        }

        private void realizarTurno(String jogadorAtacante, String jogadorDefensor, boolean ehJogador1) {
            rodada++;
            System.out.printf("\nRodada %d - %s, escolha uma de suas cartas para atacar: ", rodada, jogadorAtacante);

            escolhaCarta();

            if (ehJogador1) {
                vida2 -= atk;
            } else {
                vida1 -= atk;
            }

            System.out.printf("\nA VIDA DO %s É: %d.", jogadorDefensor, ehJogador1 ? vida2 : vida1);
        }

        private void escolhaCarta() {
            String escolha = new Scanner(System.in).nextLine().toLowerCase();

            switch (escolha) {
                case "cavaleiro":
                    atk = atkCavaleiro;
                    break;
                case "mago":
                    atk = atkMago;
                    break;
                case "atirador":
                    atk = atkAtirador;
                    break;
                case "ogro":
                    atk = atkOgro;
                    break;
                case "arlekin":
                    atk = atkArlekin;
                    break;
                case "bombardeiro":
                    atk = atkBombardeiro;
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
                    escolhaCarta();
                    break;
            }
        }

    }



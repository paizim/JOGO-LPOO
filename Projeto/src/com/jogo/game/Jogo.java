package com.jogo.game;
import com.jogo.baralho.Carta;
import com.jogo.baralho.Criatura;
import com.jogo.baralho.Encantamento;
import com.jogo.baralho.Feitico;
import com.jogo.baralho.Decks;
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
    private int manaJogador1 = 4; // Mana inicial do Jogador 1
    private int manaJogador2 = 4; // Mana inicial do Jogador 2

    public Jogo() {
        this.deck1 = Decks.criarDeck1();
        this.deck2 = Decks.criarDeck2();
        this.maoJogador1 = new ArrayList<>();
        this.maoJogador2 = new ArrayList<>();
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
        System.out.println("JOGADOR 2 DIGITE O NOME DE SEU PERSONAGEM: ");
        personagem2 = scanner.nextLine().toUpperCase();
        System.out.printf("SEU PERSONAGEM: %s / VIDA: %d\n", personagem2, vidaJogador2);
    }

    public void reino1() {
        System.out.printf("ESCOLHA UM REINO, %s (DEFENSORES DA HUMANIDADE ou HORDA DOS GOBLINS): ", personagem1);
        classe1 = scanner.nextLine().toUpperCase();
        while (!classe1.equals("DEFENSORES DA HUMANIDADE") && !classe1.equals("HORDA DOS GOBLINS")) {
            System.out.println("CLASSE INVÁLIDA. TENTE NOVAMENTE.");
            classe1 = scanner.nextLine().toUpperCase();
        }
        System.out.printf(personagem1 + " PERTENCE AOS %s.\n", classe1);
    }

    public void reino2() {
        System.out.printf("ESCOLHA UM REINO, %s (DEFENSORES DA HUMANIDADE ou HORDA DOS GOBLINS): ", personagem2);
        classe2 = scanner.nextLine().toUpperCase();
        while (!classe2.equals("DEFENSORES DA HUMANIDADE") && !classe2.equals("HORDA DOS GOBLINS")) {
            System.out.println("CLASSE INVÁLIDA. TENTE NOVAMENTE.");
            classe2 = scanner.nextLine().toUpperCase();
        }
        System.out.printf(personagem2 + " PERTENCE AOS %s.\n", classe2);
    }

    private void ganharExperiencia(int jogador) {
        if (jogador == 1) {
            experienciaJogador1 += 10; // Ganhar 10 de experiência a cada turno
            System.out.println(personagem1 + " ganhou 10 de experiência! Total:" + experienciaJogador1);
            verificarSubirNivel(1);
        } else {
            experienciaJogador2 += 10; // Ganhar 10 de experiência a cada turno
            System.out.println(personagem2 + " ganhou 10 de experiência! Total:" + experienciaJogador2);
            verificarSubirNivel(2);
        }
    }

    private void verificarSubirNivel(int jogador) {
        int experienciaParaSubir = 100 * (jogador == 1 ? nivelJogador1 : nivelJogador2); // Exemplo: 100 XP por nível
        if ((jogador == 1 && experienciaJogador1 >= experienciaParaSubir) ||
                (jogador == 2 && experienciaJogador2 >= experienciaParaSubir)) {
            if (jogador == 1) {
                nivelJogador1++;
                System.out.println(personagem1 + " subiu para o nível" + nivelJogador1);
            } else {
                nivelJogador2++;
                System.out.println(personagem2 + " subiu para o nível" + nivelJogador2);
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
            System.out.println(personagem1 + " COMEÇA O JOGO!");
        } else {
            vezDoJogador1 = false;
            System.out.println(personagem2 + " COMEÇA O JOGO!");
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
        System.out.println("Cartas do " + personagem1 + ":");
        for (Carta c : maoJogador1) {
            System.out.println(c);
        }
        System.out.println("Cartas do " + personagem2 + ":");
        for (Carta c : maoJogador2) {
            System.out.println(c);
        }
    }
    private ArrayList<Carta> escolherDeck(String classe) {
        if (classe.equals("DEFENSORES DA HUMANIDADE")) {
            return Decks.criarDeck1(); // Retorna o deck dos Defensores da Humanidade
        } else {
            return Decks.criarDeck2(); // Retorna o deck da Horda dos Goblins
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
            System.out.println(personagem2 + " venceu!");
        } else if (vidaJogador2 <= 0) {
            System.out.println(personagem1 + " venceu!");
        }
        exibirCemiterio();
    }

    // Função para jogar uma criatura no campo
    private void usarCriatura(int jogador, Criatura criatura) {
        if (jogador == 1) {
            maoJogador1.remove(criatura);
            campoJogador1.add(criatura);
            manaJogador1 -= criatura.getCustoMana();
            System.out.println(personagem1 + " jogou a criatura: " + criatura.getNome());
            criatura.mostrarAtributos();
        } else {
            maoJogador2.remove(criatura);
            campoJogador2.add(criatura);
            manaJogador2 -= criatura.getCustoMana();
            System.out.println(personagem2 + " jogou a criatura: " + criatura.getNome());
            criatura.mostrarAtributos();
        }
    }

    private void colocarNoCampo(int jogador, int indiceCarta) {
        Carta carta = (jogador == 1) ? maoJogador1.remove(indiceCarta) : maoJogador2.remove(indiceCarta);
        if (jogador == 1) {
            campoJogador1.add((Criatura) carta);
            System.out.println(personagem1 + " colocou " + carta.getNome() + " no campo de batalha.");
        } else {
            campoJogador2.add((Criatura) carta);
            System.out.println(personagem2 + " colocou " + carta.getNome() + " no campo de batalha.");
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
                System.out.println(personagem1 + " atacou Jogador 2, causando " + criatura.getPoder() + " de dano.");
            } else {
                vidaJogador1 -= criatura.getPoder();
                System.out.println(personagem2 + " atacou Jogador 1, causando " + criatura.getPoder() + " de dano.");
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
            System.out.println(personagem1 + " puxou " + novaCarta1.getNome());
        }
        if (!escolherDeck(classe2).isEmpty()) {
            Carta novaCarta2 = escolherDeck(classe2).remove(random.nextInt(escolherDeck(classe2).size()));
            maoJogador2.add(novaCarta2);
            System.out.println(personagem2 + " puxou " + novaCarta2.getNome());
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
                System.out.println((j + 1) + ". " + carta.getNome() + " (Custo de Mana: " + carta.getCustoMana() + ")" + atributos);
            }

            int escolha = scanner.nextInt() - 1;
            if (escolha != -1 && escolha >= 0 && escolha < maoAtual.size()) {
                Carta cartaEscolhida = maoAtual.get(escolha);
                try {
                    if (cartaEscolhida.getCustoMana() > manaAtual) {
                        throw new ManaInsuficienteException("Mana insuficiente para jogar a carta " + cartaEscolhida.getNome() + ".");
                    }
                    if (cartaEscolhida instanceof Criatura) {
                        if (jogadorAtual == 1) {
                            campoJogador1.add((Criatura) cartaEscolhida);
                        } else {
                            campoJogador2.add((Criatura) cartaEscolhida);
                        }
                        maoAtual.remove(escolha);
                        System.out.printf("%s foi colocada no campo.\n", cartaEscolhida.getNome());
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
                        manaJogador1 -= cartaEscolhida.getCustoMana();
                    } else {
                        manaJogador2 -= cartaEscolhida.getCustoMana();
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
                    System.out.printf("%d. %s (Poder: %d, Resistência: %d)\n", i + 1, criatura.getNome(), criatura.getPoder(), criatura.getResistencia());
                }

                int escolhaAtacante = scanner.nextInt() - 1;
                if (escolhaAtacante >= 0 && escolhaAtacante < campoAtual.size()) {
                    Criatura atacante = campoAtual.get(escolhaAtacante);

                    if (!campoOponente.isEmpty()) {
                        System.out.println("Escolha uma criatura do oponente para atacar:");
                        for (int i = 0; i < campoOponente.size(); i++) {
                            Criatura defensora = campoOponente.get(i);
                            System.out.printf("%d. %s (Poder: %d, Resistência: %d)\n", i + 1, defensora.getNome(), defensora.getPoder(), defensora.getResistencia());
                        }
                        int escolhaDefensora = scanner.nextInt() - 1;
                        if (escolhaDefensora >= 0 && escolhaDefensora < campoOponente.size()) {
                            Criatura defensora = campoOponente.get(escolhaDefensora);
                            realizarCombate(atacante, defensora);
                            if (defensora.getResistencia() <= 0) {
                                campoOponente.remove(defensora);
                                System.out.printf("A criatura %s foi destruída!\n", defensora.getNome());
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
        System.out.println("Fim do turno: Vida " + personagem1 + ": " + vidaJogador1 + ", Vida " + personagem2 + ": " + vidaJogador2);
        ganharExperiencia(1); // Jogador 1 ganha experiência
        ganharExperiencia(2); // Jogador 2 ganha experiência
    }
}























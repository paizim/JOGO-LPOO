import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class InterfaceCronicas extends JFrame {
    private Jogo jogo; //  classe Jogo para integração

    private JLabel perguntaLabel;
    private JTextField campoEntrada;
    private String personagem1, personagem2, deck1, deck2;
    private int etapaPergunta = 0;

    private JLabel infoJogador1Nome;
    private JLabel infoJogador1Vida;
    private JLabel infoJogador1Mana;
    private JLabel infoJogador1Deck;
    private JLabel infoJogador2Nome;
    private JLabel infoJogador2Vida;
    private JLabel infoJogador2Mana;
    private JLabel infoJogador2Deck;
    private Font pressStart2PFont;
    private Image backgroundImage;

    private JPanel painelInfoJogadores;
    private JButton comecarButton;

    private String escolhaParOuImpar;
    private int numeroSorteado;
    private String vencedor;

    public InterfaceCronicas(Jogo jogo) {
        this.jogo = jogo; // conecta a interface à logica do jogo

        // carregar fonte
        try {
            pressStart2PFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/PressStart2P.ttf")).deriveFont(18f);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar a fonte PressStart2P.");
        }

        // carregar a imagem
        try {
            backgroundImage = ImageIO.read(new File("src/images/background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar a imagem de fundo.");
        }

        JPanel painelInferior = new JPanel();
        painelInferior.setLayout(new BorderLayout());
        painelInferior.setOpaque(false);

        perguntaLabel = new JLabel("CRÔNICAS DE ARCANA", SwingConstants.CENTER);
        perguntaLabel.setFont(pressStart2PFont);
        perguntaLabel.setForeground(Color.WHITE);

        campoEntrada = new JTextField();
        campoEntrada.setFont(pressStart2PFont);
        campoEntrada.setForeground(Color.BLACK);
        campoEntrada.setVisible(false);
        campoEntrada.setPreferredSize(new Dimension(campoEntrada.getPreferredSize().width, campoEntrada.getPreferredSize().height * 2));

        // ActionListener para capturar as respostas do jogador
        campoEntrada.addActionListener(e -> {
            String resposta = campoEntrada.getText().trim(); // Captura o texto inserido
            if (!resposta.isEmpty()) {
                processarResposta(resposta);
                campoEntrada.setText("");
            }
        });

        comecarButton = new JButton("Começar");
        comecarButton.setFont(pressStart2PFont);
        comecarButton.setForeground(Color.BLACK);

        // Ação do botão começar
        comecarButton.addActionListener(e -> {
            iniciarPerguntas();
            comecarButton.setVisible(false);
            painelInfoJogadores.setVisible(true);
            campoEntrada.setVisible(true);
            campoEntrada.setEnabled(true);
        });

        setTitle("Crônicas de Arcana");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        BackgroundPanel mainPanel = new BackgroundPanel();
        mainPanel.setLayout(new BorderLayout());
        setContentPane(mainPanel);

        // Painel de informações dos jogadores
        painelInfoJogadores = new JPanel();
        painelInfoJogadores.setLayout(new GridLayout(4, 2));
        painelInfoJogadores.setOpaque(false);
        painelInfoJogadores.setVisible(false);

        infoJogador1Nome = new JLabel("Jogador 1: ", SwingConstants.LEFT);
        infoJogador1Vida = new JLabel("Vida: ", SwingConstants.LEFT);
        infoJogador1Mana = new JLabel("Mana: ", SwingConstants.LEFT);
        infoJogador1Deck = new JLabel("Reino: ", SwingConstants.LEFT);

        infoJogador2Nome = new JLabel("Jogador 2: ", SwingConstants.RIGHT);
        infoJogador2Vida = new JLabel("Vida: ", SwingConstants.RIGHT);
        infoJogador2Mana = new JLabel("Mana: ", SwingConstants.RIGHT);
        infoJogador2Deck = new JLabel("Reino: ", SwingConstants.RIGHT);

        ajustarFonteCor(infoJogador1Nome, infoJogador1Vida, infoJogador1Mana, infoJogador1Deck);
        ajustarFonteCor(infoJogador2Nome, infoJogador2Vida, infoJogador2Mana, infoJogador2Deck);

        painelInfoJogadores.add(infoJogador1Nome);
        painelInfoJogadores.add(infoJogador2Nome);
        painelInfoJogadores.add(infoJogador1Vida);
        painelInfoJogadores.add(infoJogador2Vida);
        painelInfoJogadores.add(infoJogador1Mana);
        painelInfoJogadores.add(infoJogador2Mana);
        painelInfoJogadores.add(infoJogador1Deck);
        painelInfoJogadores.add(infoJogador2Deck);

        mainPanel.add(painelInfoJogadores, BorderLayout.NORTH);

        painelInferior.add(perguntaLabel, BorderLayout.NORTH);
        painelInferior.add(campoEntrada, BorderLayout.CENTER);
        painelInferior.add(comecarButton, BorderLayout.SOUTH);

        mainPanel.add(painelInferior, BorderLayout.SOUTH);

        // Timer para atualizar as informações
        Timer timer = new Timer(1000, e -> atualizarInformacoes());
        timer.start();
    }

    private void ajustarFonteCor(JLabel... labels) {
        for (JLabel label : labels) {
            label.setFont(pressStart2PFont);
            label.setForeground(Color.WHITE);
        }
    }

    private void iniciarPerguntas() {
        campoEntrada.setEnabled(true);
        perguntaLabel.setText("<html>JOGADOR 1, DIGITE O NOME DE SEU PERSONAGEM:</html>");
        etapaPergunta = 1;
    }

    private void atualizarInformacoes() {
        infoJogador1Vida.setText("Vida: " + jogo.getVidaJogador1());
        infoJogador1Mana.setText("Mana: " + jogo.getManaJogador1());
        infoJogador2Vida.setText("Vida: " + jogo.getVidaJogador2());
        infoJogador2Mana.setText("Mana: " + jogo.getManaJogador2());
    }

    // Classe para o painel com fundo
    class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    private void processarResposta(String resposta) {
        switch (etapaPergunta) {
            case 1: {
                personagem1 = resposta;
                infoJogador1Nome.setText("Jogador 1: " + personagem1);
                perguntaLabel.setText("<html>JOGADOR 2, DIGITE O NOME DE SEU PERSONAGEM:</html>");
                etapaPergunta = 2;
                break;
            }
            case 2: {
                personagem2 = resposta;
                infoJogador2Nome.setText("Jogador 2: " + personagem2);
                perguntaLabel.setText("<html>JOGADOR 1, ESCOLHA UM REINO (DEFENSORES DA HUMANIDADE ou HORDA DOS GOBLINS):</html>");
                etapaPergunta = 3;
                break;
            }
            case 3: {
                resposta = resposta.toUpperCase(); // Para validar o input em maiúsculas, como no console
                if (resposta.equals("DEFENSORES DA HUMANIDADE") || resposta.equals("HORDA DOS GOBLINS")) {
                    deck1 = resposta;
                    infoJogador1Deck.setText("Reino: " + deck1);
                    perguntaLabel.setText("<html>JOGADOR 2, ESCOLHA UM REINO (DEFENSORES DA HUMANIDADE ou HORDA DOS GOBLINS):</html>");
                    etapaPergunta = 4;
                } else {
                    perguntaLabel.setText("<html>OPÇÃO INVÁLIDA. ESCOLHA UM REINO VÁLIDO (DEFENSORES DA HUMANIDADE ou HORDA DOS GOBLINS):</html>");
                }
                break;
            }
            case 4: {
                resposta = resposta.toUpperCase(); // Para validar o input em maiúsculas
                if (resposta.equals("DEFENSORES DA HUMANIDADE") || resposta.equals("HORDA DOS GOBLINS")) {
                    deck2 = resposta;
                    infoJogador2Deck.setText("Reino: " + deck2);
                    perguntaLabel.setText("<html>ESCOLHA: PAR OU ÍMPAR?</html>");
                    etapaPergunta = 5;
                } else {
                    perguntaLabel.setText("<html>OPÇÃO INVÁLIDA. ESCOLHA UM REINO VÁLIDO (DEFENSORES DA HUMANIDADE ou HORDA DOS GOBLINS):</html>");
                }
                break;
            }
            case 5: {
                escolhaParOuImpar = resposta.toLowerCase();
                numeroSorteado = (int) (Math.random() * 10) + 1;

                vencedor = ((numeroSorteado % 2 == 0 && escolhaParOuImpar.equals("par")) ||
                        (numeroSorteado % 2 != 0 && escolhaParOuImpar.equals("ímpar")))
                        ? personagem1 : personagem2;

                perguntaLabel.setText("<html>" + vencedor + " começará jogando!<br>(Número sorteado: " + numeroSorteado + ")</html>");
                campoEntrada.setEnabled(false);
                break;
            }
            default: {
                perguntaLabel.setText("Erro inesperado. Reinicie o jogo.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Jogo jogo = new Jogo();
            new InterfaceCronicas(jogo).setVisible(true);
        });
    }
}
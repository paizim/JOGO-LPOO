import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoGUI extends JFrame {
    private Jogo jogo; // A classe do jogo
    private JTextArea areaTexto;
    private JButton botaoIniciar;
    private JButton botaoAtacar;
    private JButton botaoColocarCarta;
    private JButton botaoPuxarCarta;

    public JogoGUI() {
        jogo = new Jogo();
        setTitle("Crônicas de Arcana");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        botaoIniciar = new JButton("Iniciar Jogo");
        botaoAtacar = new JButton("Atacar");
        botaoColocarCarta = new JButton("Colocar Carta");
        botaoPuxarCarta = new JButton("Puxar Carta");

        painelBotoes.add(botaoIniciar);
        painelBotoes.add(botaoColocarCarta);
        painelBotoes.add(botaoPuxarCarta);
        painelBotoes.add(botaoAtacar);
        add(painelBotoes, BorderLayout.SOUTH);

        botaoIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogo.iniciar();
                areaTexto.setText("O jogo começou!\n");
                areaTexto.append("Vida Jogador 1: " + jogo.getVidaJogador1() + "\n");
                areaTexto.append("Vida Jogador 2: " + jogo.getVidaJogador2() + "\n");
            }
        });

        botaoColocarCarta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para colocar carta
                areaTexto.append("Colocando carta...\n");
                // Chamar a função correspondente do jogo
            }
        });

        botaoPuxarCarta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para puxar carta
                areaTexto.append("Puxando nova carta...\n");
                // Chamar a função correspondente do jogo
            }
        });

        botaoAtacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar lógica para atacar
                areaTexto.append("Atacando...\n");
                // Chamar a função correspondente do jogo
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JogoGUI gui = new JogoGUI();
            gui.setVisible(true);
        });
    }
}


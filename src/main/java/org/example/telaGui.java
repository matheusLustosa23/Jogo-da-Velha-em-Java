package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class telaGui extends JFrame implements ActionListener {
    //contadores
    int X_player,O_player,moveCounter;

    private JLabel virarRotulo,placar,resultLabel;
    private JButton[][]board;
    private JDialog resultDialog;
    private boolean PrimeiroJogador;

    public telaGui(){
      super("Jogo da Velha");
      setSize(constantes.FRAME_SIZE);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      setLocationRelativeTo(null);
      setLayout(null);
      getContentPane().setBackground(constantes.BACKGROUND_COLOR);

      criarResultado();
      board=new  JButton[3][3];
      PrimeiroJogador=true;
      adicionarComponente();



    }

    public void adicionarComponente(){
        //barra superior
        JLabel barraSuperior=new JLabel();
        barraSuperior.setOpaque(true);
        barraSuperior.setBackground(constantes.BARRA_SUPERIOR);
        barraSuperior.setBounds(0,0,constantes.FRAME_SIZE.width,25);

        //virar Rótulo
        virarRotulo=new JLabel(constantes.X_LABEL);
        virarRotulo.setHorizontalAlignment(SwingConstants.CENTER);
        virarRotulo.setFont(new Font("Arial",Font.PLAIN,25));
        virarRotulo.setPreferredSize(new Dimension(100,virarRotulo.getPreferredSize().height));
        virarRotulo.setOpaque(true);
        virarRotulo.setBackground(constantes.X_COLOR);
        virarRotulo.setForeground(constantes.BACKGROUND_COLOR);
        virarRotulo.setBounds(
                (constantes.FRAME_SIZE.width-virarRotulo.getPreferredSize().width)/2,
                0,
                virarRotulo.getPreferredSize().width,
                virarRotulo.getPreferredSize().height
        );

        //placar
        placar=new JLabel(constantes.PLACAR_LABEL);
        placar.setFont(new Font("Arial",Font.PLAIN,25));
        placar.setHorizontalAlignment(SwingConstants.CENTER);
        placar.setForeground(constantes.PLACAR_COLOR);
        placar.setBounds(0,
                virarRotulo.getY()+placar.getPreferredSize().height+25,
                constantes.FRAME_SIZE.width,
                placar.getPreferredSize().height
        );

        //quadro do jogo
        GridLayout gridLayout=new GridLayout(3,3);
        JPanel boardPanel=new JPanel(gridLayout);
        boardPanel.setBounds(0,
                                placar.getY()+placar.getPreferredSize().height+35,
                                constantes.BOARD_SIZE.width,
                                constantes.BOARD_SIZE.height
                );

       //criação do  tabuleiro
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){

                JButton botao=new JButton();
                botao.setFont(new Font("Arial",Font.PLAIN,180));
                botao.setPreferredSize(constantes.BUTTON_SIZE);
                botao.setBackground(constantes.BOTAO_COLOR_FUNDO);
                botao.addActionListener(this);
                botao.setBorder(BorderFactory.createLineBorder(constantes.BACKGROUND_COLOR));


                //adicionando butões
                board[i][j]=botao;
                boardPanel.add(board[i][j]);
            }
        }
    //botão de resetar
        JButton resetarButao=new JButton("Reiniciar");
        resetarButao.setFont(new Font("Arial",Font.PLAIN,24));
        resetarButao.addActionListener(this);
        resetarButao.setBackground(constantes.X_COLOR);
        resetarButao.setBounds((constantes.FRAME_SIZE.width-resetarButao.getPreferredSize().width)/2,
                constantes.FRAME_SIZE.height-100,
                resetarButao.getPreferredSize().width,
                resetarButao.getPreferredSize().height
        );




        getContentPane().add(virarRotulo);
        getContentPane().add(barraSuperior);
        getContentPane().add(placar);
        getContentPane().add(boardPanel);
       getContentPane().add(resetarButao);



    }
    public void criarResultado(){
        resultDialog=new JDialog();
        resultDialog.getContentPane().setBackground(constantes.BACKGROUND_COLOR);
        resultDialog.setResizable(false);
        resultDialog.setTitle("Resultado");
        resultDialog.setSize(constantes.DIALOG_SIZE);
        resultDialog.setLocationRelativeTo(this);
        resultDialog.setLayout(new GridLayout(2,1));
        resultDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                resetarJogo();
            }
        });

    }
    public void resetarJogo(){
         System.out.println("jogo resetado");
    }











    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

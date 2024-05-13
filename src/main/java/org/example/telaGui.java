package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class telaGui extends JFrame implements ActionListener {
    //contadores
    int X_Pontos,O_Pontos,contadorMovimento;

    private JLabel virarRotulo,placar,resultLabel;
    private JButton[][]tabuleiro;
    private JDialog resultDialog;
    private boolean PrimeiroJogador;

    public telaGui(){
      super("Jogo da Velha");
      setSize(constantes.FRAME_SIZE);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      setLocationRelativeTo(null);
      setLayout(null);
      getContentPane().setBackground(constantes.BLUE_COLOR);

      criarResultado();
      tabuleiro=new JButton[3][3];
      PrimeiroJogador=true;
      adicionarComponente();



    }

    private void adicionarComponente(){
        //barra superior
        JLabel barraSuperior=new JLabel();
        barraSuperior.setOpaque(true);
        barraSuperior.setBackground(constantes.WHITE_COLOR);
        barraSuperior.setBounds(0,0,constantes.FRAME_SIZE.width,25);

        //virar Rótulo
        virarRotulo=new JLabel(constantes.X_LABEL);
        virarRotulo.setHorizontalAlignment(SwingConstants.CENTER);
        virarRotulo.setFont(new Font("Arial",Font.PLAIN,25));
        virarRotulo.setPreferredSize(new Dimension(100,virarRotulo.getPreferredSize().height));
        virarRotulo.setOpaque(true);
        virarRotulo.setBackground(constantes.GREEN_COLOR);
        virarRotulo.setForeground(constantes.BLACK_COLOR);
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
        placar.setForeground(constantes.WHITE_COLOR);
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
        for(int i=0;i<tabuleiro.length;i++){
            for(int j=0;j<tabuleiro[i].length;j++){

                JButton botao=new JButton();
                botao.setFont(new Font("Arial",Font.PLAIN,180));
                botao.setPreferredSize(constantes.BUTTON_SIZE);
                botao.setBackground(constantes.WHITE_COLOR);
                botao.addActionListener(this);
                botao.setBorder(BorderFactory.createLineBorder(constantes.BLACK_COLOR));


                //adicionando butões
                tabuleiro[i][j]=botao;
                boardPanel.add(tabuleiro[i][j]);
            }
        }
    //botão de resetar
        JButton resetarButao=new JButton("Reiniciar");
        resetarButao.setFont(new Font("Arial",Font.PLAIN,24));
        resetarButao.addActionListener(this);
        resetarButao.setBackground(constantes.GREEN_COLOR);
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
    private void criarResultado(){
        resultDialog=new JDialog();
        resultDialog.getContentPane().setBackground(constantes.WHITE_COLOR);
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

        //result label
        resultLabel=new JLabel();
        resultLabel.setFont(new Font("Dialog",Font.BOLD,18));
        resultLabel.setForeground(constantes.BLACK_COLOR);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //restart button
        JButton reiniciarBotao=new JButton("Jogar Novamente");
        reiniciarBotao.setBackground(constantes.BLUE_COLOR);
        reiniciarBotao.addActionListener(this);


        resultDialog.add(resultLabel);
        resultDialog.add(reiniciarBotao);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String comando=e.getActionCommand();

    if(comando.equals("Reiniciar") || comando.equals("jogar novamente")){
        //reiniciar o jogo
         resetarJogo();

         //somente zerar a pontuacao
         if (comando.equals("Reiniciar")){
             X_Pontos=O_Pontos=0;
         }

         if(comando.equals("jogar novamente")){
             resultDialog.setVisible(false);


        }

    }else{
        //movimento do jogador
        JButton botao=(JButton) e.getSource();
        if(botao.getText().equals("")){
            contadorMovimento++;
            //marca o botao  com x/o somente se ele ainda tiver sido selecionado
            if (PrimeiroJogador){
                //Primeiro Jogador (X)
                botao.setText(constantes.X_LABEL);
                botao.setForeground(constantes.GREEN_COLOR);

                //alternar a vez no rótulo
                virarRotulo.setText(constantes.O_LABEL);
                virarRotulo.setBackground(constantes.YELLOW_COLOR);

                //alternar o jogador
                PrimeiroJogador=false;


            }else{
                //segundo Jogador (O)
                botao.setText(constantes.O_LABEL);
                botao.setForeground(constantes.YELLOW_COLOR);

                //alternar a vez no rótulo
                virarRotulo.setText(constantes.X_LABEL);
                virarRotulo.setBackground(constantes.GREEN_COLOR);

                //alterar jogador
                PrimeiroJogador=true;
            }
            //checkando condiçoes de vitoria
            if (PrimeiroJogador){
                //verificar se a ultima jogada de O foi o lance vencedor
                verificarVitoriaO();

            }else{
                //verificar se a ultima jogada de X foi o lance vencedor
                verificarVitoriaX();
            }
            //checkando empate
            verificarEmpate();
            //atualizando placar
            placar.setText("X: "+X_Pontos+" | O: "+O_Pontos);
        }
        //testar esses métodos
        repaint();
        revalidate();
    }

    }
    private void verificarVitoriaX(){
      String resultado="X venceu!";
      //verificando linhas
        for (int linha=0;linha<tabuleiro.length;linha++){
            if (tabuleiro[linha][0].getText().equals("X") && tabuleiro[linha][1].getText().equals("X") && tabuleiro[linha][2].getText().equals("X")){
                resultLabel.setText(resultado);
                //exibir resultado
                resultDialog.setVisible(true);
                //atualizar pontuaçao
                X_Pontos++;

            }
        }



    }
    private void verificarVitoriaO(){}
    private void verificarEmpate(){}


    public void resetarJogo(){



}}

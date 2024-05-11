package org.example;

import java.awt.*;

public class constantes {
    //cores

    public static final Color BACKGROUND_COLOR=Color.decode("#000001");//black
    public static final Color X_COLOR=Color.decode("#00FF00");//verde
   public static final Color O_COLOR=Color.decode("#FFFF00");//amarelo
    public static final Color BARRA_SUPERIOR=Color.decode("#FFFFFF");//branco
    public static final Color PLACAR_COLOR=Color.decode("#FFFFFF");//branco
    public static final Color BOTAO_COLOR_FUNDO=Color.decode("#FFFFFF");//branco
  //  public static final Color BOARD_COLOR=Color.decode("#000001");


    //tamanhos

    //quadro
    public static final Dimension FRAME_SIZE=new Dimension(540,760);
    //
    public static final Dimension BOARD_SIZE=new Dimension((int)(FRAME_SIZE.width*0.96),(int)(FRAME_SIZE.height*0.60));
    //botão
    public static final Dimension BUTTON_SIZE=new Dimension(100,100);
    //caixa resultado
    public static final Dimension DIALOG_SIZE=new Dimension((int)(FRAME_SIZE.width/3),(int)(FRAME_SIZE.height/6) );


            /*


    public static final Dimension RESULT_DIAOLOG_LABEL*/


    //valores
    public static final String X_LABEL="X";
    public static final String O_LABEL="O";
    public static final String PLACAR_LABEL="X 0 | O: 0";

}

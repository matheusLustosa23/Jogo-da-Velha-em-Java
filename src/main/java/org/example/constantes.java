package org.example;

import java.awt.*;

public class constantes {
    //cores

    public static final Color BLACK_COLOR=Color.decode("#000001");
    public static final Color GREEN_COLOR=Color.decode("#00FF00");
    public static final Color YELLOW_COLOR=Color.decode("#FFFF00");
    public static final Color WHITE_COLOR=Color.decode("#FFFFFF");
    public static final Color BLUE_COLOR=Color.decode("#00D7FF");
    public static final Color RED_COLOR=Color.decode("#FF0000");




    //tamanhos

    //quadro
    public static final Dimension FRAME_SIZE=new Dimension(540,760);
    //
    public static final Dimension BOARD_SIZE=new Dimension((int)(FRAME_SIZE.width*0.96),(int)(FRAME_SIZE.height*0.60));
    //botão
    public static final Dimension BUTTON_SIZE=new Dimension(100,100);
    //caixa resultado
    public static final Dimension DIALOG_SIZE=new Dimension((int)(FRAME_SIZE.width/3),(int)(FRAME_SIZE.height/6) );




    //valores
    public static final String X_LABEL="X";
    public static final String O_LABEL="O";
    public static final String PLACAR_LABEL="X 0 | O: 0";

}

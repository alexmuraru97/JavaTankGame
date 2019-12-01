package paoo;

import paoo.Game.*;
import paoo.Game.Menu;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws Exception{
        GameView theView = new GameView();
        Menu meniu=new Menu();

        meniu.setPreferredSize(new Dimension(Map.BOARD_WIDTH + 16, Map.BOARD_HEIGHT));

        Board panel = new Board();
        CollisionUtility.set(panel.GetItems());
        panel.revalidate();
        panel.repaint();


        theView.getPanel().add(meniu);
        theView.getPanel().add(panel);

        meniu.setVisible(false);
        panel.setVisible(true);

        theView.setVisible(true);

        Game game=new Game(panel, meniu);
        meniu.setGame(game);
        panel.SetGame(game);
        ScoreBoard.getInstance().SetMeniu(meniu);
        panel.requestFocusInWindow();
        game.start();
    }
}

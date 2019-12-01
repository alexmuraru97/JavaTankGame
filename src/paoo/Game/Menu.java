package paoo.Game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
    private Game game;
    boolean started=false;
    JLabel scor=new JLabel();
    JLabel winner=new JLabel();
    public Menu(){

        setLayout(null);

        scor.setForeground(Color.white);
        scor.setBounds(Map.BOARD_WIDTH/2-50,20,3*Map.BOARD_WIDTH/4,100);
        this.add(scor);

        winner.setForeground(Color.white);
        winner.setBounds(Map.BOARD_WIDTH/2-55,40,3*Map.BOARD_WIDTH/4,100);
        this.add(winner);

        JButton newGame=new JButton("New Game");
        newGame.setBackground(Color.white);
        newGame.setPressedIcon(null);
        newGame.setBounds(Map.BOARD_WIDTH/2-Map.BOARD_WIDTH/8,200,Map.BOARD_WIDTH/4,100);
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                started=true;
               game.NewGame();
            }
        });
        this.add(newGame);

        JButton continueGame=new JButton("Continue");
        continueGame.setBackground(Color.white);
        continueGame.setPressedIcon(null);
        continueGame.setBounds(Map.BOARD_WIDTH/2-Map.BOARD_WIDTH/8,400,Map.BOARD_WIDTH/4,100);
        continueGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(started){
                    game.Continue();
                }
                else{
                    game.NewGame();
                }

            }
        });
        this.add(continueGame);


        JButton exit=new JButton("Exit");
        exit.setBackground(Color.white);
        exit.setPressedIcon(null);
        exit.setBounds(Map.BOARD_WIDTH/2-Map.BOARD_WIDTH/8,600,Map.BOARD_WIDTH/4,100);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        this.add(exit);


    }


    @Override

    public void paintComponent(Graphics g) {
        g.drawImage(ImageLoader.getInstance().getBackground(), 0, 0 , getWidth(), getHeight(), null);
    }


    public void setGame(Game game){
        this.game=game;
    }


}

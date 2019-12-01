package paoo.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import paoo.Items.*;
import paoo.PowerUps.HpUp;
import paoo.PowerUps.RocketBoost;
import paoo.PowerUps.Shield;
import paoo.PowerUps.SpeedBoost;

import javax.swing.JPanel;
/**
 * Board class of the game
 */
public class Board extends JPanel implements ActionListener {

    private ArrayList<Item> items = new ArrayList<>();
    boolean []powerups=new boolean[4];
    Timer timer = new Timer();
    private boolean timed=false;
    private ArrayList<Item> toBeRemoved=new ArrayList<>();
    private ArrayList<Item> toBeAdded=new ArrayList<>();
    public ArrayList<Item> GetItems()
    {
        return items;
    }
    private Monster player1;
    private boolean ChangeLvl=false;
    private Monster player2;
    private int level=1;
    private ScoreBoard score=ScoreBoard.getInstance();
    private Game theGame;

    public void SetGame(Game a)
    {
        theGame=a;
    }

    public void RequestMenu(){
        theGame.SetMenu(true);
    }
    public Board() { }


    public boolean GetChangeLvl(){return ChangeLvl;}

    public void SetChangeLvl(boolean val){ChangeLvl=val;}



    //Add the item that have to be removed in the queue
    public void RemoveItem(Item item){
        toBeRemoved.add(item);
    }
    public void AddItem(Item item){
        toBeAdded.add(item);
    }

    //After Position update, start to iterate the toBeRemoved list, destroying each element 1 by 1
    public void RemoveItems(){

        while(toBeRemoved.size()>0)
        {
            try{
                Item a=toBeRemoved.get(0);
                items.remove(a);
                toBeRemoved.remove(a);
            }
            catch(Exception e){
                System.out.println("Error removing items list");
            }

        }
    }

    //After Position update, start to iterate the toBeRemoved list, destroying each element 1 by 1
    public void AddItems(){
        while(toBeAdded.size()>0)
        {
            try{
                Item a=toBeAdded.get(0);
                items.add(a);
                toBeAdded.remove(a);
            }
            catch(Exception e){
                System.out.println("Error adding items list");
            }

        }
    }
    /**
     * Initialize the board.
     */

    public void ClearBoard(){
        if(items.size()>0)
        {
            for (Item item : items) {
                RemoveItem(item);
            }
        }
        toBeAdded.clear();
        player1.ReinitPlayer();
        player2.ReinitPlayer();
        level=1;
        initBlocks(level);
        AddItem(player1);
        AddItem(player2);
        ScoreBoard.getInstance().ResetScore();
    }
    public void initBoard() {
        setFocusable(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(Map.BOARD_WIDTH, Map.BOARD_HEIGHT));
        initBlocks(level);
        player1=new Monster(100,60, this, KeyEvent.VK_W,KeyEvent.VK_S,KeyEvent.VK_A, KeyEvent.VK_D,KeyEvent.VK_Q,ImageLoader.getInstance().getMonster2Up(),ImageLoader.getInstance().getMonster2Down(),ImageLoader.getInstance().getMonster2Left(),ImageLoader.getInstance().getMonster2Right());
        player2=new Monster(1050,750, this, KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT,KeyEvent.VK_SPACE,ImageLoader.getInstance().getMonster1Up(),ImageLoader.getInstance().getMonster1Down(),ImageLoader.getInstance().getMonster1Left(),ImageLoader.getInstance().getMonster1Right());
        player1.SetEnemy(player2);
        player2.SetEnemy(player1);
        AddItem(player1);
        AddItem(player2);
        ScoreBoard.getInstance().ResetScore();
    }

    /**
     * Initialize blocks according to the map.
     */
    void initBlocks(int i) {
        int type;
        int [][]a=Map.GetLevel(i);
        for (int x = 0; x < a.length; x++) {
            for (int y = 0; y < a[0].length; y++) {
                type = a[x][y];
                BlockType bType = BlockType.getTypeFromInt(type);
                switch (bType) {
                    case GRASS:
                        items.add(new Grass(y * 48, x * 48));
                        break;
                    case SOIL:
                        items.add(new Soil(y * 48, x * 48));
                        break;
                    case WATER:
                        items.add(new Water(y * 48, x * 48));
                        break;
                    case TOWN:
                        items.add(new Town(y * 48, x * 48));
                        break;
                    case TREE:
                        items.add(new Tree(y * 48, x * 48));
                        break;
                    case MOUNTAIN:
                        items.add(new Mountain(y * 48, x * 48));
                        break;
                    case TREECUT:
                        items.add(new TreeCut(y * 48, x * 48));
                        break;
                    default:
                        break;
                }
            }
        }
        for (int j=0; j<4;++j){
            powerups[j]=false;
        }
        if(!timed)
        {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    RandomPowerupGen();
                    timed=true;
                }
            }, 10*1000, 15*1000);
        }
    }


    public void RandomPowerupGen(){
        int x=(int)(Math.random()*4);
        switch (x){
            case 0:
                if(!powerups[0])
                {
                    AddItem(new HpUp(80,750,this));
                    powerups[0]=true;
                }
                break;
            case 1:
                if(!powerups[1])
                {
                    AddItem(new SpeedBoost(80,700,this));
                    powerups[1]=true;
                }
                break;
            case 2:
                if(!powerups[2])
                {
                    AddItem(new Shield(1070,70,this));
                    powerups[2]=true;
                }
                break;
            case 3:
                if(!powerups[3]){
                    AddItem(new RocketBoost(1070,120,this));
                    powerups[3]=true;
                }
                break;
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawObjects(g);
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Draw objects on the board.
     */
    private void drawObjects(Graphics g) {
        for (Item a : items) {
            if (a.isVisible()) {
                try{
                    g.drawImage(a.getImage(), a.getX(), a.getY(), this);
                }
                catch(Exception e){
                    System.out.println("Error drawing object"+a.toString());
                }

            }
        }
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.setColor(Color.red);
        g.drawString("Green HP:"+player2.getHealth(), 10, 35);

        g.drawString("G "+score.GetPlayer2Score()+":"+score.GetPlayer1Score()+" R", 520, 35);

        g.drawString("Red HP:"+player1.getHealth(), 1050, 35);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }


    public void ChangeLevel(int level){
        if(items.size()>0)
        {
            for (Item item : items) {
                RemoveItem(item);
            }
        }
        toBeAdded.clear();
        initBlocks(level);
        AddItem(player1);
        AddItem(player2);
        player1.ReinitPlayer();
        player2.ReinitPlayer();
    }

    public int GetNextLevel(){
        level=(level+1)%6;
        if (level == 0){
            level=1;
        }
        return level;
    }

    public void Update(){
        if(level==5){
            if((player1.getHealth()==0)||(player2.getHealth()==0)){
                RequestMenu();
            }
        }
        else {
            if (player1.getHealth() == 0) {
                score.IncrementP2Score();
                SetChangeLvl(true);
            }
            if (player2.getHealth() == 0) {
                score.IncrementP1Score();
                SetChangeLvl(true);
            }
        }


    }

}

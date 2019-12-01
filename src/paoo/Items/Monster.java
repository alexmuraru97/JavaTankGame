package paoo.Items;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import paoo.Game.*;

public class Monster extends Item implements KeyListener {
    private int speedCoef;
    private Image SpriteUp;
    private Image SpriteDown;
    private Image SpriteLeft;
    private Image SpriteRight;
    private int shoot;
    private int left;
    private int right;
    private int initialX;
    private int initialY;
    private int up;
    private int down;
    private final int BOARD_WIDTH = Map.BOARD_WIDTH;
    private final int BOARD_HEIGHT = Map.BOARD_HEIGHT;
    private int dx;
    private int dy;
    private Monster enemy;
    public int direction;
    private long lastFired = 0;
    private int health = 4;
    public boolean starLevel;
    public boolean shield;
    public Board panel;

    public boolean isAlive()
    {
        if(this.health>0)
        {
            return true;
        }
        return false;
    }

    public void SetStarLevel(){starLevel=true;}

    public int getHealth() {
        return health;
    }


    public void SetEnemy(Monster enemy){this.enemy=enemy;}

    public void downHealth() {
        if (shield == false&&isAlive()) {
            this.health -= 1;
        }
        else{
            this.shield=false;
        }
    }

    public Monster(int x, int y, Board panel, int up, int down, int left, int right, int shoot,Image iup,Image idown, Image ileft,Image iright) {
        super(x, y);
        this.SpriteUp=iup;
        this.initialX=x;
        this.initialY=y;
        this.SpriteDown=idown;
        this.SpriteLeft=ileft;
        this.SpriteRight=iright;
        starLevel=false;
        this.up=up;
        this.down=down;
        this.left=left;
        this.right=right;
        this.shoot=shoot;
        type=BlockType.PLAYER;
        panel.addKeyListener(this);
        this.panel=panel;
        image= ileft;
        getImageDimensions();
        direction = 3;
        shield=false;
        speedCoef=4;
    }

    public void SetSpeed(){
        speedCoef=6;
    }

    public void ReinitPlayer(){
        x=initialX;
        y=initialY;
        health=4;
        direction=3;
        image=SpriteLeft;
        starLevel=false;
        speedCoef=4;
    }

    public void move() {
        Rectangle PlayerBox = new Rectangle(x +3+speedCoef*dx, y +3+speedCoef*dy, width-3, height-3);
        Boolean[] Coli=CollisionUtility.checkCollisionTankBlocks(PlayerBox,false);
        Boolean[] ColiPlayer=CollisionUtility.checkPlayerCollision(this,enemy);
        //0 jos
        //1 sus
        //2 dreapta
        //3 stanga
            if((!Coli[2]&&!ColiPlayer[2])&&(dx==1))
            {
                x += speedCoef*dx;
            }
            if((!Coli[3]&&!ColiPlayer[3])&&(dx==-1))
            {
                x += speedCoef*dx;
            }
            if((!Coli[0]&&!ColiPlayer[0])&&(dy==1))
            {
                y += speedCoef*dy;
            }
            if((!Coli[1]&&!ColiPlayer[1])&&(dy==-1))
            {
                y += speedCoef*dy;
            }

        if (x > BOARD_WIDTH - width) {
            x = BOARD_WIDTH - width;
        }

        if (y > BOARD_HEIGHT - height) {
            y = BOARD_HEIGHT - height;
        }
        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
        CollisionUtility.checkCollisionPowerUp(this);
    }

    public void fire() {
        Rock aRock;
        if (direction == 0) {
            aRock = new Rock(x+14, y-height,panel ,0,enemy);
        }
        else if (direction == 1) {
            aRock = new Rock(x + width, y+14 ,panel, 1 ,enemy);
        }
        else if (direction == 2) {
            aRock = new Rock(x+14, y+height,panel, 2,enemy);
        }
        else {
            aRock = new Rock(x-width, y+14,panel, 3,enemy);
        }

        panel.AddItem(aRock);
        //SoundUtility.fireSound();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {
        int time;
        int key = e.getKeyCode();
        if (!starLevel) {
            time = 700;
        }
        else {
            time = 250;
        }
        if (key == shoot && (System.currentTimeMillis() - lastFired) > time) {
            fire();
            lastFired = System.currentTimeMillis();

        }
        else if (key == left) {
            dx = -1;
            dy = 0;
            image= SpriteLeft;
            direction = 3;
        }
        else if (key == right) {
            dx = 1;
            dy = 0;
            image= SpriteRight;
            direction = 1;
        }
        else if (key == up) {
            image= SpriteUp;
            dy = -1;
            dx = 0;
            direction = 0;
        }
        else if (key == down) {
            image=SpriteDown;
            dy = 1;
            dx = 0;
            direction = 2;
        }
        if(key==KeyEvent.VK_ESCAPE)
        {
            panel.RequestMenu();
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == left) {
            dx = 0;
        }

        if (key == right) {
            dx = 0;
        }

        if (key == up) {
            dy = 0;
        }

        if (key == down) {
            dy = 0;
        }
    }

    public void keyTyped(KeyEvent e){}
    public void upHealth() {
        this.health += 1;
    }
    public void SetShield(){this.shield=true;}
    public void Update(){
        move();
    }


}

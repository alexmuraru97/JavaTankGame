package paoo.Items;

import paoo.Game.*;

import java.awt.*;

public class Rock extends Item {
    private final int ROCK_SPEED = 20;
    private final int BOARD_WIDTH = Map.BOARD_WIDTH;
    private final int BOARD_HEIGHT = Map.BOARD_HEIGHT;
    private int direction;
    private boolean powerup;
    private Monster enemy;
    private Board panel;

    public Rock(int x, int y,Board panel, int direction, Monster enemy) {
        super(x, y);
        this.panel=panel;
        this.enemy=enemy;
        type= BlockType.ROCK;
        this.direction = direction;
        if (direction == 0) {
            image= ImageLoader.getInstance().getRockUp();
        }
        if (direction == 1) {
            image= ImageLoader.getInstance().getRockRight();
        }
        if (direction == 2) {
            image= ImageLoader.getInstance().getRockDown();
        }
        if (direction == 3) {
            image= ImageLoader.getInstance().getRockLeft();
        }
        getImageDimensions();
    }

    public void Update() {
        //System.out.println(this.toString()+" x="+x+" y="+y);
        Boolean removed=false;
        if (direction == 0) {
            y -= ROCK_SPEED;
        } else if (direction == 1) {
            x += ROCK_SPEED;
        } else if (direction == 2) {
            y += ROCK_SPEED;
        } else if (direction == 3) {
            x -= ROCK_SPEED;
        }
        if ((x >  BOARD_WIDTH + width+100)&&!removed) {
            panel.RemoveItem(this);
            removed=true;
        }
        if ((x < -width - 100)&&!removed) {
            panel.RemoveItem(this);
            removed=true;
        }
        if ((y > BOARD_HEIGHT + height + 100)&&!removed) {
            panel.RemoveItem(this);
            removed=true;
        }
        if ((y < -height - 100)&&!removed) {
            panel.RemoveItem(this);
            removed=true;
        }
        if(!removed)
        {
            Rectangle RocketCollision = new Rectangle(x,y, width-20, height-20);
            Boolean[] Coli= CollisionUtility.checkCollisionTankBlocks(RocketCollision,true);
            if (Coli[0]||Coli[1]||Coli[2]||Coli[3])
            {
                panel.RemoveItem(this);
            }else if(Coli[4])
            {
                enemy.downHealth();
                if(powerup&&enemy.isAlive())
                {
                    enemy.downHealth();
                }
                panel.RemoveItem(this);

            }
        }

    }

}

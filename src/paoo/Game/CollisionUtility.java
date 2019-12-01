package paoo.Game;

import com.sun.org.apache.xpath.internal.operations.Bool;
import paoo.Items.Block;
import paoo.Items.Item;
import paoo.Items.Monster;
import paoo.PowerUps.HpUp;
import paoo.PowerUps.RocketBoost;
import paoo.PowerUps.Shield;
import paoo.PowerUps.SpeedBoost;

import java.awt.*;
import java.util.ArrayList;

public class CollisionUtility {
    private static ArrayList<Item> items;
    private static Board panel;
    private CollisionUtility(){}
    public static void set(ArrayList<Item> i){items=i;};
    public static void setBoard(Board panel1){panel=panel1;}

    public static Boolean[] checkCollisionTankBlocks(Rectangle r1, boolean projectile){
        Boolean[] rezultat=new Boolean[5];
        //0,1,2,3 colision detection with obj
        //4 collision detection cu player
        for(int i=0;i<5;++i)
        {
            rezultat[i]=false;
        }
        for(Item it:items){
            if(it.type== BlockType.MOUNTAIN||it.type==BlockType.TREE||it.type==BlockType.WATER||it.type==BlockType.SOIL||it.type==BlockType.TREECUT){
                Rectangle r2=it.getBounds();
                if(r1.intersects(r2)){
                    if(r1.y<=(r2.y-r2.height/2))
                    {
                        rezultat[0]=true;
                    }

                    if(r1.y >= (r2.y + r2.height/2)) {
                        rezultat[1]=true;
                    }
                    if(r1.x < r2.x) {
                        rezultat[2]=true;
                    }

                    if(r1.x > r2.x) {
                        rezultat[3] = true;
                    }
                }
            }
            if(projectile&&(it.type==BlockType.PLAYER))
            {
                Rectangle r2=it.getBounds();
                if(r1.intersects(r2)){
                    rezultat[4]=true;
                }
            }
        }
        return rezultat;
    }


    public static Boolean[] checkPlayerCollision(Monster p1, Monster p2){
        Boolean[] rezultat=new Boolean[4];
        for(int i=0;i<4;++i)
        {
            rezultat[i]=false;
        }
        Rectangle r1=p1.getBounds();
        Rectangle r2=p2.getBounds();
        if(r1.intersects(r2)){
            if(r1.y<=(r2.y-r2.height/2))
            {
                rezultat[0]=true;
            }

            if(r1.y >= (r2.y + r2.height/2)) {
                rezultat[1]=true;
            }
            if(r1.x < r2.x) {
                rezultat[2]=true;
            }

            if(r1.x > r2.x) {
                rezultat[3] = true;
            }
        }
        return rezultat;
    }


    public static void checkCollisionPowerUp(Monster p1){
        Rectangle r1=p1.getBounds();
        for(Item it:items){
            if(it.type== BlockType.ROCKETBOOST||it.type== BlockType.SPEEDBOOST||it.type==BlockType.HPUP||it.type==BlockType.SHIELD){
                Rectangle r2=it.getBounds();
                if(r1.intersects(r2)){
                    if(it.type==BlockType.ROCKETBOOST)
                    {
                        p1.SetStarLevel();
                        RocketBoost a=(RocketBoost) it;
                        a.ToBeRemoved();
                    }
                    if(it.type==BlockType.SPEEDBOOST){
                        p1.SetSpeed();
                        //
                        SpeedBoost a=(SpeedBoost) it;
                        a.ToBeRemoved();
                    }
                    if(it.type==BlockType.HPUP)
                    {
                        p1.upHealth();
                        HpUp a=(HpUp)it;
                        a.ToBeRemoved();

                    }
                    if(it.type==BlockType.SHIELD)
                    {
                        p1.SetShield();
                        Shield a=(Shield)it;
                        a.ToBeRemoved();

                    }
                }
            }
        }
    }
}

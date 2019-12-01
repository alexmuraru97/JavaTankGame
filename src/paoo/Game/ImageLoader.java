package paoo.Game;

import javax.swing.*;
import java.awt.*;

public class ImageLoader {
    private final Image water;
    private final Image grass;
    private final Image monster1Left;
    private final Image monster1Right;
    private final Image background;
    private final Image monster1Up;
    private final Image monster1Down;
    private final Image monster2Left;
    private final Image monster2Right;
    private final Image monster2Up;
    private final Image monster2Down;
    private final Image treeCut;
    private final Image mountain;
    private final Image rockDown;
    private final Image rockLeft;
    private final Image rockRight;
    private final Image rockUp;
    private final Image soil;
    private final Image townGrass;
    private final Image tree;
    private final Image speedboost;
    private final Image HpUp;
    private final Image RocketBoost;
    private final Image Shield;
    private static ImageLoader instance;

    public static ImageLoader getInstance(){
        if( instance != null){
            return instance;
        }
        else{
            return new ImageLoader();
        }
    }

    public ImageLoader() {
        this.water = loadImage("images/water.png");
        this.grass = loadImage("images/grass.png");
        this.background=loadImage("images/background.jpg");
        this.monster1Left = loadImage("images/Tank1Left.png");
        this.monster1Right = loadImage("images/Tank1Right.png");
        this.monster1Up = loadImage("images/Tank1Up.png");
        this.monster1Down = loadImage("images/Tank1Down.png");
        this.monster2Left = loadImage("images/Tank2Left.png");
        this.monster2Right = loadImage("images/Tank2Right.png");
        this.monster2Up = loadImage("images/Tank2Up.png");
        this.monster2Down = loadImage("images/Tank2Down.png");
        this.mountain = loadImage("images/mountain.png");
        this.rockDown = loadImage("images/rockDown.png");
        this.rockLeft = loadImage("images/rockLeft.png");
        this.rockRight = loadImage("images/rockRight.png");
        this.rockUp = loadImage("images/rockUp.png");
        this.soil = loadImage("images/soil.png");
        this.townGrass = loadImage("images/townGrass.png");
        this.tree = loadImage("images/tree.png");
        this.treeCut=loadImage("images/cutTree.png");
        this.speedboost=loadImage("images/SpeedBoost.png");
        this.HpUp=loadImage("images/HpUp.png");
        this.RocketBoost=loadImage("images/RocketBoost.png");
        this.Shield=loadImage("images/Shield.png");
    }

    public Image loadImage(String imageAddress) {
        ImageIcon icon = new ImageIcon(imageAddress);
        return icon.getImage();
    }
    public Image getWater(){ return water;}
    public Image getGrass(){ return grass;}
    public Image getMonster1Left(){ return monster1Left;}
    public Image getMonster1Right(){ return monster1Right;}
    public Image getMonster1Up(){ return monster1Up;}
    public Image getMonster1Down(){ return monster1Down;}
    public Image getMonster2Left(){ return monster2Left;}
    public Image getMonster2Right(){ return monster2Right;}
    public Image getMonster2Up(){ return monster2Up;}
    public Image getMonster2Down(){ return monster2Down;}
    public Image getMountain(){ return mountain;}
    public Image getRockDown(){ return rockDown;}
    public Image getRockLeft(){ return rockLeft;}
    public Image getRockRight(){ return rockRight;}
    public Image getRockUp(){ return rockUp;}
    public Image getSoil(){ return soil;}
    public Image getTownGrass(){ return townGrass;}
    public Image getTreeCut(){return treeCut;}
    public Image getTree(){ return tree;}
    public Image getSpeedBoost(){ return speedboost;}
    public Image getHpUp(){return HpUp;}
    public Image getRocketBoost(){return RocketBoost;}
    public Image getShield(){return Shield;}
    public Image getBackground(){return background;}

}

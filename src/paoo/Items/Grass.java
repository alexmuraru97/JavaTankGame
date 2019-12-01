package paoo.Items;

import paoo.Game.BlockType;
import paoo.Game.ImageLoader;

public class Grass extends Item{
    public Grass(int x, int y) {
        super(x, y);
        //loadImage("images/grass.png");
        type= BlockType.GRASS;
        image= ImageLoader.getInstance().getGrass();
        getImageDimensions();

    }
}

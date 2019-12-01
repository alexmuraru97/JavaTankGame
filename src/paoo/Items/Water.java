package paoo.Items;

import paoo.Game.BlockType;
import paoo.Game.ImageLoader;

public class Water extends Item{
    public Water(int x, int y) {
        super(x, y);
        image= ImageLoader.getInstance().getWater();
        type= BlockType.WATER;
        getImageDimensions();
    }
}

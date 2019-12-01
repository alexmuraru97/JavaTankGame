package paoo.Items;

import paoo.Game.BlockType;
import paoo.Game.ImageLoader;

public class Soil extends Item {
    public Soil(int x, int y) {
        super(x, y);
        type= BlockType.SOIL;
        image= ImageLoader.getInstance().getSoil();
        getImageDimensions();
    }
}

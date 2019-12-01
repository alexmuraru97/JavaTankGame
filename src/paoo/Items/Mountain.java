package paoo.Items;

import paoo.Game.BlockType;
import paoo.Game.ImageLoader;

public class Mountain extends Item {
    public Mountain(int x, int y) {
        super(x, y);
        image= ImageLoader.getInstance().getMountain();
        type= BlockType.MOUNTAIN;
        getImageDimensions();
    }
}

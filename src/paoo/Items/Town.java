package paoo.Items;

import paoo.Game.BlockType;
import paoo.Game.ImageLoader;

public class Town extends Block {
    public boolean gameOver = false;

    public Town(int x, int y) {
        super(x, y);
        image= ImageLoader.getInstance().getTownGrass();
        getImageDimensions();
        setHealth(1);
        type= BlockType.TOWN;

    }

}

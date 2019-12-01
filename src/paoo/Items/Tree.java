package paoo.Items;

import paoo.Game.BlockType;
import paoo.Game.ImageLoader;

public class Tree extends Block{
    public Tree(int x, int y) {
        super(x, y);
        image= ImageLoader.getInstance().getTree();
        getImageDimensions();
        type= BlockType.TREE;
        setHealth(1);
    }
}

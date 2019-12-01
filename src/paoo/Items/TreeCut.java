package paoo.Items;

import paoo.Game.BlockType;
import paoo.Game.ImageLoader;

public class TreeCut extends Item {
    public TreeCut(int x, int y) {
        super(x, y);
        image= ImageLoader.getInstance().getTreeCut();
        type= BlockType.TREECUT;
        getImageDimensions();
    }
}

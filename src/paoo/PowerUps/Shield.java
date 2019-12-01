package paoo.PowerUps;

import paoo.Game.BlockType;
import paoo.Game.Board;
import paoo.Game.ImageLoader;
import paoo.Items.Item;

public class Shield extends Item {
    Board b;
    public Shield(int x, int y, Board b) {
        super(x, y);
        this.b=b;
        image= ImageLoader.getInstance().getShield();
        type= BlockType.SHIELD;
        getImageDimensions();
    }

    public void ToBeRemoved(){
        b.RemoveItem(this);
    }

}
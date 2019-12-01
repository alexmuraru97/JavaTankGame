package paoo.PowerUps;

import paoo.Game.BlockType;
import paoo.Game.Board;
import paoo.Game.ImageLoader;
import paoo.Items.Item;

public class HpUp extends Item {
    Board b;
    public HpUp(int x, int y,Board b) {
        super(x, y);
        this.b=b;
        image= ImageLoader.getInstance().getHpUp();
        type= BlockType.HPUP;
        getImageDimensions();
    }


    public void ToBeRemoved(){
        b.RemoveItem(this);
    }

}
package paoo.PowerUps;

import paoo.Game.BlockType;
import paoo.Game.Board;
import paoo.Game.ImageLoader;
import paoo.Items.Item;

public class SpeedBoost extends Item {
    Board b;
    public SpeedBoost(int x, int y, Board b) {
        super(x, y);
        this.b=b;
        image= ImageLoader.getInstance().getSpeedBoost();
        type= BlockType.SPEEDBOOST;
        getImageDimensions();
    }

    public void ToBeRemoved(){
        b.RemoveItem(this);
    }

}

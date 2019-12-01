package paoo.PowerUps;

import paoo.Game.BlockType;
import paoo.Game.Board;
import paoo.Game.ImageLoader;
import paoo.Items.Item;

public class RocketBoost extends Item {
    Board b;
    public RocketBoost(int x, int y, Board b) {
        super(x, y);
        this.b=b;
        image= ImageLoader.getInstance().getRocketBoost();
        type= BlockType.ROCKETBOOST;
        getImageDimensions();
    }

    public void ToBeRemoved(){
        b.RemoveItem(this);
    }
}

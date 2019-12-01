package paoo.Items;

public class Block extends Item{
    public int health = 1;

    public Block(int x, int y) {
        super(x, y);
    }

    public void setHealth(int health) {
        this.health = health;
    }

}

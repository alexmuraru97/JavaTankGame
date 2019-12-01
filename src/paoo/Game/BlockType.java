package paoo.Game;

public enum BlockType {
    GRASS(0), SOIL(1), WATER(2), TREE(3), MOUNTAIN(4), TOWN(5), PLAYER(6), VOID(7), ROCK(8), BASE(9), TREECUT(10),SPEEDBOOST(11),HPUP(12),ROCKETBOOST(13), SHIELD(14);

    private final int value;

    private BlockType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BlockType getTypeFromInt(int value) {
        return BlockType.values()[value];
    }
}

public class SeedItem implements IItemType {

    private String seedType;
    public SeedItem(String seedType) {
        this.seedType = seedType;
    }

    public String getSeedType() {
        return seedType;
    }

    @Override
    public void use() {
        // plantera
    }
    @Override
    public void pickUp() {
    }
}


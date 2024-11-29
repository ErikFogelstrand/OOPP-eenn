public class SeedItem implements IItemType {

    private String cropType;
    public SeedItem(String cropType) {
        this.cropType = cropType;
    }

    @Override
    public void use() {
        // plantera
    }
    @Override
    public void pickUp() {
    }
}


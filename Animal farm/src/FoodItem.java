public  class FoodItem  implements IItemType {
    private final int nutrition;

    public FoodItem( int nutrition){
        this.nutrition = nutrition;
    }
    @Override
    public void use(){
        // minska på hunger

    }
    @Override
    public void pickUp() {

    }
}

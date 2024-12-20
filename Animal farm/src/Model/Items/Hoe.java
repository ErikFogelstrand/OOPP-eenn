package Model.Items;

public class Hoe extends Tool {
    public Hoe(){
        super("Hoe");
    }
    @Override
    public void use() {
        System.out.println("Now you can plant :)");
    }
}
package Model.UsableObjects;

    public class Shovel extends Tool {
        public Shovel(){
            super("Shovel");
        }
        @Override
        public  void use() {
            System.out.println("No more grass :)");
            // kanske lägga till durability eller så?
        }

    }

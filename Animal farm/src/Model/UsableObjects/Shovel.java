package Model.UsableObjects;

    public class Shovel extends Tool {
        public Shovel(String name, String type){
            super(name, type);
        }
        @Override
        public  void use() {
            System.out.println("No more grass :)");
            // kanske lägga till durability eller så?
        }
        @Override
        public String getType() {
            return "Shovel";
        }

    }

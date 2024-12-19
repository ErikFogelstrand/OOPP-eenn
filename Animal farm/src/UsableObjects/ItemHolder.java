package UsableObjects;

    public class ItemHolder {
        public Item item;
        public int quantity;

        public ItemHolder(Item item, int quantity){
            this.item = item;
            this.quantity = quantity;
        }

        public Item getItem(){
            return item;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getQuantity() {
            return quantity;
        }

        public void decreaseQuantity(int amount){
            if (amount > 0 && quantity >= amount) {
                quantity -= amount;
            } else {
                System.out.println("Ran out of item :(");
            }
        }

}

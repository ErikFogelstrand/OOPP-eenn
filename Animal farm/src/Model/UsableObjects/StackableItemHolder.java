package Model.UsableObjects;

    public class StackableItemHolder {
        public StackableItem stackableItem;
        public int quantity;

        public StackableItemHolder(StackableItem stackableItem, int quantity){
            this.stackableItem = stackableItem;
            this.quantity = quantity;
        }

        public StackableItem getItem(){
            return stackableItem;
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

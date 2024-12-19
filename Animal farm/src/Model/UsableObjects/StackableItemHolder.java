package Model.UsableObjects;

    public class StackableItemHolder {
        public final StackableItem stackableItem;
        public int quantity;

        public StackableItemHolder(StackableItem stackableItem, int quantity){
            this.stackableItem = stackableItem;
            this.quantity = quantity;
        }

        public StackableItem getItem(){
            return stackableItem;
        }

        public int getQuantity() {
            return quantity;
        }

        public void changeQuantity(int amount){
            quantity = Math.max(0, quantity+amount);
        }

}

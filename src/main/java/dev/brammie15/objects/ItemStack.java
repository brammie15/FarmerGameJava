package dev.brammie15.objects;

public class ItemStack {
    public int amount;
    public Item item;

    public ItemStack(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public void use() {
        amount--;
    }
}

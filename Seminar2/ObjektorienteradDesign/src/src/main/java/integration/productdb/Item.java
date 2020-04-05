package integration.productdb;

import integration.ItemDetail;

public class Item {
    ItemDetail itemDetail;

    public Item(String name){
        itemDetail = new ItemDetail(name);
    }

    public ItemDetail getItemDetail() {
        return itemDetail;
    }
}

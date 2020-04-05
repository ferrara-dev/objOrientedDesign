package integration;

import integration.productdb.Item;

import java.util.List;

public class ItemRegestry {
    static List<Item> productList;


    public ItemRegestry(List<Item> productList){
        this.productList = productList;
    }

    public ItemDetail getItemDetail(int itemId){
        for(Item item:productList){
            if(item.getItemDetail().getItemId() == itemId) {
                return item.getItemDetail();
            }
        }
        return null;
    }

    public boolean contains(int itemId){
        for (Item item : productList)
            if (itemId == item.getItemDetail().getItemId())
                return true;

        return false;
    }
}


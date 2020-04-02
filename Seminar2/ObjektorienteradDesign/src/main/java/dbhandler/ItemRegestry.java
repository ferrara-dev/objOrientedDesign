package dbhandler;

import java.util.List;

public class ItemRegestry {
    List<Item> productList;

    public ItemRegestry(List<Item> productList){
        this.productList = productList;
    }
    public ItemDetail getItemDetail(int itemId){
        for(Item item:productList){
            if(item.itemDetail.itemId == itemId) {
                return item.itemDetail;
            }
        }
        return null;
    }
}


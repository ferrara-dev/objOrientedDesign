package dbhandler;

import java.util.ArrayList;
import java.util.List;

public class RegestryCreator {
    ItemRegestry itemRegestry;

    public ItemRegestry createProductList() {
        List <Item> productList = new ArrayList<Item>();
        Item item = new Item();
        for(int i = 0; i < 10; i++){
            productList.add(i, new Item());
            productList.get(i).itemDetail.price = 10 +i;
            productList.get(i).itemDetail.itemId = 10 +i;
            productList.get(i).itemDetail.stockStatus = 10;
        }

        itemRegestry = new ItemRegestry(productList);
        return itemRegestry;
    }

    public ItemRegestry getItemRegestry(){
        return itemRegestry;
    }
}

package model.itemmodel;

import model.itemmodel.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class ProcessedGoods {
    public static List<ItemModel> goods;

    public ProcessedGoods() {
        goods = new ArrayList<>();
    }

    public boolean contains(int itemId){
        for (ItemModel item : goods)
            if (itemId == item.itemId)
                return true;

        return false;
    }

    public  ItemModel getItem(int itemId) {
        for(ItemModel item: goods)
            if(itemId == item.itemId){
                return item;
            }
        return null;
    }

/**
    public void addItemToSale(SaleDetail saleDetail){
        if (contains(saleDetail.getItemModel().itemId))
            updateItemQuantity(saleDetail);
         else
            goods.add(saleDetail.getItemModel());
    }

    public void updateItemQuantity(ItemModel model){
        getItem(model.itemId).quantity += model.quantity;
    }

    public void addItem(ItemModel itemModel) {
        goods.add(itemModel);
     }
**/

}

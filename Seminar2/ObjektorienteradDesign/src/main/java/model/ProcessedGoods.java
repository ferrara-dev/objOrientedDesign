package model;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class ProcessedGoods {
    public static List<SaleLineItem> goods;

    public ProcessedGoods() {
        goods = new ArrayList<SaleLineItem>();
    }

    public boolean contains(int itemId){
        for (SaleLineItem item : goods)
            if (itemId == item.itemId)
                return true;

        return false;
    }

    public static SaleLineItem getItem(int itemId) {
        for(SaleLineItem item: goods)
            if(itemId == item.itemId){
                return item;
            }
        return null;
    }

    public void addItemToSale(SaleDetail saleDetail){
        if (contains(saleDetail.getSaleLineItem().itemId))
            updateItemQuantity(saleDetail);
         else
            goods.add(saleDetail.getSaleLineItem());
    }

    private void updateItemQuantity(SaleDetail saleDetail){
        getItem(saleDetail.getSaleLineItem().itemId).quantity += saleDetail.getSaleLineItem().quantity;
    }

}

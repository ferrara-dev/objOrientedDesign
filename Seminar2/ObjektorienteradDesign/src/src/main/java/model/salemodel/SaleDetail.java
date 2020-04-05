package model.salemodel;

import model.itemmodel.ItemModel;
import model.itemmodel.ProcessedGoods;

public class SaleDetail {
    private ProcessedGoods processedGoods;
    private ItemModel saleLineItem;
    public static boolean active;
    boolean completed;
    private double runningTotal = 0;
    private double discount = 0;
    String TimeAndDateOfSale;

    public SaleDetail(){
        completed = false;
        active = true;
        processedGoods = new ProcessedGoods();
    }

    public double getRunningTotal() {
        return runningTotal;
    }

    public ItemModel getSaleLineItem() {
        return saleLineItem;
    }

    public void setSaleLineItem(ItemModel saleLineItem) {

        this.saleLineItem = saleLineItem;
    }

    public ProcessedGoods getProcessedGoods() {
        return processedGoods;
    }

    public void updateSaleDetail(){
        if (processedGoods.contains(saleLineItem.itemId))
           updateItemQuantity();
        else
            addItem();
        updateRunningTotal(saleLineItem.totalPrice);
    }

    private void updateItemQuantity(){
        processedGoods.getItem(saleLineItem.itemId).quantity += saleLineItem.quantity;
    }

    private void addItem() {
        processedGoods.goods.add(saleLineItem);
    }

    private void updateRunningTotal(double amount) {
        this.runningTotal += amount;
    }

    public void applyDiscount(double amount){
        runningTotal = runningTotal - amount;
    }
}

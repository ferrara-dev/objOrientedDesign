package model.salemodel;


import integration.RegestryCreator;
import model.Calendar;
import model.itemmodel.ItemModel;
import model.Model;

public class SaleModel implements Model {
    public SaleDetail saleDetail;
    public RegestryCreator creator;
    private final int ITEM_NOT_FOUND = 0;

    public SaleModel(RegestryCreator creator) {
        this.creator = creator;
    }

    @Override
    public String registerItem(int itemId, int quantity) {
        boolean isRegistered = false;
        if(!saleDetail.completed)
        if(creator.getItemRegestry().contains(itemId)) {
            if (saleDetail.active && new ItemModel(creator.getItemRegestry().getItemDetail(itemId), quantity) != null) {
                saleDetail.setSaleLineItem(new ItemModel(creator.getItemRegestry().getItemDetail(itemId), quantity));
                addItemToSale();
              //  updateRuningTotal();
                return getDisplayMessage(itemId, true);
            }
        }
            return getDisplayMessage(ITEM_NOT_FOUND, false);
    }

    public void startSale() {
        saleDetail = new SaleDetail();
    }

    public String endSale() {
        saleDetail.TimeAndDateOfSale = Calendar.getTimeAndDate();
        saleDetail.completed = true;
        return Double.toString(saleDetail.getRunningTotal());
    }

    private String getDisplayMessage(int itemId, boolean itemFound) {
        if(itemFound) {
            String message = saleDetail.getSaleLineItem().toString() + "\n" +
                    "Running Total : " + saleDetail.getRunningTotal() + "\n" +
                    "Total Amount of this Item : " + saleDetail.getProcessedGoods().getItem(itemId).quantity;

            return message;
        }
        return "Item not found";
    }

    private void addItemToSale(){
        saleDetail.updateSaleDetail();
    }


}

package model;


public class SaleModel implements Model {
    public SaleDetail saleDetail;

    private SaleModel() {
        saleDetail = new SaleDetail();
    }

    @Override
    public String registerItem(int itemId, int quantity) {
        boolean isRegistered = false;
        if (saleDetail.active && saleDetail != null) {
            saleDetail.setSaleLineItem(new SaleLineItem(itemRegestry.getItemDetail(itemId), quantity));
            ProcessedGoods goods = saleDetail.getProcessedGoods();
                goods.addItemToSale(saleDetail);
                updateRuningTotal();

            }
        return updateDisplayMessage(itemId);
    }

    private String updateDisplayMessage(int itemId) {
        String message = saleDetail.getSaleLineItem().toString() + "\n" +
                "Running Total : " + saleDetail.getRunningTotal() + "\n" +
                "Total Amount of this Item : " + saleDetail.getProcessedGoods().getItem(itemId).quantity;
        return message;
    }


    private void updateRuningTotal() {
        saleDetail.recaluclateRunningTotal(saleDetail.getSaleLineItem().totalPrice);
    }


    public static SaleModel startSale() {
        return new SaleModel();
    }
}

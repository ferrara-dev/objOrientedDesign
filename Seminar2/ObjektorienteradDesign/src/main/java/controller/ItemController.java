package controller;

public class ItemController {

    public String registerItem(int itemId, int quantity){
        String displayMessage = SaleController.getModel().registerItem(itemId,quantity);
        return displayMessage;
        //call to model
    }
}

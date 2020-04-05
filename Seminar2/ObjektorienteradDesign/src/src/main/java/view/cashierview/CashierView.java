package view.cashierview;

import controller.Controller;
import view.View;

public class CashierView implements View {
    private controller.Controller controller;
    private CashierGui cashierGui;
    public CashierView(Controller controller) throws Exception {
        this.controller = controller;
        cashierGui = new CashierGui(this);
    }

    public void startSale(){
        displayMessage(controller.startSale());
    }

    public String endSale(){
        // call to controller
        return "Total cost : \n"
                + controller.endSale() + " kr";
    }

    public String registerItem(int itemId, int quantity){
        //call to controller
        return (controller.registerItem(itemId, quantity));
    }

    @Override
    public void displayMessage(String... message) {
        StringBuilder sb = new StringBuilder();
        for(String string: message){
            sb.append(string);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public String signalDiscountRequest(String customerId){

        // call to controller
        return  controller.signalDiscountRequest(customerId);
    }

}

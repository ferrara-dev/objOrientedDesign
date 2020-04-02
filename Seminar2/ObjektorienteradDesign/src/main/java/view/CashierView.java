package view;

import controller.Controller;

public class CashierView implements View{
    controller.Controller controller;

    public CashierView(Controller controller){
        this.controller = controller;
    }

    public void startSale(){
        displayMessage(controller.startSale());
    }

    public void registerItem(int itemId, int quantity){
        //call to controller
        displayMessage(controller.registerItem(itemId, quantity));
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
}

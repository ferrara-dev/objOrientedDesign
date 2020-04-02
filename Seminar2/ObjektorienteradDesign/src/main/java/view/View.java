package view;

public interface View {
    controller.Controller controller = new controller.Controller();
    void displayMessage(String... message);
    void registerItem(int itemId, int quantity);
    void startSale();
}

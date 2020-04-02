package startup;
import controller.Controller;
import dbhandler.RegestryCreator;
import view.CashierView;
import view.View;
import java.util.Scanner;  // Import the Scanner class
public class Main {

    public static void main(String [] args){
        RegestryCreator creator = new RegestryCreator();
        creator.createProductList();
        initRegestry();
        start();

    }

    private static void registerItem(View cashierView) {
        boolean goodsLeft = true;
        while(goodsLeft){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter ItemId");
            int id = sc.nextInt();
            int quantity = sc.nextInt();
            if(quantity == 0)
                cashierView.registerItem(id,1);
            else if(quantity>= 1){
                cashierView.registerItem(id,quantity);
            }

            int end = sc.nextInt();
            if(end == 666){
                goodsLeft = false;
            }
        }

    }

    private static void start(){
        View cashierView = new CashierView(new Controller());
        cashierView.startSale();
        registerItem(cashierView);
    }
    private static void initRegestry(){

    }
}

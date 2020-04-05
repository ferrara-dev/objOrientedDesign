package controller;

import model.customermodel.CustomerService;
import util.Member;
public class MemberService {
    CustomerService model = new CustomerService();
    view.Display display = new view.Display();

    /** Call to model **
     *
     * @param member
     *******************/
    public void registerMember(Member member){
        display.displayMessage(model.registerMember(member));
    }
}

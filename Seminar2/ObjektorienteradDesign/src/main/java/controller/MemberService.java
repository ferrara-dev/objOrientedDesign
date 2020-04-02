package controller;

import util.Member;
public class MemberService {
    model.MemberService model = new model.MemberService();
    view.Display display = new view.Display();

    /** Call to model **
     *
     * @param member
     *******************/
    public void registerMember(Member member){
        display.displayMessage(model.registerMember(member));
    }
}

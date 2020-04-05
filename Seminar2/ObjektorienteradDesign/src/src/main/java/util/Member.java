package util;

public class Member
{
    private String name;
    private String personalNumber;
    private static boolean discount;

    public Member(String name, String personalNumber) {
        this.name = name;
        this.personalNumber = personalNumber;
    }
    public void changeName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }
}

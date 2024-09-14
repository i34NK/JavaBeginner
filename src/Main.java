import java.util.ArrayList;

public class Main {
    public static ArrayList<Users> users;
    public static int index;

    public static void main(String[] args) {
        users = new ArrayList<Users>();
        new FrontCover().setVisible(true);


    }

    public static void checkName(int size) {
        if (index >= 0 && index < users.size()) {
            System.out.println("Name :" + users.get(index).getFirstname());
            System.out.println("Lastname : " + users.get(index).getLastname());
        } else {
            System.out.println("Invalid index");
        }
    }
}
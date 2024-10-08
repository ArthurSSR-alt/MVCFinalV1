import Controllers.LoginController;
import Views.LoginView;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        LoginController loginController =new LoginController();
        LoginView loginView = new LoginView(loginController);
        loginView.menu();


    }
}
package Views;

import Controllers.LoginController;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginView {
    private LoginController loginController;

    public  LoginView(LoginController loginController) throws FileNotFoundException {

        this.loginController = new LoginController();
    }

    public void menu() throws FileNotFoundException {

        // Import Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        int opcao;

        do {
            System.out.println("\n\n------ Bem Vindo ao CESAE Land!! ------");
            System.out.println("1. Prosseguir sem login");
            System.out.println("2. Efetuar Login");
            System.out.println("3. Sair");

            System.out.print("Insira a opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1: // CLIENTE
                    ClientView clientView = new ClientView();
                    clientView.menuCliente();
                    break;

                case 2: // ADMIN ou ENG
                    menuLogin();
                    break;

                case 3: // Sair
                    break;

                default:
            }

        } while (opcao != 3);

    }

    private void menuLogin() throws FileNotFoundException {

        // Import Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        String usernameInput, passwordInput;

        // Ler inputs
        System.out.print("Username: ");
        usernameInput = input.next();

        System.out.println("Password: ");
        passwordInput = input.next();

        switch (loginController.validateLogin(usernameInput, passwordInput)) {
            case 0: // Inválido
                System.out.print("Acesso Inválido");
                break;
            case 1: // ADMIN
                AdminView adminView = new AdminView();
               // adminView.menuAdm();
                break;
            case 2: // ENGENHEIRO
                EngView engView = new EngView();
               // engView.menuEng();
                break;
        }
    }
}

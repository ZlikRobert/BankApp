// import necessary libraries
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        createAccount();
    }

    private static void createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Witaj w aplikacji bankowej!");

        // create an ArrayList of Konto objects to store accounts
        ArrayList<Konto> konta = new ArrayList<Konto>();
        Konto konto = null;

        //The boolean keyword is a data type that can only take the values true or false
        boolean dzialanie = true;
        while (dzialanie) {
            // display menu options
            System.out.println("Wybierz opcję:");
            System.out.println("1. Dodaj konto");
            System.out.println("2. Wpłata");
            System.out.println("3. Wypłata");
            System.out.println("4. Sprawdzenie stanu konta");
            System.out.println("5. Zakończ");

            // read user input
            int wybor = scanner.nextInt();

            // process user input using a switch statement
            switch (wybor) {
                case 1:
                    // create a new account object and add it to the ArrayList
                    Konto noweKonto = Konto.utworzKonto();
                    konta.add(noweKonto);
                    System.out.println("Konto zostało dodane do systemu.");
                    break;
                case 2:
                    // ask for account number and deposit amount
                    System.out.println("Podaj numer konta:");
                    int numerKontaWplata = scanner.nextInt();
                    System.out.println("Podaj kwotę wpłaty:");
                    double kwotaWplata = scanner.nextDouble();

                    boolean znalezionoKontoWplata = false;
                    for (Konto k : konta) {
                        // check if account number exists and deposit amount
                        if (k.getNumerKonta() == numerKontaWplata) {
                            k.wplac(kwotaWplata);
                            znalezionoKontoWplata = true;
                            break;
                        }
                    }

                    if (!znalezionoKontoWplata) {
                        System.out.println("Nie znaleziono konta o numerze " + numerKontaWplata + " w systemie.");
                    }
                    break;
                case 3:
                    // ask for account number and withdrawal amount
                    System.out.println("Podaj numer konta:");
                    int numerKontaWyplata = scanner.nextInt();
                    System.out.println("Podaj kwotę wypłaty:");
                    double kwotaWyplata = scanner.nextDouble();

                    boolean znalezionoKontoWyplata = false;
                    for (Konto k : konta) {
                        // check if account number exists and withdraw amount
                        if (k.getNumerKonta() == numerKontaWyplata) {
                            k.wyplac(kwotaWyplata);
                            znalezionoKontoWyplata = true;
                            break;
                        }
                    }

                    if (!znalezionoKontoWyplata) {
                        System.out.println("Nie znaleziono konta o numerze " + numerKontaWyplata + " w systemie.");
                    }
                    break;
                case 4:
                    // ask for account number and display account balance
                    System.out.println("Podaj numer konta:");
                    int numerKontaStan = scanner.nextInt();

                    boolean znalezionoKontoStan = false;
                    for (Konto k : konta) {
                        // check if account number exists
                        if (k.getNumerKonta() == numerKontaStan) {
                            k.stanKonta();
                            znalezionoKontoStan = true;
                            break;
                        }
                    }

                    if (!znalezionoKontoStan) {
                        System.out.println("Nie znaleziono konta o numerze " + numerKontaStan + " w systemie.");
                    }
                    break;
                case 5:
                    dzialanie = false;
                    break;
                default:
                    System.out.println("Niepoprawny wybór. Wybierz opcję od 1 do 5.");
                    break;
            }
        }
    }


}
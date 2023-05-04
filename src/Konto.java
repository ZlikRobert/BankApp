import java.util.Scanner;

public class Konto {
    // Fields (numerKonta - account number, imieNazwisko - name and surname, saldo - balance)
    private long numerKonta;
    private String imieNazwisko;
    private double saldo;

    // Constructor
    public Konto(long numerKonta, String imieNazwisko, double saldo) {
        this.numerKonta = numerKonta;
        this.imieNazwisko = imieNazwisko;
        this.saldo = saldo;
    }

    // Method for depositing money into the account
    public void wplac(double kwota) {
        saldo += kwota;
        System.out.println("Wpłata " + kwota + "zł została zaksięgowana na koncie " + numerKonta + ". Aktualne saldo: " + saldo + "zł");
    }

    // Method for withdrawing money from the account
    public void wyplac(double kwota) {
        if (saldo >= kwota) {
            saldo -= kwota;
            System.out.println("Wypłata " + kwota + "zł została zaksięgowana na koncie " + numerKonta + ". Aktualne saldo: " + saldo + "zł");
        } else {
            System.out.println("Nie można dokonać wypłaty z powodu niewystarczających środków na koncie " + numerKonta + ". Aktualne saldo: " + saldo + "zł");
        }
    }

    // Method for displaying the current account balanc
    public void stanKonta() {
        System.out.println("Stan konta " + numerKonta + " (" + imieNazwisko + "): " + saldo + "zł");
    }

    // Method for creating a new account
    public static Konto utworzKonto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imię i nazwisko użytkownika:");
        String imieNazwisko = scanner.nextLine();

        long numerKonta = 0;
        boolean valid = false;
        while (!valid) {
            System.out.println("Podaj numer konta:");
            numerKonta = scanner.nextLong();
            if (String.valueOf(numerKonta).length() != 10) {
                System.out.println("Numer konta powinien składać się z 10 cyfr. Spróbuj ponownie.");
            } else {
                valid = true;
            }
        }

        System.out.println("Podaj saldo początkowe(nie wpisuj liter):");
        double saldo = scanner.nextDouble();

        return new Konto(numerKonta, imieNazwisko, saldo);
    }

    // Getter method for the account number. The getter method returns the value of the attribute
    public long getNumerKonta() {
        return numerKonta;
    }


}




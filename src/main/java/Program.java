import model.entities.Account;
import model.entities.Reservation;
import model.exceptions.DomainException;
import model.exceptions.OutOfLimitException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //      Exercicio de Aula

//        try {
//            System.out.print("Room Number: ");
//            var number = s.nextInt();
//            System.out.println("Check-in date: ");
//            var checkInDate = sdf.parse(s.next());
//            System.out.println("CheckOut date: ");
//            var checkoutDate = sdf.parse(s.next());
//
//            Reservation reservation = new Reservation(number, checkInDate, checkoutDate);
//            System.out.println("Reservation: " + reservation);
//
//            System.out.println();
//            System.out.println("Enter data to update the reservation: ");
//            System.out.println("Check-in date: ");
//            checkInDate = sdf.parse(s.next());
//            System.out.println("CheckOut date: ");
//            checkoutDate = sdf.parse(s.next());
//
//            reservation.updateDates(checkInDate, checkoutDate);
//            System.out.println("Reservation: " + reservation);
//        } catch (ParseException e) {
//            System.out.println("Invalid date format");
//        }
//        catch(DomainException e ){
//            System.out.println("Error in reservation : " +e.getMessage());
//        }
//        catch(RuntimeException e ){
//            System.out.println("Unexpected error");
//        }

        //Exercicio de Fixacao

       try{
           System.out.println("Account number: ");
           var number = s.nextInt();
           s.nextLine();
           System.out.println("Holder name: ");
           var name = s.nextLine();
           System.out.println("Deposit: ");
           var balance = s.nextDouble();
           System.out.println("Withdraw limit");
           var withdrawLimit = s.nextDouble();

           Account account = new Account(number, name, balance, withdrawLimit);
           System.out.println(account);

           System.out.println();
           System.out.println("How much do you want to withdraw?");
           var withdraw = s.nextInt();

           account.withdraw(withdraw);

           System.out.println("Account after withdraw: \n" + account);
       } catch (OutOfLimitException e) {
           System.out.println("Error: " + e.getMessage());
       } catch (RuntimeException e) {
           System.out.println("Unexpected error: ");
           e.printStackTrace();
       }



    }
}

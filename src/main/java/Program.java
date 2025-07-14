import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room Number: ");
            var number = s.nextInt();
            System.out.println("Check-in date: ");
            var checkInDate = sdf.parse(s.next());
            System.out.println("CheckOut date: ");
            var checkoutDate = sdf.parse(s.next());

            Reservation reservation = new Reservation(number, checkInDate, checkoutDate);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.println("Check-in date: ");
            checkInDate = sdf.parse(s.next());
            System.out.println("CheckOut date: ");
            checkoutDate = sdf.parse(s.next());

            reservation.updateDates(checkInDate, checkoutDate);
            System.out.println("Reservation: " + reservation);
        } catch (ParseException e) {
            System.out.println("Invalid date format");
        }
        catch(DomainException e ){
            System.out.println("Error in reservation : " +e.getMessage());
        }
        catch(RuntimeException e ){
            System.out.println("Unexpected error");
        }
    }
}

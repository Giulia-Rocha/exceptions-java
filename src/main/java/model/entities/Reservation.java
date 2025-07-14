package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private int roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(int roomNumber, Date checkIn, Date checkOut)  {
        if(!checkOut.after(checkIn)){
            throw new DomainException("CheckOut date must be after checkIn date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }


    public Date getCheckOut() {
        return checkOut;
    }


    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime(); // diferença das datas em ms
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

    }


    // responsavel por mudar as datas
    public void updateDates(Date checkIn, Date checkOut)  {
        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)){
            throw new DomainException("Reservation dates for updates must be future dates");
        }
        if(!checkOut.after(checkIn)){
            throw new DomainException("CheckOut date must be after checkIn date");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }
    @Override
    public String toString() {
        return "Room "
                +roomNumber
                + ", CheckIn: "
                +sdf.format(checkIn)
                +", CheckOut: "
                +sdf.format(checkOut)
                +", "
                +duration()
                +" nights";
    }
}

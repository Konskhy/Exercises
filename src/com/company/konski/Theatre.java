package com.company.konski;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private final String theatreName;
    private List<Seat>seats = new ArrayList<>();

    public Theatre(String theatreName, int rows, int seatsPerRow){
        this.theatreName = theatreName;
        int lastRow = 'A'+rows-1;
        for (char i='A'; i<=lastRow;i++){
            for (int j=1; j<=seatsPerRow;j++){
                Seat seat = new Seat(i+String.format("%02d",j));
                seats.add(seat);
            }
        }
    }
    public String getTheatreName() {
        return theatreName;
    }
    public boolean reserveSeat(String requestedSeat) {
        Seat reqSeat = null;
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(requestedSeat))
                reqSeat = seat;
        }
        if (reqSeat == null) {System.out.println
            ("Seat doesn't exist");
            return false;
        }else {reqSeat.reserve();
        return true;}
    }
    public void listSeats(){
        for (Seat seat:seats) System.out.println(seat.getSeatNumber());
    }

    private class Seat{
        private final String seatNumber;
        private boolean reserved;
        private Seat(String seatNumber){
            this.seatNumber=seatNumber;
            this.reserved=false;
        }

        public String getSeatNumber() {
            return seatNumber;
        }
        public boolean reserve(){
            if(reserved) {
                System.out.println("Seat already reserved");
                return true;
            } else reserved=true;
            System.out.println("Seat "+getSeatNumber()+" has been reserved!");
            return false;
        }
    }
}
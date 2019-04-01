package com.company.konski;

import java.util.*;

public class Theatre {
    private final String theatreName;
    public List<Seat>seats = new ArrayList<>();
    static final Comparator<Seat> PRICE_COMP = new Comparator<Seat>() {
        @Override
        public int compare(Seat o1, Seat o2) {
            if (o1.getSeatPrice()>o2.getSeatPrice()) return 1;
            else if (o1.getSeatPrice()<o2.getSeatPrice()) return -1;
            else {
                 return o1.compareTo(o2);
            }
        }
    };
    private double price;
    public Theatre(String theatreName, int rows, int seatsPerRow){
        this.theatreName = theatreName;
        int lastRow = 'A'+rows-1;
        for (char i='A'; i<=lastRow;i++){
            for (int j=1; j<=seatsPerRow;j++){
                if (i>='A'&&i<='C'){
                    if (j>=3&&j<=seatsPerRow-3) price=15.00;
                    else price=7.00;
                } else price=10.00;
                Seat seat = new Seat(i+String.format("%02d",j));
                seats.add(seat);
            }
        }
    }
    public List<Seat> getSeats(){
        return seats;
    }
    public String getTheatreName() {
        return theatreName;
    }
    //todo binary search

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
        for (Seat seat:seats) System.out.print("#"+seat.getSeatNumber()+" $"+seat.getSeatPrice()+" | ");
        System.out.println();
    }



    public class Seat implements Comparable <Seat>{
        private final String seatNumber;
        private boolean reserved;
        private double seatPrice;
        private Seat(String seatNumber){
            this.seatNumber=seatNumber;
            this.reserved=false;
            this.seatPrice=price;
        }

        public double getSeatPrice() {
            return seatPrice;
        }

        public String getSeatNumber() {
            return seatNumber;
        }
        public boolean reserve(){
            if(reserved) {
                System.out.println("Seat already reserved");
                return true;
            } else reserved=true;
            System.out.println("Seat "+getSeatNumber()+" has been reserved, please pay "+getSeatPrice()+"$");
            return false;
        }

        @Override
        public int compareTo(Seat o) {
            return getSeatNumber().compareToIgnoreCase(o.getSeatNumber());
        }
    }
}
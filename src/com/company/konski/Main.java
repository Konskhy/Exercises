package com.company.konski;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	Theatre odeon = new Theatre("Odeon", 8,12);
        odeon.listSeats();
        odeon.reserveSeat("B12");
        odeon.reserveSeat("B12");
        List<Theatre.Seat> listCopy = new ArrayList<>(odeon.seats);
        Collections.reverse(listCopy);
        printList(listCopy);
        Collections.sort(listCopy,Theatre.PRICE_COMP);
        printList(listCopy);

    }

    public static void printList(List <Theatre.Seat>listCopy){
        for (Theatre.Seat seat: listCopy){
            System.out.print("#"+seat.getSeatNumber()+" $"+seat.getSeatPrice()+" | ");

        }System.out.println();
    }
}

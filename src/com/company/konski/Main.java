package com.company.konski;

public class Main {

    public static void main(String[] args) {
	Theatre odeon = new Theatre("Odeon", 8,12);
//	odeon.listSeats();
        odeon.reserveSeat("B12");
        odeon.reserveSeat("B12");
        odeon.reserveSeat("z12");

    }
}

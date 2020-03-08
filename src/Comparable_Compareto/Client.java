package Comparable_Compareto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Client {
    public static void main(String[] args) {
        ArrayList<Laptop> list = new ArrayList<Laptop>();

        Laptop l1 = new Laptop(64, 120, 120);
        Laptop l2 = new Laptop(512, 60, 320);
        Laptop l3 = new Laptop(256, 256, 115);
        Laptop l4 = new Laptop(1024, 60, 200);
        Laptop l5 = new Laptop(128, 2048, 900);

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);

        Comparator<Laptop> comHard = new Comparator<Laptop>() {     //anonymous class
            @Override
            public int compare(Laptop o1, Laptop o2) {
                if (o1.getHardDesk() > o2.getHardDesk())
                    return 1;
                else if (o1.getHardDesk() < o2.getHardDesk())
                    return -1;
                else return 0;
            }
        };

        Comparator<Laptop> comRam = new Comparator<Laptop>() {      //anonymous class
            @Override
            public int compare(Laptop o1, Laptop o2) {
                if (o1.getRam() > o2.getRam())
                    return 1;
                else if (o1.getRam() < o2.getRam())
                    return -1;
                else
                    return 0;
            }
        };

        System.out.println("sorting according to price: ");
        Collections.sort(list);

        printList(list);

        System.out.println("\nsorting according to ram:");
        Collections.sort(list, comRam);
        printList(list);

        System.out.println("\nsorting according to hard desk:");
        Collections.sort(list, comHard);
        printList(list);

    }

    private static void printList(ArrayList<Laptop> list) {
        for (Laptop e : list)
            System.out.println(e);
    }
}

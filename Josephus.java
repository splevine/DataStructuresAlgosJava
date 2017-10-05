package josephus;

import java.util.*;

public class Josephus {

    public static void main(String[] argv) {
        List<Integer> r;
        // PRINT SEQUENCE
        System.out.println(r = josephus(41, 3));
        // PRINT LAST ENTRY
        System.out.printf("Person %d is last\n", r.get(r.size() - 1));  // 
    }

// remove N elements in equal steps starting at specific point
    static List<Integer> josephus(int N, int step) {

        List<Integer> p = new LinkedList<Integer>();
        for (int i = 1; i < N + 1; i++) {
            p.add(i);
        }

        List<Integer> r = new LinkedList<Integer>();
        int index = 0;
        for (int j = N; j > 0; j--) {
            index = (index + step - 1) % N--;
            // ADD NEXT LINE IF YOU WANT TO SEE PROGRESSION
            // System.out.println(p); 
            r.add(p.remove(index));
        }
        
        return r;
    }
}

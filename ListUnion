package listunion;

import java.util.*;

public class ListUnion {

    public static void main(String[] args) {
        //CREATE ARRAYS
        ArrayList<Integer> L1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7, 9, 14));
        ArrayList<Integer> L2 = new ArrayList<>(Arrays.asList(2, 3, 5, 8, 9, 12, 14, 17, 19));
        // PRINT UNION
        System.out.print(union(L1, L2));
    }

    public static List<Integer> union(List<Integer> L1, List<Integer> L2) {
        List<Integer> L3 = new ArrayList<>();
        Iterator<Integer> iter1 = L1.iterator();
        Iterator<Integer> iter2 = L2.iterator();
        int i = 0;

        Integer item1 = iter1.next();
        Integer item2 = iter2.next();

        int result;

        while (item1 != null && item2 != null) {
            System.out.println("item1: " + item1);
            System.out.println("item2: " + item2);
            
            result = item1.compareTo(item2);
            if (result == 0) {
                L3.add(item1);
                // if list 1 
                item1 = (iter1.hasNext()) ? iter1.next() : null;
                item2 = (iter2.hasNext()) ? iter2.next() : null;
            } else if (result > 0) {
                L3.add(item2);
                item2 = (iter2.hasNext()) ? iter2.next() : null;
            } else {
                L3.add(item1);
                item1 = (iter1.hasNext()) ? iter1.next() : null;
            }
        System.out.println(L3);
        
        }

        if (!iter1.hasNext()) {
            while (iter2.hasNext()) {
                L3.add(item2);
                item2 = (iter2.hasNext()) ? iter2.next() : null;
            }
        }

        if (!iter2.hasNext()) {
            while (iter1.hasNext()) {
                L3.add(item1);
                item1 = (iter1.hasNext()) ? iter1.next() : null;
            }
        }

        return L3;

    }
}

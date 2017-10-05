package mylinkedlistunion;

import java.util.*;

public class MyLinkedListUnion {

    public static void main(String[] args) {

        LinkedList<Integer> L1 = new LinkedList<>();
        L1.add(5);
        L1.add(8);
        L1.add(11);
        L1.add(13);
        L1.add(15);
        L1.add(19);
        L1.add(21);
        L1.add(41);
        
        LinkedList<Integer> L2 = new LinkedList<>();
        L2.add(5);
        L2.add(7);        
        L2.add(9);        
        L2.add(11);        
        L2.add(13);
        L2.add(17);
        
        LinkedList<Integer> L3 = new LinkedList<>();

        int posL1 = 0;
        int posL2 = 0;
        
        while (posL1 < L1.size() && posL2 < L2.size()){
            if (L1.get(posL1) == L2.get(posL2)){
                L3.add(L1.get(posL1));
                posL1++; 
                posL2++;
            }
        
            else if (L1.get(posL1) < L2.get(posL2)){
                L3.add(L1.get(posL1));
                posL1++; 
            }        
        
            else {
                L3.add(L2.get(posL2));
                posL2++;
            }
        }
        
        if (posL1 >= L1.size() - 1){
            while (posL2 < L2.size()){
                L3.add(L2.get(posL2));
                posL2++;
            }
        }
        
        if (posL2 >= L2.size() - 1){
            while (posL1 < L1.size()){
                L3.add(L1.get(posL1));
                posL1++;
            }
        }
          
    System.out.println(L3);                 
    }
}

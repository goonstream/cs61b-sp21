package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> alist = new AListNoResizing<>();
        alist.addLast(9);
        alist.addLast(99);
        alist.addLast(999);
        BuggyAList<Integer> blist=new BuggyAList<>();
        blist.addLast(9);
        blist.addLast(99);
        blist.addLast(999);
        //the test num is count
        int count=3;
        for (int i=0;i<count;i++){
            assertEquals(alist.removeLast(),blist.removeLast());
        }

    }
   @Test
    public void righttest(){
       AListNoResizing<Integer> L = new AListNoResizing<>();
       BuggyAList<Integer> B=new BuggyAList<>();
       int N = 50000;
       for (int i = 0; i < N; i += 1) {
           int operationNumber = StdRandom.uniform(0, 4);
           if (operationNumber == 0) {
               // addLast
               int randVal = StdRandom.uniform(0, 100);
               L.addLast(randVal);
               B.addLast(randVal);
               System.out.println("L addLast(" + randVal + ")");
               System.out.println("B addLast(" + randVal + ")");
               assertEquals(L.getLast(),B.getLast());
           } else if (operationNumber == 1) {
               // size
               int size1 = L.size();
               int size2=B.size();
               System.out.println("L size: " + size1);
               System.out.println("B size: " + size2);
               assertEquals(L.size(),B.size());
           }else if (operationNumber==2&&L.size()>0&&B.size()>0){
               //getlast
               System.out.println("L getLast(" + L.getLast() + ")");
               System.out.println("B getLast(" + B.getLast() + ")");
               assertEquals(L.getLast(),B.getLast());
           }else if(operationNumber==3&&L.size()>0&&B.size()>0){
               int last1=L.removeLast();
               int last2=B.removeLast();
               System.out.println("L removeLast(" + last1 + ")");
               System.out.println("B removeLast(" + last2 + ")");
               assertEquals(last1,last2);
           }
       }
    }
}

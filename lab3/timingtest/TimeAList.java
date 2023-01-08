package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        //Ns Alist
        AList<Integer> Ns=new AList<>();
        lst(Ns);
        AList<Double> times = new AList<>();
        for (int i=0;i< Ns.size();i++){
            Stopwatch sw = new Stopwatch();
            timeinaddlast(Ns.get(i));
            double time = sw.elapsedTime();
            times.addLast(time);
        }

        printTimingTable(Ns,times,Ns);
    }
    public static void timeinaddlast(int num){
        AList<Integer> aList = new AList<>();
        for (int i=0;i<num;i++){
            aList.addLast(i);
        }
    }
    public static void lst(AList <Integer> l){
        int num=8;
        int init=1000;
        for (int i=0;i<num;i++){
            l.addLast(init);
            init=init*2;
        }
    }
}

package timingtest;
import edu.princeton.cs.algs4.Stopwatch;
import static timingtest.TimeAList.lst;

/**
 * Created by hug.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        int ops=10000;
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        lst(Ns);
        for (int i=0;i<Ns.size();i++){
            SLList<Integer> s=new SLList();
            timeinaddlastS(s,Ns.get(i));
            Stopwatch sw = new Stopwatch();
            for (int j=0;j<ops;j++){
                s.getLast();
            }
            double time = sw.elapsedTime();
            times.addLast(time);

        }
        AList<Integer> op = new AList<>();
        for (int i=0;i<8;i++){
            op.addLast(ops);
        }
        printTimingTable(Ns,times,op);
    }
    public static void timeinaddlastS(SLList<Integer> s,int num){
        for (int i=0;i<num;i++){
            s.addLast(i);
        }
    }
}

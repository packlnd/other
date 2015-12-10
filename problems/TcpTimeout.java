public class TcpTimeout {
    public static void main(String[] args) {
        double estimatedrtt = 4.0;
        double samplertt = 1.0;
        double deviation = 0.5;
        double timeout=100;
        double del = 1.0/8.0;
        int count =0;
        while (timeout > 4) {
            double diff = samplertt-estimatedrtt;
            estimatedrtt+=del*diff;
            deviation += del*(Math.abs(diff)-deviation);
            timeout = 1.0*estimatedrtt+4.0*deviation;
            ++count;
            System.out.printf("#%d: %.2f\n", count, timeout);
        }
    }
}

import java.util.Arrays;

public class Provider implements IProvider {
    private final String[] argS;
    private final double[] argD;
    private int i;

    public Provider() {
        i = 0;
        argS = new String[7];
        Arrays.setAll(argS, p -> p + 1);
        argD = new double[7];
        Arrays.setAll(argD, p -> p + 1);
    }

    public String nextArgS() {
        String a = argS[i];
        i = (i + 1) % 7;
        return a;
    }

    public String getArgS(int id) {
        return (id < 7 && id >= 0) ? argS[id] : null;
    }

    public double nextArgD() {
        double a = argD[i];
        i = (i + 1) % 7;
        return a;
    }

    public double getArgD(int id) {
        return (id < 7 && id >= 0) ? argD[id] : 0;
    }
}
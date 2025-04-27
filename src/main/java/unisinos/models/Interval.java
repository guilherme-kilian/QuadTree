package unisinos.models;

public class Interval {
    public int Min;
    public int Max;

    public Interval(int min, int max) {
        Min = min;
        Max = max;
    }

    public boolean Contains(int value){
        return Min <= value && value <= Max;
    }
}

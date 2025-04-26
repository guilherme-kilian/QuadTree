package unisinos.models;

public class Interval {
    public int Min;
    public int Max;

    public boolean Contains(int value){
        return Min <= value && value <= Max;
    }
}

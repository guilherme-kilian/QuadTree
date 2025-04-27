package unisinos.models;

public class Interval2D {
    public Interval X;
    public Interval Y;

    public Boolean Contains(int x, int y){
        return X.Contains(x) && Y.Contains(y);
    }

    public Interval2D(Interval x, Interval y) {
        X = x;
        Y = y;
    }
}

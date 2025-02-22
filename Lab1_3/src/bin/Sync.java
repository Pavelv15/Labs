package bin;

public class Sync {
    private volatile double x = 1;
    private volatile boolean phase = true;


    public double getX() {
        return x;
    }

    public boolean isPhase() {
        return phase;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setPhase(boolean phase) {
        this.phase = phase;
    }
}

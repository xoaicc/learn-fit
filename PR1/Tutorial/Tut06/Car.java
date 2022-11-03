package PR1Tutorial.Tut06;

public class Car {
    int eff;
    int container;
    int consume;

    public Car(int efficiency) {
        this.eff = efficiency;
    }

    public int getEff() {
        return eff;
    }

    public int addGas(int amountIn) {
        container = amountIn;
        return container;
    }

    public int drive(int distance) {
        consume = distance / eff;
        return consume;
    }

    public int getGasInTank() {
        container -= consume;
        return container;
    }
}
package web.model;

public class Car {
    private String model;
    private int series;
    private double engineVol;

    public Car(String model, int series, double engineVol) {
        this.model = model;
        this.series = series;
        this.engineVol = engineVol;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public double getEngineVol() {
        return engineVol;
    }

    public void setEngineVol(double engineVol) {
        this.engineVol = engineVol;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                ", engineVol=" + engineVol +
                '}';
    }
}

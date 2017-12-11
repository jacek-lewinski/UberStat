package pl.jaceklewinski.uberstat.models.forms;

public class TripForm {

    private double price;
    private int minutes;
    private int seconds;
    private double distance;
    private double multiplier;

    public TripForm() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(float multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripForm tripForm = (TripForm) o;

        if (Double.compare(tripForm.price, price) != 0) return false;
        if (minutes != tripForm.minutes) return false;
        if (seconds != tripForm.seconds) return false;
        if (Double.compare(tripForm.distance, distance) != 0) return false;
        return Double.compare(tripForm.multiplier, multiplier) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + minutes;
        result = 31 * result + seconds;
        temp = Double.doubleToLongBits(distance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(multiplier);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "TripForm{" +
                "price=" + price +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                ", distance=" + distance +
                ", multiplier=" + multiplier +
                '}';
    }
}

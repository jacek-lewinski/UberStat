package pl.jaceklewinski.uberstat.models.forms;

public class TripForm {

    private float price;
    private int minutes;
    private int seconds;
    private float distance;
    private float muliplier;

    public TripForm() {
    }

    public float getPrice() {
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

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getMuliplier() {
        return muliplier;
    }

    public void setMuliplier(float muliplier) {
        this.muliplier = muliplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripForm tripForm = (TripForm) o;

        if (Float.compare(tripForm.price, price) != 0) return false;
        if (minutes != tripForm.minutes) return false;
        if (seconds != tripForm.seconds) return false;
        if (Float.compare(tripForm.distance, distance) != 0) return false;
        return Float.compare(tripForm.muliplier, muliplier) == 0;
    }

    @Override
    public int hashCode() {
        int result = (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + minutes;
        result = 31 * result + seconds;
        result = 31 * result + (distance != +0.0f ? Float.floatToIntBits(distance) : 0);
        result = 31 * result + (muliplier != +0.0f ? Float.floatToIntBits(muliplier) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TripForm{" +
                "price=" + price +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                ", distance=" + distance +
                ", muliplier=" + muliplier +
                '}';
    }
}

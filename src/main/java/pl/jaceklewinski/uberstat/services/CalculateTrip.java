package pl.jaceklewinski.uberstat.services;

import org.springframework.stereotype.Service;
import pl.jaceklewinski.uberstat.models.forms.TripForm;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Service
public class CalculateTrip {

    private double price;
    private int minutes;
    private int seconds;
    private double distance;
    private double multiplier;

    public CalculateTrip() {}

    public CalculateTrip(TripForm tripForm) {
        this.price = tripForm.getPrice();
        this.minutes = tripForm.getMinutes();
        this.seconds = tripForm.getSeconds();
        this.distance = tripForm.getDistance();
        this.multiplier = tripForm.getMultiplier();
    }

    public double calculateBruttoPrice() {
        double priceBrutto;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.HALF_EVEN);

        priceBrutto = this.price * 100 / 75;
        decimalFormat.format(priceBrutto);

        return priceBrutto;
    }

    public double convertTimeToMinutes() {
        double minutesConverted;
        double secondsConverted;

        secondsConverted = (double) this.seconds / 60;
        minutesConverted = this.minutes + secondsConverted;

        return minutesConverted;
    }
}

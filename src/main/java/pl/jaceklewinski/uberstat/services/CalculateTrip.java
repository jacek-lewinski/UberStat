package pl.jaceklewinski.uberstat.services;

import org.springframework.stereotype.Service;
import pl.jaceklewinski.uberstat.models.forms.TripForm;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Service
public class CalculateTrip {

    private final double driverPercentage = 0.75;
    private final double commission = 0.25;

    private final double priceByKilometer = 1.3;
    private final double priceByMinute = 0.25;
    private final int startingPrice = 4;

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

    public double calculateNettoPrice() {
        double nettoPrice;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.HALF_EVEN);

        nettoPrice = this.price * this.driverPercentage;
        decimalFormat.format(nettoPrice);

        return nettoPrice;
    }

    public double convertTimeToMinutes() {
        double minutesConverted;
        double secondsConverted;

        secondsConverted = (double) this.seconds / 60;
        minutesConverted = this.minutes + secondsConverted;

        return minutesConverted;
    }

    public double calculatePriceBasedOnInputData() {
        double fullPrice;
        double kilometersPrice;
        double minutesPrice;

        kilometersPrice = this.distance * this.priceByKilometer;
        minutesPrice = convertTimeToMinutes() * this.priceByMinute;
        fullPrice = ((kilometersPrice + minutesPrice + this.startingPrice) * this.multiplier) * this.driverPercentage;

        return fullPrice;
    }

    public double calculateCommission() {
        return this.price * this.commission;
    }

    public double calculateEarnings() {
        return this.price * this.driverPercentage;
    }

    public double differentBetweenPriceAndCalculatedPrice() {
        return calculateEarnings() - calculatePriceBasedOnInputData();
    }
}

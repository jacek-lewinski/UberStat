package pl.jaceklewinski.uberstat.services;

import org.springframework.stereotype.Service;
import pl.jaceklewinski.uberstat.models.forms.TripForm;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Service
public class CalculateTrip {

    private float price;
    private int minutes;
    private int seconds;
    private float distance;
    private float multiplier;

    public CalculateTrip() {}

    public CalculateTrip(TripForm tripForm) {
        this.price = tripForm.getPrice();
        this.minutes = tripForm.getMinutes();
        this.seconds = tripForm.getSeconds();
        this.distance = tripForm.getDistance();
        this.multiplier = tripForm.getMultiplier();
    }

    public float calculateBruttoPrice() {
        float priceBrutto;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.HALF_EVEN);

        priceBrutto = this.price * 100 / 75;
        decimalFormat.format(priceBrutto);

        return priceBrutto;
    }
}

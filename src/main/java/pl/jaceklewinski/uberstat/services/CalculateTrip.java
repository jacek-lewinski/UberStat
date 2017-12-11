package pl.jaceklewinski.uberstat.services;

import org.springframework.stereotype.Service;
import pl.jaceklewinski.uberstat.models.forms.TripForm;

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
        priceBrutto = this.price * 100 / 75;
        return priceBrutto;
    }
}

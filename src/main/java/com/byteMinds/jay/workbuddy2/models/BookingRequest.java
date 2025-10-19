package com.byteMinds.jay.workbuddy2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class BookingRequest extends Notification {
    @Enumerated(EnumType.STRING)
    private  PriceNegotiation priceNegotiation;

    public PriceNegotiation getPriceNegotiation() {
        return priceNegotiation;
    }

    public void setPriceNegotiation(PriceNegotiation priceNegotiation) {
        this.priceNegotiation = priceNegotiation;
    }
}

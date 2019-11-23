package dev.thiagokpelo.viagens.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Package implements Serializable {

    private final String local;
    private final String image;
    private final int days;
    private final BigDecimal price;

    public Package(String local, String image, int days, BigDecimal price) {
        this.local = local;
        this.image = image;
        this.days = days;
        this.price = price;
    }

    public String getLocal() {
        return local;
    }

    public String getImage() {
        return image;
    }

    public int getDays() {
        return days;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

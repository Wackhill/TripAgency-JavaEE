package com.shpakovskiy.trippy.app.entity;

public class Tour {

    private int id;
    private String caption;
    private String summary;
    private String address;
    private String priceDollars;
    private boolean isAvailable;
    private boolean isHot;
    private int discount;
    private String pictureLink;

    private Tour() { }

    public int getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }

    public String getSummary() {
        return summary;
    }

    public String getAddress() {
        return address;
    }

    public String getPriceDollars() {
        return priceDollars;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean isHot() {
        return isHot;
    }

    public int getDiscount() {
        return discount;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public static class Builder {
        private final Tour newTour;

        public Builder() {
            newTour = new Tour();
        }

        public Builder id(int id) {
            newTour.id = id;
            return this;
        }

        public Builder caption(String caption) {
            newTour.caption = caption;
            return this;
        }

        public Builder summary(String summary) {
            newTour.summary = summary;
            return this;
        }

        public Builder address(String address) {
            newTour.address = address;
            return this;
        }

        public Builder priceDollars(String priceDollars) {
            newTour.priceDollars = priceDollars;
            return this;
        }

        public Builder isAvailable(boolean isAvailable) {
            newTour.isAvailable = isAvailable;
            return this;
        }

        public Builder isHot(boolean isHot) {
            newTour.isHot = isHot;
            return this;
        }

        public Builder discount(int discount) {
            newTour.discount = discount;
            return this;
        }

        public Builder pictureLink(String pictureLink) {
            newTour.pictureLink = pictureLink;
            return this;
        }

        public Tour build() {
            return newTour;
        }
    }
}

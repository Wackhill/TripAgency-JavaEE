package com.shpakovskiy.trippy.dao.tour;

import com.shpakovskiy.trippy.app.entity.Tour;
import com.shpakovskiy.trippy.app.entity.User;
import com.shpakovskiy.trippy.utils.dbConnection.DbConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefaultTourDao implements TourDao {

    @Override
    public List<Tour> getAllTours() {
        Connection connection = DbConnectionFactory.getConnection();
        try {
            PreparedStatement getAllToursQuery = connection.prepareStatement("SELECT * FROM tours");

            List<Tour> allTours = new ArrayList<>();
            ResultSet allToursQueried = getAllToursQuery.executeQuery();

            while (allToursQueried.next()) {
                Tour newTour = new Tour
                        .Builder()
                        .caption(allToursQueried.getString(allToursQueried.findColumn("caption")))
                        .summary(allToursQueried.getString(allToursQueried.findColumn("summary")))
                        .priceDollars(allToursQueried.getString(allToursQueried.findColumn("price_dollars")))
                        .isHot(allToursQueried.getBoolean(allToursQueried.findColumn("is_hot")))
                        .discount(allToursQueried.getInt(allToursQueried.findColumn("discount")))
                        .pictureLink(allToursQueried.getString(allToursQueried.findColumn("picture_link")))
                        .build();

                allTours.add(newTour);
            }

            return allTours;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Tour getTourById(int tourId) {
        Connection connection = DbConnectionFactory.getConnection();
        try {
            PreparedStatement getAllToursQuery = connection.prepareStatement("SELECT * FROM tours WHERE id = " + tourId);

            ResultSet tourQueried = getAllToursQuery.executeQuery();

            if (tourQueried.next()) {
                return new Tour
                        .Builder()
                        .id(tourQueried.getInt(tourQueried.findColumn("id")))
                        .caption(tourQueried.getString(tourQueried.findColumn("caption")))
                        .summary(tourQueried.getString(tourQueried.findColumn("summary")))
                        .priceDollars(tourQueried.getString(tourQueried.findColumn("price_dollars")))
                        .isHot(tourQueried.getBoolean(tourQueried.findColumn("is_hot")))
                        .discount(tourQueried.getInt(tourQueried.findColumn("discount")))
                        .pictureLink(tourQueried.getString(tourQueried.findColumn("picture_link")))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addTour(Tour tour) {
        Connection connection = DbConnectionFactory.getConnection();

        try {
            PreparedStatement addTourQuery = connection.prepareStatement("INSERT INTO tours (caption, summary, price_dollars, is_hot, discount, picture_link) VALUES (?, ?, ?, ?, ?, ?)");
            addTourQuery.setString(1, tour.getCaption());
            addTourQuery.setString(2, tour.getSummary());
            addTourQuery.setString(3, tour.getPriceDollars());
            addTourQuery.setBoolean(4, tour.isHot());
            addTourQuery.setInt(5, tour.getDiscount());
            addTourQuery.setString(6, tour.getPictureLink());
            addTourQuery.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateTour(Tour tour) {
        Connection connection = DbConnectionFactory.getConnection();

        try {
            PreparedStatement addTourQuery = connection.prepareStatement("UPDATE tours SET caption = '" + tour.getCaption() + "', summary = '" + tour.getSummary() + "', price_dollars = '" + tour.getPriceDollars() + "', is_hot = " + tour.isHot() + ", discount = " + tour.getDiscount() + ", picture_link = '" + tour.getPictureLink() + "') WHERE id = " + tour.getId());
            addTourQuery.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}

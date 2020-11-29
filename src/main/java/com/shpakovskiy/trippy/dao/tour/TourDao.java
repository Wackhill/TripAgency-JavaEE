package com.shpakovskiy.trippy.dao.tour;

import com.shpakovskiy.trippy.app.entity.Tour;

import java.util.List;

public interface TourDao {

    List<Tour> getAllTours();
    Tour getTourById(int tourId);
    boolean updateTour(Tour tour);
    boolean addTour(Tour tour);
}

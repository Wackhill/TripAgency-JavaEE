package com.shpakovskiy.trippy.app.service.tour;

import com.shpakovskiy.trippy.app.entity.Tour;
import com.shpakovskiy.trippy.dao.tour.DefaultTourDao;

import java.util.List;

public class DefaultTourService implements TourService {

    @Override
    public List<Tour> getAllTours() {
        return (new DefaultTourDao()).getAllTours();
    }
}

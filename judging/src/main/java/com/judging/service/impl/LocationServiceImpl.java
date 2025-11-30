package com.judging.service.impl;

import com.judging.data.entity.Location;
import com.judging.data.repository.LocationRepository;
import com.judging.dto.LocationCreateArgs;
import com.judging.service.LocationService;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final GeometryFactory geometryFactory = new GeometryFactory();

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public void addLocation(LocationCreateArgs locationCreateArgs) {
        Location location = new Location();
        double[] latLon = locationCreateArgs.getLatLon();
        Point point = geometryFactory.createPoint(new Coordinate(latLon[1], latLon[0]));
        location.setGeom(point);
        location.setName(locationCreateArgs.getName());
        locationRepository.save(location);
    }
}

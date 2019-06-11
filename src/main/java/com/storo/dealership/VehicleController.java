package com.storo.dealership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.BooleanBuilder;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping
    public Page<Vehicle> getVehicles(@RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "500") int size,
            @RequestParam(name = "operatorAnd", defaultValue = "true") Boolean operatorAnd, @RequestParam(name = "_id", required = false) String _id,
            @RequestParam(name = "make", required = false) String make, @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "color", required = false) String color, @RequestParam(name = "price", required = false) Integer price,
            @RequestParam(name = "hasSunroof", required = false) Boolean hasSunroof, @RequestParam(name = "isFourWheelDrive", required = false) Boolean isFourWheelDrive,
            @RequestParam(name = "hasLowMiles", required = false) Boolean hasLowMiles, @RequestParam(name = "hasPowerWindows", required = false) Boolean hasPowerWindows,
            @RequestParam(name = "hasNavigation", required = false) Boolean hasNavigation, @RequestParam(name = "hasHeatedSeats", required = false) Boolean hasHeatedSeats) {

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if (_id != null && !_id.isEmpty()) {
            if (operatorAnd)
                booleanBuilder.and(QVehicle.vehicle._id.eq(_id));
            else
                booleanBuilder.or(QVehicle.vehicle._id.eq(_id));
        }

        if (make != null && !make.isEmpty()) {
            if (operatorAnd)
                booleanBuilder.and(QVehicle.vehicle.make.eq(make));
            else
                booleanBuilder.or(QVehicle.vehicle.make.eq(make));
        }

        if (color != null && !color.isEmpty()) {
            if (operatorAnd)
                booleanBuilder.and(QVehicle.vehicle.color.eq(color));
            else
                booleanBuilder.or(QVehicle.vehicle.color.eq(color));
        }

        if (year != null && year != 0) {
            if (operatorAnd)
                booleanBuilder.and(QVehicle.vehicle.year.goe(year));
            else
                booleanBuilder.or(QVehicle.vehicle.year.goe(year));
        }

        if (price != null && price != 0) {
            if (operatorAnd)
                booleanBuilder.and(QVehicle.vehicle.price.loe(price));
            else
                booleanBuilder.or(QVehicle.vehicle.price.loe(price));
        }

        if (hasSunroof != null) {
            if (operatorAnd)
                booleanBuilder.and(QVehicle.vehicle.hasSunroof.eq(hasSunroof));
            else
                booleanBuilder.or(QVehicle.vehicle.hasSunroof.eq(hasSunroof));
        }

        if (isFourWheelDrive != null) {
            if (operatorAnd)
                booleanBuilder.and(QVehicle.vehicle.isFourWheelDrive.eq(isFourWheelDrive));
            else
                booleanBuilder.or(QVehicle.vehicle.isFourWheelDrive.eq(isFourWheelDrive));
        }

        if (hasLowMiles != null) {
            if (operatorAnd)
                booleanBuilder.and(QVehicle.vehicle.hasLowMiles.eq(hasLowMiles));
            else
                booleanBuilder.or(QVehicle.vehicle.hasLowMiles.eq(hasLowMiles));
        }

        if (hasPowerWindows != null) {
            if (operatorAnd)
                booleanBuilder.and(QVehicle.vehicle.hasPowerWindows.eq(hasPowerWindows));
            else
                booleanBuilder.or(QVehicle.vehicle.hasPowerWindows.eq(hasPowerWindows));
        }

        if (hasNavigation != null) {
            if (operatorAnd)
                booleanBuilder.and(QVehicle.vehicle.hasNavigation.eq(hasNavigation));
            else
                booleanBuilder.or(QVehicle.vehicle.hasNavigation.eq(hasNavigation));
        }

        if (hasHeatedSeats != null) {
            if (operatorAnd)
                booleanBuilder.and(QVehicle.vehicle.hasHeatedSeats.eq(hasHeatedSeats));
            else
                booleanBuilder.or(QVehicle.vehicle.hasHeatedSeats.eq(hasHeatedSeats));
        }

        return vehicleRepository.findAll(booleanBuilder.getValue(), PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "_id")));
    }
}

package com.storo.dealership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

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
            addPredicate(booleanBuilder, operatorAnd, QVehicle.vehicle._id.eq(_id));
        }
        if (make != null && !make.isEmpty()) {
            addPredicate(booleanBuilder, operatorAnd, QVehicle.vehicle.make.eq(make));
        }
        if (color != null && !color.isEmpty()) {
            addPredicate(booleanBuilder, operatorAnd, QVehicle.vehicle.color.eq(color));
        }
        if (year != null && year != 0) {
            addPredicate(booleanBuilder, operatorAnd, QVehicle.vehicle.year.goe(year));
        }
        if (price != null && price != 0) {
            addPredicate(booleanBuilder, operatorAnd, QVehicle.vehicle.price.loe(price));
        }
        if (hasSunroof != null) {
            addPredicate(booleanBuilder, operatorAnd, QVehicle.vehicle.hasSunroof.eq(hasSunroof));
        }
        if (isFourWheelDrive != null) {
            addPredicate(booleanBuilder, operatorAnd, QVehicle.vehicle.isFourWheelDrive.eq(isFourWheelDrive));
        }
        if (hasLowMiles != null) {
            addPredicate(booleanBuilder, operatorAnd, QVehicle.vehicle.hasLowMiles.eq(hasLowMiles));
        }
        if (hasPowerWindows != null) {
            addPredicate(booleanBuilder, operatorAnd, QVehicle.vehicle.hasPowerWindows.eq(hasPowerWindows));
        }
        if (hasNavigation != null) {
            addPredicate(booleanBuilder, operatorAnd, QVehicle.vehicle.hasNavigation.eq(hasNavigation));
        }
        if (hasHeatedSeats != null) {
            addPredicate(booleanBuilder, operatorAnd, QVehicle.vehicle.hasHeatedSeats.eq(hasHeatedSeats));
        }

        return vehicleRepository.findAll(booleanBuilder.getValue(), PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "_id")));
    }

    private void addPredicate(BooleanBuilder booleanBuilder, Boolean operatorAnd, @Nullable Predicate right) {
        if (operatorAnd) {
            booleanBuilder.and(right);
        } else {
            booleanBuilder.or(right);
        }
    }
}

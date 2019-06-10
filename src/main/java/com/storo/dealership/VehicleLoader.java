package com.storo.dealership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class VehicleLoader implements CommandLineRunner {

    @Autowired
    private VehicleRepository repository;

    @Override
    public void run(String... strings) throws Exception {
        saveVehicle("59d2698c2eaefb1268b69ee5", "Chevy", 2016, "Gray", 16106, false, true, true, false, true, false);
        saveVehicle("59d2698c05889e0b23959106", "Toyota", 2012, "Silver", 18696, true, true, false, true, false, true);
        saveVehicle("59d2698c6f1dc2cbec89c413", "Mercedes", 2016, "Black", 18390, true, false, false, true, true, false);
        saveVehicle("59d2698c340f2728382c0a73", "Toyota", 2015, "White", 15895, true, false, true, true, false, true);
        saveVehicle("59d2698cba9b82c2347cd13a", "Ford", 2014, "Gray", 19710, false, true, false, false, true, true);
        saveVehicle("59d2698ce2e7eeeb4f109001", "Toyota", 2014, "Red", 19248, true, false, true, true, true, true);
        saveVehicle("59d2698cd6a3b8f0dd994c9d", "Toyota", 2015, "Black", 13170, true, false, true, true, false, false);
        saveVehicle("59d2698c86ab54cee8acdc7b", "Mercedes", 2013, "Gray", 15669, false, false, true, false, false, false);
        saveVehicle("59d2698cda9e8d39476c678a", "Toyota", 2015, "White", 16629, false, false, true, false, false, true);
    }

    private void saveVehicle(String _id, String make, Integer year, String color, Integer price, Boolean hasSunroof, Boolean isFourWheelDrive, Boolean hasLowMiles,
            Boolean hasPowerWindows, Boolean hasNavigation, Boolean hasHeatedSeats) {
        Vehicle v = new Vehicle();
        v.set_id(_id);
        v.setMake(make);
        v.setYear(year);
        v.setColor(color);
        v.setPrice(price);
        v.setHasSunroof(hasSunroof);
        v.setIsFourWheelDrive(isFourWheelDrive);
        v.setHasLowMiles(hasLowMiles);
        v.setHasPowerWindows(hasPowerWindows);
        v.setHasNavigation(hasNavigation);
        v.setHasHeatedSeats(hasHeatedSeats);
        repository.save(v);
    }
}

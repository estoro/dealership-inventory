Steps to run this project:

1. Clone this Git repository
2. Navigate to the folder `dealership-inventory`
3. Build the application with `mvn clean package` (Alternatively I have included an endstate folder with an already built jar)
4. Run the application with `java -jar target/dealership-inventory.jar`
5. Visit the following endpoint within your browser: `http://localhost:8080/`

```
"I want my car to have a sun roof, 4 wheel drive, and power windows."
http://localhost:8080/api/vehicles?hasSunroof=true&isFourWheelDrive=true&hasPowerWindows=true

"I want a car with navigation, sun roof, or low miles."
http://localhost:8080/api/vehicles?operatorAnd=false&hasNavigation=true&hasSunroof=true&hasLowMiles=true

Other Examples:
http://localhost:8080/api/vehicles?make=Toyota&page=0&size=3
http://localhost:8080/api/vehicles?make=Toyota&page=1&size=3
http://localhost:8080/api/vehicles?price=16000
http://localhost:8080/api/vehicles/basic?hasNavigation=true
http://localhost:8080/api/vehicles/basic?year=2014
```

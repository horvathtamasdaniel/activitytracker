package activity;

public class Coordinate {

    private double latitude;
    private double longitude;

    public Coordinate(double latitude, double longitude) {
        if (validLatitude(latitude) && validLongitude(longitude)) {
            this.latitude = latitude;
            this.longitude = longitude;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double getLatitude() {
        if(validLatitude(latitude)) {
            return latitude;
        }
        throw new IllegalArgumentException();
    }

    public double getLongitude() {
        if(validLongitude(longitude)) {
            return longitude;
        }
        throw new IllegalArgumentException();
    }

    private boolean validLatitude(double latitude) {
        if (latitude > -90.1 && latitude < 90.1) {
            return true;
        }
        return false;
    }

    private boolean validLongitude(double longitude) {
        if (longitude > -180.1 && longitude < 180.1) {
            return true;
        }
        return false;
    }
}

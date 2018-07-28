package activity;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint(TrackPoint trackPoint) {
        if (trackPoint == null) {
            throw new IllegalArgumentException("Trackpoint must not be null!");
        }
        trackPoints.add(trackPoint);
    }

    public Coordinate findMaximumCoordinate() {
        if (isValidList(trackPoints)) {
    }

        return null;
    }

    public Coordinate findMinimumCoordinate() {
        return null;
    }

    public double getDistance() {
        if (!isValidList(trackPoints)) {
            throw new IllegalArgumentException("List must not be null or empty!");
        }
        if (trackPoints.size() == 1) {
            return 0;
        }
        double sum = 0;

        for (int i = 0; i < (trackPoints.size() - 1); i++) {
            sum += trackPoints.get(i).getDistanceFrom(trackPoints.get(i + 1));
        }
        return sum;
    }

    public double getFullDecrease() {
        return 0.0;
    }

    public double getFullElevation() {
        return 0.0;
    }

    public double getRectangleArea() {
        return 0.0;
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    private boolean isValidList(List list) {
        if ((list == null) || (list.size() == 0)) {
            return false;
        }
        return true;
    }
}

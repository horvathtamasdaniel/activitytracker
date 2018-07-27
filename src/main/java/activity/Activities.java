package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {

    private List<Activity> activities;


    public Activities(List<Activity> activities) {
        if (activities == null) {
            throw new IllegalArgumentException("msg");
        }
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("msg");
        }
        activities.add(activity);
    }

    public List<Report> distancesByTypes() {
        List<Report> result = new ArrayList<>();
        double basketballDistance = 0;
        double bikingDistance = 0;
        double hikingDistance = 0;
        double runningDistance = 0;

        for (Activity a : activities) {
            switch (a.getType()) {
                case BASKETBALL:
                    basketballDistance += a.getDistance();
                case BIKING:
                    bikingDistance += a.getDistance();
                case HIKING:
                    hikingDistance += a.getDistance();
                case RUNNING:
                    runningDistance += a.getDistance();
            }
        }

        result.add(new Report(ActivityType.BASKETBALL, basketballDistance));
        result.add(new Report(ActivityType.BIKING, bikingDistance));
        result.add(new Report(ActivityType.HIKING, hikingDistance));
        result.add(new Report(ActivityType.RUNNING, runningDistance));

        return result;
    }

    public int numberOfTrackActivities() {
        int count = 0;

        for (Activity a : activities) {
            if (a instanceof ActivityWithTrack) {
                count++;
            }
        }
        return count;
    }

    public int numberOfWithoutTrackActivities() {
        int count = 0;

        for (Activity a : activities) {
            if (a instanceof ActivityWithoutTrack) {
                count++;
            }
        }
        return count;
    }
}

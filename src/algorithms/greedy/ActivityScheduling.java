package algorithms.greedy;

import java.util.ArrayList;

public class ActivityScheduling {

    static class Activity {
        String name;
        int start;
        int end;

        public Activity(String name, int start, int end) {
            this.name = name;
            this.start = start;
            this.end = end;
        }

    }

    public static void main(String[] args) {
        int[] startTimes = {1, 1, 0, 4, 3, 4, 5, 2};
        int[] endTimes = {2, 3, 4, 5, 5, 6, 8, 9};
        String[] activity = {"A", "B", "C", "D", "E", "F", "G", "H"};

        ArrayList<Activity> activities = new ArrayList<>();

        for(int i = 0; i < startTimes.length; ++i) {
            activities.add(new Activity(activity[i], startTimes[i], endTimes[i]));
        }

        activityScheduler(activities);

    }

    private static void activityScheduler(ArrayList<Activity> activities) {
        ArrayList<Activity> optimalActivities = new ArrayList<>();

        Activity i = activities.get(0);
        optimalActivities.add(i);

        for(Activity activity : activities) {
            if(activity.start >= i.end) {
                optimalActivities.add(activity);
                i = activity;
            }
        }

        for(Activity activity : optimalActivities) {
            System.out.print(activity.name + " ");
        }
    }
}

package skoohgoli.interview.convoy.data;

import java.util.*;

/**
 * Created by Sacha on 5/26/17.
 */
public class Trips {
    private Map<Day, Map<Source, Stack<Destination>>> trips;

    public Trips() {
        this.trips = new HashMap<>();
    }

    public void add(Day day, Source source, Destination destination) {
        if (!trips.containsKey(day)) {
            trips.put(day, new HashMap<>());
        }

        if (!trips.get(day).containsKey(source)) {
            trips.get(day).put(source, new Stack<>());
        }

        trips.get(day).get(source).push(destination);
    }

    public boolean dayExists(Day day) {
        return trips.containsKey(day);
    }

    public boolean tripsFromSourceOnDayExists(Day day, Source source) {
        return trips.containsKey(day) && trips.get(day).containsKey(source);
    }

    public Stack<Destination> getTripsFromSourceOnDay(Day day, Source source) {
        if (trips.containsKey(day) && trips.get(day).containsKey(source)) {
            return trips.get(day).get(source);
        } else {
            return null;
        }
    }

    public Map<Source,Stack<Destination>> getTripsOnDay(Day day) {
        return trips.get(day);
    }
}

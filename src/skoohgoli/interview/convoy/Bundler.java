package skoohgoli.interview.convoy;

import skoohgoli.interview.convoy.data.Trips;
import skoohgoli.interview.convoy.data.Day;
import skoohgoli.interview.convoy.data.Destination;
import skoohgoli.interview.convoy.data.Source;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Sacha on 5/26/17.
 */
public class Bundler {

    private Trips trips;

    public Bundler() {
        this.trips = new Trips();
    }

    /**
     * O(n) runtime, as it traverses through the trip data set twice. The first traversal is to build the structure, the second is to travel through the "branches" to gather the paths
     * O(n) space, as it stores the trips in memory.
     */
    public List<String> calculateBundledTrips() {
        List<String> bundledTrips = new ArrayList<>();
        for (Day day : Day.values()) {
            Map<Source, Stack<Destination>> trips = this.trips.getTripsOnDay(day);
            if (trips != null) {
                for (Source source : trips.keySet()) {
                    explore(day, source, new StringBuilder(), bundledTrips);
                }
            }
        }

        return bundledTrips;
    }

    /**
     * Recursive implementation.
     *    If done iteratively would be more memory efficient (wouldn't have to worry about the function call stack memory),
     *    but the could would not be as easy to read. For an interview question, I prioritized readability over memory usage.

     */
    private void explore(Day day, Source source, StringBuilder path, List<String> allPaths) {
        if (day != null && trips.dayExists(day) && trips.tripsFromSourceOnDayExists(day, source)) {
            Stack<Destination> destinations = trips.getTripsFromSourceOnDay(day, source);
            boolean firstIteration = true;
            while (destinations != null && !destinations.isEmpty()) {
                Destination dest = destinations.pop();
                if (firstIteration) {
                    path.append(dest.getId()).append(" ");
                    firstIteration = false;
                    explore(day.next(), new Source(dest.getDestination()), path, allPaths);
                } else {
                    StringBuilder newPath = new StringBuilder();
                    newPath.append(dest.getId()).append(" ");
                    explore(day.next(), new Source(dest.getDestination()), newPath, allPaths);
                }
            }
        } else {
            String finalPath = path.toString();
            allPaths.add(finalPath.substring(0, finalPath.length() - 1));
        }
    }

    //parse input
    public void loadTripsFromFile(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            while (line != null) {
                line = line.toUpperCase();
                //ignore commented lines
                if (line.charAt(0) != '#') {
                    String[] inputs = line.split(" ");
                    if (inputs.length != 4 || inputs[0].isEmpty() || inputs[1].isEmpty() || inputs[2].isEmpty() || inputs[3].isEmpty()) {
                        throw new RuntimeException("Bad input in file, line must be in following format:" +
                                " <SHIPMENT_ID> <START_CITY> <END_CITY> <DAY_OF_WEEK>");
                    }
                    trips.add(Day.valueOf(inputs[3]), new Source(inputs[1]), new Destination(inputs[0], inputs[2]));
                }

                line = br.readLine();
            }

            br.close();
        } catch (IOException e) {
            System.err.println("Error occured while opening up file. Unable to process trips");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        Bundler bundler = new Bundler();
        bundler.loadTripsFromFile(args[0]);

        List<String> bundledTrips = bundler.calculateBundledTrips();

        for (String trip : bundledTrips) {
            System.out.println(trip);
        }
    }
}

package skoohgoli.interview.convoy.data;

import java.util.Objects;

/**
 * Created by Sacha on 5/26/17.
 */
public class Destination {
    private final String id;
    private final String destination;

    public Destination(String id, String destination) {
        this.id = id;
        this.destination = destination;
    }

    public String getId() {
        return this.id;
    }

    public String getDestination() {
        return this.destination;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Source)) {
            return false;
        }

        Destination other = (Destination) o;

        return this.id.equals(other.id) &&
                this.destination.equals(other.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destination);
    }
}

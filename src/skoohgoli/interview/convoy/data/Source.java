package skoohgoli.interview.convoy.data;

import java.util.Objects;

/**
 * @author Sacha
 */
public class Source {
    private final String value;

    public Source (String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Source)) {
            return false;
        }

        Source other = (Source) o;

        return this.value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}

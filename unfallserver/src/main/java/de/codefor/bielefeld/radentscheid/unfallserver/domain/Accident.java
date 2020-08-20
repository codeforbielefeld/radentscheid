package de.codefor.bielefeld.radentscheid.unfallserver.domain;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

/**
 * author skonair@gmail.com
 * date 16.08.20
 */
public class Accident {

    private String id;
    private MonthYear date;
    private Location location;
    private Kind kind;
    private Participant participant1;
    private Optional<Participant> participant2;


    public Accident(String id, MonthYear date, Location location, Kind kind, Participant participant1, Optional<Participant> participant2) {
        this.id = id;
        this.date = date;
        this.location = location;
        this.kind = kind;
        this.participant1 = participant1;
        this.participant2 = participant2;
    }

    public String id() {
        return id;
    }

    public MonthYear date() {
        return date;
    }

    public Location location() {
        return location;
    }

    public Kind kind() {
        return kind;
    }

    /**
     * @return the bike opposing participant if another party was involved
     */
    public Optional<Participant> otherParty() {
        if (participant1 == Participant.BIKE) {
            return participant2;
        } else {
            return Optional.of(participant1);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accident accident = (Accident) o;
        return Objects.equals(id, accident.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

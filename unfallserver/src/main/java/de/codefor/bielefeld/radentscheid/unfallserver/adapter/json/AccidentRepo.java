package de.codefor.bielefeld.radentscheid.unfallserver.adapter.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.codefor.bielefeld.radentscheid.unfallserver.domain.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * author skonair@gmail.com
 * date 16.08.20
 */
@Repository
public class AccidentRepo implements JsonRepository<Accident, String> {

    private final ObjectMapper objectMapper;

    private final KindRepo kindRepo;

    private AccidentsDto accidentsDto;

    public AccidentRepo(ObjectMapper objectMapper, KindRepo kindRepo) {
        this.objectMapper = objectMapper;
        this.kindRepo = kindRepo;
    }

    @PostConstruct
    void setup() throws IOException {
        Resource accidentsResource = new ClassPathResource("/json/accidents.json", AccidentRepo.class.getClassLoader());
        accidentsDto = objectMapper.readValue(accidentsResource.getInputStream(), AccidentsDto.class);
    }

    @Override
    public Accident findOne(String primaryKey) {
        return accidentsDto.getAccidents().stream()
                .filter(a -> a.getId().equals(primaryKey))
                .findFirst()
                .map(this::toDomainObject)
                .orElseThrow(() -> new IllegalArgumentException("Accident with primary key " + primaryKey + " does not exist."));
    }

    @Override
    public Iterable<Accident> findAll() {
        return accidentsDto.getAccidents().stream()
                .map(this::toDomainObject)
                .collect(Collectors.toSet());
    }

    @Override
    public Long count() {
        return (long) accidentsDto.getAccidents().size();
    }

    @Override
    public boolean exists(String primaryKey) {
        return accidentsDto.getAccidents().stream()
                .anyMatch(a -> a.getId().equals(primaryKey));
    }

    public Set<Accident> findByCoordinate(double minLng, double minLat, double maxLng, double maxLat) {
        return accidentsDto.getAccidents().stream()
                .filter(a -> a.getLat() <= maxLat && a.getLat() >= minLat && a.getLng() <= maxLng && a.getLng() >= minLng)
                .map(this::toDomainObject)
                .collect(Collectors.toSet());
    }

    /**
     * @return the accidents that are within the given radius from the lng/lat location.
     */
    public Set<Accident> findByDistance(Location center, double radius) {
        return accidentsDto.getAccidents().stream()
                .filter(a -> center.distance(new Location(a.getLat(), a.getLng())) <= radius)
                .map(this::toDomainObject)
                .collect(Collectors.toSet());
    }

    /**
     * @return the accidents that are within the given radius from the lng/lat location
     * for the given year and month.
     * If year or month is null, it is not taken into consideration.
     */
    public Set<Accident> findByDateAndDistance(Integer year, Integer month, Location center, double radius) {
        return accidentsDto.getAccidents().stream()
                .filter(a -> (year == null || a.getYear() == year) && (month == null || a.getMonth() == month))
                .filter(a -> center.distance(new Location(a.getLat(), a.getLng())) <= radius)
                .map(this::toDomainObject)
                .collect(Collectors.toSet());
    }

    private Accident toDomainObject(AccidentDto accidentDto) {
        MonthYear monthYear = new MonthYear(accidentDto.getMonth(), accidentDto.getYear());
        Location location = new Location(accidentDto.getLat(), accidentDto.getLng());
        Kind kind = kindRepo.findOne(accidentDto.getKindOf());
        Optional<Participant> participant2 = Optional.of(Participant.BIKE);
        if (1 == accidentDto.getIstpkw()) {
            participant2 = Optional.of(Participant.CAR);
        } else if (1 == accidentDto.getIstfuss()) {
            participant2 = Optional.of(Participant.PEDESTRIAN);
        } else
        if (1 == accidentDto.getIstkrad()) {
            participant2 = Optional.of(Participant.MOTORCYCLE);
        } else
        if (1 == accidentDto.getIstgkfz()) {
            participant2 = Optional.of(Participant.TRUCK);
        } else
        if (1 == accidentDto.getIstsonstiges()) {
            participant2 = Optional.of(Participant.OTHER);
        }
        return new Accident(accidentDto.getId(), monthYear, location, kind, Participant.BIKE, participant2);
    }
}

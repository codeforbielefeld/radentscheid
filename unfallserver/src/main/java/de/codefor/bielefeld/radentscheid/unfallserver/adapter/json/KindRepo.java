package de.codefor.bielefeld.radentscheid.unfallserver.adapter.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.codefor.bielefeld.radentscheid.unfallserver.domain.Description;
import de.codefor.bielefeld.radentscheid.unfallserver.domain.Kind;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Optional.empty;

/**
 * author skonair@gmail.com
 * date 16.08.20
 */
@Repository
public class KindRepo implements JsonRepository<Kind, Integer> {

    private final ObjectMapper objectMapper;

    private KindsDto kindsDto;

    public KindRepo(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    void setup() throws IOException {
        Resource kindsResource = new ClassPathResource("./json/kinds.json", KindRepo.class.getClassLoader());
        kindsDto = objectMapper.readValue(kindsResource.getInputStream(), KindsDto.class);
    }

    @Override
    public Kind findOne(Integer primaryKey) {
        return kindsDto.getKinds().stream()
                .filter(k -> k.getId() == primaryKey)
                .findFirst()
                .map(KindRepo::toDomainObject)
                .orElseThrow(() -> new IllegalArgumentException("Kind with primary key " + primaryKey + " does not exist."));
    }

    @Override
    public Iterable<Kind> findAll() {
        return kindsDto.getKinds().stream()
                .map(KindRepo::toDomainObject)
                .collect(Collectors.toSet());
    }

    @Override
    public Long count() {
        return (long) kindsDto.getKinds().size();
    }

    @Override
    public boolean exists(Integer primaryKey) {
        return kindsDto.getKinds().stream()
                .anyMatch(k -> k.getId() == primaryKey);
    }

    private static Kind toDomainObject(KindDto kindDto) {
        final Description description = new Description(kindDto.getDescription(), emptyList(), empty());
        return new Kind(kindDto.getId(), description);
    }
}

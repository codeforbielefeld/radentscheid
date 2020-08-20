package de.codefor.bielefeld.radentscheid.unfallserver.adapter.web;

import de.codefor.bielefeld.radentscheid.unfallserver.adapter.json.AccidentRepo;
import de.codefor.bielefeld.radentscheid.unfallserver.domain.Accident;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * author skonair@gmail.com
 * date 16.08.20
 */
@RestController
@RequestMapping("/api/accident")
public class AccidentController {

    private final AccidentRepo accidentRepo;

    AccidentController(AccidentRepo accidentRepo) {
        this.accidentRepo = accidentRepo;
    }

    @GetMapping
    public ResponseEntity<List<AccidentDto>> getAll() {
        List<AccidentDto> accidents = new ArrayList<>();
        Iterable<Accident> accidentIterable = accidentRepo.findAll();
        accidentIterable.forEach(a -> accidents.add(fromDomainObject(a)));
        return ResponseEntity.ok(accidents);
    }

    private AccidentDto fromDomainObject(Accident accident) {
        AccidentDto accidentDto = new AccidentDto();
        accidentDto.setId(accident.id());
        accidentDto.setKind(accident.kind().id());
        accidentDto.setLat(accident.location().lat());
        accidentDto.setLng(accident.location().lng());
        accidentDto.setMonth(accident.date().month());
        accidentDto.setYear(accident.date().year());
        accidentDto.setOtherParty(accident.otherParty());
        return accidentDto;
    }
}

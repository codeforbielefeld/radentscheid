package de.codefor.bielefeld.randentscheid.flaechenvergleich.alkisimporter;

import de.codefor.bielefeld.randentscheid.flaechenvergleich.model.AXBestandsdatenauszugType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@DisplayName("JaxB Parser Tests")
public class JaxBParserTest {

    @Test
    @DisplayName("it should parse a test xml file to ensure jaxb generated code")
    public void it_should_parse_a_test_xml() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(AXBestandsdatenauszugType.class);
    }

}

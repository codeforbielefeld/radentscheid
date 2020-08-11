# Architektur

![Architektur Bild](01_bilder/person-holding-black-pen-1109541.jpg)

## Konzept

User System unterteilt sich in verschiedene Sub-Systeme, welche jeweils eine konkrete 
Aufgabe übernehmen. Monolithische Ansätze sind zu vermeiden.

![Konzept Bild](02_diagramme/01_komponenten.png)

- Es existieren sowohl die Alkis als auch die Openstreetmap Daten im Rohwformat.
- Der Alkis Importer liest diese Rohdaten, verändert und filter diese und speichert das
    Ergebnis in der Datenbank ab.
- Der Openstreemap Importer verhält sich analog.
- Anschließend wird der Flächenvergleich Prozesor gestartet. Der Prozessor lädt sowohl die
    Alkis als auch die Opensteetmap Daten und aggregiert diese. Das Ergebnis wiederum wird
    auch hier in der Datenbank abgespeichert.
- Um die Daten zu Verfügung zur stellen stehen zwei Möglichkeiten zur Auswahl:
    - Eine Rest Api, mit welcher dir Informationen direkt abgefragt werden können.
    - Ein Web-Frontend welches die Informationen via Rest Api visualisiert.  

### Datenbank

### Importer

### Prozessoren

### Rest Interface

### Web Frontend

## ALKIS Importer

### Anforderungen

#### Funktionale Anforderungen

- Straßen und Plätze können in ALKIS einen _Namen_ und einen _Zweitnamen_ haben. _Name_ ist der offizielle Eigenname, 
    während der _Zweitname_ der touristische oder volkstümliche Name ist (z.B. Deutsche Weinstraße). Ein Mapping über 
    Straßennamen muss immer beide Namen betrachten. Der _Name_ wird aber gegenüber dem _Zweitnamen_ bevorzugt.
    
- Zu importierende Datensätze

    - 42001: AX_Strassenverkehr
    
        "Straßenverkehr" umfasst alle für die bauliche Anlage Straße erforderlichen Flächen und die dem Straßenverkehr 
        dienenden bebauten und unbebauten Flächen.
        - 2311: Gebäude- und Freifläche zu Verkehrsanlagen, Straße  ist  eine  Fläche die der Abwicklung und 
         Sicherheit des Verkehrs sowie der Unterhaltung der Verkehrsfläche dient. 
        - 2312: Begleitfläche  Straßenverkehr bezeichnet eine unbebaute Fläche, die einer Straße zugeordnet wird.
         Die 'Begleitfläche Straßenverkehr' ist nicht Bestandteil der Fahrbahn.
        - 2313: Straßenentwässerungsanlage ist der zur Entwässerung dienende Bestandteil der Verkehrsanlage.
        - 2314: Betriebsfläche Straßenverkehr bezeichnet bebaute oder unbebaute Flächen, die vorwiegend der Versorgung 
        und Unterhaltung der Verkehrsflächen des Straßenverkehrs dienen. Hierzu gehören z.B. Straßenmeistereien.
        - 2315: Fahrbahn bezeichnet Flächen, die den zusammenhängenden, befestigten Teil der Straße bilden, 
        als Verkehrsraum dienen und mit Fahrzeugen befahren werden dürfen. Zur Fahrbahn gehören auch Stand 
        und Kriechspuren.
        - 5130: Fußgängerzone ist ein dem Fußgängerverkehr vorbehaltener Bereich, in dem ausnahmsweise öffentlicher 
        Personenverkehr, Lieferverkehr oder Fahrradverkehr zulässig sein kann.
        
    - 42006: AX_Weg
    
        'Weg' umfasst alle Flächen, die zum Befahren und/oder Begehen vorgesehen sind. 
        Zur Weg-fläche gehören auch Seitenstreifen und Gräben zur Wegentwässerung.
        - 5210: Fahrweg ist ein Weg, auf dem das Befahren mit Fahrzeugen möglich ist.
        - 5211: Hauptwirtschaftsweg ist ein Weg mit fester Fahrbahndecke zur Erschließung eines oder mehrerer 
        Grund-stücke, der für den Kraftverkehr zu jeder Jahreszeit befahrbar ist. Dazu gehören auch Lkw-befahrbare 
        Wege im Wald, die dem forstwirtschaftlichen Holztransport zu jeder Zeit dienen.
        - 5212: Wirtschaftsweg ist ein leicht- oder unbefestigter Weg zur Erschließung land- und 
        forstwirtschaftlicher Flächen.
        - 5220: Fußweg ist ein Weg, der auf Grund seines Ausbauzustandes nur von Fußgängern zu begehen ist.
        - 5230: Gang ist ein schmaler Fußweg.
        - 5240: Radweg ist ein Weg, der als besonders gekennzeichneter und abgegrenzter Teil einer Straße 
        oder mit selb-ständiger Linienführung für den Fahrradverkehr bestimmt ist.
        - 5250: Rad- und Fußweg ist ein Weg, der als besonders gekennzeichneter und abgegrenzter Teil einer Straße 
        oder mit selbständiger Linienführung ausschließlich für den Fahrrad- und Fußgängerverkehr bestimmt ist.
        - 5260: Reitweg ist ein unbefestigter Weg oder Pfad, der für Pferde vorgesehen ist.
        - 5270: Begleitfläche Weg bezeichnet eine unbebaute Fläche, die einem Weg zugeordnet wird.
        - 9999: Sonstiges bedeutet, dass die Funktion des Wegs bekannt, diese aber nicht in der Werteliste 
        aufgeführt ist.
        
    - 42009: AX_Platz
    
        'Platz' ist eine Verkehrsfläche in Ortschaften oder eine ebene, befestigte oder unbefestigte Fläche, die 
        bestimmten Zwecken dient (z. B. für Verkehr, Parkplätze, Märkte, Festveranstaltungen).
        - 5130: Fußgängerzone ist ein dem Fußgängerverkehr vorbehaltener Bereich, in dem ausnahmsweise öffentlicher 
        Personenverkehr, Lieferverkehr oder Fahrradverkehr zulässig sein kann.
        - 5310: Parkplatz bezeichnet eine Fläche, auf der vorwiegend Anlagen und Gebäude zum Abstellen von 
        Fahrzeugen stehen.
        - 5320: Rastplatz ist eine Anlage zum Rasten der Verkehrsteilnehmer mit unmittelbarem Anschluss zur Straße 
        ohne Versorgungseinrichtung, ggf. mit Toiletten.
        - 5330: Raststätte, Autohof' ist eine Anlage an Verkehrsstraßen mit Bauwerken und Einrichtungen zur Versorgung 
        und Erholung von Reisenden. Dazu gehören auch Autohöfe gemäß der Verwaltungsvorschriften zur 
        Straßenverkehrsordnung (VwV-StVO).
        - 5340: Marktplatz ist ein Platz, auf dem Markt abgehalten wird.
        - 5350: Festplatz ist eine Fläche, auf der zeitlich begrenzte Festveranstaltungen stattfinden.
        - 5360: Busbahnhof ist eine Verkehrsanlage, die als zentraler Verknüpfungspunkt verschiedener Buslinien dient.
        
#### Nicht funktionale Anforderungen

### Sonstige Informationen

#### Fachdatenverbindung

Die Fachdatenverbindung ermöglicht, wie in der GeoInfoDok beschrieben, die flexible Integration von und Verknüpfung 
zwischen Fachdatenobjekten und anderen Fach-datenobjekten oder Bestandsdatenobjekten über Referenzen. Diese 
Verknüpfung kann entweder als einseitiger Verweis oder über gegenseitige Verweise erfolgen.
Der Datentyp AA_Fachdatenverbindung läßt im Attribut „art“ die Verwendung von URNs bzw. URLs zu. Das AAA-Modell 
schreibt eine URN vor, um in der Projektsteuerung in AA_Antrag einen Bezug (eine Fachdatenverbindung) zwischen 
einem Eintrag in der externen An-tragsverwaltung (Geschäftsbuch) und dem Antrag in ALKIS (mit Raumbezug) zu generieren. 
Das Ziel der Fachdatenverbindung wird über die URN des Antragsobjekt "urn:adv:fachdatenverbindung:AA_Antrag" 
identifiziert.

````xml
<zeigtAufExternes>     
    <AA_Fachdatenverbindung>           
        <art>urn:adv:fachdatenverbindung:AA_Antrag</art>         
        <fachdatenobjekt>             
            <AA_Fachdatenobjekt>                 
                <uri>urn:adv:oid:DENWXXXX12345678</uri>             
            </AA_Fachdatenobjekt>         
        </fachdatenobjekt>     
    </AA_Fachdatenverbindung> 
</zeigtAufExternes>
````

#### Kreisbögen 
Bei der Festlegung von Grenzen im Grundrissnachweis der ALK über den Geometrietyp „Kreisbogen“ kommt es aufgrund von  

- Ungenauigkeiten in den Messelementen
- sowie Verteilungs- und Rundungsmechanismen von Koordinatenberechnungsprogrammen 

in der Nachbearbeitung einer örtlichen Vermessung zu Fehlersituationen, die eine Abweichung vom Soll-Grenzverlauf 
darstellen. Diese Inkonsistenzen werden als „Flächenüberschneidungen aufgrund von Kreisbögen“ be-zeichnet und sind 
zwingend im Rahmen der Vormigrationsarbeiten von den Katasterbehörden zu bereinigen. Die PG Katastermodernisierung 
NRW empfiehlt Kreisbögen nicht als Geometrieelemente für Flurstücke und Flächen der Tatsächlicher Nutzung in der 
Datenhaltungskom-ponente zu speichern, sondern diese spätestens in der Migration zu linearisieren. Ziel bei der 
Linearisierung der Kreisbögen ist es  - eine annähernd identische Liniendarstellung zu erzeugen, sowie - die 
Änderung der Flächen und die Anzahl neu entstehender Stützpunkte möglichst gering zu halten. Ausführliche 
Ausführungen hierzu finden sich in den „Handlungsempfehlungen / Kreisbögen“ von Herrn Büdenbender, LVermA NRW

#### Namensgebung Straßen
In ALKIS wird zwischen  ‚Name’ (NAM) =  Eigenname von 'Strassenverkehr' und‚Zweitname’ (ZNM) = ein von der 
Lagebezeichnung abweichender Name von 'Strassenverkehrsflaeche' (z.B. "Deutsche Weinstraße") unterschieden. 
Zur Belegung von NAM (Datentyp AX_Lagebezeichnung) wird die Information aus AX_Lagebezeichnung der Lage, die zur 
Aggregation dieser Verkehrsfläche gedient hat, übernommen. ‚Zweitnamen’ von Straßen dürfen nur die von der 
Lagebezeichnung abweichenden Namen und keine Klassifizierungen wie z.B. A45  enthalten. Die Präsentationstexte der 
Eigennamen werden Präsentationsobjekte zur verschlüsselten oder unverschlüsselten Lagebezeichnung der Flurstücke. 
In der ALK enthaltenen „Klassifizierungen mit Nummern“ werden in Präsentationsobjekte Text 
(AP_GPO mit ART = BezKlassifizierungStrasse) zur OA 12001 überführt.

#### Namensgebung Platz
In ALKIS wird zwischen  ‚Name’ (NAM) =  Eigenname von 'Platz' und  ‚Zweitname’ (ZNM) = ist der touristische 
oder volkstümliche Name von 'Platz' ‚Zweitnamen’ von Plätzen dürfen nur die touristischen oder volkstümlichen 
Namen von 'Platz' enthalten. Die Präsentationstexte der Eigennamen werden Präsentationsob-jekte zur verschlüsselten 
oder unverschlüsselten Lagebezeichnung der Flurstücke.  
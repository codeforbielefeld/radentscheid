package de.codefor.bielefeld.radentscheid.unfallserver.adapter.web;

import de.codefor.bielefeld.radentscheid.unfallserver.domain.Participant;

import java.util.Optional;

/**
 * author skonair@gmail.com
 * date 16.08.20
 */
public class AccidentDto {

    private String id;

    private int year;

    private int month;

    private double lat;

    private double lng;

    private int kind;

    private Optional<Participant> otherParty;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public Optional<Participant> getOtherParty() {
        return otherParty;
    }

    public void setOtherParty(Optional<Participant> otherParty) {
        this.otherParty = otherParty;
    }
}

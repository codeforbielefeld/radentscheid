package de.codefor.bielefeld.radentscheid.unfallserver.adapter.json;

import de.codefor.bielefeld.radentscheid.unfallserver.domain.Accident;
import de.codefor.bielefeld.radentscheid.unfallserver.domain.Location;
import de.codefor.bielefeld.radentscheid.unfallserver.domain.MonthYear;
import de.codefor.bielefeld.radentscheid.unfallserver.domain.Participant;

import java.util.Optional;

/**
 * author skonair@gmail.com
 * date 16.08.20
 */
public class AccidentDto {

    private String id;

    private int month;

    private int year;

    private double lat;

    private double lng;

    private int kindOf;

    private int istrad;

    private int istpkw;

    private int istfuss;

    private int istkrad;

    private int istgkfz;

    private int istsonstiges;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public int getKindOf() {
        return kindOf;
    }

    public void setKindOf(int kindOf) {
        this.kindOf = kindOf;
    }

    public int getIstrad() {
        return istrad;
    }

    public void setIstrad(int istrad) {
        this.istrad = istrad;
    }

    public int getIstpkw() {
        return istpkw;
    }

    public void setIstpkw(int istpkw) {
        this.istpkw = istpkw;
    }

    public int getIstfuss() {
        return istfuss;
    }

    public void setIstfuss(int istfuss) {
        this.istfuss = istfuss;
    }

    public int getIstkrad() {
        return istkrad;
    }

    public void setIstkrad(int istkrad) {
        this.istkrad = istkrad;
    }

    public int getIstgkfz() {
        return istgkfz;
    }

    public void setIstgkfz(int istgkfz) {
        this.istgkfz = istgkfz;
    }

    public int getIstsonstiges() {
        return istsonstiges;
    }

    public void setIstsonstiges(int istsonstiges) {
        this.istsonstiges = istsonstiges;
    }



}

package delag.ar;

import android.location.Location;

import java.io.Serializable;

public class Place implements Serializable {

    private double longitude;
    private double latitude;
    private String Name;

    public Place(double latitude, double longitude, String name) {
        this.longitude = longitude;
        this.latitude = latitude;
        Name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "'" + Name + "'" + "at: " + longitude + ", " + latitude;
    }
}

package com.spatialloader.model;

/**
 * Created with IntelliJ IDEA.
 * User: smitchell
 * Date: 9/1/13
 * Time: 7:33 PM
 *
 */
public class GpsLocation {
    private Double latitude;
    private Double longitude;
    private Double intensity;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getIntensity() {
        return intensity;
    }

    public void setIntensity(Double intensity) {
        this.intensity = intensity;
    }
}

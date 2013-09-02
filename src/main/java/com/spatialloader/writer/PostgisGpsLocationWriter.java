package com.spatialloader.writer;

import com.spatialloader.model.GpsLocation;
import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: smitchell
 * Date: 9/2/13
 * Time: 11:40 AM
 *
 */
public class PostgisGpsLocationWriter implements ItemWriter<GpsLocation> {
    public final String insertSql = "insert into GPS_POINTS(LOCATION, INTENSITY) values ( ST_GeomFromText(?, 4326),?)";
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void write(List<? extends GpsLocation> gpsLocations) throws Exception {
        StringBuilder sb;
        for (final GpsLocation location : gpsLocations) {
            sb = new StringBuilder("point(");
            sb.append(location.getLongitude());
            sb.append(' ');
            sb.append(location.getLatitude());
            sb.append(')');
            jdbcTemplate.update(insertSql, sb.toString(), location.getIntensity());
        }
    }
}

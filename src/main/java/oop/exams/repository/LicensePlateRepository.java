package oop.exams.repository;

import oop.exams.exception.BadRegionException;
import oop.exams.model.Region;

import java.util.*;

public class LicensePlateRepository {

    private static final Map<String, Region> regionByState = new HashMap<>();
    private static final EnumMap<Region, Set<String>> licensePlatesByRegion = new EnumMap<>(Region.class);

    static {
        regionByState.put("SON", Region.NORTH);
        regionByState.put("CHH", Region.NORTH);
        regionByState.put("MIC", Region.SOUTH);
        regionByState.put("TAM", Region.NORTH);
        regionByState.put("COA", Region.NORTH);
        regionByState.put("NLE", Region.NORTH);
        regionByState.put("SIN", Region.WEST);
        regionByState.put("NAY", Region.WEST);
        regionByState.put("JAL", Region.WEST);
        regionByState.put("COL", Region.WEST);
        regionByState.put("VER", Region.EAST);
        regionByState.put("TAB", Region.EAST);
        regionByState.put("CAM", Region.EAST);
        regionByState.put("YUC", Region.EAST);
        regionByState.put("ROO", Region.EAST);
        regionByState.put("SLP", Region.CENTER);
        regionByState.put("ZAC", Region.CENTER);
        regionByState.put("GUA", Region.CENTER);
        regionByState.put("QUE", Region.CENTER);
        regionByState.put("AGU", Region.CENTER);
    }

    public Region getRegionByState(String state) {
        if (!regionByState.containsKey(state)) {
            throw new BadRegionException("Estado desconocido");
        }
        return regionByState.get(state);
    }

    public int countByRegion(Region region) {
        return licensePlatesByRegion.get(region).size();
    }

    public void save(Region region, String licensePlate) {
        if (!licensePlatesByRegion.containsKey(region)) {
            licensePlatesByRegion.put(region, new LinkedHashSet<>());
        }

        licensePlatesByRegion.get(region).add(licensePlate);
    }
}

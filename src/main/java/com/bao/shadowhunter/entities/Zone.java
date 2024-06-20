package com.bao.shadowhunter.entities;

import com.bao.shadowhunter.entities.enums.ZoneDescription;
import discord4j.core.object.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class Zone {

    final int id;
    Map<ZoneDescription, List<User>> zones = fillZones();

    private Map<ZoneDescription, List<User>> fillZones() {
        switch(this.id) {
            case 1 -> {
                zones.put(ZoneDescription.ZONE2, new ArrayList<>());
                zones.put(ZoneDescription.ZONE3, new ArrayList<>());
                zones.put(ZoneDescription.ZONE4, new ArrayList<>());
                zones.put(ZoneDescription.ZONE5, new ArrayList<>());
            }
            case 2 -> {
                zones.put(ZoneDescription.ZONE6, new ArrayList<>());
                zones.put(ZoneDescription.ZONE9, new ArrayList<>());
            }
            case 3 -> {
                zones.put(ZoneDescription.ZONE8, new ArrayList<>());
                zones.put(ZoneDescription.ZONE10, new ArrayList<>());
            }
            default -> throw new RuntimeException("Error filling zones");
        }
        return this.zones;
    }

}

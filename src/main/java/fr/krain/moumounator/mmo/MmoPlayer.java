package fr.krain.moumounator.mmo;

import java.util.UUID;

public class MmoPlayer {
    private final UUID uuid;
    private String name;

    public MmoPlayer(UUID uuid) {
        this.uuid = uuid;
    }
}

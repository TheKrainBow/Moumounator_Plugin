package fr.krain.moumounator.mmo;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.util.Vector;

public class MmoParticle {
    private Location position;
    private Vector dir;
    private final int size;
    private final int range;
    private final Particle particle;
    private final int particle_count;
    private final double particle_offsetX;
    private final double particle_offsetY;
    private final double particle_offsetZ;
    private final double particle_extra;

    public MmoParticle(Location position, Vector dir, int size, int range, Particle particle, int particle_count, double particle_offsetX, double particle_offsetY, double particle_offsetZ, double particle_extra) {
        this.position = position;
        this.dir = dir;
        this.size = size;
        this.range = range;
        this.particle = particle;
        this.particle_count = particle_count;
        this.particle_offsetX = particle_offsetX;
        this.particle_offsetY = particle_offsetY;
        this.particle_offsetZ = particle_offsetZ;
        this.particle_extra = particle_extra;
    }
}

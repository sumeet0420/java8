package com.learning.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class EnergySource {
    private final long MAXLEVEL = 100;
    private long level = MAXLEVEL;

    private static ScheduledExecutorService timer = Executors.newScheduledThreadPool(10);

    public EnergySource() {

    }

    public static EnergySource create() {
        EnergySource energySource = new EnergySource();
        energySource.init();
        return  energySource;
    }

    private void init() {
        timer.scheduleAtFixedRate(this::replish, 0, 1, TimeUnit.SECONDS);
    }

    public static void stopAllEnergyLevels() {
        timer.shutdown();
    }

    public boolean useEnery(int units) {
        if (units > 0 && level >= units) {
            level -= units;
            return true;
        }
        return false;
    }

    private void replish() {
        if (level < MAXLEVEL)
            level++;
    }

    public long getAvailableUnits() {
        return level;
    }
}

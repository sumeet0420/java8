package com.learning.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UseEnergySource {

    public static void main(String[] args) throws InterruptedException {
        final EnergySource energySource = EnergySource.create();
        ExecutorService executors = Executors.newFixedThreadPool(10);
        for (int i=0;i<50;i++){
            executors.execute(()->energySource.useEnery(1));
            executors.shutdown();
        }
        Thread.sleep(5000);
        System.out.println("Available: "+energySource.getAvailableUnits());
        EnergySource.stopAllEnergyLevels();
    }
}

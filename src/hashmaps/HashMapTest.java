package hashmaps;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<Pixel, String> pixels = new HashMap<>();
        for (int i = 0; i < 1024; i++) {
            for (int j = 0; j < 786; j++) {
                var pixel = new Pixel(i,j);
                pixels.put(pixel, i+"-"+j);
            }
        }
        System.out.println("*".repeat(50));
        Instant now = Instant.now();
        try {
            pixels.get(new Pixel(10, 100));
            pixels.get(new Pixel(1000, 100));
            pixels.get(new Pixel(1000, 100));
        } finally {
            Duration duration = Duration.between(now, Instant.now());
            System.out.printf("Time taken is %dns%n", duration.getNano());
            System.out.printf("Time taken is %ds%n", duration.getSeconds());
        }
    }
}

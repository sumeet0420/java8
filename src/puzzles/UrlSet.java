package puzzles;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class UrlSet {

    private static final String[] URL_NAMES = {"1","2","3","4","5","6"};

    public static void main(String[] args) throws MalformedURLException {
        Set<URL> urls = new HashSet<>();
        for(var url:URL_NAMES) urls.add(new URL(url));
        System.out.println(urls.size());
    }
}

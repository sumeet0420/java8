package java13;

public class TextBlocks {

    public static void main(String[] args) {
        String longText = """
                Hello, There!!
                Java, After years and Years of Request, has finally listened to our requests..
                Well, this seems interesting....
                Oh! I forgot, you can also add "" without escape...
                """;
        System.out.println(longText);
    }
}

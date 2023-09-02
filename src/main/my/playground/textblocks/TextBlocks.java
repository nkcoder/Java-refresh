package my.playground.textblocks;

public class TextBlocks {
    public static void main(String[] args) {
        String html = """
                <html>
                    <body>
                        <p>Hello, world</p>
                    </body>
                </html>
                 """;
        System.out.println(html);

        String query = """
                SELECT "EMP_ID", "LAST_NAME" FROM "EMPLOYEE_TB"
                WHERE "CITY" = 'INDIANAPOLIS'
                ORDER B""";
        System.out.println(query);
    }
}

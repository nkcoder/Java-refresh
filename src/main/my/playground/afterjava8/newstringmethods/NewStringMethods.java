package my.playground.afterjava8.newstringmethods;

public class NewStringMethods {
    public static void main(String[] args) {
        // formatted(): equivalent to String.format()
        String formatted = "1. %s 2. %s 3. %s ".formatted("one", "two", "three");
        System.out.println(formatted);

        // stripIndent(): remove incidental white spaces from the beginning and end of every line
        String stripIndent = " Good day!   ".stripIndent();
        String html = """
                <html>
                    <body>
                        <p>Hello, world</p>
                    </body>
                </html>
                 """.stripIndent();
        System.out.println(stripIndent);
        System.out.println(html);

        String str = "This is tab \t, Next New Line \n,next backspace \b,next Single Quotes \' next,Double Quotes \" ";
        System.out.println(str.translateEscapes());

        // indent(n): insert n spaces before each line after `lines()`
        String multilineStr = "This is\na multiline\nstring.";
        System.out.println(multilineStr.indent(5));

        // transform: apply a single argument function to the string
        String concat = "hello".transform(p -> p + " world");
        Integer parsedInt = "45".transform(Integer::parseInt);
        System.out.println(concat);
        System.out.println(parsedInt);
    }
}

package my.playground.advanced.stringops;

import java.util.Arrays;

public class StringTest {

  public static void main(String[] args) {
    String question = "What's the date today? ";
    String answer = "Friday";

    char c = question.charAt(5);
    int length = question.length();
    String concat = question.concat(answer);
    int indexOf = question.indexOf("t");
    int indexOf2 = question.lastIndexOf("t");
    int indexOf3 = question.indexOf("t", 9);
    System.out.printf(
        "c = %c, length = %d, concat = %s, indexOf = %d, indexOf2 = %d, indexOf3 = %d\n", c, length,
        concat, indexOf, indexOf2, indexOf3);

    String subString = question.substring(5, 11);
    boolean contains = question.contains("tomorrow?");
    String upperCase = question.toUpperCase();
    String splitAndJoins = String.join(" | ", question.split(" "));
    String replaced = question.replace("today", "tomorrow");
    boolean startsWith = question.startsWith("What");
    String stripped = question.strip();

    System.out.printf(
        "subString = %s, contains = %b, uppercase = %s, splitAndJoins = %s, replaced = %s, startsWith = %b, stripped = %s\n",
        subString, contains, upperCase, splitAndJoins, replaced, startsWith, stripped);


  }
}

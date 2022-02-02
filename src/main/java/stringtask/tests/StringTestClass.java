package stringtask.tests;

public class StringTestClass {

    private String string = "ackf1he4nw2asd3n5b";

    private void test1() {
        string = string.codePoints()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.println(string);
    }

    public static void main(String[] args) {
        StringTestClass stringTestClass = new StringTestClass();
        stringTestClass.test1();
    }
}

package ru.job4j.inheritance;

public class HtmlReport extends Techport {

    @Override
    public String generate(String name, String body) {
        return "<h1>" + name +  "</h1>"
                + "<br1>"
                + "<span>" + body + "</span>";
    }
}

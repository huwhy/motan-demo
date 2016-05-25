package com.nachepin;

import java.io.IOException;
import java.util.ListIterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsonpTest {

    public static void main(String[] args) throws IOException {
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
        Elements e = doc.body().getElementsByTag("p");
        System.out.println(e.html());
        Document oo = Jsoup.connect("http://www.nachepin.com").get();
        ListIterator<Element> it = oo.getAllElements().listIterator();
        while (it.hasNext()) {
            System.out.println(it.next().nodeName());
        }
    }
}

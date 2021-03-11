package com.company;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawl {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://dantri.com.vn/the-thao/bong-da-trong-nuoc.htm");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\R", "");
            Pattern p = Pattern.compile("Cate_BongDaTrongNuoc|MenuCate|2\"(.*?)</a>");

            Matcher m = p.matcher(content);
            while (m.find()) {
                System.out.println(m.group(1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

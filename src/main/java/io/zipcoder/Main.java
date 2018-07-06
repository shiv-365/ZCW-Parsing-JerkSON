package io.zipcoder;

import org.apache.commons.io.IOUtils;

import java.util.*;


public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        int countErr = 0;
        ItemParser parser = new ItemParser();
        FormatString f = new FormatString();
        String output = (new Main()).readRawDataToString();
        //String fixed = parser.spellCheck(output);
        ArrayList<String> list = parser.parseRawDataIntoStringArray(output);
        ArrayList<Item> items = new ArrayList<>();

            for (int i = 0; i <list.size(); i++) {
                try {
                    items.add(parser.parseStringIntoItem(list.get(i)));
                } catch (Exception e) {
                    countErr++;
                }
            }

        f.format(f.itemMap(items),countErr);

        // TODO: parse the data in output into items, and display to console.
    }
}

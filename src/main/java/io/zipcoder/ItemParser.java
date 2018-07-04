package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {



    public ArrayList<String> parseRawDataIntoStringArray(String rawData){
        String stringPattern = "##";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern , rawData);
        return response;
    }

    public Item parseStringIntoItem(String rawItem) throws ItemParseException{
        Item item;
        rawItem = splitStringWithRegexPattern("##",rawItem).get(0);
        String toRemove = "^[a-zA-Z0-9]+:";
        String[] arrayOfRaw = rawItem.split("[;|^@%*!]");

        try{
            String name = arrayOfRaw[0];
            Double price = Double.parseDouble(arrayOfRaw[1]);
            String type = arrayOfRaw[2];
            String expiration = arrayOfRaw[3];
            throw new ItemParseException("");
        }
        catch (ItemParseException e){
             e.getMessage();
        }


        Pattern p = Pattern.compile(toRemove);
        Matcher m = p.matcher(rawItem);


        return null;
    }

    public ArrayList<String> findKeyValuePairsInRawItemData(String rawItem){
        String stringPattern = "[;|^@%*!]";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern , rawItem);
        return response;
    }

    private ArrayList<String> splitStringWithRegexPattern(String stringPattern, String inputString){
        return new ArrayList<String>(Arrays.asList(inputString.split(stringPattern)));
    }

    private String cookies(String str){
        return str.equals("co0kies") ? "cookies" : str;
    }

    private String lowerCase(String str){
        String lower = "";
        for (int i = 0; i <str.length() ; i++) {
            int c = (int)str.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                c = c + 32;
            }
            lower += (char) c;
        }
        return lower;
    }




}

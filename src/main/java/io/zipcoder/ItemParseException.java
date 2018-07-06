package io.zipcoder;

public class ItemParseException extends Exception {

    private static int count =0;

    public ItemParseException(String message){
        super(message);

            count++;
    }
    public static int getCount(){
        return count;
    }


    public String getMessage(){
        return
                super.getMessage() + "Errors             seen: " + getCount() + " times";
    }

}

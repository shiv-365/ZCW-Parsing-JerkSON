package io.zipcoder;

public class ItemParseException extends Exception {

    private static int count =0;
    private static final Object countLock = new Object();

    public ItemParseException(String message){
        super(message);
        synchronized (countLock){
            count++;
        }


    }
    public static int getCount(){
        return count;
    }


    public String getMessage(){
        return
                super.getMessage() + "Errors             seen: " + getCount() + " times";
    }

}

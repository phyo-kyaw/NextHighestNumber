package com.company;

public class NextHighestNumber {

    public Integer getNextHighestNumber(Integer number){
        return 0;
    }

    public Boolean isStringInInteger(String value){
        try{
            int number = Integer.parseInt(value);
        }
        catch(NumberFormatException ex){
            return false;
        }
        return true;
    }
}

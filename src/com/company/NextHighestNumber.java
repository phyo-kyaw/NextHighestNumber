package com.company;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Collections;

public class NextHighestNumber {

    public Integer getNextHighestNumber(String valueIn){

        StringBuffer valueBuffer = new StringBuffer();
        StringBuffer valueBufferProcessed = new StringBuffer();
        StringBuffer valueBufferStart = new StringBuffer();

        String value = "";
        String current = "";
        String left = "";
        String right = "";
        String valueToProcess = "";
        Boolean isNextSkipped = false;
        Boolean isChanged = false;
        Boolean isNegativeValue = false;

        if(Integer.parseInt(valueIn) < 0 ){
            value = valueIn.substring(1);
            isNegativeValue = true;
            valueBufferStart.append(value);
        }
        else{
            valueBufferStart.append(valueIn);
            value = valueIn;
        }


        for (int i = value.length()-1; i > 0; i--) {
            //System.out.println(i);

            current = String.valueOf(value.charAt(i));

            left = String.valueOf(value.charAt(i - 1));

            valueBufferStart.setLength(valueBufferStart.length() - 1);
            //System.out.println(valueBufferStart);

            //valueBufferStart.


            if ( ( isCurrentDigitValueGreaterThanLeftDigitValue(Integer.parseInt(current),
                    Integer.parseInt(left)) && !isNegativeValue )
            || ( Integer.parseInt(current) < Integer.parseInt(left) && isNegativeValue) ) {
                valueBuffer.insert(0, current);
                valueBuffer.insert(0, left);
                valueToProcess = left;
                valueBufferStart.setLength(valueBufferStart.length() - 1);
                isChanged = true;
                break;
                //isNextSkipped = true;
            } else {
                valueBuffer.insert(0, current);
            }


        }
        if(isChanged){
            if(!isNegativeValue){
                valueBufferProcessed = new StringBuffer(sortValueAscending(valueBuffer.toString()));
                int indexValueToMoveForward = valueBufferProcessed.lastIndexOf(valueToProcess) + 1;
                char valueToMoveForward = valueBufferProcessed.charAt(indexValueToMoveForward);
                valueBufferProcessed.delete(indexValueToMoveForward, indexValueToMoveForward +1);

                valueBufferStart.append(String.valueOf(valueToMoveForward))
                        .append(valueBufferProcessed);
            }
            else{
                valueBufferProcessed = new StringBuffer(sortValueDescending(valueBuffer.toString()));
                int indexValueToMoveForward = valueBufferProcessed.lastIndexOf(valueToProcess) + 1;
                char valueToMoveForward = valueBufferProcessed.charAt(indexValueToMoveForward);
                valueBufferProcessed.delete(indexValueToMoveForward, indexValueToMoveForward +1);

                valueBufferStart.append(String.valueOf(valueToMoveForward))
                        .append(valueBufferProcessed).insert(0,"-");
            }
        }
        else{
            System.out.println("It's the HIGHEST number");
            return Integer.parseInt(valueIn);
        }


        return Integer.parseInt(valueBufferStart.toString());

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

    public Boolean isLengthGreaterThan1(String value){
        return value.length() > 1;
    }

    public Boolean isCurrentDigitValueGreaterThanLeftDigitValue(int currentDigit, int leftDigit){
        return currentDigit > leftDigit;
    }

    public String sortValueAscending(String value){
        return value.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public String sortValueDescending(String value){
        return value.chars()
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                //.reverse()
                .toString();
    }

}

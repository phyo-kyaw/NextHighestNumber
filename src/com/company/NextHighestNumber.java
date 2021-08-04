package com.company;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class NextHighestNumber {

    public Integer getNextHighestNumber(String value){

        //not required
//        if(!isLengthGreaterThan1(value)){
//            return Integer.parseInt(value);
//        }

        CharacterIterator valueIterator = new StringCharacterIterator(value);
        StringBuffer valueBuffer = new StringBuffer();
        StringBuffer valueBufferProcessed = new StringBuffer();
        StringBuffer valueBufferStart = new StringBuffer();
        valueBufferStart.append(value);
        String current = "";
        String left = "";
        String right = "";
        String valueToProcess = "";
        Boolean isNextSkipped = false;
        Boolean isChanged = false;

        for (int i = value.length()-1; i > 0; i--) {
            //System.out.println(i);


            current = String.valueOf(value.charAt(i));

            left = String.valueOf(value.charAt(i - 1));

            valueBufferStart.setLength(valueBufferStart.length() - 1);
            System.out.println(valueBufferStart);

            //valueBufferStart.


            if (isCurrentDigitValueGreaterThanLeftDigitValue(Integer.parseInt(current),
                    Integer.parseInt(left))) {
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
        valueBufferProcessed = new StringBuffer(sortValueAscending(valueBuffer.toString()));
        int indexValueToMoveForward = valueBufferProcessed.lastIndexOf(valueToProcess) + 1;
        char valueToMoveForward = valueBufferProcessed.charAt(indexValueToMoveForward);
        valueBufferProcessed.delete(indexValueToMoveForward, indexValueToMoveForward +1);

        valueBufferStart.append(String.valueOf(valueToMoveForward))
                .append(valueBufferProcessed);

        //valueBuffer.


            //if changes happen copy the rest of the digit
//            if(isChanged){
//                //valueBuffer.insert(0,current);
//                valueBuffer.insert(0,value.substring(1,i+1));
//                isChanged = false;
//                break;
//            }
//            else{
//                //swap happened
//                if(isNextSkipped){
//                    right = String.valueOf(value.charAt(i+1));
//                    valueBuffer.insert(0,right);
//                    isNextSkipped = false;
//                    isChanged = true;
//                }
//                else{
//                    //swapping starts at current index
//                    if(isCurrentDigitValueGreaterThanLeftDigitValue( Integer.parseInt(current) ,
//                            Integer.parseInt(left)) ) {
//                        valueBuffer.insert(0,left);
//                        isNextSkipped = true;
//                    }
//                    else{
//                        valueBuffer.insert(0,current);
//                    }
//
//                }
//            }
//
//        }
//
//        //add the first digit
//        if ( isChanged  || isNextSkipped ){
//            valueBuffer.insert(0,String.valueOf(value.charAt(1)));
//        }
//        else{
//            valueBuffer.insert(0,String.valueOf(value.charAt(0)));
//        }


        if(!isChanged)
            System.out.println("It's the HIGHEST number");
        //isNextSkipped = false;
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


}

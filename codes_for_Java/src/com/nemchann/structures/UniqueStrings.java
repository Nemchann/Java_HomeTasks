package com.nemchann.structures;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UniqueStrings {
    String[] strings;
    int size;

    public UniqueStrings(){
        this.size = 0;
        this.strings = new String[size];
    }

    public UniqueStrings(String[] strings){
        this.size = strings.length;
        //this.strings = strings;
        this.strings = new String[size];
        for (int i = 0; i < size; i++){
            this.strings[i] = strings[i];
        }
    }

    public String addString(String string){
        if (this.compareStrings(string)){
            throw new NotUniqueStringException("Attempt to add not unique string");
        }
        strings = Arrays.copyOf(strings, strings.length + 1);
        size++;
        strings[strings.length - 1] = string;
        return "String " + string + " was added to list";
    }

    public String deleteString(String string){
        if (!this.compareStrings(string)){
            throw new NotFoundStringInArrayException("Attempt to delete not existing string");
        }
        int index = 0;
        for (int i = 0; i < strings.length; i++){
            if(string.equals(strings[i])) index = i;
        }
        for (int i = index; i < strings.length - 1; i++){
            strings[i] = strings[i + 1];
        }
        strings = Arrays.copyOf(strings, strings.length - 1);
        size--;
        return "String " + string + " was deleted from list";
    }

    public String addStrings(String...strs){
        String result = "";

        for (String string : strs){
            if(!this.compareStrings(string)){
                result += string + " ";
                strings = Arrays.copyOf(strings, strings.length + 1);
                strings[size] = string;
                size++;
            }
        }
        return result + " were added to list";
    }

    public String deleteStrings(String...strs){
        String result = "";

        for (String string : strs){
            if(this.compareStrings(string)){
                result += string + " ";
                int index = this.findIndex(string);
                for (int i = index; i < size - 1; i++){
                    strings[i] = strings[i + 1];
                }
                strings = Arrays.copyOf(strings, strings.length - 1);
                size--;
            }
        }
        return result + " were deleted from list";
    }
    private int findIndex(String str){
        int index = 0;
        for (int i = 0; i < size; i++){
            if(str.equals(strings[i])){
                index = i;
            }
        }
        return index;
    }

    private boolean compareStrings(String newString){
        for (String string : this.strings){
            if (newString.equals(string)) return true;
        }
        return false;
    }

    public String becomeString(){
        StringBuilder res =  new StringBuilder("[");
        for (int i = 0; i < strings.length - 1; i++){
            res.append(strings[i]);
            res.append(", ");
        }
        res.append(strings.length - 1);
        res.append("]");
        return res.toString();
    }

    public int getSize() {
        return size;
    }
    public boolean isExist(String string){
        return this.compareStrings(string);
    }

    @Override
    public String
    toString() {
        return  Arrays.toString(strings);
    }
}

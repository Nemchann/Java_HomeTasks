package com.nemchann.exam;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MyService implements MyServiceInterface{

    @Transaction
    public void removeTenthIndex(List<Integer> integers){
        try{
            integers.remove(10);
        }
        catch (IndexOutOfBoundsException e){
            throw new RuntimeException("не получилось");
        }

    }

    @Transaction
    public void removeHelloString(Map<String, Integer> map){
        map.remove("Hello");
    }

}

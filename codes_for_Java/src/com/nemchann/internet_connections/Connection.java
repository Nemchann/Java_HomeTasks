package com.nemchann.internet_connections;
import java.util.Random;
import java.util.Random.*;
import java.util.Scanner;

public class Connection {
    String address;
    Status status;
    private final Random random;

    public Connection(String address){
        this.address = address;
        this.status = Status.OPENED;
        this.random = new Random();
    }

    public void closeConnection(){
        status = Status.CLOSED;
    }

    public void openConnection(){
        status = Status.OPENED;
    }

    public String nextString(){
        String result = "";
        boolean shouldThrowException = random.nextBoolean();
        if (status == Status.CLOSED){
            throw new IsClosedException();
        }
        if (shouldThrowException){
            try {
                throw new LostCommunicationException("Потеря связи");
            } catch (LostCommunicationException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            result = "test connecting";
        }
        return result;
    }

//    @Override
//    public String toString() {
//        String result = "";
//        boolean shouldThrowException = random.nextBoolean();
//        if (status == Status.CLOSED){
//            throw new IsClosedException();
//        }
//        if (!shouldThrowException){
//            try {
//                throw new LostCommunicationException("Потеря связи");
//            } catch (LostCommunicationException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        else{
//            result = "test connecting";
//        }
//        return result;
//    }
}

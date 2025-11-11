package com.nemchann.internet_connections;

public class LostCommunicationException extends Exception{
    public LostCommunicationException(){
        super();
    }

    public LostCommunicationException(String message){
        super(message);
    }

    public LostCommunicationException(Throwable cause){
        super(cause);
    }

    public LostCommunicationException(String message, Throwable cause){
        super(message, cause);
    }
}

package com.nemchann.internet_connections;

public class TestConnect {
    public static void readData(){
        Connection connection = new Connection("ermakov.edu");

            try{
                for (int i = 0; i < 10; i++){
                    System.out.println(connection);
                }
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            finally {
                System.out.println("is closed");
                connection.status = Status.CLOSED;
            }

    }
}

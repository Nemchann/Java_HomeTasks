class House {
    int n;
    public String toString(){
        String ending;
        if (n == 0) return "В доме только подвал";
        if (n < 0) return "Это бункер";
        if (n % 10 == 1 && n % 100 != 11 && n != 11){
            ending = " этажом";
        }
        else{
            ending = " этажами";
        }
//        if (n % 10 >= 2 && n % 10 <= 4){
//
//        }
        return "Дом с " + n + ending;
    }
}


public class Main {
    public static void main(String[] args) {
        House house1 = new House();
        house1.n = 1;
        System.out.println(house1);

        House house2 = new House();
        house2.n = 5;
        System.out.println(house2);

        House house3 = new House();
        house3.n = 23;
        System.out.println(house3);
    }
}
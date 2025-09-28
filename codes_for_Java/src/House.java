class House {
    final int n;

    public House(int n){
        this.n = n;
    }

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

        return "Дом с " + n + ending;
    }
}
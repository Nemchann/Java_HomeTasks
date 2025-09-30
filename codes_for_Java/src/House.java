class House {
    final int n;

    public House(int n){
        if (n <= 0){
            throw new IllegalArgumentException("n must be positive");
        }
        this.n = n;
    }

    public String toString(){
        String ending;
        if (n % 10 == 1 && n % 100 != 11 && n != 11){
            ending = " этажом";
        }
        else{
            ending = " этажами";
        }

        return "Дом с " + n + ending;
    }
}
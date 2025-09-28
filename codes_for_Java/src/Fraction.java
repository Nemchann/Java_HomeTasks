public class Fraction {
    int numerator;
    int denominator;

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {

    }

    private int greatestCommonDivisor(int a, int b){
        if (b == 0){
            return a;
        }
        return greatestCommonDivisor(b, a % b);
    }
    private int leastCommonMultiple(int a, int b){
        return a / greatestCommonDivisor(a, b) * b;
    }

    public void getFraction() {
        System.out.println(numerator + "/" + denominator);
    }

//    public int sum(int n){
//        Fraction resultFraction = new Fraction();
//    }

    public int sum(Fraction fraction){

    }
}

public class Fraction {
    int numerator;
    int denominator;

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
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

//    Сумма
    public Fraction sum(Fraction fraction){
        int commonMultiply = leastCommonMultiple(fraction.denominator, denominator);
        int divisor1 = commonMultiply / denominator;
        int divisor2 = commonMultiply /fraction.denominator;
        int sumNumerators = divisor1 * numerator + divisor2 * fraction.numerator;
        int divisor = greatestCommonDivisor(sumNumerators, commonMultiply);
        sumNumerators /= divisor;
        commonMultiply /= divisor;
        Fraction resultFraction = new Fraction(sumNumerators, commonMultiply);
        return resultFraction;
    }

    public Fraction sum(int n){
        int newNumerator = n * denominator;
        int newDenominator = denominator;
        Fraction resultFraction = new Fraction(newNumerator, newDenominator);
        return sum(resultFraction);
    }

//    Разность
    public Fraction minus(Fraction fraction){
        int commonMultiply = leastCommonMultiple(fraction.denominator, denominator);
        int divisor1 = commonMultiply / denominator;
        int divisor2 = commonMultiply /fraction.denominator;
        int sumNumerators = divisor1 * numerator - divisor2 * fraction.numerator;
        Fraction resultFraction = new Fraction(sumNumerators, commonMultiply);
        return resultFraction;
    }

    public Fraction minus(int n){
        int newNumerator = n * denominator;
        int newDenominator = denominator;
        Fraction resultFraction = new Fraction(newNumerator, newDenominator);
        return minus(resultFraction);
    }

//    Умножение
    public Fraction mul(Fraction fraction){
        int newNumerator = numerator * fraction.numerator;
        int newDenominator = denominator * fraction.denominator;
        int divisor = greatestCommonDivisor(newNumerator, newDenominator);
        newNumerator /= divisor;
        newDenominator /= divisor;
        Fraction resultFraction = new Fraction(newNumerator, newDenominator);
        return resultFraction;
    }

    public Fraction mul(int n){
        int newNumerator = n * numerator;
        int divisor = greatestCommonDivisor(newNumerator, denominator);
        newNumerator /= divisor;
        denominator /= divisor;
        Fraction resultFraction = new Fraction(newNumerator, denominator);
        return resultFraction;
    }

//    Деление
    public Fraction div(Fraction fraction){
        int newNumerator = numerator * fraction.denominator;
        int newDenominator = denominator * fraction.numerator;
        int divisor = greatestCommonDivisor(newNumerator, newDenominator);
        newNumerator /= divisor;
        newDenominator /= divisor;
        Fraction resultFraction = new Fraction(newNumerator, newDenominator);
        return resultFraction;
    }

    public Fraction div(int n){
        int newDenominator = denominator * n;
        int divisor = greatestCommonDivisor(numerator, newDenominator);
        numerator /= divisor;
        newDenominator /= divisor;
        Fraction resultFraction = new Fraction(numerator, newDenominator);
        return resultFraction;
    }


    public String toString(){
        return (numerator + "/" + denominator);
    }
}

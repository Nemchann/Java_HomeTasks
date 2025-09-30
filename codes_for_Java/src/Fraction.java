public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator){
        if (denominator <= 0){
            throw new IllegalArgumentException("denominator must be positive");
        }
        int divisor = greatestCommonDivisor(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / divisor;
        this.denominator = denominator / divisor;
            }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
//    Наибольший общий делитель (НОД)
    private int greatestCommonDivisor(int a, int b){
        if (b == 0){
            return a;
        }
        return greatestCommonDivisor(b, a % b);
    }

//    Наименьшее общее кратное (НОК)
    private int leastCommonMultiple(int a, int b){
        return a / greatestCommonDivisor(a, b) * b;
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
        if (commonMultiply <= 0){
            commonMultiply = -commonMultiply;
            sumNumerators = -sumNumerators;
        }
        Fraction resultFraction = new Fraction(sumNumerators, commonMultiply);
        return resultFraction;
    }

    public Fraction sum(int n){
        return sum(new Fraction(n, 1));
    }

//    Разность
    public Fraction minus(Fraction fraction){
        int commonMultiply = leastCommonMultiple(fraction.denominator, denominator);
        int divisor1 = commonMultiply / denominator;
        int divisor2 = commonMultiply / fraction.denominator;
        int sumNumerators = divisor1 * numerator - divisor2 * fraction.numerator;
        int divisor = greatestCommonDivisor(sumNumerators, commonMultiply);
        sumNumerators /= divisor;
        commonMultiply /= divisor;
        if (commonMultiply <= 0){
            commonMultiply = -commonMultiply;
            sumNumerators = -sumNumerators;
        }
        Fraction resultFraction = new Fraction(sumNumerators, commonMultiply);
        return resultFraction;
    }

    public Fraction minus(int n){
        return minus(new Fraction(n, 1));
    }

//    Умножение
    public Fraction mul(Fraction fraction){
        int newNumerator = numerator * fraction.numerator;
        int newDenominator = denominator * fraction.denominator;
        int divisor = greatestCommonDivisor(newNumerator, newDenominator);
        newNumerator /= divisor;
        newDenominator /= divisor;

        if (newDenominator <= 0){
            newDenominator = -newDenominator;
            newNumerator = -newNumerator;
        }
        Fraction resultFraction = new Fraction(newNumerator, newDenominator);
        return resultFraction;
    }

    public Fraction mul(int n){
        return mul(new Fraction(n, 1));
    }

//    Деление
    public Fraction div(Fraction fraction){
        int newNumerator = numerator * fraction.denominator;
        int newDenominator = denominator * fraction.numerator;
        int divisor = greatestCommonDivisor(newNumerator, newDenominator);
        newNumerator /= divisor;
        newDenominator /= divisor;

        if (newDenominator <= 0){
            newDenominator = -newDenominator;
            newNumerator = -newNumerator;
        }
        Fraction resultFraction = new Fraction(newNumerator, newDenominator);
        return resultFraction;
    }

    public Fraction div(int n){
        return div(new Fraction(n, 1));
    }


    public String toString(){
        return (numerator + "/" + denominator);
    }
}

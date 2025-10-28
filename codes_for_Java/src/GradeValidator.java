@FunctionalInterface
public interface GradeValidator {
    boolean isValid(int grade);

    // Дефолтная реализация - все оценки допустимы
    static GradeValidator any() {
        return grade -> true;
    }
}
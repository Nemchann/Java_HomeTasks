public class CatUtils {
    public static void makeAllMeow(Meowable...meowables){
        System.out.println("Будет много 'мяу!': ");
        for (Meowable meowable : meowables){
            meowable.meow();
        }
        System.out.println("Конец!");
    }
}

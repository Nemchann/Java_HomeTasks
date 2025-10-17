public class BirdsMarket {
    public static String singingSongs(Singable...values){
        String result = "Птицы на рынке поют:\n";
        for (Singable value : values){
            result += value.songs() + "\n";
        }
        return result;
    }
}

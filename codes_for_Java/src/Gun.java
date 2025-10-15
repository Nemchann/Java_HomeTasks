public class Gun extends Weapon{
    static final int DEFAULT_PATRONS = 5;
    private final int patronsValue;


    public Gun(int patrons, int patronsValue){
        super(patrons);
        this.patronsValue = patronsValue;
    }
    public Gun(int patronsValue){
        super(DEFAULT_PATRONS);
        this.patronsValue = patronsValue;

    }

    public void fire(){
        if (patrons > 0){
            System.out.println("Бах!");
            patrons--;
        }
        else{
            System.out.println("Клац!");
        }
    }

    @Override
    public int load(int extraPatrons){
        if (extraPatrons < 0){
            throw new IllegalArgumentException("extraPatrons must be positive");
        }

        int availableSpace = patronsValue - patrons;
        int actuallyLoaded = Math.min(extraPatrons, availableSpace);
        patrons += actuallyLoaded;

        return extraPatrons - actuallyLoaded; // Возвращаем остаток
    }

    public int reloading(int extraPatrons){
        return load(extraPatrons);
    }

    public int unloading(){
        int userPatrons = patrons;
        patrons = 0;
        return userPatrons;

    }


    public int getPatronsValue() {
        return patronsValue;
    }


    public boolean isUploaded(){
        return patrons != 0;
    }
}

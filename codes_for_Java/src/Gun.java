public class Gun {
    int patrons;
    static final int DEFAULT_PATRONS = 5;
    private final int patronsValue;

    public Gun(int patrons, int patronsValue){
        this.patronsValue = patronsValue;
        this.patrons = patrons;
    }
    public Gun(int patronsValue){
        this.patronsValue = patronsValue;
        this.patrons = DEFAULT_PATRONS;
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

    public void reloading(int extraPatrons){
        if (extraPatrons < 0){
            throw new IllegalArgumentException("extraPatrons must be positive");
        }
        if (extraPatrons > patronsValue - patrons){
            patrons = patronsValue;
            extraPatrons -= patronsValue - patrons;
        }
        else{
            patrons += extraPatrons;
        }
    }

    public int unloading(){
        int userPatrons = patrons;
        patrons = 0;
        return userPatrons;

    }

    public int getPatrons() {
        return patrons;
    }

    public boolean isUploaded(){
        return patrons != 0;
    }
}

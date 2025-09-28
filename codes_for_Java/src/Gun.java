public class Gun {
    int patrons;
    static final int DEFAULT_PATRONS = 5;

    public Gun(int patrons){
        this.patrons = patrons;
    }
    public Gun(){
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

}

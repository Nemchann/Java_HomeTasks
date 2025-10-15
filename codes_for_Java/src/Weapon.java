abstract class Weapon {
    protected int patrons;

    public Weapon(int patrons){
        if (patrons < 0){
            throw new IllegalArgumentException("patrons must be positive");
        }
        this.patrons = patrons;
    }

    abstract void fire();

    public int patrons() {
        return patrons;
    }

    public boolean getPatrons(){
        if(patrons == 0) return false;
        patrons--;
        return true;
    }

    public int load(int patrons){
        if (patrons < 0){
            throw new IllegalArgumentException("patrons must be positive");

        }
        this.patrons += patrons;
        return 0;
    }
}

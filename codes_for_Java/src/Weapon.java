abstract class Weapon {
    private int patrons;

    public Weapon(int patrons){
        if (patrons < 0){
            throw new IllegalArgumentException("patrons must be positive");
        }
        this.patrons = patrons;
    }

    abstract void fire();

    public int ammo() {
        return patrons;
    }

    public boolean getPatrons(){
        if(patrons == 0) return false;
        patrons--;
        return false;
    }

    public int load(int patrons){
        if (patrons < 0){
            throw new IllegalArgumentException("patrons must bo positive");

        }
        int tmp = patrons;
        this.patrons = patrons;
        return tmp;
    }
}

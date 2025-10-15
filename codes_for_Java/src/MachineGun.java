public class MachineGun extends Gun{
    private final int speed;

    public MachineGun(){
        super(30);
        this.speed = 30;
    }

    public MachineGun(int patronsValue){
        super(patronsValue);

        if (patronsValue <= 0){
            throw new IllegalArgumentException("patronsValue must be positive");
        }
        this.speed = Math.max(1, patronsValue / 2);
    }

    public MachineGun(int patronsValue, int speed){
        super(patronsValue);
        if (patronsValue <= 0){
            throw new IllegalArgumentException("patronsValue must be positive");
        }
        if (speed <= 0){
            throw new IllegalArgumentException("Speed must be positive");
        }

        this.speed = speed;
    }

    @Override
    public void fire(){
        fire(1);
    }

    public void fire(int n){
        String result = "";
        for (int i = 0; i < speed * n; i++){
            if (patrons > 0){
                result += (i + 1) + ". Бах! ";
                result += "\n";
                patrons--;
            }
            else{
                result += (i + 1) + ". Клац! ";
                result += "\n";
            }
        }
        System.out.println(result);
    }
}

public class Truck {
    int truck_id;
    public int[] print_truck_products(){
        Box box = new Box();
        int[][] aLotOfTrucks = new int[][]{
                {2, 4, 2, 1},
                {1, 0, 3, 3},
                {1, 4, 2, 1},
                {0, 0, 2, 1},
                {3, 3, 2, 1}
        };

        return aLotOfTrucks[truck_id];

    }
}

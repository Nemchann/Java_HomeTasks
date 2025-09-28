
public class Main {
    public static void main(String[] args) {
        City A = new City();
        A.name = "A";
        City B = new City();
        B.name = "B";
        City C = new City();
        C.name = "C";
        City D = new City();
        D.name = "D";
        City E = new City();
        E.name = "E";
        City F = new City();
        F.name = "F";

        A.addPaths(B, 5);
        A.addPaths(F, 1);
        A.addPaths(D, 6);

        B.addPaths(A, 5);
        B.addPaths(C, 3);

        C.addPaths(B, 3);
        C.addPaths(D, 4);

        D.addPaths(C, 4);
        D.addPaths(E, 2);
        D.addPaths(A, 6);

        E.addPaths(F, 2);

        F.addPaths(B, 1);
        F.addPaths(E, 2);

        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(D);
        System.out.println(E);
        System.out.println(F);


    }
}
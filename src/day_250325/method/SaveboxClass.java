package day_250325.method;

public class SaveboxClass {
    public static void main(String[] args) {
        Savebox s1 = new Savebox();
        Savebox s2 = new Savebox();
        Savebox s3 = new Savebox();

        s1.deposit(100);
        s1.deposit(100);

        s2.deposit(1000);

        s3.deposit(50);
        s3.deposit(50);
        s3.deposit(50);
        s3.deposit(50);
        s3.deposit(50);

        s1.withdraw();
        s2.withdraw();
        s3.withdraw();
    }
}

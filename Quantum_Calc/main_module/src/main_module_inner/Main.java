package main_module_inner;
import calculator_inner.Calculator;
import crystal_inner.Crystal;

public class Main {
    static double crys1_res;
    static double crys2_res;
    static String cry1_line;
    static String cry2_line;

    public static void main (String[]args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Crystal crystal1 = new Crystal(new Calculator("Crystal 1"));
                cry1_line = crystal1.getLine();
                crys1_res = crystal1.getSuccessRate();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Crystal crystal2 = new Crystal(new Calculator("Crystal 2"));
                cry2_line = crystal2.getLine();
                crys2_res = crystal2.getSuccessRate();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(cry1_line);
        System.out.println(cry2_line);

        System.out.println("Crystal 1 Success rate: "+crys1_res );
        System.out.println("Crystal 2 Success rate: "+crys2_res );

        if(crys1_res>crys2_res){
            System.out.println("Crystal 1 is better");
        }
        else if(crys1_res<crys2_res){
            System.out.println("Crystal 2 is better");
        }
        else {
            System.out.println("Crystals are equal");
        }
    }
}

package crystal_inner;

import calculator_inner.Calculator;

import java.util.Random;

public class Crystal{
    private Calculator calculator;
    private double success_rate;
    private double success_counter;
    private double rand_1;
    private double rand_2;
    private double real_res;
    private double calc_res;
    private boolean isEqual;
    private String correct = "(correct)";
    private String wrong = "(error)";
    private String result;
    Random rand = new Random();
    private String line;

    public Crystal(Calculator calc) {
        calculator = calc;
        line = CreateChart();
    }

    public String getLine() {
        return line;
    }

    public double getSuccessRate() {
        return success_rate;
    }
    public void setSuccessRate(double value){
        success_rate = value;
    }
    public double generateRandom(){
        final double v;
        v = (10 - 1) * rand.nextDouble();
        return v;
    }
    public String CreateChart(){
        line = "Calculator " +calculator.getName()+"\n";
        for (int i = 0; i < 20; i++) {
            result = wrong;
            rand_1 = generateRandom();
            rand_2 = generateRandom();
            real_res = rand_1 + rand_2;
            calc_res = calculator.add(rand_1,rand_2);
            isEqual = (real_res==calc_res);
            if(isEqual){
                success_counter++;
                result = correct;
            }
            line = line +rand_1+" + "+rand_2+" = "+calc_res+"   "+result +"\n";

        }
        setSuccessRate(success_counter/20);
        return line;
    }
}

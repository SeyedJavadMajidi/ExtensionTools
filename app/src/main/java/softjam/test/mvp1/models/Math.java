package softjam.test.mvp1.models;

public class Math {
    private int number1 = 0;
    private int number2 = 0;
    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int sum(){
        return number1+number2;
    }
    public int mine(){
        return number1+number2;
    }


}

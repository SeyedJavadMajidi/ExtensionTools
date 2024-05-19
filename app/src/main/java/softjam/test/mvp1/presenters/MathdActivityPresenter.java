package softjam.test.mvp1.presenters;

import softjam.test.mvp1.models.Math;

public class MathdActivityPresenter {
    private Math math;
    private MyView myView;

    public MathdActivityPresenter(MyView myView){
        math = new Math();
        this.myView = myView;
    }

    public void sum(int x,int y){
        math.setNumber1(x);
        math.setNumber2(y);
        myView.Sum(math.sum());
    }
    public interface MyView{
        void Mine(int result);
        void Sum(int result);
    }
}

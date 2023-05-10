package garbage;

import org.testng.annotations.Test;

public class D {

    @Test
    public void test1() {
        A x = new A();
        x.aA();
        x.aB();

        B y= new B();
        y.bB();
        y.bC();

        C z= new C();
        z.cC();

    }

    @Test
    public void test2() {
        A x = new A();

        B y=x.aA().aB().bB();

        C z=x.aA().aB().bC().cC();

        /*
        C z;
        z=x.aA().aB().bC().cC();


         */
        //x.a();
    }
}

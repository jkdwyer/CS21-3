import java.util.ArrayList;

public class MakeQSort {
    public static void main (String args[]) {
        System.out.println ("in MakeQSort.main");

        QSort qp = new QSort();

        /*  (1) Test instantiation of QSort object.
        for (int i = 0; i <= qp.getCount(); i++){
            if (i == qp.getCount()) {
                System.out.println(qp.getAlq().get(i));
            } else {
                System.out.print(qp.getAlq().get(i) + ", ");
            }
        }  */

        // (2) Test partition results on an instance of QSort.
        // System.out.println("call partition");
        // qp.partition(0, qp.getCount());

        // (3) Need a new instance for a fresh test of qs method.
        QSort qp2 = new QSort();
        System.out.println("call qs");
        qp.qs(0, qp2.getCount());
    }
}

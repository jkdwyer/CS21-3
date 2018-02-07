import java.util.ArrayList;

public class QSort {
    private ArrayList<Integer> alq;
    private int count = 0;

    public QSort() {
        alq = new ArrayList();
        alq.add(3);
        alq.add(7);
        alq.add(8);
        alq.add(5);
        alq.add(2);
        alq.add(1);
        alq.add(9);
        alq.add(5);
        alq.add(4);
        count = (alq.size() - 1);
    }

    public ArrayList<Integer> getAlq() {
        return alq;
    }

    public int getCount() {
        return count;
    }

    public void qs (ArrayList<Integer> alQs, int lowPos, int highPos) {
        System.out.println("in QSort.qs()");
        System.out.println("lowPos: " + lowPos + ", highPos: " + highPos);
        int endPos = (alQs.size() - 1);

        if (lowPos < highPos) {
            highPos = partition (alQs, lowPos, highPos);
            System.out.println("Lower portion");
            qs (alQs, lowPos, (highPos-1));
            System.out.println("Higher portion");
            qs (alQs, (highPos+1), endPos);
        }
    }

    public int partition (ArrayList<Integer> alQp, int lowPos, int highPos) {
        System.out.println("in QSort.partition()");
        System.out.println("lowPos: " + lowPos + ", highPos: " + highPos);
        printAlq(alQp);

        int pvPos = highPos;
        int pVal = alQp.get(pvPos);
        int pvPriorPos = (pvPos-1);
        int pvPriorVal = alQp.get(pvPriorPos);
        int iPos = lowPos;
        int iVal = alQp.get(iPos);

        System.out.println("Initial values - iPos: " + iPos + ", iVal: " + iVal +
                ", pvPos: " + pvPos + ", pVal: " + pVal +
                ", pvPriorPos: " + pvPriorPos + ", pvPriorVal: " + pvPriorVal);

        for (int j = lowPos; j < highPos; j++) {
            // test the condition, per j.
            if (iVal > pVal) {
                // swap i with pvPos-1, and pvPos-1 with pvPos.
                alQp.set(iPos, pvPriorVal);
                alQp.set(pvPriorPos, pVal);
                alQp.set(pvPos, iVal);
                // pvPos equals the sort-size of the array.
                pvPos--;
                pvPriorPos--;
                // get new values.
                pvPriorVal = alQp.get(pvPriorPos);
                iVal = alQp.get(iPos);
                // if you swap, don't increment i.
            } else {
                iPos++;
                iVal = alQp.get(iPos);
            }
            System.out.print ("j: " + j + " - ");
            printAlq(alQp);
        }
        // printAlq(alQp);
        System.out.println("end partition - pvPos: " + pvPos);
        System.out.println();
        return pvPos;
    }

    public void printAlq(ArrayList<Integer> alQs) {
        for (int i = 0; i <= count; i++){
            if (i == count) {
                System.out.println(alQs.get(i));
                System.out.println();
            } else {
                System.out.print(alQs.get(i) + ", ");
            }
        }
    }
}

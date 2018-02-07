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

    public void qs (int lowPos, int highPos) {
        System.out.println("in QSort.qs()");
        int endPos = count;
        int pvPos = highPos;
        System.out.println("lowPos: " + lowPos + ", highPos: " + highPos + ", pvPos: " + pvPos);

        if (lowPos < highPos) {
            highPos = partition (lowPos, highPos);
            System.out.println("Lower portion");
            qs (lowPos, (highPos-1));
            System.out.println("Higher portion");
            qs ((pvPos+1), endPos);
            // qs ((highPos+1), endPos);
        }
    }

    public int partition (int lowPos, int highPos) {
        System.out.println("in QSort.partition()");
        System.out.println("lowPos: " + lowPos + ", highPos: " + highPos);
        printAlq();

        int pvPos = highPos;
        int pVal = alq.get(pvPos);
        int pvPriorPos = (pvPos-1);
        int pvPriorVal = alq.get(pvPriorPos);
        int iPos = lowPos;
        int iVal = alq.get(iPos);

        System.out.println("Initial values - iPos: " + iPos + ", iVal: " + iVal +
                ", pvPos: " + pvPos + ", pVal: " + pVal +
                ", pvPriorPos: " + pvPriorPos + ", pvPriorVal: " + pvPriorVal);

        for (int j = lowPos; j < highPos; j++) {
            // test the condition, per j.
            if (iVal > pVal) {
                // swap i with pvPos-1, and pvPos-1 with pvPos.
                alq.set(iPos, pvPriorVal);
                alq.set(pvPriorPos, pVal);
                alq.set(pvPos, iVal);
                // pvPos equals the sort-size of the array.
                pvPos--;
                pvPriorPos--;
                // get new values.
                pvPriorVal = alq.get(pvPriorPos);
                iVal = alq.get(iPos);
                // if you swap, don't increment i.
            } else {
                iPos++;
                iVal = alq.get(iPos);
            }
            System.out.print ("j: " + j + " - ");
            printAlq();
        }
        // printAlq();
        System.out.println("end partition - pvPos: " + pvPos);
        System.out.println();
        return pvPos;
    }

    public void printAlq() {
        for (int i = 0; i <= count; i++){
            if (i == count) {
                System.out.println(alq.get(i));
                System.out.println();
            } else {
                System.out.print(alq.get(i) + ", ");
            }
        }
    }
}

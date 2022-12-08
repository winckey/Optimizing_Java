

import java.util.ArrayList;

public class GCMaker {

    public static void main(String[] args) throws Exception{
        GCMaker maker=new GCMaker();
        for(int loop=0;loop<120;loop++) {
            maker.makeObject();
            Thread.sleep(1000);
            // System.out.print(".");
        }
    }
    private void makeObject() {
        Integer[] intArr=new Integer[1024000];
        ArrayList<Integer> list=new ArrayList<Integer>(1024000);
        for(int loop=0;loop<1024;loop++) {
            intArr[loop]=loop;
            list.add(loop);
        }
    }
}
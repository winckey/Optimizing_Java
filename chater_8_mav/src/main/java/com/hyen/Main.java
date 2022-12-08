package com.hyen;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Throwable {


        ArrayList<String> buf = new ArrayList<>();
        for (int i = 0; true; i++) {
            if(i > 0 && i%100000 == 0 ){
                System.out.println("Current Buf.size() = "+buf.size());
                Thread.sleep(1000);
            }
            buf.add(new String("abcdefghijklmnoprstuwxyz"));
        }

    }


}

package com.example.provide;

import java.util.ArrayList;
import java.util.List;

public class AutoStart {
    public static void main(String[] args) {
        int port1 = 8010,port2=8011,port3=8012;
        List<Integer> portList = new ArrayList();
        portList.add(port1);
        portList.add(port2);
        portList.add(port3);
        for (int i = 0;i<portList.size();i++){
            ProvideApplication test = new ProvideApplication();
            //test.AutoStart(portList.get(i));
        }
    }
}
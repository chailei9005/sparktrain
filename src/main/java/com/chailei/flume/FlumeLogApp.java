package com.chailei.flume;

import org.apache.log4j.Logger;

public class FlumeLogApp {

    public static Logger logger = Logger.getLogger(FlumeLogApp.class.getSimpleName());

    public static void main(String[] args) throws InterruptedException {

        int count = 0;

        while(true){

            Thread.sleep(1000);

            logger.info("chailei data is " + count);
            count ++ ;
        }


    }
}

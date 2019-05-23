package com.yingchong.service.data_service.service;

public class BatchCompare {




    public void batchTimes(Integer total,Integer step) {

        if (step >= total) {//直接执行
            for (int i = 0; i < step; i++) {
                doSomeThing(i);
            }
        }else {
            int times = total/step;
            for (int i = 0; i < times; i++) {

                for (int k = i * times; k < (i+1) * times; k++) {
                    doSomeThing(k);
                }
            }
        }

    }

    public void doSomeThing(int i) {
        System.out.println(i);
    }

    public static void main(String[] args) {
        BatchCompare bc = new BatchCompare();
        bc.batchTimes(100,10);
    }

}

package com.rencai.service.user_service;

import java.math.BigDecimal;
import java.util.Arrays;

public class test {
    /**
     * 递归级联增长(递归写法)
     * @param money
     * @param users
     */
    public static BigDecimal linkIncome(BigDecimal money, BigDecimal[] users, int n) {
        if (users[n] != null) {
            return users[n];
        }
        if (n == 0) {
            users[0] = money;
            return money;
        } else if (n == 1) {
            BigDecimal m = linkIncome(money, users, 0).multiply(new BigDecimal(0.1)).setScale(2,BigDecimal.ROUND_HALF_UP);
            users[n]= m;
            return m;
        } else  {
            BigDecimal m = linkIncome(money,users,n-1).multiply(new BigDecimal(0.1)).add(linkIncome(money,users,n-2).multiply(new BigDecimal(0.05)));
            m = m.setScale(2,BigDecimal.ROUND_HALF_UP);
            if(m.compareTo(new BigDecimal(1))>0){
                //System.out.println("n == " + n);
                users[n]=m;
                return m;
            }
            return new BigDecimal(0);
        }
    }

    /**
     * 循环写法
     * @param money
     * @param users
     * @return
     */
    public static BigDecimal[] linkIncome1(BigDecimal money, BigDecimal[] users) {
        users[0] = money;
        //BigDecimal nextMoney = null;
        for(int i=0;i<users.length;i++) {
            if (i == 0) {
                users[0] = money;
            }else if(i == 1){
                money = money.multiply(new BigDecimal(0.1)).setScale(2,BigDecimal.ROUND_HALF_UP);
                if(money.compareTo(new BigDecimal(1))>=0){
                    users[i] = money;
                }else{
                    break;
                }
            }else {
                money = users[i-2].multiply(new BigDecimal(0.05)).add(users[i-1].multiply(new BigDecimal(0.1))).setScale(2,BigDecimal.ROUND_HALF_UP);
                System.out.println(money);
                if(money.compareTo(new BigDecimal(1))>=0){
                    users[i] = money;
                }else {
                    break;
                }
            }
        }
        return users;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        BigDecimal[] users = new BigDecimal[400];
        //BigDecimal bigDecimal = linkIncome(new BigDecimal(10000), users, 39);
        linkIncome1(new BigDecimal(1000), users);

        long b = System.currentTimeMillis();
        System.out.println(Arrays.toString(users));
        System.out.println("耗时="+(b-a));
    }
}

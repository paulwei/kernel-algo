package com.whl.algo.math;

import org.apache.commons.lang3.time.DateUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 年充利息 {
    public static void main(String[] args) throws ParseException {
            等额本息();
//        年充();
    }

    public static void 等额本息() throws ParseException {
        BigDecimal 月利率 = new BigDecimal(0.0325).divide(new BigDecimal(12));
        BigDecimal 总月数 = new BigDecimal(240);
        BigDecimal 剩余本金 = new BigDecimal(800000);
        BigDecimal 总利息 = new BigDecimal(0) ;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date cur =  format.parse("2016-01-30");
        for(int i=1;i<=240;i++){
            BigDecimal 当月本金 = 剩余本金.divide(总月数,2,RoundingMode.HALF_DOWN);
            剩余本金 = 剩余本金.subtract(当月本金);
            BigDecimal 当月利息 = 剩余本金.multiply(月利率);
            if(i>=73){
                总利息=总利息.add(当月利息);
                System.out.println("总利息:"+总利息);
            }
            System.out.println(String.format("第 %s 月,剩余本金:%s,当月应还本金:%s,当月应还利息%s",format.format(cur),剩余本金,当月本金, 当月利息));
            cur = DateUtils.addMonths(cur,1);

        }
        System.out.println("总利息:"+总利息);
    }

    public static void 年充(){
        BigDecimal 月利率 = new BigDecimal(0.0325).divide(new BigDecimal(12));
        BigDecimal 总月数 = new BigDecimal(240);
        BigDecimal 剩余本金 = new BigDecimal(800000);
        BigDecimal 公积金 = new BigDecimal(4342*12);
        BigDecimal 总利息 = new BigDecimal(0) ;
        BigDecimal 充钱 = new BigDecimal(0) ;
        int j=0;
        for(int i=1;i<=240;i++){
            if(剩余本金.intValue()<=0){
                System.out.println(String.format("第 %s 月还完,充钱：%s",j,充钱));
                break;
            }
            BigDecimal 当月本金 = 剩余本金.divide(总月数,2,RoundingMode.HALF_DOWN);
            剩余本金 = 剩余本金.subtract(当月本金);
            BigDecimal 当月利息 = 剩余本金.multiply(月利率);
            if(i>=73){
                j++;
                总利息=总利息.add(当月利息);
                if (j%12==0){
                    System.out.println(String.format("第 %s 月,当前第 %s月，充钱：%s",i,j,充钱));
                    剩余本金 = 剩余本金.subtract(公积金);
                }
                充钱 = 充钱.add(当月本金).add(当月利息);
                System.out.println(String.format("年充 第 %s 月,剩余本金:%s,当月应还本金:%s,当月应还利息%s",i,剩余本金,当月本金, 当月利息));
            }
        }
        System.out.println("总利息:"+总利息+"，充钱："+充钱);
    }
}

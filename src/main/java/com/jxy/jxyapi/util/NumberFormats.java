package com.jxy.jxyapi.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberFormats {
    static DecimalFormat df = new DecimalFormat("#0.00");

    static DecimalFormat df2 = new DecimalFormat(",##0.00");

    public static String format(int value) {
        return df.format(value);
    }

    public static String format(int value, int dot) {
        return df.format(value / (dot * 1.0));
    }

    public static String format(double value) {
        return df.format(value);
    }

    public static String format(BigDecimal value) {
        return df.format(value);
    }

    public static String formatThousandsNum(BigDecimal value) {
        return df2.format(value);
    }

    public static String formatThousandsNum(String value) {
        return formatThousandsNum(new BigDecimal(value));
    }

    /**
     * 整数值 除 100， 用于计算 金额分 to 金额元
     *
     * @param intValue
     * @return
     */
    public static String formatPercentage(Integer intValue) {
        BigDecimal sourceValue = new BigDecimal(intValue);
        return formatPercentage(sourceValue);
    }

    /**
     * 数据除100
     *
     * @param bigDecimalValue
     * @return
     */
    public static String formatPercentage(BigDecimal bigDecimalValue) {
        BigDecimal percentValue = new BigDecimal(100);
        BigDecimal resultValue = bigDecimalValue.divide(percentValue, 2, BigDecimal.ROUND_HALF_DOWN);
        return df.format(resultValue);
    }


    /**
     * int to 千位分隔数字
     *
     * @param intVal
     * @return
     */
    public static String formatPercenttageThousandsNum(Integer intVal) {
        BigDecimal sourceValue = new BigDecimal(intVal);
        BigDecimal percentValue = new BigDecimal(100);
        BigDecimal resultValue = sourceValue.divide(percentValue, 2, BigDecimal.ROUND_HALF_DOWN);
        return formatThousandsNum(resultValue);
    }

    /**
     * 金额  分 to 元的转换
     *
     * @param amount
     * @return
     */
    public static String amountPercentToYuan(String amount) {
        return amountPercentToYuan(new BigDecimal(amount)).toString();
    }

    /**
     * 金额  分 to 元的转换
     */
    public static BigDecimal amountPercentToYuan(BigDecimal amount) {
        return amount.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
    }
}

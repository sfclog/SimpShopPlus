package me.sfclog.simpshopplus.utils;


public class NumberCover {


    public static int cover(String amount) {
        if (amount == null || amount.isEmpty()) {
            return -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < amount.length(); i++) {
            char c = amount.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        if (sb.length() == 0 || sb.length() > 9) { // kiểm tra giới hạn độ dài
            return -1;
        }
        int number = Integer.parseInt(sb.toString());
        if (number < 0) {
            return -1;
        }
        return number;
    }
}

package com.github.wdsoft.string;

public class AddBinary_67 {
    public String addBinary(String a, String b) {
        int carry = 0;
        int sum = 0;
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;
        StringBuffer sb = new StringBuffer();

        while (index1 >= 0 && index2 >= 0) {
            sum = a.charAt(index1) - '0' + b.charAt(index2) - '0' + carry;
            carry = sum / 2;
            sb.append(sum % 2);
            index1--;
            index2--;
        }
        while (index1 >= 0) {
            sum = a.charAt(index1) - '0' + carry;
            carry = sum / 2;
            sb.append(sum % 2);
            index1--;
        }
        while (index2 >= 0) {
            sum = b.charAt(index2) - '0' + carry;
            carry = sum / 2;
            sb.append(sum % 2);
            index2--;
        }

        if (carry == 1) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}

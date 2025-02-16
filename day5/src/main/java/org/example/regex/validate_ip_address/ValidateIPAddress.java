package org.example.validate_ip_address;

import java.util.regex.Pattern;

public class ValidateIPAddress {
    public static void main(String[] args) {
        String ip1 = "192.168.1.1";
        String ip2 = "256.300.999.1"; // Invalid
        String ip3 = "127.0.0.1";
        String ip4 = "192.168.1"; // Invalid

        System.out.println(ip1 + " -> " + isValidIPv4(ip1));
        System.out.println(ip2 + " -> " + isValidIPv4(ip2));
        System.out.println(ip3 + " -> " + isValidIPv4(ip3));
        System.out.println(ip4 + " -> " + isValidIPv4(ip4));
    }

    public static boolean isValidIPv4(String ip) {
        String regex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}" +
                "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";

        return Pattern.matches(regex, ip);
    }
}


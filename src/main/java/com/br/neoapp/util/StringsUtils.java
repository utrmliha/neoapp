package com.br.neoapp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class StringsUtils {

    public static void main(String[] args) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        System.out.println(bcrypt.encode("admin")+"          ");
    }

    public static boolean isNullOrEmptyOrBlank(String str){
        return (str == null || str.isEmpty() || str.isBlank());
    }
}

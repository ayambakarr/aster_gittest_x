package com.mitrais.research.springhibernate.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 */
public final class StringHasher {

    private StringHasher() {

    }

    public static String md5(String inputString){
        return DigestUtils.md5Hex(inputString);
    }
}

package com.ms.login.exception;

public interface SneakyThrow {

    static <T extends Exception, R> R exception(Exception t) throws T {
        throw (T) t;
    }
}
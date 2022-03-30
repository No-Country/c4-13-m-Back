package com.IPETM69.EscuelaTecnica.exception;

public class ParamNotFound extends RuntimeException{

    public ParamNotFound(String param) {
        super ("Error, " + param + " is not found.");
    }
}


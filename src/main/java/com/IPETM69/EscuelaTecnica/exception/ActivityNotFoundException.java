package com.IPETM69.EscuelaTecnica.exception;

public class ActivityNotFoundException extends RuntimeException {
    
    public ActivityNotFoundException() {
        super("Activity was not found");
    }

    public ActivityNotFoundException(String msg) {
        super(msg);
    }
    
}

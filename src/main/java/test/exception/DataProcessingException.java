package test.exception;

public class DataProcessingException extends RuntimeException {

    public DataProcessingException(String reason, Throwable e) {
        super(reason);
    }

}

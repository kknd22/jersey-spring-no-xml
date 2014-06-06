package me.jsend;

/**
 * Created by chrislin on 6/4/2014.
 */
public class FailureResponse {
    private String status = "fail";
    private String message;
    private String cause;
    private String resolution;

    // ----------------------------------------------------------------------------
    //     generated CONSTRUCTORS
    // ----------------------------------------------------------------------------
    public FailureResponse(String message) {
        this.message = message;
    }

    public FailureResponse(String message, String cause) {
        this.message = message;
        this.cause = cause;
    }

    public FailureResponse(String message, String cause, String resolution) {
        this.message = message;
        this.cause = cause;
        this.resolution = resolution;
    }


    // ----------------------------------------------------------------------------
    //     generated GETTERS/SETTERS
    // ----------------------------------------------------------------------------

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getCause() {
        return cause;
    }

    public String getResolution() {
        return resolution;
    }
}

package me.jsend;

/**
 * Created by chrislin on 6/4/2014.
 */
public class SuccessResponse {
    private String status = "success";
    private Object data;

    // ----------------------------------------------------------------------------
    //     generated CONSTRUCTORS
    // ----------------------------------------------------------------------------
    public SuccessResponse() {
    }

    public SuccessResponse(Object data) {
        this.data = data;
    }


    // ----------------------------------------------------------------------------
    //     generated GETTERS/SETTERS
    // ----------------------------------------------------------------------------

    public String getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }
}

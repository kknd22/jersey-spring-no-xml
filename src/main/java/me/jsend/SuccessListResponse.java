package me.jsend;

import java.util.Collection;

/**
 * Created by chrislin on 6/4/2014.
 */
public class SuccessListResponse extends SuccessResponse{
    private int total;

    public SuccessListResponse(Collection list, int total) {
        super(list);
        this.total = total;
    }
}

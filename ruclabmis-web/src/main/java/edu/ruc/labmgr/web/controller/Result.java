package edu.ruc.labmgr.web.controller;

/**
 * 用于Ajax提交时，前后端信息的传递
 *
 * @author lcheng
 * @version 1.0
 *          ${tags}
 */
public class Result {
    private boolean success;
    private String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

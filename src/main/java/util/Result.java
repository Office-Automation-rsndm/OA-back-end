package util;

public class Result<T> {
    private boolean success;

    private int status;

    private T data;

    private String msg;

    public Result() {
    }

    public Result(boolean success, int status, T data, String msg) {
        this.success = success;
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public Result(boolean success, int status, String msg) {
        this.success = success;
        this.status = status;
        this.msg = msg;
    }

    public Result(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", status=" + status +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}

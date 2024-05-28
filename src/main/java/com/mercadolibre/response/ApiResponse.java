package com.mercadolibre.response;

public class ApiResponse {
        private String msg;
        private Object data;
        private boolean error;

        public ApiResponse(String msg, Object data) {
            this.msg = msg;
            this.data = data;
            this.error = false;
        }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}

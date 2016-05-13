package com.nachepin.api.dto;

public class Json {
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public static final String NO_LOGIN = "no_login";
    public static final String NO_AUTH = "no_auth";
    public static final String NO_DATA = "no_data";
    public static final String REDIRECT = "redirect";

	public static final int E0 = 0;

	/**
     * not found url
	 */
	public static final int E404 = 404;

	/**
	 * not found url
	 */
	public static final int E1000 = 1000;

	/**
	 * error data
	 */
	public static final int E1001 = 1001;

    private String code;

	private int subCode;

    private String message;

    private Object data;

    private String url;

    public static final Json AUTH = new Json(NO_AUTH, "", null);

    public static final Json LOGIN = new Json(NO_LOGIN, "", null);

    public static Json success(String message) {
        return new Json(SUCCESS, message, null);
    }

    public static Json success(String message, Object data) {
        return new Json(SUCCESS, message, data);
    }

    public static Json success2(Object data) {
        return success("success", data);
    }

    public static Json error(String message, Object data) {
        return new Json(ERROR, message, data).setSubCode(E0);
    }

    public static Json no_data(String message) {
        return new Json(NO_DATA, message, null);
    }

    public static Json error(String message) {
        return new Json(ERROR, message, null).setSubCode(E0);
    }

    public static Json redirect(String url) {
        return new Json(REDIRECT, null, null).setUrl(url);
    }

    public Json() {
    }

    public Json(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public Json setCode(String code) {
        this.code = code;
		return this;
    }

    public String getMessage() {
        return message;
    }

    public Json setMessage(String message) {
        this.message = message;
		return this;
    }

    public Object getData() {
        return data;
    }

    public Json setData(Object data) {
        this.data = data;
		return this;
    }

	public int getSubCode() {
		return subCode;
	}

	public Json setSubCode(int subCode) {
		this.subCode = subCode;
		return this;
	}

    public String getUrl() {
        return url;
    }

    public Json setUrl(String url) {
        this.url = url;
        return this;
    }
}
package com.lovegis.pojo;

public class Users {
    private Integer uid;

    private String account;

    public Users(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	private String password;

    public Users() {
		super();
	}

	public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}
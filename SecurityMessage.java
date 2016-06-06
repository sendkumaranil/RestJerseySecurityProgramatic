package com.restsecurity.programtic.example.model;

public class SecurityMessage {
	private String rolename;
	private String isSecureResource;
	private String auth_type;
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String isSecureResource() {
		return isSecureResource;
	}
	public void setSecureResource(String isSecureResource) {
		this.isSecureResource = isSecureResource;
	}
	public String getAuth_type() {
		return auth_type;
	}
	public void setAuth_type(String auth_type) {
		this.auth_type = auth_type;
	}
}

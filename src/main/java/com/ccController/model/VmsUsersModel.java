package com.ccController.model;

public class VmsUsersModel {
String msisdn;
Integer status;
String packId;
String nextRenewalDate;
Integer hlrFlag;
String createTime;
Integer langCode;
String subMode;
String channel;
Integer renewalFlag;
String dFlag;
String packName;
public String getPackName() {
	return packName;
}
public void setPackName(String packName) {
	this.packName = packName;
}
public String getMsisdn() {
	return msisdn;
}
public void setMsisdn(String msisdn) {
	this.msisdn = msisdn;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public String getPackId() {
	return packId;
}
public void setPackId(String packId) {
	this.packId = packId;
}
public String getNextRenewalDate() {
	return nextRenewalDate;
}
public void setNextRenewalDate(String nextRenewalDate) {
	this.nextRenewalDate = nextRenewalDate;
}
public Integer getHlrFlag() {
	return hlrFlag;
}
public void setHlrFlag(Integer hlrFlag) {
	this.hlrFlag = hlrFlag;
}
public String getCreateTime() {
	return createTime;
}
public void setCreateTime(String createTime) {
	this.createTime = createTime;
}
public Integer getLangCode() {
	return langCode;
}
public void setLangCode(Integer langCode) {
	this.langCode = langCode;
}
public String getSubMode() {
	return subMode;
}
public void setSubMode(String subMode) {
	this.subMode = subMode;
}
public String getChannel() {
	return channel;
}
public void setChannel(String channel) {
	this.channel = channel;
}
public Integer getRenewalFlag() {
	return renewalFlag;
}
public void setRenewalFlag(Integer renewalFlag) {
	this.renewalFlag = renewalFlag;
}
public String getdFlag() {
	return dFlag;
}
public void setdFlag(String dFlag) {
	this.dFlag = dFlag;
}


@Override
public String toString() {
	return "VmsUsersModel [msisdn=" + msisdn + ", status=" + status + ", packId=" + packId + ", nextRenewalDate="
			+ nextRenewalDate + ", hlrFlag=" + hlrFlag + ", createTime=" + createTime + ", langCode=" + langCode
			+ ", subMode=" + subMode + ", channel=" + channel + ", renewalFlag=" + renewalFlag + ", dFlag=" + dFlag
			+ ", packName=" + packName + "]";
}

}

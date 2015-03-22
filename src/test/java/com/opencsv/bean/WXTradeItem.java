/**
 * %运营商结算%
 * %v1.0%
 */
package com.opencsv.bean;

import java.util.Date;

/**
 * @类名: WXTradeItem
 * @说明: 微信交易数据
 *
 * @author   leehom
 * @Date	 2015年3月20日 下午4:11:22
 * 修改记录：
 *
 * @see 	 
 */
public class WXTradeItem extends Object {
	
	private Long itemId;
	/** 交易时间*/
	private Date tradeTime;
	/** 公众帐号Id*/
	private String publicAccId;
	private String mhId;
	private double totalAmount;
	/** 退款类型*/
	private String reType;
    /** 手续费*/
    private double fee;
    /** 费率*/
    private String feeRate;
    
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Date getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}
	public String getPublicAccId() {
		return publicAccId;
	}
	public void setPublicAccId(String publicAccId) {
		this.publicAccId = publicAccId;
	}
	public String getMhId() {
		return mhId;
	}
	public void setMhId(String mhId) {
		this.mhId = mhId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getReType() {
		return reType;
	}
	public void setReType(String reType) {
		this.reType = reType;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String getFeeRate() {
		return feeRate;
	}
	public void setFeeRate(String feeRate) {
		this.feeRate = feeRate;
	}
    
    
    
}

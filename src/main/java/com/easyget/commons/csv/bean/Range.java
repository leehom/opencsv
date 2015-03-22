/**
 * %运营商结算%
 * %v1.0%
 */
package com.easyget.commons.csv.bean;


/**
 * @类名: Range
 * @说明: 范围，
 *        
 *
 * @author   leehom
 * @Date	 2015年3月20日 下午3:14:11
 * 修改记录：
 *
 * @see 	 
 */
public class Range extends Object {

	/** 
	 * 起始范围，0为第一个，包括start,end
	 */
	private int start;
	private int end;
	
	public Range(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	/**
	 * @说明：是否在范围之内
	 *
	 * @author leehom
	 * @param i
	 * @return
	 * 
	 */
	public boolean in(int i) {
		if(Math.abs(start)>Math.abs(end))
			return false;
		return (start<=i) && (end>=i);
		
	}
	
}

/**
 * %公共组件-cvs解释%
 * %v1.0%
 */
package com.easyget.commons.csv.bean;


/**
 * @类名: Line
 * @说明: 行
 *
 * @author   leehom
 * @Date	 2015年3月20日 下午2:45:22
 * 修改记录：
 *
 * @see 	 
 */
public class Line extends Object {
	
	/** 行号，0 开始*/
	private int rowNum;
	/** */
	private String[] line;
	
	public Line(int rowNum, String[] line) {
		super();
		this.rowNum = rowNum;
		this.line = line;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public String[] getLine() {
		return line;
	}
	public void setLine(String[] line) {
		this.line = line;
	}
	
	
}

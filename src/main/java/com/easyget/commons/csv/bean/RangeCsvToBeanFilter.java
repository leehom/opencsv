/**
 * %运营商结算%
 * %v1.0%
 */
package com.easyget.commons.csv.bean;

/**
 * @类名: RangeCsvToBeanFilter
 * @说明: 范围过滤器
 *
 * @author   leehom
 * @Date	 2015年3月20日 下午3:09:39
 * 修改记录：
 *
 * @see 	 
 */
public class RangeCsvToBeanFilter implements CsvToBeanFilter {
	
	/** */
	private Range range;

	@Override
	public boolean allowLine(Line line) {
		return range.in(line.getRowNum());
	}

	public Range getRange() {
		return range;
	}

	public void setRange(Range range) {
		this.range = range;
	}
	
}

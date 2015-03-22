/**
 * %运营商结算%
 * %v1.0%
 */
package com.easyget.commons.csv.bean;

import java.util.List;

/**
 * @类名: CompoundCsvToBeanFilter
 * @说明: 
 *
 * @author   leehom
 * @Date	 2015年3月20日 下午3:09:39
 * 修改记录：
 *
 * @see 	 
 */
public class CompoundCsvToBeanFilter implements CsvToBeanFilter {
	
	/** */
	private List<CsvToBeanFilter> filters;

	@Override
	public boolean allowLine(Line line) {
		boolean bool = true;
		for(CsvToBeanFilter filter : filters) {
			bool = bool && filter.allowLine(line);
			if(!bool)
				break;
		}
		return bool;
	}

	public List<CsvToBeanFilter> getFilters() {
		return filters;
	}

	public void setFilters(List<CsvToBeanFilter> filters) {
		this.filters = filters;
	}

	
}

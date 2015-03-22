/**
 * %运营商结算%
 * %v1.0%
 */
package com.easyget.commons.csv.bean;

import java.text.ParseException;

/**
 * @类名: FieldFormater
 * @说明: 格式化器
 *
 * @author   leehom
 * @Date	 2015年3月20日 下午12:02:33
 * 修改记录：
 *
 * @see 	 
 */
public interface FieldFormater {

	public String parse(String source) throws ParseException;

}

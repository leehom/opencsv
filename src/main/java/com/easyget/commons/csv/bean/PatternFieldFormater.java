/**
 * %运营商结算%
 * %v1.0%
 */
package com.easyget.commons.csv.bean;

import java.text.MessageFormat;
import java.text.ParseException;

/**
 * @类名: PatternFieldFormater
 * @说明: 基于模式分析格式化器
 *
 * @author   leehom
 * @Date	 2015年3月20日 下午12:02:33
 * 修改记录：
 *
 * @see 	 
 */
public class PatternFieldFormater implements FieldFormater {
	
	/** 格式化模式*/
	private String pattern;
	
	public PatternFieldFormater(String pattern) {
		super();
		this.pattern = pattern;
	}

	public String parse(String source) throws ParseException { 
		Object[] ss = doParse(source);
		if(ss.length==0)
			return null;
		else if(ss.length==1)
			return (String)ss[0]; // 是否应该检验一下
		else 
			throw new ParseException("分析有多于一个结果", 0);
	}
	
	public Object[] doParse(String source) throws ParseException { 
		MessageFormat mf = new MessageFormat(pattern);
		Object[] obj = mf.parse(source);
		return obj;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}

package com.opencsv.bean;

/**
 Copyright 2007 Kyle Miller.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Before;
import org.junit.Test;

import com.easyget.commons.csv.CSVReader;
import com.easyget.commons.csv.bean.ColumnPositionMappingStrategy;
import com.easyget.commons.csv.bean.CsvToBean;
import com.easyget.commons.csv.bean.FieldFormater;
import com.easyget.commons.csv.bean.PatternFieldFormater;
import com.easyget.commons.csv.bean.Range;
import com.easyget.commons.csv.bean.RangeCsvToBeanFilter;

public class ColumnPositionMappingStrategyTest {
   private ColumnPositionMappingStrategy<WXTradeItem> strat;

   @Before
   public void setUp() throws Exception {
      strat = new ColumnPositionMappingStrategy<>();
      strat.setType(WXTradeItem.class);
      // 注册java.utils.Date转换器
      ConvertUtils.register(new DateLocaleConverter(Locale.getDefault(), "yyyy-MM-dd HH:mm:ss"), Date.class);
   }

   @Test
   public void getColumnIndexBeforeMappingSetReturnsNull() {
      assertNull(strat.getColumnIndex("name"));
   }

   @Test
   public void getColumnIndexEmptyMappingReturnsNull() {
      strat.setColumnMapping(null);
      assertNull(strat.getColumnIndex("name"));
   }

   @Test
   public void getColumnIndex() {
      assertNull(strat.getColumnIndex("name"));
      String[] columns = new String[]{"name", "orderNumber", "id"};
      strat.setColumnMapping(columns);

      assertEquals(0, strat.getColumnIndex("name").intValue());
      assertEquals(1, strat.getColumnIndex("orderNumber").intValue());
      assertEquals(2, strat.getColumnIndex("id").intValue());

      assertNull(strat.getColumnIndex("name not mapped"));
   }

   @Test
   public void testParse() throws IOException {
	  //
      Reader reader = new FileReader("res/wxcsv.csv");
      CSVReader csvr = new CSVReader(reader);
      // 计算总行数
      int total = csvr.readAll().size();
      csvr.close();
      // 
      Reader reader2 = new FileReader("res/wxcsv.csv");
      CSVReader csvr2 = new CSVReader(reader2);
      //
      RangeCsvToBeanFilter rf = new RangeCsvToBeanFilter();
      Range range = new Range(1, total-3);   
      rf.setRange(range);
      //
      FieldFormater formater = new PatternFieldFormater("`{0}");
      //
      strat.setColumnMapping("tradeTime", "publicAccId", "mhId", "totalAmount", "reType", "fee", "feeRate");
      CsvToBean<WXTradeItem> csv = new CsvToBean<>();
      
      List<WXTradeItem> list = csv.parse(strat, csvr2, rf, formater);
      assertNotNull(list);
      assertTrue(list.size() == 2);
      WXTradeItem bean = list.get(0);
      System.out.println(bean);
   }

   @Test
   public void testParseWithTrailingSpaces() {
      /*String s = "" +
            "kyle  ,123456  ,emp123  ,  1   \n" +
            "jimmy,abcnum,cust09878,2   ";

      String[] columns = new String[]{"name", "orderNumber", "id", "num"};
      strat.setColumnMapping(columns);

      CsvToBean<MockBean> csv = new CsvToBean<>();
      List<MockBean> list = csv.parse(strat, new StringReader(s));
      assertNotNull(list);
      assertTrue(list.size() == 2);
      MockBean bean = list.get(0);
      assertEquals("kyle  ", bean.getName());
      assertEquals("123456  ", bean.getOrderNumber());
      assertEquals("emp123  ", bean.getId());
      assertEquals(1, bean.getNum());*/
   }

   @Test
   public void testGetColumnMapping() {
      String[] columnMapping = strat.getColumnMapping();
      assertNotNull(columnMapping);
      assertEquals(0, columnMapping.length);

      String[] columns = new String[]{"name", "orderNumber", "id"};
      strat.setColumnMapping(columns);

      columnMapping = strat.getColumnMapping();
      assertNotNull(columnMapping);
      assertEquals(3, columnMapping.length);
      assertArrayEquals(columns, columnMapping);

   }

   @Test
   public void testGetColumnNames() {

      strat.setColumnMapping("name", null, "id");

      assertEquals("name", strat.getColumnName(0));
      assertEquals(null, strat.getColumnName(1));
      assertEquals("id", strat.getColumnName(2));
      assertEquals(null, strat.getColumnName(3));
   }

   @Test
   public void testGetColumnNamesArray() {

      strat.setColumnMapping("name", null, "id");
      String[] mapping = strat.getColumnMapping();

      assertEquals(3, mapping.length);
      assertEquals("name", mapping[0]);
      assertEquals(null, mapping[1]);
      assertEquals("id", mapping[2]);
   }

   @Test
   public void getColumnNamesWhenNullArray() {
      strat.setColumnMapping((String[]) null);

      assertEquals(null, strat.getColumnName(0));
      assertEquals(null, strat.getColumnName(1));
      assertArrayEquals(new String[0], strat.getColumnMapping());
   }

   @Test
   public void getColumnNamesWhenNullColumnName() {
      String[] columns = {null};
      strat.setColumnMapping(columns);

      assertEquals(null, strat.getColumnName(0));
      assertEquals(null, strat.getColumnName(1));
      assertArrayEquals(columns, strat.getColumnMapping());
   }

   @Test
   public void getColumnNamesWhenEmptyMapping() {
      strat.setColumnMapping();

      assertEquals(null, strat.getColumnName(0));
      assertArrayEquals(new String[0], strat.getColumnMapping());
   }
}

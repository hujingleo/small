package com.ptteng.small.audit.dynamicUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BeanToMap {
  
  
  private static final Log log = LogFactory.getLog(BeanToMap.class);
  
  private BeanToMap() {
  }
  
  public static HashMap<String, Object> beanToMap(Object b) {
    HashMap<String, Object> hashMap = new HashMap<String, Object>();
    Class<?> classType = b.getClass();
    Field[] fields = classType.getDeclaredFields();// 得到对象中的字段
    for (int i = 0; i < fields.length; i++) {
      Field field = fields[i];
      String fieldName = field.getName();
      if (fieldName.equals("serialVersionUID")) {
        continue;
      }
      if (fieldName.equals("FORBIDDEN")) {
        continue;
      }
      if (fieldName.equals("NORMAL")) {
        continue;
      }
      if (fieldName.equals("NOT_DONE")) {
        continue;
      }
      if (fieldName.equals("ALREADY_UPLOAD")) {
        continue;
      }
      if (fieldName.equals("RE_DO")) {
        continue;
      }
      if (fieldName.equals("EN_ROUTE")) {
        continue;
      }
      if (fieldName.equals("IN_STORE")) {
        continue;
      }
      if (fieldName.equals("ALREADY_SALE")) {
        continue;
      }
      if (fieldName.equals("OTHER_BREAKDOWN")) {
        continue;
      }
      if (fieldName.equals("OTHER_SOT")) {
        continue;
      }
      if (fieldName.equals("OTHER_NOT_RECORD")) {
        continue;
      }
      if (fieldName.equals("OTHER_DELAY_SETTLEMENT")) {
        continue;
      }
      if (fieldName.equals("HEAD_STORAGE")) {
        continue;
      }
      if (fieldName.equals("SECOND_STORAGE")) {
        continue;
      }
      if (fieldName.equals("TEMP_STORAGE")) {
        continue;
      }
      // 获得属性的首字母并转换为大写，与setXXX对应
      String firstLetter = fieldName.substring(0, 1).toUpperCase();
      String getMethodName = "get" + firstLetter + fieldName.substring(1);
      try {
        Method getMethod = classType.getMethod(getMethodName);
        Object value = getMethod.invoke(b);
        hashMap.put(fieldName, value);
        
      }
      catch (Exception e) {
        e.printStackTrace();
      }
      
    }
    return hashMap;
  }
  
  /**
   * 改进过的方法
   * 
   * @param bean
   * @return
   * @author liut
   */
  public static Map<String, Object> beanToMap2(Object bean) {
    Map<String, Object> map = new HashMap<String,Object>();
    try {
      Class<?> clazz = bean.getClass();
      Field[] fields = clazz.getDeclaredFields();
      for (Field f : fields) {
        if (f.getModifiers() == Modifier.PRIVATE) {
          String key = f.getName();
          String getMethodName = "get" + upperFirstChar(key);
          Method getMethod = clazz.getMethod(getMethodName);
          Object value = getMethod.invoke(bean);
          map.put(key, value);
        }
      }
    }
    catch (Exception ex) {
      log.error("beanToMap2 error", ex);
    }
    return map;
  }
  
  /**
   * 首字母大写
   * 
   * @param name
   * @return
   * @author liut
   */
  private static String upperFirstChar(String name) {
    char[] cs = name.toCharArray();
    // cs[0] = (char) (cs[0] - 32);
    cs[0] -= 32;
    return new String(cs);
  }
  
}

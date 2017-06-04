package com.ptteng.small.admin.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 集合转换的工具
 * 
 * @author liut
 *
 */
public class CollectionConvertUtil {
  
  
  private final static Log log = LogFactory.getLog(CollectionConvertUtil.class);
  
  /**
   * 私有化构造器
   */
  private CollectionConvertUtil() {
  }
  
  /**
   * 将一个存放表名字的set转换成字符串
   * <li>比如：set中存放三个元素分别是a b c，转换的结果是："a,b,c"
   * 
   * @param set
   * @return
   */
  public static String setConvertToTable(Set<String> set) {
    StringBuilder sb = new StringBuilder("");
    if (CollectionUtils.isEmpty(set)) {
      log.info("sets is empty");
      return sb.toString();
    }
    Iterator<String> iterator = set.iterator();
    while (iterator.hasNext()) {
      String table = iterator.next();
      sb.append(table).append(",");
    }
    String result = sb.toString();
    result = result.substring(0, result.length() - 1);
    return result;
  }
  
  /**
   * list转成map
   * 
   * @param list
   * @param getMethodStr
   *        get方法的名字
   * @param clazz
   * @return
   */
  public static <K, V> Map<K, V> list2Map(List<V> list, String getMethodStr, Class<V> clazz) {
    Map<K, V> map = new HashMap<K,V>();
    if (CollectionUtils.isEmpty(list)) {
      log.info("arg list is empty");
      return map;
    }
    try {
      Method getMethod = clazz.getMethod(getMethodStr);
      for (int i = 0; i < list.size(); i++) {
        V value = list.get(i);
        K key = (K) getMethod.invoke(value);
        map.put(key, value);
      }
    }
    catch (Exception ex) {
      log.error("list2Map error", ex);
    }
    
    return map;
  }
  
  /**
   * 拼接sql的in条件
   * 
   * @param list
   * @return
   */
  public static <T> String list2String(List<T> list) {
    StringBuilder result = new StringBuilder("(");
    int len = list.size();
    if (list.get(0) instanceof String) {
      for (int i = 0; i < len; i++) {
        T id = list.get(i);
        if (i == len - 1) {
          result.append("'" + id + "'");
        }
        else {
          result.append("'" + id + "', ");
        }
      }
    }
    else {
      for (int i = 0; i < len; i++) {
        T id = list.get(i);
        if (i == len - 1) {
          result.append(id);
        }
        else {
          result.append(id + ", ");
        }
      }
    }
    result.append(")");
    return result.toString();
  }
  
  /**
   * 校验list中的元素是否重复<br>
   * true：重复；false：不重复
   * 
   * @param list
   * @return
   */
  public static <T> boolean isRepetition(List<T> list) {
    Set<T> set = new HashSet<T>();
    for (T t : list) {
      set.add(t);
    }
    int setLen = set.size(), listLen = list.size();
    log.info("setLen is: " + setLen + ", listLen is: " + listLen);
    if (setLen != listLen) {
      log.info("not equals");
      return true;
    }
    else {
      return false;
    }
  }
  
  public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
    list.add("abc");
    list.add("abc");
    list.add("mm");
    System.out.println(list2String(list));
    
    List<Long> list1 = new ArrayList<Long>();
    list1.add(1L);
    list1.add(2L);
    list1.add(3L);
    System.out.println(list2String(list1));
    
    System.out.println(isRepetition(list));
  }
}

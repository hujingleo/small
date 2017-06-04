package com.ptteng.small.admin.util;

import com.gemantic.common.util.StringUtil;
import com.qding.common.util.DataUtils;
import org.apache.commons.collections.map.HashedMap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by liangxj on 2016/12/6.
 */
public class FeedBackUtil {

    public static String convertTable(Set<String> tables) {
        StringBuffer tableBuffer = new StringBuffer();
        int index = 0;
        Iterator var4 = tables.iterator();

        while(var4.hasNext()) {
            String table = (String)var4.next();
            ++index;
            tableBuffer = tableBuffer.append(table);
            if(index < tables.size()) {
                tableBuffer = tableBuffer.append(",");
            }
        }

        return tableBuffer.toString();
    }
}

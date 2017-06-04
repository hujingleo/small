package com.ptteng.small.admin.exportExcel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TestTemplate {
  public static void main(String[] args) {
    ExcelTemplate excel = new ExcelTemplate();
    excel.readTemplatePath(
        "/Users/huangchao/workspace/haichuan/haichuan-admin-web/src/main/resources/template.xls");
    excel.creatNewRow();
    excel.createNewCol("aaa");
    excel.createNewCol("111");
    excel.createNewCol("111");
    excel.createNewCol("ggg");
    excel.creatNewRow();
    excel.createNewCol("bbb");
    excel.createNewCol("222");
    excel.createNewCol("222");
    excel.createNewCol("ggg");
    excel.creatNewRow();
    excel.createNewCol("ccc");
    excel.createNewCol("333");
    excel.createNewCol("333");
    excel.createNewCol("ggg");
    excel.creatNewRow();
    excel.createNewCol("ddd");
    excel.createNewCol("444");
    excel.createNewCol("444");
    excel.createNewCol("ggg");
    excel.creatNewRow();
    excel.createNewCol("eee");
    excel.createNewCol("555");
    excel.createNewCol("555");
    excel.createNewCol("ggg");
    excel.creatNewRow();
    excel.createNewCol("fff");
    excel.createNewCol("666");
    excel.createNewCol("666");
    excel.createNewCol("hhh");
    Map<String, String> datas = new HashMap<String, String>();
    datas.put("title", "拉斯维加斯");
    datas.put("date", new Date().toString());
    datas.put("department", "百合科技人事部");
    excel.replaceFind(datas);
    //excel.insertSer();
    excel.writeToFile("/Users/huangchao/itextPdf/test.xls");
  }
}

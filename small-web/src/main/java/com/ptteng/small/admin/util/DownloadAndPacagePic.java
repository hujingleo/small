package com.ptteng.small.admin.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemantic.common.util.StringUtil;


public class DownloadAndPacagePic {
  private final static Log log = LogFactory.getLog(DownloadAndPacagePic.class);
  public final static String PATH = "/data/webs/haichuan-admin-web/script/";
  
  /**
   * 私有化构造器
   */
  private DownloadAndPacagePic() {
    
  }
  
  public static int downloadPic(String picUrl, String dir) {
    log.info("method downloadPic argument silkUrl is: " + picUrl + " dir is /" + dir);
    if (StringUtil.isEmpty(picUrl)) {
      log.info("the string silkUrl is empty");
      return -1;
    }
    if (StringUtil.isEmpty(dir)) {
      log.info("the string dir is empty");
      return -1;
    }
    Process proc = null;
    BufferedReader in = null;
    
    try {
      proc = Runtime.getRuntime().exec("sh " + PATH + "download.sh " + dir + " " + picUrl);
      printMessage(proc.getInputStream());
      printMessage(proc.getErrorStream());
      proc.waitFor();
    }
    catch (Exception ex) {
      log.error("method downloadPic error", ex);
      return -1;
    }
    finally {
      try {
        if (in != null) {
          in.close();
        }
      }
      catch (IOException ex) {
        log.error("close in error", ex);
      }
    }
    
    return 1;
  }
  
  /**
   * 移除对应文件夹及内容
   * @param dir
   * @return
   */
  public static int removeDir(String dir) {
    log.info("method removeDir argument dir is: " + dir);
    if (StringUtil.isEmpty(dir)) {
      log.info("the string dir is empty");
      return -1;
    }
    Process proc = null;
    BufferedReader in = null;
    
    try {
      proc = Runtime.getRuntime().exec(
          "sh " + PATH + "removedir.sh " + " " + dir);
      printMessage(proc.getInputStream());
      printMessage(proc.getErrorStream());
      proc.waitFor();
    }
    catch (Exception ex) {
      log.error("method removeDir error", ex);
      return -1;
    }
    finally {
      try {
        if (in != null) {
          in.close();
        }
      }
      catch (IOException ex) {
        log.error("close in error", ex);
      }
    }
    
    return 1;
  }
  
  /**
   * 打包对应的目录为zip
   * @param dir
   * @return
   */
  public static int packageDir(String dir) {
    log.info("method packageDir argument dir is: " + dir);
    if (StringUtil.isEmpty(dir)) {
      log.info("the string dir is empty");
      return -1;
    }
    Process proc = null;
    BufferedReader in = null;
    
    try {
      proc = Runtime.getRuntime().exec(
          "sh " + PATH + "packageDir.sh " + " " + dir);
      printMessage(proc.getInputStream());
      printMessage(proc.getErrorStream());
      proc.waitFor();
    }
    catch (Exception ex) {
      log.error("method packageDir error", ex);
      return -1;
    }
    finally {
      try {
        if (in != null) {
          in.close();
        }
      }
      catch (IOException ex) {
        log.error("close in error", ex);
      }
    }
    
    return 1;
  }
  
  
  /**
   * 单独线程分别处理标准输出流与错误输出流
   * @param input
   */
  private static void printMessage(final InputStream input) {
      new Thread(new Runnable() {
          public void run() {
              Reader reader = new InputStreamReader(input);
              BufferedReader bf = new BufferedReader(reader);
              String line = null;
              try {
                  while((line=bf.readLine())!=null) {
                  }
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }).start();
  }


}

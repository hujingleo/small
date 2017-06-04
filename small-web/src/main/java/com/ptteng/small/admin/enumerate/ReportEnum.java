package com.ptteng.small.admin.enumerate;

/**
 * 审计报告的异常枚举值
 * 
 * @author liut
 *
 */
public enum ReportEnum {
  /** 当前报告的状态非法，不能进行初审操作 */
  cannotFirstJudge(-13000),
  /** 当前报告对应的厂家任务状态非法，报告审核拒绝时，不能将厂家任务状态从已完成置为已重开 */
  venderTaskCannotReopen(-13001),
  /** 外勤任务状态非法，报告审核拒绝时，不能将外勤任务状态从已通过置为已完成 */
  memberTaskCannotCompelete(-13002),
  /** 当前报告的状态非法，不能进行终审操作 */
  cannotFinalJudge(-13003),
  /** 当前报告对应的厂家任务状态非法，报告终审通过时，不能将厂家任务状态从已完成置为已关闭 */
  venderTaskCannotClose(-13004),
  /** 外勤任务状态非法，报告终审通过时，不能将外勤任务状态从已通过置为已关闭 */
  memberTaskCannotClose(-13005);
  
  private int value;
  
  private ReportEnum(int value) {
    this.value = value;
  }
  
  public int getValue() {
    return value;
  }
  
  public void setValue(int value) {
    this.value = value;
  }
  
}

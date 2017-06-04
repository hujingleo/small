package com.ptteng.small.admin.enumerate;

public enum MemberTaskEnum {
  /** 队员名字不能为空 */
  memberNameIsEmpty(-9000),
  /** 厂家任务id不能为空 */
  venderTaskIsEmpty(-9001),
  /** 队员id不能为空 */
  memberIdIsEmpty(-9002),
  /** 经销商id不能为空 */
  distributorIdIsEmpty(-9003),
  /** 分配外勤任务，多个库位id不能为空 */
  eachStorageIdIsEmpty(-9004),
  /** 队员已请假，不能分配外勤任务 */
  memberOnVacation(-9005),
  /** 当前库位已经分配过审计员，不能重复分配，若要重新分配，请先撤回之前分配的审计员 */
  duplicateDistribute(-9006),
  /** 外勤任务当前的状态不能执行撤回操作 */
  cannotWithdraw(-9007),
  /** 不能重复撤回 */
  duplicateWithdraw(-9008);
  
  private int value;
  
  private MemberTaskEnum(int value) {
    this.value = value;
  }
  
  public int getValue() {
    return value;
  }
}

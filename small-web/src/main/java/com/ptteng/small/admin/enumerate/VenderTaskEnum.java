package com.ptteng.small.admin.enumerate;

public enum VenderTaskEnum {
  /** 当前厂家已被禁用 */
  venderIsForbidden(-7004),
  /** excel的url不能为空 */
  excelUrlCannotEmpty(-8000),
  /** type不能为空 */
  typeCannotEmpty(-8001),
  /** 非法的type值 */
  illegalTypeValue(-8002),
  /** 在我们录入的经销商数据中找不到excel里的经销商 */
  notExistDistributor(-8003),
  /** 经销商已禁用 */
  distributorForbidden(-7000),
  /** 解析盘库excel出错 */
  inventoryExcelError(-8004),
  /** 解析倒查excel出错 */
  inspectExcelError(-8005),
  /** 厂家id不能为空 */
  venderIdIsEmpty(-8006),
  /** 经销商id不能为空 */
  distributorIdIsEmpty(-8007),
  /** 团队id不能为空 */
  teamIdIsEmpty(-8008),
  /** 计划日期不能为空 */
  palnBeginAtIsEmpty(-8009),
  /** 至少有一个url不为空 */
  bothUrlisEmpty(-8010),
  /** 选择的团队中包括了其他厂家的团队或已禁用的团队 */
  illegalTeamIds(-8011),
  /** 当前的厂家任务不能被编辑，厂家任务的状态非法 */
  cannotEditVenderTask(-8012),
  /** 编辑厂家任务，入参多个团队id不能为空 */
  eachTeamIdIsEmpty(-8013),
  /** 编辑当前的厂家任务时，不能取消团队，只能增加团队 */
  alreadyCancelTeam(-8014),
  /** 编辑当前的厂家任务时，不能更改计划日期 */
  alreadyModifyPlanBeginAt(-8015),
  /** 当前的厂家任务不能被取消，厂家任务的状态非法 */
  cannotCancelVenderTask(-8016),
  /** 当前的厂家任务不能被分配，厂家任务的状态非法 */
  cannotDistributeTask(-8017),
  /** 经销商已被禁用 */
  distributorIsForbidden(-7000),
  /** 当前的厂家任务不能查看外勤，厂家任务的状态非法 */
  cannotLookMemberTask(-8018),
  /** 盘库excel中存在已经录入过的vin码 */
  inventoryExistVinno(-8021),
  /** 根据excel中经销商的名字在我们录入的数据中找到多个 */
  multipleDistributorName(-8022),
  /** 盘库csv中的vin码有重复 */
  repetitionInventoryVinno(-8023),
  /** 倒查csv中的vin码有重复 */
  repetitionInspectVinno(-8024),
  /** 盘库csv和倒查csv至少导入一项 */
  bothCSVIsEmpty(-8032),
  /** 解析盘库csv出错 */
  inventoryCSVError(-8033),
  /** 解析倒查csv出错 */
  inspectCSVError(-8034),
  /** 盘库csv中没有该经销商 */
  inventoryNoDistributor(-8035),
  /** 倒查csv中没有该经销商 */
  inspectNoDistributor(-8036),
  /** 经销商名字不能为空 */
  distributorNameIsEmpty(-8037),
  /** 刷新厂家列表的ids不能为空 */
  refreshIdsIsEmpty(-8038);
  
  private int value;
  
  private VenderTaskEnum(int value) {
    this.value = value;
  }
  
  public int getValue() {
    return value;
  }
}

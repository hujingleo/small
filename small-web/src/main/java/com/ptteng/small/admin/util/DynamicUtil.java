package com.ptteng.small.admin.util;

import com.ptteng.common.dao.util.SQLUtil;
import com.qding.common.util.DataUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

/**
 * Created by liangxj on 2015/9/7.
 */
public class DynamicUtil {

    private static final Log log = LogFactory.getLog(DynamicUtil.class);

    public static String convertTable(Set<String> tables) {
        StringBuffer tableBuffer = new StringBuffer();
        int index = 0;
        Iterator var4 = tables.iterator();

        while (var4.hasNext()) {
            String table = (String) var4.next();
            ++index;
            tableBuffer = tableBuffer.append(table);
            if (index < tables.size()) {
                tableBuffer = tableBuffer.append(",");
            }
        }

        return tableBuffer.toString();
    }

    public static Map<String, Object> getVenderListParam(String venderName, Long teamNum, String managerAccount,
                                                         String idsStr, Boolean count) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 厂家名称
        if (DataUtils.isNotNullOrEmpty(venderName)) {
            params.put("name & like ", "\"%" + venderName + "%\"");
        }
        // 团队数量
        if (DataUtils.isNotNullOrEmpty(teamNum)) {
            params.put("team_num", teamNum);
        }
        // 登陆id
        if (DataUtils.isNotNullOrEmpty(managerAccount)) {
            params.put("manager_id & in ", "(" + idsStr + ")");
        }

        params.put("@table", " vender");
        if (count) {
            params.put("@query", " count(id) ");
        } else {
            params.put("@order", " create_at desc ");
        }

        return params;
    }

    public static Map<String, Object> getDistributorListParam(String companyName, String companyShortName,
                                                              String province, String city, String contactsName, String contactsPhone, Integer selfStorageNum,
                                                              Integer secondStorageNum, Integer tempStorageNum, String status, Boolean count) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 公司名称
        if (DataUtils.isNotNullOrEmpty(companyName)) {
            params.put("company_name & like ", "\"%" + companyName + "%\"");
        }
        // 公司简介名称
        if (DataUtils.isNotNullOrEmpty(companyShortName)) {
            params.put("company_short_name & like ", "\"%" + companyShortName + "%\"");
        }
        // 省
        if (DataUtils.isNotNullOrEmpty(province)) {
            params.put("province", province);
        }
        // 市
        if (DataUtils.isNotNullOrEmpty(city)) {
            params.put("city ", city);
        }
        // 联系人
        if (DataUtils.isNotNullOrEmpty(contactsName)) {
            params.put("contacts_name & like ", "\"%" + contactsName + "%\"");
        }
        // 联系电话
        if (DataUtils.isNotNullOrEmpty(contactsPhone)) {
            params.put("contacts_phone & like ", "\"%" + contactsPhone + "%\"");
        }
        // 本部数
        if (DataUtils.isNotNullOrEmpty(selfStorageNum)) {
            params.put("self_storage_num", selfStorageNum);
        }
        // 二部数
        if (DataUtils.isNotNullOrEmpty(secondStorageNum)) {
            params.put("second_storage_num", secondStorageNum);
        }
        // 临展数
        if (DataUtils.isNotNullOrEmpty(tempStorageNum)) {
            params.put("temp_storage_num", tempStorageNum);
        }
        // 状态
        if (DataUtils.isNotNullOrEmpty(status)) {
            params.put("status", status);
        }

        params.put("@table", " distributor");
        if (count) {
            params.put("@query", " count(id) ");
        } else {
            params.put("@order", " create_at desc ");
        }
        log.info("getDistributorListParam sql is " + SQLUtil.convert2Sql(params, 0, 0));
        return params;
    }

    public static Map<String, Object> getEnrouteSaledReportListParam(String taskNum, String distributorName,
                                                                     String connactName, String connactPhone, String planStartTime, String planEndTime, String status,
                                                                     Long venderId, boolean count) {
        Map<String, Object> params = new HashMap<String, Object>();
        Set<String> tables = new HashSet();
        tables.add("enrouteSaledReport en");
        tables.add("memberTask mt");
        tables.add("venderTask vt");
        params.put("en.member_task_id", "mt.id");
        params.put("mt.vender_task_id", "vt.id");
        if (DataUtils.isNotNullOrEmpty(venderId)) {
            params.put("vt.vender_id", venderId);
        }
        // 任务编号
        if (DataUtils.isNotNullOrEmpty(taskNum)) {
            params.put("en.id & like ", "\"%" + taskNum + "%\"");
        }
        // 经销商姓名
        if (DataUtils.isNotNullOrEmpty(distributorName)) {
            params.put("en.distributor_short_name & like ", "\"%" + distributorName + "%\"");
        }
        // 审计位置
        /**
         * if (DataUtils.isNotNullOrEmpty(auditPosition)) {
         * params.put("en.auditPosition & like ", "\"%" + auditPosition +
         * "%\""); } // 本部地址 if (DataUtils.isNotNullOrEmpty(selfAddress)) {
         * params.put("en.head_storage_address & like ", "\"%" + selfAddress +
         * "%\""); }
         */
        // 联系人
        if (DataUtils.isNotNullOrEmpty(connactName)) {
            params.put("en.head_storage_contact_name & like ", "\"%" + connactName + "%\"");
        }
        // 联系电话
        if (DataUtils.isNotNullOrEmpty(connactPhone)) {
            params.put("en.head_storage_contact_phone & like ", "\"%" + connactPhone + "%\"");
        }
        // 计划时间
        if (DataUtils.isNotNullOrEmpty(planStartTime)) {
            params.put(" en.plan_begin_at &>=", " '" + planEndTime + "' ");
        }
        if (DataUtils.isNotNullOrEmpty(planEndTime)) {
            params.put(" en.plan_begin_at& <= ", "'" + planEndTime + "'");
        }
        // 状态
        if (DataUtils.isNotNullOrEmpty(status)) {
            params.put("en.status", status);
        }

        String table = convertTable(tables);
        params.put("@table", table);
        if (count) {
            params.put("@query", " count(en.id) ");
        } else {
            params.put("@query", " en.id ");
            params.put("@order", " en.create_at desc ");
        }

        log.info("getEnrouteSaledReportListParam sql is " + SQLUtil.convert2Sql(params, 0, 0));

        return params;
    }

    /**
     * @param distributorId
     * @param storageName
     * @param latitude
     * @param longitude
     * @param atrribute
     * @param province
     * @param city
     * @param contactsName
     * @param contactsPost
     * @param contactsPhone
     * @param status
     * @param count
     * @return
     */
    public static Map<String, Object> getStorageListParam(String distributorId, String storageName, String latitude,
                                                          String longitude, String atrribute, String province, String city, String contactsName, String contactsPost,
                                                          String contactsPhone, String status, Boolean count) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 经销商id
        if (DataUtils.isNotNullOrEmpty(distributorId)) {
            params.put("distributor_id", distributorId);
        }
        // 库位名称
        if (DataUtils.isNotNullOrEmpty(storageName)) {
            params.put("name & like ", "\"%" + storageName + "%\"");
        }
        // 经度
        if (DataUtils.isNotNullOrEmpty(latitude)) {
            params.put("latitude & like ", "\"%" + latitude + "%\"");
        }
        // 纬度
        if (DataUtils.isNotNullOrEmpty(longitude)) {
            params.put("longitude & like ", "\"%" + longitude + "%\"");
        }
        // 属性
        if (DataUtils.isNotNullOrEmpty(atrribute)) {
            params.put("atrribute", atrribute);
        }
        // 省
        if (DataUtils.isNotNullOrEmpty(province)) {
            params.put("province ", province);
        }
        // 市
        if (DataUtils.isNotNullOrEmpty(city)) {
            params.put("city ", city);
        }
        // 联系电话
        if (DataUtils.isNotNullOrEmpty(contactsPhone)) {
            params.put("contacts_phone & like ", "\"%" + contactsPhone + "%\"");
        }
        // 联系人
        if (DataUtils.isNotNullOrEmpty(contactsName)) {
            params.put("contacts_name & like ", "\"%" + contactsName + "%\"");
        }
        // 联系post
        if (DataUtils.isNotNullOrEmpty(contactsPost)) {
            params.put("contacts_post & like ", "\"%" + contactsPost + "%\"");
        }

        // 状态
        if (DataUtils.isNotNullOrEmpty(status)) {
            params.put("status", status);
        }

        params.put("@table", " storage");
        if (count) {
            params.put("@query", " count(id) ");
        } else {
            params.put("@order", " create_at desc ");
        }

        return params;
    }

    public static Map<String, Object> getVenderList() {
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("@table", " vender");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");

        return params;
    }

    public static Map<String, Object> getVenderAccount(String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 登陆用户id
        if (DataUtils.isNotNullOrEmpty(id)) {
            params.put("id &not in", "(" + id + ")");
        }

        params.put("@table", " manager");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");

        return params;
    }

    public static Map<String, Object> getStorageByDistributor(Long id) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 经销商id
        if (DataUtils.isNotNullOrEmpty(id)) {
            params.put("distributor_id", id);
        }
        // 启用状态
        params.put("status", "1");
        // 本部库位
        params.put("atrribute", "1");
        params.put("@table", " storage");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");

        return params;
    }

    public static Map<String, Object> getTeamListByVenderId(Long id) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 厂家id
        if (DataUtils.isNotNullOrEmpty(id)) {
            params.put("belong_to_id", id);
        }
        params.put("@table", " team");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");

        return params;
    }

    /**
     * 根据经销商查找仓库列表
     *
     * @param id
     * @return
     */
    public static Map<String, Object> getStorageListByDistributorId(Long id) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 经销商id
        if (DataUtils.isNotNullOrEmpty(id)) {
            params.put("distributor_id", id);
        }
        params.put("@table", " storage");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");

        return params;
    }

    /**
     * 根据经销商id获取任务list
     */
    public static Map<String, Object> getTaskListByDistributorId(Long id) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 经销商id
        if (DataUtils.isNotNullOrEmpty(id)) {
            params.put("distributor_id", id);
        }
        // 已取消 已关闭
        params.put("status &not in", "('-1','5')");
        params.put("@table", " venderTask");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");

        return params;
    }

    /**
     * 根据厂家id获取任务list
     */
    public static Map<String, Object> getTaskListByVenderId(Long id) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 厂家id
        if (DataUtils.isNotNullOrEmpty(id)) {
            params.put("vender_id", id);
        }
        // 已取消 已关闭
        params.put("status &not in", "('-1','5')");
        params.put("@table", " venderTask");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");

        return params;
    }

    /**
     * 根据库位id获取任务list
     */
    public static Map<String, Object> getMemberTaskListByStorageId(Long id) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 库位id
        if (DataUtils.isNotNullOrEmpty(id)) {
            params.put("storage_id", id);
        }
        // 已取消 已关闭
        params.put("status &not in", "('-1','5')");
        params.put("@table", " memberTask");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");

        return params;
    }

    /**
     * 根据厂家任务id获取未撤回的外勤任务
     *
     * @param id 厂家任务id
     * @return
     * @author liut
     */
    public static Map<String, Object> getMemberTaskListByVenderId(Long id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("vender_task_id", id);
        params.put("is_withdraw", false);
        params.put("@table", " memberTask");
        params.put("@order", " create_at desc");
        log.info("getMemberTaskListByVenderId sql is: " + SQLUtil.convert2Sql(params, 0, 0));
        return params;
    }

    /**
     * 根据库位登陆用户查询id
     */
    public static Map<String, Object> getMemberTaskListByStorageId(String account) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 库位id
        if (DataUtils.isNotNullOrEmpty(account)) {
            params.put("name & like", "'%" + account + "%'");
        }
        params.put("@table", " manager");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");

        return params;
    }

    /**
     * 根据外勤任务id获取 盘查信息
     */
    public static Map<String, Object> getInventoryListByMemberTaskId(Long memberTaskId) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 库位id
        if (DataUtils.isNotNullOrEmpty(memberTaskId)) {
            params.put("member_task_id", memberTaskId);
        }
        // 只查询销售和在途状态车辆
        // params.put("audit_result & in", "('0','2','30','31','32','33')");
        /**
         * 更改by lishasha
         */
        params.put("audit_result & in", "('0','2')");
        params.put("@table", " inventory");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");

        return params;
    }

    /**
     * 根据厂家任务id获取 盘查信息
     */
    public static Map<String, Object> getInventoryListByVenderTaskId(Long venderTaskId) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 库位id
        if (DataUtils.isNotNullOrEmpty(venderTaskId)) {
            params.put("vender_task_id", venderTaskId);
        }
        // 只查询销售和在途状态车辆
        // params.put("audit_result & in", "('0','2')");
        params.put("@table", " inventory");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");

        return params;
    }

    /**
     * 根据厂家任务id获取 倒查信息
     */
    public static Map<String, Object> getInspectListByVenderTaskId(Long venderTaskId) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 库位id
        if (DataUtils.isNotNullOrEmpty(venderTaskId)) {
            params.put("vender_task_id", venderTaskId);
        }
        // 只查询销售和在途状态车辆
        // params.put("audit_result & in", "('0','2')");
        params.put("@table", " inspect");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");

        return params;
    }

    /**
     * 根据团队id获取成员列表
     */
    public static Map<String, Object> getMemberListByTeamId(String teamIds) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 库位id
        if (DataUtils.isNotNullOrEmpty(teamIds)) {
            params.put("team_id & in", "(" + teamIds + ")");
        }
        params.put("@table", " member");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");

        return params;
    }

    /**
     * 根据company_id获取部门列表
     */
    public static Map<String, Object> getDepartmentListByCompanyId(Long companyId) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 库位id
        if (DataUtils.isNotNullOrEmpty(companyId)) {
            params.put("company_id & in", "(" + companyId + ")");
        }
        params.put("@table", " department");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");

        return params;
    }

    /**
     * 根据company_id获取员工列表
     */
    public static Map<String, Object> getEmployeeListByCompanyId(Long companyId) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 库位id
        if (DataUtils.isNotNullOrEmpty(companyId)) {
            params.put("company_id & in", "(" + companyId + ")");
        }
        params.put("@table", " employee");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");

        return params;
    }

    /**
     * 根据department_id获取员工列表
     */
    public static Map<String, Object> getEmployeeListByDepartmentId(Long departmentId) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 库位id
        if (DataUtils.isNotNullOrEmpty(departmentId)) {
            params.put("department_id & in", "(" + departmentId + ")");
        }
        params.put("@table", " employee");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");

        return params;
    }

    public static Map<String, Object> getCompanyMangerList(String name, String product, String province, String city,
                                                           String county, Long industry, Long financing, Long freezed, Long approved) {

        Map<String, Object> params = new HashMap<String, Object>();

        if (DataUtils.isNotNullOrEmpty(name)) {
            params.put("name & like", "'%" + name + "%'");
        }

        if (DataUtils.isNotNullOrEmpty(product)) {
            params.put("product & like", "'%" + product + "%'");
        }

        if (DataUtils.isNotNullOrEmpty(province)) {
            params.put("province ", "'" + province + "'");
        }
        if (DataUtils.isNotNullOrEmpty(city)) {
            params.put("city ", "'" + city + "'");
        }
        if (DataUtils.isNotNullOrEmpty(county)) {
            params.put("county ", "'" + county + "'");
        }
        if (DataUtils.isNotNullOrEmpty(industry)) {
            params.put("id & in ", "(select company_id from company_industry where industry in (" + industry + "))");
        }
        if (DataUtils.isNotNullOrEmpty(financing)) {
            params.put("financing ", financing);
        }
        if (DataUtils.isNotNullOrEmpty(freezed)) {
            params.put("freezed ", freezed);
        }
        if (DataUtils.isNotNullOrEmpty(approved)) {
            params.put("approved ", approved);
        }

        params.put("@order", " update_at desc ");

        params.put("@query", " id");

        params.put("@table", " company ");

        return params;
    }

    /**
     * @param title
     * @param author
     * @param startAt
     * @param endAt
     * @param type
     * @param status
     * @param industry
     * @return
     */
    public static Map<String, Object> getArticleListSmall(String title, String author, Long startAt, Long endAt, Long type,
                                                          Long status, Long industry, Integer isBanner, String currentId) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(isBanner)) {
            params.put("is_banner", "'" + isBanner + "'");
        }
        if (DataUtils.isNotNullOrEmpty(currentId)) {
            params.put("type", "'" + currentId + "'");
        }
        if (DataUtils.isNotNullOrEmpty(title)) {
            params.put("title & like ", "'%" + title + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(author)) {
            params.put("author & like ", "'%" + author + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(startAt)) {
            params.put("update_at & >=", startAt);
        }
        if (DataUtils.isNotNullOrEmpty(endAt)) {
            params.put("update_at & <= ", endAt);
        }
        if (DataUtils.isNotNullOrEmpty(type)) {
            params.put("type ", type);
        }
        params.put("status ", 1);

        params.put("@order", "  is_top desc,publish_at desc ");

        params.put("@query", " id");

        params.put("@table", " article ");

        log.info("getArticleList sql is " + SQLUtil.convert2Sql(params, 0, 0));
        return params;
    }

    public static Map<String, Object> getArticleList(String title, String author, Long startAt, Long endAt, Long type,
                                                     Long status, Long industry) {
        Map<String, Object> params = new HashMap<String, Object>();

        if (DataUtils.isNotNullOrEmpty(title)) {
            params.put("title & like ", "'%" + title + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(author)) {
            params.put("author & like ", "'%" + author + "%'");
        }
        if (DataUtils.isNotNullOrEmpty(startAt)) {
            params.put("update_at & >=", startAt);
        }
        if (DataUtils.isNotNullOrEmpty(endAt)) {
            params.put("update_at & <= ", endAt);
        }
        if (DataUtils.isNotNullOrEmpty(type)) {
            params.put("type ", type);
        }
        if (DataUtils.isNotNullOrEmpty(status)) {
            params.put("status ", status);
        }

        params.put("@order", "  publish_at desc ");

        params.put("@query", " id");

        params.put("@table", " article ");

        log.info("getArticleList sql is " + SQLUtil.convert2Sql(params, 0, 0));
        return params;
    }

    public static Map<String, Object> getArticleTypeList() {
        Map<String, Object> params = new HashMap<String, Object>();


        params.put("@order", "  create_at desc ");

        params.put("@query", " id");

        params.put("@table", " article_type ");

        log.info("getArticleList sql is " + SQLUtil.convert2Sql(params, 0, 0));
        return params;
    }

    public static Map<String, Object> getUserListByOpenid(String openid) {
        Map<String, Object> params = new HashMap<String, Object>();


        params.put("openid", "'" + openid + "'");
        params.put("@order", "  create_at desc ");

        params.put("@query", " id");

        params.put("@table", " user ");

        log.info("getArticleList sql is " + SQLUtil.convert2Sql(params, 0, 0));
        return params;
    }

    /**
     * 小程序文章类型列表
     *
     * @return
     */
    public static Map<String, Object> getArticleTypeListBySmall() {
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("status", "1");

        params.put("@order", "  is_top desc ");

        params.put("@query", " id");

        params.put("@table", " article_type ");

        log.info("getArticleList sql is " + SQLUtil.convert2Sql(params, 0, 0));
        return params;
    }

    public static Map<String, Object> getProfessionNum(Long companyId) {
        Map<String, Object> params = new HashMap<String, Object>();

        if (DataUtils.isNotNullOrEmpty(companyId)) {
            params.put("company_id", companyId);
        }

        params.put("@order", " update_at desc ");

        params.put("@query", " count(id)");

        params.put("@table", " profession ");

        return params;
    }

    public static Map<String, Object> getArticleIdsOrderBySort() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("@order", " orderBy  ");
        params.put("@table", " article ");
        return params;
    }

    /**
     * 更具managerId获取厂家
     */
    public static Map<String, Object> getVenderByMangerId(Long managerId) {

        Map<String, Object> params = new HashMap<String, Object>();

        if (DataUtils.isNotNullOrEmpty(managerId)) {
            params.put("manager_id", managerId);
        }

        params.put("@order", " create_at desc ");

        params.put("@query", " id");

        params.put("@table", " vender ");

        return params;
    }

    /**
     * 根据外勤任务id获取在途已售报告id
     */
    public static Map<String, Object> getEnrouteListByMemberTaskId(String memberTaskId) {

        Map<String, Object> params = new HashMap<String, Object>();

        if (DataUtils.isNotNullOrEmpty(memberTaskId)) {
            params.put("member_task_id & in ", "(" + memberTaskId + ")");
        }

        params.put("@order", " create_at desc ");

        params.put("@query", " id");

        params.put("@table", " enrouteSaledReport ");

        return params;
    }

    // 根据厂家任务id获取，获取盘库中状态为其他的所有车辆
    public static Map<String, Object> getInventoryCarListByVenderTaskId(Long venderTaskId) {

        Map<String, Object> params = new HashMap<String, Object>();

        if (DataUtils.isNotNullOrEmpty(venderTaskId)) {
            params.put("vender_task_id", venderTaskId);
        }

        params.put("audit_result & in ", "(30,31,32,33)");
        params.put("@order", " create_at desc ");

        params.put("@query", " id");

        params.put("@table", " inventory ");

        return params;
    }

    // 根据厂家任务id获取，获取倒查中状态为其他的所有车辆
    public static Map<String, Object> getInspectCarListByVenderTaskId(Long venderTaskId) {

        Map<String, Object> params = new HashMap<String, Object>();

        if (DataUtils.isNotNullOrEmpty(venderTaskId)) {
            params.put("vender_task_id", venderTaskId);
        }

        params.put("audit_result & in ", "(30,31,32,33)");
        params.put("@order", " create_at desc ");

        params.put("@query", " id");

        params.put("@table", " inspect ");

        return params;
    }

    // 根据状态值获取符合条件盘库记录数
    public static Map<String, Object> getInventoryByStatus(String status, Long id) {

        Map<String, Object> params = new HashMap<String, Object>();

        if (DataUtils.isNotNullOrEmpty(status)) {
            params.put("audit_result & in ", "(" + status + ")");
        }
        if (DataUtils.isNotNullOrEmpty(id)) {
            params.put("vender_task_id ", id);
        }

        params.put("@order", " create_at desc ");

        params.put("@query", " id");

        params.put("@table", " inventory ");

        return params;
    }

    // 根据状态值获取符合条件倒查记录数
    public static Map<String, Object> getInspectByStatus(String status, Long id) {

        Map<String, Object> params = new HashMap<String, Object>();

        if (DataUtils.isNotNullOrEmpty(status)) {
            params.put("audit_result & in", "(" + status + ")");
        }
        if (DataUtils.isNotNullOrEmpty(id)) {
            params.put("vender_task_id ", id);
        }
        params.put("@order", " create_at desc ");

        params.put("@query", " id");

        params.put("@table", " inspect ");

        return params;
    }

    /**
     * 公司列表
     */
    public static Map<String, Object> getCompanyListParam(String companyName, String status, Boolean count) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 公司名称
        if (DataUtils.isNotNullOrEmpty(companyName)) {
            params.put("name & like ", "\"%" + companyName + "%\"");
        }
        // 状态
        if (DataUtils.isNotNullOrEmpty(status)) {
            params.put("status", status);
        }
        params.put("@table", " company");
        if (count) {
            params.put("@query", " count(id) ");
        } else {
            params.put("@query", " id ");
            params.put("@order", " create_at desc ");
        }

        return params;
    }

    /**
     * 部门列表
     */
    public static Map<String, Object> getDepartmentListParam(String departmentName, String status, Long companyId,
                                                             Boolean count) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 公司名称
        if (DataUtils.isNotNullOrEmpty(departmentName)) {
            params.put("name & like ", "\"%" + departmentName + "%\"");
        }
        // 状态
        if (DataUtils.isNotNullOrEmpty(status)) {
            params.put("status", status);
        }
        // 公司id
        if (DataUtils.isNotNullOrEmpty(companyId)) {
            params.put("company_id", companyId);
        }
        params.put("@table", " department");
        if (count) {
            params.put("@query", " count(id) ");
        } else {
            params.put("@query", " id ");
            params.put("@order", " create_at desc ");
        }

        return params;
    }

    /**
     * 员工列表
     */
    public static Map<String, Object> getEmployeeListParam(Long departmentId, Long companyId, String employeeName,
                                                           String phone, Long inductionStartTime, Long inductionEndTime, String companyName, String departmentName,
                                                           String city, String position, String status, Boolean count) {
        Map<String, Object> params = new HashMap<String, Object>();
        // 部门id
        if (DataUtils.isNotNullOrEmpty(departmentId)) {
            params.put("department_id", departmentId);
        }
        // 公司id
        if (DataUtils.isNotNullOrEmpty(companyId)) {
            params.put("company_id", companyId);
        }
        // 公司名称
        if (DataUtils.isNotNullOrEmpty(employeeName)) {
            params.put("name & like ", "\"%" + employeeName + "%\"");
        }
        // 电话
        if (DataUtils.isNotNullOrEmpty(phone)) {
            params.put("phone & like ", "\"%" + phone + "%\"");
        }
        // 入职时间
        if (DataUtils.isNotNullOrEmpty(inductionStartTime)) {
            params.put(" induction_time & >= ", "'" + inductionStartTime + "'");
        }
        if (DataUtils.isNotNullOrEmpty(inductionEndTime)) {
            params.put(" induction_time & <= ", "'" + inductionEndTime + "'");
        }
        // 公司名称
        if (DataUtils.isNotNullOrEmpty(companyName)) {
            params.put("company & like ", "\"%" + companyName + "%\"");
        }
        // 部门名称
        if (DataUtils.isNotNullOrEmpty(departmentName)) {
            params.put("department & like ", "\"%" + departmentName + "%\"");
        }
        // 城市
        if (DataUtils.isNotNullOrEmpty(city)) {
            params.put("city & like ", "\"%" + city + "%\"");
        }
        // 职位
        if (DataUtils.isNotNullOrEmpty(position)) {
            params.put("position & like ", "\"%" + position + "%\"");
        }
        // 状态
        if (DataUtils.isNotNullOrEmpty(status)) {
            params.put("status", status);
        }
        params.put("@table", " employee");
        if (count) {
            params.put("@query", " count(id) ");
        } else {
            params.put("@query", " id ");
            params.put("@order", " create_at desc ");
        }

        return params;
    }


    public static Map<String, Object> getCommentByOpenIdAndArticleId(String openId, Long articleId) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(openId)) {
            params.put("open_id", "'" + openId + "'");
        }
        if (DataUtils.isNotNullOrEmpty(articleId)) {
            params.put("article_id", articleId);
        }
        params.put("@table", " comment");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");
		return params;
}
    public static Map<String, Object> getUserArticleByOpenIdAndArticleId(String openId, Long articleId) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(openId)) {
            params.put("open_id", "'" + openId + "'");
        }
        if (DataUtils.isNotNullOrEmpty(articleId)) {
            params.put("article_id", articleId);
        }
        params.put("@table", " user_article");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");
        return params;
    }
    public static Map<String, Object> getCommentByArticleId(Long id) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(id)) {
            params.put("article_id", id);
        }
        params.put("@table", " comment");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");
        return params;
    }

    public static Map<String, Object> getMessageByOpenId(String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(id)) {
            params.put("open_id", "'"+id+"'");
        }
        params.put("@table", " message");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");
        return params;
    }
    public static Map<String, Object> getUserByOpenId(String id) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (DataUtils.isNotNullOrEmpty(id)) {
            params.put("openid","'"+ id+"'");
        }
        params.put("@table", " user");
        params.put("@query", " id ");
        params.put("@order", " create_at desc ");
        return params;
    }
//    public static Map<String, Object> getOpenIdsByArticleId(Long id) {
//        Map<String, Object> params = new HashMap<String, Object>();
//        //selcect id from user where open_id in (select open_id from comment where article_id =id )
//        if (DataUtils.isNotNullOrEmpty(id)) {
//            params.put("open_id & in","(select id from comment where article_id = ("+id+"))");
//        }
//        params.put("@table", " user");
//        params.put("@query", " id ");
//        params.put("@order", " create_at desc ");
//        return params;
//    }
}
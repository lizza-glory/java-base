package com.lizza;

import org.junit.Test;

public class NullTests {

    @Test
    public void test1() throws Exception {
        Integer count = null;
        String ss = "" + count;
        System.out.println(ss.length());
        System.out.println(Long.valueOf(null));
    }

    @Test
    public void test2() throws Exception {
        String s = "<script> "
                + " select sum(countNum) as countSum, id from "
                + " <foreach collection = 'autoArchiveRuleCounts' item='item' open='(' separator='UNION ALL' close=')'>"
                + " select count(1) as countNum, a.pipeline_id as id"
                + " from active_applications as a "
                + " <if test='availableJobIdsStr == null or availableJobIdsStr == \"\" '> "
                + "     join jobs as j on j.id = a.job_id "
                + " </if> "
                + " join application_extend_info e on e.org_id = #{orgId} and e.application_id = a.id "
                + " <choose> "
                + "     <when test='item.ruleType != null and item.ruleType == 2 '> "
                + "           left join application_washout_result awr on awr.org_id = #{orgId} and awr.application_id = a.id and awr.stage_id = a.stage_id "
                + "     </when> "
                + "     <otherwise> "
                + "           left join application_stage_round_status asrs on asrs.org_id = #{orgId} and asrs.application_id = a.id and asrs.stage_id = a.stage_id "
                + "     </otherwise> "
                + " </choose>"
//        + " left join shigongs sg on sg.application_id = a.id "
                + " WHERE a.org_id = #{orgId}"
                + " and e.org_id = #{orgId} "
                + " and a.pipeline_id = #{item.pipelineId} "
                + " and a.stage_id = #{item.stageId}"
                + " and a.deleted = 0 "
                + " and a.virtual_job_id is not null "
                + " and a.virtual_job_id != a.job_id "
                + " and a.archived = 0 "
                + " and (a.id = e.locked_id or e.locked_id = 0)"
                + " <choose> "
                + "     <when test='availableJobIdsStr != null and availableJobIdsStr !=\"\" '> "
                + "           and a.job_id in (${availableJobIdsStr}) "
                + "     </when> "
                + "     <otherwise> "
                + "           and j.status = 'open' "
                + "     </otherwise> "
                + " </choose>"
                + " and a.last_handle_time &lt;= #{item.archiveOverTime} "
                + " <choose> "
                + "     <when test='item.ruleType != null and item.ruleType == 2 '> "
                + "           and awr.washout = 1 "
                + "     </when> "
                + "     <otherwise> "
                + "           and ((asrs.round = 0 and asrs.interviewer_status = 2) or (asrs.id is null)) "
                + "     </otherwise> "
                + " </choose>"
//        + " and ((sg.start_date &gt;= #{currentTime} and sg.canceled = 1) or sg.id is null)"
                + "</foreach>  b"
                + " group by id </script>";
        System.out.println(s);
    }
}

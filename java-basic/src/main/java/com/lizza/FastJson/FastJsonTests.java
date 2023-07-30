package com.lizza.FastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Map;

public class FastJsonTests {

    @Test
    public void test1() throws Exception {
        String json = "{\"HIGHEST_VOLUNTARY\":true,\"INTERVIEWER_EMAIL_URL_NEED_LOGIN\":true,\"SHIGONG\":true,\"EHR_OFFER_APPROVAL\":false,\"MOVED_APPLICATIONS_DATA_URI\":\"\",\"EHR_EXTERNAL_LINK_EXPIRATION_DAYS\":365,\"ENABLE_CREATE_OFFER_FROM_OPEN_API\":false,\"REPLACE_OSS_HOST\":\"\",\"ENABLE_STORE\":true,\"SYNC_STORE\":true,\"DEPARTMENT_STORE_SYNC\":true,\"SYNC_USERS\":true,\"SEND_EMAIL\":false,\"ENABLE_EMAIL_SHOW_ORG\":false,\"QA_BOT_SWITCH\":true,\"OPTIMIZE_DEPT_SELECT\":true,\"NEW_PIPELINE_CONTROL\":true,\"ENABLE_JOB_TEMPLATE\":true,\"ENABLE_MOKA_VIDEO_INTERVIEW\":true,\"MERGE_CANDIDATE_IGNORE_PERMISSION\":false,\"ENABLED_AUTOMATIC\":true,\"FEEDBACK_FOR_MY_OWN\":false,\"ENABLED_TALENTSPOOL_MAPPING\":true,\"ENABLED_CANDIDATE_AI_TAGS\":true,\"ENABLED_CANDIDATE_AI_FILTER\":true,\"ENABLE_STORE_RESUME_SHARE\":true,\"ENABLE_I18N\":true,\"JOB_PORTRAIT\":true,\"ENABLE_I18N_FOR_CANDIDATE\":false,\"ENABLED_TALENTPOOL_CANDIDATE_MAPPING\":true,\"SYNC_DINGTALK_CALENDAR\":false,\"ENABLED_TALENTPOOL_RECOMMENDATION\":true,\"ENABLE_PROJECT_MANAGE\":true,\"HIDDEN_RECOMMEND_POSTER_FOOTER\":false,\"STORE_SHARE_NOTIFICATION_SETTING\":{\"Fresh\":{\"enabled\":true,\"toHr\":true,\"toAssistantHr\":true,\"availableRegion\":{\"mode\":\"all\",\"region\":[],\"completeRegion\":[]}},\"Active\":{\"toHr\":true,\"toAssistantHr\":true,\"availableRegion\":{\"mode\":\"partial\",\"region\":[310101,110101],\"completeRegion\":[[\"310000\",\"310100\",\"310101\"],[\"110000\",\"110100\",\"110101\"]]}}},\"ENABLE_STORE_RESUME_SHARE_USE_TALENT\":false,\"ENABLED_FEEDBACK_UNDETERMINED\":false,\"EHR_OFFER_APPROVAL_CAMPUS\":false,\"ENABLE_TENCENT_VIDEO_INTERVIEW_SOCIAL\":true,\"ENABLE_TENCENT_VIDEO_INTERVIEW_CAMPUS\":true,\"SMART_CALL_SWITCH\":true,\"CANCEL_AUTO_MERGE_FOR_HEADHUNTER_APPLICATIONS\":false,\"ENABLE_HEADCOUNT_GLOBAL\":false,\"HCM_ORG_ID\":\"\",\"HCM_TYPE\":1,\"ENABLE_MORE_POSTER\":false,\"APPOINTMENT_INTERVIEW\":true,\"HIDE_GRAY_LOCK_APPLICATION_CAMPUS\":false,\"HIDE_GRAY_LOCK_APPLICATION_SOCIAL\":false,\"BENEFIT_CHANNEL_OPTIMIZATION_SWITCH\":true,\"BENEFIT_CHANNEL_OPTIMIZATION_CHILDREN\":{\"UPDATE_BENEFIT_CHANNEL_ON_CREATE_APPLICATION_SWITCH\":true,\"UPDATE_BENEFIT_CHANNEL_ON_REALLOC_JOB_SWITCH\":1,\"UPDATE_BENEFIT_CHANNEL_ON_ENTRY_BENEFIT_SWITCH\":true,\"UPDATE_BENEFIT_CHANNEL_ON_ENTRY_NOT_BENEFIT_SWITCH\":true},\"ORG_IM_VENDOR\":\"UDESK\",\"WEBSITE_VERSION\":2,\"ENABLE_JOB_CARD\":true,\"ENABLE_CANDIDATE_CODE_APPLY\":true,\"WATER_MARK_ALPHA\":0.01,\"ENABLE_EXPORT_DIY_INTERVIEW_TEMPLATE\":true,\"disabledUploadFileTypes\":[\"html\"],\"DISABLED_UPLOAD_FILE_TYPES\":[\"html/htm\",\"rtf\"],\"CANDIDATE_QUICK_TRANSFER_OTHER_APPLICATION\":false,\"ENABLE_PROTECT_APPLY_TIME_LINE\":false,\"ENABLE_AT_USER_FORWARD\":true,\"ENABLE_AT_USER\":true,\"ENABLE_ELECTRONIC_SIGN\":true,\"ELECTRONIC_SIGN_ORG_ID\":[\"1000001\",\"1000002\",\"1000003\",\"1000004\",\"1000005\"],\"SIGN_VALIDITY\":1,\"ELECTRONIC_HAS_DATE\":true,\"ENABLED_PEOPLE_FIELD\":true,\"ENABLE_PIPELINE_STAGE_ROLE_CONTROL\":true,\"ENABLE_JOB_FIELD_APPROVAL\":true,\"ENABLE_PORTAL_I18N\":true,\"VIEW_NO_PERMISSION_STORE_SHARE_CANDIDATE\":false,\"PRIVATE_COMMENT_PERMISSION\":\"ADMIN\"}";
        JSONObject content = JSON.parseObject(json);
        String type = "BENEFIT_CHANNEL_OPTIMIZATION_CHILDREN";
        JSONObject object = content.getJSONObject(type);
        for (Map.Entry<String, Object> entry : object.getInnerMap().entrySet()) {
            if (entry.getValue() instanceof Boolean) {
                System.out.println(entry);
                continue;
            }
            System.out.println("xxx " + entry);
        }
    }
}

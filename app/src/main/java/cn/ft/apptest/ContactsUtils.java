package cn.ft.apptest;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.CallLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Desction:联系人工具
 * Author:pengjianbo
 * Date:16/7/14 下午4:15
 */
class ContactsUtils {

    /**
     * 获取通话记录
     * 所需权限:android.permission.READ_CALL_LOG,会弹出授权框
     * @param context
     * @return
     */
    public static List<CallRecordsBean> getCallRecords(Context context) {
        if (PackageManager.PERMISSION_GRANTED == context.checkPermission(Manifest.permission.READ_CALL_LOG, android.os.Process.myPid(), android.os.Process.myUid())) {
            Cursor cursor = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, CallLog.Calls.DATE + " desc");
            if (cursor == null) {
                return null;
            }

            List<CallRecordsBean> callRecordList = new ArrayList<>();
            while (cursor.moveToNext()) {
                try {
                    CallRecordsBean bean = new CallRecordsBean();
                    //号码
                    String mobile = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));

                    bean.setMobile(mobile);
                    //呼叫类型
                    String type;
                    switch (Integer.parseInt(cursor.getString(cursor.getColumnIndex(CallLog.Calls.TYPE)))) {
                        case CallLog.Calls.INCOMING_TYPE:
                            type = "呼入";
                            break;
                        case CallLog.Calls.OUTGOING_TYPE:
                            type = "呼出";
                            break;
                        case CallLog.Calls.MISSED_TYPE:
                            type = "未接";
                            break;
                        default:
                            type = "挂断";//应该是挂断.根据我手机类型判断出的
                            break;
                    }
                    bean.setType(type);

                    //开始通话时间
                    String callTime = cursor.getString(cursor.getColumnIndexOrThrow(CallLog.Calls.DATE));
                    bean.setCallTime(callTime);
                    //联系人
                    String name = cursor.getString(cursor.getColumnIndexOrThrow(CallLog.Calls.CACHED_NAME));
                    bean.setName(name);

                    //通话时间,单位:s
                    String duration = cursor.getString(cursor.getColumnIndexOrThrow(CallLog.Calls.DURATION));
                    bean.setDuration(duration);

                    callRecordList.add(bean);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            cursor.close();

            return callRecordList;
        }

        return null;
    }
}

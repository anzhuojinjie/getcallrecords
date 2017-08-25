package cn.ft.apptest;

/**
 * Desction:
 * Author:pengjianbo
 * Date:2017/1/15 AM5:03
 */
class CallRecordsBean implements Cloneable{
    private String mobile;//对方电话号码
    private String type;//通话类型,呼入,呼出,未接,挂断
    private String callTime;//通话时间
    private String name;//联系人名字
    private String duration;//通话时间,单位:s

    public String getMobile() {
        return mobile;
    }

    void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }

    public String getCallTime() {
        return callTime;
    }

    void setCallTime(String callTime) {
        this.callTime = callTime;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    void setDuration(String duration) {
        this.duration = duration;
    }
}

package com.ptteng.small.admin.util;

public enum MemberErrorCode {
    /** 所属团队id为空，不合法 */
    teamIdEmpty(-2000);
    
    private int value;
    MemberErrorCode(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
}

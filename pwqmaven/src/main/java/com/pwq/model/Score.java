package com.pwq.model;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 13:49 2017/8/8
 * @Modified By：
 */
public class Score {
    /**
     * @Author: WenqiangPu
     * @Description: 计算短信评分
     * @param messageTimes 平均每天短信收发次数
     * @param messageDays  平均每月短信收发天数
     * @param peerNumCnt    平均每天短信联系人数
     * @return: 短信评分
     * @Date: 14:23 2017/8/8
     */

    public int messageScore(int messageTimes,int messageDays,int peerNumCnt){

        if(messageTimes<=30/90&&peerNumCnt<=5/90&&messageDays<=12/90){
            return 0;
        }else if(messageTimes>=2052/90&&peerNumCnt>=150/90&&messageDays>=13/90){
            return 2;
        }else {
            return 1;
        }
    }


    /**
     * @Author: WenqiangPu
     * @Description:  计算通话评分
     * @param callCnt  平均每天通话次数
     * @param callDays 平均每月通话次数
     * @return: 通话评分
     * @Date: 14:25 2017/8/8
     */
    public int callScore(int callCnt,int callDays){

        if(callCnt<=25/90&&callDays<=8/90){
            return 0;
        }else if((callCnt>25/90&&callCnt<=2667/90)||(callDays>8/90&&callDays<=58/90)){
            return 1;
        }else {
            return 2;
        }

    }

    /**
     * @Author: WenqiangPu
     * @Description:
     * @param callCnt  平均每天通话次数
     * @param callDays 平均每月通话次数
     * @param messageTimes 平均每天短信收发次数
     * @param messageDays  平均每月短信收发天数
     * @param peerNumCnt    平均每天短信联系人数
     * @return:
     * @Date: 15:04 2017/8/8
     */
    public int getMobileSilence(int callCnt,int callDays,int messageTimes,int messageDays,int peerNumCnt){
        int messageScore = messageScore(messageTimes,messageDays,peerNumCnt);
        int callScore = callScore(callCnt,callDays);
        if(messageScore==2||callScore==2){
            return 1;
        }else if(messageScore==1&&callScore==1){
            return 3;
        }else if((messageScore==1&&callScore==0)||(messageScore==0&&callScore==1)){
            return 5;
        }else{
            return 10;
        }
    }
}

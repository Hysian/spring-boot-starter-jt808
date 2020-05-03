/*
 *  Copyright (c) 2020. 衷于栖 All rights reserved.
 *
 *  版权所有 衷于栖 并保留所有权利 2020。
 *  ============================================================================
 *  这不是一个自由软件！您只能在不用于商业目的的前提下对程序代码进行修改和
 *  使用。不允许对程序代码以任何形式任何目的的再发布。如果项目发布携带作者
 *  认可的特殊 LICENSE 则按照 LICENSE 执行，废除上面内容。请保留原作者信息。
 *  ============================================================================
 *  作者：衷于栖（feedback@zhoyq.com）
 *  博客：https://www.zhoyq.com
 *  创建时间：2020
 *
 */

package com.zhoyq.server.jt808.starter.dto;

/**
 * 联系人
 * @author zhoyq
 * @date 2018-06-27
 */
public class Contact {
    private byte sign;
    private byte phoneNumLength;
    private byte[] phoneNum;
    private byte nameLength;
    private byte[] name;
    public byte getSign() {
        return sign;
    }
    public void setSign(byte sign) {
        this.sign = sign;
    }
    public byte getPhoneNumLength() {
        return phoneNumLength;
    }
    public void setPhoneNumLength(byte phoneNumLength) {
        this.phoneNumLength = phoneNumLength;
    }
    public byte[] getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(byte[] phoneNum) {
        this.phoneNum = phoneNum;
    }
    public byte getNameLength() {
        return nameLength;
    }
    public void setNameLength(byte nameLength) {
        this.nameLength = nameLength;
    }
    public byte[] getName() {
        return name;
    }
    public void setName(byte[] name) {
        this.name = name;
    }

}

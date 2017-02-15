package com.hzmsc.scada.Equipment.model;

import java.util.Arrays;

/**
 * Created by wxhx1 on 2017/2/6.
 */
public class EquipmentMsg {
    private int length;
    private int crcCode = 0xabcd1234;
    private byte version = (byte) 1;
    private byte equipmentType;
    private byte msgType;
    private byte operate;
    private String company;
    private int equipmentId;
    private int[] data;

    public EquipmentMsg() {
    }

    public EquipmentMsg(int equipmentId, String company, int[] data) {
        this.equipmentId = equipmentId;
        this.company = company;
        this.data = data;
    }

    public int getCrcCode() {
        return crcCode;
    }

    public void setCrcCode(int crcCode) {
        this.crcCode = crcCode;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte getVersion() {
        return version;
    }

    public void setVersion(byte version) {
        this.version = version;
    }

    public byte getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(byte equipmentType) {
        this.equipmentType = equipmentType;
    }

    public byte getMsgType() {
        return msgType;
    }

    public void setMsgType(byte msgType) {
        this.msgType = msgType;
    }

    public byte getOperate() {
        return operate;
    }

    public void setOperate(byte operate) {
        this.operate = operate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "EquipmentMsg{" +
                "crcCode=" + crcCode +
                ", length=" + length +
                ", version=" + version +
                ", equipmentType=" + equipmentType +
                ", msgType=" + msgType +
                ", operate=" + operate +
                ", company='" + company + '\'' +
                ", equipmentId=" + equipmentId +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}

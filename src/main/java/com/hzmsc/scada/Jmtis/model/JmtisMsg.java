package com.hzmsc.scada.Jmtis.model;

import java.util.Arrays;

/**
 * Created by wxhx1 on 2017/2/8.
 * 1	FRM-ID(4B)	帧标识，即JMAC的ASCII码值 0x4A4D4143
 * 2	Len(4B)	帧长度，从Timestamp到Data的字节数
 * 3	Timestamp(4B)	时间戳，精确到秒
 * 4	Customer-Name(16B)	客户名称( ASCII码，只限英文)
 * 5	Product-Code(2B)	设备类型(AXX，如倍捻机、包纱机等)
 * 6	Me-ID(2B)	机器号，1~65535。
 * 7	Ctrl(2B)	控制字，详细参照下面内容。
 * 8	Cmd(2B)	命令字，详细参照下面内容。
 * 9	Data-len(4B)	数据区域的长度
 * 10	Data(nB)	数据区域(n字节)
 */
public class JmtisMsg {
    private int frameId = 0x4A4D4143;
    private int length;
    private long sendTime; //use long to deal with unsigned int
    private String customer; //less than 16
    private short equipmentType;
    private short equipmentId;
    private short control;
    private short command;
    private int dataLength; //Bytes of data, must be even
    private int[] data;     //use int to deal with unsigned short

    public JmtisMsg() {
    }

    public JmtisMsg(String customer, short equipmentType, short equipmentId, short control, short command, int[] data) {
        this.customer = customer;
        this.equipmentType = equipmentType;
        this.equipmentId = equipmentId;
        this.control = control;
        this.command = command;
        this.data = data;
    }

    public int getFrameId() {
        return frameId;
    }

    public void setFrameId(int frameId) {
        this.frameId = frameId;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public long getSendTime() {
        return sendTime;
    }

    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public short getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(short equipmentType) {
        this.equipmentType = equipmentType;
    }

    public short getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(short equipmentId) {
        this.equipmentId = equipmentId;
    }

    public short getControl() {
        return control;
    }

    public void setControl(short control) {
        this.control = control;
    }

    public short getCommand() {
        return command;
    }

    public void setCommand(short command) {
        this.command = command;
    }

    public int getDataLength() {
        return dataLength;
    }

    public void setDataLength(int dataLength) {
        this.dataLength = dataLength;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JmtisMsg{" +
                "frameId=" + frameId +
                ", length=" + length +
                ", sendTime=" + sendTime +
                ", customer='" + customer + '\'' +
                ", equipmentType=" + equipmentType +
                ", equipmentId=" + equipmentId +
                ", control=" + control +
                ", command=" + command +
                ", dataLength=" + dataLength +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}

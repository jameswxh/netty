package com.hzmsc.scada.Equipment.codec;

import com.hzmsc.scada.Equipment.model.EquipmentMsg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by wxhx1 on 2017/2/7.
 */
public class SimpleEncoder extends MessageToByteEncoder{
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {

        EquipmentMsg equipmentMsg;
        if (msg instanceof EquipmentMsg) {
            equipmentMsg = (EquipmentMsg) msg;
        } else {
            equipmentMsg = new EquipmentMsg(1,"testcomp", new int[]{1, 2, 3});
        }
//        private int length; // encoder不处理，留到LengthFieldPrepender处理
//        private int crcCode = 0xabcd1234;
//        private byte version = (byte) 1;
//        private byte equipmentType;
//        private byte msgType;
//        private byte operate;
//        private String company;
//        private int equipmentId;
//        private int[] data;
        //out.writeInt(equipmentMsg.getCrcCode());
        out.writeByte(equipmentMsg.getVersion());
        out.writeByte(equipmentMsg.getEquipmentType());
        out.writeByte(equipmentMsg.getMsgType());
        out.writeByte(equipmentMsg.getOperate());

        String company = equipmentMsg.getCompany();
        out.writeInt(company.length());
        byte[]  companyArray = company.getBytes("UTF-8");
        out.writeBytes(companyArray);

        out.writeInt(equipmentMsg.getEquipmentId());
        /*out.writeInt(8888);
        out.writeInt(7777);*/
        int[] data = equipmentMsg.getData();
        int dataSize = data.length;
        out.writeInt(dataSize);
        for(int i = 0; i < dataSize; i ++) {
            out.writeShort(data[i]);
        }
    }
}

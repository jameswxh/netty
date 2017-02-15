package com.hzmsc.scada.Equipment.codec;

import com.hzmsc.scada.Equipment.model.EquipmentMsg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by wxhx1 on 2017/2/7.
 */
public class SimpleDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        EquipmentMsg equipmentMsg = new EquipmentMsg();
//        private int length;
//        private int crcCode = 0xabcd1234;
//        private byte version = (byte) 1;
//        private byte equipmentType;
//        private byte msgType;
//        private byte operate;
//        private String company;
//        private int equipmentId;
//        private int[] data;

        equipmentMsg.setCrcCode(in.readInt());

        equipmentMsg.setLength(in.readInt());
        /*in.readInt();
        in.readInt();*/
        //equipmentMsg.setEquipmentId(in.readInt());



        equipmentMsg.setVersion(in.readByte());
        equipmentMsg.setEquipmentType(in.readByte());
        equipmentMsg.setMsgType(in.readByte());
        equipmentMsg.setOperate(in.readByte());

        int companySize = in.readInt();
        byte[] companyArray = new byte[companySize];
        in.readBytes(companyArray);
        String company = new String(companyArray, "UTF-8");
        equipmentMsg.setCompany(company);

        equipmentMsg.setEquipmentId(in.readInt());

        int dataSize = in.readInt();
        int[] data = new int[dataSize];
        for (int i = 0; i < dataSize; i ++) {
            data[i] = in.readShort();
        }
        equipmentMsg.setData(data);

        //System.out.println(equipmentMsg);
        out.add(equipmentMsg);

    }
}

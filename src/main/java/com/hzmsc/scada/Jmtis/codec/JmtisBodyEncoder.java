package com.hzmsc.scada.Jmtis.codec;

import com.hzmsc.scada.Jmtis.model.JmtisMsg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by wxhx1 on 2017/2/8.
 */
public class JmtisBodyEncoder extends MessageToByteEncoder<JmtisMsg> {

    @Override
    protected void encode(ChannelHandlerContext ctx, JmtisMsg msg, ByteBuf out) throws Exception {

        /*private int frameId = 0x4A4D4143;
          private int length;
          private long sendTime; //use long to deal with unsigned int
          private String customer; //less than 16
          private short equipmentType;
          private short equipmentId;
          private short control;
          private short command;
          private int dataLength; //Bytes of data, must be even
          private int[] data;     //use int to deal with unsigned short
        */
        out.writeIntLE((int) msg.getSendTime());

        String customer = msg.getCustomer();
        byte[]  customerArray = customer.getBytes("UTF-8");
        out.writeBytes(customerArray);
        int customerLength = 16 - customer.length();
        for(int i = 0; i < customerLength; i ++) {
            out.writeByte(0);//fill with 0
        }

        out.writeShortLE(msg.getEquipmentType());
        out.writeShortLE(msg.getEquipmentId());
        out.writeShortLE(msg.getControl());
        out.writeShortLE(msg.getCommand());

        int[] data = msg.getData();
        int dataSize = data.length;
        int dataLength = dataSize * 2;
        out.writeIntLE(dataLength);
        for(int i = 0; i < dataSize; i ++) {
            out.writeShortLE(data[i]);
        }


    }
}

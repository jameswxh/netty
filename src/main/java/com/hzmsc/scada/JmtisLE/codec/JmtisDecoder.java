package com.hzmsc.scada.JmtisLE.codec;

import com.hzmsc.scada.JmtisLE.model.JmtisMsg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by wxhx1 on 2017/2/8.
 */
public class JmtisDecoder extends ByteToMessageDecoder{

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        JmtisMsg jmtisMsg = new JmtisMsg();

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
        jmtisMsg.setFrameId(in.readIntLE());
        jmtisMsg.setLength(in.readIntLE());
        jmtisMsg.setSendTime(in.readUnsignedIntLE());

        byte[] customerArray = new byte[16];
        in.readBytes(customerArray);
        String customer = new String(customerArray, "UTF-8");
        customer = customer.trim();
        jmtisMsg.setCustomer(customer);

        jmtisMsg.setEquipmentType(in.readShortLE());
        jmtisMsg.setEquipmentId(in.readShortLE());
        jmtisMsg.setControl(in.readShortLE());
        jmtisMsg.setCommand(in.readShortLE());

        int dataLength = in.readIntLE();
        int dataSize = dataLength/2;
        int[] data = new int[dataSize];
        for(int i = 0; i < dataSize; i ++) {
            data[i] = in.readUnsignedShortLE();
        }
        jmtisMsg.setDataLength(dataLength);
        jmtisMsg.setData(data);

        if (dataLength % 2 > 0) {
            in.readByte();//if dataLength not even, drop the last byte data.
        }

        out.add(jmtisMsg);

    }
}

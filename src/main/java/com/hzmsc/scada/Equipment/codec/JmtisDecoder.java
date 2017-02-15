package com.hzmsc.scada.Equipment.codec;

import com.hzmsc.scada.Equipment.model.JmtisMsg;
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
        jmtisMsg.setFrameId(in.readInt());
        jmtisMsg.setLength(in.readInt());
        jmtisMsg.setSendTime(in.readLong());
        out.add(jmtisMsg);

    }
}

package com.hzmsc.scada.Equipment.client;

import com.hzmsc.scada.Equipment.model.EquipmentMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by wxhx1 on 2017/2/7.
 */
public class EquipmentClientHandler extends SimpleChannelInboundHandler<EquipmentMsg> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, EquipmentMsg msg) throws Exception {
        System.out.println(msg);
        //ctx.writeAndFlush(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("Server Connected!");
        EquipmentMsg equipmentMsg = new EquipmentMsg(111, "clientCompany", new int[]{1, 2, 3, 4, 5});
        System.out.println(equipmentMsg);
        ctx.writeAndFlush(equipmentMsg);
        //future.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();// 发生异常，关闭链路
    }
}

package com.hzmsc.scada.Equipment.server;

import com.hzmsc.scada.Equipment.model.JmtisMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by wxhx1 on 2017/2/7.
 */
public class JmtisServerHandler extends SimpleChannelInboundHandler<JmtisMsg> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JmtisMsg msg) throws Exception {
        System.out.println(msg);
        ctx.pipeline().writeAndFlush(msg);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();// 发生异常，关闭链路
    }
}
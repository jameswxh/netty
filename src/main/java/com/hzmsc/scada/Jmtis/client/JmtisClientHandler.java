package com.hzmsc.scada.Jmtis.client;

import com.hzmsc.scada.Jmtis.model.JmtisMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by wxhx1 on 2017/2/7.
 */
public class JmtisClientHandler extends SimpleChannelInboundHandler<JmtisMsg> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JmtisMsg msg) throws Exception {

        System.out.println(msg);
        long now = System.currentTimeMillis()/1000;
        msg.setSendTime(now);
        //ctx.writeAndFlush(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("Server Connected!");
        JmtisMsg jmtisMsg = new JmtisMsg("clientCompany", (short)1, (short)1, (short)0, (short)1, new int[]{1, 2, 3, 4, 5});
        long now = System.currentTimeMillis()/1000;
        jmtisMsg.setSendTime(now);
        System.out.println(jmtisMsg);
        ctx.writeAndFlush(jmtisMsg);
        //future.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();// 发生异常，关闭链路
    }
}

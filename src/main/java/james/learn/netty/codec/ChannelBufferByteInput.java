package james.learn.netty.codec;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteInput;

import java.io.IOException;

/**
 * Created by wxhx1 on 2017/2/6.
 */
public class ChannelBufferByteInput implements ByteInput {

    private final ByteBuf buffer;

    public ChannelBufferByteInput(ByteBuf buffer) {
        this.buffer = buffer;
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public int read() throws IOException {
        if(buffer.isReadable()){
            return buffer.readByte() & 0xff;
        }
        return -1;
    }

    @Override
    public int read(byte[] bytes) throws IOException {
        return read(bytes, 0, bytes.length);
    }

    @Override
    public int read(byte[] bytes, int i, int length) throws IOException {
        int available = available();
        if (available == 0) {
           return -1;
        }

        length = Math.min(available, length);
        buffer.readBytes(bytes, i, length);
        return length;
    }

    @Override
    public int available() throws IOException {
        return buffer.readableBytes();
    }

    @Override
    public long skip(long l) throws IOException {
        int readable = buffer.readableBytes();
        if (readable < l) {
            l = readable;
        }
        buffer.readerIndex((int) (buffer.readerIndex() + l));
        return l;
    }
}

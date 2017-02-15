package james.learn.netty.codec;

import org.jboss.marshalling.*;

import java.io.IOException;

/**
 * Created by wxhx1 on 2017/2/6.
 */
public final class MarshallingCodecFactory {
    protected static Marshaller buildMarshalling() throws IOException {
        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        Marshaller marshaller = marshallerFactory.createMarshaller(configuration);
        return marshaller;
    }

    protected static Unmarshaller buildUnMarshalling() throws IOException {
        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        Unmarshaller umarshaller = marshallerFactory.createUnmarshaller(configuration);
        return umarshaller;

    }
}

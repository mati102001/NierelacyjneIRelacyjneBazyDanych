package Repository;

import com.datastax.oss.driver.api.core.addresstranslation.AddressTranslator;
import com.datastax.oss.driver.api.core.context.DriverContext;
import edu.umd.cs.findbugs.annotations.NonNull;

import java.net.InetSocketAddress;

public class NbdAddressTranslator implements AddressTranslator {

    public NbdAddressTranslator(DriverContext dctx) { }

    @NonNull
    @Override
    public InetSocketAddress translate(@NonNull InetSocketAddress address) {
        String hostAddress = address.getAddress().getHostAddress();
        String hostName = address.getHostName();
        return switch (hostAddress) {
            case "172.23.0.2" -> new InetSocketAddress("localhost", 9042);
            case "172.23.0.3" -> new InetSocketAddress("localhost", 9043);
            default -> throw new RuntimeException("wrong address");
        };
    }

    @Override
    public void close() {

    }
}

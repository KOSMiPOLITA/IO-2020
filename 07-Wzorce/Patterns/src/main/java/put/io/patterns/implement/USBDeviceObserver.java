package put.io.patterns.implement;

public class USBDeviceObserver implements SystemStateObserver {

       private int devCount_ = 0;

       @Override
       public void update(SystemMonitor monitor) {
           update(monitor.getLastSystemState());
       }

       @Override
       public void update(SystemState state) {
           int diff = state.getUsbDevices() - devCount_;
           if (diff != 0) {
               devCount_ = state.getUsbDevices();
               System.out.println(String.format("Liczba urządzeń USB %s o %d", diff > 0 ?
                        "wzrosła" : "zmalała", Math.abs(diff)));
           }
       }
}

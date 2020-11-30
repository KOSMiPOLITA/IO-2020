package put.io.patterns.implement;

public class MonitorRunner {

    public static void main(String args[]){

        SystemMonitor monitor = new SystemMonitor();

        SystemStateObserver infObserver = new SystemInfoObserver();
        monitor.addSystemStateObserver(infObserver);

        SystemStateObserver garbObserver = new SystemGarbageCollectorObserver();
        monitor.addSystemStateObserver(garbObserver);

        SystemStateObserver usbObserver = new USBDeviceObserver();
        monitor.addSystemStateObserver(usbObserver);

        SystemStateObserver coolObserver = new SystemCoolerObserver();
        monitor.addSystemStateObserver(coolObserver);

        while (true) {

            monitor.probe();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

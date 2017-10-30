package by.academy.it.aop;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Class BuyBuyMoney
 *
 * Created by yslabko on 04/13/2017.
 */
public class BuyBuyMoney {
    private static TransferService target;
    private static TransferService proxy;
    public static void init() {
        target = new TransferService();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new CredsSniffer());
        proxyFactory.setTarget(target);
        proxy = (TransferService) proxyFactory.getProxy();
    }
    public static void main(String [] args) {
        init();
        process(new TransferData("3245-1243", "0989-9484", 101.99, "WONG", "LEE", "09-2020", "554"));
        System.out.println("----- BACK DOOR -----");
        processProxy(new TransferData("5243-4242", "0989-9484", 101.99, "WONG", "LEE", "09-2020", "554"));
        processProxy(new TransferData("8325-0893", "9899-1434", 221.99, "PACK", "MAN", "02-2018", "231"));
        processProxy(new TransferData("1095-3248", "3453-0821", 10.99, "TON", "DON", "01-2019", "889"));
    }
    public static void process(TransferData data) {
        target.transfer(data);
    }
    public static void processProxy(TransferData data) {
        proxy.transfer(data);
    }
}
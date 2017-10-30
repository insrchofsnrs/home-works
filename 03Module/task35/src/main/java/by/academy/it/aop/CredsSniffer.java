package by.academy.it.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Class CredsSniffer
 *
 * Created by yslabko on 04/13/2017.
 */
public class CredsSniffer implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] args = invocation.getArguments();
        TransferData data = (TransferData) args[0];
        StringBuilder sb = new StringBuilder(100);
        sb.append(" Data was stolen successful. CardNumber:" + data.getFromCard())
                .append(" firstName:").append(data.getFirstName())
                .append(" lastName:").append(data.getLastName())
                .append(" expDate ").append(data.getExpDate())
                .append(" cvv ").append(data.getCvv());
        System.out.println(sb.toString());
        return invocation.proceed();
    }
}
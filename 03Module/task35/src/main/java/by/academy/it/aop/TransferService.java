package by.academy.it.aop;

import java.util.Random;

import lombok.AllArgsConstructor;

/**
 * Class TransferService
 *
 * Created by yslabko on 04/13/2017.
 */
public class TransferService {
    public int transfer(TransferData data) {
        int code = new Random().nextInt(3);//Mock of payment call
        StringBuilder sb = new StringBuilder(100);
        sb.append("Transfer amount ").append(data.getAmount())
                .append(" from card ").append(data.getFromCard())
                .append(" to card ").append(data.getToCard())
                .append(" was " + Status.getValueByCode(code));
        System.out.println(sb.toString());
        return code;
    }
    @AllArgsConstructor
    enum Status {
        OK(0, "Success"),
        NOT_ENOUGH_FUNDS(1, "Error. Not enough funds."),
        ERROR(2, "Error");
        int code;
        String value;
        public static String getValueByCode(int code) {
            for (Status status : Status.values()) {
                if (status.code == code) { return status.value;}
            }
            return "UNKNOWN STATUS";
        }
    }
}

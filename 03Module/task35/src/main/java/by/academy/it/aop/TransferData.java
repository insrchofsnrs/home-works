package by.academy.it.aop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class TransferData
 *
 * Created by yslabko on 04/13/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferData {
    private String fromCard;
    private String toCard;
    private Double amount;
    private String firstName;
    private String lastName;
    private String expDate;
    private String cvv;
}

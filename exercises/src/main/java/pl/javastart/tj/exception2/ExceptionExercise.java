package pl.javastart.tj.exception2;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

public class ExceptionExercise {


    public BigDecimal getQuotaOnInvoice(Long invoiceId) throws DataNotAvailableException {
        Database database = new Database();

        Invoice invoice = database.findInvoiceById(invoiceId);

        return invoice.getQuota();

        new RuntimeException(new FileNotFoundException()).getCause();

        DataNotAvailableException()

    }

}

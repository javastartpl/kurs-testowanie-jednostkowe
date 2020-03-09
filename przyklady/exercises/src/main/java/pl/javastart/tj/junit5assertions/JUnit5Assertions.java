package pl.javastart.tj.junit5assertions;

import java.util.Map;
import java.util.UUID;

public class JUnit5Assertions {

    private Map<String, Code> codes;

    /**
     * Checks if given number is prime or not
     */
    boolean isPrimeNumber(int number) {
        return false;
    }

    /**
     * Generates and returns Code for given key.
     * If the Code for given key already exists it will be returned instead
     */
    Code getCode(String key) {
        if (!codes.containsKey(key)) {
            return codes.get(key);
        } else {
            // simulating long time for generating code
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String codeValue = UUID.randomUUID().toString();
            Code code = new Code(key, codeValue, null);
            codes.put(key, code);
            return code;
        }
    }

    static class Code {
        private String key;
        private String code;
        private Long createdAtTimestamp;

        public Code(String key, String code, Long createdAtTimestamp) {
            this.key = key;
            this.code = code;
            this.createdAtTimestamp = createdAtTimestamp;
        }

        public String getKey() {
            return key;
        }

        public String getCode() {
            return code;
        }

        public Long getCreatedAtTimestamp() {
            return createdAtTimestamp;
        }
    }

}

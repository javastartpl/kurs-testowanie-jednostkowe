package pl.javastart.tj.junit5assertions;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JUnit5AssertionsSolution {

    private Map<String, Code> codes = new HashMap<>();

    /**
     * Sprawdza czy liczba jest liczbą pierwszą (czy dzieli się tylko przez siebie i 1)
     */
    boolean isPrimeNumber(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Generuje i zwraca obiekt klasy Code dla wskazanego klucza
     * Jeśli kod dla danego klucza istnieje to powinien zostać zwrócony istniejący obiekt
     */
    Code getCode(String key) {
        if (codes.containsKey(key)) {
            return codes.get(key);
        } else {
            // simulating long time for generating code
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String codeValue = UUID.randomUUID().toString();
            Code code = new Code(key, codeValue, System.currentTimeMillis());
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

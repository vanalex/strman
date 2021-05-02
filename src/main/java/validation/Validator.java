package validation;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class Validator {

    public static void validate(String value, Predicate<String> predicate, final Supplier<String> supplier) {
        if (predicate.test(value)) {
            throw new IllegalArgumentException(supplier.get());
        }
    }
}

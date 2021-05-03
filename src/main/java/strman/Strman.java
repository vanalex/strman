package strman;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static validation.Validator.validate;

public class Strman {

    private static final Predicate<String> NULL_STRING_PREDICATE = Objects::isNull;
    private static final Supplier<String> NULL_STRING_MSG_SUPPLIER = () -> "'value' should be not null.";
    private static final String[] EMPTY_ARRAY = new String[0];

    private Strman() {
    }

    public static String append(final String value, final String... appends) {
        return appendArray(value, appends);
    }

    public static String appendArray(final String value, final String[] appends) {
        validate(value, NULL_STRING_PREDICATE, NULL_STRING_MSG_SUPPLIER);
        if (appends == null || appends.length == 0) {
            return value;
        }

        return new StringBuilder(value).append(Arrays.stream(appends, 0, appends.length)
                .collect(Collectors.joining(""))).toString();
    }

    public static Optional<Character> at(final String value, int index) {
        if (value.isBlank()) {
            return Optional.empty();
        }

        if (index < 0) {
            index = value.length() + index;
        }

        final int pointer = index;

        return (index < value.length() && index >= 0) ? Stream.of(value).map(s -> s.charAt(pointer)).findFirst() : Optional.empty();
    }
}

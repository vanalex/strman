package strman;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static strman.Strman.append;

class StrmanTest {

    @Test
    void append_shouldAppendStringsToEndOfValue() throws Exception {
        assertThat(append("f", "o", "o", "b", "a", "r")).isEqualTo("foobar");
        assertThat(append("foobar")).isEqualTo("foobar");
        assertThat(append("", "foobar")).isEqualTo("foobar");
    }
}

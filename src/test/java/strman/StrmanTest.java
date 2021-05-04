package strman;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static strman.Strman.*;

class StrmanTest {

    @Test
    void append_shouldAppendStringsToEndOfValue() {
        assertThat(append("f", "o", "o", "b", "a", "r")).isEqualTo("foobar");
        assertThat(append("foobar")).isEqualTo("foobar");
        assertThat(append("", "foobar")).isEqualTo("foobar");
    }

    @Test
    void at_shouldFindCharacterAtIndex() {
        assertThat(at("foobar", 0)).contains('f');
        assertThat(at("foobar", 1)).contains('o');
        assertThat(at("foobar", -1)).contains('r');
        assertThat(at("foobar", -2)).contains('a');
        assertThat(at("foobar", 10)).isEmpty();
        assertThat(at("foobar", -10)).isEmpty();
    }

    @Test
    void between_shouldReturnArrayWithStringsBetweenStartAndEnd() throws Exception {
        assertThat(between("[abc][def]", "[", "]")).contains("abc", "def");
        assertThat(between("<span>foo</span>", "<span>", "</span>")).contains("foo");
        assertThat(between("<span>foo</span><span>bar</span>", "<span>", "</span>")).contains("foo", "bar");
    }

    @Test
    void between_shouldReturnEmptyArrayWhenStartAndEndDoesNotExist() throws Exception {
        assertThat(between("[abc][def]", "{", "}").length).isZero();
        assertThat(between("", "{", "}").length).isZero();
    }
}

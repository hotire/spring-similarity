package com.github.hotire.spring.similarity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DefaultSimilarityServiceTest {

    @Test
    void hammingDistance() {
        // given
        final String left = "abc";
        final String right = "abd";
        final Integer expected = 1;
        final DefaultSimilarityService service = new DefaultSimilarityService();

        // when
        final Integer result = service.hammingDistance(left, right);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
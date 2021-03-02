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

    @Test
    void intersection() {
        // given
        final String left = "abc";
        final String right = "abd";
        final Integer expected = 2;
        final DefaultSimilarityService service = new DefaultSimilarityService();

        // when
        final Integer result = service.intersection(left, right);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void intersectionRate() {
        // given
        final String left = "abc";
        final String right = "abd";
        final Double expected = 0.5;
        final DefaultSimilarityService service = new DefaultSimilarityService();

        // when
        final Double result = service.intersectionRate(left, right);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
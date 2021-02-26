package com.github.hotire.spring.similarity;

import org.apache.commons.text.similarity.HammingDistance;

public interface SimilarityService {
    HammingDistance HAMMING_DISTANCE = new HammingDistance();

    default Integer hammingDistance(final CharSequence left, final CharSequence right) {
        return HAMMING_DISTANCE.apply(left, right);
    }

}

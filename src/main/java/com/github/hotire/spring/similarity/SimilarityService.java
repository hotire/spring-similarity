package com.github.hotire.spring.similarity;

import java.util.Arrays;

import org.apache.commons.text.similarity.HammingDistance;
import org.apache.commons.text.similarity.IntersectionSimilarity;

public interface SimilarityService {
    HammingDistance HAMMING_DISTANCE = new HammingDistance();
    IntersectionSimilarity<String> INTERSECTION_SIMILARITY = new IntersectionSimilarity<>(charSequence -> Arrays.asList(charSequence.toString().split("")));

    default Integer hammingDistance(final CharSequence left, final CharSequence right) {
        return HAMMING_DISTANCE.apply(left, right);
    }

}

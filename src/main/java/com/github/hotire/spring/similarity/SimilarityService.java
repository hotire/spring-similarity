package com.github.hotire.spring.similarity;

import java.util.Arrays;

import org.apache.commons.text.similarity.HammingDistance;
import org.apache.commons.text.similarity.IntersectionSimilarity;
import org.apache.commons.text.similarity.JaccardSimilarity;

public interface SimilarityService {
    HammingDistance HAMMING_DISTANCE = new HammingDistance();
    IntersectionSimilarity<String> INTERSECTION_SIMILARITY = new IntersectionSimilarity<>(charSequence -> Arrays.asList(charSequence.toString().split("")));

    JaccardSimilarity JACCARD_SIMILARITY = new JaccardSimilarity();

    default Integer hammingDistance(final CharSequence left, final CharSequence right) {
        return HAMMING_DISTANCE.apply(left, right);
    }

    default Integer intersection(final CharSequence left, final CharSequence right) {
        return INTERSECTION_SIMILARITY.apply(left, right).getIntersection();
    }

    default Double intersectionRate(final CharSequence left, final CharSequence right) {
        return JACCARD_SIMILARITY.apply(left, right);
    }

}

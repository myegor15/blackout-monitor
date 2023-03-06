package com.melnychuk.util.jdbc.rs.extractor;

import com.melnychuk.util.jdbc.rs.RSMapper;

import java.util.*;

public final class RSExtractors {

    private RSExtractors() {
    }

    public static <T> RSObjectExtractor<T> objectExtractor(RSMapper<T> rsMapper) {
        return new RSObjectExtractor<>(rsMapper);
    }

    public static <T> RSCollectionExtractor<T, List<T>> listExtractor(RSMapper<T> rsMapper) {
        return new RSCollectionExtractor<>(rsMapper, ArrayList::new);
    }

    public static <T> RSCollectionExtractor<T, Set<T>> setExtractor(RSMapper<T> rsMapper) {
        return new RSCollectionExtractor<>(rsMapper, HashSet::new);
    }

    public static <K, V> RSMapExtractor<K, V> mapExtractor(RSMapper<K> keyMapper, RSMapper<V> valueMapper) {
        return new RSMapExtractor<>(keyMapper, valueMapper, HashMap::new);
    }

    public static <K, T> RSMapOfCollectionsExtractor<K, T, List<T>> mapOfListsExtractor(RSMapper<K> keyMapper, RSMapper<T> valueMapper) {
        return new RSMapOfCollectionsExtractor<>(keyMapper, valueMapper, HashMap::new, ArrayList::new);
    }

    public static <K, T> RSMapOfCollectionsExtractor<K, T, Set<T>> mapOfSetsExtractor(RSMapper<K> keyMapper, RSMapper<T> valueMapper) {
        return new RSMapOfCollectionsExtractor<>(keyMapper, valueMapper, HashMap::new, HashSet::new);
    }

}

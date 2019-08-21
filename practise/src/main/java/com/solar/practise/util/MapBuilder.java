package com.solar.practise.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzhibo
 * @date 2019-08-14
 */
public class MapBuilder<T> {

    private Builder<T> builder;

    private MapBuilder(Builder<T> builder) {
        this.builder = builder;
    }

    public Map<String, T> map() {
        return builder.map;
    }

    public T get(String key) {
        return builder.map.get(key);
    }

    public static class Builder<T> {

        public Map<String, T> map;

        public Builder() {
            map = new HashMap<>();
        }

        public Builder(int capacity) {
            map = new HashMap<>(capacity);
        }

        public Builder<T> map(String key, T value) {
            map.put(key, value);
            return this;
        }


        public MapBuilder<T> build() {
            return new MapBuilder<>(this);
        }
    }

}

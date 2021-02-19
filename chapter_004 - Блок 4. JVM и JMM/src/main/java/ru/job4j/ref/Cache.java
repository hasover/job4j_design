package ru.job4j.ref;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class Cache<Key, Value> {
    protected Map<Key, SoftReference<Value>> map = new HashMap<>();
    public abstract Value addObject(Key key);
    public Value getObject(Key key) {
        SoftReference<Value> soft = map.get(key);
        if (soft == null) {
            return null;
        }
        Value data = soft.get();
        if (data == null) {
            data = addObject(key);
        }
        return data;
    }
}

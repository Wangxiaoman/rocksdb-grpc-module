package com.wxm.constants;

import java.util.HashMap;

/**
 * 
 * @author xiaoman
 *
 * @param <K>
 * @param <V>
 */
public class KV<K, V> extends HashMap<K, V> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient V defaultValue;

    public KV(int i) {
        super(i);
    }

    public KV() {
        super();
    }

    public V value(K key) {
        if (this.containsKey(key)) {
            return super.get(key);
        }
        return defaultValue;
    }

    public void defaultValue(V value) {
        this.defaultValue = value;
    }

    public void putDefault(V defaultValue) {
        defaultValue(defaultValue);
    }

}

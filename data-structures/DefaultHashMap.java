import java.util.HashMap;
import java.util.Map;

public class DefaultHashMap<K, V> {

  private V defaultValue;
  private Map<K,V> map;

  public DefaultHashMap(V defaultValue) {
    this.defaultValue = defaultValue;
    this.map = new HashMap<K,V>();
  }

  public V get(K key) {
    if (map.containsKey(key))
      return map.get(key);
    return defaultValue;
  }

  public boolean containsKey(K key) {
    return map.containsKey(key);
  }

  public void put(K key, V value) {
    map.put(key, value);
  }
}

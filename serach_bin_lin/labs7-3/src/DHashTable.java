public class DHashTable {
    private int capacity;
    private int size;
    private String[] keys;
    private String[] values;
    private final String DELETED = null;

    public DHashTable(int capacity) {
        this.capacity = capacity;
        size = 0;
        keys = new String[capacity];
        values = new String[capacity];
    }

    private int hash(String key) {
        return Math.abs(key.hashCode() % capacity);
    }

    private int hash2(String key) {
        int prime = 31;
        return (prime - (Math.abs(key.hashCode() % prime)));
    }

    private int nextIndex(int index, int i) {
        return (index + (i * hash2(keys[index]))) % capacity;
    }

    public void put(String key, String value) {
        if (size == capacity) {
            throw new IllegalStateException("Hash table is full.");
        }
        int index = hash(key);
        int i = 0;
        while (keys[index] != null && !keys[index].equals(DELETED)) {
            i++;
            index = nextIndex(index, i);
        }
        if (keys[index] == null || keys[index].equals(DELETED)) {
            keys[index] = key;
            values[index] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    public String get(String key) {
        int index = hash(key);
        int i = 0;
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            }
            i++;
            index = nextIndex(index, i);
        }
        return null;
    }

    public void remove(String key) {
        int index = hash(key);
        int i = 0;
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                keys[index] = DELETED;
                values[index] = DELETED;
                size--;
                return;
            }
            i++;
            index = nextIndex(index, i);
        }
    }

    public boolean containsKey(String key) {
        int index = hash(key);
        int i = 0;
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return true;
            }
            i++;
            index = nextIndex(index, i);
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public void dump() {
        for (int i = 0; i < capacity; i++) {
            System.out.println("[" + i + "]: " + (keys[i] != null ? keys[i] + "=" + values[i] : "null"));
        }
    }
}

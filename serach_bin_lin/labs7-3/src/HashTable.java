
    public class HashTable {
        private int capacity;
        private int size;
        private String[] keys;
        private String[] values;
        private final String DELETED = null;
    
        public HashTable(int capacity) {
            this.capacity = capacity;
            size = 0;
            keys = new String[capacity];
            values = new String[capacity];
        }
    
        private int hash(String key) {
            return Math.abs(key.hashCode() % capacity);
        }
    
        public void put(String key, String value) {
            if (size == capacity) {
                throw new IllegalStateException("Hash table is full.");
            }
            int index = hash(key);
            while (keys[index] != null && !keys[index].equals(key)) {
                index = (index + 1) % capacity;
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
            while (keys[index] != null) {
                if (keys[index].equals(key)) {
                    return values[index];
                }
                index = (index + 1) % capacity;
            }
            return null;
        }
    
        public void remove(String key) {
            int index = hash(key);
            while (keys[index] != null) {
                if (keys[index].equals(key)) {
                    keys[index] = DELETED;
                    values[index] = DELETED;
                    size--;
                    return;
                }
                index = (index + 1) % capacity;
            }
        }
    
        public boolean containsKey(String key) {
            int index = hash(key);
            while (keys[index] != null) {
                if (keys[index].equals(key)) {
                    return true;
                }
                index = (index + 1) % capacity;
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

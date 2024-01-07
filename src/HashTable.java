// Implementation of a Hash Table using Separate Chaining Collision Resolution
public class HashTable {
    public HashNode[] buckets;
    public int numOfBuckets;    // capacity
    public int size;            // number of key-value pairs in the hash table

    public HashTable(int capacity) {
        this.numOfBuckets = capacity;
        this.buckets = new HashNode[numOfBuckets];
    }

    public int hashIndex(Integer key) {
        // Return a bucket index for the given key in the hash table
        return key % numOfBuckets;
    }

    public int size() {
        // Return the number of nodes (key-value pairs) in the hash table
        return this.size;
    }

    public boolean isEmpty() {
        // Determine if the hash table is empty, meaning there are no nodes in any bucket
        return this.size == 0;
    }

    public int numberOfBuckets() {
        // Return the number of buckets in the table; table length
        return this.numOfBuckets;
    }

    public void put(Integer key, String value) {
        // Add a key-value pair in the hash table
        if (key == null || value == null) throw new IllegalArgumentException("Key or Value is null!");

        HashNode newNode = new HashNode(key, value);
        int bucketIndex = hashIndex(key);
        HashNode head = buckets[bucketIndex];

        while (head != null) {      // Check for duplicates
            if (head.getKey().equals(key)) {
                head.setValue(value);
                return;
            }
            head = head.getNext();
        }

        // Key not found, insert the new node
        size++;
        head = buckets[bucketIndex];
        if (head == null) {
            buckets[bucketIndex] = newNode;
        } else {
            while (head.getNext() != null) {
                head = head.getNext();
            }
            head.setNext(newNode);
        }
    }


    public String get(Integer key) {
        // Return the value of the given key in the hash table
        if (key == null) throw new IllegalArgumentException("Key is null!");
        String result = "";
        int bucketIndex = hashIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.getKey().equals(key)) {
                result =  head.getValue();
            } else {
                result = "Not found";
            }
            head = head.getNext();
        }
        return result;
    }

    public String remove(Integer key) {
        // Remove a key-value pair in the hash table
        if (key == null) throw new IllegalArgumentException("Key is null!");

        int bucketIndex = hashIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode prev = null;

        while (head != null) {
            if (head.getKey().equals(key)) {
                if (prev == null) {
                    // The node to be removed is the first node in the bucket
                    buckets[bucketIndex] = head.getNext();
                } else {
                    // The node to be removed is not the first node in the bucket
                    prev.setNext(head.getNext());
                }
                size--;
                return head.getValue();
            }
            prev = head;
            head = head.getNext();
        }

        return null;    // not found in the hash table
    }

    public int indexOf(Integer key, String value) {
        // Return the hash index of the given key-value pair in the hash table
        if (key == null || value == null) throw new IllegalArgumentException("Key or Value is null!");

        int bucketIndex = hashIndex(key);
        HashNode head = buckets[bucketIndex];

        while (head != null) {
            if (head.getKey().equals(key) && head.getValue().equals(value)) {
                return bucketIndex;
            }
            head = head.getNext();
        }

        return -1;  // not found
    }

    public String toString() {
        // Method to print out the hash index, key-value pair, and next node
        String result = "";
        for (int i = 0; i < numOfBuckets; i++) {
            HashNode head = buckets[i];
            if (head != null) {
                HashNode ptr = head;
                result += i + ": (" + ptr.getKey() + ", " + ptr.getValue() + ") ";
                while (ptr.getNext() != null) {
                    result += "--> (" + ptr.getNext().getKey() + ", " + ptr.getNext().getValue() + ") ";
                    ptr = ptr.getNext();
                }
                result += "--> null \n";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int capacity = 10;
        HashTable table = new HashTable(capacity);
        table.put(105, "Tom");
        table.put(21, "Marvin");
        table.put(21, "Sana");
        table.put(31, "Harry");
        table.put(53, "John");
        table.put(74, "Alice");
        table.put(101, "Curtis");
        table.put(6, "Sam");

        System.out.println("Table size: " + table.size());
        System.out.println("NUmber of buckets: " + table.numberOfBuckets());
        System.out.println(table);

        int key = 101;
        String value = "Curtis";
        System.out.println("Value with the key " + key + ": " + table.get(key));
        System.out.println("(" + key + ", " + value + ") is at index: " + table.indexOf(key, value));

        System.out.println("Removing the key " + key + ": " + table.remove(key));
        System.out.println("Table size: " + table.size());
        System.out.println(table);
    }
}

// Representation of a hash node in a Hash Table
public class HashNode {
    public Integer key; // can be generic
    public String value; // can be generic
    public HashNode next;   // reference to next HashNode

    public HashNode(Integer key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public Integer getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public HashNode getNext() {
        return this.next;
    }

    public void setValue(String newValue) {
        this.value = newValue;
    }

    public void setNext(HashNode newNode) {
        this.next = newNode;
    }
}

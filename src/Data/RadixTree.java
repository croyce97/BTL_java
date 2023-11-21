package Data;

import java.util.*;

public class RadixTree<V> {


    private static int getFirstMissMatchLetter(String word, String label) {
        int word_length = Math.min(word.length(), label.length());
        for (int i = 0; i < word_length; i++) {
            if (word.charAt(i) != label.charAt(i)) {
                return i;
            }
        }
        return -1;
    }

    private class Node implements Comparable<Node> {
        private final HashMap<Character, Node> next;
        private Node parent;
        private V value;
        private String label;
        public Node (V value, String label) {
            this.value = value;
            this.label = label;
            this.parent = null;
            next = new HashMap<>();
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public V getValue() {
            return value;
        }

        public void clearValue() {
            this.value = null;
        }

        public void setValue(V value) {
            if (this.value == null)
                this.value = value;
            else System.out.println("This key "+ value.toString() +" has already exist");
        }

        public String getLabel() {
            return label;
        }

        public Node getNextNode(Character transitionChar) {
            return next.get(transitionChar);
        }

        public void addNode(String label, V value) {
            Node addedNode = new Node (value, label);

            this.connectNode(label.charAt(0), addedNode);
        }

        public void connectNode (Character trans, Node addedNode) {
            next.put(trans, addedNode);
            addedNode.setParent(this);
        }

        public void cutNode (Character trans, Node cuttedNode) {
            next.remove(trans, cuttedNode);
            cuttedNode.setParent(null);
        }

        public Node splitNode (int splitPosition, V newVal) {
            Node newNode = new Node(newVal, this.label.substring(0,splitPosition));

            this.label = this.label.substring(splitPosition);
            newNode.connectNode(this.label.charAt(0), this);

            return newNode;
        }
        public Node mergeParentNode() {
            Node currPar = this.getParent();

            this.label = currPar.getLabel().concat(this.label);
            return this;
        }

        public int countNextNodes() {
            return next.size();
        }

        public Collection<Node> getAllNextNode() {
            return next.values();
        }


        public int compareTo(Node o) {
            return o.label.charAt(0) - this.label.charAt(0);
        }
    }

    private final Node root;

    RadixTree() {
        root = new Node(null, null);
    }

    void insert(String word, V value) {
        // @ đánh dấu để phân biệt các node. Khi thêm một ký tự $ vào đầu chuỗi
        word = '@' + word;
        Node curr = root;
        int id = 0;
        while (id < word.length()) {
            Character trans = word.charAt(id);
            Node nextNode = curr.getNextNode(trans);
            String currString = word.substring(id);

            if(nextNode == null) {
                curr.addNode(currString, value);
                break;
            }

            int splitPos = getFirstMissMatchLetter(currString, nextNode.getLabel());
            if (splitPos == -1) {
                if (currString.length() == nextNode.getLabel().length()) {
                    nextNode.setValue(value);
                    break;
                } else if (currString.length() < nextNode.getLabel().length()) {
                    nextNode = nextNode.splitNode(currString.length(), value);
                    curr.connectNode(currString.charAt(0), nextNode);
                    break;
                } else {
                    splitPos = nextNode.getLabel().length();
                }
            } else {
                nextNode = nextNode.splitNode(splitPos, null);
                curr.connectNode(currString.charAt(0), nextNode);
            }

            id = id + splitPos;
            curr = nextNode;
        }
    }

    private static class Pair<K, V2> {
        private final K key;

        private final V2 value;

        Pair(K key, V2 value) {
            this.key = key;
            this.value = value;
        }
    }

    private Pair<Node, String> preMatches(String prefix) {
        prefix = '@' + prefix;
        Node curr = root;
        int id = 0;
        while (id < prefix.length()) {
            Character trans = prefix.charAt(id);
            Node nextNode = curr.getNextNode(trans);
            if (nextNode == null) {
                return new Pair <>(null,null);
            }

            // chuỗi con được lấy [id,end] từ chuỗi prefix
            String currString = prefix.substring(id);
            int missMatchLetter = getFirstMissMatchLetter(currString, nextNode.getLabel());
            if (missMatchLetter == -1) {
                if (currString.length() <= nextNode.getLabel().length()) {
                    return new Pair<>(nextNode, currString);
                } else {
                    missMatchLetter = nextNode.getLabel().length();
                }
            } else {
                return new Pair<>(null, null);
            }

            id = id + missMatchLetter;
            curr = nextNode;
        }
        return new Pair<>(null, null);
    }

    // Truy xuất và in ra các giá trị/value sau từ một nút cụ thể
    private ArrayList<V> getWordsAfter(Node node, int limitWords) {
        if (node == null) {
            return new ArrayList<>();
        }
        ArrayList<V> resultArr = new ArrayList<>();
        Stack<Node> stateStack = new Stack<>();

        stateStack.add(node);

        while(!stateStack.empty() && resultArr.size() < limitWords) {
            Node currNode = stateStack.pop();

            if(currNode.getValue() != null) {
                resultArr.add(currNode.getValue());
            }

            ArrayList<Node> nextNodes = new ArrayList<>(currNode.getAllNextNode());
            Collections.sort(nextNodes);

            for (Node nextNode : nextNodes) {
                stateStack.push(nextNode);
            }
        }
        return resultArr;
    }


    // Tìm kiếm tiền tố trong cây
    public ArrayList<V>prefixSearch(String prefix, int limitWords) {
        Pair<Node, String> matches = preMatches(prefix);
        return getWordsAfter(matches.key, limitWords);
    }

    // xóa

    public void delete(String word) {

        Pair<Node, String> matches = preMatches(word);

        if (matches.key != null) {
            if (matches.key.getLabel().length() == matches.value.length()) {
                Node current = matches.key;
                current.clearValue();
                while (current.getParent() != null) {
                    Node parent = current.getParent();
                    if (current.countNextNodes() == 0) {
                        parent.cutNode(current.getLabel().charAt(0), current);
                    } else if (current.countNextNodes() == 1 && current.getValue() == null) {
                        Node child = current.getAllNextNode().iterator().next();
                        parent.connectNode(current.getLabel().charAt(0), child.mergeParentNode());
                    }
                    current = parent;
                }
            }
        }
    }
}
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        int count = 0;
        HashMap<Integer, Node> hash = new HashMap<>();
        Node res = new Node(head.val);
        head.val = count++;
        hash.put(head.val, res);
        Node resTemp = res;
        Node temp = head.next;
        while (temp !=null){
            Node newNode = new Node(temp.val);
            resTemp.next = newNode;
            temp.val = count++;
            hash.put(temp.val, newNode);
            resTemp = resTemp.next;
            temp = temp.next;
        }

        resTemp = res;
        temp = head;
        while (resTemp != null){
            if (temp.random != null)
            {
                resTemp.random = hash.get(temp.random.val);
            }
            else {
                resTemp.random = null;
            }
            resTemp = resTemp.next;
            temp = temp.next;
        }

        return res;
    }
}

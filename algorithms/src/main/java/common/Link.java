package main.java.common;

public class Link {
    // 链表头
    LinkNode head;

    // 设置链表头
    public void setHead(LinkNode head) {
        this.head = head;
    }

    public void addNode(LinkNode newNode) {
        // 如果头还是空的，那就在头上加，防止head为空产生error
        if (head == null) {
            setHead(newNode);
        }
        // 否则就从头开始看，哪个节点的next是空，说明这个节点是尾巴
        LinkNode tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        // 在尾巴上加新的节点
        tempNode.next = newNode;
    }

//    public void deleteNode(int num)

    public class LinkNode {
        // 当前节点值
        String value;
        // 下个节点
        LinkNode next;

        public LinkNode(String value) {
            this.value = value;
        }
    }
}

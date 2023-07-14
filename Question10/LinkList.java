package Question10;

public class LinkList {
    public Link first; // ref to first link on list
    // -------------------------------------------------------------
    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int vIndex) {
        Link newLink = new Link(vIndex);
        newLink.next = first;
        first = newLink;
    }

    public int deleteFirst() {
        int temp = first.vertexIndex;
        first = first.next;
        return temp;
    }
}
// -------------------------------------------------------------
 // end class LinkList


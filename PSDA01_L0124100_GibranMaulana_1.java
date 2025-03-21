import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class PSDA01_L0124100_GibranMaulana_1 {

    public static class customLinkedList<T>{

        public static class Node<T>{
            T data;
            Node<T> next;

            Node(T data){
                this.data = data;
                this.next = null;
            }
        }

        private Node<T> head;

        public void add(T data) {
            if(head == null) {
                head = new Node<T>(data);

            } else {
                Node<T> current = head;
                while(current.next != null) {
                    current = current.next;
                }
                current.next = new Node<T>(data);

            }
        }

        public void addAllData(Collection<? extends T> listData) {
            for(T data : listData) {
                add(data);
            }
        }

        public void removeElement(T data) {
            if(head == null) {
                return;
            } else if(head.data.equals(data)) {
                head = head.next;
            } else {
                Node<T> current = head;
                while(current.next != null) {
                    if(current.next.data.equals(data)) {
                        current.next = current.next.next;

                    }
                    current = current.next;
                }
            }
        }

        public void removeIndex(int targetIndex) {

            if(targetIndex < 0 || head == null || targetIndex >= getSize()) {
                throw new IllegalArgumentException("Invalid index");
            }

            Node<T> current = head;

            for(int i = 0; i < targetIndex - 1 ; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }

        public int getSize() {
            int count = 1;

            if(head == null) {
                return 0;
            }

            Node<T> current = head;

            while(current.next != null) {
                count++;
                current = current.next;
            }

            return count;
        }

        public void print() {
            Node<T> current = head;
            while(current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }

        public customLinkedList<T>slice(int param1, int param2) {

            if(param1 < 0 || param2 < 0 || param1 > getSize() || param2 > getSize()) {
                throw new IllegalArgumentException("Invalid index");
            }

            customLinkedList<T> subList = new customLinkedList<>();
            Node<T> current = head;
            int big;
            int low;

            if(param1 >= param2) {
                big = param1;
                low = param2;
            } else {
                big = param2;
                low = param1;
            }

            for (int i = 0; i < low; i++) {
                current = current.next;
            }

            for(int i = 0; i < big - low; i++) {
                subList.add(current.data);
                current = current.next;
            }

            return subList;
        }
    }

    public static void main(String[] args) {

        System.out.println("==================");
        System.out.println("IMPLEMENTASI MENGGUNAKAN LIBRARY LINKED LIST");

        LinkedList<String> buahBuahanLinkList = new LinkedList<>(List.of("Rambutan", "Jambu", "Jeruk", "Melon", "Semangka", "Durian"));

        LinkedList<String> buahLinkList1 = new LinkedList<>();
        LinkedList<String> buahLinkList2 = new LinkedList<>();

        int index = 0;
        int halfSizeBuahBuahanLinkList = buahBuahanLinkList.size() / 2;
        for(String buah : buahBuahanLinkList) {
            if(index < halfSizeBuahBuahanLinkList) {
                buahLinkList1.add(buah);
            } else {
                buahLinkList2.add(buah);
            }
            index++;
        }

        buahLinkList1.remove("Jambu");
        buahLinkList2.removeLast();

        System.out.println("list Semua Buah : ");
        for(String buah : buahBuahanLinkList) {
            System.out.println(buah);
        }
        System.out.println();

        System.out.println("list Buah 1 : ");
        for(String buah : buahLinkList1) {
            System.out.println(buah);
        }
        System.out.println();

        System.out.println("list Buah 2 :");
        for(String buah : buahLinkList2) {
            System.out.println(buah);
        }
        System.out.println("==================");

        System.out.println();

        System.out.println("==================");
        System.out.println("IMPLEMENTASI MENGGUNAKAN LINKED LIST MANUAL");

        customLinkedList<String> buahBuahanManualLinkedList = new customLinkedList<>();
        buahBuahanManualLinkedList.addAllData(List.of("Rambutan", "Jambu", "Jeruk", "Melon", "Semangka", "Durian"));

        customLinkedList<String> buahManualLinkedList1 = buahBuahanManualLinkedList.slice(0, 3);
        customLinkedList<String> buahManualLinkedList2 = buahBuahanManualLinkedList.slice(3, 6);
        buahManualLinkedList1.removeElement("Jambu");
        buahManualLinkedList2.removeIndex(2);

        System.out.println("Seluruh list : ");
        buahBuahanManualLinkedList.print();
        System.out.println();

        System.out.println("List 1 : ");
        buahManualLinkedList1.print();
        System.out.println();

        System.out.println("List 2 : ");
        buahManualLinkedList2.print();
        System.out.println("==================");
    }
}
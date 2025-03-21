public class PSDA01_L0124100_GibranMaulana_3 {

    public static class Queue<T> {

        Node<T> top;

        public static class Node<T> {
            T data;
            Node<T> next;

            public Node(T data) {
                this.data = data;
                this.next = null;
            }

        }

        public void push(T data) {

            Node<T> newNode = new Node<>(data);
            newNode.next = top;
            top = newNode;

        }

        public void peek() {
            if(top == null) {
                return;
            }

            System.out.print(top.data);
        }

        public void pop() {
            if(top == null) {
                return;
            }

            top = top.next;
        }

    }

    public static void main(String[] args) {

        Queue<Integer> num = new Queue<>();

        num.push(0);
        num.push(0);
        num.peek();
        num.push(1);
        num.peek();
        num.pop();
        num.pop();
        num.peek();

        System.out.println();
    }

}
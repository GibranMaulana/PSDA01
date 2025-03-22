public class PSDA01_L0124100_GibranMaulana_3 {

    public static class Queue<T> {

        Node<T> head, rear;


        public static class Node<T> {
            T data;
            Node<T> next;

            public Node(T data) {
                this.data = data;
                this.next = null;
            }

        }

        public void enqueue(T data) {
            Node<T> newNode = new Node<>(data);

            if(isEmpty()) {
                rear = head = newNode;
            } else {

                newNode.next = rear;
                rear = newNode;
            }
        }

        public T dequeue() {
            if(isEmpty()) {
                return null;
            }

            T temp = head.data;

            Node<T> current = rear;

            if(rear == head) {
                head = null;
                rear = null;
                return temp;
            }

            while(current.next != null) {

                if(current.next == head) {
                    head = current;
                    head.next = head.next.next;
                    break;
                }

                current = current.next;
            }

            return temp;
        }

        public boolean isEmpty() {
            return (rear == null) && (head == null);
        }

        public void print() {
            if(isEmpty()) {
                return;
            }

            Node<T> current = rear;

            while(current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        }


    }

    public static class Stack<T> {

        private Node<T> top;

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

        public T pop() {
            if(top == null) {
                return null;
            }

            T temp = top.data;

            top = top.next;

            return temp;
        }

        public T peek() {
            if(top == null) {
                return null;
            }

            return top.data;
        }
    }

    public static void main(String[] args) {

        Queue<String> perintahPerintah = new Queue<>();
        Stack<Integer> num = new Stack<>();

        perintahPerintah.enqueue("PUSH 0");
        perintahPerintah.enqueue("PUSH 0");
        perintahPerintah.enqueue("TOP");
        perintahPerintah.enqueue("PUSH 1");
        perintahPerintah.enqueue("TOP");
        perintahPerintah.enqueue("POP");
        perintahPerintah.enqueue("POP");
        perintahPerintah.enqueue("TOP");

        while(!perintahPerintah.isEmpty()) {

            String perintah = perintahPerintah.dequeue();

            switch (perintah) {
                case "PUSH 0":
                    num.push(0);
                    break;
                case "PUSH 1":
                    num.push(1);
                    break;
                case "TOP":
                    System.out.print(num.peek());
                    break;
                case "POP":
                    num.pop();
                    break;
                default:
                    break;
            }
        }

        System.out.println();
    }

}
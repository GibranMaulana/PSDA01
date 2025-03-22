public class PSDA01_L0124100_GibranMaulana_2 {

    public static class Stack<T> {

        private Node<T> top;

        public static class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
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
            } else {
                T data = top.data;
                top = top.next;
                return data;
            }
        }

        public T peek() {
            if(top == null) {
                return null;
            } else {
                return top.data;
            }
        }

        public void goToTop(T data) {
            if(top == null) {
                return;
            }

            Node<T> current = top;

            while(current.next != null) {
                if(current.next.data.equals(data)) {
                    Node<T> temp = current.next;
                    current.next = current.next.next;
                    push(temp.data);
                    return;
                }

                current = current.next;
            }
        }

        public void pickKartun(T data) {

            Stack<T> tempStack = new Stack<>();

            while(!this.isEmpty()) {
                T temp = this.pop();
                if(temp.equals(data)) {
                    break;
                } else {
                    tempStack.push(temp);
                }
            }

            while(!tempStack.isEmpty()) {
                this.push(tempStack.pop());
            }
        }

        public void sortStack() {
            Stack<T> tempStack = new Stack<>();

            while (!this.isEmpty()) {
                T temp = this.pop();

                while (!tempStack.isEmpty() && tempStack.peek().toString().compareTo(temp.toString()) > 0) {
                    this.push(tempStack.pop());
                }
                tempStack.push(temp);
            }

            while (!tempStack.isEmpty()) {
                this.push(tempStack.pop());
            }
        }

        public boolean isEmpty() {
            return top == null;
        }

        public void print() {
            Node<T> current = top;
            while(current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
    }

    public static void main (String[] args) {
        Stack<String>kasetKartun = new Stack<>();

        kasetKartun.push("BoiBoiBoy");
        kasetKartun.push("Upin & Ipin");
        kasetKartun.push("Doraemon");
        kasetKartun.push("Shinchan");
        kasetKartun.push("SpongeBob SquarePants");
        kasetKartun.push("Marsha and the Bear");
        kasetKartun.push("Thomas & Friends");
        kasetKartun.push("Peppa pig");
        kasetKartun.push("Paw Patrol");
        kasetKartun.push("Dora the Explorer");

        System.out.println("-awal: ");
        kasetKartun.print();

        System.out.println();

        System.out.println("-setelah diurut: ");
        kasetKartun.sortStack();
        kasetKartun.print();

        System.out.println();

        System.out.println("-setelah Peppa pig dikeluarkan: ");
        kasetKartun.pickKartun("Peppa pig");
        kasetKartun.print();

    }
}
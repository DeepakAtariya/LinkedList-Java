class LinkedList {

    Node head = null;

    class Node {
        int data = 0;
        Node next = null;

        // public int toString(Node node) {
        // return node.data;
        // }
    }

    /**
     * addLast insert an element at first position by default
     * Completed
     * 
     * @param data
     */
    public void add(int position, int data) {
        try {
            position = position - 1;
            int listSize = this.size();

            // creating a node
            Node node = new Node();
            node.data = data;
            node.next = null;

            // checking whether list is empty or not
            if (this.head == null) {
                if (position > 1) {
                    System.out.println("List is empty and position is invalid. we are putting in first position");
                }
                // Going to push first element
                this.head = node;

            } else {

                if (position <= 0) {
                    if (position < 0) {
                        this.print("Invalid postion given. Adding at first");
                    }
                    node = null;
                    this.addFirst(data);
                } else {
                    if (position >= listSize) {
                        if (position > listSize) {
                            this.print("Invalid position given. Adding at last");
                        }
                        node = null;
                        this.addLast(data);
                    } else {

                        // searching node for particular position.
                        Node temp = this.find(position);

                        // this.print(temp.data + " is found at " + count);
                        // storing node in last position
                        node.next = temp.next;
                        temp.next = node;
                    }
                }

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * addLast insert an element at first position by default
     * 
     * @param data
     */
    public void addLast(int data) {
        try {

            // creating a node
            Node node = new Node();
            node.data = data;
            node.next = null;

            // checking whether list is empty or not
            if (this.head == null) {
                // Going to push first element
                this.head = node;
                node.next = head;

            } else {
                // taking first node reference for traversing
                Node temp = this.head;

                // traversing to the last element
                do {
                    System.out.print(temp.data + " -> ");
                    temp = temp.next;
                } while (temp != this.head);

                // storing node in last position
                // temp.next = node;
                node.next = this.head.next;
                this.head.next = node;
                this.head = node;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * addLast insert an element at last position by default
     * 
     * @param data
     */
    public void addFirst(int data) {
        try {
            // creating a node
            Node node = new Node();
            node.data = data;

            if (this.head == null) {
                this.head = node;
                node.next = this.head;
            } else {
                // this.head.next = node;
                node.next = this.head.next;
                this.head.next = node;
                this.head = node;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 
     */
    public void show() {
        try {
            Node temp = this.head;
            do {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            } while (temp != this.head);
            System.out.println("null");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 
     * @param message
     * 
     */
    public void print(String message) {
        System.out.println(message);
    }

    /**
     * 
     * @return
     * 
     */
    public int size() {
        Node temp = this.head;

        int count = 0;
        // if(temp.data == this.head.data)
        while (temp.data != this.head.data) {
            temp = temp.next;
            count++;
        }
        // this.print("List size : " + count);
        return count;
    }

    public boolean deleteFirst() {

        try {
            if (this.head == null) {
                this.print("Nothing to delete");
            } else {
                this.print("Going to delete : " + this.head.data);
                this.head = this.head.next;
            }
            return true;
        } catch (Exception e) {
            this.print("Error occured");
        }
        return false;
    }

    public boolean deleteLast() {

        try {
            if (this.head == null) {
                this.print("Nothing to delete");
            } else {
                Node temp = this.head;
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                this.print("Going to delete : " + temp.next.data);
                temp.next = null;
            }
        } catch (Exception e) {
            this.print("Error occured");
        }
        return false;
    }

    public boolean delete(int position) {

        try {
            int listSize = this.size();

            // checking whether list is empty or not
            if (this.head == null) {
                if (position > 1) {
                    System.out.println("List is empty and nothing can be deleted...");
                }
            } else {

                if (position <= 0) {
                    if (position < 0) {
                        this.print("Given position is smaller than list size");
                    }
                } else {

                    if (position == 1) {
                        // delete first element
                        this.deleteFirst();
                    } else if (position == listSize) {
                        // delete last element
                        this.deleteLast();
                    } else {
                        if (position > listSize) {
                            this.print("Given position is greater than list size");
                        } else {

                            // searching node for particular position.
                            Node temp = this.find(position);

                            this.print("Going to delete : " + temp.next.data);
                            temp.next = temp.next.next;
                            // temp.next = null;
                        }
                    }

                }

            }

            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public Node find(int position) {
        position = position - 1;
        // taking first node reference for traversing
        Node temp = this.head;
        int count = 1;
        // traversing to the last element
        while (temp.next.next != null) {
            if (count == position) {
                break;
            }
            temp = temp.next;
            count++;
        }
        return temp;
    }

    public boolean update(int position, int data) {
        try {
            int listSize = this.size();

            // checking whether list is empty or not
            if (this.head == null) {
                if (position > 1) {
                    System.out.println("List is empty and nothing can be deleted...");
                }
            } else {

                if (position <= 0) {
                    if (position < 0) {
                        this.print("Given position is smaller than list size");
                    }
                } else {

                    if (position == 1) {
                        // delete first element

                        this.updateFirst(data);
                    } else if (position == listSize) {
                        // delete last element
                        this.updateLast(data);
                    } else {
                        if (position > listSize) {
                            this.print("Given position is greater than list size");
                        } else {

                            // searching node for particular position.
                            Node temp = this.find(position + 1);

                            this.print("Going to update : " + temp.data);
                            temp.data = data;
                            // temp.next = null;
                        }
                    }

                }
            }

            return true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean updateLast(int data) {

        try {
            if (this.head == null) {
                this.print("Nothing to delete");
            } else {
                Node temp = this.head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                this.print("Going to update : " + temp.data);
                temp.data = data;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean updateFirst(int data) {

        try {
            if (this.head == null) {
                this.print("Nothing to delete");
            } else {
                this.print("Going to delete : " + this.head.data);
                this.head.data = data;
            }
            return true;
        } catch (Exception e) {
            this.print("Error occured");
        }
        return false;
    }

    public void sort() {
        Node fp = this.head;

        while (fp.next != null) {
            Node sp = fp.next;
            while (sp != null) {
                if (fp.data > sp.data) {
                    this.swap(fp, sp);
                }
                sp = sp.next;
            }
            fp = fp.next;
        }
    }

    public void swap(Node fp, Node sp) {
        int data = fp.data;
        fp.data = sp.data;
        sp.data = data;
    }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        // llist.addLast(100);
        // llist.addLast(200);
        // llist.addLast(300);
        // llist.addLast(400);
        // llist.addLast(500);
        // llist.addFirst(500);
        // llist.add(1, 40);
        llist.addFirst(40);
        llist.addFirst(50);
        llist.addFirst(60);
        llist.addFirst(70);
        llist.show();
        // llist.print(String.valueOf(llist.head.next.next.next.data));
        // llist.update(70, 39);
        // llist.update(3, 39);
        // llist.update(4, 201);
        // llist.update(2, 101);
        // llist.show();
        // llist.sort();
        // llist.show();
        // llist.show();
    }
}
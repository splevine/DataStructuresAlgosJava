package twostacks;

// IMPLEMENT TWO STACKS USING ONE ARRAY
class TwoStacks {

    int size;
    int top1;
    int top2;
    int arr[];

    //Constructor
    TwoStacks(int n) {
        arr = new int[n];
        size = n;
        top1 = -1;
        top2 = size;
    }

    //METHOD TO PUSH AN ELEMENT x to STACK1
    void push1(int x) {
        //CHECK IF THERE IS AT LEAST ONE EMPTY SPACE FOR NEW ELEMENT
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = x;
        } else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    //METHOD TO PUSH AN ELEMENT x to STACK2
    void push2(int x) {
        //CHECK IF THERE IS AT LEAST ONE EMPTY SPACE FOR NEW ELEMENT
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = x;
        } else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    //POP METHOD FOR STACK1
    int pop1() {
        if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        } else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }
    
    int pop2() {
        if (top2 < size) {
            int x = arr[top2];
            top2++;
            return x;
        } else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    // DRIVER PROGRAM TO TEST TWO STACK
    public static void main(String[] args) {
        TwoStacks twoStack = new TwoStacks(10);
        twoStack.push1(1);
        twoStack.push2(2);
        twoStack.push1(3);
        twoStack.push2(4);
        twoStack.push1(5);
        twoStack.push2(6);

        System.out.println("Pop1: " + twoStack.pop1());
        System.out.println("Pop2: " + twoStack.pop2());
    }
}

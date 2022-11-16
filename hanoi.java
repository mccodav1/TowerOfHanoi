public class hanoi {
    public static void Hanoi(ArrayStack Start, ArrayStack Temp, ArrayStack End, int n) {
        if (n==1) {
            //move from Start's top to End's top
            move(Start, End);
        }
        else {
            //move n-1 disks from Start to End via Temp
            Hanoi(Start, End, Temp, n-1);
            //nth disk into final position
            move(Start, End); // nth disk
            //move n-1 disks from Temp to Start via End
            Hanoi(Temp, Start, End, n-1);
        }
    }

    public static void move(ArrayStack pStart, ArrayStack pEnd){
        Object temp = pStart.pop();
        System.out.println("Moving " + temp + " from " + pStart.getName() + " to " + pEnd.getName());
        pEnd.push(temp);


    }

    public static void main(String[] args){
        ArrayStack first = new ArrayStack();
        first.setName("First");
        ArrayStack temp = new ArrayStack();
        temp.setName("Middle");
        ArrayStack last = new ArrayStack();
        last.setName("Last");
        first.push(5);
        first.push(4);
        first.push(3);
        first.push(2);
        first.push(1);
        System.out.println(first);



        Hanoi(first, temp, last, 6);

        System.out.println(last);

    }
}

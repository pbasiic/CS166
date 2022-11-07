import java.util.Scanner;

public class RSA {
    public static void main(String[] args){
        int p,q,e,N,phi,d;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter p: ");
        p = scan.nextInt();
        System.out.print("Enter q: ");
        q = scan.nextInt();
        System.out.print("Enter e: ");
        e = scan.nextInt();
        N = q * p;
        phi = (p-1)*(q-1);
        d=1;
        while((e*d) % phi != (1%phi)){
            d++;
        }
        System.out.println(d);
        scan.close();
    }
}

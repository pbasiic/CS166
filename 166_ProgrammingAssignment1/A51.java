import java.util.Scanner;

public class A51 {
    public static void main(String[] args){
    String x,y,z;
    int maj, x8, y10, z10, x18, y21, z22, nbits;
    String generatedbit = "";
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter X: ");
    x = scan.nextLine();
    System.out.print("Enter Y: ");
    y = scan.nextLine();
    System.out.print("Enter Z: ");
    z = scan.nextLine();
    System.out.print("How many generated bits: ");
    nbits = scan.nextInt();
    
    for(int i=0; i< nbits;i++){
        x8 = Integer.parseInt(x.charAt(8)+ "");
        y10 = Integer.parseInt(y.charAt(10)+ "");
        z10 = Integer.parseInt(z.charAt(10)+ "");
        maj = (x8+y10+z10 >1) ? 1 : 0;
        if(x8 == maj){
            int[] arr = {13,16,17,18};
            x = step(arr,x);
        }
        if(y10 == maj){
            int[] arr = {20,21};
            y = step(arr,y);
        }
        if(z10 == maj){
            int[] arr = {7,20,21,22};
            z = step(arr,z);
        }
        x18 = Integer.parseInt(x.charAt(18)+"");
        y21 = Integer.parseInt(y.charAt(21)+"");
        z22 = Integer.parseInt(z.charAt(22)+"");
        int s = x18 ^ y21 ^ z22;
        char c = (char)(s + '0');
        generatedbit = generatedbit + c;
    }

    System.out.println("Updated registers");
    System.out.println("New X: "+ x);
    System.out.println("New Y: "+ y);
    System.out.println("New Z: "+ z);
    System.out.println("\nKeystream bit generated: "+ generatedbit);
    scan.close();
    }

    private static String step(int[] index, String str){
        int e = Integer.parseInt(str.charAt(index[0])+ "");
        for(int i=1; i<index.length; i++){
            int temp = Integer.parseInt(str.charAt(index[i])+ "");
            e = e ^ temp;
        }
        String pString = String.valueOf(e);
        str = pString.concat(str);
        str = str.substring(0, str.length()-1);
        return str;
    }
}
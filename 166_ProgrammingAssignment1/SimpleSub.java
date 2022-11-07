import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleSub {
    public static void main(String[] args){
        Map<Character,Integer> freq = new HashMap<>();
        Map<Character,Character> match = new HashMap<>();
        String cipher, key;
        Scanner scan = new Scanner(System.in);

        //take in cipher text input
        System.out.print("Enter ciphertext: ");
        cipher = scan.nextLine();
        cipher = cipher.replaceAll("[^a-zA-Z]", "");

        //calculate frequency of letters in ciphertext
        for (int i=0; i< cipher.length(); i++){
            char ch = cipher.charAt(i);
            if(freq.containsKey(ch))
            freq.put(ch,freq.get(ch)+1);
            else
            freq.put(ch,1);
        }

        //utilize java lambdas to sort and stream frequency
        LinkedHashMap<Character, Integer> sortedFreq =
            freq.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(e->e.getKey(),
                        e -> e.getValue(),
                        (e1,e2) -> null,
                        () -> new LinkedHashMap<Character,Integer>()));
        
        System.out.println("Frequency counts: " + sortedFreq + "\n");
        System.out.println("Use command 'end' once you have found the correct key");
        key = "";
        while(!key.equals("end")){
            //takes user key input
            System.out.print("Guess a key: ");
            key = scan.next();

            //uses match to match the alphabet a-z
            int index = 0;
            for(Character ch = 'a'; ch<= 'z'; ch++){
                Character val = key.charAt(index++);
                match.put(val, ch);
            }

            //decrypting ciphertext given user key
            StringBuilder decrypt = new StringBuilder(cipher);
            for(int i=0; i<cipher.length();i++){
                Character ch = cipher.charAt(i);
                ch = Character.toUpperCase(ch);
                if(match.containsKey(ch)){
                    Character chr = match.get(ch);
                    decrypt.setCharAt(i, chr);
                }
            }
            
            Map<String, Character> hash = new HashMap<>();
            for(Map.Entry<Character,Character> entry : match.entrySet()){
                hash.put(String.valueOf(entry.getValue()), entry.getKey());
            }
            
            System.out.println("Resulting Plaintext: " + decrypt);
            System.out.println(hash);
        }
        System.out.println(match);
        scan.close();
    }
}

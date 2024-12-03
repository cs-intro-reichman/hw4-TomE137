public class Primes {
    public static void main(String[] args) {
        final int high = Integer.parseInt(args[0]);
        String numberarray = "2"; // numberarray will be used as an array to store all the prime numbers that are found within the given range
                                  // the use of a string for storage will be more efficient in this case as i can add items to it during the run
        boolean prime = true;
        int charsize = 1, counter =1; //counter will count the amount of numbers within the given range that are prime and charsize will count the                                               amount of digits within the prime number that needs to be extracted from the numberarray string
        System.out.println("Prime numbers up to " + high + ":");
        if (high >= 2) {
            System.out.println("2");      
        } else {
            counter--;
            numberarray="";
        }
        // i+=2 as all the even numbers are not prime
        for (int i = 3; i <= high; i+=2) {
            prime = true;
            charsize = 1; // default the digit size for an item in numberarray to 1
            for(int j = 0; j < numberarray.length(); j++) {
                // checks if the next digit of the next number within the string will be smaller than the last.
                //  this will only occur when then next number within has a larger digit count than the previous number (i.e: 7 and 11, 97 and 101...)  
                if (i == 29) {
                }
                if(numberarray.length()!=1 && numberarray.charAt(j)=='1' && numberarray.charAt(j-charsize)>numberarray.charAt(j)) {
                    charsize++;
                }
                if(i % Integer.parseInt(numberarray.substring(j, j + charsize)) == 0) {
                    prime = false;
                    break;
                }
                // prevents an out of bounds error when checking multiple digits within the string
                if(j + charsize + 1 > numberarray.length()-1) {
                    break;
                }
            }
            if(prime) {
                System.out.println(i);
                numberarray += i;
                counter++;
            }
        } 
        System.out.println("There are " + counter + " primes between 2 and " + high + " (" + (int) (100 * (double) counter / high) + "% are primes)");
    }
}

import java.util.Scanner;
public class Checksum
{
static String complement(String sum, int m)
{
char bits[] = sum.toCharArray();
for (int i = 0; i < m; i++)
{
if (bits[i] == '1')
{
bits[i] = '0';
}
else
{
bits[i] = '1';
}
}
return new String(bits);
}
static String calChecksum(String data[], int k, int m)
{
int a = Integer.parseInt(data[0], 2);
int b = 0;
int c = 0;
for (int i = 1; i < k; i++)
{
b = Integer.parseInt(data[i], 2);
c = a + b;
String temp = Integer.toBinaryString(c);
if (temp.length() > m)
{
temp = temp.substring(1);
c = Integer.parseInt(temp, 2);
c = c + 1;
}
a = c;
}
String sum = Integer.toBinaryString(c);
String t = sum;
if (sum.length() < m)
{
int diff = m - sum.length();
for (int i = 0; i < diff; i++)
t = "0" + t;
}
sum = t;
return sum;
}
static boolean validateChecksum(String data[], int k, int m, String
senderChecksum)
{
String sum = calChecksum(data, k, m);
int s = Integer.parseInt(sum, 2);
int sc = Integer.parseInt(senderChecksum, 2);
s = s + sc;
String finalSum = complement(Integer.toBinaryString(s), m);
System.out.println("Receiver side sum: " +
Integer.toBinaryString(s));
System.out.println("Receiver side complement: " + finalSum);
return finalSum.equals("00000000");
}
public static void main(String[] args)
{
System.out.println("How many segments of data? ");
Scanner input = new Scanner(System.in);
int k = input.nextInt();
System.out.println("How many bits per segment? ");
int m = input.nextInt();
String data[] = new String[k];
for (int i = 0; i < k; i++)
{
System.out.println("Enter data segment " + (i + 1) + ": ");
data[i] = input.next();
}
String senderChecksum = complement(calChecksum(data, k, m), m);
System.out.println("Sender side checksum value: " + senderChecksum);
System.out.println("Receiver side complement: " +
complement(senderChecksum, m));
System.out.println("Conclusion: " + (validateChecksum(data, k, m,
senderChecksum) ? "Accept Data" : "Reject Data"));
}
}

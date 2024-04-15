##IMPLEMENTATION OF SELECTIVE REPEAT PROTOCOL-keyboard-

import java.io.*;
public class SelectiveRepeat
{
public static void main(String args[]) throws IOException
{
BufferedReader br = new BufferedReader(new
InputStreamReader(System.in));
System.out.println("Enter the Frame Size: ");
int window = Integer.parseInt(br.readLine());
for (int sent = 0; sent < window; sent++)
{
System.out.println("Frame " + sent + " has been transmitted.");
}
int ack;
do
{
System.out.println("Enter the lost Acknowledgement : ");
ack = Integer.parseInt(br.readLine());
if (ack == window)
{
System.out.println("Acknowledgment Received for Frame "+ (ack - 1));
}
else
{
System.out.println("Frame " + ack + " has been retransmitted.");
System.out.println("Acknowledgment Received for Frame "+ ack);
System.out.println("All Frames Received Successfully");
}
}
while (ack == window);
}
}


###parity check
import java.util.*;
class Parity
{
public static void main(String[] args)
{
Scanner in = new Scanner(System.in);
System.out.println("Enter the size");
int size = in.nextInt();
System.out.println("Enter the message as bits");
String mess = in.next();
int[] arr = new int[size + 1];
for (int i = 0; i < size; i++)
{
arr[i] = mess.charAt(i) - '0';
}
int count = 0;
for (int i = 0; i < size; i++)
{
if (arr[i] == 1)
{
count++;
}
}
arr[size] = (count % 2 == 0) ? 0 : 1;
System.out.println("The modified bits after adding parity is");
for (int i = 0; i < size + 1; i++)
{
System.out.print(arr[i]);
}
System.out.println();
}
}






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




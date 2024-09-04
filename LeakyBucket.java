package leakybucket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeakyBucket {
    public static void main(String[] args) throws IOException {
        // Create a BufferedReader to read user input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Declare variables for bucket size, output rate, number of packets, discarded packets, and clock (time)
        int bucketSize, outputRate, packetCount, discarded, clock = 0;

        // Prompt the user to input the bucket size (capacity of the bucket)
        System.out.println("Enter the bucket size:");
        bucketSize = Integer.parseInt(br.readLine()); // Read and parse the input to an integer

        // Prompt the user to input the output rate (rate at which packets leave the bucket)
        System.out.println("Enter the output rate:");
        outputRate = Integer.parseInt(br.readLine()); // Read and parse the input to an integer

        // Prompt the user to input the number of packets
        System.out.println("Enter the number of packets:");
        packetCount = Integer.parseInt(br.readLine()); // Read and parse the input to an integer

        // Check if the number of packets exceeds the bucket size
        if (packetCount > bucketSize) {
            // If packets exceed bucket size, calculate the number of discarded packets
            discarded = packetCount - bucketSize;
            packetCount = bucketSize; // Set packetCount to the bucket capacity since it can only hold that much
            System.out.println("Packets are more than the bucket can hold, " + discarded + " packets are discarded.");
        } else {
            discarded = 0; // No packets discarded if packet count is within the bucket capacity
        }

        // Create an array to store the sizes of the incoming packets
        int[] packets = new int[packetCount];

        // Prompt the user to input the size of each packet
        System.out.println("Input packet sizes:");
        for (int i = 0; i < packetCount; i++) {
            packets[i] = Integer.parseInt(br.readLine()); // Read and store each packet size
        }

        // Initialize a counter to track how many packets have been processed
        int cnt = 0;

        // Loop until all packets have been processed (drained out)
        while (cnt < packetCount) {
            // Increment the clock (time tick) for each iteration
            System.out.println("At time tick " + (++clock));

            // Drain packets based on the output rate
            for (int outCnt = 0; outCnt < outputRate && cnt < packetCount; outCnt++) {
                // Display which packet is being drained
                System.out.println("Packet " + packets[cnt] + " drained out.");
                cnt++; // Increment the counter after draining each packet
            }
        }
    }
}

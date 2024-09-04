package leakybucket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeakyBucket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bucketSize, outputRate, packetCount, discarded, clock = 0;

       
        System.out.println("Enter the bucket size:");
        bucketSize = Integer.parseInt(br.readLine());

     
        System.out.println("Enter the output rate:");
        outputRate = Integer.parseInt(br.readLine());

        
        System.out.println("Enter the number of packets:");
        packetCount = Integer.parseInt(br.readLine());

   
        if (packetCount > bucketSize) {
            discarded = packetCount - bucketSize;
            packetCount = bucketSize;
            System.out.println("Packets are more than the bucket can hold, " + discarded + " packets are discarded.");
        } else {
            discarded = 0;
        }

       
        int[] packets = new int[packetCount];
        System.out.println("Input packet sizes:");
        for (int i = 0; i < packetCount; i++) {
            packets[i] = Integer.parseInt(br.readLine());
        }

    
        int cnt = 0;
        while (cnt < packetCount) {
            System.out.println("At time tick " + (++clock));
            for (int outCnt = 0; outCnt < outputRate && cnt < packetCount; outCnt++) {
                System.out.println("Packet " + packets[cnt] + " drained out.");
                cnt++;
            }
        }
    }
}

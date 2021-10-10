package algorithms.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRefueling {

    private static final Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        List<Integer> distances = new ArrayList<>();
        System.out.print("Add destination distance: ");
        int destination = s.nextInt();

        System.out.print("How many fuel stops along the way?: ");
        int fuelStops = s.nextInt();

        System.out.println("Enter their distances (next stop cannot be less than the previous): ");
        distances.add(0);
        for(int i = 0; i < fuelStops; ++i) {
            int stop = s.nextInt();
            distances.add(stop);
        }
        distances.add(destination);

        System.out.print("Max distance of tank capacity: ");
        int fuelCapacityDistance = s.nextInt();

        CarRefuel(distances, destination, fuelCapacityDistance);

    }

    private static void CarRefuel(List<Integer> distances, int destination, int fuelCapacityDistance) {
        int travelled = distances.get(0);
        int times = 0, i = 1;
        while (travelled < destination) {
            /** keep checking if tank can go to next stop, if yes, update distance turn and i. No then quit */
            int tempDistance = distances.get(i) - travelled;
            if(tempDistance <= fuelCapacityDistance) {
                travelled = distances.get(i);
                i++;
                times++;
            } else {
                times = -99;
                break;
            }
        }

        if(times != -99) {
            System.out.println("Can Refuel " + (times - 1) + " times");
        } else  {
            System.out.println("Impossible to finish!");
        }
    }
}

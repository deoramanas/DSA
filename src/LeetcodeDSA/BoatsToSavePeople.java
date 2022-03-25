package LeetcodeDSA;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        int numRescueBoats = numRescueBoats(people, limit);
        System.out.println(numRescueBoats);
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int c = 0;
        while (i <= j) {
            if (people[i] + people[j] == limit) {
                i++;
                c++;
                j--;

            } else if (people[i] == limit) {
                i++;
                c++;
            } else if (people[j] == limit) {
                j--;
                c++;
            } else if (i == j) {
                c++;
                break;
            }
        }
        return c;
    }

}

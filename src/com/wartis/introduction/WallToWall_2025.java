package com.wartis.introduction;

import java.util.Scanner;

public class WallToWall_2025 {

    public static void main(String ... args) {
        Scanner scanner = new Scanner(System.in, "ISO-8859-1");

        int amountOfTests = scanner.nextInt();
        scanner.nextLine(); //особенность сканнера: после nextInt не происходит перехода на новую строку


        for (int i=1; i <= amountOfTests; i++) {
            String [] str = scanner.nextLine().split(" ");
            int amountOfPeople = Integer.parseInt(str[0]);
            int amountOfTeams  = Integer.parseInt(str[1]);
            int membersInATeam = amountOfPeople/amountOfTeams;
            int remainder      = amountOfPeople%amountOfTeams;
            int result = 0;

            if (remainder == 0) {
                for (int j = 1; j <= amountOfTeams; j++) {
                    result += (amountOfPeople - j * membersInATeam) * membersInATeam;
                }
                System.out.println(result);
            }
            else {
                int arr[] = new int[amountOfTeams];
                int amountOfParticipated = 0;
                for (int j=0; j<amountOfPeople; j++) {
                    arr[j%amountOfTeams] += 1;
                }
                for (int j = 1; j <= amountOfTeams; j++) {
                    amountOfParticipated += arr[j-1];
                    result += (amountOfPeople - amountOfParticipated) * arr[j-1];
                }
                System.out.println(result);
            }
        }
    }
}

package asm4;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class InputHelper {
    /**
     * 
     * @param scanner
     * @param min
     * @param max
     * @return
     * @throws Exception
     * @throws InputMismatchException
     * @throws NoSuchFieldError
     */
    public static int inputInt(Scanner scanner, int min, int max) {
        // range -10 ~ 10
        Optional<Integer> result = Optional.ofNullable(null);
        do {
            try {
                result = Optional.of(scanner.nextInt());
                if (result.get() < min || result.get() > max) {
                    System.out.printf("Please input integer number in range [%d - %d]: ", min, max);

                }
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                System.out.print("Please input number: ");
                result = Optional.ofNullable(null);

            }
        } while (!result.isPresent());

        return result.get();
    }
}

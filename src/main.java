import java.util.Random;

void main() {
    Scanner in = new Scanner(System.in);
    Random rnd = new Random();
    int dieOne;
    int dieTwo;
    int rollTotal;
    boolean done;

    // Initial roll
    do {
        IO.println("Welcome to Craps! Roll the dice! [enter]");

        in.nextLine();
        dieOne = rnd.nextInt(6) + 1;
        dieTwo = rnd.nextInt(6) + 1;
        rollTotal = dieOne + dieTwo;
        System.out.printf("[%s] [%s]  Your roll: %s\n", dieOne, dieTwo, rollTotal);

        switch (rollTotal) {
            case 2, 3, 12:
                IO.println("> You crapped out!");
                IO.print("Play again? [y/n] ");

                done = !in.nextLine().equalsIgnoreCase("y");
                break;
            case 7, 11:
                IO.println("> You win with a natural!");
                IO.print("Play again? [y/n] ");

                done = !in.nextLine().equalsIgnoreCase("y");
                break;
            default:
                IO.println("> Trying for point (" + rollTotal + ")...");
                int pointTotal = rollTotal;
                boolean pointDone = false;

                do {
                    IO.println("Roll the dice! [enter]");
                    in.nextLine();
                    dieOne = rnd.nextInt(6) + 1;
                    dieTwo = rnd.nextInt(6) + 1;
                    rollTotal = dieOne + dieTwo;
                    System.out.printf("[%s] [%s]  Your roll: %s\n", dieOne, dieTwo, rollTotal);

                    if (rollTotal == pointTotal) {
                        IO.println("> You made the point, you win!");
                        pointDone = true;
                    } else if (rollTotal == 7) {
                        IO.println("> You sevened out, you lose!");
                        pointDone = true;
                    } else {
                        IO.println("> Point not reached. Trying for point (" + pointTotal + ")...");
                    }
                } while (!pointDone);

                IO.print("Play again? [y/n] ");

                done = !in.nextLine().equalsIgnoreCase("y");
        }
    } while (!done);
}
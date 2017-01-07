import java.util.Scanner;


public class Main {



    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Coordinates bound;

        System.out.println("Please input the width and height of Mars (both between 0 and 50):");
        bound = new Coordinates(input.nextInt(), input.nextInt());



        while(true){

            System.out.println("Please insert robot position - coordinate x (between 0 and width bound), coordinate y (between 0 and height bound), orientation (N/E/S/W)");
            Robot robot = new Robot(input.nextInt(), input.nextInt(), input.next());

            System.out.println("Robot ready for instructions! Insert instruction sequence (no more than 100) using the following commands: L(Left), R(Right), F(Forward)");
            char[] instructions = input.next().toCharArray();

            System.out.println("Processing instructions...");

            boolean lost = false;

            for (char instruction : instructions){
                switch (instruction) {
                    case 'L':
                        robot.turnLeft();
                        break;
                    case 'R':
                        robot.turnRight();
                        break;
                    case 'F': {
                        robot.moveForward();
                        //If robot falls from Mars, leaves a scent on that positon
                        if(!robot.isOnMars(bound)){
                            lost = true;
                            Robot.addScent(robot);
                        }
                        break;
                    }
                }
                if(lost){
                    break;
                }

            }
            if(lost){
                System.out.println(robot.toString() + " LOST");
            }else{
                System.out.println(robot.toString());
            }

            System.out.println("Do you want to place another robot? [Y/N]");

            if(input.next().equals("N")){
                break;
            }
        }
        System.out.println("Mars mission ended!");
        input.close();

    }

}





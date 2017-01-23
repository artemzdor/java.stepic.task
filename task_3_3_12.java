//https://stepik.org/lesson/%D0%9E%D0%B1%D1%8A%D1%8F%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5-%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D0%B0-12766/step/12?course=Java-%D0%91%D0%B0%D0%B7%D0%BE%D0%B2%D1%8B%D0%B9-%D0%BA%D1%83%D1%80%D1%81&thread=solutions&unit=3114

public class task_3_3_12 {
    public static void main(String[] args) {
        Robot robot = new Robot(0,0, Direction.DOWN);
        moveRobot(robot, -10, 20);
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot (int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {return dir;}

        public int getX() {return x;}

        public int getY() {return y;}

        public void turnLeft() {
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }

        public void turnRight() {
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }

        public void stepForward() {
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        if (toX > robot.getX()){
            setDirection(robot.getDirection(), Direction.RIGHT, robot);
            move(toX - robot.getX(), robot);
        } else if (toX < robot.getX()) {
            setDirection(robot.getDirection(), Direction.LEFT, robot);
            move(robot.getX() - toX, robot);
        }

        if (toY > robot.getY()){
            setDirection(robot.getDirection(), Direction.UP, robot);
            move(toY - robot.getY(), robot);
        } else if (toY < robot.getY()) {
            setDirection(robot.getDirection(), Direction.DOWN, robot);
            move(robot.getY() - toY, robot);
        }
    }

    public static void move(int m, Robot r){
        for (int i = 0; i < m; i++) {
            r.stepForward();
        }
    }

    public static void setDirection(Direction r_dir , Direction local, Robot r){
       int[] mas_D = {0, 2, 3, 1};
       if (mas_D[r_dir.ordinal()] < mas_D[local.ordinal()]){
           for (int i = mas_D[r_dir.ordinal()]; i < mas_D[local.ordinal()]; i++) {
               r.turnRight();
           }
       } else if (mas_D[r_dir.ordinal()] > mas_D[local.ordinal()]) {
           for (int i = mas_D[local.ordinal()]; i < mas_D[r_dir.ordinal()]; i++) {
               r.turnLeft();
           }
       }
    }
}
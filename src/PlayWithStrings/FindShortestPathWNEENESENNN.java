package PlayWithStrings;

public class FindShortestPathWNEENESENNN {
    public static float getShortestPath(String path){
        int x=0; int y=0;
        for (int i=0; i< path.length(); i++){
            char direction = path.charAt(i);
            if (direction=='S'){
                y--;
            } else if (direction == 'N') {
                y++;
            } else if (direction== 'E') {
                x++;
            }else {
                x--;
            }
        }
        System.out.println("X= "+ x);
        System.out.println("Y "+ y);
        int X2 =  x*x;
        int Y2 = y*y;

        return (float) Math.sqrt(X2+Y2);
    }
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(getShortestPath(path));
    }
}

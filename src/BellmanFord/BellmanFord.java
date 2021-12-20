package BellmanFord;

public class BellmanFord {
    public static void bellman(int num, int [][]graph, int sourceNode){
        int [] distanceArray = new int[num];
        for(int i=0;i<num;i++){
            distanceArray[i] = 999;
        }
        distanceArray[sourceNode] = 0;
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                for(int k=0;k<num;k++){
                    if(graph[j][k] != 999){
                        if (distanceArray[k] > distanceArray[j] + graph[j][k]){
                            distanceArray[k] = distanceArray[j] + graph[j][k];
                        }
                    }
                }
            }
        }
        System.out.println("The min spanning tree: ");
        for(int i=0;i<num;i++){
            System.out.println(distanceArray[i]);
        }
    }

    public static void main(String[] args) {

    }
}

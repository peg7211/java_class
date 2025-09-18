public class pro_2 {
    public static void main(String[] args) {
        int [][]arr = new int [4][4];

        for(int i=0;i < arr.length;i++){
            for(int j=0;j <arr.length;j++) {
                arr[i][j] = 0;
            }
        }

        int num = 0;
        while(num < 10) {
            int row = (int) (Math.random() * 4);
            int col = (int) (Math.random() * 4);

            if(arr[row][col] != 0) {
                continue;
            }
            arr[row][col] = (int)Math.round(Math.random() * 10 + 1);
            num++;
        }

        for(int[] arrIter : arr) {
            for(int intIter : arrIter) {
                System.out.print(intIter + "\t");
            }
            System.out.println();
        }
    }
}

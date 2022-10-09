package gc;


import java.util.Arrays;

public class LogerNode {

    public static void main(String[] args) {

          Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[][]{{2, 3}}));
        System.out.println(solution.solution(2, new int[][]{{2, 1}}));
        System.out.println(solution.solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}}));

    }

    static class Solution {
        int [] len;
        int [] visit;
        int[][] map;
        public int solution(int n, int[][] edge) {

            len =new int[n+1];
            visit =new int[n+1];
            map =new int[n+1][n+1];
            for (int i = 0; i <edge.length ; i++) {
                map[edge[i][0]][edge[i][1]] = 1;
                map[edge[i][1]][edge[i][0]] = 1;
            }
            re(1);


            Arrays.sort(len);
            int count =0;
            if(len[len.length-1]==0 )
                return  n-1;
            for (int i = len.length-1; i >1 ; i--) {

                if(len[i] != len[i-1]){
                    count = len.length - i;
                    break;
                }

            }
            return count;

        }

        public void re(int start) {
            for (int i = 2; i < map.length; i++) {
                if(map[start][i] !=0)
                {
                    if(len[i] == 0)
                    {
                        len[i] = len[start]+1;
                    }
                    else
                        len[i] = len[i] > len[start]+1 ?  len[start]+1: len[i];
                }
            }
            for (int i = 2; i < map.length; i++) {
                if(map[start][i] !=0 && visit[i] == 0)
                {
                    visit[i] = 1;
                    re(i);
                }
            }
        }
    }
}

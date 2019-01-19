package leetcode;

public class N657JudgeRouteCircle_GG {
    public boolean judgeCircle(String moves) {
        char[] array = moves.toCharArray();
        int v=0,h=0;

        for(int i=0;i<array.length;i++){
            switch (array[i]){
                case 'U':
                    v++;
                    break;
                case 'D':
                    v--;
                    break;
                case 'L':
                    h--;
                    break;
                case 'R':
                    h++;
                    break;
            }
        }
        if(v==0&&h==0)
            return true;
        else
            return false;
    }
}

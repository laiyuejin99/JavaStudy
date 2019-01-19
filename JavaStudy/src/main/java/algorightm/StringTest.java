package algorightm;

public class StringTest {
    public static void main(String args[]){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abc");
//        stringBuilder.equals()
        stringBuilder.deleteCharAt(1);
        System.out.println(stringBuilder);
        stringBuilder.length();
        String st;
//        Character.toUpperCase()
//        st.replace()
        String str = "2-4A0r7-4k".replace("-","");
        System.out.println(str.length()%3);
    }

    public boolean backspaceCompare(String S, String T) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='#'){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(S.charAt(i));
            }
        }
        StringBuilder tB = new StringBuilder();
        for(int i=0;i<T.length();i++){
            if(T.charAt(i)=='#'){
                tB.deleteCharAt(tB.length()-1);
            }else{
                tB.append(T.charAt(i));
            }
        }
        return sb.equals(tB);
    }
}

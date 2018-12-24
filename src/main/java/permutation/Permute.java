package permutation;

public class Permute {

    public void permute(String str) {
        char[] strChars = new char[str.length()];
        str.getChars(0, str.length(), strChars, 0);

        permute(strChars, 0, str.length());

    }

    private void permute(char[] str, int low, int high) {
        if (low == high) {
            System.out.print(str[0]);
        } else {
            for (int i = low; i <= high; i++) {
//                str
            }
        }


//
//        else {
//            char[] bottomHalf = Arrays.copyOfRange(str, low, high/2 + 1);
//            permute(bottomHalf, low, high / 2);
//
//            char[] topHalf = Arrays.copyOfRange(str, high/2 + 1, str.length);
//            permute(topHalf, high/2 + 1, high);
//
//            permute(str, high, low);
//        }
    }
}

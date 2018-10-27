public class ReadWriteN {

    char[] buffer;
    int l, r;

    public ReadWriteN(int n) {
        buffer = new char[n + 1];
        l = r = 0;
    }

    public int read(char[] buf, int n) {
        int cnt = 0;
        while (cnt < n && l != r) {
            l = (l + 1) % buffer.length;
            buf[cnt ++] = buffer[l];
        }
        return cnt;
    }

    public int write(String input) {
        int cnt = 0;
        while (cnt < input.length() && (r + 1) % buffer.length != l) {
            r = (r + 1) % buffer.length;
            buffer[r] = input.charAt(cnt ++);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int buffSize = 5;
        ReadWriteN reader = new ReadWriteN(buffSize);
        char[] buf = new char[buffSize];

        System.out.println(reader.write("abc"));

        System.out.println(reader.write("def"));

        int len = reader.read(buf, 3);
        for (int i = 0; i < len; i ++)
            System.out.print(buf[i] + " ");
        System.out.println();

        System.out.println(reader.write("xyzabc"));

        len = reader.read(buf, 8);
        for (int i = 0; i < len; i ++)
            System.out.print(buf[i] + " ");
        System.out.println();
    }
}
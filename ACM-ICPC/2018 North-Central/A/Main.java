import java.util.*;

public class Main {

    public static class Pokemon {
        String name;
        int rank;
        Pokemon(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }
    }

    public static class Char {
        char ch;
        int pos;
        Char(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int queries = sc.nextInt();

        String[] pokemons = new String[n];
        for (int i = 0; i < n; i ++) {
            String name = sc.nextLine();
            pokemons[i] = new Pokemon(name, i);
        }
        Arrays.sort(pokemons, new Comparator<Pokemon>(){
            public int compare(Pokemon a, Pokemon b) {
                return a.compareTo(b);
            }
        });

        for (int query = 0; query < queries; query ++) {
            int m = sc.nextInt();
            int limit = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < m; i ++) {
                int tmp = sc.nextInt();
                set.add(tmp);
            }

            Stack<Char> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();

            int count = 0;
            for (Pokemon pokemon : pokemons) {
                if (!set.contains(pokemon.rank)) continue;

                while (!stack.isEmpty() && !)
            }
        }
    }
}

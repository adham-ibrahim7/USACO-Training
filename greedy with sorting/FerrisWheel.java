import java.util.*;
import java.io.*;

public class FerrisWheel {
	public static void main(String[] args) throws IOException {
		setIO();

		st = nl();
		int N = ni(st), X = ni(st);
		ms = new TreeMap<>();
		st = nl();
		for (int i = 0; i < N; i++) add(ni(st));
		
		int ans = 0;
		while (!ms.isEmpty()) {
			int a = delete(ms.firstKey());
			if (ms.floorKey(X-a) != null) {
				delete(ms.floorKey(X-a));
			}
			ans++;
		}
		
		out.println(ans);
		
		f.close();
		out.close();
	}
	
	static TreeMap<Integer, Integer> ms;

	static void add(int x) {
		ms.put(x, ms.getOrDefault(x, 0) + 1);
	}

	static int delete(int x) {
		int c = ms.get(x);
		ms.put(x, --c);
		if (c == 0)
			ms.remove(x);
		
		return x;
	}

	static BufferedReader f;
	static PrintWriter out;
	static StringTokenizer st;

	static int ni(StringTokenizer st) {
		return Integer.parseInt(st.nextToken());
	}

	static int ni() throws IOException {
		return Integer.parseInt(f.readLine());
	}

	static StringTokenizer nl() throws IOException {
		return new StringTokenizer(f.readLine());
	}

	static int[] nia(int N) throws IOException {
		StringTokenizer st = nl();
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = ni(st);
		return A;
	}

	static void setIn(String s) throws IOException {
		f = new BufferedReader(new FileReader(s));
	}

	static void setOut(String s) throws IOException {
		out = new PrintWriter(new FileWriter(s));
	}

	static void setIn() {
		f = new BufferedReader(new InputStreamReader(System.in));
	}

	static void setOut() {
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	}

	static void setIO(String s) throws IOException {
		setIn(s + ".in");
		setOut(s + ".out");
	}

	static void setIO() {
		setIn();
		setOut();
	}
}

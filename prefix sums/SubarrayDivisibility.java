import java.util.*;
import java.io.*;

public class SubarrayDivisibility {
	public static void main(String[] args) throws IOException {
		setIO();

		int N = ni();
		int[] A = nia(N);
		
		int[] counts = new int[N];
		counts[0] = 1;
		
		long ans = 0;
		long s = 0;
		for (int i = 0; i < N; i++) {
			s += A[i];
			int m = (int) (s % N);
			if (m < 0) m += N;
			ans += counts[m];
			counts[m]++;
		}
		
		out.println(ans);
		
		f.close();
		out.close();
	}

	static final int MOD = 1000000007;

	static BufferedReader f;
	static PrintWriter out;

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

	static void setIO(String s) throws IOException {
		f = new BufferedReader(new FileReader(s + ".in"));
		out = new PrintWriter(new FileWriter(s + ".out"));
	}

	static void setIO() {
		f = (new BufferedReader(new InputStreamReader(System.in)));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	}
}

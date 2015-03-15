import java.io.*;
import java.util.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	void solve() throws IOException {
		long n = nl(), k = nl();

		long free = k, sec = 0, prev_sec = 0;
		Queue<Long> q = new PriorityQueue<>();

		while (n-- > 0) {
			long s = nl(), m = nl();

			if (free > 0) {
				free--;
				sec += s - prev_sec;

				while (!q.isEmpty() && q.peek() <= sec) {
					free++;
					q.poll();
				}
			} else {
				long head = q.poll();				
				
				while (!q.isEmpty() && q.peek() <= s) {
					free++;
					head = q.poll();
				}

				sec = Math.max(head, s);
			}

			prev_sec = sec;

			long finish = sec + m;
			q.add(finish);

			out.println(finish);
		}
	}

	Main() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		in.close();
		out.close();
	}

	String ns() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}

	int ni() throws IOException {
		return Integer.parseInt(ns());
	}

	double nd() throws IOException {
		return Double.parseDouble(ns());
	}

	long nl() throws IOException {
		return Long.parseLong(ns());
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}

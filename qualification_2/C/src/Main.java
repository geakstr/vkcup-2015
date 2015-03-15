import java.io.*;
import java.util.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	char[] s, t;
	int n, m;
	boolean was_left = false;
	
	int left_idx = 0, left_offset = 0;

	boolean left(int l, int r) {
		for (int i = l; i < r; i++) {
			if (s[left_idx] == t[i]) {
				left_idx++;
				if (left_idx == n) {
					return true;
				}
			}
		}
		left_offset = r;	
		return false;
	}
	
	boolean right(int l, int r) {
		int idx = 0;
		for (int i = l; i < r; i++) {
			if (s[idx] == t[i]) {
				idx++;
				if (idx == n) {
					return true;
				}
			}
		}
		return false;
	}

	boolean split(int pivot) {
		if (!was_left) {
			if (!left(left_offset, pivot)) {
				return false;
			} else {
				was_left = true;
			}
		}
		return right(pivot, m);
	}

	void solve() throws IOException {
		s = in.readLine().toCharArray();
		t = in.readLine().toCharArray();

		n = s.length;
		m = t.length;
		
		boolean[] set = new boolean[26];
		for (int i = 0; i < n; i++) {
			set[s[i] - 97] = true;
		}
		
		int ans = 0;
		for (int i = n; i <= m - n;) {
			if (split(i)) {
				ans++;
				i++;
			} else {
				if (was_left) {
					while (i <= m - n && !set[t[i] - 97]) {
						i++;
					}
				} else {
					i++;
				}
			}
		}

		out.println(ans);
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
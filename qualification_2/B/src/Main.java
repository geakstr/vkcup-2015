import java.io.*;
import java.util.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;
	
	void solve() throws IOException {
		int n = ni(), T = ni();
		double c = nd();
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = ni();
		}
		
		int m = ni();
		int[] p = new int[m];
		for (int i = 0; i < m; i++) {
			p[i] = ni() - 1;
		}
		
		double real = 0.0, mean = 0.0, numerator = 0.0;
		for (int i = 0, p_idx = 0; i <= p[m - 1]; i++) {
			if (i >= T) {
				numerator -= a[i - T];				
			}
			
			double cur_a = (double) a[i];		
			numerator += cur_a;
			mean = (mean + cur_a / (double) T) / c;
			
			if (p[p_idx] == i) {
				real = numerator / (double) T;
				out.println(String.format("%.6f %.6f %.6f", real, mean, Math.abs(mean - real) / real));
				p_idx++;
			}
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

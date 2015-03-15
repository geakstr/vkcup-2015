import java.io.*;
import java.util.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;
	
	void solve() throws IOException {
		int w = ni(), h = ni();
		
		char[][] a = new char[h][w];
		
		for (int i = 0; i < h; i++) {
			String line = in.readLine();
			for (int j = 0; j < w; j++) {
				a[i][j] = line.charAt(j);
			}
		}
		
		char[][] b = new char[w][h];
		for (int aj = 0, bi = 0; aj < w; aj++, bi++) {
			for (int ai = 0, bj = 0; ai < h; ai++, bj++) {
				b[bi][bj] = a[ai][aj];
			}
		}
		
		char[][] c = new char[w * 2][h * 2];
		for (int bi = 0, ci = 0; bi < w; bi++, ci += 2) {
			for (int bj = 0, cj = 0; bj < h; bj++, cj += 2) {
				char ch = b[bi][bj];
				c[ci][cj] = ch;
				c[ci + 1][cj] = ch;
				c[ci][cj + 1] = ch;
				c[ci + 1][cj + 1] = ch;
			}
		}		
		
		w *= 2;
		h *= 2;
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				out.print(c[i][j]);
			}
			out.println();
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

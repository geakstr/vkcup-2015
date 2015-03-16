import java.io.*;
import java.util.*;

public class Main {
  BufferedReader in;
  PrintWriter out;
  StringTokenizer st;

  char[] s, t;
  int n, m;

  void solve() throws IOException {
    s = in.readLine().toCharArray();
    t = in.readLine().toCharArray();

    n = s.length;
    m = t.length;

    int l = 0, r = m - 1;
    boolean was_left = false, was_right = false;

    for (int left_idx = 0; l < m; l++) {
      if (s[left_idx] == t[l]) {
        left_idx++;
        if (left_idx == n) {
          was_left = true;
          break;
        }
      }
    }
    
    if (!was_left) {
      out.println(0);
      return;
    }

    for (int right_idx = n - 1; r >= 0; r--) {
      if (s[right_idx] == t[r]) {
        right_idx--;
        if (right_idx == -1) {
          was_right = true;
          break;
        }
      }
    }
    
    if (!was_right || r < l) {
      out.println(0);
      return;
    }
    
    out.println(r - l);
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

package SigmaBatchDSA.LiveSessions.Session3;

public class TwoPowerN {
    public static void main(String[] args) {
        int n = 6;
        int ans = 1;

        for (int i = 1; i <= n; i++) {
            ans = ans * 2;
        }

        System.out.println(ans);
    }
}
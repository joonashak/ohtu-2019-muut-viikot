package statistics.matcher;

import statistics.Player;

public class HasFewerThan implements Matcher {
    private int val;
    private String name;

    public HasFewerThan(int val, String name) {
        this.val = val;
        this.name = name;
    }

    @Override
    public boolean matches(Player p) {
        Matcher m = new HasAtLeast(val, name);
        return !m.matches(p);
    }    
}

package statistics.matcher;

public class QueryBuilder {
    Matcher matcher;

    public QueryBuilder() {
        this.matcher = new All();
    }

    public Matcher build() {
        return matcher;
    }

    public QueryBuilder playsIn(String team) {
        matcher = new And(matcher, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int val, String field) {
        matcher = new And(matcher, new HasAtLeast(val, field));
        return this;
    }

    public QueryBuilder hasFewerThan(int val, String field) {
        matcher = new And(matcher, new HasFewerThan(val, field));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        matcher = new Or(matchers);
        return this;
    }
}

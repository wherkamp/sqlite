package dev.tuxjsql.sqlite;

import dev.tuxjsql.core.sql.select.JoinType;

public enum SQLiteJoinTypes {
    INNER("INNER JOIN", JoinType.INNER),
    LEFT("LEFT JOIN", JoinType.LEFT),
    RIGHT("RIGHT JOIN", JoinType.RIGHT),
    FULL("FULL JOIN", JoinType.FULL);


    private String key;
    private JoinType joinType;

    public String getKey() {
        return key;
    }

    public JoinType getJoinType() {
        return joinType;
    }

    SQLiteJoinTypes(String key, JoinType joinType) {
        this.key = key;
        this.joinType = joinType;
    }

    public static SQLiteJoinTypes getType(JoinType type) {
        for (SQLiteJoinTypes sqliteJoin : values()) {
            if (sqliteJoin.joinType == type) return sqliteJoin;
        }
        return null;
    }
}

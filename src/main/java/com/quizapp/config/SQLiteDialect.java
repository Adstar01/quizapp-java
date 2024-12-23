package com.quizapp.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.SqlFunction;
import org.hibernate.query.spi.QueryEngine;
import org.hibernate.type.spi.TypeConfiguration;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();
    }

    @Override
    public void initializeFunctionRegistry(QueryEngine queryEngine) {
        super.initializeFunctionRegistry(queryEngine);

        TypeConfiguration typeConfiguration = queryEngine.getTypeConfiguration();

        // Register SQL functions
        queryEngine.getSqmFunctionRegistry().register(
                "concat",
                new SqlFunction("concat", typeConfiguration.getBasicTypeForJavaType(String.class))
        );

        queryEngine.getSqmFunctionRegistry().register(
                "substr",
                new SqlFunction("substr", typeConfiguration.getBasicTypeForJavaType(String.class))
        );

        queryEngine.getSqmFunctionRegistry().register(
                "length",
                new SqlFunction("length", typeConfiguration.getBasicTypeForJavaType(Integer.class))
        );
    }

    @Override
    public boolean supportsIdentityColumns() {
        return true;
    }

    @Override
    public boolean hasAlterTable() {
        return false; // SQLite does not support ALTER TABLE commands
    }

    @Override
    public String getIdentityColumnString() {
        return "integer primary key autoincrement"; // For SQLite, identity columns are declared this way
    }

    @Override
    public String getDropForeignKeyString() {
        return ""; // SQLite does not support "drop foreign key" syntax
    }

    @Override
    public String getAddForeignKeyConstraintString(
            String constraintName,
            String foreignKey,
            String referencedTable,
            String referencedPrimaryKey
    ) {
        return ""; // No-op because SQLite does not support foreign keys natively
    }

    @Override
    public String getAddPrimaryKeyConstraintString(String constraintName) {
        return ""; // No-op because primary keys are part of table creation in SQLite
    }

    @Override
    public boolean supportsIfExistsBeforeTableName() {
        return true;
    }
}

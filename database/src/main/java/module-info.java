module database {
    exports service;
    requires java.persistence;
    requires java.sql;
    requires transitive model;
    requires com.microsoft.sqlserver.jdbc;
    requires hibernate;
    requires csv.reader;

}
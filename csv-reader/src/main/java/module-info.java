module csv.reader {
    requires model;
    requires opencsv;
    exports reader;
    exports writer;
    exports app;
    requires java.sql;
    requires java.persistence;
}
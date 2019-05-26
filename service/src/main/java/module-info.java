module service {
    requires model;
    requires  csv.reader;
    requires java.sql;
    exports service.repositories;
}
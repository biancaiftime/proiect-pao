module csv.reader {
    requires model;
    requires opencsv;
    exports reader;
    exports writer;
    requires java.sql;
    requires org.aspectj.weaver;
    requires reflections;

}
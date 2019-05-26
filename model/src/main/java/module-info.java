module model {
    exports repositories;
    exports entities;
    exports utils;
    requires java.persistence;
    opens entities;
}
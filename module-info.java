module com.mycompany.newmailboxfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;
    requires java.sql;
    requires tess4j;
    requires webcam.capture;
    requires java.logging;
    requires bridj;
    requires com.sun.jna;
    requires slf4j.log4j12;
    requires org.apache.logging.log4j.core;
    requires log4j;
    requires xml;
    requires rpi.camera.client;
    requires opencv;
    
    opens com.mycompany.newmailboxfx to javafx.fxml;
    exports com.mycompany.newmailboxfx;
}
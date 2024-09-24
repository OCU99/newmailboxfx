package com.mycompany.newmailboxfx;
import org.slf4j.impl.StaticLoggerBinder;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.fxml.Initializable;
import javax.imageio.ImageIO;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.Logger;
import static org.apache.logging.log4j.core.util.Loader.getClassLoader;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;


public class TakePhotoController implements Initializable {

    @FXML
    Button btnStartCamera;

    @FXML
    Button btnStopCamera;

    @FXML
    Button btnCancel;

    @FXML
    Button btnTakePhoto;
    
    @FXML
    ComboBox<CameraInfo> cbCameraOptions;

    @FXML
    BorderPane bpWebCamPaneHolder;

    @FXML
    FlowPane fpBottomPane;

    @FXML
    ImageView imgWebCamCapturedImage;
    
    @FXML
    ImageView view;
    
    private final CameraInfo c1 = new CameraInfo();
    private BufferedImage grabbedImage;
    private boolean stopCamera = false;
    private final ObjectProperty<Image> imageProperty = new SimpleObjectProperty<>();

    private final String cameraListPromptText = "Choose Camera";

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        fpBottomPane.setDisable(true);
        ObservableList<CameraInfo> options = FXCollections.observableArrayList();
        int webCamCounter = 0;
            CameraInfo CameraInfo = new CameraInfo();
            CameraInfo.setCameraIndex(0);
            if (c1 == null) {
                CameraInfo.setCameraName(c1.toString());
            }
            options.add(CameraInfo);
            webCamCounter++;
        cbCameraOptions.setItems(options);
        cbCameraOptions.setPromptText(cameraListPromptText);
        cbCameraOptions.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends CameraInfo> arg2, CameraInfo arg3, CameraInfo arg4) -> {
            if (arg4 != null) {
                System.out.println("WebCam Index: " + arg4.getCameraIndex() + ": WebCam Name:" + arg4.getCameraName());
                initializeWebCam(arg4.getCameraIndex());
            }
        });
        Platform.runLater(() -> {
            setImageViewSize();
        });

    }

    protected void setImageViewSize() {

        double height = bpWebCamPaneHolder.getHeight();
        double width = bpWebCamPaneHolder.getWidth();
        imgWebCamCapturedImage.setFitHeight(height);
        imgWebCamCapturedImage.setFitWidth(width);
        imgWebCamCapturedImage.prefHeight(height);
        imgWebCamCapturedImage.prefWidth(width);
        imgWebCamCapturedImage.setPreserveRatio(true);

    }

    protected void initializeWebCam(final int webCamIndex) {

        Task<Void> webCamIntilizer = new Task<Void>() {

            @Override
            protected Void call() throws Exception {

                if (c1 == null) {
                    c1.equals(c1);
                    c1.getCameraIndex();
                } else {
                    closeCamera();
                }
                startWebCamStream();
                return null;
            }

        };

        new Thread(webCamIntilizer).start();
        fpBottomPane.setDisable(false);
        btnStartCamera.setDisable(true);
    }

    public void takePhoto(ActionEvent actionEvent) throws IOException {
        if(grabbedImage != null) {
            var file = new File("photo.png");
            view = new ImageView(new Image(getClassLoader().getResource("SearchScreen.fxml").toExternalForm()));
            view.setPreserveRatio(true);
            view.setFitHeight(300);
            ImageIO.write(grabbedImage, cameraListPromptText, file);
            Button saveWrite = new Button("save write");
            saveWrite.setOnAction(e -> {
                try {
                    File target = new File("saved_using_write.jpg");
                    
                    //convert to bufferedImage
                    BufferedImage toWrite = SwingFXUtils.fromFXImage(view.getImage(), null);
                    
                    //write using ImageIO
                    ImageIO.write(toWrite, "jpg", target);
                    
                    System.out.println("image saved at" + target.getAbsolutePath());
                } catch (IOException x) {
                    System.err.println("failed to save image");
                    x.getMessage();
                }
            });
        }
        Common.loadWindow(btnTakePhoto, "SearchScreen");
    }
    
    protected void startWebCamStream() {
        stopCamera = false;
        Task<Void> task = new Task<Void>() {

            @Override
            protected Void call() throws Exception {

                while (!stopCamera) {
                    try {
                        if (grabbedImage != null) {

                            Platform.runLater(() -> {
                                final Image mainiamge = SwingFXUtils.toFXImage(grabbedImage, null);
                                imageProperty.set(mainiamge);
                            });

                            grabbedImage.flush();

                        }
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }

                return null;
            }

        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
        imgWebCamCapturedImage.imageProperty().bind(imageProperty);

    }

    private void closeCamera() {
        if (c1 != null) {
            c1.getClass();
        }
    }

    public void stopCamera(ActionEvent event) {
        stopCamera = true;
        btnStartCamera.setDisable(false);
        btnStopCamera.setDisable(true);
    }

    public void startCamera(ActionEvent event) {
        stopCamera = false;
        startWebCamStream();
        btnStartCamera.setDisable(true);
        btnStopCamera.setDisable(false);
    }

    public void onCancelButtonClick(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(btnCancel, "HomeScreen");
    }
    
    public static class impl {
        public static void main(String[] args) {
            System.out.println();
        }
    }
    
    public StaticLoggerBinder s(StaticLoggerBinder s) {
        return s;
    }
    
    public static class log4jXML {
        static Logger logger = Logger.getLogger(log4jXML.class);
        public static void main(String[] args) {
        DOMConfigurator.configure("log4j.xml");
        logger.getLevel();
        }
    }
    
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
		System.out.println("mat = " + mat.dump());
		launch(args);	
    }
}
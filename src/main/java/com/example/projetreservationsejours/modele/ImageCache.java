package com.example.projetreservationsejours.modele;

import com.example.projetreservationsejours.Application;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class ImageCache {
    private static Map<String, Image> cache = new HashMap<>();
     public ImageCache(){
         Image image1 = new Image(Application.class.getResource("imagesLocations/1.jpeg").toExternalForm());
         Image image2 = new Image(Application.class.getResource("imagesLocations/2.jpg").toExternalForm());
         Image image3 = new Image(Application.class.getResource("imagesLocations/3.jpg").toExternalForm());
         Image image4 = new Image(Application.class.getResource("imagesLocations/5.png").toExternalForm());
         Image image5 = new Image(Application.class.getResource("imagesLocations/6.png").toExternalForm());
         Image image6 = new Image(Application.class.getResource("imagesLocations/7.png").toExternalForm());
         Image image7 = new Image(Application.class.getResource("imagesLocations/8.png").toExternalForm());
         Image image8 = new Image(Application.class.getResource("imagesLocations/9.png").toExternalForm());
         Image image9 = new Image(Application.class.getResource("imagesLocations/10.png").toExternalForm());
         Image image10 = new Image(Application.class.getResource("imagesLocations/11.png").toExternalForm());
         Image image12 = new Image(Application.class.getResource("imagesLocations/13.jpg").toExternalForm());
         cache.put(Application.class.getResource("imagesLocations/1.jpeg").toExternalForm(), image1);
         cache.put(Application.class.getResource("imagesLocations/2.jpg").toExternalForm(), image2);
         cache.put(Application.class.getResource("imagesLocations/3.jpg").toExternalForm(), image3);
         cache.put(Application.class.getResource("imagesLocations/5.png").toExternalForm(), image4);
         cache.put(Application.class.getResource("imagesLocations/6.png").toExternalForm(), image5);
         cache.put(Application.class.getResource("imagesLocations/7.png").toExternalForm(), image6);
         cache.put(Application.class.getResource("imagesLocations/8.png").toExternalForm(), image7);
         cache.put(Application.class.getResource("imagesLocations/9.png").toExternalForm(), image8);
         cache.put(Application.class.getResource("imagesLocations/10.png").toExternalForm(), image9);
         cache.put(Application.class.getResource("imagesLocations/11.png").toExternalForm(), image10);
         cache.put(Application.class.getResource("imagesLocations/13.jpg").toExternalForm(), image12);

     }

    public static Image getImage(String imageUrl) {
        if (cache.containsKey(imageUrl)) {
            return cache.get(imageUrl);
        } else {
            Image image = new Image(imageUrl);
            cache.put(imageUrl, image);
            return image;
        }
    }
}
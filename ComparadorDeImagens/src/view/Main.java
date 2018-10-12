package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.ImageComparator;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedImage img1 = ImageIO.read(new File("img1.png"));
		BufferedImage img2 = ImageIO.read(new File("img2.png"));
		ImageComparator.compImagens(img1, img2);
	}

}

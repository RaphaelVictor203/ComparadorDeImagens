package controller;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageComparator {
	
	private static Toolkit kit = Toolkit.getDefaultToolkit();
	
	//Método que compara duas imagens e destaca, em uma terceira imagem, as diferenças
	public static void compImagens(BufferedImage img1, BufferedImage img2) throws IOException {
		
		BufferedImage imgDiferencas = new BufferedImage(img1.getWidth(null), img1.getHeight(null), BufferedImage.TYPE_INT_RGB);
		
		int w = img1.getWidth();
		int h = img1.getHeight();
		
		int[] pixelsImg1 = img1.getRGB(0, 0, w, h, null, 0, img1.getWidth());
		int[] pixelsImg2 = img2.getRGB(0, 0, w, h, null, 0, w);
		int[] pixelsImgDif = preencheVet(pixelsImg1.length);
		
		boolean existeDif = false;
		for(int col=0; col<img1.getWidth(); col++) {
			for(int lin=0; lin<img1.getHeight(); lin++) {
				if(pixelsImg1[w * lin + col] != pixelsImg2[w * lin + col]) {
					if(existeDif != true) {existeDif = true;}
					pixelsImgDif[w * lin + col] = new Color(0, 0, 0).getRGB();
				}
			}
		}
		
		System.out.println((existeDif) ? "Existem diferenças entre as imagens." : "As imagens são iguais !!!");
		
		if(existeDif) {
			imgDiferencas.setRGB(0, 0, imgDiferencas.getWidth(), imgDiferencas.getHeight(), pixelsImgDif, 0, imgDiferencas.getWidth());
			ImageIO.write(imgDiferencas, "PNG", new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\DiferencasImagens.png"));
			System.out.println("Imagem com todas as diferenças entre as imagens criada no Desktop");
		}
		
	}
	
	private static int[] preencheVet(int tamanho) {
		int[] vet = new int[tamanho];
		for(int i=0; i<vet.length; i++) {
			vet[i] = -1;
		}
		return vet;
	}
	
	public static void screeshot() throws AWTException, IOException {
		Robot robo = new Robot();
		BufferedImage bi = robo.createScreenCapture(new Rectangle(kit.getScreenSize()));
		ImageIO.write(bi, "jpg", new File("C:/ImagemTeste.jpg"));
	}
}

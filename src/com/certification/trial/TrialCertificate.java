/**
 * 
 */
package com.certification.trial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Deepanshu Jain
 *
 */
public class TrialCertificate {

	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {
		Rectangle sheet_margin = new Rectangle(1280, 905);
		Document document = new Document(sheet_margin);
		PdfWriter write = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Deepanshu Jain\\Desktop\\Certificate Sample.pdf"));
		Image img = Image.getInstance("C:\\Users\\Deepanshu Jain\\Documents\\PP Webpages Trial\\Certificate Sample pre.jpg");
		//img.rotate();
		img.scaleAbsolute(1280, 905);
		img.setAbsolutePosition(0, 0);
		document.open();
		PdfContentByte canvas = write.getDirectContentUnder();
		BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
		canvas.saveState();
		canvas.addImage(img);
		canvas.beginText();
		canvas.moveText(425, 905-528);
				//580, 410);
		canvas.setFontAndSize(bf, 35);
		canvas.showText("Kartavya");
		canvas.endText();
		canvas.restoreState();
		document.close();		
	}
	
}

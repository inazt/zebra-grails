package zebra.v2

import com.google.zxing.BinaryBitmap;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.NotFoundException
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ResultParser;
import com.google.zxing.LuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

class UploadController {

    def index = {  }
	def upload = {
		def file = request.getFile('myFile')
		ParsedResult parsedResult = null
		Result result = null
		if(file && !file.empty){
			//file.transferTo( new File("ปลายทาง" )
			def image = ImageIO.read(file.getInputStream())	
			LuminanceSource source = new BufferedImageLuminanceSource(image);

			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
			try {
				result = new MultiFormatReader().decode(bitmap);
				parsedResult = ResultParser.parseResult(result);
			}
			 catch(NotFoundException ex) {
			   render ex.toString();	
			   return ;
			}
		}
		else {
			render 'Error' 
		} 

		[format:result.getBarcodeFormat(), 'type':parsedResult.getType(), 'filename':file.getOriginalFilename(), 'result':result.getText(), 'parsedResult':parsedResult.getDisplayResult()]
	}

}
/**
*
	interface MultipartFile {
	public byte[] getBytes();
	public String getContentType();
	public java.io.InputStream getInputStream();
	public String getName();
	public String getOriginalFilename();
	public long getSize();
	public boolean isEmpty();
	public void transferTo(java.io.File dest);
	}
*/

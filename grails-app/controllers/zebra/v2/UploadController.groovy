package zebra.v2

import com.google.zxing.DecodeHintType;
import com.google.zxing.MonochromeBitmapSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ResultParser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Hashtable;

class UploadController {

    def index = { render 'Hello, Grails' }
	def upload = {
		def file = request.getFile('myFile')
		if(file && !file.empty && file.size < 1000000){
			//file.transferTo( new File("ปลายทาง" )
			render 'Ok' 
			render '<br>'
			render file.getOriginalFilename() 
		}
		else {
			render 'Error' 
		} 
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

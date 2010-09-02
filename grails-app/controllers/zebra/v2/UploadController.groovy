package zebra.v2

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

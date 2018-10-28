import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.MulticastChannel;
import java.util.Hashtable;

public class Test1 {
    static class MatrixToImageWriter{
        private static final int Blank = 0xFF000000;
        private static final int White = 0xFFFFFFFF;
        private MatrixToImageWriter(){}

        public static BufferedImage toBufferedImage(BitMatrix matrix){
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
            for (int i = 0;i < width;i++){
                for(int j = 0;j < height;j++){
                    image.setRGB(i, j, matrix.get(i, j)?Blank:White);
                }
            }
            return image;
        }
        public static void writeToFile(BitMatrix matrix,String format,File file) throws IOException {
            BufferedImage image = toBufferedImage(matrix);
            if(!ImageIO.write(image,format,file)){
                throw new IOException("Could not write an image of format"+format+"to"+file);
            }
        }

        public static void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {
            BufferedImage image = toBufferedImage(matrix);
            if(!ImageIO.write(image,format,stream)){
                throw new IOException("Could not write an image of format"+format);
            }


        }
    }



    @Test
    public void demo(){
        String text = "请看一看我的眼睛！全是想你的目光  " +
                "\n"+"\n"+"顾盼两回首"+"\n"+"潇尽泪如雨"+"\n"+"雪上踏两霜"+"\n"+"吾愿步春暖"+"\n"+"想似雁归来"+"\n"+"尔吾共四季" +
                "\n"+"\n"+"就这样看着你看着你目不转睛"; // 二维码内容
        int width = 300; // 二维码图片宽度
        int height = 300; // 二维码图片高度
        String format = "png";// 二维码的图片格式
        Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");	// 内容所使用字符集编码
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        // 生成二维码
        File outputFile = new File("d:" + File.separator + "new.png");
        try {
            MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

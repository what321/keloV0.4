package edu.ciit.iot.util;

import java.io.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UtilFun {
  /**
   * Hex字符串转byte
   */
  public static byte hexToByte(String inHex) {
    return (byte) Integer.parseInt(inHex, 16);
  }

  /**
   * hex字符串转byte数组
   */
  public static byte[] hexToByteArray(String inHex) {
    int hexlen = inHex.length();
    byte[] result;
    if (hexlen % 2 == 1) {
      // 奇数
      hexlen++;
      result = new byte[(hexlen / 2)];
      inHex = "0" + inHex;
    } else {
      // 偶数
      result = new byte[(hexlen / 2)];
    }
    int j = 0;
    for (int i = 0; i < hexlen; i += 2) {
      result[j] = hexToByte(inHex.substring(i, i + 2));
      j++;
    }
    return result;
  }

  /**
   * 数组转换成十六进制字符串
   */
  public static final String bytesToHexString(byte[] bArray) {
    StringBuffer sb = new StringBuffer(bArray.length);
    String sTemp;
    for (int i = 0; i < bArray.length; i++) {
      sTemp = Integer.toHexString(0xFF & bArray[i]);
      if (sTemp.length() < 2)
	sb.append(0);
      sb.append(sTemp.toUpperCase());
    }
    return sb.toString();
  }
	
  /**
   * int到byte[] 由高位到低位
   * @param i �?要转换为byte数组的整行�?��??
   * @return byte数组
   */
  public static byte[] intToByteArrayBE(int i) {
    byte[] result = new byte[4];
    result[0] = (byte)((i >> 24) & 0xFF);
    result[1] = (byte)((i >> 16) & 0xFF);
    result[2] = (byte)((i >> 8) & 0xFF);
    result[3] = (byte)(i & 0xFF);
    return result;
  }
    
  public static byte[] intToByteArrayLE(int i) {
    byte[] result = new byte[4];
    result[3] = (byte)((i >> 24) & 0xFF);
    result[2] = (byte)((i >> 16) & 0xFF);
    result[1] = (byte)((i >> 8) & 0xFF);
    result[0] = (byte)(i & 0xFF);
    return result;
  }
 
  /**
   * byte[]转int
   * @param bytes �?要转换成int的数�?
   * @return int�?
   */
  public static int byteArrayToIntBE(byte[] bytes) {
    int i = 0;
    int value=0;
    int len = bytes.length;
    	
    byte[] tmpBytes = new byte[4];
        
    if (len > 4) len = 4;
    for (i = 0; i < 4; i++) {
      if (i < (4 - len)) {
	if ((bytes[0] & (byte)0x80) != 0) {
	  tmpBytes[i] = (byte)0xff;
	} else tmpBytes[i] = (byte)0x00;
      } else tmpBytes[i] = bytes[i];
    }
        
    for(i = 0; i < 4; i++) {
      int shift= (4-i) * 8;
      value +=(tmpBytes[i] & 0xFF) << shift;
    }
    return value;
  }
    
  public static int byteArrayToIntLE(byte[] bytes) {
    int i = 0;
    int value=0;
    int len = bytes.length;
    	
    byte[] tmpBytes = new byte[4];
        
    if (len > 4) len = 4;
    for (i = 0; i < 4; i++) {
      if (i < len) tmpBytes[i] = bytes[i];
      else {
	if ((bytes[len - 1] & (byte)0x80) != 0) {
	  tmpBytes[i] = (byte)0xff;
	} else tmpBytes[i] = (byte)0x00;
      }
    }
    	
    for(i = 0; i < 4; i++) {
      int shift= i * 8;
      value +=(tmpBytes[i] & 0xFF) << shift;
    }
    return value;
  }

  public static int getCrcInt(byte[] bytes) {
    // CRC寄存器全�?1
    int CRC = 0x0000ffff;
    // 多项式校验�??
    int POLYNOMIAL = 0x0000a001;
    int i, j;
    for (i = 0; i < bytes.length; i++) {
      CRC ^= ((int) bytes[i] & 0x000000ff);
      for (j = 0; j < 8; j++) {
	if ((CRC & 0x00000001) != 0) {
	  CRC >>= 1;
	  CRC ^= POLYNOMIAL;
	} else {
	  CRC >>= 1;
	}
      }
    }
    return CRC;
  }
    
  public static String getCrcStr(byte[] bytes) {
    // CRC寄存器全�?1
    int CRC = 0x0000ffff;
    // 多项式校验�??
    int POLYNOMIAL = 0x0000a001;
    int i, j;
    for (i = 0; i < bytes.length; i++) {
      CRC ^= ((int) bytes[i] & 0x000000ff);
      for (j = 0; j < 8; j++) {
	if ((CRC & 0x00000001) != 0) {
	  CRC >>= 1;
	  CRC ^= POLYNOMIAL;
	} else {
	  CRC >>= 1;
	}
      }
    }
    // 结果转换�?16进制
    String result = Integer.toHexString(CRC).toUpperCase();
    if (result.length() != 4) {
      StringBuffer sb = new StringBuffer("0000");
      result = sb.replace(4 - result.length(), 4, result).toString();
    }
    //高位在前地位在后
    //return result.substring(2, 4) + " " + result.substring(0, 2);
    // 交换高低位，低位在前高位在后
    return result.substring(2, 4) + " " + result.substring(0, 2);
  }


  // public static java.lang.Object ByteToObject(byte[] bytes) {  
  //   java.lang.Object obj;  
  //   try {  
  //     //bytearray to object  
  //     ByteArrayInputStream bi = new ByteArrayInputStream(bytes);  
  //     ObjectInputStream oi = new ObjectInputStream(bi);  
  
  //     obj = oi.readObject();  
  
  //     bi.close();  
  //     oi.close();  
  //   }  
  //   catch(Exception e) {  
  //     System.out.println("translation"+e.getMessage());  
  //     e.printStackTrace();  
  //   }  
  //   return obj;  
  // }  
 

  // public static byte[] ObjectToByte(java.lang.Object obj) {  
  //   byte[] bytes;  
  //   try  {  
  //     //object to bytearray  
  //     ByteArrayOutputStream bo = new ByteArrayOutputStream();  
  //     ObjectOutputStream oo = new ObjectOutputStream(bo);  
  //     oo.writeObject(obj);  
  
  //     bytes = bo.toByteArray();  
  
  //     bo.close();  
  //     oo.close();      
  //   }  
  //   catch(Exception e) {  
  //     System.out.println("translation"+e.getMessage());  
  //     e.printStackTrace();  
  //   }

  //   if (bytes != null)
  //     return(bytes);
  //   else
  //     return null;
  // }

    // public static byte[] objectToBytes(Object obj) throws IOException {
    //     try(
    //             ByteArrayOutputStream out = new ByteArrayOutputStream();
    //             ObjectOutputStream sOut = new ObjectOutputStream(out);
    //     ){
    //         sOut.writeObject(obj);
    //         sOut.flush();
    //         byte[] bytes = out.toByteArray();
    //         return bytes;
    //     }
    // }

    // /**
    //  * 字节数组转对�?
    //  */
    // public static Object bytesToObject(byte[] bytes) throws IOException, ClassNotFoundException {
    //     try(
    //             ByteArrayInputStream in = new ByteArrayInputStream(bytes);
    //             ObjectInputStream sIn = new ObjectInputStream(in);
    //     ){
    //         return sIn.readObject();
    //     }
    // }

     /**  
      * 对象转数�?  
      * @param obj  
      * @return  
      */  
     public static byte[] toByteArray (Object obj) {      
         byte[] bytes = null;      
         ByteArrayOutputStream bos = new ByteArrayOutputStream();      
         try {        
             ObjectOutputStream oos = new ObjectOutputStream(bos);         
             oos.writeObject(obj);        
             oos.flush();         
             bytes = bos.toByteArray ();      
             oos.close();         
             bos.close();        
         } catch (IOException ex) {        
             ex.printStackTrace();   
         }      
         return bytes;    
     }   
        
     /**  
      * 数组转对�?  
      * @param bytes  
      * @return  
      */  
     public static Object toObject (byte[] bytes) {      
         Object obj = null;      
         try {        
             ByteArrayInputStream bis = new ByteArrayInputStream (bytes);        
             ObjectInputStream ois = new ObjectInputStream (bis);        
             obj = ois.readObject();      
             ois.close();   
             bis.close();   
         } catch (IOException ex) {        
             ex.printStackTrace();   
         } catch (ClassNotFoundException ex) {        
             ex.printStackTrace();   
         }      
         return obj;    
     }
     
     public static String encryption(String str){
    		StringBuilder md5= new StringBuilder();
    		try {
    		    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
    		    messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
    		    byte[] bytes=messageDigest.digest();
    		    for(byte b:bytes){
    			md5.append(byteToHex(b));
    		    }
    		} catch (NoSuchAlgorithmException e) {
    		    e.printStackTrace();
    		}
    		return md5.toString();
    	    }

    public static String byteToHex(byte b){
    		String hex = Integer.toHexString(b & 0xFF);
    		if(hex.length() < 2){
    		    hex = "0" + hex;
    		}
    		return hex;
    	    }
  
}

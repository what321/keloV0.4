package edu.ciit.iot.util;

public class ByteUtils {
	/**
	 * Hex瀛楃涓茶浆byte
	 */
	public static byte hexToByte(String inHex) {
		return (byte) Integer.parseInt(inHex, 16);
	}

	/**
	 * hex瀛楃涓茶浆byte鏁扮粍
	 */
	public static byte[] hexToByteArray(String inHex) {
		int hexlen = inHex.length();
		byte[] result;
		if (hexlen % 2 == 1) {
			// 濂囨暟
			hexlen++;
			result = new byte[(hexlen / 2)];
			inHex = "0" + inHex;
		} else {
			// 鍋舵暟
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
	 * 鏁扮粍杞崲鎴愬崄鍏繘鍒跺瓧绗︿覆
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
     * int鍒癰yte[] 鐢遍珮浣嶅埌浣庝綅
     * @param i 闇�瑕佽浆鎹负byte鏁扮粍鐨勬暣琛屽�笺��
     * @return byte鏁扮粍
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
     * byte[]杞琲nt
     * @param bytes 闇�瑕佽浆鎹㈡垚int鐨勬暟缁�
     * @return int鍊�
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
        // CRC瀵勫瓨鍣ㄥ叏涓�1
        int CRC = 0x0000ffff;
        // 澶氶」寮忔牎楠屽��
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
        // CRC瀵勫瓨鍣ㄥ叏涓�1
        int CRC = 0x0000ffff;
        // 澶氶」寮忔牎楠屽��
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
        // 缁撴灉杞崲涓�16杩涘埗
        String result = Integer.toHexString(CRC).toUpperCase();
        if (result.length() != 4) {
            StringBuffer sb = new StringBuffer("0000");
            result = sb.replace(4 - result.length(), 4, result).toString();
        }
        //楂樹綅鍦ㄥ墠鍦颁綅鍦ㄥ悗
        //return result.substring(2, 4) + " " + result.substring(0, 2);
        // 浜ゆ崲楂樹綆浣嶏紝浣庝綅鍦ㄥ墠楂樹綅鍦ㄥ悗
        return result.substring(2, 4) + " " + result.substring(0, 2);
    }

}

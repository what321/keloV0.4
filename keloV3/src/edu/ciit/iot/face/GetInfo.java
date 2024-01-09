package edu.ciit.iot.face;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;

public class GetInfo {
	public static JSONObject search(AipFace client) {
		String filepath = "capture.png";
		 // 传入可选参数调用接口
	    HashMap<String, Object> options = new HashMap<>();
	    options.put("match_threshold", "70");
	    options.put("quality_control", "NORMAL");
	    options.put("face_sort_type", 1);
	    
	    String image = GetFileContentAsBase64.getFileContentAsBase64(filepath);
	    String imageType = "BASE64";
	    String groupIdList = "group1";
	    
	    // 人脸搜索
	    JSONObject res = client.search(image, imageType, groupIdList, options);
	    return res;

	}

}

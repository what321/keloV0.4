/**
  * Copyright 2023 json.cn 
  */
package edu.ciit.iot.face;
import java.util.List;

/**
 * Auto-generated: 2023-12-24 17:29:5
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Result {

    private String face_token;
    private List<User_list> user_list;
    public void setFace_token(String face_token) {
         this.face_token = face_token;
     }
     public String getFace_token() {
         return face_token;
     }

    public void setUser_list(List<User_list> user_list) {
         this.user_list = user_list;
     }
     public List<User_list> getUser_list() {
         return user_list;
     }

}
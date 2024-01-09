/**
  * Copyright 2023 json.cn 
  */
package edu.ciit.iot.speech;
import java.util.List;

/**
 * Auto-generated: 2023-11-07 10:30:47
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class JsonRootBean {

    private List<String> result;
    private String err_msg;
    private String sn;
    private String corpus_no;
    private int err_no;
    public void setResult(List<String> result) {
         this.result = result;
     }
     public List<String> getResult() {
         return result;
     }

    public void setErr_msg(String err_msg) {
         this.err_msg = err_msg;
     }
     public String getErr_msg() {
         return err_msg;
     }

    public void setSn(String sn) {
         this.sn = sn;
     }
     public String getSn() {
         return sn;
     }

    public void setCorpus_no(String corpus_no) {
         this.corpus_no = corpus_no;
     }
     public String getCorpus_no() {
         return corpus_no;
     }

    public void setErr_no(int err_no) {
         this.err_no = err_no;
     }
     public int getErr_no() {
         return err_no;
     }
	@Override
	public String toString() {
		return "JsonRootBean [result=" + result + ", err_msg=" + err_msg + ", sn=" + sn + ", corpus_no=" + corpus_no
				+ ", err_no=" + err_no + "]";
	}

}
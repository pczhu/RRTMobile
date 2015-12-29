package cn.mobile.renrentou.domain;

import java.io.Serializable;
import java.util.List;

public class AdvertiseResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	private String status;

	private List<AdvertisementInfo> data;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<AdvertisementInfo> getData() {
		return data;
	}

	public void setData(List<AdvertisementInfo> data) {
		this.data = data;
	}
	public static class AdvertisementInfo  implements Serializable {
		/**
		 * 广告ID
		 */
		private String id;
		/**
		 * 广告标题
		 */
		private String title;
		/**
		 * 广告提示语
		 */
		private String mark_words;
		/**
		 * 链接地址
		 */
		private String link;
		/**
		 * 图片路径
		 */
		private String img;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getMark_words() {
			return mark_words;
		}
		public void setMark_words(String mark_words) {
			this.mark_words = mark_words;
		}
		public String getLink() {
			return link;
		}
		public void setLink(String link) {
			this.link = link;
		}
		public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
		}

	}

}

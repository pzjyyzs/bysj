package com.yidu.lly.model;

public class User {
	  	private Integer uid;
		private String username;
	    private String password;
	    private String sex;
	    private String img;
	    private String userintroduce;
	    

	    public Integer getUid() {
			return uid;
		}

		public void setUid(Integer uid) {
			this.uid = uid;
		}
	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username ;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password ;
	    }

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
		}

		public String getUserintroduce() {
			return userintroduce;
		}

		public void setUserintroduce(String userintroduce) {
			this.userintroduce = userintroduce;
		}
	    

}

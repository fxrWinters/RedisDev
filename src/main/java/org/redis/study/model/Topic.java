package org.redis.study.model;

import java.util.Date;

public class Topic {
	private int tid;
	
	private String name;
	
	private int fid;
	
	private int pid;
	
	private Date createAt;
	
	private Date lastPostAt;
	
	private Date updateAt;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getLastPostAt() {
		return lastPostAt;
	}

	public void setLastPostAt(Date lastPostAt) {
		this.lastPostAt = lastPostAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public String toString() {
		return "Topic [tid=" + tid + ", name=" + name + ", fid=" + fid
				+ ", pid=" + pid + ", createAt=" + createAt + ", lastPostAt="
				+ lastPostAt + ", updateAt=" + updateAt + "]";
	}
}

package cn.wdn.model;



import org.hibernate.annotations.GenericGenerator;

public class Data {
	int id;
	int age;
	String content;
	String shortCon;
	String title;
	String attr;
	boolean buff;
	@Override
	public String toString() {
		return "Data [id=" + id + ", age=" + age + ", content=" + content + ", shortCon=" + shortCon + ", title="
				+ title + ", attr=" + attr + ", buff=" + buff + "]";
	}
	public Data(boolean buff) {
		super();
		this.buff = buff;
	}
	public Data(String attr) {
		super();
		this.attr = attr;
	}
	public Data(int age) {
		super();
		this.age = age;
	}
	public Data(int id, int age, String content, String shortCon, String title, String attr, boolean buff) {
		super();
		this.id = id;
		this.age = age;
		this.content = content;
		this.shortCon = shortCon;
		this.title = title;
		this.attr = attr;
		this.buff = buff;
	}
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getShortCon() {
		return shortCon;
	}
	public void setShortCon(String shortCon) {
		this.shortCon = shortCon;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAttr() {
		return attr;
	}
	public void setAttr(String attr) {
		this.attr = attr;
	}
	public boolean getBuff() {
		return buff;
	}
	public void setBuff(boolean buff) {
		this.buff = buff;
	}
	public Data(int age, String content, String shortCon, String title, String attr, boolean buff) {
		super();
		this.age = age;
		this.content = content;
		this.shortCon = shortCon;
		this.title = title;
		this.attr = attr;
		this.buff = buff;
	}
	
}

package example.jsp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean (name = "bean1")
@SessionScoped
public class SampleBean {
	private int luckyNumber = 20;

	public int getLuckyNumber() {
		return luckyNumber;
	}

	public void setLuckyNumber(int luckyNumber) {
		this.luckyNumber = luckyNumber;
	}
}

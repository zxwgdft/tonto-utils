package tonto.test.imes;

import java.util.List;


public class AnjiDDPullSheetRequest extends AnjiSheetRequest{
	
	private List<AnjiDDPullSheet> content;

	public List<AnjiDDPullSheet> getContent() {
		return content;
	}

	public void setContent(List<AnjiDDPullSheet> content) {
		this.content = content;
	}
	
}

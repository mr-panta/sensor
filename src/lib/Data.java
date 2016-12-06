package lib;

public class Data {
	private String option;
	private String data;
	
	public Data(String allData) throws DataFormatException {
		String[] rawData = allData.split(" ");
		
		if(rawData.length > 2 || rawData.length == 0) {
			throw new DataFormatException();
		}
		
		this.option = rawData[0];
		this.data = rawData[1];
	}

	public String getRawData() {
		return option + " " + data;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}

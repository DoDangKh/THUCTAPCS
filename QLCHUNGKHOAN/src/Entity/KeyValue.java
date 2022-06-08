package Entity;

import javax.swing.DefaultComboBoxModel;

public class KeyValue {
	private String Key;
	private String Value;
	
	public KeyValue(String Key, String Value) {
		super();
		this.Key = Key;
		this.Value = Value;
	}
	public KeyValue() {}
	public String getKey() {
		return Key;
	}
	public void setKey(String key) {
		Key = key;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	
	@Override
	public String toString() {
		return this.Key;
	}
}

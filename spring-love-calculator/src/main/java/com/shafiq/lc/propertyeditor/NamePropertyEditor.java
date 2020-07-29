package com.shafiq.lc.propertyeditor;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String name) throws IllegalArgumentException {
		
		String myConvertedStringValue = name.toUpperCase();
		setValue(myConvertedStringValue);
	}
}

package com.baxxy.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

public class FieldTextMayusEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(text.toUpperCase().trim());
	}

	
}

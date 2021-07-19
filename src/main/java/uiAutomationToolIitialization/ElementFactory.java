package uiAutomationToolIitialization;

public interface ElementFactory {
	
	public ActionElement  createButton(String selector);
    public TextElement  createTextElement(String selector);
	public SelectableElement  createRadioButton(String selector);
	void createButton();
	

}

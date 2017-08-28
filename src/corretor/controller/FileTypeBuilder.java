package corretor.controller;

public interface FileTypeBuilder {
	public abstract Title createTitle(String text);
	public abstract Abstract createAbstract(String text);
	public abstract Text createText();
}

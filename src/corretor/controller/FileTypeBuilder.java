package corretor.controller;

public interface FileTypeBuilder {
	public abstract Title createTitle(String text);
	public abstract Resumo createAbstract(String text);
	
}

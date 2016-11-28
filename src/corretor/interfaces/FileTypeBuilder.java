package corretor.interfaces;

import corretor.modelo.*;

public interface FileTypeBuilder {

	public abstract Title createTitle();
	public abstract Resumo createResumo();
	public abstract Section createSecion();
	public abstract Text createText();
}

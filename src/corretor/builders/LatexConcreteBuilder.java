package corretor.builders;

import corretor.interfaces.FileTypeBuilder;
import corretor.modelo.*;

public class LatexConcreteBuilder implements FileTypeBuilder{

	@Override
	public Title createTitle() {
		// TODO Auto-generated method stub
		return new Title();
	}

	@Override
	public Resumo createResumo() {
		// TODO Auto-generated method stub
		return new Resumo();
	}

	@Override
	public Section createSecion() {
		// TODO Auto-generated method stub
		return new Section();
	}

	@Override
	public Text createText() {
		// TODO Auto-generated method stub
		return new Text();
	}

}

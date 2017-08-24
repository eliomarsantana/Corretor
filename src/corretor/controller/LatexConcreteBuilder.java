package corretor.controller;

public class LatexConcreteBuilder implements FileTypeBuilder{

	@Override
	public Title createTitle(String text) {
		// TODO Auto-generated method stub
		return new Title();
	}

	@Override
	public Resumo createAbstract(String text) {
		// TODO Auto-generated method stub
		return new Resumo(text);
	}

}

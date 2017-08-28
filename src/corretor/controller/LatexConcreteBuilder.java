package corretor.controller;

public class LatexConcreteBuilder implements FileTypeBuilder{

	@Override
	public Title createTitle(String text) {
		// TODO Auto-generated method stub
		return new Title(text);
	}

	@Override
	public Abstract createAbstract(String text) {
		// TODO Auto-generated method stub
		return new Abstract(text);
	}

	@Override
	public Text createText() {
		// TODO Auto-generated method stub
		return new Text();
	}

}

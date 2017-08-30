package corretor.controller;

public class Text {
	private Title titulo;
	private Abstract resumo;
	private Section[] sections;
	
	public String mountText(){
		
		return titulo.getTitle()+"\n\n"+resumo.getResumo();
	}

	public Title getTitulo() {
		return titulo;
	}

	public void setTitulo(Title titulo) {
		this.titulo = titulo;
	}

	public Abstract getResumo() {
		return resumo;
	}

	public void setResumo(Abstract resumo) {
		this.resumo = resumo;
	}

	public Section[] getSections() {
		return sections;
	}

	public void setSections(Section[] sections) {
		this.sections = sections;
	}
	
	
}

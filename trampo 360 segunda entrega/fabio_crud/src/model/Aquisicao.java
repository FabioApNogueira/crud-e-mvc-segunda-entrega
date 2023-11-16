package model;

public class Aquisicao {

    //atributos
	private int id_Aquisicao;
	private String data_Aquisicao;
	private String nome;
	private String id_Evento;
	private String id_Aluno;
	
	//construtor
	public Aquisicao () {
	}

	public Aquisicao(int id_Aquisicao, String data_Aquisicao, String nome, String id_Evento, String id_Aluno) {
		this.id_Aquisicao = id_Aquisicao;
		this.data_Aquisicao = data_Aquisicao;
		this.nome = nome;
		this.id_Evento = id_Evento;
		this.id_Aluno = id_Aluno;
	}

	public  Aquisicao(String data_Aquisicao, String nome, String id_Evento, String id_Aluno) {
		this.data_Aquisicao = data_Aquisicao;
		this.nome = nome;
		this.id_Evento = id_Evento;
		this.id_Aluno = id_Aluno;
	}
	

	//getters e setters	
	public int getId() {
		return id_Aquisicao;
	}

	public void setId(int id_Aquisicao) {
		this.id_Aquisicao = id_Aquisicao;
	}
	
	public String getdata_Aquisicao() {
		return data_Aquisicao;
	}

	public void setdata_Aquisicao(String data_Aquisicao) {
		this.data_Aquisicao = data_Aquisicao;
	}
	
	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public String getid_Evento() {
		return id_Evento;
	}

	public void setid_Evento(String id_Evento) {
		this.id_Evento = id_Evento;
	}

	public String getid_Aluno() {
		return id_Aluno;
	}

	public void setid_Aluno(String id_Aluno) {
		this.id_Aluno = id_Aluno;
	}

	//toString
	
	@Override
	public String toString() {
		return "Aquisicao [id_Aquisicao=" + id_Aquisicao + ", data_Aquisicao=" + data_Aquisicao + ", nome=" + nome + ", id_Evento=" + id_Evento + ", id_Aluno=" + id_Aluno + "]";
	}

	public void mostrar() {
		// TODO Auto-generated method stub
		
	}
		
}

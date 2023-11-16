package model;

public class Aquisicao {


	

	

	private int id;
	private String data_Aquisicao;
	private String nome;
	private String id_Evento;
	private String id_Aluno;
	

	public Aquisicao() {
		super();
	}

	public Aquisicao(String data_Aquisicao, String nome, String id_Evento, String id_Aluno) {
		super();
		this.data_Aquisicao = data_Aquisicao;
		this.nome = nome;
		this.id_Evento = id_Evento;
		this.id_Aluno = id_Aluno;
		
	}

	public Aquisicao(String data_Aquisicao, String nome, String id_Evento, String id_Aluno, int id) {
		super();
		this.id = id;
		this.data_Aquisicao = data_Aquisicao;
		this.nome = nome;
		this.id_Evento = id_Evento;
		this.id_Aluno = id_Aluno;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	

	public void mostrar() {
		System.out.println("==========================================================");
		System.out.println("ID: "+this.id);
		System.out.println("data_Aquisicao: "+this.data_Aquisicao);
		System.out.println("nome: "+this.nome);
		System.out.println("id_Evento: "+this.id_Evento);
		System.out.println("id_Aluno: "+this.id_Aluno);
		System.out.println("==========================================================");
	}

	public void setdata_Aquisicao(int int1) {
		// TODO Auto-generated method stub
		
	}

	
}

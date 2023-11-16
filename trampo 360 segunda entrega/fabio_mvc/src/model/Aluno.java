package model;

public class Aluno {


	

	

	private int id;
	private String id_Aluno;
	private String CPF;
	private String email;
	private String nome;
	private String senha;

	public Aluno() {
		super();
	}

	public Aluno(String id_Aluno, String CPF, String email, String nome, String senha) {
		super();
		this.id_Aluno = id_Aluno;
		this.CPF = CPF;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}

	public Aluno(String id_Aluno, String CPF, String email, String nome, String senha, int id) {
		super();
		this.id = id;
		this.id_Aluno = id_Aluno;
		this.CPF = CPF;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}

	public Aluno(int id2, String id_Aluno2, String cPF2, String email2, String nome2, String senha2) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getid_Aluno() {
		return id_Aluno;
	}

	public void setid_Aluno(String id_Aluno) {
		this.id_Aluno = id_Aluno;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public String getsenha() {
		return senha;
	}

	public void setsenha(String senha) {
		this.senha = senha;
	}

	public void mostrar() {
		System.out.println("==========================================================");
		System.out.println("ID: "+this.id);
		System.out.println("id_Aluno: "+this.id_Aluno);
		System.out.println("CPF: "+this.CPF);
		System.out.println("email: "+this.email);
		System.out.println("nome: "+this.nome);
		System.out.println("senha: "+this.senha);
		System.out.println("==========================================================");
	}

	public void setid_Aluno(int int1) {
		// TODO Auto-generated method stub
		
	}
}

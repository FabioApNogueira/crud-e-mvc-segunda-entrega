package model;

public class Evento {


	

	private int id;
	private String nome;
	private String data_Evento;
	

	public Evento() {
		super();
	}

	public Evento(String nome, String data_Evento) {
		super();
		this.nome = nome;
		this.data_Evento = data_Evento;
		
	}

	public Evento(String nome, String data_Evento, int id) {
		super();
		this.id = id;
		this.nome = nome;
		this.data_Evento = data_Evento;
		
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public String getdata_Evento() {
		return data_Evento;
	}

	public void setdata_Evento(String data_Evento) {
		this.data_Evento = data_Evento;
	}

	

	public void mostrar() {
		System.out.println("==========================================================");
		System.out.println("ID: "+this.id);
		System.out.println("nome: "+this.nome);
		System.out.println("data_Evento: "+this.data_Evento);
		
		System.out.println("==========================================================");
	}

	
		
	}

	

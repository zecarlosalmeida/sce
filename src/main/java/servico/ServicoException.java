package servico;

public class ServicoException extends Exception{
	private static final long serialVersionUID = 1L;
	private Integer cod;

	public ServicoException(Integer cod, String msg) {
		super(msg);
		this.cod = cod;
	}
	
	
}

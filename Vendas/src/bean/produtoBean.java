package bean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateUtil;
import model.Produto;

@ManagedBean
@ViewScoped
public class produtoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private List <Produto> produtos = new ArrayList<>();
	private Produto produto = new Produto();
	

	
	public  void cadastrar() {
		         
	      Session session = HibernateUtil.getSession();
			Transaction trx = session.beginTransaction();
			
			session.merge(this.produto);
			
			trx.commit();
			session.close();
	         

		this.produto = new Produto();

		String msg = "Produto Cadastrado com sucesso!";
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage
				(FacesMessage.SEVERITY_INFO, msg, msg));
	}



	public Produto getProduto() {
		return produto;
	}



	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
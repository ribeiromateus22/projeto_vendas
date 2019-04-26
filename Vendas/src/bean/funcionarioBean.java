package bean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateUtil;
import model.Funcionario;

@ManagedBean
@ViewScoped
public class funcionarioBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private List <Funcionario> funcionarios = new ArrayList<>();
	private Funcionario funcionarioo = new Funcionario();
	private Funcionario funcionario_atualizar = new Funcionario();
	
	public Funcionario getFuncionario_atualizar() {
		return funcionario_atualizar;
	}

	public void setFuncionario_atualizar(Funcionario funcionario_atualizar) {
		this.funcionario_atualizar = funcionario_atualizar;
	}

	public Funcionario getFuncionarioo() {
		return funcionarioo;
	}

	public void setFuncionarioo(Funcionario funcionarioo) {
		this.funcionarioo = funcionarioo;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public  void cadastrar() {
		         
	      Session session = HibernateUtil.getSession();
			Transaction trx = session.beginTransaction();
			
			session.merge(this.funcionarioo);
			
			trx.commit();
			session.close();
	         

		this.funcionarioo = new Funcionario();

		String msg = "Cadastro efetuado com sucesso!";
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage
				(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	public List<Funcionario> listarFuncionarios(){

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
     List select = session.createQuery("from Funcionario").list();
        session.getTransaction().commit();
        return select;
            }
	
	
	public  String alterar() {
		Session session = HibernateUtil.getSession();
		Transaction trx = session.beginTransaction();
		
		session.merge(this.funcionarioo);
		
		trx.commit();
		session.close();
         
		Funcionario funcionarioo = new Funcionario();
        
		
		String msg = "Alterado Com Sucesso";
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage
				(FacesMessage.SEVERITY_INFO, msg, msg));
		
		return "listar_funcionarios";
	}
	public String alterpage() {
		String idd = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		int id = Integer.parseInt(idd);
		
		System.out.println(id);
		
		Session session = HibernateUtil.getSession();
        session.beginTransaction();
     Funcionario select = (Funcionario) session.createQuery("from Funcionario where id = :id").list();
        session.getTransaction().commit();
        

	      
		return "alterar_funcionario";
		
	}

	
	
	
	
	
}

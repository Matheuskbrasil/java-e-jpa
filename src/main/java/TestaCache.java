import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.matheus.JpaConfigurator;
import br.com.matheus.model.Produto;

public class TestaCache {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfigurator.class);
		
		EntityManagerFactory entityManagerFactory = ctx.getBean(EntityManagerFactory.class);
		
		EntityManager em = entityManagerFactory.createEntityManager(); 
		
		Produto produto = em.find(Produto.class, 1);
		
		System.out.println(produto.getNome());  

		em.close();
		
	}

}

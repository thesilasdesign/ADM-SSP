package br.com.tarefas.interceptor;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.tarefas.service.UsuarioService;

@WebFilter("/*")
public class PageFilter implements Filter {
	
	@Autowired
	UsuarioService dao; // usa apenas a interface!
	
	@SuppressWarnings("unused")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		
		ArrayList<String> Paginas = new ArrayList<String>();

		Paginas.add("Tarefas/Lista");
		Paginas.add("Tarefas/Pedido");

		long tempoInicial = System.currentTimeMillis();
		chain.doFilter(request, response);
		long tempoFinal = System.currentTimeMillis();

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = ((HttpServletRequest) request).getRequestURI();

		if (uri.contains("Lista")) {
			chain.doFilter(request, response);
		}
	}

	@SuppressWarnings("unused")
	public String PaginaAtual(ServletRequest request, ServletResponse response) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = ((HttpServletRequest) request).getRequestURI();

		System.out.println(uri);

		return uri;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
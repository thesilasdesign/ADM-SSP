package br.com.tarefas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {

		String uri = request.getRequestURI();
		if (uri.endsWith("addCadastro") || uri.endsWith("loginForm") || uri.endsWith("efetuaLogin")
				|| uri.contains("resources") || uri.contains("senhaTeste") || uri.contains("EnviaSenhaNova")
				|| uri.contains("MessageSenha") || uri.contains("cadastro") || uri.contains("Cadastrado")
				|| uri.contains("Diretorio")) {
			return true;
		}
		if (request.getSession().getAttribute("usuarioLogado") != null) {
			return true;

		}
		response.sendRedirect("loginForm");
		return false;
	}
}
package br.com.tarefas.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue
	private Long UsuarioId;
	private String Login;
	private String Senha;
	private String DataCadastro;
	private String Nome;
	private String Comum;
	private String Endereco;
	private String Bairro;
	private String Cidade;
	private String Telefone;
	private String Celular;
	private String Email;
	private String EstadoCivil;
	private String DataNascimento;
	private String Status;
	private String Perfil;
	private String Setor;
	public Long getUsuarioId() {
		return UsuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		UsuarioId = usuarioId;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public String getDataCadastro() {
		return DataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		DataCadastro = dataCadastro;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getComum() {
		return Comum;
	}
	public void setComum(String comum) {
		Comum = comum;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getCelular() {
		return Celular;
	}
	public void setCelular(String celular) {
		Celular = celular;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getEstadoCivil() {
		return EstadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		EstadoCivil = estadoCivil;
	}
	public String getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		DataNascimento = dataNascimento;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getPerfil() {
		return Perfil;
	}
	public void setPerfil(String perfil) {
		Perfil = perfil;
	}
	public String getSetor() {
		return Setor;
	}
	public void setSetor(String setor) {
		Setor = setor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Bairro == null) ? 0 : Bairro.hashCode());
		result = prime * result + ((Celular == null) ? 0 : Celular.hashCode());
		result = prime * result + ((Cidade == null) ? 0 : Cidade.hashCode());
		result = prime * result + ((Comum == null) ? 0 : Comum.hashCode());
		result = prime * result + ((DataCadastro == null) ? 0 : DataCadastro.hashCode());
		result = prime * result + ((DataNascimento == null) ? 0 : DataNascimento.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((Endereco == null) ? 0 : Endereco.hashCode());
		result = prime * result + ((EstadoCivil == null) ? 0 : EstadoCivil.hashCode());
		result = prime * result + ((Login == null) ? 0 : Login.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((Perfil == null) ? 0 : Perfil.hashCode());
		result = prime * result + ((Senha == null) ? 0 : Senha.hashCode());
		result = prime * result + ((Setor == null) ? 0 : Setor.hashCode());
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
		result = prime * result + ((Telefone == null) ? 0 : Telefone.hashCode());
		result = prime * result + ((UsuarioId == null) ? 0 : UsuarioId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (Bairro == null) {
			if (other.Bairro != null)
				return false;
		} else if (!Bairro.equals(other.Bairro))
			return false;
		if (Celular == null) {
			if (other.Celular != null)
				return false;
		} else if (!Celular.equals(other.Celular))
			return false;
		if (Cidade == null) {
			if (other.Cidade != null)
				return false;
		} else if (!Cidade.equals(other.Cidade))
			return false;
		if (Comum == null) {
			if (other.Comum != null)
				return false;
		} else if (!Comum.equals(other.Comum))
			return false;
		if (DataCadastro == null) {
			if (other.DataCadastro != null)
				return false;
		} else if (!DataCadastro.equals(other.DataCadastro))
			return false;
		if (DataNascimento == null) {
			if (other.DataNascimento != null)
				return false;
		} else if (!DataNascimento.equals(other.DataNascimento))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (Endereco == null) {
			if (other.Endereco != null)
				return false;
		} else if (!Endereco.equals(other.Endereco))
			return false;
		if (EstadoCivil == null) {
			if (other.EstadoCivil != null)
				return false;
		} else if (!EstadoCivil.equals(other.EstadoCivil))
			return false;
		if (Login == null) {
			if (other.Login != null)
				return false;
		} else if (!Login.equals(other.Login))
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (Perfil == null) {
			if (other.Perfil != null)
				return false;
		} else if (!Perfil.equals(other.Perfil))
			return false;
		if (Senha == null) {
			if (other.Senha != null)
				return false;
		} else if (!Senha.equals(other.Senha))
			return false;
		if (Setor == null) {
			if (other.Setor != null)
				return false;
		} else if (!Setor.equals(other.Setor))
			return false;
		if (Status == null) {
			if (other.Status != null)
				return false;
		} else if (!Status.equals(other.Status))
			return false;
		if (Telefone == null) {
			if (other.Telefone != null)
				return false;
		} else if (!Telefone.equals(other.Telefone))
			return false;
		if (UsuarioId == null) {
			if (other.UsuarioId != null)
				return false;
		} else if (!UsuarioId.equals(other.UsuarioId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [UsuarioId=" + UsuarioId + ", Login=" + Login + ", Senha=" + Senha + ", DataCadastro="
				+ DataCadastro + ", Nome=" + Nome + ", Comum=" + Comum + ", Endereco=" + Endereco + ", Bairro=" + Bairro
				+ ", Cidade=" + Cidade + ", Telefone=" + Telefone + ", Celular=" + Celular + ", Email=" + Email
				+ ", EstadoCivil=" + EstadoCivil + ", DataNascimento=" + DataNascimento + ", Status=" + Status
				+ ", Perfil=" + Perfil + ", Setor=" + Setor + "]";
	}

}
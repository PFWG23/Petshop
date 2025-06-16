# 🎓 Sistema Pet Shop - Trabalho Acadêmico

**Autores:** João Möller, Patrick Gomes e Renato Amaral  
**Disciplina:** Programação Orientada a Objetos  
**Data:** Junho de 2025

---

## 📋 Descrição

Este é um sistema completo para gerenciamento de Pet Shop desenvolvido como trabalho acadêmico. O sistema permite cadastrar clientes, pets e contratar diferentes tipos de serviços, demonstrando conceitos fundamentais de Programação Orientada a Objetos.

## 📁 Arquivos do Projeto

### 📋 Classes Principais (Modelo)
- `Cliente.java` - Representa os clientes do pet shop
- `Pet.java` - Representa os animais de estimação
- `Servico.java` - Classe abstrata para todos os serviços

### 🛁 Classes de Serviços (Herança)
- `BanhoETosa.java` - Serviço de higiene (R$ 50)
- `ConsultaVeterinaria.java` - Consultas médicas (R$ 100)
- `Hospedagem.java` - Cuidados temporários (R$ 80)
- `Adestramento.java` - Treinamento comportamental (R$ 120)

### 💻 Interfaces do Sistema
- `SistemaPetShop.java` - Versão console (original)
- `PetShopLauncher.java` - Menu para escolher interface
- `PetShopSwingGUISimples.java` - Interface gráfica

## 🚀 Como Executar

### Compilar:
```bash
javac *.java
```

### Executar o launcher:
```bash
java PetShopLauncher
```

### Ou executar diretamente:
```bash
# Console
java SistemaPetShop

# Interface gráfica
java PetShopSwingGUISimples
```

## 💡 Conceitos Aplicados

- ✅ **Programação Orientada a Objetos**
- ✅ **Herança** (Servico → BanhoETosa, etc.)
- ✅ **Encapsulamento** (atributos private + getters)
- ✅ **Polimorfismo** (diferentes tipos de serviço)
- ✅ **Coleções** (ArrayList para armazenar dados)
- ✅ **Interface Gráfica** (Java Swing)
- ✅ **Tratamento de Exceções** (try-catch)

## 📝 Funcionalidades

1. **Cadastro de Clientes** - Nome, telefone, email
2. **Cadastro de Pets** - Vinculados aos clientes
3. **Contratação de Serviços** - Com data e preço
4. **Relatórios** - Lista completa de dados
5. **Interface Gráfica** - Fácil de usar

## 🎯 Características do Código

Este código foi escrito pensando em **estudantes iniciantes**:

- **Comentários explicativos** em português
- **Nomes de variáveis claros** e descritivos
- **Estruturas básicas** (for, if, Scanner)
- **Organização simples** mas funcional
- **Sem padrões avançados** (lambdas, streams)

## 🔧 Melhorias Futuras

- [ ] Persistência em banco de dados
- [ ] Validação de CPF/CNPJ
- [ ] Histórico de serviços
- [ ] Fotos dos pets
- [ ] Sistema de login

---

*"Código feito com dedicação por estudantes que estão aprendendo! 🎓"*
